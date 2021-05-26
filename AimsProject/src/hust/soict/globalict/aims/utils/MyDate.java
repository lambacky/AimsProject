package hust.soict.globalict.aims.utils;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
public class MyDate {
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
			this.year = year;
	}
	public MyDate(int day, int month, int year) {
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public MyDate() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		this.day=calendar.get(Calendar.DATE);
		this.month=calendar.get(Calendar.MONTH)+1;
		this.year=calendar.get(Calendar.YEAR);
	}
	
	public MyDate(String d) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = sdf.parse(d);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(dt);
		this.day=calendar.get(Calendar.DATE);
		this.month=calendar.get(Calendar.MONTH)+1;
		this.year=calendar.get(Calendar.YEAR);
	}
	
	public MyDate(String day,String month,String year) {
		
	}
	
	public void print(){
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd yyyy");  
		Date date = new Date();  
		System.out.println(formatter.format(date));
	}
	
	public void printdate() {
		if(check(day,month,year)==0)
			System.out.println("Invalid date");
		else System.out.println(month+"/"+day+"/"+year);
	}
	public int check(int day,int month,int year) {
		if(year>0) {
			if(month>0&&month<13) {
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
					if(day>=1&&day<=31) return 1;
				}
				if(month==4||month==6||month==8||month==11) {
				if(day>=1&&day<=30) return 1;

				}
				if(month==2) {
					if(((year % 4 == 0) && !(year % 100 == 0)||(year % 400 == 0))) {

					}
					else {
						if(day>=1&&day<=28) return 1;
					}
				}
			}
		}
		return 0;
	}

}
