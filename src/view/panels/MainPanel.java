package view.panels;

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
import view.panels.gestante.*;

/**
 * A classe {@code MainPanel} gera o panel inicial da aplicacao
 * @author Wanderlan Carvalho
 *
 */

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -1931505285368286964L;

	/**
	 * Gera o panel
	 * @param frame
	 */
	public MainPanel(JFrame frame) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//setUndecorated(true);
		
		FontsProj fontes = new FontsProj();
		
		JButton btnCadastrarGestante = new JButton("Cadastrar Gestante");
		btnCadastrarGestante.setToolTipText("Cadastrar Gestante");
		btnCadastrarGestante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new CadGestPanel(frame));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnCadastrarGestante.setFont(fontes.Raleway);
		btnCadastrarGestante.setForeground(new Color(255, 255, 255));
		btnCadastrarGestante.setBackground(new Color(153, 51, 255));
		btnCadastrarGestante.setBorder(null);
		btnCadastrarGestante.setBounds(250, 162, 300, 40);
		add(btnCadastrarGestante);
		
		JButton btnRemoverGestante = new JButton("Remover Gestante");
		btnRemoverGestante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new DelGestPanel(frame));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnRemoverGestante.setToolTipText("Remover Gestante");
		btnRemoverGestante.setFont(fontes.Raleway);
		btnRemoverGestante.setForeground(new Color(255, 255, 255));
		btnRemoverGestante.setBackground(new Color(153, 51, 255));
		btnRemoverGestante.setBorder(null);
		btnRemoverGestante.setBounds(250, 231, 300, 40);
		add(btnRemoverGestante);
		
		JButton btnListaGestantes = new JButton("Gestantes Cadastradas");
		btnListaGestantes.setToolTipText("Gestantes Cadastradas");
		btnListaGestantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ListGestPanel(frame));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnListaGestantes.setBackground(new Color(153, 51, 255));
		btnListaGestantes.setForeground(new Color(255, 255, 255));
		btnListaGestantes.setFont(fontes.Raleway);
		btnListaGestantes.setBorder(null);
		btnListaGestantes.setBounds(250, 297, 300, 40);
		add(btnListaGestantes);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				//setVisible(false);
				System.exit(0);
			}
		});
		btnSair.setFont(fontes.Raleway);
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setBackground(new Color(153, 51, 255));
		btnSair.setBorder(null);
		btnSair.setBounds(250, 532, 300, 40);
		add(btnSair);
		
		JLabel lblMeDigital = new JLabel("M@e Digital");
		lblMeDigital.setFont(fontes.unDinaruBM);
		lblMeDigital.setForeground(new Color(255, 255, 255));
		lblMeDigital.setBounds(271, 35, 260, 75);
		add(lblMeDigital);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}
}
