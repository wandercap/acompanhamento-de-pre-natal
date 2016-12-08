package view.panels.consulta;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.FontsProj;
import view.panels.MainPanel;
import view.panels.ProntuarioPanel;

/**
 * A classe {@code ConsultasPanel} gera o panel principal de consultas
 * @author Wanderlan Carvalho
 *
 */

public class ConsultasPanel extends JPanel {
	private static final long serialVersionUID = -2534326009160514561L;
	
	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ConsultasPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		FontsProj fontes = new FontsProj();
		
		JButton btnConsultasAgendadas = new JButton("Consultas Agendadas");
		btnConsultasAgendadas.setToolTipText("Consultas Agendadas");
		btnConsultasAgendadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListConsAgendPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnConsultasAgendadas.setFont(fontes.Raleway);
		btnConsultasAgendadas.setForeground(new Color(255, 255, 255));
		btnConsultasAgendadas.setBackground(new Color(153, 51, 255));
		btnConsultasAgendadas.setBorder(null);
		btnConsultasAgendadas.setBounds(250, 211, 300, 40);
		add(btnConsultasAgendadas);
		
		JButton btnConsultasRealizadas = new JButton("Consultas Realizadas");
		btnConsultasRealizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListConsRealiPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnConsultasRealizadas.setToolTipText("Consultas Realizadas");
		btnConsultasRealizadas.setFont(fontes.Raleway);
		btnConsultasRealizadas.setForeground(new Color(255, 255, 255));
		btnConsultasRealizadas.setBackground(new Color(153, 51, 255));
		btnConsultasRealizadas.setBorder(null);
		btnConsultasRealizadas.setBounds(250, 286, 300, 40);
		add(btnConsultasRealizadas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ProntuarioPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnVoltar.setFont(fontes.Raleway);
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(153, 51, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(250, 532, 300, 40);
		add(btnVoltar);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(fontes.unDinaruB);
		lblConsultas.setForeground(new Color(255, 255, 255));
		lblConsultas.setBounds(311, 35, 169, 75);
		add(lblConsultas);
		
		JButton btnAgendarConsulta = new JButton("Agendar Consulta");
		btnAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new CadConsPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnAgendarConsulta.setToolTipText("Agendar Consulta");
		btnAgendarConsulta.setForeground(Color.WHITE);
		btnAgendarConsulta.setFont(fontes.Raleway);
		btnAgendarConsulta.setBackground(new Color(153, 51, 255));
		btnAgendarConsulta.setBorder(null);
		btnAgendarConsulta.setBounds(250, 135, 300, 40);
		add(btnAgendarConsulta);
		
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
		btnInicio.setFont(fontes.Raleway);
		btnInicio.setBorder(null);
		btnInicio.setBackground(new Color(153, 51, 255));
		btnInicio.setBounds(250, 480, 300, 40);
		add(btnInicio);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}
}
