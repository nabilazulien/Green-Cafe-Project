package minimart.basya.model.constant;

import lombok.Getter;

@Getter
public enum ItemCategory {
    A_LA_CARTE("A La Carte"),
    APPERTIZERS("Appertizers"),
    SIDES("Sides"),
    EXTRAS("Extras"),
    BEVERAGES("Beverages");

    ItemCategory(String name) {
        this.name = name;
    }

    public String name;
}
