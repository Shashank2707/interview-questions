package com.test.lld.dsaquestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Problem : 
 * 
 * Please help me with a solution
 * 
 * Stock Exchange The Challenge
 * 
 * Implement an order matching system for a stock exchange. 
 * Traders place Buy and Sell orders for a stock indicating the price and quantity. 
 * Each order gets entered into the exchange’s order-book and remains there until it is matched. 
 * Order matching is attempted whenever a new order is added.
 * The exchange follows a FirstInFirstOut Price-Time order-matching rule, which states that: 
 * "The first order in the order-book at a price level is the first order matched. 
 * All orders at the same price level are filled according to time priority." 
 * The exchange works like a market where lower selling prices and higher buying prices get priority.
 * 
 * A trade is executed when a buy price is greater than or equal to a sell price. 
 * The trade is recorded at the price of the sell order regardless of the price of the buy order.
 * 
 * Your program should take as input:
 * Order ID.
 * Time.
 * Stock.
 * Buy/Sell.
 * Price.
 * Quantity.
 * 
 * The output should be
 * Buy Order ID
 * Sell Price
 * Quantity
 * Sell Order ID
 * Input format: <buy/sell>
 * 
 * Output format:
 * SAMPLE INPUT-OUTPUT
 * 
 * INPUT:
 * #1 09:45 BAC sell 240.12 100
 * #2 09:46 BAC sell 237.45 90
 * #3 09:47 BAC buy 238.10 110
 * #4 09:48 BAC buy 237.80 10
 * #5 09:49 BAC buy 237.80 40
 * #6 09:50 BAC sell 236.00 50
 * 
 * OUTPUT:
 * #3 237.45 90 #2
 * #3 236.00 20 #6
 * #4 236.00 10 #6
 * #5 236.00 20 #6
 * 
 * Input needs to be read from a text file, and output should be printed to console. 
 * Your program should execute and take the location to the test file as parameter.
 * */

// Order class to store details of each order
class Order {
    int id;
    String time;
    String stock;
    String type;  // buy or sell
    double price;
    int quantity;

    public Order(int id, String time, String stock, String type, double price, int quantity) {
        this.id = id;
        this.time = time;
        this.stock = stock;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
}

public class StockExchange {

    public static void main(String[] args) {
        // Read the file path from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        processOrders(filePath);

        scanner.close();
    }

    private static void processOrders(String filePath) {
        // Priority Queue for Buy Orders (MaxHeap by Price, FIFO by Time)
    	/**
    	 * This means that, by default, the highest price buy order will have the 
    	 * highest priority (it will be dequeued first).
    	 * 
    	 * However, when two orders have the same price, we fall back to the FIFO (First In First Out) rule.
    	 *  This is achieved by using the order's id. 
    	 *  The order with the smaller id (i.e., the one that came in earlier) is given higher priority.
    	 */
        PriorityQueue<Order> buyOrders = new PriorityQueue<>(
                (o1, o2) -> (o1.price == o2.price) ? Integer.compare(o1.id, o2.id) : Double.compare(o2.price, o1.price)
        );

        
        
        // Priority Queue for Sell Orders (MinHeap by Price, FIFO by Time)
        //This means that the lowest price sell order will have the highest priority (it will be dequeued first).
        //Similar to buy orders, if two sell orders have the same price, we again 
        //fall back to FIFO based on the id of the order.
        PriorityQueue<Order> sellOrders = new PriorityQueue<>(
                (o1, o2) -> (o1.price == o2.price) ? Integer.compare(o1.id, o2.id) : Double.compare(o1.price, o2.price)
        );

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0].substring(1));  // Extracting the order ID (e.g., #1)
                String time = parts[1];
                String stock = parts[2];
                String type = parts[3];
                double price = Double.parseDouble(parts[4]);
                int quantity = Integer.parseInt(parts[5]);

                Order newOrder = new Order(id, time, stock, type, price, quantity);

                if (type.equalsIgnoreCase("buy")) {
                    processBuyOrder(newOrder, sellOrders, buyOrders);
                } else if (type.equalsIgnoreCase("sell")) {
                    processSellOrder(newOrder, buyOrders, sellOrders);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Process a Buy Order: Try to match with existing Sell Orders
    private static void processBuyOrder(Order buyOrder, PriorityQueue<Order> sellOrders, PriorityQueue<Order> buyOrders) {
        while (!sellOrders.isEmpty() && buyOrder.quantity > 0) {
            Order sellOrder = sellOrders.peek();

            // If no match is possible (buy price < sell price), break
            if (buyOrder.price < sellOrder.price) {
                break;
            }

            sellOrders.poll(); // Remove matched sell order

            // Execute trade at sell order's price
            int tradedQty = Math.min(buyOrder.quantity, sellOrder.quantity);
//            System.out.printf("#%d %.2f %d #%d%n", buyOrder.id, sellOrder.price, tradedQty, sellOrder.id);
            System.out.println("#" + buyOrder.id + " " + String.format("%.2f", sellOrder.price) + " " + tradedQty + " #" + sellOrder.id);


            // Update remaining quantities
            buyOrder.quantity -= tradedQty;
            sellOrder.quantity -= tradedQty;

            // If there's leftover sell order quantity, put it back
            if (sellOrder.quantity > 0) {
                sellOrders.add(sellOrder);
            }
        }

        // If buy order is not fully matched, add it to the Buy queue
        if (buyOrder.quantity > 0) {
            buyOrders.add(buyOrder);
        }
    }

    // Process a Sell Order: Try to match with existing Buy Orders
    private static void processSellOrder(Order sellOrder, PriorityQueue<Order> buyOrders, PriorityQueue<Order> sellOrders) {
        while (!buyOrders.isEmpty() && sellOrder.quantity > 0) {
            Order buyOrder = buyOrders.peek();

            // If no match is possible (buy price < sell price), break
            if (buyOrder.price < sellOrder.price) {
                break;
            }

            buyOrders.poll(); // Remove matched buy order

            // Execute trade at sell order's price
            int tradedQty = Math.min(buyOrder.quantity, sellOrder.quantity);
//            System.out.printf("#%d %.2f %d #%d%n", buyOrder.id, sellOrder.price, tradedQty, sellOrder.id);
            System.out.println("#" + buyOrder.id + " " + String.format("%.2f", sellOrder.price) + " " + tradedQty + " #" + sellOrder.id);

            // Update remaining quantities
            sellOrder.quantity -= tradedQty;
            buyOrder.quantity -= tradedQty;

            // If there's leftover buy order quantity, put it back
            if (buyOrder.quantity > 0) {
                buyOrders.add(buyOrder);
            }
        }

        // If sell order is not fully matched, add it to the Sell queue
        if (sellOrder.quantity > 0) {
            sellOrders.add(sellOrder);
        }
    }
}
