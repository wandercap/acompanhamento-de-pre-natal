package view.panels;

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

import view.panels.consulta.ConsultasPanel;
import view.panels.exame.ExamesPanel;
import view.panels.gestante.ListGestPanel;
import view.panels.procedimento.ProcedimentosPanel;

/**
 * A classe {@code ProntuarioPanel} gera o panel com as opcoes do prontuario
 * @author Wanderlan Carvalho
 *
 */

public class ProntuarioPanel extends JPanel {
	private static final long serialVersionUID = -9191926887985574641L;
	
	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ProntuarioPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setToolTipText("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ConsultasPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnConsultas.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnConsultas.setForeground(new Color(255, 255, 255));
		btnConsultas.setBackground(new Color(153, 51, 255));
		btnConsultas.setBorder(null);
		btnConsultas.setBounds(250, 136, 300, 40);
		add(btnConsultas);
		
		JButton btnExames = new JButton("Exames");
		btnExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ExamesPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnExames.setToolTipText("Exames");
		btnExames.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnExames.setForeground(new Color(255, 255, 255));
		btnExames.setBackground(new Color(153, 51, 255));
		btnExames.setBorder(null);
		btnExames.setBounds(250, 205, 300, 40);
		add(btnExames);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListGestPanel(frame));
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
		
		JLabel lblProntuario = new JLabel("Prontuário");
		lblProntuario.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblProntuario.setForeground(new Color(255, 255, 255));
		lblProntuario.setBounds(310, 35, 178, 75);
		add(lblProntuario);
		
		JButton btnProcedimentos = new JButton("Procedimentos");
		btnProcedimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ProcedimentosPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnProcedimentos.setToolTipText("Procedimentos");
		btnProcedimentos.setForeground(Color.WHITE);
		btnProcedimentos.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnProcedimentos.setBackground(new Color(153, 51, 255));
		btnProcedimentos.setBorder(null);
		btnProcedimentos.setBounds(250, 270, 300, 40);
		add(btnProcedimentos);
		
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
