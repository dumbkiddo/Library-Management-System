package kz.iitu.libmanagement.repository;

import kz.iitu.libmanagement.entity.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Long> {
}
