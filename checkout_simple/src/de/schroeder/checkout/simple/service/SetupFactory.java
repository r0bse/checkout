package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.DiscountByAmountEntity;
import de.schroeder.checkout.simple.domain.SkuEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by robert on 04.07.16.
 */
public class SetupFactory {

    private static SetupFactory instance;
    private final HashMap<SkuEntity, Map<Integer, DiscountByAmountEntity>> productMap;

    private SetupFactory(){
        this.productMap = new HashMap<>();
    }

    private static final SetupFactory getInstance(){

        if(instance == null){
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

        aSet.add(new DiscountByAmountEntity(1, 1.0));
        aSet.add(new DiscountByAmountEntity(3, (100*100/3)/40));//product A in table has a special price
        bSet.add(new DiscountByAmountEntity(2, (100*80/2)/50));//product B in table has a special price
        cSet.add(new DiscountByAmountEntity(1, 1.0));
        dSet.add(new DiscountByAmountEntity(1, 1.0));

        productMap.put(new SkuEntity('A'), aSet);
        productMap.put(new SkuEntity('B'), bSet);
        productMap.put(new SkuEntity('C'), cSet);
        productMap.put(new SkuEntity('D'), dSet);
    }
}
