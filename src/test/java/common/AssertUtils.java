package common;
import org.testng.Assert;

public class AssertUtils {

    // 1. Assert equals
    public static void assertEquals(String actualResult, String valueContains, String... message){
        if (message.length > 0)
            Assert.assertEquals(actualResult, valueContains, message[0]);
        else
            Assert.assertEquals(actualResult, valueContains);
    }

    // 2 . Assert not equals

    public static void assertNotEquals(String actualResult, String unexpectedResult, String... message) {
        if (message.length > 0)
            Assert.assertNotEquals(actualResult, unexpectedResult, message[0]);
        else
            Assert.assertNotEquals(actualResult, unexpectedResult);
    }
    // 3.Assert ignore case ( không phân biệt chữ hoa hay thường)

    public static void assertEqualsIgnoreCase(String actualResult, String expectedResult, String... message) {
        boolean isEqual = actualResult != null && expectedResult != null && actualResult.equalsIgnoreCase(expectedResult);
        if (message.length > 0)
            Assert.assertTrue(isEqual, message[0]);
        else
            Assert.assertTrue(isEqual,
                    String.format("Expected '%s' equalsIgnoreCase '%s'", actualResult, expectedResult));
    }
    // 4. Assert true
    public static void assertTrue(boolean condition, String... message) {
        if (message.length > 0)
            Assert.assertTrue(condition, message[0]);
        else
            Assert.assertTrue(condition);
    }
    // 5.Assert false
    public static void assertFalse(boolean condition, String... message) {
        if (message.length > 0)
            Assert.assertFalse(condition, message[0]);
        else
            Assert.assertFalse(condition);
    }
    // 6. Assert contains
    public static void assertContains(String value, String valueContains, String... message){
        Assert.assertTrue(value.contains(valueContains));

    }

}
