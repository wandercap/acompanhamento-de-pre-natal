package view.panels.exame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.dao.textfiledao.TextFileExameDao;
import model.Exame;
import view.FontsProj;

/**
 * A classe {@code CadExamePanel} gera o panel para o cadastro de exames
 * @author Wanderlan Carvalho
 *
 */

public class CadExamePanel extends JPanel {
	private static final long serialVersionUID = -7186138490226021966L;
	private TextFileExameDao newExam;
	private JFormattedTextField txtData;
	private JFormattedTextField txtHorario;
	private JTextField txtLocal;
	private JTextField txtEspec;
	private JTextField txtMedico;
	private JTextArea txtComents;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public CadExamePanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(196, 137, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(fontes.unDinaru);
		add(lblData);
		
		JLabel lblAgendarExame = new JLabel("Agendar Exame");
		lblAgendarExame.setBounds(270, 35, 288, 48);
		lblAgendarExame.setFont(fontes.unDinaruB);
		lblAgendarExame.setForeground(new Color(255, 255, 255));
		add(lblAgendarExame);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(196, 194, 143, 15);
		lblLocal.setFont(fontes.unDinaru);
		lblLocal.setForeground(new Color(255, 255, 255));
		add(lblLocal);
		
		txtLocal = new JTextField();
		txtLocal.setBounds(196, 209, 410, 30);
		txtLocal.setToolTipText("");
		txtLocal.setBorder(null);
		txtLocal.setFont(fontes.unDinaru);
		txtLocal.setForeground(new Color(102, 102, 102));
		add(txtLocal);
		txtLocal.setColumns(10);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(470, 137, 114, 15);
		lblEspecialidade.setFont(fontes.unDinaru);
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBounds(470, 152, 136, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setFont(fontes.unDinaru);
		txtEspec.setForeground(new Color(102, 102, 102));
		add(txtEspec);
		txtEspec.setColumns(10);
		
		JLabel lblMedico = new JLabel("Médico");
		lblMedico.setBounds(196, 251, 114, 15);
		lblMedico.setForeground(new Color(255, 255, 255));
		lblMedico.setFont(fontes.unDinaru);
		add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(196, 266, 410, 30);
		txtMedico.setToolTipText("");
		txtMedico.setBorder(null);
		txtMedico.setFont(fontes.unDinaru);
		txtMedico.setForeground(new Color(102, 102, 102));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JLabel lblComentarios = new JLabel("Comentários");
		lblComentarios.setBounds(196, 308, 114, 15);
		lblComentarios.setFont(fontes.unDinaru);
		lblComentarios.setForeground(new Color(255, 255, 255));
		add(lblComentarios);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exame ex = new Exame(idGest, txtData.getText(), txtHorario.getText(), txtLocal.getText(), txtEspec.getText(), txtMedico.getText(), txtComents.getText(), false);

				newExam = new TextFileExameDao();
				if(newExam.adicionar(ex) == true)
					JOptionPane.showMessageDialog(CadExamePanel.this, "Novo exame agendado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(CadExamePanel.this, "Erro ao agendar novo exame!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAgendar.setToolTipText("Agendar");
		btnAgendar.setFont(fontes.Raleway);
		btnAgendar.setBackground(new Color(153, 51, 255));
		btnAgendar.setForeground(new Color(255, 255, 255));
		btnAgendar.setBorder(null);
		btnAgendar.setBounds(550, 530, 200, 40);
		add(btnAgendar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ExamesPanel(frame, idGest));
				frame.revalidate();
				frame.repaint();
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setBackground(new Color(153, 51, 255));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(fontes.Raleway);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(50, 530, 200, 40);
		add(btnVoltar);
		
		JLabel lblHorario = new JLabel("Horário");
		lblHorario.setForeground(new Color(255, 255, 255));
		lblHorario.setFont(fontes.unDinaru);
		lblHorario.setBounds(358, 137, 143, 15);
		add(lblHorario);
		
		txtData = new JFormattedTextField();
		txtData.setBorder(null);
		txtData.setBounds(196, 152, 150, 30);
		add(txtData);
		
		txtHorario = new JFormattedTextField();
		txtHorario.setBorder(null);
		txtHorario.setBounds(358, 152, 100, 30);
		add(txtHorario);
		
		txtComents = new JTextArea();
		txtComents.setForeground(new Color(102, 102, 102));
		txtComents.setBorder(null);
		txtComents.setFont(fontes.unDinaru);
		txtComents.setBounds(196, 326, 410, 137);
		add(txtComents);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
