package decision.drools.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	public static Result genSuccessResult() {
		return new Result().setCode(ResultCode.SUCCESS).setCodeDesc(DEFAULT_SUCCESS_MESSAGE);
	}

	public static Result genSuccessResult(Object data) {
		return new Result().setCode(ResultCode.SUCCESS).setCodeDesc(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	public static Result genFailResult(String message) {
		return new Result().setCode(ResultCode.FAIL).setCodeDesc(message);
	}

	public static Result genFailResult(int code, String message) {
		return new Result().setCode(code).setCodeDesc(message);
	}
}
