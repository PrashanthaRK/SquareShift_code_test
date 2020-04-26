package com.squareshift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DataStorage {
	//static Map<Integer, Integer> rowColmapper;
	static ArrayList<Map> mapList;
	static Map<Integer, Integer> seatPosMapper;
	static int noOfSeats, totalNoOfSeats;
	static ArrayList<Integer> seatsMapSequence;
	static ArrayList<Integer> seatsOccupiedSequence;
	private static DataStorage dataStorage= new DataStorage();
	public DataStorage(){		
	}
	public static DataStorage getInstance(){
		if (dataStorage == null)
			dataStorage = new DataStorage();
		return dataStorage;
	}
	public static void setRowColMapList(ArrayList<Map> list){
		mapList = list;
	}
	public static void setNoOfSeats(int seats){
		noOfSeats = seats;
	}
	public static int getNoOfSeats(){
		return noOfSeats;		
	}
	public static ArrayList<Map> getRowColMapList(){
		return mapList;
	}
	public static void setTotalNoOfSeats(int seats){
		totalNoOfSeats = seats;
	}
	public static int getTotalNoOfSeats(){
		return totalNoOfSeats;		
	}

	public static int getSeatsOccupiedSequence(int seatNo){
		return seatsOccupiedSequence.get(seatNo).intValue();	
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

	public void setSeatsOccupiedSequence(int position, int value){
		seatsOccupiedSequence.set(position, value);
	}

	public ArrayList<Integer> getSeatsOccupiedSequence(){
		return seatsOccupiedSequence;
	}
	
	
	public ArrayList<Integer> getSeatsMapSequence(){
		return seatsMapSequence;
	}
	public static int getSeatsMapdSequence(int seatNo){
		return seatsMapSequence.get(seatNo).intValue();	
	}
	
	public void setSeatsMapSequence( ArrayList<Integer> array){
		seatsMapSequence = array;
	}
}
