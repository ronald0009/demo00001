package com.rab.demo00001.process;

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
