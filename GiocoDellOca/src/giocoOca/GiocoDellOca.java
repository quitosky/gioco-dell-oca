package giocoOca;



import java.awt.GridLayout;

import javax.swing.JFrame;

public class GiocoDellOca {
	 /*Gioco dell'oca
	    Copyright (C) 2021  Guido Iannì

	    This program is free software: you can redistribute it and/or modify
	    it under the terms of the GNU General Public License as published by
	    the Free Software Foundation, either version 3 of the License, or
	    (at your option) any later version.

	    This program is distributed in the hope that it will be useful,
	    but WITHOUT ANY WARRANTY; without even the implied warranty of
	    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	    GNU General Public License for more details.

	    You should have received a copy of the GNU General Public License
	    along with this program.  If not, see <https://www.gnu.org/licenses/>. 
		 */
	JFrame frameObj;

	GiocoDellOca() {
		Tabellone tabellone = new Tabellone();
		PannelloDiGioco pannelloDiGioco = new PannelloDiGioco(tabellone);

		frameObj = new JFrame();
		frameObj.add(pannelloDiGioco);
		frameObj.add(tabellone);
		frameObj.setLayout(new GridLayout(1, 2));
		frameObj.setExtendedState(frameObj.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frameObj.setVisible(true);
	}

	public static void main(String[] args) {
		new GiocoDellOca();

	}

}
