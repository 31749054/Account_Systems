package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto);
}
