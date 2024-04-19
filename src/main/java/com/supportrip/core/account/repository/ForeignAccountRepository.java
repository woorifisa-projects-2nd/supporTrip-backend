package com.supportrip.core.account.repository;

import com.supportrip.core.account.domain.ForeignAccount;
import com.supportrip.core.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForeignAccountRepository extends JpaRepository<ForeignAccount, Long> {
    Optional<ForeignAccount> findByUser(User user);
}