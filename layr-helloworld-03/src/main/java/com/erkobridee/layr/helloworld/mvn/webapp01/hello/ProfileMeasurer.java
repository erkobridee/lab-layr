package com.erkobridee.layr.helloworld.mvn.webapp01.hello;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class ProfileMeasurer {

	public long measurer() {
		return new Date().getTime() % 2;
	}
	
}
