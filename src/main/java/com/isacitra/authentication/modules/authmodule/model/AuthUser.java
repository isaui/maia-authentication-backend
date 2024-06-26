package com.isacitra.authentication.modules.authmodule.model;

import com.isacitra.authentication.modules.authmodule.model.dto.UserInformationDTO;
import com.isacitra.authentication.modules.authmodule.model.dto.UserRegisterInfoDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String name;
    @Column(unique = true)
    private String email;
    private  String password;


    public AuthUser() {

    }

    public static class AuthUserBuilder {
        private Long userId;
        private String name;
        private String selfDescription;
        private String email;
        private String password;
        private String profilePhoto;

        public AuthUserBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }



        public AuthUserBuilder name(String name) {
            this.name = name;
            return this;
        }



        public AuthUserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthUserBuilder password(String password) {
            this.password = password;
            return this;
        }



        public AuthUser build() {
            AuthUser authUser = new AuthUser();
            authUser.setUserId(this.userId);
            authUser.setName(this.name);
            authUser.setEmail(this.email);
            authUser.setPassword(this.password);
            return authUser;
        }
    }




    public static AuthUser fromUserRegisterInfo(UserRegisterInfoDTO info){
        return new AuthUserBuilder()
                .email(info.getEmail())
                .password(info.getPassword())
                .name(info.getName())
                .build();
    }

    public UserInformationDTO toUserInformationDTO() {
        return UserInformationDTO.builder()
                .userId(this.userId)
                .email(this.email)
                .name(this.name)
                .build();
    }
}
