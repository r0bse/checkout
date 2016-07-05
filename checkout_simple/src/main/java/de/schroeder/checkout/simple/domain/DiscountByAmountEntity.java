package de.schroeder.checkout.simple.domain;

/**
 * Created by robert on 04.07.16.
 */
public class DiscountByAmountEntity {

    private final Double discount;

    public DiscountByAmountEntity(double discount) {
        this.discount = discount;
    }

    public Double getDiscount() {
        return discount;
    }
}
