package za.ac.nwu.as.logic.flow.impl;

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

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {
    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    @Autowired
    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator, FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }


    //nuwe vid

    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        accountTransactionDto.setACC_TRANS_ID(null);

       ACC_TYPE acc_type = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeByMnemonic());
        ACC_TRANSACTION acc_transaction = accountTransactionDto.buildAccountTransaction(acc_type);

        ACC_TRANSACTION createdAcc_transaction = accountTransactionTranslator.save(acc_transaction);


        return new AccountTransactionDto(createdAcc_transaction);
    }

}
