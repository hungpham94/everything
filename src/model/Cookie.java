package model;

public class Cookie extends common
{
   public final static Cookie[] cookie=
	{
	   new Cookie("bread","i usually eat break every morning",2),
	   new Cookie("Cube","i usually eat break every morning",2),
	   new Cookie("sanwitch","i usually eat break every morning",2)
	};
   public Cookie(String name,String descripition,int image)
   {
	   super(name, descripition, image);
   }
   public Cookie()
   {
	   super();
   }
}
