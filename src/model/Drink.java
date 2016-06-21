package model;

public class Drink extends common {
   public final static Drink[] drink={
	   new Drink("COFFEE", "COOFFEE USUALLY SELL AT COFFEE SHOP",2),
	   new Drink("BEER", "BEER USUALLY SELL AT SUPERMARKET", 2),
	   new Drink("WATER", "WATER USUALLY SELL AT STORES", 2)
   };

public Drink(String drinkName, String descripion, int hinhanh) {
	  super(drinkName,descripion,hinhanh);
}
 public Drink()
 {
	 
 } 
}
