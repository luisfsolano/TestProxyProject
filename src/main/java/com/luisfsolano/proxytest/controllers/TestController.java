package com.luisfsolano.proxytest.controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisfsolano.proxytest.payloadsobjects.Request;
import com.luisfsolano.proxytest.utils.Constant;

@RestController
@RequestMapping("/test")
public class TestController {

	@PostMapping("/")
	public String run(@RequestBody String params) {
		if (null == params)
			return "Parametros vacios";

		Request rq;
		try {
			ObjectMapper mapper = new ObjectMapper();
			rq = mapper.readValue(params, Request.class);
			String className = Constant.PATH + rq.getHeader().getCommerce();
			Class<?> cls = Class.forName(className);
			Object ii = cls.newInstance();
			Method method = null;
			method = ii.getClass().getMethod(rq.getHeader().getOperation(), rq.getClass());
			return (String) method.invoke(ii, rq);

		} catch (IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return "Error al invocar el metodo enviado";
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return "No se encontró el metodo enviado";
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return "No se pudo instanciar la clase enviada en el payload";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "No se encontró la clase enviada en el payload";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getOriginalMessage();
		}

	}

}
