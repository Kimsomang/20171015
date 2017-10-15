package com.selfit.model.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility {

	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		String today = format.format(new Date());
		
		return today;
	}
	
	//임시비밀번호 생성 메서드
		public String createRandomPw() {
			Random r = new Random();
			String randomPw = "";
			
			for(int i=0; i<8; i++) {
				randomPw += r.nextInt(10);			
			}
			return randomPw;
		}
}
