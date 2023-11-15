package umc.spring.embedded;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;

    protected Address() {
    }

    @Builder
    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
