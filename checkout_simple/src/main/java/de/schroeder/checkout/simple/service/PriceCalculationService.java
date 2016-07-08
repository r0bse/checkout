package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.SkuEntity;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
public class PriceCalculationService{

    private static PriceCalculationService instance;

    private PriceCalculationService() {}

    /**
     * get the instance of this class as singleton
     *
     * @return
     */
    public static final PriceCalculationService getInstance() {

        if ( instance == null ) {
            instance = new PriceCalculationService();
        }
        return instance;
    }

    /**
     * calculate price for given products
     *
     * @param sku
     * @param amount
     * @return
     */
    public Integer calculatePrice( SkuEntity sku,
                                  Integer amount ) {

        Double discount = 1.0;
        Double result = 0.0;

        //calculate the amount of products which are not credited by amount
        Integer overspill = amount % sku.getDiscountEntity().getAmount();

        //apply discount if amount matches to a multiplikation of amount and discount
        if ( overspill == 0) {
            discount = sku.getDiscountEntity().getDiscount();
            result = amount * sku.getDefaultCentPrice() * discount;
        }
        //all other cases where discountamount does not match the productamount
        else{
            //calculate the amount where discount is applyable
            Integer discountAmount = amount - overspill;
            //calculate discount price
            result = discountAmount * sku.getDefaultCentPrice() * sku.getDiscountEntity().getDiscount();
            //add the remaining price
            result += overspill * sku.getDefaultCentPrice();
        }

        return (int) Math.round(result);
    }

    /**
     * copied from testClass
     *
     * @param goods
     * @return
     */
    public int calculatePrice(String goods) {

        CheckOut co = new CheckOut();

        for(int i=0; i<goods.length(); i++) {

            co.scan(String.valueOf(goods.charAt(i)));
        }

        return co.total();
    }
}
