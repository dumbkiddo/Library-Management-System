package kz.iitu.libmanagement.repository;

import kz.iitu.libmanagement.entity.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Long> {
    List<LibraryMember> findAllByName(String name);

}
