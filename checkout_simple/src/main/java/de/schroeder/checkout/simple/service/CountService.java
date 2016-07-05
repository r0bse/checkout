package de.schroeder.checkout.simple.service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
public class CountService {

    /**
     * count amount of given Characters in String
     *
     * @param productNames
     * @param productToCount
     * @return
     */
    public Long countAmount( String productNames,
                             Character productToCount ) {

        IntStream charIntStream = productNames.chars(); //normally i would expect a Stream<Character>, but oracle seems to knew it better
        Long result = charIntStream.mapToObj( integer -> ( char ) integer ) //map char integer representation to actual chars
                                    .filter( character -> character.equals( productToCount ) )
                                    .count();

        //same result but less readable/understandable
        //Long result = productNames.chars().filter( num -> num == Character.getNumericValue( productToCount ) ).count();

        return result;
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
