package pl.geeksoft.examples;


import java.io.File;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Rule;

public class AbstractLoggingPerformanceTest {

	static final int THREADS  = 10;
	static final int DURATION = 30000;
	static final int WARM_UP  = 10000;

	static final String LOGGER_NAME   = "LoggingPerformanceLogger";

	static final String    MESSAGE   = "Some message";
	static final Exception EXCEPTION = new ApplicationRuntimeException();

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	@After
	public void cleanUp() {
		new File("logs/performance.log").delete();
	}

	public static class ApplicationRuntimeException extends RuntimeException {

		public ApplicationRuntimeException() {
			super("Unexpected exception occured", new NullPointerException("Value is NULL"));
		}
	}

}
