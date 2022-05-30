package me.majbar.digitalbankingrestapi.repositories;

import me.majbar.digitalbankingrestapi.entities.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, String> {

}
