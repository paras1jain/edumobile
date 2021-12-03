package com.Lead.qa.util;

public class DataDrivenTest {

	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\hp\\Desktop\\New folder\\Educollab2\\EducalabMobile\\src\\main\\java\\com\\Lead\\qa\\testdata\\Leaddata.xlsx");
		String Mobile =reader.getCellData("LoginPositive", "Name", 2);
		System.out.println(Mobile);
	}

}
