package de.schroeder.checkout.simple.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

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
}