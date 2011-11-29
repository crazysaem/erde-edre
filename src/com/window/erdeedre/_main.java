/**	Team5-Listener
 * 	Tobias König, Sebastian Böhm, Magnus Brühl, Marvin Melchiors und Samuel Schneider
 * 
 * BSD-License:
 * http://www.opensource.org/licenses/bsd-license.php
 * 
 * Github:	https://github.com/crazysaem/erde-edre
 * 
 * Für Software Engineering, Prof. Dr. Eckhard Kruse. Semester 03, DHBW Mannheim.
 * 
 * To compile: 
 * 1) add this Project to Eclipse
 * 2) Add JDK7 (7!) to the build path
 * 3) compile
 */

package com.window.erdeedre;

import com.window.erdeedre.skins.SkinChooser;

/**
 * Main Entry into the Program
 * @author Team5-Listener * 
 *
 */
public class _main {
	
	public static void main(String[] args) {
		new SkinChooser(2, true);
    }
}