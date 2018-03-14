import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class OrderQueue {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to Vu's Virtual Diner!");
		System.out.println();
		System.out.println("Menu");
		System.out.println("---------------");
		System.out.println();
		System.out.println("Hamburger");
		System.out.println("Fries");
		System.out.println("Scrambled Eggs");
		System.out.println("Pizza");
		System.out.println("Salad");
		System.out.println();
		System.out.println("You may only have 2 orders");
		System.out.println();
		
		
		
		
		int time = 0;
		String orderItem = null;
		
		while (time == 0) {
			System.out.println("What would you like to order?");
			orderItem = scnr.next();
			if (orderItem.equalsIgnoreCase("Hamburger")) {
				time = 5;
				} else if (orderItem.equalsIgnoreCase("Fries")) {
					time = 3;
				} else if (orderItem.equalsIgnoreCase("Scrambled Eggs")) {
					time = 7;
				} else if (orderItem.equalsIgnoreCase("Pizza")) {
					time = 10;
				} else if (orderItem.equalsIgnoreCase("Salad")) {
					time = 4;
				} else {
					System.out.println("Sorry, we do not serve that");
				}
		}
		System.out.println();
		System.out.println("Could we have your name please?");
		String name = scnr.next();
		Order order = new Order(orderItem, name, time);
		Queue<Order> queue = new LinkedList<Order>();
		queue.add(order);
		time = order.time();
		int totalTime = order.time();
		int currentTime = 0;
		
		while (queue.size() > 0) {
			
			for (Order item : queue) {
				totalTime += item.time();
			}
			totalTime -= time;
			
			System.out.println("There are " + queue.size() + " more item(s) in the queue.");
			System.out.println("The item being prepared right now is " + queue.element().item() + ".");
			System.out.println("It will take " + totalTime + " more minutes to complete your order");
			System.out.println();
			
			
			System.out.println("Is that all you want to order?");
			System.out.println("(Yes/No)");
			if (scnr.next().equalsIgnoreCase("No")) {
				while (time == 0) {
					System.out.print("What would you like to order?");
					orderItem = scnr.next();
					if (orderItem.equalsIgnoreCase("Hamburger")) {
						time = 5;
						} else if (orderItem.equalsIgnoreCase("Fries")) {
							time = 3;
						} else if (orderItem.equalsIgnoreCase("Scrambled Eggs")) {
							time = 7;
						} else if (orderItem.equalsIgnoreCase("Pizza")) {
							time = 10;
						} else if (orderItem.equalsIgnoreCase("Salad")) {
							time = 4;
						} else {
							System.out.println("Sorry, we do not serve that");
						}
				}
				Order order1 = new Order(orderItem, name, time);
				queue.add(order1);
			}
			if (queue.element().time() == time) {
				System.out.println(queue.element().name() + ", your " + queue.element().item() + " is ready");
				queue.remove();
				time = 0;
			} else {
				System.out.println("The first order will be ready in " + (queue.element().time() - time) + " minutes");
			}
			time++;
			System.out.println();
			}
		scnr.close();
		}
		
		
		
	}

