package za.ac.nwu.as.domain.dto;

import static org.junit.jupiter.api.Assertions.*;

class AccountTypeDtoTest {

    @org.junit.jupiter.api.Test
   public void getMNEMONIC() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getMNEMONIC());
    }
}