package kz.iitu.libmanagement.controller;

import io.swagger.annotations.Api;
import kz.iitu.libmanagement.entity.LibraryMember;
import kz.iitu.libmanagement.repository.LibraryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value="Library Member Controller")
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private LibraryMemberRepository memberRepository;

    @GetMapping("")
    public List<LibraryMember> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public LibraryMember getMemberById(@PathVariable("id") Long id) {
        return memberRepository.findById(id).get();
    }


    @GetMapping("/find/")
    public List<LibraryMember> getMemberByName(@RequestParam String name) {
        return memberRepository.findAllByName(name);
    }

    @PostMapping("")
    public LibraryMember createMember(@RequestBody LibraryMember member) {
        return memberRepository.saveAndFlush(member);
    }

    @DeleteMapping("/{id}")
    public LibraryMember deleteMember(@PathVariable("id") Long id) {
        memberRepository.deleteById(id);
        return memberRepository.saveAndFlush(memberRepository.findById(id).get());
    }

    @PutMapping("/{id}")
    public LibraryMember updateMember(@PathVariable Long id, @RequestBody LibraryMember member) {
        member.setId(id);
        return memberRepository.saveAndFlush(member);
    }


}
