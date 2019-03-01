package com.rab.demo00001.process;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

public class ExecuteProcess implements Process {

	private static final Logger log = Logger.getLogger(ExecuteProcess.class);

	public void process() {
		log.info(MessageFormat.format("Start {0}", this.getClass()));

		String[] arrayCommands = { "com.rab.demo00001.process.CountryProcess",
				"com.rab.demo00001.process.MoneyProcess" };
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
