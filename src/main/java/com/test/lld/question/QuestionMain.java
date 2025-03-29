package com.test.lld.question;

public class QuestionMain {

	public static void main(String[] args) {
		try
		{
			int a[] = new int[1];
			a[1] = 30 / 0;
			a[2] = 50;
		}catch(ArithmeticException e)
		{
			System.out.println("Exception1");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception 2");
		}
		catch (Exception e) {
			System.out.println("common");
		}
		System.out.println("rest");
	}
}
