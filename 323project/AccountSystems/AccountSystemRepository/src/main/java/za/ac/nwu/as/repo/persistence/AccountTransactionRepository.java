package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.ACC_TRANSACTION;

@Repository
public interface AccountTransactionRepository extends JpaRepository <ACC_TRANSACTION, Long> {
}
