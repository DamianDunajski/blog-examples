package pl.geeksoft.examples;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.databene.contiperf.PerfTest;
import org.junit.Test;

/*
* To get valid results it's neccessary to use valid logger config, so run test with parameter:
* -Djava.util.logging.config.file=src/main/resources/jdk-logger.properties
* */
public class JdkLoggerPerformanceTest extends AbstractLoggingPerformanceTest {

	private static final Logger LOGGER = Logger.getLogger(LOGGER_NAME);

	@Override
	protected String getLogFileName() {
		return "jdk-logger.log";
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testJdkLoggerPerformane_Message() {
		LOGGER.log(Level.INFO, MESSAGE);
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testJdkLoggerPerformane_Exception() {
		LOGGER.log(Level.SEVERE, MESSAGE, EXCEPTION);
	}

}
