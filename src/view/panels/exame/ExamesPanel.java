package view.panels.exame;

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
 * A classe {@code ListConsAgendPanel} gera o panel principal dos exames
 * @author Wanderlan Carvalho
 *
 */

public class ExamesPanel extends JPanel {
	private static final long serialVersionUID = 4292232876149583023L;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ExamesPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		JButton btnExamesAgendados = new JButton("Exames Agendados");
		btnExamesAgendados.setToolTipText("Exames Agendados");
		btnExamesAgendados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListExamAgendPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnExamesAgendados.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnExamesAgendados.setForeground(new Color(255, 255, 255));
		btnExamesAgendados.setBackground(new Color(153, 51, 255));
		btnExamesAgendados.setBorder(null);
		btnExamesAgendados.setBounds(250, 211, 300, 40);
		add(btnExamesAgendados);
		
		JButton btnExamesRealizados = new JButton("Exames Realizados");
		btnExamesRealizados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListExamRealiPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnExamesRealizados.setToolTipText("Exames Realizados");
		btnExamesRealizados.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnExamesRealizados.setForeground(new Color(255, 255, 255));
		btnExamesRealizados.setBackground(new Color(153, 51, 255));
		btnExamesRealizados.setBorder(null);
		btnExamesRealizados.setBounds(250, 286, 300, 40);
		add(btnExamesRealizados);
		
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
		
		JLabel lblExames = new JLabel("Exames");
		lblExames.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblExames.setForeground(new Color(255, 255, 255));
		lblExames.setBounds(330, 35, 130, 75);
		add(lblExames);
		
		JButton btnAgendarExame = new JButton("Agendar Exame");
		btnAgendarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new CadExamePanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnAgendarExame.setToolTipText("Agendar Exame");
		btnAgendarExame.setForeground(Color.WHITE);
		btnAgendarExame.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnAgendarExame.setBackground(new Color(153, 51, 255));
		btnAgendarExame.setBorder(null);
		btnAgendarExame.setBounds(250, 135, 300, 40);
		add(btnAgendarExame);
		
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
