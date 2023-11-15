package umc.spring.point.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Point extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;
    private Integer point;

    @Builder
    public Point(Integer point) {
        this.point = point;
    }

    public void changePoint(Integer point) { this.point = point;}
}
