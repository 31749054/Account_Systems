package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.ACC_TYPE;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
    ACC_TYPE getAccountTypeDbEntityByMnemonic(String mnemonic);


}
