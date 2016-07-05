package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.DiscountByAmountEntity;
import de.schroeder.checkout.simple.domain.SkuEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by robert on 04.07.16.
 */
public class SetupFactory {

    private static SetupFactory instance;

    private final HashMap<SkuEntity, Map<Integer, DiscountByAmountEntity>> productMap;

    private SetupFactory() {
        this.productMap = new HashMap<>();
    }

    public static final SetupFactory getInstance() {

        if ( instance == null ) {
            instance = new SetupFactory();
            instance.setup();
        }
        return instance;
    }

    private void setup() {

        Map<Integer, DiscountByAmountEntity> aSet = new HashMap<>();
        Map<Integer, DiscountByAmountEntity> bSet = new HashMap<>();
        Map<Integer, DiscountByAmountEntity> cSet = new HashMap<>();
        Map<Integer, DiscountByAmountEntity> dSet = new HashMap<>();

        aSet.put( 1, new DiscountByAmountEntity( 1.0 ) );
        aSet.put( 3, new DiscountByAmountEntity( ( 100 * 100 / 3 ) / 40 ) );//product A has a discount
        bSet.put( 2, new DiscountByAmountEntity( ( 100 * 80 / 2 ) / 50 ) );//product B has a discount
        cSet.put( 1, new DiscountByAmountEntity( 1.0 ) );
        dSet.put( 1, new DiscountByAmountEntity( 1.0 ) );

        productMap.put( new SkuEntity( 'A' ), aSet );
        productMap.put( new SkuEntity( 'B' ), bSet );
        productMap.put( new SkuEntity( 'C' ), cSet );
        productMap.put( new SkuEntity( 'D' ), dSet );
    }

    public HashMap<SkuEntity, Map<Integer, DiscountByAmountEntity>> getProductMap() {
        return productMap;
    }
}
