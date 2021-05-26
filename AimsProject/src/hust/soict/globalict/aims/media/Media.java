package hust.soict.globalict.aims.media;

public abstract class Media implements Comparable<Media> {
	private int id;
	private String title;
	private String category;
	private float cost;
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Media(String title) {
		this.title=title;
	}
	
	public Media(String title,String category) {
		this(title);
		this.category=category;
	}
	
	public Media(String title,String category,float cost) {
		this(title,category);
		this.cost=cost;
	}
	public Media(int id,String title,String category,float cost) {
		this.id=id;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	
	public boolean equals(Object obj) {
		Media m =(Media) obj;
		if((this.getTitle().equals(m.getTitle()))&&(this.getCost()==m.getCost()))
			return true;
		return false;
	}
	
	public int compareTo(Media o) {
		return this.getTitle().compareTo(o.getTitle());
	}

}
