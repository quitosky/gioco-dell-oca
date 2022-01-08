package giocoOca;



import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Casella extends JComponent {

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
	 
	private static final long serialVersionUID = -1365499437168100383L;
	String testo;
	boolean posizGioca=false;
	List<Integer> caselleOca = Arrays.asList(5, 9, 14, 18, 23, 27);

	public Casella() {
	}

	public Casella(String testo,boolean posizGioca) {
		super();
		this.posizGioca=posizGioca;
		this.testo = testo;
	}

	@Override
	public void paintComponent(Graphics g) {
		String text = testo;
		int centerX = 30, centerY = 20;
		int ovalWidth = 55, ovalHeight = 40;
		if(posizGioca) {
			g.setColor(Color.RED);
			posizGioca=false;
		}else {
			g.setColor(Color.BLUE);			
		}
		FontMetrics fm = g.getFontMetrics();
		double textWidth = fm.getStringBounds(text, g).getWidth();
		if (testo.equals("6")) {
			try {
				URL url = getClass().getResource("..//img//ponte_30.png");
				BufferedImage bImg = ImageIO.read(new File(url.getPath()));
				
				g.drawImage(bImg,  10, 20 , this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (isInteger(testo,10) && Arrays.stream(caselleOca.toArray()).anyMatch(Integer.valueOf(testo)::equals)){
		
			try {
				URL url = getClass().getResource("..//img//oca_30.png");
				BufferedImage bImg = ImageIO.read(new File(url.getPath()));
				
				g.drawImage(bImg,  10, 20 , this);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else {
		
			g.fillOval(centerX - ovalWidth / 2, centerY - ovalHeight / 2, ovalWidth, ovalHeight);		
			g.setColor(Color.WHITE);
			g.drawString(text, (int) (centerX - textWidth / 2), (int) (centerY + fm.getMaxAscent() / 2));

		}
	}

	public static boolean isInteger(String s, int radix) {
		if (s.isEmpty())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}
}
