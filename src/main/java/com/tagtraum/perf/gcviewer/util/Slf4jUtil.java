package com.tagtraum.perf.gcviewer.util;

import org.slf4j.Logger;
import org.slf4j.impl.JDK14LoggerAdapter;

import java.lang.reflect.Field;
import java.util.logging.Handler;

/**
 * @author <a href="mailto:art.dm.ser@gmail.com">Artem Dmitriev</a>
 *         8/1/16
 */
public class Slf4jUtil {
    private static final Field loggerField;

    static {
        try {
            loggerField = JDK14LoggerAdapter.class.getDeclaredField("logger");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        loggerField.setAccessible(true);
    }

    public static void removeHandler(Logger l, Handler handler) {
        if (l instanceof JDK14LoggerAdapter) {
            julLogger(l).removeHandler(handler);
        }
    }

    public static Handler[] getHandlers(Logger l) {
        if (l instanceof JDK14LoggerAdapter) {
            return julLogger(l).getHandlers();
        } else {
            return new Handler[0];
        }
    }

    public static void addHandler(Logger l, Handler handler) {
        if (l instanceof JDK14LoggerAdapter) {
            julLogger(l).addHandler(handler);
        }
    }

    private static java.util.logging.Logger julLogger(Logger l) {
        try {
            return (java.util.logging.Logger) loggerField.get(l);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
