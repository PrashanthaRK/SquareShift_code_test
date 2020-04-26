package com.squareshift;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputHandler {	
	ArrayList<Integer> seatType;
	void handleInput(){
		seatType = new ArrayList();
		Scanner in;
		try{		
			while(true){
				System.out.println("Enter the rows and columns :");
				in = new Scanner(System.in);
				String stream = in.nextLine();
				//String stream = "[3,4], [4,5], [2,3], [3,4]";
				stream = stream.replaceAll("\\s", ""); // Remove all empty spaces
				if (stream.charAt(0) != '[' || stream.charAt(stream.length()-1) != ']'){
					System.out.println("Wrong Input, Please try again");
					continue;
				}					
				//HashMap<Integer, Integer> map = parseInput(stream);
				ArrayList<Map> list = parseInput(stream);
				DataStorage.getInstance().setRowColMapList(list); //map);
				if(list != null)
					break;
				else
					System.out.println("Wrong Input, Please try again");
			}
			System.out.println("Enter the number of seats :");
			String strNoOfSeats = in.nextLine();
			//String strNoOfSeats = "30";
			int noOfSeats = Integer.parseInt(strNoOfSeats);
			DataStorage.getInstance().setNoOfSeats(noOfSeats);
			DecisionMaker decisionMaker = new DecisionMaker();
			int totalNoOfSeats = decisionMaker.getTotalNoOfSeats();
			DataStorage.getInstance().setTotalNoOfSeats(totalNoOfSeats);
			DataStorage.getInstance().setSeatsMapSequence(decisionMaker.populateSeatMap(seatType));
		}catch(Exception e){
			e.printStackTrace();
		}			
			
	}
	
	//HashMap<Integer, Integer> parseInput(String input){
	ArrayList<Map>parseInput(String input){
		try{
			
			ArrayList <Map> rowColMapList = new ArrayList();
			System.out.println("String:" +  input);
			String[] rowCols = input.split("\\[");
			for (String rowCol : rowCols){
				if (rowCol.isEmpty())
					continue;
				String[] blocks = rowCol.split("\\]");
				for (String block : blocks){						
					if (block.isEmpty())
						continue;					
					String [] rowAndCol = block.split(",");	
					if (rowAndCol.length == 0 || rowAndCol[0].isEmpty() || rowAndCol[1].isEmpty() || rowAndCol[0].compareTo(",") == 0)
						continue;
					System.out.println("Block :"+ block);
					Integer row = Integer.parseInt(rowAndCol[0]);
					Integer col = Integer.parseInt(rowAndCol[1]);
					Map<Integer, Integer> rowColMap = new HashMap();
					rowColMap.put(row, col);
					rowColMapList.add(rowColMap);
					// While filling up itself, populate whether seats are windows or aisle or middle seat
					for(int i = 0; i < col; i++){
						if (seatType.size() == 0  && i == 0)
						{
							seatType.add(new Integer(Common.WINDOW_SEAT)); // Windows Seat														
						}
						else if(i == 0 || i == col-1)
						{
							seatType.add(new Integer(Common.AISLE_SEAT)); // Aisle seat
						}
						else
							seatType.add(new Integer(Common.MIDDLE_SEAT)); 
					}
				}							
			}
			seatType.set(seatType.size()-1, Common.WINDOW_SEAT);
			return rowColMapList;//(HashMap<Integer, Integer>)rowColMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
