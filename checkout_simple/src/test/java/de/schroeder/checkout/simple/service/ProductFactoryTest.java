package de.schroeder.checkout.simple.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

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

    /**
     * test that the key of an entry maps to the name of the sku.productname
     * @throws Exception
     */
    @Test
    public void testProductMap() throws Exception {

        factory.getProductMap().entrySet()
                .stream()
                .forEach( entry -> assertEquals( entry.getKey(), entry.getValue().getProductName() ) );
    }

    /**
     * test singleton implementation
     */
    @Test
    public void testSingleton(){
        assertEquals( factory, ProductFactory.getInstance() );
    }
}