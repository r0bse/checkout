package de.schroeder.checkout.simple.domain;

import java.util.Objects;

/**
 * Created by robert on 04.07.16.
 */
public class DiscountEntity {

    private final Double discount;
    private final Integer amount;

    public DiscountEntity( Double discount, Integer amount ) {

        Objects.requireNonNull(discount);
        Objects.requireNonNull(amount);

        if(discount > 1.0 || discount < 0){
            throw new IllegalArgumentException( "discount can't be bigger than 100% or negative" );
        }

        this.discount = discount;
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public Integer getAmount() {
        return amount;
    }
}
