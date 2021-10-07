package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.persistence.ACC_TRANSACTION;

import java.util.List;

public interface AccountTransactionTranslator {
    ACC_TRANSACTION save(ACC_TRANSACTION acc_transaction);

    List<ACC_TRANSACTION> getAllAccountTransactions();

    ACC_TRANSACTION getAccountTransactionByPk(Long transactionId);
}
