package com.namoo.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.xml.sax.SAXException;

public class ExcelReader {
	//
	public static void main(String[] args) throws IOException, SAXException, InvalidFormatException {
		//
		InputStream mappingXml = new FileInputStream(new File("mapping.xml"));
		XLSReader reader = ReaderBuilder.buildFromXML(mappingXml);
		
		InputStream inputXls = new FileInputStream(new File("address_four.xlsx"));
		Map<String, Object> beans = new HashMap<String, Object>();
		
		List<Address> addresses = new ArrayList<Address>();
		beans.put("addresses", addresses);
		
		reader.read(inputXls, beans);

		//
		for (Address address : addresses) {
			System.out.println(address.getName());
			System.out.println(address.getPhone());
			System.out.println(address.getAddress());
		}
	}
}
