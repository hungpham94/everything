package model;

public class common {
   private String name;
   private String Descripition;
   private int image;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescripition() {
	return Descripition;
}
public void setDescripition(String descripition) {
	Descripition = descripition;
}
public int getImage() {
	return image;
}
public void setImage(int image) {
	this.image = image;
}
public common(String name, String descripition, int image) {
	super();
	this.name = name;
	Descripition = descripition;
	this.image = image;
}
public common() {
	
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return getName();
}
   
}
