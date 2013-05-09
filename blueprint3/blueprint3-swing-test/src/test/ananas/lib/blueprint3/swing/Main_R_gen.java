package test.ananas.lib.blueprint3.swing;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import ananas.lib.blueprint3.tools.R_file_generator;
import ananas.lib.util.CommandLinePropertiesUtil;

public class Main_R_gen {

	public static void main(String[] arg) {
		Properties prop = CommandLinePropertiesUtil.argumentsToProperties(arg);
		(new Main_R_gen()).run(prop);
	}

	private void run(Properties prop) {

		File base = this.getBaseDir();

		prop.setProperty("-base-dir", base.getAbsolutePath());
		prop.setProperty("-res-dir", "src");
		prop.setProperty("-gen-dir", "gen");
		prop.setProperty("-R", "true");
		prop.setProperty("-accept-file", ".xml");
		prop.setProperty("-accept-xml-file", ".xml");
		prop.setProperty("-accept-attr", "id");
		// prop.setProperty("", "");

		String[] arg = CommandLinePropertiesUtil.propertiesToArguments(prop);
		R_file_generator.main(arg);

	}

	private File getBaseDir() {
		try {
			URL url = this.getClass().getProtectionDomain().getCodeSource()
					.getLocation();
			File file = new File(url.toURI());
			return file.getParentFile();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
