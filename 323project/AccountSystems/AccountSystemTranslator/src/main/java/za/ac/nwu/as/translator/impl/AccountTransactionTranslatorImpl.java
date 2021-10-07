package za.ac.nwu.as.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.persistence.ACC_TRANSACTION;
import za.ac.nwu.as.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.as.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.repo = accountTransactionRepository;
    }
    @Override
    public ACC_TRANSACTION save(ACC_TRANSACTION accTransaction){
        return repo.save(accTransaction);
    }
    @Override
    public List<ACC_TRANSACTION> getAllAccountTransactions(){
        List<ACC_TRANSACTION> acc_transactions;

        acc_transactions = new ArrayList<>(repo.findAll());
        return acc_transactions;
    }

    @Override
    public ACC_TRANSACTION getAccountTransactionByPk(Long transactionId) {
        return repo.findById(transactionId).orElse(null);
    }


}
