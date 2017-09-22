package cdc.armada.noah.common;

/**
 * @author herui.li
 *
 */
public class CommonConst {
	// 系统共通
	public static final String APP_VERSION = "1.0";

	public static final String PAGE_SIZE = "com.armada.themis.common.Page.PageSize";
	public static final String REST_SERVICE_URI = "com.armada.themis.common.rest.service.url";
	public static final String REST_DETAILDESIGNGENRESTSERVICE_URI = "com.armada.themis.common.rest.detailDesignGenRestService.url";
	public static final String REST_LOGIN_SERVICE_URI = "com.armada.themis.common.rest.loginservice.url";
	public static final String REST_SQL_GENERATE_SERVICE_URI = "com.armada.themis.common.rest.sqlgenerateservice.url";
	public static final String REST_TESTRUN_SERVICE_URI = "com.armada.themis.common.rest.testRunservice.url";

	public static final String RESPONSE_FIELD_STATUS = "status";
	public static final String RESPONSE_FIELD_RESULT = "result";
	public static final String RESPONSE_FIELD_ERRORS = "errors";

	public static final String HTTP_STATUS_SUCCESS = "SUCCESS";
	public static final String HTTP_STATUS_FAILED = "FAILED";
	public static final String HTTP_STATUS_ERROR = "ERROR";

	public static final String VALUE_NULL = "null";

	public static final String FLG_TRUE = "1";
	public static final String FLG_FALSE = "0";

	// 各种errorMessage 编号
	public static final String SUCCESS_CODE = "0000";
	public static final String SYSTEM_ERROR_CODE = "1111";

	public static final String LOGIN_EMPTY_MSG = "W0001";
	public static final String LOGIN_INVALID_MSG = "W0002";
	public static final String FILE_PATH_NULL_ERROR_MSG = "E2010";
	public static final String FILE_REPEAT_ERROR_MSG = "E2011";
	public static final String FILE_TYPE_EXCEL_ERROR_MSG = "E2012";
	public static final String CHECKBOX_NOT_SELECTED = "E2013";
	public static final String CHECKBOX_AND_DESIGN_INCONSISTENT = "E2014";
	public static final String SQL_CHECKBOX_NOT_SELECTED = "E2015";
	public static final String COLUMN_OR_TABLE_NOT_EXIST = "E0409";
	public static final String FILE_PATH_NOT_EXIST = "E2016";
	public static final String FILES_NOT_EXIST = "E2017";
	// 成功message
	public static final String TEST_CASE_MADE_SUCCESS = "S0001";
	// 各个画面的画面名
	public static final String LOGIN_PAGE = "P00-01-01";
	public static final String MAIN_MENU = "P01-01-01";
	public static final String DESIGN_MANAGE_MENU = "P02-01-01";
	public static final String DESIGN_IMPORT_PAGE = "P02-02-01";
	public static final String DESIGN_EXPORT_PAGE = "P02-02-02";
	public static final String DETAILED_DESIGN_GENERATION_PAGE = "P03-01-01";
	public static final String SCRIPT_GENERATION_MENU = "P04-01-01";
	public static final String SQL_GENERATION_PAGE = "P04-02-01";
	public static final String AUTOMATIC_TEST_MENU = "P05-01-01";
	public static final String SINGLE_TEST_CASE_GENERATION_PAGE = "P05-02-01";
	public static final String SINGLE_TEST_DATA_GENERATION_PAGE = "P05-02-02";
	public static final String SINGLE_TEST_EXECUTION_SCRIPT_GENERATION_PAGE = "P05-02-03";
	public static final String SINGLE_TEST_EXECUTION_PAGE = "P05-02-04";
	public static final String SINGLE_TEST_RESULTS_VERIFICATION_PAGE = "P05-02-05";
	
	//罫線削除類型
	public static final int ITEM_TYPE_MOVENONE  = 0;
	public static final int ITEM_TYPE_MOVEAROUNDLINE  = 1;
	public static final int ITEM_TYPE_MOVELATTICE  = 2;
	
	

}