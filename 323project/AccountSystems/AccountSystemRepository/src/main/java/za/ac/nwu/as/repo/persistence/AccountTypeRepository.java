package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.ACC_TYPE;

@Repository
public interface AccountTypeRepository extends JpaRepository<ACC_TYPE, Long> {
//    @Query(value = "SELECT " +
//            "       ACC_TYPE_ID," +
//            "       ACC_TYPE_NAME," +
//            "       CREATION_DATE," +
//            "       MNEMONIC," +
//            "      FROM " +
//            "       ACC_TYPE.DiscoveryRewardsCmpg323" +
//            "      WHERE MNEMONIC = :mnemonic: ", nativeQuery = true)
//    ACC_TYPE getAccountTypeByMnemonicNativeQuery(String mnemonic);
//
//    @Query(value = "SELECT " +
//            "       at" +
//            "      FROM " +
//            "           ACC_TYPE at" +
//            "       WHERE at.mnemonic = :mnemonic ")
//    ACC_TYPE getAccountTypeByMnemonic(String mnemonic);
//
//    @Query(value = "SELECT new za.ac.nwu.as.domain.dto.AccountTypeDto( " +
//            "       at.MNEMONIC," +
//            "       at.ACC_TYPE_NAME," +
//            "       at.CREATION_DATE," +
//            "    FROM," +
//            "       ACC_TYPE at" +
//            "    WHERE at.MNEMONIC = :mnemonic " )
//    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


}


