package com.cbnu.teammatching.member.domain;

import com.cbnu.teammatching.application.domain.Application;
import com.cbnu.teammatching.member.dto.MemberSignUpRequest;
import com.cbnu.teammatching.message.domain.Message;
import com.cbnu.teammatching.post.domain.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private LocalDateTime birthdate;

    @NotNull
    @Column(unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Interest> interests = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Career> careers = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Certification> certifications = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "recipient")
    private List<Message> receivedMessages = new ArrayList<>();

    @OneToMany(mappedBy = "applicant")
    private List<Application> applications = new ArrayList<>();

    protected Member() {
    }

    public static Member createMember(MemberSignUpRequest registrationDto) {
        Member member = new Member();
        member.username = registrationDto.getUsername();
        member.password = registrationDto.getPassword();
        member.nickname = registrationDto.getNickname();
        member.name = registrationDto.getName();
        member.email = registrationDto.getEmail();
        member.birthdate = registrationDto.getBirthdate();
        member.phoneNumber = registrationDto.getPhoneNumber();
        return member;
    }



}