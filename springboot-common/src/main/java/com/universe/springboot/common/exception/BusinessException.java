package com.universe.springboot.common.exception;

import com.universe.springboot.common.enums.ResultCodeEnum;

/**
 * 自定义基础异常
 */
public class BusinessException extends RuntimeException {

	private final String code;

	public String getCode() {
		return code;
	}

	public BusinessException(ResultCodeEnum resultCodeEnum) {
		this.code = resultCodeEnum.getCode();
	}

	public BusinessException(String code) {
		this.code = code;
	}

	public static void throwMessage(String code) {
		throw new BusinessException(code);
	}

	public static void throwMessage(ResultCodeEnum resultCodeEnum) {
		throw new BusinessException(resultCodeEnum.getCode());
	}
	
}
