package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		Wrapper wjungleDVD= new Wrapper(jungleDVD);
		Wrapper wcinderellaDVD=new Wrapper(cinderellaDVD);
		swap(wjungleDVD,wcinderellaDVD);
		System.out.println("Jungle dvd title: "+wjungleDVD.d.getTitle());
		System.out.println("Cinderlla dvd title: "+wcinderellaDVD.d.getTitle());
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("Jungle dvd title: "+jungleDVD.getTitle());
	}
	
	public static void swap(Wrapper o1,Wrapper o2) {
		DigitalVideoDisc tmp=o1.d;
		o1.d=o2.d;
		o2.d=tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd=new DigitalVideoDisc(oldTitle);
	}
}

class Wrapper{
	DigitalVideoDisc d;
	Wrapper(DigitalVideoDisc d){
		this.d=d;
	}
}
