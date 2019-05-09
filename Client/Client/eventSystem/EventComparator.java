package eventSystem;

import java.util.Comparator;

import events.Event;

public class EventComparator implements Comparator<Event>{
	
	@Override
    public int compare(Event a, Event b){
		
		
		if(a.timeStamp_FrameNumber == b.timeStamp_FrameNumber){
			if(a.priority > b.priority){
				return 1;
			}else{
				return -1;
			}
		}
		
		a.age++;
		b.age++;
		
		if(a.timeStamp_FrameNumber < b.timeStamp_FrameNumber){
			return -1;
		}else{
			return 1;
		}
		
	}

}
