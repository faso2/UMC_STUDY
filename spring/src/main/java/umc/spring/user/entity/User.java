package umc.spring.user.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.embedded.Address;
import umc.spring.point.entity.Point;
import umc.spring.user.entity.enums.Gender;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String password;
    private String email;
    private String birthday;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Embedded
    private Address address;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "point_id")
    private Point point;

    @Builder
    public User(String name, String password, String email, String birthday, String phoneNumber, Gender gender, Address address, Point point) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.point = point;
    }

    public static User createNullUser() { return new User();}
}
