package minimart.basya.model.constant;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("male", "M"),
    FEMALE("female", "F");

    public String nama;
    public String code;

    Gender(String nama, String code) {
        this.nama = nama;
        this.code = code;
    }
}
