package model;

public class Food extends common{
	   
	public Food(String foodName, String descripion, int hinhanh) {
		super(foodName,descripion,hinhanh);
	}
	public Food()
	{
		super();
	}
	public final static Food[] food=
		{
		 new Food("fried eeg","wonderfull", 2),
		 new Food("chicken boil","delicious", 2),
		 new Food("snake meat","terrible", 2)
		};
	
	}
