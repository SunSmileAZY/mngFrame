package com.anzy.frame.utils;

import com.anzy.frame.base.controller.AbstractController;

import java.lang.reflect.Method;

/**
 * 
 * @author anzy
 * @date 2017年11月30日
 */
public class ClassUtils extends AbstractController {

	public static Method getSetMethodByMethodName(Class<?> oClass, String methodName) {
		try {
			Method m = oClass.getMethod(methodName);
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
