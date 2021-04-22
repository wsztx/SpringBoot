package com.universe.springboot.common.enums;

/**
 * 操作结果枚举类
 * @author zhoutianxiang
 *
 */
public enum ResultCodeEnum {
	
	SUCCESS("0000"),
	FAIL("9999");
	
	ResultCodeEnum(String code) {
		this.code = code;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static ResultCodeEnum getResultEnum(String code) {
		for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
			if (resultCodeEnum.getCode().equals(code)) {
				return resultCodeEnum;
			}
		}
		return null;
	}

}
