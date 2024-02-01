package se.yrgo.models;

import org.junit.jupiter.api.Test;
import se.yrgo.utilities.GenderType;
import se.yrgo.utilities.LoanStatus;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {

	//VG
	@Test
	public void testDueDate() {
		Book book1 = new Book(1, "Cosmos", "Carl Sagan", "3045603456704", "gg", 456);
		Customer customer1 = new Customer("Dr", "James", "Wilson", "Storgatan 10", "0702362514", "james.w@yahoo.com", 44564, GenderType.MALE);
		Loan loan1 = new Loan(3, customer1, book1);
		LocalDate testDueDate = LocalDate.now().plusDays(14);
		LoanStatus status = LoanStatus.CURRENT;

		assertEquals(testDueDate, loan1.getDueDate());
   }
}