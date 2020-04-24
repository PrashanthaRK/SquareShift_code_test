package com.squareshift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DataStorage {
	static Map<Integer, Integer> rowColmapper;	
	static Map<Integer, Integer> seatPosMapper;
	static int noOfSeats, totalNoOfSeats;
	static ArrayList<Integer> seatsOccupiedSequence;
	private static DataStorage dataStorage= new DataStorage();
	public DataStorage(){		
	}
	public static DataStorage getInstance(){
		if (dataStorage == null)
			dataStorage = new DataStorage();
		return dataStorage;
	}
	public static void setRowColMap(HashMap map){
		rowColmapper = (Map)map;
	}
	public static void setNoOfSeats(int seats){
		noOfSeats = seats;
	}
	public static int getNoOfSeats(){
		return noOfSeats;		
	}
	public static Map getRowColMap(){
		return rowColmapper;
	}
	public static void setTotalNoOfSeats(int seats){
		totalNoOfSeats = seats;
	}
	public static int getTotalNoOfSeats(){
		return totalNoOfSeats;		
	}

	public static int getSeatsOccupiedSequence(int seatNo){
		return seatsOccupiedSequence.get(seatNo);	
	}
	
	public static Map getSeatPosMapper(){
		return seatPosMapper;
	}
	
	public static void setSeatPosMapper(Map map){
		 seatPosMapper= map;
	}
	public void setSeatsOccupiedSequence( ArrayList<Integer> array){
		seatsOccupiedSequence = array;
	}
	public ArrayList<Integer> getSeatsOccupiedSequence(){
		return seatsOccupiedSequence;
	}
}
