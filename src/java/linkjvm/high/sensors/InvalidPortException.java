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

package linkjvm.high.sensors;

/**
 * This class provides the InvalidPortException which should be thrown, 
 * when the a specified port does not exist.
 * @since 2.0.0
 * @version 2.0.0
 * @author Markus Klein
 */
public class InvalidPortException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2317447340566282872L;
	
	/**
	 * Constructs a new InvalidPortException
	 */
	public InvalidPortException(){
		super();
	}
	
	/**
	 * Constructs a new InvalidPortException
	 * @param message exception message
	 */
	public InvalidPortException(String message){
		super(message);
	}
}
