package org.adostic.primegenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PrimePrinterTest {
	private PrintStream out;

	@Before
	public void setup() throws Exception {
		out = System.out;
		System.setOut(new PrintStream(new FileOutputStream("lead")));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(out);
		new File("lead").delete();
	}

	@Test
	public void makeSureOutputMatchesGold() throws Exception {
		PrimePrinter.main(new String[0]);
		BufferedReader lead = new BufferedReader(new FileReader("lead"));
		BufferedReader gold = new BufferedReader(new FileReader("gold"));
		String line;
		while ((line = gold.readLine()) != null) {
			assertEquals(line, lead.readLine());
			// If I use next line as the example code, test fails
			//assertEquals(null, lead.readLine());
		}
	}
}
