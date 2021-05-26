package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title,int length) {
		this.title=title;
		this.length=length;
	}
	
	public void play() throws PlayerException {
		if(this.getLength()>0) {
			//System.out.println("Playing track: "+this.getTitle());
			//System.out.println("Track length: "+this.getLength());
		}
		else {
			throw new PlayerException("Track length is non-posittive");
		}
		
	}
	
	public boolean equals(Object obj) {
		Track t=(Track) obj;
		if(!this.getTitle().equals(t.getTitle()))
			return false;
		if(this.getLength()!=t.getLength())
			return false;
		return true;
			
	}
	

}
