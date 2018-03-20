package decision.drools.core;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result {
	private int code;
	private String codeDesc;
	private Object data;

	public Result setCode(ResultCode resultCode) {
		this.code = resultCode.code;
		return this;
	}

	public int getCode() {
		return code;
	}

	public Result setCode(int code) {
		this.code = code;
		return this;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public Result setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
		return this;
	}

	public Object getData() {
		return data;
	}

	public Result setData(Object data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
