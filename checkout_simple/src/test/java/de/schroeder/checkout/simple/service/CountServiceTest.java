package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.DiscountEntity;
import de.schroeder.checkout.simple.domain.SkuEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
@RunWith( MockitoJUnitRunner.class )
public class CountServiceTest {

    private CountService countService = CountService.getInstance();;

    @Test
    public void testCount_1() throws Exception {
        Integer result = countService.countDifferentProducts( new Character[]{ 'A', 'A', 'A' } );
        assertEquals( ( Integer ) 1, result );
    }

    @Test
    public void testCount_2() throws Exception {
        Integer result = countService.countDifferentProducts( new Character[]{ 'A', 'B', 'A' } );
        assertEquals( ( Integer ) 2, result );
    }

    @Test
    public void testCount_3() throws Exception {
        Integer result = countService.countDifferentProducts( new Character[]{} );
        assertEquals( ( Integer ) 0, result );
    }

    @Test
    public void testCountDifferentProducts() throws Exception {

        SkuEntity skuA1 = new SkuEntity( 'A', 20L, new DiscountEntity( 0.20, 2 ) );
        SkuEntity skuA2 = new SkuEntity( 'A', 20L, new DiscountEntity( 0.20, 2 ) );
        SkuEntity skuB1 = new SkuEntity( 'B', 20L, new DiscountEntity( 0.20, 2 ) );
        SkuEntity skuB2 = new SkuEntity( 'B', 20L, new DiscountEntity( 0.20, 2 ) );

        List<SkuEntity> skuList = Arrays.asList( skuA1, skuA2, skuB1, skuB2);

        Integer resultA = countService.countAmount( skuList, 'A' );
        assertEquals( (Integer) 2, resultA );

        Integer resultB = countService.countAmount( skuList, 'B' );
        assertEquals( (Integer) 2, resultB );

        Integer resultC = countService.countAmount( skuList, 'C' );
        assertEquals( (Integer) 0, resultC );
    }

    /**
     * test singleton implementation
     */
    @Test
    public void testSingleton(){
        assertEquals( countService, CountService.getInstance() );
    }
}