/*Java program to demonstrate Singleton Pattern which ensures
 * a class only has one instance, and provide global point of access.
 * to it.
 *Author: Thabo Pitso
 *Date: 2022 May 04
 */

package jdp2e.singleton.demo;

final class Captain
{
	private static Captain captain;
	//We make the constructor private to prevent the use on "new"
	private Captain() {}
	
	public static synchronized Captain getCaptain()
	{
		//Lazy initialization
		if (captain == null)
		{
			captain = new Captain();
			System.out.println("New Captain is elected for your team.");
		}
		else
		{
			System.out.print("You already have a captain for your team. ");
			System.out.println("Send him for the toss.");
		}
		return captain;
	}
}
//WE cannot extend Captain class. The constructor is private in this case.
//Class B extends Captain{} // error

public class SingletonPatternExample 
{

	public static void main(String[] args) 
	{
		System.out.println("***Singleton Pattern Demo***\n");
		System.out.println("Trying to make a captain for your team: ");
		//Constructor is private. We cannot use "new" here.
		//Captain c3 = new Captain();//error
		
		Captain captain1 = Captain.getCaptain();
		System.out.println("Trying to make another captain for your team:");
		Captain captain2 = Captain.getCaptain();
		if (captain1 == captain2)
		{
			System.out.println("Captain1 and Captain2 are the same instance");
		}
		

	}

}
