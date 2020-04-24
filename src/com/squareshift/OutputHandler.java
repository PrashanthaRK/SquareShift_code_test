package com.squareshift;

public class OutputHandler {
	int [] seatingSequence;
	
	void printOutput(){
		DecisionMaker decisionMaker = new DecisionMaker();
		seatingSequence = new int[decisionMaker.getTotalNoOfSeats()];
		
		System.out.println("No of seats " + DataStorage.getInstance().getNoOfSeats());
		for(int i = 0; i < DataStorage.getInstance().getNoOfSeats(); i++){
			seatingSequence[i] = decisionMaker.getNextSeatNo(i); 
		}
		for(int i = DataStorage.getInstance().getNoOfSeats(); i < decisionMaker.getTotalNoOfSeats(); i++)
			seatingSequence[i] = -1;
		
		for(int i = 0; i < seatingSequence.length; i++)
			System.out.println( i + "");

	}
}
