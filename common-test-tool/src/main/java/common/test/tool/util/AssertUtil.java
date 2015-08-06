package common.test.tool.util;

public class AssertUtil {

    public static <T> boolean isLambda(T e) {
        return e.getClass().getSimpleName().contains("$$Lambda");
    }
}
