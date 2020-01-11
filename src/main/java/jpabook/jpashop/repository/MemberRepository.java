package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    //findby 이후 name으로되어있으면 select m from Member m where m.name =? 으로 짜버림
    List<Member> findByName(String name);
}
