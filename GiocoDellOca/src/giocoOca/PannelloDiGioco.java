package giocoOca;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PannelloDiGioco extends JPanel {

	/**
	 *Gioco dell'oca
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
	private static final long serialVersionUID = 8481387482188234928L;
	JTextField nomeGiocatoreTxf;
	JLabel nomeGiocatoreLbl;
	JLabel risultatoDado1Giocatore1lbl;
	JLabel risultatoDado2Giocatore1lbl;
	JTextField risultatoDado1Giocatore1Txf;
	JTextField risultatoDado2Giocatore1Txf;
	JPanel risultatoDadoGiocatore1Pnl;
	JLabel giocatore1Lbl;
	JButton btnLanciaDadoGiocatore1;
	JButton btnMuoviGiocatore1;

	JLabel risultatoDado1Giocatore2lbl;
	JLabel risultatoDado2Giocatore2lbl;
	JTextField risultatoDado1Giocatore2Txf;
	JTextField risultatoDado2Giocatore2Txf;
	JPanel risultatoDadoGiocatore2Pnl;
	JLabel giocatore2Lbl;
	JButton btnLanciaDadoGiocatore2;
	JButton btnMuoviGiocatore2;

	JLabel risultatoDado1Giocatore3lbl;
	JLabel risultatoDado2Giocatore3lbl;
	JTextField risultatoDado1Giocatore3Txf;
	JTextField risultatoDado2Giocatore3Txf;
	JPanel risultatoDadoGiocatore3Pnl;
	JLabel giocatore3Lbl;
	JButton btnLanciaDadoGiocatore3;
	JButton btnMuoviGiocatore3;

	JLabel risultatoDado1Giocatore4lbl;
	JLabel risultatoDado2Giocatore4lbl;
	JTextField risultatoDado1Giocatore4Txf;
	JTextField risultatoDado2Giocatore4Txf;
	JPanel risultatoDadoGiocatore4Pnl;
	JLabel giocatore4Lbl;
	JButton btnLanciaDadoGiocatore4;
	JButton btnMuoviGiocatore4;

	JButton btnInizia;
	JButton btnAggiungi;
	List<String> giocatori;
	Tabellone tabellone;
	Map<String, Integer> giocatoriPunteggi = new HashMap<>();
	List<Integer> caselleOca ;
	Integer precPosGicatore1=0;
	Integer precPosGicatore2=0;
	Integer precPosGicatore3=0;
	Integer precPosGicatore4=0;
	
	public PannelloDiGioco() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PannelloDiGioco(Tabellone tabellone) {
		this.tabellone = tabellone;
		giocatori = new ArrayList<String>();
		this.setLayout(new GridLayout(6, 4));
		nomeGiocatoreLbl = new JLabel("Nome giocatore");
		this.add(nomeGiocatoreLbl);
		btnAggiungi = new JButton("Aggiungi");
		btnInizia = new JButton("Inizia");
		btnLanciaDadoGiocatore1 = new JButton();
		btnMuoviGiocatore1 = new JButton();

		nomeGiocatoreTxf = new JTextField();
		this.add(nomeGiocatoreTxf);
		btnInizia.setEnabled(false);
		this.setVisible(true);
		this.add(btnAggiungi);
		this.add(btnInizia);
		for (int i = 0; i < 15; i++) {
			this.add(new JLabel());
		}

		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nomeGiocatoreTxf.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "devi inserire un nome!!");
				} else {

					aggiungiGiocatore(nomeGiocatoreTxf.getText());
				}
			}

			private void aggiungiGiocatore(String nomeGiocatore) {
				boolean presente = false;
				for (String giocatore : giocatori) {
					if (giocatore.equalsIgnoreCase(nomeGiocatore)) {
						presente = true;
					}
				}
				if (!presente) {
					giocatori.add(nomeGiocatore);
					JOptionPane.showMessageDialog(new JFrame(), "aggiunto giocatore " + nomeGiocatore);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "gicatore già prersente!!");
				}
				nomeGiocatoreTxf.setText("");
				if (giocatori.size() > 1) {
					btnInizia.setEnabled(true);

				}

				if (giocatori.size() == 4) {
					btnAggiungi.setEnabled(false);

				}
			}
		});

		btnInizia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame(giocatori.size());
				;
			}
		});

	}

	public void nascondiPannello(String numGiocatori) {
		this.setVisible(false);

	}

	JLabel lbgGiocatore;

	private void startGame(int giocNum) {
		this.removeAll();
		btnMuoviGiocatore3 = new JButton();
		btnMuoviGiocatore4 = new JButton();
		btnLanciaDadoGiocatore3 = new JButton();
		btnLanciaDadoGiocatore4 = new JButton();
		risultatoDado1Giocatore1lbl = new JLabel("Dado 1: ");
		risultatoDado2Giocatore1lbl = new JLabel("Dado 2: ");
		risultatoDado1Giocatore1Txf = new JTextField("0");
		risultatoDado2Giocatore1Txf = new JTextField("0");
		risultatoDadoGiocatore1Pnl = new JPanel();
		giocatore1Lbl = new JLabel(giocatori.get(0));
		btnLanciaDadoGiocatore1 = new JButton("lancia il dado");
		btnMuoviGiocatore1 = new JButton("Muovi " + giocatori.get(0));
		risultatoDadoGiocatore1Pnl.add(risultatoDado1Giocatore1lbl);
		risultatoDadoGiocatore1Pnl.add(risultatoDado2Giocatore1Txf);
		risultatoDadoGiocatore1Pnl.add(risultatoDado2Giocatore1lbl);
		risultatoDadoGiocatore1Pnl.add(risultatoDado1Giocatore1Txf);

		risultatoDado1Giocatore2lbl = new JLabel("Dado 1: ");
		risultatoDado2Giocatore2lbl = new JLabel("Dado 2: ");
		risultatoDado2Giocatore2Txf = new JTextField("0");
		risultatoDado1Giocatore2Txf = new JTextField("0");
		risultatoDadoGiocatore2Pnl = new JPanel();
		giocatore2Lbl = new JLabel(giocatori.get(1));
		btnLanciaDadoGiocatore2 = new JButton("lancia il dado");
		btnMuoviGiocatore2 = new JButton("Muovi " + giocatori.get(1));
		risultatoDadoGiocatore2Pnl.add(risultatoDado1Giocatore2lbl);
		risultatoDadoGiocatore2Pnl.add(risultatoDado1Giocatore2Txf);
		risultatoDadoGiocatore2Pnl.add(risultatoDado2Giocatore2lbl);
		risultatoDadoGiocatore2Pnl.add(risultatoDado2Giocatore2Txf);

		this.setLayout(new GridLayout(6, 3));
		for (int i = 0; i < 3; i++) {
			this.add(new JLabel());
		}

		this.add(btnLanciaDadoGiocatore1);
		this.add(risultatoDadoGiocatore1Pnl);
		this.add(btnMuoviGiocatore1);

		this.add(btnLanciaDadoGiocatore2);
		this.add(risultatoDadoGiocatore2Pnl);
		this.add(btnMuoviGiocatore2);
		switch (giocNum) {
		case 2:
			for (int i = 0; i < 6; i++) {
				this.add(new JLabel());
			}
			break;

		case 3:
			risultatoDado1Giocatore3lbl = new JLabel("Dado 1: ");
			risultatoDado2Giocatore3lbl = new JLabel("Dado 2: ");
			risultatoDado2Giocatore3Txf = new JTextField("0");
			risultatoDado1Giocatore3Txf = new JTextField("0");
			risultatoDadoGiocatore3Pnl = new JPanel();
			giocatore3Lbl = new JLabel(giocatori.get(2));
			btnLanciaDadoGiocatore3 = new JButton("lancia il dado");
			btnMuoviGiocatore3 = new JButton("Muovi " + giocatori.get(2));
			risultatoDadoGiocatore3Pnl.add(risultatoDado1Giocatore3lbl);
			risultatoDadoGiocatore3Pnl.add(risultatoDado1Giocatore3Txf);
			risultatoDadoGiocatore3Pnl.add(risultatoDado2Giocatore3lbl);
			risultatoDadoGiocatore3Pnl.add(risultatoDado2Giocatore3Txf);
			this.add(btnLanciaDadoGiocatore3);
			this.add(risultatoDadoGiocatore3Pnl);
			this.add(btnMuoviGiocatore3);
			for (int i = 0; i < 3; i++) {
				this.add(new JLabel());
			}
			break;

		case 4:
			risultatoDado1Giocatore3lbl = new JLabel("Dado 1: ");
			risultatoDado2Giocatore3lbl = new JLabel("Dado 2: ");
			risultatoDado2Giocatore3Txf = new JTextField("0");
			risultatoDado1Giocatore3Txf = new JTextField("0");
			risultatoDadoGiocatore3Pnl = new JPanel();
			giocatore3Lbl = new JLabel(giocatori.get(2));
			btnLanciaDadoGiocatore3 = new JButton("lancia il dado");
			btnMuoviGiocatore3 = new JButton("Muovi " + giocatori.get(2));
			risultatoDadoGiocatore3Pnl.add(risultatoDado1Giocatore3lbl);
			risultatoDadoGiocatore3Pnl.add(risultatoDado1Giocatore3Txf);
			risultatoDadoGiocatore3Pnl.add(risultatoDado2Giocatore3lbl);
			risultatoDadoGiocatore3Pnl.add(risultatoDado2Giocatore3Txf);

			risultatoDado1Giocatore4lbl = new JLabel("Dado 1: ");
			risultatoDado2Giocatore4lbl = new JLabel("Dado 2: ");
			risultatoDado2Giocatore4Txf = new JTextField("0");
			risultatoDado1Giocatore4Txf = new JTextField("0");
			risultatoDadoGiocatore4Pnl = new JPanel();
			giocatore4Lbl = new JLabel(giocatori.get(3));
			btnLanciaDadoGiocatore4 = new JButton("lancia il dado");
			btnMuoviGiocatore4 = new JButton("Muovi " + giocatori.get(3));
			risultatoDadoGiocatore4Pnl.add(risultatoDado1Giocatore4lbl);
			risultatoDadoGiocatore4Pnl.add(risultatoDado1Giocatore4Txf);
			risultatoDadoGiocatore4Pnl.add(risultatoDado2Giocatore4lbl);
			risultatoDadoGiocatore4Pnl.add(risultatoDado2Giocatore4Txf);

			this.add(btnLanciaDadoGiocatore3);
			this.add(risultatoDadoGiocatore3Pnl);
			this.add(btnMuoviGiocatore3);
			this.add(btnLanciaDadoGiocatore4);
			this.add(risultatoDadoGiocatore4Pnl);
			this.add(btnMuoviGiocatore4);
			break;
		}

		this.repaint();
		this.revalidate();

		btnMuoviGiocatore1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precPosGicatore1=gestisciMovimento(risultatoDado2Giocatore1Txf, risultatoDado1Giocatore1Txf, giocatore1Lbl,precPosGicatore1);

			}

		});

		btnMuoviGiocatore2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				precPosGicatore2=gestisciMovimento(risultatoDado2Giocatore2Txf, risultatoDado1Giocatore2Txf, giocatore2Lbl,precPosGicatore2);

			}

		});

		btnMuoviGiocatore3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				precPosGicatore3=gestisciMovimento(risultatoDado2Giocatore3Txf, risultatoDado1Giocatore3Txf, giocatore3Lbl,precPosGicatore3);

			}

		});

		btnMuoviGiocatore4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				precPosGicatore4= gestisciMovimento(risultatoDado2Giocatore4Txf, risultatoDado1Giocatore4Txf, giocatore4Lbl,precPosGicatore4);

			}

		});

		btnLanciaDadoGiocatore1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lanciaDadi(risultatoDado1Giocatore1Txf,risultatoDado2Giocatore1Txf);

			}

		});

		btnLanciaDadoGiocatore2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lanciaDadi(risultatoDado1Giocatore2Txf,risultatoDado2Giocatore2Txf);

			}

		});

		btnLanciaDadoGiocatore3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lanciaDadi(risultatoDado1Giocatore3Txf,risultatoDado2Giocatore3Txf);

			}

		});

		btnLanciaDadoGiocatore4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lanciaDadi(risultatoDado1Giocatore4Txf,risultatoDado2Giocatore4Txf);
			}

		});

	}

	protected void lanciaDadi(JTextField risultatoDado1GiocatoreTxf,JTextField risultatoDado2GiocatoreTxf) {
		int max = 8;
		int min = 1;
		int int_random1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int int_random2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		risultatoDado1GiocatoreTxf.setText(int_random1 + "");
		risultatoDado2GiocatoreTxf.setText(int_random2 + "");
		aggiornaFrame();

	}

	private void aggiornaTabellone(Map<String, Integer> mappaPunteggi) {
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.remove(tabellone);
		tabellone = new Tabellone(mappaPunteggi);
		topFrame.add(tabellone);
		this.repaint();
		this.revalidate();
	}
	
	private void chiudiPartita() {
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.setVisible(false); 
		topFrame.dispose(); 
		this.repaint();
		this.revalidate();
	}

	private void aggiornaFrame() {

		this.repaint();
		this.revalidate();
	}

	public Integer gestisciMovimento(JTextField risultatoDado2Txf, JTextField risultatoDado1Txf, JLabel giocatoreLbl,Integer precPosGicatoreOld) {
		caselleOca = Arrays.asList(5, 9, 14, 18, 23, 27);
		int precPosGicatore=0;
		if (isInteger(risultatoDado2Txf.getText(), 10) && isInteger(risultatoDado1Txf.getText(), 10)) {
			int d2 = Integer.valueOf(risultatoDado2Txf.getText());
			int d1 = Integer.valueOf(risultatoDado1Txf.getText());
			Integer finalVal;
			Integer res=d1+d2;
			if (giocatoriPunteggi.containsKey(giocatoreLbl.getText())) {
				precPosGicatore=giocatoriPunteggi.get(giocatoreLbl.getText());
				if ((giocatoriPunteggi.get(giocatoreLbl.getText()) + res) > 63) {
					Integer newVal = giocatoriPunteggi.get(giocatoreLbl.getText()) + res - 63;
					finalVal= 63 - newVal;
					controllaSePosOccupata(finalVal,precPosGicatoreOld);
					giocatoriPunteggi.put(giocatoreLbl.getText(),finalVal);
				} else if (Arrays.stream(caselleOca.toArray()).anyMatch(Integer.valueOf(giocatoriPunteggi.get(giocatoreLbl.getText()) + res)::equals) ){
					JOptionPane.showMessageDialog(new JFrame(), " casella "+
							giocatoriPunteggi.get(giocatoreLbl.getText()) + res+",hai beccato l'oca!! "+giocatoreLbl.getText() 
							+ " Muovi ancora di "+res+" posizioni");
					finalVal= giocatoriPunteggi.get(giocatoreLbl.getText()) + res+ res;
					controllaSePosOccupata(finalVal,precPosGicatoreOld);
					giocatoriPunteggi.put(giocatoreLbl.getText(),
							finalVal);
				} else if ((giocatoriPunteggi.get(giocatoreLbl.getText()) + res) == 6) {
					JOptionPane.showMessageDialog(new JFrame(), giocatoreLbl.getText() + " sei sul ponte!! muovi ancora di 6 posizioni");
					finalVal=giocatoriPunteggi.get(giocatoreLbl.getText()) + res+ 6;
					controllaSePosOccupata(finalVal,precPosGicatoreOld);
					giocatoriPunteggi.put(giocatoreLbl.getText(),
							finalVal);
				}else if ((giocatoriPunteggi.get(giocatoreLbl.getText()) + res) == 63) {
					JOptionPane.showMessageDialog(new JFrame(), giocatoreLbl.getText() + " Ha vinto!!");
					chiudiPartita();
					return 0;
				} else {
					finalVal=giocatoriPunteggi.get(giocatoreLbl.getText()) + res;
					controllaSePosOccupata(finalVal,precPosGicatoreOld);
					giocatoriPunteggi.put(giocatoreLbl.getText(),finalVal);
					
				}
			} else if (Arrays.stream(caselleOca.toArray()).anyMatch(Integer.valueOf( res)::equals)) {
				giocatoriPunteggi.put(giocatoreLbl.getText(), res);
				
				JOptionPane.showMessageDialog(new JFrame(),  " casella "+
						giocatoriPunteggi.get(giocatoreLbl.getText()) +",hai beccato l'oca!! "
						+giocatoreLbl.getText() +" Muovi ancora di "+res+" posizioni");
				finalVal=res+ res;
				controllaSePosOccupata(finalVal,precPosGicatoreOld);
				giocatoriPunteggi.put(giocatoreLbl.getText(),
						finalVal);
			} else if (( d2 + d1) == 6) {
				JOptionPane.showMessageDialog(new JFrame(), giocatoreLbl.getText() + " sei sul ponte!! muovi ancora di 6 posizioni");
				finalVal=res+ 6;
				controllaSePosOccupata(finalVal,precPosGicatoreOld);
				giocatoriPunteggi.put(giocatoreLbl.getText(),
						finalVal);
			}else {
				controllaSePosOccupata(res,precPosGicatoreOld);
				giocatoriPunteggi.put(giocatoreLbl.getText(), res);
			}
			aggiornaTabellone(giocatoriPunteggi);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Numero non valido!!");
			chiudiIframe();
		}
		return precPosGicatore;
	}

	private void controllaSePosOccupata(Integer finalVal, Integer precPosGicatoreOld) {
		for (Map.Entry<String, Integer> entry : giocatoriPunteggi.entrySet()) {
			if (entry.getValue()==finalVal) {
				giocatoriPunteggi.put(entry.getKey(), precPosGicatoreOld);
				break;
			}
			
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

	public void chiudiIframe() {
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.dispatchEvent(new WindowEvent(topFrame, WindowEvent.WINDOW_CLOSING));

	}

}
