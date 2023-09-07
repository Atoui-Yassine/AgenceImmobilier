package com.example.AgenceImmobilier.models.user;


import com.example.AgenceImmobilier.models.BaseEntity;
import com.example.AgenceImmobilier.models.logement.Logement;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserModel extends BaseEntity {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String providerId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String phone;
    private String gender;
    private String photoUrl;
    private String coverUrl;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    /*@OneToMany(mappedBy = "host" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Logement> myLogements;*/
    public UserModel(String firstname, String lastname, String username, String email, String password) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email=email;
        this.password = password;

    }

    public UserModel(String email, String password) {

        this.email = email;
        this.password = password;
    }
}

