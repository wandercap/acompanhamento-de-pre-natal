package view.panels.laudo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.dao.textfiledao.TextFileLaudoDao;
import model.Laudo;

/**
 * A classe {@code ViewLaudoPanel} gera o panel para a visualizacao de um laudo
 * @author Wanderlan Carvalho
 *
 */

public class ViewLaudoPanel extends JPanel {
	private static final long serialVersionUID = 631057595827651450L;
	private TextFileLaudoDao newLaudo;
	private Laudo laudo;
	private JFormattedTextField txtData;
	private JTextField txtEspec;
	private JTextField txtMedico;
	private JTextArea txtLaudo;
	
	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 * @param idProc
	 * @param idExam
	 */
	public ViewLaudoPanel(JFrame frame, int idGest, int idProc, int idExam) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		newLaudo = new TextFileLaudoDao();
		laudo = newLaudo.buscar(idProc, idExam);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(50, 134, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		add(lblData);
		
		JLabel lblPrescricao = new JLabel("Laudo");
		lblPrescricao.setBounds(336, 35, 108, 48);
		lblPrescricao.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblPrescricao.setForeground(new Color(255, 255, 255));
		add(lblPrescricao);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(216, 134, 114, 15);
		lblEspecialidade.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBackground(new Color(153, 51, 255));
		txtEspec.setBounds(216, 149, 200, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setText(laudo.getEspecialidade());
		txtEspec.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtEspec.setForeground(new Color(255, 255, 255));
		add(txtEspec);
		txtEspec.setColumns(10);
		
		JLabel lblMedico = new JLabel("Médico");
		lblMedico.setBounds(428, 134, 114, 15);
		lblMedico.setForeground(new Color(255, 255, 255));
		lblMedico.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBackground(new Color(153, 51, 255));
		txtMedico.setBounds(428, 149, 322, 30);
		txtMedico.setToolTipText("");
		txtMedico.setBorder(null);
		txtMedico.setText(laudo.getMedico());
		txtMedico.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtMedico.setForeground(new Color(255, 255, 255));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new LaudoPanel(frame, idGest, idProc, idExam));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setBackground(new Color(153, 51, 255));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(50, 530, 200, 40);
		add(btnVoltar);
		
		txtData = new JFormattedTextField();
		txtData.setForeground(new Color(255, 255, 255));
		txtData.setBackground(new Color(153, 51, 255));
		txtData.setBorder(null);
		txtData.setBounds(50, 149, 150, 30);
		txtData.setText(laudo.getData());
		add(txtData);
		
		txtLaudo = new JTextArea();
		txtLaudo.setBackground(new Color(153, 51, 255));
		txtLaudo.setForeground(new Color(255, 255, 255));
		txtLaudo.setText(laudo.getLaudo());
		txtLaudo.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtLaudo.setBounds(50, 209, 700, 300);
		add(txtLaudo);
		
		JLabel lblLaudo = new JLabel("Laudo");
		lblLaudo.setForeground(Color.WHITE);
		lblLaudo.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblLaudo.setBounds(50, 191, 114, 15);
		add(lblLaudo);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("/home/wanderlan/workspace/M@e Digital/img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
