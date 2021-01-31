package com.luisfsolano.proxytest.beans;

import com.luisfsolano.proxytest.payloadsobjects.Request;
import com.luisfsolano.proxytest.utils.ControllerAbstractClass;

public class ClienteB extends ControllerAbstractClass{

	public String run(Request parameters) {
		return "Hola desde el bean con logica de ClienteB";
	}
	
	public String prueba(Request parameters) {
		return "Hola desde el bean con logica de ClienteB, metodo prueba";
	}

}
