package de.schroeder.checkout.simple.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
@RunWith( MockitoJUnitRunner.class )
public class SkuEntityTest {

    @Test
    public void testEquals() throws Exception {

        DiscountEntity discountA = new DiscountEntity( 0.8, 5 );
        DiscountEntity discountB = new DiscountEntity( 0.8, 5 );

        SkuEntity skuA1 = new SkuEntity( 'A', 20L, discountA );
        SkuEntity skuA2 = new SkuEntity( 'A', 20L, discountA );
        SkuEntity skuB = new SkuEntity( 'B', 30L, discountB );

        assertEquals( skuA1, skuA2 );
        assertEquals( skuB, skuB );
        assertNotEquals( skuA1, skuB );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroPrice(){

        DiscountEntity discount = new DiscountEntity( 0.8, 5 );
        new SkuEntity( 'A', -0L, discount );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice(){

        DiscountEntity discount = new DiscountEntity( 0.8, 5 );
        new SkuEntity( 'A', -1L, discount );
    }
}