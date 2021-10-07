package za.ac.nwu.as.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.ACC_TRANSACTION;
import za.ac.nwu.as.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.as.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.as.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public  class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {
    private AccountTransactionTranslator translator;

    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator){
        this.translator = translator;
    }
    @Override
    public List<AccountTransactionDto> getAllAccountTransactions(){
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for(ACC_TRANSACTION accTransaction : translator.getAllAccountTransactions()){
            accountTransactionDtos.add(new AccountTransactionDto(accTransaction));
        }
        return accountTransactionDtos;
    }




    //moet verander
    @Override
    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
        ACC_TRANSACTION acc_transaction = translator.getAccountTransactionByPk(transactionId);
        return null != acc_transaction ? new AccountTransactionDto(acc_transaction) :null;
//    return null;
    }



}
