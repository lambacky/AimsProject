package hust.soict.globalict.aims.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class DateUtils {
	public String Change(MyDate d1) {
		String s1=Integer.toString(d1.getDay())+"-"+Integer.toString(d1.getMonth())+"-"+Integer.toString(d1.getYear());
		return s1;
	}
	public void Compare(MyDate d1,MyDate d2) throws ParseException {
		SimpleDateFormat sobj = new SimpleDateFormat("dd-MM-yyyy");
		Date date1=sobj.parse(Change(d1)); 
		Date date2=sobj.parse(Change(d2));
		if(date1.compareTo(date2) > 0) {
	         System.out.println("Date 1 occurs after Date 2");
	      } else if(date1.compareTo(date2) < 0) {
	         System.out.println("Date 1 occurs before Date 2");
	      } else if(date1.compareTo(date2) == 0) {
	         System.out.println("Both dates are equal");
	      }
		
	}
	public void Sort(MyDate d[]) throws ParseException {
		String s[]=new String[d.length];
		Date date[]=new Date[d.length];
		for(int i=0;i<d.length;i++) {
			s[i]= Change(d[i]);
		}
		SimpleDateFormat sobj = new SimpleDateFormat("dd-MM-yyyy");
		for(int i=0;i<d.length;i++)
        {
            date[i]=sobj.parse(s[i]);                         //parse the date string to date obj
        }
		Arrays.sort(date);                                                                            
		System.out.println("Sorting in ascending order: ");
        for(Date date1 : date)                                  //Enchanced for loop, it loops through all element in date array
        {                                                       //each time date[i] is copied to date1 like traditional for loop
            System.out.println(sobj.format(date1));             //format the date1 to dd-MM-yyyy using sobj 
        }
	}
}
