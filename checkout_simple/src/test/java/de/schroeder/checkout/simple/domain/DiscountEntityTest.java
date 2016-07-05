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
public class DiscountEntityTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFaultInstantiation1(){
        new DiscountEntity( 1.0001, 1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFaultInstantiation2(){
        new DiscountEntity( -0.0001, 1 );
    }

}