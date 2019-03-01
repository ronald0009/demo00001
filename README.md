# demo00001

/replica/pom.xml

<groupId>com.rab</groupId>
<artifactId>replica</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>replica</name>

<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.17</version>
</dependency>

/replica/src/main/java/log4j.properties

# Root logger option
log4j.rootLogger=INFO,WARN,ERROR,DEBUG, stdout, file

# Redirect log messages to console
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

# Redirect log messages to a log file, support file rolling.
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=D:\\log\\replica.log
log4j.appender.file.MaxFileSize=5MB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

log4j.category.org.hibernate=info
log4j.category.pe.com.bancomercio=debug

/replica/src/main/java/com/rab/replica/main/Main.java

package com.rab.replica.main;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

import com.rab.replica.main.process.ExecuteProcess;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		log.info(MessageFormat.format("Start {0}", Main.class));
		ExecuteProcess process = new ExecuteProcess();
		process.process();
		log.info(MessageFormat.format("End {0}", Main.class));
	}

}

/replica/src/main/java/com/rab/replica/main/process/Process.java

package com.rab.replica.main.process;

public interface Process {

	public void process();
	
}

/replica/src/main/java/com/rab/replica/main/process/ExecuteProcess.java

package com.rab.replica.main.process;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

public class ExecuteProcess implements Process {

	private static final Logger log = Logger.getLogger(ExecuteProcess.class);

	public void process() {
		log.info(MessageFormat.format("Start {0}", this.getClass()));

		String[] arrayCommands = { "com.rab.replica.main.process.CountryProcess",
				"com.rab.replica.main.process.MoneyProcess" };
		String command = null;
		for (int i = 0; i < arrayCommands.length; i++) {
			command = arrayCommands[i];
			processEntity(command);
		}

		log.info(MessageFormat.format("End {0}", this.getClass()));
	}

	private void processEntity(String command) {
		try {
			Process process = (Process) Class.forName(command).newInstance();
			process.process();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

/replica/src/main/java/com/rab/replica/main/process/CountryProcess.java

package com.rab.replica.main.process;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

public class CountryProcess implements Process {

	private static final Logger log = Logger.getLogger(CountryProcess.class);

	@Override
	public void process() {
		log.info(MessageFormat.format("Start {0}", this.getClass()));
		log.info(MessageFormat.format("End {0}", this.getClass()));
	}

}
