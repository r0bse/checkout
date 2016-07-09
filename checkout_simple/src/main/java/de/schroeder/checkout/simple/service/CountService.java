package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.SkuEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
public class CountService {

    private static CountService instance;

    private CountService(){}

    /**
     * get the instance of this class as singleton
     *
     * @return
     */
    public static final CountService getInstance() {

        if ( instance == null ) {
            instance = new CountService();
        }
        return instance;
    }

    /**
     * count amount of given Characters in String
     *
     * @param productList
     * @param productToCount
     *
     * @return a long since stream api count() returns one
     */
    public Integer countAmount( List<SkuEntity> productList,
                             Character productToCount ) {

        Long result = productList.stream()
                .filter( sku -> productToCount.equals( sku.getProductName() ) )
                .count();

        //since we cast to integer we should check that the max value
        if(result > Integer.MAX_VALUE){
            throw new NumberFormatException("The calculated amount of products is bigger than Integer.Max_Value !");
        }
        return result.intValue();
    }

    /**
     * count amount of different characters in an array
     *
     * @param productArray
     * @return
     */
    public Integer countDifferentProducts( Character[] productArray ) {

        Set<Character> set = Arrays.asList( productArray )
                .stream()
                .collect( Collectors.toSet() );

        return set.size();
    }
}
