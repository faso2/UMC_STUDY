package umc.spring.category.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.store.entity.Store;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Category extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Store> stores = new ArrayList<>();

    @Builder
    private Category(String name, List<Store> stores) {
        this.name = name;
        this.stores = stores;
    }
}
