package com.codizer.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.codizer.service.Ejercicio5Service;

@Service("ejercicio5Service")
public class Ejercicio5ServiceImpl implements Ejercicio5Service {

	private static final Log LOG = LogFactory.getLog(Ejercicio5Service.class);
	
	@Override
	public void showLogMessage() {
		LOG.info("MESSAGE LOG");
		
	}

}
