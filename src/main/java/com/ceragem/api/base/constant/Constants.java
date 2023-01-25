package com.ceragem.api.base.constant;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 
 * <pre>
 * com.ceragem.api.sys.util - Constants.java
 * </pre>
 *
 * @ClassName : Constants
 * @Description : 상수 설정
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

public class Constants {
	public static final String _API_INFO_KEY = "apiInfo";
	public static final String _APIKEY_PAYLOAD = "apikeyInfo";
	public static final String _APIKEY_PAYLOAD_KEY_SYSTEM = "systemCd";
	public static final String _API_CALL_URL_KEY = "api_request_uri";

	public final static String _API_CODE_OK = "IAR0200";
	public final static String _API_CODE_FAIL = "IAR0201";
	public final static String _API_CODE_NOT_FOUND = "IAR0202"; /* 해당api를 찾을 수 없습니다. */
	public final static String _API_CODE_NOT_FOUND_MSG = "해당api를 찾을 수 없습니다.";
	public final static String _API_CODE_NO_TOKEN = "IAR0203"; /* 토큰을 찾을 수 없습니다. */
	public final static String _API_CODE_NO_TOKEN_MSG = "토큰을 찾을 수 없습니다.";
	public final static String _API_CODE_EXPIRED_KEY = "IAR0204"; /* 만료된 apikey 입니다.. */
	public final static String _API_CODE_EXPIRED_KEY_MSG = "만료된 apikey 입니다.";
	public final static String _API_CODE_MALFROMED_KEY = "IAR0205"; /* 잘못된 apikey 입니다.. */
	public final static String _API_CODE_MALFROMED_KEY_MSG = "잘못된 apikey 입니다."; /* 잘못된 apikey 입니다.. */
	public final static String _API_CODE_NO_REG = "IAR0206"; /* 등록되지 않은 API입니다. */
	public final static String _API_CODE_NO_REG_MSG = "등록되지 않은 API입니다."; /* 등록되지 않은 API입니다. */
	public final static String _API_CODE_EXPIRED_URL = "IAR0207"; /* 사용 종료된 API 주소입니다. */
	public final static String _API_CODE_EXPIRED_URL_MSG = "사용 종료된 API 주소입니다."; /* 사용 종료된 API 주소입니다. */
	public final static String _API_CODE_NO_METHOD = "IAR0208"; /* 등록되지 않은 API입니다. */
	public final static String _API_CODE_NO_METHOD_MSG = "등록되지 않은 API입니다."; /* 등록되지 않은 API입니다. */
	public final static String _API_CODE_NO_SEARCH_PARAM = "IAR0209"; /* 검색조건이 설정되지 않았습니다. */
	public final static String _API_CODE_NO_SEARCH_PARAM_MSG = "검색조건이 설정되지 않았습니다."; /* 검색조건이 설정되지 않았습니다. */

	public final static String _API_CODE_INVALID_PARAM = "IAR0300"; /* 요청파라미터가 올바르지 않습니다. [파라미터] */
	public final static String _API_CODE_INVALID_PARAM_MSG = "요청파라미터가 올바르지 않습니다."; /* 요청파라미터가 올바르지 않습니다. [파라미터] */
	public final static String _API_CODE_DUPLICATED_PARAM = "IAR0301"; /* 요청파라미터가 올바르지 않습니다. [파라미터] */
	public final static String _API_CODE_DUPLICATED_PARAM_MSG = "이미 등록된 데이터가 존재합니다."; /* 중복된 값이 존재합니다. [파라미터] */
	public static final String _API_CODE_DUPLICATED_PARAM_USER_CI_MSG = "이미 등록된 CI값이 존재합니다.";
	public static final String _API_CODE_DUPLICATED_PARAM_USER_NM_PHONE_MSG = "동일한 이름에 동일한 전화번호가 존재합니다.";
	public static final String _API_CODE_DUPLICATED_PARAM_LOGIN_ID_MSG = "이미 사용중인 로그인 아이디 입니다.";

	public final static String _API_CODE_NO_USER = "IAR0302"; /* 요청파라미터가 올바르지 않습니다. [파라미터] */
	public final static String _API_CODE_NO_USER_MSG = "존재하지 않는 통합회원번호 입니다."; /* 중복된 값이 존재합니다. [파라미터] */

	public final static String _API_CODE_NO_STORE = "IAR0303";
	public final static String _API_CODE_NO_STORE_MSG = "존재하지 않는 매장번호 입니다.";

	public final static String _API_CODE_NO_INFO_ID = "IAR0304";
	public final static String _API_CODE_NO_INFO_ID_MSG = "개인정보 취급자 아이디가 존재하지 않습니다.";

	public final static String _API_CODE_NO_DORMANT = "IAR0305";
	public final static String _API_CODE_NO_DORMANT_MSG = "휴면회원 정보는 수정 할 수 없습니다.";

	public final static String _API_CODE_NO_DATA = "IAR0400"; /* 조회된 데이터가 없습니다. */
	public final static String _API_CODE_NO_DATA_MSG = "조회된 데이터가 없습니다."; /* 조회된 데이터가 없습니다. */

	public final static String _API_CODE_NO_RIGHT = "IAR0800"; /* 요청한 정보를 조회할 권한이 없습니다. */
	public final static String _API_CODE_NO_RIGHT_MSG = "요청한 정보를 조회할 권한이 없습니다"; /* 요청한 정보를 조회할 권한이 없습니다. */

