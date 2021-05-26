package hust.soict.globalict.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	public void setLength(int length) {
		this.length = length;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	
	public Disc(String title) {
		super(title);
	}
	public Disc(String title,String category) {
		super(title,category);
	}
	
	public Disc(int id,String title, String category,float cost) {
		super(id,title,category,cost);
	}
	public Disc(int id, String title,String category,float cost,String director) {
		super(id,title,category,cost);
		this.director=director;
	}
	public Disc(int id,String title,String category,float cost,int length,String director) {
		super(id,title,category,cost);
		this.length=length;
		this.director=director;
	}

}
