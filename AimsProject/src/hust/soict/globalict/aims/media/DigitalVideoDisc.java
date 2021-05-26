package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{

	public DigitalVideoDisc(int id,String title,String category,float cost,int length,String director) {
		super(id,title,category,cost,length,director);
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public void play() throws PlayerException {
		if(this.getLength()>0) {
			//System.out.println("Playing DVD: "+this.getTitle());
			//System.out.println("DVD length: "+this.getLength());
		}
		else {
			throw new PlayerException("DVD length is non positive");
		}

	}
	
	public boolean search(String title) {
		String space=" ";
		String[] arrays=title.split(space);
		for(String array: arrays) {
			if (!getTitle().contains(array)) {
				return false;
			}
		}
		return true;
	}
	
	public int compareTo(Media o) {
		DigitalVideoDisc dvd=(DigitalVideoDisc) o;
		if(this.getCost()>dvd.getCost())
			return 1;
		return -1;
	}
}
