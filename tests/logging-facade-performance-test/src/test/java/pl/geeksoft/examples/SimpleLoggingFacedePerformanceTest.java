package pl.geeksoft.examples;

import org.databene.contiperf.PerfTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLoggingFacedePerformanceTest extends AbstractLoggingPerformanceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(LOGGER_NAME);

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testPerformane_Message() {
		LOGGER.info(MESSAGE);
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testPerformane_Exception() {
		LOGGER.error(MESSAGE, EXCEPTION);
	}

}
