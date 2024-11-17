package labs.lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Contains data and does some analysis about all customers in a store
 */
public class CustomerData {

	ArrayList<Customer> custs;

	/**
	 * Constructs a new CustomerData object from the data in the file
	 * 
	 * If a file contains more than one customer with the same name, the data from
	 * the last one read overwrites the previously read data.
	 */
	public CustomerData(String fileName) {
		custs = new ArrayList<Customer>();
		try (Scanner in = new Scanner(new File(fileName))) {
			while (in.hasNextLine()) {
				String info = in.nextLine();
				String[] cust_info = info.split(" ");
				
				String name = cust_info[0];
				double spent = Double.valueOf(cust_info[1]);
				Customer.CustomerType type = Customer.CustomerType.PERSONAL;
				if (cust_info[2].equals("CORPORATE")) {
					type = Customer.CustomerType.CORPORATE;
				}
				
				boolean dup = false;
				for (Customer c : custs) {
					if (c.getName().equals(name)) {
						dup = true;
					}
				}
				if (dup) {
					for (Customer c : custs) {
						if (c.getName().equals(name)) {
							c.setAmountSpent(spent);
							c.setCustomerType(type);
						}
					}
				} else {
					custs.add(new Customer(name, spent, type));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
		}
	}


	/**
	 * Gets the customer(s) with the highest amount spent.
	 * 
	 * @return a list containing the customer(s) with the highest amount spent. If
	 *         there is only 1 customer with the highest amount, the list contains
	 *         only that one customer. If there are > 1 customer with the highest
	 *         amount, the list contains them all, in an undetermined order.
	 */
	public List<Customer> getBestCustomer() {
		ArrayList<Customer> best = new ArrayList<Customer>();
		double max = 0;
		for (Customer c : custs) {
			max = Math.max(max, c.getAmountSpent());
		}
		
		for (Customer c: custs) {
			if (c.getAmountSpent() == max) {
				best.add(c);
			}
		}
		
		return best;
	}


	/**
	 * Gets the customer(s) of the given customer type with the highest amount
	 * spent.
	 * 
	 * @return a list containing the customer(s) of the given type with the highest
	 *         amount spent. If there is only 1 customer with the highest amount,
	 *         the list contains only that one customer. If there are > 1 customer
	 *         with the highest amount, the list contains them all, in an
	 *         undetermined order.
	 */
	public List<Customer> getBestCustomer(Customer.CustomerType custType) {
		ArrayList<Customer> val = new ArrayList<Customer>();
		for (Customer c : custs) {
			if (c.getCustomerType().equals(custType)) {
				val.add(c);
			}
		}
		
		ArrayList<Customer> best = new ArrayList<Customer>();
		double max = 0;
		for (Customer c : val) {
			max = Math.max(max, c.getAmountSpent());
		}
		
		for (Customer c: val) {
			if (c.getAmountSpent() == max) {
				best.add(c);
			}
		}
		
		return best;
	}

}
