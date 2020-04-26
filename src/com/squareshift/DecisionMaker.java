package com.squareshift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DecisionMaker {
	boolean isAsileSeat(int seatNo){
		Integer seatMap = (Integer)DataStorage.getInstance().getSeatsMapSequence().get(seatNo);
		if(seatMap.intValue() == Common.AISLE_SEAT)
			return true;
		return false;
	}
	
	boolean isWindowsSeat(int seatNo){
		Integer seatMap = (Integer)DataStorage.getInstance().getSeatsMapSequence().get(seatNo);
		if(seatMap.intValue() == Common.WINDOW_SEAT)
			return true;
		return false;	
	}
	
	boolean isMiddleSeat(int seatNo){
		Integer seatMap = (Integer)DataStorage.getInstance().getSeatsMapSequence().get(seatNo);
		if(seatMap.intValue() == Common.AISLE_SEAT || seatMap.intValue() == Common.WINDOW_SEAT )
			return false;
		return true;
	}
	
	boolean isSetOccupied(int i){
		if (DataStorage.getSeatsOccupiedSequence(i) != Common.NOT_OCCUPIED)
			return true;
		return false;
	}
	
	int getNextSeatNo(int currentSeatNo){
		for(int i = 0; i < DataStorage.getInstance().getTotalNoOfSeats(); i++){
			if(!isSetOccupied(i)){				
				if(isAsileSeat (i)){
					//ArrayList<Integer> array = DataStorage.getInstance().getSeatsOccupiedSequence();
					DataStorage.getInstance().setSeatsOccupiedSequence(i, Common.AISLE_SEAT);
					return i;
				}
			}
		}
		for(int i = 0; i < DataStorage.getInstance().getTotalNoOfSeats(); i++){
			if(!isSetOccupied(i)){	
				if(isWindowsSeat (i)){
					DataStorage.getInstance().setSeatsOccupiedSequence(i, Common.WINDOW_SEAT);
					return i;
				}
			}
		}
		for(int i = 0; i < DataStorage.getInstance().getTotalNoOfSeats(); i++){
			if(!isSetOccupied(i)){
				DataStorage.getInstance().setSeatsOccupiedSequence(i, Common.MIDDLE_SEAT);
				return i;
			}			
		}
		return -1;
	}
	
	int getTotalNoOfSeats(){
		ArrayList<Map> mapList = DataStorage.getInstance().getRowColMapList();
		int count = 0;
		for (Map map: mapList){
			Set set = map.keySet();
			Iterator iterator = set.iterator();
			Integer row = (Integer)iterator.next();
			Integer col = (Integer)map.get(row);
			count = count + row.intValue() * col.intValue();
		}
		return count;
	}
	
	ArrayList<Integer> populateSeatMap(ArrayList firstRowList){
		ArrayList<Integer> completeSeatMap = new ArrayList();
		int totalNoOfSeats = DataStorage.getInstance().getTotalNoOfSeats();
		for(int i = 0; i < totalNoOfSeats; i++){
			Integer currentSeatType = (Integer)firstRowList.get(i%firstRowList.size());
			completeSeatMap.add(new Integer(currentSeatType));			
		}
		return completeSeatMap;
	}
}
