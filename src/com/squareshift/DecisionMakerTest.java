package com.squareshift;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DecisionMakerTest {
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InputHandler inputTester = new InputHandler();
		inputTester.parseInput("[3,4], [4,5], [2,3], [3,4]");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsAsileSeatInt() {
		DecisionMaker tester = new DecisionMaker();
		assertEquals(-1+"", tester.getNextSeatNo(0), "Initialization failed");
		assertEquals(-1+"", tester.getNextSeatNo(10), "Getting next seat number failed");
		assertNotEquals(-1+"", tester.getNextSeatNo(100), "Getting next seat number failed");
		
	}

	@Test
	public void testIsWindowsSeat() {
		DecisionMaker tester = new DecisionMaker();
		
		assertTrue(!tester.isWindowsSeat(0));
		assertTrue(tester.isWindowsSeat(1));
	}

	@Test
	public void testIsAsileSeat() {
		DecisionMaker tester = new DecisionMaker();
		assertTrue(tester.isAsileSeat(0));
		
	}

	@Test
	public void testGetNextSeatNo() {
		DecisionMaker tester = new DecisionMaker();
		assertNotEquals(0+"", tester.getNextSeatNo(0), "Returned the same seat no");
		assertNotEquals(10+"", tester.getNextSeatNo(10), "Returned the same seat no");
		assertNotEquals(-1+"", tester.getNextSeatNo(0), "Logic failure");
	}

	@Test
	public void testGetTotalNoOfSeats() {
		fail("Not yet implemented");
	}

}
