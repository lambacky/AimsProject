package hust.soict.globalict.test.disk;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order anOrder = new Order();
		
		//create a dvd1
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		//add dvd1 to the order
		anOrder.addMedia(dvd1);
		
		//create a dvd2
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		//add dvd2 to the order
		anOrder.addMedia(dvd2);
			
		//create dvd3
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		//add dvd3 to the order
		anOrder.addMedia(dvd3);
		
		//create dvd4
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Forrest Gump");
		dvd4.setCategory("Drama");
		dvd4.setCost(23.45f);
		dvd4.setDirector("Robert Zemeckis");
		dvd4.setLength(142);
		//add dvd4 to the order
		anOrder.addMedia(dvd4);
		
		System.out.println("Here is the list of dvds that you order:");
		anOrder.print();
		
		anOrder.getALuckyItem();
		System.out.println("After randomly pick up an item, here is the new list:");
		anOrder.print();
		
		//check the boolean title search
		System.out.println(dvd1.search("The King"));
		System.out.println(dvd4.search("Forrest house"));
	}

}
