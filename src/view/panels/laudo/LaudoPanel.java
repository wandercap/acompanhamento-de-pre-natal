package view.panels.laudo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.panels.MainPanel;
import view.panels.ProntuarioPanel;

/**
 * A classe {@code LaudoPanel} gera o panel principal de laudos
 * @author Wanderlan Carvalho
 *
 */

public class LaudoPanel extends JPanel {
	private static final long serialVersionUID = 4523814233635093073L;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 * @param idProc
	 * @param idExam
	 */
	public LaudoPanel(JFrame frame, int idGest, int idProc, int idExam) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		JButton btnAltLaudo = new JButton("Alterar Laudo");
		btnAltLaudo.setToolTipText("Alterar Laudo");
		btnAltLaudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new AltLaudoPanel(frame, idGest, idProc, idExam));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnAltLaudo.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnAltLaudo.setForeground(new Color(255, 255, 255));
		btnAltLaudo.setBackground(new Color(153, 51, 255));
		btnAltLaudo.setBorder(null);
		btnAltLaudo.setBounds(250, 211, 300, 40);
		add(btnAltLaudo);
		
		JButton btnConsLaudo = new JButton("Consultar Laudo");
		btnConsLaudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ViewLaudoPanel(frame, idGest, idProc, idExam));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnConsLaudo.setToolTipText("Consultar Laudo");
		btnConsLaudo.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnConsLaudo.setForeground(new Color(255, 255, 255));
		btnConsLaudo.setBackground(new Color(153, 51, 255));
		btnConsLaudo.setBorder(null);
		btnConsLaudo.setBounds(250, 286, 300, 40);
		add(btnConsLaudo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ProntuarioPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnVoltar.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(153, 51, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(250, 532, 300, 40);
		add(btnVoltar);
		
		JLabel lblLaudo = new JLabel("Laudo");
		lblLaudo.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblLaudo.setForeground(new Color(255, 255, 255));
		lblLaudo.setBounds(350, 35, 106, 75);
		add(lblLaudo);
		
		JButton btnCadLaudo = new JButton("Cadastrar Laudo");
		btnCadLaudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new CadLaudoPanel(frame, idGest, idProc, idExam));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnCadLaudo.setToolTipText("Cadastrar Laudo");
		btnCadLaudo.setForeground(Color.WHITE);
		btnCadLaudo.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnCadLaudo.setBackground(new Color(153, 51, 255));
		btnCadLaudo.setBorder(null);
		btnCadLaudo.setBounds(250, 135, 300, 40);
		add(btnCadLaudo);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new MainPanel(frame));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnInicio.setToolTipText("Inicio");
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnInicio.setBorder(null);
		btnInicio.setBackground(new Color(153, 51, 255));
		btnInicio.setBounds(250, 480, 300, 40);
		add(btnInicio);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("/home/wanderlan/workspace/M@e Digital/img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
