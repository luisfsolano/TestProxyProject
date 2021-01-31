package com.luisfsolano.proxytest.beans;

import com.luisfsolano.proxytest.payloadsobjects.Request;
import com.luisfsolano.proxytest.utils.ControllerAbstractClass;

public class ClienteC extends ControllerAbstractClass{

	public String run(Request parameters) {
		return "Hola desde el clienteC class";
	}

	public String prueba(Request parameters) {
		return null;
	}

}
