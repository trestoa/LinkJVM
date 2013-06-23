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

package linkjvm.ardrone.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class ListenerList<E> extends ArrayList<E> {
	
	private static final long serialVersionUID = 8391904731472086730L;

	@Override
	public boolean add(E e) throws ListenerListException, UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException{
		Iterator<E> it = this.iterator();
		while(it.hasNext()){
			if(it.next() == e){
				throw new ListenerListException("");
			}
		}
		return super.add(e);
	}
}
