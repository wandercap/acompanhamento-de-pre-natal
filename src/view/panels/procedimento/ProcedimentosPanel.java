package view.panels.procedimento;

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
 * A classe {@code ProcedimentosPanel} gera o panel dos procedimentos
 * @author Wanderlan Carvalho
 *
 */

public class ProcedimentosPanel extends JPanel {
	private static final long serialVersionUID = -1629671509025926691L;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ProcedimentosPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		FontsProj fontes = new FontsProj();
		
		JButton btnProcAgendados = new JButton("Procedimentos Agendados");
		btnProcAgendados.setToolTipText("Procedimentos Agendados");
		btnProcAgendados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListProcAgendPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnProcAgendados.setFont(fontes.Raleway);
		btnProcAgendados.setForeground(new Color(255, 255, 255));
		btnProcAgendados.setBackground(new Color(153, 51, 255));
		btnProcAgendados.setBorder(null);
		btnProcAgendados.setBounds(250, 211, 300, 40);
		add(btnProcAgendados);
		
		JButton btnProcRealizados = new JButton("Procedimentos Realizados");
		btnProcRealizados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListProcRealiPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnProcRealizados.setToolTipText("Procedimentos Realizados");
		btnProcRealizados.setFont(fontes.Raleway);
		btnProcRealizados.setForeground(new Color(255, 255, 255));
		btnProcRealizados.setBackground(new Color(153, 51, 255));
		btnProcRealizados.setBorder(null);
		btnProcRealizados.setBounds(250, 286, 300, 40);
		add(btnProcRealizados);
		
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
		
		JLabel lblExames = new JLabel("Procedimentos");
		lblExames.setFont(fontes.unDinaruB);
		lblExames.setForeground(new Color(255, 255, 255));
		lblExames.setBounds(275, 35, 258, 75);
		add(lblExames);
		
		JButton btnAgendarProc = new JButton("Agendar Procedimento");
		btnAgendarProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new CadProcPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnAgendarProc.setToolTipText("Agendar Procedimento");
		btnAgendarProc.setForeground(Color.WHITE);
		btnAgendarProc.setFont(fontes.Raleway);
		btnAgendarProc.setBackground(new Color(153, 51, 255));
		btnAgendarProc.setBorder(null);
		btnAgendarProc.setBounds(250, 135, 300, 40);
		add(btnAgendarProc);
		
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
