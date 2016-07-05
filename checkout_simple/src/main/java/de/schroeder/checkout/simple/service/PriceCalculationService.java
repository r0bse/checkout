package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.DiscountByAmountEntity;
import de.schroeder.checkout.simple.domain.SkuEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
public class PriceCalculationService {

    private final HashMap<SkuEntity, Map<Integer, DiscountByAmountEntity>> productMap;

    public PriceCalculationService(){

        SetupFactory factory = SetupFactory.getInstance();
        this.productMap = factory.getProductMap();
    }

    /**
     * calculate whole price for given product
     *
     * @param productName
     * @param amount
     * @return
     */
    public Double calculatePrice(char productName, Integer amount){

        Double discount = productMap.get(productName).get(amount).getDiscount();

        return amount * discount;
    }
}
