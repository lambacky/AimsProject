package hust.soict.globalict.aims;
import hust.soict.globalict.aims.order.Order;
import hust.soict.globalict.aims.media.*;
import java.util.*;
import hust.soict.globalict.aims.PlayerException;
public class Aims {
	static int id;
	static String t;
	static String ca;
	static float co;
	static Scanner s=new Scanner(System.in);
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1.Create new Order");
		System.out.println("2.Add an item to the order");
		System.out.println("3.Remove an item by id");
		System.out.println("4.Display the items list of order");
		System.out.println("0.Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number 0-1-2-3-4");
	}
	
	public static void showType() {
		System.out.println("Types of item: ");
		System.out.println("--------------------------------");
		System.out.println("1.Book");
		System.out.println("2.DVD");
		System.out.println("3.CD");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number 1-2-3");
	}
	
	public static  void Information() {
		System.out.println("Enter id:");
		id=s.nextInt();
		System.out.println("Enter Title");
		s.nextLine();
		t= s.nextLine();
		System.out.println("Enter category:");
		ca=s.nextLine();
		System.out.println("Enter cost:");
		co=s.nextFloat();
	}
	
	
	public static void main(String[] args) throws PlayerException {
		// TODO Auto-generated method stub
		MemoryDaemon md=new MemoryDaemon();
		Thread th=new Thread(md);
		th.setDaemon(true);
		th.start();
		Order anOrder[]=new Order[Order.MAX_O];
		int j=-1;
		do {
			showMenu();
			switch(s.nextInt()) {
			case 1:
				if(j+1<Order.MAX_O) {
					j++;
					anOrder[j]=new Order();
					System.out.println("A new Order is created");
				}
				else System.out.println("You cannot create more orders");
				break;
			case 2:
				showType();
				switch(s.nextInt()) {
				case 1:
					Information();
					Book b=new Book(id,t,ca,co);
					String q="y";
					while(q.equals("y")){
						System.out.println("Enter author name:");
						s.nextLine();
						String a =s.nextLine();
						b.addAuthor(a);
						System.out.println("Are there any authors?(y/n): ");
						q=s.next();
					}
					anOrder[j].addMedia(b);
					break;
				case 2:
					Information();
					System.out.println("Enter length:");
					int dl=s.nextInt();
					System.out.println("Enter director:");
					s.nextLine();
					String ddi=s.nextLine();
					DigitalVideoDisc dvd=new DigitalVideoDisc(id,t,ca,co,dl,ddi);
					anOrder[j].addMedia(dvd);
					System.out.println("Do you want to play this dvd?(y/n):");
					if(s.next().equals("y")) {
						try {
							dvd.play();
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					break;
				case 3:
					Information();
					System.out.println("Enter director:");
					s.nextLine();
					String cdi=s.nextLine();
					System.out.println("Enter artist: ");
					String ar=s.nextLine();
					CompactDisc cd=new CompactDisc(id,t,ca,co,cdi,ar);
					String p="y";
					while(p.equals("y")){
						System.out.println("Enter track title:");
						String trt=s.nextLine();
						System.out.println("Enter track length:");
						int trl=s.nextInt();
						Track tr=new Track(trt,trl);
						cd.addTrack(tr);
						System.out.println("Do you want to play this track?(y/n):");
						if(s.next().equals("y")) {
							tr.play();
						}
						System.out.println("Are there any tracks?(y/n):");
						s.nextLine();
						p=s.nextLine();
					}
					anOrder[j].addMedia(cd);
					System.out.println("Do you want to play this cd?(y/n):");
					if(s.next().equals("y")) {
						try{
							cd.play();
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					break;
				}
				break;
			case 3:
				System.out.println("Enter id:");
				anOrder[j].removeMedia(s.nextInt());
				break;
			case 4:
				anOrder[j].print();
				break;
			case 0:
				System.exit(0);
			}
		}while(true);
	}
}
