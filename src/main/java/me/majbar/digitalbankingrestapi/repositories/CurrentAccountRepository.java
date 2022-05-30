package me.majbar.digitalbankingrestapi.repositories;

import me.majbar.digitalbankingrestapi.entities.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, String> {
}
