package it.sfb;


import org.junit.Assert;
import org.junit.Test;


public class AppTest {

    @Test
    public void testHello() throws Exception {
        App.main(new String[]{});
        Assert.assertTrue(true);
    }

}
