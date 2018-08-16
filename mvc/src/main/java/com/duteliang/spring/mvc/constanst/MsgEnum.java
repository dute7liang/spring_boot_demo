package com.duteliang.spring.mvc.constanst;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-16 16:43
 */
public enum MsgEnum {

	ADD_SUCCESS("新增成功！",1),
	ADD_FAULT("新增失败！",1),
	UPDATE_SUCCESS("编辑成功！",1),
	UPDATE_FAULT("编辑失败！",1),
	DELETE_SUCCESS("删除成功！",1),
	DELETE_FAULT("删除失败！",1),


	;
	private String msg;

	private Integer code;

	MsgEnum(String msg,Integer code){
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
