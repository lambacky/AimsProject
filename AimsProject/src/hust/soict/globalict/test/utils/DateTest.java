package hust.soict.globalict.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import hust.soict.globalict.aims.utils.DateUtils;
import hust.soict.globalict.aims.utils.MyDate;

import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
public class DateTest {
	public static void main(String[] args) throws ParseException{
		DateUtils t=new DateUtils();
		MyDate d1=new MyDate();
		d1.print(); //print the current date
		
		MyDate d2=new MyDate(25,4,2019);
		d2.printdate(); // print the date with format d/MM/yyyy
		
		MyDate d3=new MyDate(23,5,2018);
		d3.printdate();
		
		MyDate d4=new MyDate(6,4,2020);
		d4.printdate();
		
		t.Compare(d1, d2);
		
		MyDate[] d= {d1,d2,d3,d4};
		t.Sort(d);
		
		

	}

}
