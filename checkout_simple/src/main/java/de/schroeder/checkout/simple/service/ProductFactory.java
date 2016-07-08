package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.DiscountEntity;
import de.schroeder.checkout.simple.domain.SkuEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by robert on 04.07.16.
 */
public class ProductFactory {

    private static ProductFactory instance;

    private final HashMap<Character, SkuEntity> productMap;

    private ProductFactory() {
        this.productMap = new HashMap<>();
    }


    /**
     * get the instance of this class as singleton
     *
     * @return
     */
    public static final ProductFactory getInstance() {

        if ( instance == null ) {
            instance = new ProductFactory();
            instance.setup();
        }
        return instance;
    }

    /**
     * setup the map with all available SkuEntities
     */
    private void setup() {

        SkuEntity skuA = new SkuEntity( 'A', 40L, new DiscountEntity( calculateDiscount( 100.0, 120.0 ), 3 ) );
        SkuEntity skuB = new SkuEntity( 'B', 50L, new DiscountEntity( calculateDiscount( 80.0, 100.0 ), 2 ) );
        SkuEntity skuC = new SkuEntity( 'C', 25L, new DiscountEntity( 100.0, 1 ) );
        SkuEntity skuD = new SkuEntity( 'D', 20L, new DiscountEntity( 100.0, 1 ) );

        productMap.put( skuA.getProductName(), skuA );
        productMap.put( skuB.getProductName(), skuB );
        productMap.put( skuC.getProductName(), skuC );
        productMap.put( skuD.getProductName(), skuD );
    }

    public Map<Character, SkuEntity> getProductMap() {
        return productMap;
    }

    /**
     * calculate the discount
     *
     * @param prozentwert
     * @param grundwert
     * @return
     */
    private Double calculateDiscount( Double prozentwert,
                                      Double grundwert ) {

        Double result = prozentwert * 100.0 / grundwert;
        return result;
    }

    /**
     * add a product to productList, if it exists, replace it
     *
     * @param productName    the name of the product
     * @param defaultPrice   the default price of the product
     * @param discountAmount the amount which triggers the discountprice
     * @param discountPrice  the price whihc applies on discount
     */
    public SkuEntity addOrChangeProduct( Character productName,
                                         Long defaultPrice,
                                         Integer discountAmount,
                                         Double discountPrice ) {

        Long grundwert = ( discountAmount * defaultPrice );
        DiscountEntity discount = new DiscountEntity( calculateDiscount( discountPrice, grundwert.doubleValue() ), discountAmount );
        SkuEntity sku = new SkuEntity( productName, defaultPrice, discount );
        productMap.put( productName,  sku);

        return sku;
    }

    ;
}
