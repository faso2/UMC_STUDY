package umc.spring.missionstore.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.mission.entity.Mission;
import umc.spring.missionstore.entity.enums.ReviewStatus;
import umc.spring.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MissionStore extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "missionStore_id")
    private Long id;
    private String storeName;
    private String storeCode;
    private String price;
    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Builder
    public MissionStore(String storeName, String storeCode, String price, ReviewStatus reviewStatus, User user, Mission mission) {
        this.storeName = storeName;
        this.storeCode = storeCode;
        this.price = price;
        this.reviewStatus = reviewStatus;
        this.user = user;
        this.mission = mission;
    }
}
