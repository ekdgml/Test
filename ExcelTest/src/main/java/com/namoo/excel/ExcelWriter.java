package com.namoo.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

public class ExcelWriter {
	//
	public static void main(String[] args) throws ParsePropertyException, InvalidFormatException, IOException {
		//
		
		// 템플릿 엑셀파일
		// + 데이터
		// = 생성할 액셀파일
		
		String template = "address_template.xlsx";
		String excelFile = "result.xlsx";
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(new Address("박상희", "010-2941-1630", "경기도 안양시 동안구"));
		addresses.add(new Address("홍길동", "010-1111-1111", "경기도 금천구 가산동"));
		
		data.put("addresses", addresses);
		data.put("title", "주소록 입니다.");
		
		XLSTransformer transformer = new XLSTransformer();
		transformer.transformXLS(template, data, excelFile);
	}
}
