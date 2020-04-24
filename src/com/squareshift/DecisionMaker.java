package com.squareshift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DecisionMaker {
	boolean isAsileSeat(int seatNo){
		Integer seatMap = (Integer)DataStorage.getInstance().getSeatsOccupiedSequence().get(seatNo);
		if(seatMap.intValue() == 1)
			return true;
		return false;
	}
	
	boolean isWindowsSeat(int seatNo){
		Integer seatMap = (Integer)DataStorage.getInstance().getSeatsOccupiedSequence().get(seatNo);
		if(seatMap.intValue() == 2)
			return true;
		return false;	
	}
	
	boolean isMiddleSeat(int seatNo){
		Integer seatMap = (Integer)DataStorage.getInstance().getSeatsOccupiedSequence().get(seatNo);
		if(seatMap.intValue() == 1 || seatMap.intValue() == 2 )
			return false;
		return true;
	}
	
	boolean isSetOccupied(int i){
		if (DataStorage.getSeatsOccupiedSequence(i) == -1)
			return true;
		return false;
	}
	
	int getNextSeatNo(int currentSeatNo){
		for(int i = 0; i < DataStorage.getInstance().getNoOfSeats(); i++){
			if(!isSetOccupied(i)){				
				if(isAsileSeat (i))
					return i;
			}
		}
		for(int i = 0; i < DataStorage.getInstance().getNoOfSeats(); i++){
			if(!isSetOccupied(i)){	
				if(isWindowsSeat (i))
					return i;
			}
		}
		for(int i = 0; i < DataStorage.getInstance().getNoOfSeats(); i++){
			if(!isSetOccupied(i)){
				return i;
			}			
		}
		return -1;
	}
	
	int getTotalNoOfSeats(){
		Map<Integer, Integer> map = DataStorage.getInstance().getRowColMap();
		int count = 0;
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
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
