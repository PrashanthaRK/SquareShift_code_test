package com.squareshift;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InputHandllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testHandleInput() {
		InputHandler tester = new InputHandler();
		tester.handleInput();		
	}

	@Test
	public void testParseInput() {
		InputHandler tester = new InputHandler();
		tester.parseInput("[3,4], [4,5], [2,3], [3,4]");
		DecisionMaker decisionMaker = new DecisionMaker();
		assertTrue(!decisionMaker.isWindowsSeat(1));
		assertTrue(!decisionMaker.isMiddleSeat(2));
		assertTrue(!decisionMaker.isAsileSeat(3));
		assertTrue(!decisionMaker.isSetOccupied(3));
		assertTrue(!decisionMaker.isAsileSeat(4));
		assertTrue(!decisionMaker.isMiddleSeat(5));
		assertTrue(!decisionMaker.isMiddleSeat(6));
		assertTrue(!decisionMaker.isMiddleSeat(7));
		assertTrue(!decisionMaker.isAsileSeat(8));
		assertTrue(!decisionMaker.isAsileSeat(9));
		assertTrue(!decisionMaker.isAsileSeat(10));
		assertTrue(!decisionMaker.isAsileSeat(11));
		assertTrue(!decisionMaker.isAsileSeat(12));
		assertTrue(!decisionMaker.isAsileSeat(13));
		assertTrue(!decisionMaker.isMiddleSeat(14));
		assertTrue(!decisionMaker.isWindowsSeat(15));
		assertTrue(!decisionMaker.isMiddleSeat(16));
		assertTrue(!decisionMaker.isAsileSeat(17));
		assertTrue(!decisionMaker.isAsileSeat(18));
		assertTrue(!decisionMaker.isMiddleSeat(19));
	}

}
