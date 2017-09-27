package server;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class StringEqualityTest {

    @Test
    public void testA() {
        String str1 = "I";
        String str2 = "I";

        Assert.assertTrue(str1 == str2);
    }

    @Test
    public void testB() {

        String str1 = "I";
        String str2 = "I";

        Assert.assertTrue(str1.equals(str2));
    }
}
