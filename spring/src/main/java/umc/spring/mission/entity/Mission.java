package umc.spring.mission.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.mission.entity.enums.Status;
import umc.spring.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Mission extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;
    private String storeName;
    private String storeCode;
    private String price;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Mission(String storeName, String storeCode, String price, Status status, User user) {
        this.storeName = storeName;
        this.storeCode = storeCode;
        this.price = price;
        this.status = status;
        this.user = user;
    }

    public void changeStatus(Status status) { this.status = status; }
}
