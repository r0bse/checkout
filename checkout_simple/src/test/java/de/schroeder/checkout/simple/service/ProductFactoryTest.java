package de.schroeder.checkout.simple.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
@RunWith( MockitoJUnitRunner.class )
public class ProductFactoryTest {

    private ProductFactory factory;

    @Before
    public void setup(){
        factory = ProductFactory.getInstance();
    }

    @Test
    public void testGetProductMap() throws Exception {

        factory.getProductMap().entrySet()
                .stream()
                .forEach( entry -> assertEquals( entry.getKey(), entry.getValue().getProductName() ) );
    }

    @Test
    public void testSingleton(){
        assertEquals( factory, ProductFactory.getInstance() );
    }
}