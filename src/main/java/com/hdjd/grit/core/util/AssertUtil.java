package com.hdjd.grit.core.util;
import com.hdjd.grit.core.constant.ApiConstant;
import com.hdjd.grit.core.exception.ParameterException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yuan
 *
 */
public class AssertUtil {


    public static void isNotEmpty(String str, String... message) {
        if (StringUtils.isBlank(str)) {
            execute(message);
        }
    }

    public static void isNotNull(Object obj, String... message) {
        if (obj == null) {
            execute(message);
        }
    }
    public static void isTrue(boolean isTrue, String... message) {
        if (isTrue) {
            execute(message);
        }
    }

    private static void execute(String... message) {
        String msg = ApiConstant.ERROR_MESSAGE;
        if (message != null && message.length > 0) {
            msg = message[0];
        }
        throw new ParameterException(msg);
    }
}
