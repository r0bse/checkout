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

        if(discount > 100 || discount < 0){
            throw new IllegalArgumentException( "discount can't be bigger than 100% or negative" );
        }

        this.discount = discount;
        this.amount = amount;
    }

    /**
     * get discount as value between 0 and 1
     * @return
     */
    public Double getDiscount() {
        return discount/100.0;
    }

    public Integer getAmount() {
        return amount;
    }
}
