package ind.vijay.demo.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BaseResponse {

	Integer statuz = 200;

	Map<String, Object> result = new HashMap<String, Object>();

	public static BaseResponse Instance() {
		return new BaseResponse();
	}
	public BaseResponse() {
		
	}
	public BaseResponse Response() {
		return this;
	}
	/**
	 * todo:		根据处理情况修改，比如数据不正确等
	 * author:		Vijay Wong
	 * datetime:	2017年10月31日 上午12:29:46
	 */
	public void CHANGE_STATUZ(Integer statuz) {
		this.statuz = statuz;
	}
	/**
	 * todo:		添加数据结果
	 * author:		Vijay Wong
	 * datetime:	2017年11月11日 上午6:37:48
	 */
	public void addResult(String key, Object value) {
		this.result.put(key, value);
	}
	
}
