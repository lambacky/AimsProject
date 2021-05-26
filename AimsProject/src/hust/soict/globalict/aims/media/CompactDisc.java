package hust.soict.globalict.aims.media;

import java.util.ArrayList;

import hust.soict.globalict.aims.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	public ArrayList<Track> tracks = new ArrayList<Track>();
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title,String category) {
		super(title,category);
	}
	public CompactDisc(int id,String title,String category,float cost,String director,String artist) {
		super(id,title,category,cost,director);
		this.artist=artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
		}
	}
	
	public int getLength() {
		int l=0;
		for(int i=0;i<tracks.size();i++)
			l+=tracks.get(i).getLength();
		return l;
	}
	
	public void play() throws PlayerException {
		if(this.getLength()>0) {
			//System.out.println("Playing CD: "+this.getTitle());
			//System.out.println("CD length: "+this.getLength());
			java.util.Iterator iter=tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack=(Track) iter.next();
				try {
					nextTrack.play();
				}catch(Exception e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("CD length is non-positive");
		}
	}
	
	public int compareTo(Media o) {
		CompactDisc cd=(CompactDisc) o;
		int c= this.tracks.size()-cd.tracks.size();
		if(c!=0) return c;
		else return this.getLength()-cd.getLength();
	}
}
