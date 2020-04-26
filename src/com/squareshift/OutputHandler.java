package com.squareshift;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OutputHandler {
	ArrayList<Integer> seatingSequence;
	
	void printOutput(){
		try{
			
			DecisionMaker decisionMaker = new DecisionMaker();
			//seatingSequence = new int[decisionMaker.getTotalNoOfSeats()];
			seatingSequence = new ArrayList();
			ArrayList<Integer> seatsOccupiedList = new ArrayList();
			for(int i = 0; i < DataStorage.getInstance().getTotalNoOfSeats(); i++){
				seatsOccupiedList.add(new Integer(Common.NOT_OCCUPIED));
			}
			DataStorage.getInstance().setSeatsOccupiedSequence(seatsOccupiedList);
			System.out.println("No of seats " + DataStorage.getInstance().getNoOfSeats());
			for(int i = 0; i < DataStorage.getInstance().getNoOfSeats(); i++){
				seatingSequence.add(new Integer(decisionMaker.getNextSeatNo(i)));
				
			}
			for(int i = DataStorage.getInstance().getNoOfSeats(); i < decisionMaker.getTotalNoOfSeats(); i++)
				seatingSequence.add(Common.NOT_OCCUPIED);
			
			//for(int i = 0; i < seatingSequence.length; i++)
			//	System.out.println(i + "	:" +  seatingSequence[i] );
			//ArrayList <Integer> list = DataStorage.getInstance().getSeatsOccupiedSequence();
			ArrayList<Map> mapList = DataStorage.getInstance().getRowColMapList();
			int count = 0;
			ArrayList<Integer> columnsGroupList = new ArrayList();
			for (Map map: mapList){
				Set set = map.keySet();
				Iterator iterator = set.iterator();
				Integer row = (Integer)iterator.next();
				columnsGroupList.add((Integer)map.get(row));
			}
			int groupColIndex = 0;
			int noOfColumns = columnsGroupList.get(groupColIndex);
			int columnIterator = -1;
			for(int i = 0; i < DataStorage.getInstance().getTotalNoOfSeats(); i++){
				int seatNum =seatingSequence.indexOf(i)+1;
				if(columnIterator == noOfColumns-1){
					if (groupColIndex == columnsGroupList.size()-1){
						groupColIndex = 0;
						System.out.println();
						if (seatNum == 0)
							System.out.print(" " +   "-");
						else
							System.out.print(" " +   (seatingSequence.indexOf(i)+1));						
					}else{
						groupColIndex++;
						if (seatNum == 0)
							System.out.print(" " +   "-");
						else													
							System.out.print("     " +   (seatingSequence.indexOf(i)+1));
					}
					columnIterator = 0;
					noOfColumns = columnsGroupList.get(groupColIndex);
				}else{
					columnIterator++;
					if (seatNum == 0)
						System.out.print(" " +   "-");
					else					
						System.out.print(" " +   (seatingSequence.indexOf(i)+1));
				}					
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
