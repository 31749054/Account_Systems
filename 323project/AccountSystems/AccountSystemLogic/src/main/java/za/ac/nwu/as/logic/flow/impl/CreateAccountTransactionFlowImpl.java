package za.ac.nwu.as.logic.flow.impl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.ACC_TRANSACTION;
import za.ac.nwu.as.domain.persistence.ACC_TYPE;
import za.ac.nwu.as.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.as.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.as.translator.AccountTransactionTranslator;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
//import java.util.logging.Logger;

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger FILE = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);
    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    @Autowired
    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator, FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }


    //nuwe vid

    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        FILE.info("The input object was{} ",accountTransactionDto);
        accountTransactionDto.setACC_TRANS_ID(null);

       ACC_TYPE acc_type = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeByMnemonic());
       FILE.info("Got accounttype for {} and the accounttypeId for {} ",accountTransactionDto.getAccountTypeByMnemonic(),acc_type.getACC_TYPE_ID());
        ACC_TRANSACTION acc_transaction = accountTransactionDto.buildAccountTransaction(acc_type);

        ACC_TRANSACTION createdAcc_transaction = accountTransactionTranslator.save(acc_transaction);
        AccountTransactionDto results = new AccountTransactionDto(createdAcc_transaction);

        FILE.info("The return object is {} ",results);
        return results;
    }

}
