package pl.geeksoft.examples;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.junit.Test;

public class Log4jPerformanceTest extends AbstractLoggingPerformanceTest {

	private static final Logger LOGGER = Logger.getLogger(LOGGER_NAME);

	@Override
	protected String getLogFileName() {
		return "log4j.log";
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testLog4jPerformane_Message() {
		LOGGER.info(MESSAGE);
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testLog4jPerformane_Exception() {
		LOGGER.error(MESSAGE, EXCEPTION);
	}

}