	public final static String _API_CODE_NO_PARAM = "IAR0900"; /* 헤더정보가 잘못되었습니다. [파라미터]. */
	public final static String _API_CODE_NO_PARAM_MSG = "헤더정보가 잘못되었습니다."; /* 헤더정보가 잘못되었습니다. [파라미터]. */

	public final static String _API_CODE_LOGIN_FAIL = "IAR0300"; /* 요청파라미터가 올바르지 않습니다. [파라미터] */
	public final static String _API_CODE_LOGIN_FAIL_MSG = "아이디/암호를 확인해 주세요.";

	public final static String _API_CODE_NO_USETYPE = "IAR0513";
	public final static String _API_CODE_NO_USETYPE_MSG = "일반회원은 구매 정책이 없습니다.";

	public final static SimpleDateFormat _TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
			Locale.KOREAN);
	public final static SimpleDateFormat _DATETIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);
	public final static SimpleDateFormat _DATE_FORMAT = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);

	public final static String _DB_ENCODING = "UTF-8";

	public final static String _UNKNOWN_SYSTEM_CD = "000";

	public static final String _USER_STATUS_NORMAL = "001";
	public static final String _USER_STATUS_DORMANT = "002";
	public static final String _USER_STATUS_DELETE = "003";

	public static final String _API_COUPN_NO_DATA = "IAR0701";
	public static final String _API_COUPN_NO_DATA_MSG = "조회된 쿠폰번호가 없습니다";

	public static final String _API_POINT_NO_DATA = "IAR0702";
	public static final String _API_POINT_NO_DATA_MSG = "조회된 포인트가 없습니다";

	public static final String _API_STMP_CNT_DATA = "IAR0703";
	public static final String _API_STMP_CNT_DATA_MSG = "스탬프 적립 수량이 상이합니다";

	public static final String _API_CUST_NO_DATA = "IAR0704";
	public static final String _API_CUST_NO_DATA_MSG = "통합회원 번호가 상이합니다";

	public static final String _API_CHL_NO_DATA = "IAR0705";
	public static final String _API_CHL_NO_DATA_MSG = "채널코드 가 상이합니다";

	public static final String _API_STOR_NO_DATA = "IAR0706";
	public static final String _API_STOR_NO_DATA_MSG = "매장코드 가 상이합니다";

	public static final String _API_GODS_NO_DATA = "IAR0707";
	public static final String _API_GODS_NO_DATA_MSG = "상품코드 가 상이합니다";

	public static final String _API_MSHP_CD_NO_DATA = "IAR0708";
	public static final String _API_MSHP_CD_NO_DATA_MSG = "회원 등급 코드가 상이합니다";

	public static final String _API_CHIT_CNT_NO_DATA = "IAR0709";
	public static final String _API_CHIT_CNT_NO_DATA_MSG = "중복된 전표번호 입니다";

	public static final String _API_CHIT_NO_DATA = "IAR0710";
	public static final String _API_CHIT_NO_DATA_MSG = "전표번호 가 상이합니다";

	public static final String _API_CUST_CNT_NO_DATA = "IAR0711";
	public static final String _API_CUST_CNT_NO_DATA_MSG = "조회된 통합회원이 없습니다";

	public static final String _API_CHL_CNT_NO_DATA = "IAR0712";
	public static final String _API_CHL_CNT_NO_DATA_MSG = "조회된 채널이 없습니다";

	public static final String _API_STOR_CNT_NO_DATA = "IAR0713";
	public static final String _API_STOR_CNT_NO_DATA_MSG = "조회된 매장이 없습니다";

	public static final String _API_STMP_NO_DATA = "IAR0714";
	public static final String _API_STMP_NO_DATA_MSG = "조회된 스탬프가 없습니다";

	public static final String _API_MSHP_TYPE_NO_DATA = "IAR0715";
	public static final String _API_MSHP_TYPE_NO_DATA_MSG = "회원구분이 상이 합니다.";

	public static final String _TALK_CODE_POINT_DEPOSIT = "220";
	public static final String _TALK_CODE_POINT_WITHDRAWAL = "230";
	public static final String _TALK_CODE_POINT_CANCEL = "240";
	public static final String _TALK_CODE_POINT_RECOM = "250";

	public static final String _CUST_EVENT_REGISTER = "001";
	public static final String _CUST_EVENT_MODIFY = "002";
	public static final String _CUST_EVENT_WITHDRAWAL = "003";
	public static final String _CUST_EVENT_DORM = "004";
	public static final String _CUST_EVENT_DORM_CANCEL = "005";
	public static final String _CUST_EVENT_MEMBERSHIP = "006";
	public static final String _CUST_EVENT_MODIFY_PWD = "002";
	public static final String _CUST_EVENT_MODIFY_IDPWD = "002";
	
	public final static String _API_COUPN_OVER_DAY_DATA = "IAR0600"; /* 조회된 데이터가 없습니다. */
	public final static String _API_COUPN_OVER_DAY_DATA_MSG = "발행기간이 초과 되었습니다."; /* 조회된 데이터가 없습니다. */
	
	public final static String _API_COUPN_OVER_ISSUE_DATA = "IAR0604"; 
	public final static String _API_COUPN_OVER_ISSUE_DATA_MSG = "일최대 발급 매수 초과 했습니다."; 
	
	public final static String _API_COUPN_GRADE_DATA = "IAR0605"; 
	public final static String _API_COUPN_GRADE_DATA_MSG = "발행권한이 제한 되었습니다."; 
	
	public final static String _API_COUPN_CMPNO_DATA = "IAR0606"; 
	public final static String _API_COUPN_CMPNO_DATA_MSG = "제휴사 번호가 불일치 합니다."; 
	
	static {
		_TIMESTAMP_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
}
