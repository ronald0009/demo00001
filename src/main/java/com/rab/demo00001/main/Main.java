package com.rab.demo00001.main;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

import com.rab.demo00001.process.ExecuteProcess;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		log.info(MessageFormat.format("Start {0}", Main.class));
		ExecuteProcess process = new ExecuteProcess();
		process.process();
		log.info(MessageFormat.format("End {0}", Main.class));
	}
}
