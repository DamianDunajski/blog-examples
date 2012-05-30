package pl.geeksoft.examples;

import org.databene.contiperf.PerfTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackPerformanceTest extends AbstractLoggingPerformanceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(LOGGER_NAME);

	@Override
	protected String getLogFileName() {
		return "logback.log";
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testLogbackPerformane_Message() {
		LOGGER.info(MESSAGE);
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testLogbackPerformane_Exception() {
		LOGGER.error(MESSAGE, EXCEPTION);
	}
}
