package com.luisfsolano.proxytest.beans;

import com.luisfsolano.proxytest.payloadsobjects.Request;
import com.luisfsolano.proxytest.utils.ControllerAbstractClass;

public class ClienteA extends ControllerAbstractClass{

	public String run(Request parameters) {
		return "Hola "+parameters.getBody().getCustomRequest1().getName()+" desde el bean con logica de cliente A";
	}

	public String prueba(Request parameters) {
		return null;
	}

}
