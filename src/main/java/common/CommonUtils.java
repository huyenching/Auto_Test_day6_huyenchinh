package common;

public class CommonUtils {
    public static void SleepInSeconds(long seconds) {
        try {
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException ignored) {

        }
    }
}
