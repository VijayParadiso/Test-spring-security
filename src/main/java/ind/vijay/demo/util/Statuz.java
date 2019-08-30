package ind.vijay.demo.util;

/**
 * todo   	描述接口调用状态的相应码
 * author 	Vijay Wong
 * datetime 2017年10月31日 上午12:19:42
 */
public interface Statuz {
	
	Integer DATA_ERROR_405 = 405;
	/**
	 * 根据具体业务扩展确认
	 */
	Integer DATA_ERROR_404 = 404;
	/**
	 * 根据具体业务扩展确认
	 */
	Integer DATA_ERROR_403 = 403;
	/**
	 * 根据具体业务扩展确认
	 */
	Integer DATA_ERROR_402 = 402;
	/**
	 * 数据要求不准确
	 */
	Integer DATA_ERROR_401 = 401;
	/**
	 * 系统异常
	 */
	Integer SYS_ERROR = 500;
	
	Integer STATUS_0 = 0;
	Integer STATUS_1 = 1;
	Integer STATUS_2 = 2;
	Integer STATUS_3 = 3;
	Integer STATUS_4 = 4;
	Integer STATUS_5 = 5;
	Integer STATUS_6 = 6;
	Integer STATUS_7 = 7;
	Integer STATUS_8 = 8;
	Integer STATUS_9 = 9;
	
	Integer STATUS_P1 = -1;
	Integer SUCCESS = 200;
	
}
