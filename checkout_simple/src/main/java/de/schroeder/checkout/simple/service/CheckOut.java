package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.SkuEntity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
public class CheckOut {

    private final List<SkuEntity> productList;
    private final Map<Character, SkuEntity> productmap;
    private final ProductFactory productFactory = ProductFactory.getInstance();
    private final PriceCalculationService calculationService = PriceCalculationService.getInstance();
    private final CountService countService = CountService.getInstance();

    public CheckOut() {

        productList = new ArrayList<>();
        productmap = productFactory.getProductMap();
    }

    /**
     * scan given product and add it to checkout
     *
     * @param productName
     */
    public void scan( String productName ) {

        if ( productName.length() > 1 ) {
            throw new IllegalArgumentException( "Productname is only allowed to have a length of 1 !" );
        }
        SkuEntity sku = productmap.get( productName.charAt( 0 ) );
        productList.add( sku );
    }

    /**
     * calculate the total price sum of all products in checkout
     *
     * @return
     */
    public int total() {

        Set<SkuEntity> set = productList.stream()
                                        .collect( Collectors.toSet() );

        int result = set.stream()
                .map( sku -> {
                    Integer amount = countService.countAmount( productList, sku.getProductName() );
                    return calculationService.calculatePrice( sku, amount );
                } )
                .mapToInt( i -> i.intValue() )
                .sum();

        return result;
    }

    /**
     * reset the productList
     */
    public void reset(){
        this.productList.clear();
    }
}
