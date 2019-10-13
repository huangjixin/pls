package com.zhiyesoft.cloud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;


public class Generator {

	public static void main(String[] args) throws IOException, XMLParserException, SQLException, InterruptedException, InvalidConfigurationException {
		/*List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		InputStream inputStream = Generator.class.getResourceAsStream("/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(inputStream);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);*/
		
		URL url = Generator.class.getClassLoader()
				.getResource("generatorConfig.xml");
				String config = url.getFile();
				String[] arg = { "-configfile", config, "-overwrite" };
				ShellRunner.main(arg);
	}

}