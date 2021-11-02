package model;

public class Collection {
	

	private String owner;
	
	//Relationships
	
	private Date creationDate;
	private Album album1;
	private Album album2;
	private Album album3;
	

	public Collection(String owner, int day, int month, int year) {
		this.owner = owner;
		creationDate = new Date(day, month, year);
		
	}
	
	public void addAlbum1(String name, int num)  {
		album1 = new Album(name, num);
	}
	
	public void addAlbum2(String name, int num) {
		album2 = new Album(name, num);
	}
	
	public void addAlbum3(String name, int num) {
		album3 = new Album(name, num);
	}
	
	
	
	/*
	 * ============================== Getters & Setters
	 */

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Album getAlbum1() {
		return album1;
	}

	public void setAlbum1(Album album1) {
		this.album1 = album1;
	}

	public Album getAlbum2() {
		return album2;
	}

	public void setAlbum2(Album album2) {
		this.album2 = album2;
	}

	public Album getAlbum3() {
		return album3;
	}

	public void setAlbum3(Album album3) {
		this.album3 = album3;
	}
	
	public String toString() {
		String out="";
		out += "This collection belongs to " + owner;
		out += "\ncreated on " + creationDate.toString();
		return out;
	}

	/** Debe retornar true si hay algún objeto null, false en el caso contrarion
	*/
	public boolean hasAlbums() {
		boolean out=false;
		if(album1==null || album2==null || album3==null){
			out = true;
		}
		return out;
	}

	public String showAlbums() {
		return "";
		
	}

	public void addAlbum(String tit, int num) {

		if(album1==null){
			addAlbum1(tit, num);

		}
		else if(album2==null){
			addAlbum2(tit, num);

		}
		else if(album3==null){
			addAlbum3(tit, num);

		}

	} 

	public void editAlbum(int id, String nom, int num){
		switch(id){
			case 1:
				album1.setRegionName(nom);
				album1.setNumPokemons(num);
				break;
			case 2:
				album2.setRegionName(nom);
				album2.setNumPokemons(num);
				break;
			case 3:
				album3.setRegionName(nom);
				album3.setNumPokemons(num);
				break;
		}
	}

	public void deleteAlbum(int id){
		switch(id){
			case 1:
				album1 = null;
				break;
			case 2:
				album2 = null;
				break;
			case 3:
				album3 = null;
				break;
		}
	}
	
	private boolean isThereSpaceInAlbum((int id){
		out = false;
		
		switch(id){
			case 1:
				if(album1!=null){
					out = album1.isThereSpace();
				}
				else{
					out = false;
				}
				break;
				
			case 2:
				if(album2!=null){
					out = album2.isThereSpace();
				}
				else{
					out = false;
				}
				break;
				
			case 3:
				if(album3!=null){
					out = album3.isThereSpace();
				}
				else{
					out = false;
				}
				break;
		}
		
		return out;
		
	}

}
