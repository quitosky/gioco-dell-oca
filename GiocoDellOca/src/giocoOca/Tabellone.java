package giocoOca;



import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JPanel;

public class Tabellone extends JPanel {

	/**
	 *  *Gioco dell'oca
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

	private static final long serialVersionUID = 4653517554113955768L;


	public Tabellone() {
		super();
		this.setLayout(new GridLayout(8, 8));
		for (int i = 1; i < 64; i++) {
			Casella casella = new Casella("" + i, false);
			this.add(casella);

		}

	}

	public Tabellone(int posizione, String nome) {
		super();
		this.setLayout(new GridLayout(8, 8));
		for (int i = 1; i < 64; i++) {
			if (i == posizione) {
				Casella casella;
				if (nome.length() > 4) {
					casella = new Casella(nome.substring(0, 5), true);
				} else {
					casella = new Casella(nome, true);
				}
				this.add(casella);
			} else {
				Casella casella = new Casella("" + i, false);
				this.add(casella);
			}

		}

	}


	public Tabellone(Map<String, Integer> mappaPunteggi) {
		super();
		this.setLayout(new GridLayout(8, 8));

		for (int i = 1; i < 64; i++) {
			Casella casella;
			if (mappaPunteggi.containsValue(i)) {
				for (Map.Entry<String, Integer> entry : mappaPunteggi.entrySet()) {
					System.out.println(entry.getKey());
					if (entry.getKey().length() > 4 && entry.getValue() == i) {
						casella = new Casella(entry.getKey().substring(0, 5), true);
						this.add(casella);
					} else if (entry.getValue() == i) {
						casella = new Casella(entry.getKey(), true);
						this.add(casella);
					}

				}

			} else {
				casella = new Casella("" + i, false);
				this.add(casella);
			}

		}

	}
}
