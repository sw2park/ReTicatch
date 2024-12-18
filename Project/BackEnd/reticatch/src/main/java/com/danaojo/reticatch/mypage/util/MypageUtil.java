package com.danaojo.reticatch.mypage.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import com.danaojo.reticatch.mypage.dto.CancelReserveDTO;
import com.danaojo.reticatch.mypage.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MypageUtil {
	// String 데이터를 넘겨주면 UserDTO에 매핑해서 리턴
	public UserDTO mappingUserDto(String data) throws JsonMappingException, JsonProcessingException {
		UserDTO uDto = new UserDTO();
		ObjectMapper objMapper = new ObjectMapper();

		uDto = objMapper.readValue(data, UserDTO.class);

		return uDto;
	}

	// 오늘 날짜 yyyy-MM-dd 형태로 반환
	public String returnToday() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formNow = now.format(form);

		return formNow;
	}

	// 정규표현식 사용해서 전화번호 변환
	public String changePhoneNum(String phoneNum, int type) {
		String result = "";

		if (phoneNum.length() == 11) {
			if (type == 0) {
				// 01012345678 → 010-****-5678
				result = phoneNum.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-****-$3");
			} else {
				// 01012345678 → 010-1234-5678
				result = phoneNum.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
			}
		} else if (phoneNum.length() == 8) {
			// 12345678 → 1234-5678
			result = phoneNum.replaceAll("(\\d{4})(\\d{4})", "$1-$2");
		} else {
			if (phoneNum.startsWith("02")) {
				if (type == 0) {
					// 0212345678 → 02-****-5678
					result = phoneNum.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "$1-****-$3");
				} else {
					// 0212345678 → 02-1234-5678
					result = phoneNum.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "$1-$2-$3");
				}
			} else {
				if (type == 0) {
					// 03112345678 → 031-***-5678
					result = phoneNum.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-***-$3");
				} else {
					// 03112345678 → 031-123-5678
					result = phoneNum.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
				}
			}
		}
		return result;
	}

	// String 데이터를 넘겨주면 cancelDTO에 매핑해서 리턴
	public CancelReserveDTO mappingCancelDto(String data) throws JsonMappingException, JsonProcessingException {
		CancelReserveDTO cDto = new CancelReserveDTO();
		ObjectMapper objMapper = new ObjectMapper();

		cDto = objMapper.readValue(data, CancelReserveDTO.class);

		return cDto;
	}

	// 따옴표 제거 메소드
	public String deleteMarks(String str) {
		String result = str.replace("\"", "");

		return result;
	}

	// 조건 시작일 ex) 12월 선택시 12-01로 설정하는 메소드 return : yyyy-MM-dd
	public String calcPrevDate(String year, String month) {
		// String -> int 변환
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, yearInt);
		cal.set(Calendar.MONTH, monthInt - 1); // 월은 0부터 시작 (1월: 0)
		cal.set(Calendar.DAY_OF_MONTH, 1); // 첫째 날 설정

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(cal.getTime());
	}

	// 조건 종료일 ex) 12월 선택시 12-31로 설정하는 메소드 return : yyyy-MM-dd
	public String calcNextDate(String year, String month) {
		// String -> int 변환
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, yearInt);
		cal.set(Calendar.MONTH, monthInt - 1); // 월은 0부터 시작 (1월: 0)
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH)); // 마지막 날 설정

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

}