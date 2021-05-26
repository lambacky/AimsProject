package hust.soict.globalict.aims.order;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MyDate;
import java.util.*;
public class Order {
	public static final int MAX =10;
	public static final int MAX_O=5;
	public static int nbOrders=0;
	private MyDate dateOdered=new MyDate();
	private Media lucky;
	public List<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(itemsOrdered.size()<MAX) {
			itemsOrdered.add(media);
			
		}
	}
	public void removeMedia(int id) {
		for(int i=0;i<itemsOrdered.size();i++) {
			if(itemsOrdered.get(i).getId()==id) {
				itemsOrdered.remove(i);
			}
		}
	}

	public float totalCost() {
		float c=0;
		for(int i=0;i<itemsOrdered.size();i++) {
			if(itemsOrdered.get(i)==lucky) {
				continue;
			}
			c+=itemsOrdered.get(i).getCost();
		}
		return c;
	}
	
	public void print() {
			System.out.println("********************Order********************");
			System.out.print("Date: ");dateOdered.print();
			System.out.print("Ordered items:");
			for(int i=0;i<itemsOrdered.size();i++) {
				System.out.print("\n"+(i+1)+". "+itemsOrdered.get(i).getId()+" - "+itemsOrdered.get(i).getTitle()+" - "+itemsOrdered.get(i).getCategory()+" - "+itemsOrdered.get(i).getCost());
				if(itemsOrdered.get(i)==lucky) {
					System.out.print(" (You get this item for free)");
				}
			}
			System.out.println("\nTotal cost: "+totalCost());
			System.out.println("*********************************************\n");
	}
	
	public Media getALuckyItem() {
		int r=(int)(Math.random()*itemsOrdered.size());
		lucky=itemsOrdered.get(r);
		return lucky;
	}
}



