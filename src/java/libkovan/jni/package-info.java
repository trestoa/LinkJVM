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

/**
 * Package provides the low-level wrapper of the libkovan.
 * The class <code>LinkJVMJNI</code> is the lowest wrapper with
 * all native method definitions. <code>LinkJVM</code> wraps these
 * methods one more time and is used by all higher wrappers and classes.
 * In additional it includes an type definition generated using swig.
 * 
 * <strong>The classes containing this package should not be used!!</strong>
 */

package libkovan.jni;