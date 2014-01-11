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

/*
 * Copyright 2010 Cliff L. Biffle.  All Rights Reserved.
 * Use of this source code is governed by a BSD-style license that can be found
 * in the LICENSE file.
 */

package linkjvm.high.ardrone.navdata.javadrone;

import java.nio.ByteBuffer;

import linkjvm.high.ardrone.listeners.NavDataListener;
import linkjvm.high.ardrone.navdata.NavDataException;



public class JavadroneNavDataParser {
	private NavDataListener navDataListener;
	
	long lastSequenceNumber=1;
	
	//set listeners
	public void setNavDataListener(NavDataListener navDataListener){
		this.navDataListener=navDataListener;
	}
		
	public void parseNavData(ByteBuffer buffer) throws NavDataException{
		
		dispatch(buffer, buffer.remaining());
	}
	
	private void dispatch(ByteBuffer optionData, int length)
	{
		try
		{
			NavData navData = NavData.createFromData(optionData, length);
			
			if(navDataListener!=null){
				navDataListener.navDataUpdated(navData);
			}

		}
		catch (NavDataFormatException e)
		{
			e.printStackTrace();
		}
	}
}