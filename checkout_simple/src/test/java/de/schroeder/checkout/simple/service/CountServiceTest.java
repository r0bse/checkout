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
public class CountServiceTest {

    private CountService countService;

    @Before
    public void setup() {
        this.countService = new CountService();
    }

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

        Long resultA = countService.countAmount( "ABBA", 'A' );
        assertEquals( (Long) 2L, resultA );

        Long resultB = countService.countAmount( "ABBA", 'B' );
        assertEquals( (Long) 2L, resultB );

        Long resultC = countService.countAmount( "ABBA", 'C' );
        assertEquals( (Long) 0L, resultC );
    }
}