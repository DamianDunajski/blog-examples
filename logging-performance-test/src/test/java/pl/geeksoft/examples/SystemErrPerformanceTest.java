package pl.geeksoft.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.databene.contiperf.PerfTest;
import org.junit.Before;
import org.junit.Test;

public class SystemErrPerformanceTest extends AbstractLoggingPerformanceTest {

	@Override
	protected String getLogFileName() {
		return "system-err.log";
	}

	@Before
	public void setUp() throws FileNotFoundException {
		File logFile = new File("logs/" + getLogFileName());
		PrintStream printStream = new PrintStream(logFile);
		System.setErr(printStream);
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testSystemErrPerformane_Message() {
		System.err.println(MESSAGE);
	}

	@Test
	@PerfTest(threads = THREADS, duration = DURATION, warmUp = WARM_UP)
	public void testSystemErrPerformane_Exception() {
		EXCEPTION.printStackTrace();
	}

}
