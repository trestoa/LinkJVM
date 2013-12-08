/*
 * This file is part of LinkJVM.
 *
 * Java Framework for the KIPR Link
 * Copyright (C) 2013 Markus Klein<m@mklein.co.at>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package old.linkjvm.events;

import java.util.ArrayList;
import java.util.Iterator;

public class EventManager implements Runnable{
	private ArrayList<Event> eventList;
	private boolean stop;	
	
	public EventManager(){
		eventList = new ArrayList<Event>();
		stop = false;
	}

	public void run(){
		while(!stop){
			Iterator<Event> it = eventList.iterator();
			while(it.hasNext()){
				Event nextEvent = it.next();
				if(nextEvent.proof()){
					nextEvent.trigger();
				}
			}
		}
	}
	
	public void start(){
		Thread t = new Thread(this);
		t.start();
	}

	public void stop(){
		stop = true;
	}

	public boolean registerEvent(Event e){
		return eventList.add(e);
	}

	public boolean unregisterEvent(Event e){
		return eventList.remove(e);
	}
}
