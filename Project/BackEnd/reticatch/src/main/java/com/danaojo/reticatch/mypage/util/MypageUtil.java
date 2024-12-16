package com.danaojo.reticatch.mypage.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MypageUtil {
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