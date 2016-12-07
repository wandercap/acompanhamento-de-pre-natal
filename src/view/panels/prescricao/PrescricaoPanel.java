package view.panels.prescricao;

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
import view.panels.consulta.ListConsRealiPanel;

/**
 * A classe {@code PrescricaoPanel} gera o panel principal de prescricoes
 * @author Wanderlan Carvalho
 *
 */

public class PrescricaoPanel extends JPanel {
	private static final long serialVersionUID = -529955509574397798L;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 * @param idCons
	 */
	public PrescricaoPanel(JFrame frame, int idGest, int idCons) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		JButton btnAltPresc = new JButton("Alterar Prescrição");
		btnAltPresc.setToolTipText("Alterar Prescrição");
		btnAltPresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new AltPrescPanel(frame, idGest, idCons));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnAltPresc.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnAltPresc.setForeground(new Color(255, 255, 255));
		btnAltPresc.setBackground(new Color(153, 51, 255));
		btnAltPresc.setBorder(null);
		btnAltPresc.setBounds(250, 211, 300, 40);
		add(btnAltPresc);
		
		JButton btnConsPresc = new JButton("Consultar Prescrição");
		btnConsPresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ViewPrescPanel(frame, idGest, idCons));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnConsPresc.setToolTipText("Consultar Prescrição");
		btnConsPresc.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnConsPresc.setForeground(new Color(255, 255, 255));
		btnConsPresc.setBackground(new Color(153, 51, 255));
		btnConsPresc.setBorder(null);
		btnConsPresc.setBounds(250, 286, 300, 40);
		add(btnConsPresc);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListConsRealiPanel(frame, idGest));
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
		
		JLabel lblPresc = new JLabel("Prescrições");
		lblPresc.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblPresc.setForeground(new Color(255, 255, 255));
		lblPresc.setBounds(307, 35, 190, 75);
		add(lblPresc);
		
		JButton btnCadPresc = new JButton("Cadastrar Prescrição");
		btnCadPresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new CadPrescPanel(frame, idGest, idCons));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnCadPresc.setToolTipText("Cadastrar Prescrição");
		btnCadPresc.setForeground(Color.WHITE);
		btnCadPresc.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnCadPresc.setBackground(new Color(153, 51, 255));
		btnCadPresc.setBorder(null);
		btnCadPresc.setBounds(250, 135, 300, 40);
		add(btnCadPresc);
		
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
