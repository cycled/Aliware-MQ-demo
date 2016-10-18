package log4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jixiang on 15/8/13.
 */
public class ONSLog4jAppenderTest {
    private static final Logger log = LoggerFactory.getLogger("OnsLog");

    public static void main(String[] args) {
        log.warn("hello world");
    }
}