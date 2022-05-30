package me.majbar.digitalbankingrestapi.repositories;

import me.majbar.digitalbankingrestapi.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {

    List<AccountOperation> findByBankAccountId( String accountId);


    Page<AccountOperation> findByBankAccountId(String accountId, Pageable pageable);

}
