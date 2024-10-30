package com.dosol.braincare.repository;

import com.dosol.braincare.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
