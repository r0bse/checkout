package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.SkuEntity;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
public class PriceCalculationService{

    private static PriceCalculationService instance;

    private PriceCalculationService() {

        ProductFactory factory = ProductFactory.getInstance();
    }

    /**
     * calculate price for given products
     * when amount equals or is bigger than the defined treshold, apply the discount
     *
     * @param sku
     * @param amount
     * @return
     */
    public Double calculatePrice( SkuEntity sku,
                                  Integer amount ) {

        Double discount = 1.0;

        if ( amount >= sku.getDiscountEntity().getAmount() ) {
            discount = sku.getDiscountEntity().getDiscount();
        }

        return amount * sku.getDefaultCentPrice() * discount;
    }


    public static final PriceCalculationService getInstance() {

        if ( instance == null ) {
            instance = new PriceCalculationService();
        }
        return instance;
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
