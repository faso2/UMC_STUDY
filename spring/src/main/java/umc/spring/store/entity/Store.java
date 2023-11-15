package umc.spring.store.entity;

import lombok.*;
import umc.spring.category.entity.Category;
import umc.spring.common.entity.BaseEntity;
import umc.spring.embedded.Address;
import umc.spring.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Store extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;
    private String storeName;
    private String storeCode;
    private String openTime;
    private String closeTime;
    private Integer storeRating;
    @Embedded
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    private Store(String storeName, String  storeCode, String openTime, String closeTime, Integer storeRating, Address address, User user, Category category) {
        this.storeName = storeName;
        this.storeCode = storeCode;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.storeRating = storeRating;
        this.address = address;
        this.user = user;
        this.category = category;
    }
}
