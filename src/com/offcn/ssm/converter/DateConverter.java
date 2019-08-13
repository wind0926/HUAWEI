package com.offcn.ssm.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

// 转换器
public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		
		// 把字符串转换为日期类型
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			// 将字符串转换为Date类型
			return df.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	

}
