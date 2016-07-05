package de.schroeder.checkout.simple.domain;

/**
 * Created by robert on 04.07.16.
 */
public class DiscountByAmountEntity {

    private final Integer amount;
    private final Double discount;

    public DiscountByAmountEntity(Integer amount, double discount) {
        this.amount = amount;
        this.discount = discount;
    }
}
