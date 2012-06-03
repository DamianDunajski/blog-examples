package pl.geeksoft.examples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.databene.contiperf.PerfTest;
import org.junit.Test;

public class CommonsLoggingPerformanceTest extends AbstractLoggingPerformanceTest {

	private static final Log LOGGER = LogFactory.getLog(LOGGER_NAME);

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
