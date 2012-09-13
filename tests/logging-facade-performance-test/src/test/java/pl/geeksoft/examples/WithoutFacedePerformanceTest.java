package pl.geeksoft.examples;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.junit.Test;

public class WithoutFacedePerformanceTest extends AbstractLoggingPerformanceTest {

	private static final Logger LOGGER = Logger.getLogger(LOGGER_NAME);

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
