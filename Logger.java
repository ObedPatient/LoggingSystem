package loggingsystem;
import java.util.*;



public class Logger implements Cloneable, java.io.Serializable {
    private volatile static Logger logger;
    private Logger() {
        // Private constructor to prevent instantiation
        if(logger != null) {
            throw new IllegalStateException("Logger instance already exists!");
        }
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Logger cannot be cloned");
    }

    protected Object readResolve() {
        return logger();
    }

    
}
