package hust.soict.globalict.test.media;

import java.util.*;

import hust.soict.globalict.aims.media.*;

public class TestMediaCompareTo {
	public static void main(String[] args) {
		//add DVDs and sort by cost
		//create dvd1
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		//create a dvd2
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
			
		//create dvd3
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		
		List<Media> collection1=new ArrayList<Media>();
		collection1.add(dvd2);
		collection1.add(dvd1);
		collection1.add(dvd3);
		Iterator<Media> iterator1=collection1.iterator();
		System.out.println("----------------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		while(iterator1.hasNext()){
			System.out.println((iterator1.next()).getTitle());
		}
		
		Collections.sort(collection1);
		iterator1=collection1.iterator();
		System.out.println("----------------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		while(iterator1.hasNext()){
			System.out.println(iterator1.next().getTitle());
		}
		System.out.println("----------------------------------------");
		
		
		//add CDS and sort by number of tracks and length
		//create cd1
		CompactDisc cd1=new CompactDisc("BBB");
		cd1.setCategory("Science Fiction");
		cd1.setCost(22.95f);
		cd1.setDirector("George Lucas");
		cd1.setArtist("Lam");
		Track tr1=new Track("eee",5);
		cd1.addTrack(tr1);
		Track tr2=new Track("ddd",9);
		cd1.addTrack(tr2);
		
		//create cd2
		CompactDisc cd2=new CompactDisc("AAA");
		cd2.setCategory("Science Fiction");
		cd2.setCost(21.95f);
		cd2.setDirector("George Lucas");
		cd2.setArtist("lam");
		Track tr3=new Track("eee",5);
		cd2.addTrack(tr3);
		Track tr4=new Track("ddd",8);
		cd2.addTrack(tr4);
		
		List<Media> collection2=new ArrayList<Media>();
		collection2.add(cd1);
		collection2.add(cd2);
		Iterator<Media> iterator2=collection2.iterator();
		System.out.println("----------------------------------------");
		System.out.println("The CD currently in the order are: ");
		while(iterator2.hasNext()){
			System.out.println((iterator2.next()).getTitle());
		}
		
		Collections.sort(collection2);
		iterator2=collection2.iterator();
		System.out.println("----------------------------------------");
		System.out.println("The CDs in sorted order are: ");
		while(iterator2.hasNext()){
			System.out.println(iterator2.next().getTitle());
		}
		System.out.println("----------------------------------------");
		
	}
}
