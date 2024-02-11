package org.study.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.board.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
