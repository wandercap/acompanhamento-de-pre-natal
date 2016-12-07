package view.panels.consulta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.dao.textfiledao.TextFileConsultaDao;
import model.Consulta;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * A classe {@code CadConsPanel} gera o panel para cadastro de consultas
 * @author Wanderlan Carvalho
 *
 */

public class CadConsPanel extends JPanel {
	private static final long serialVersionUID = 7593745127329937200L;
	private TextFileConsultaDao newCons;
	private JFormattedTextField txtData;
	private JFormattedTextField txtHora;
	private JTextField txtLocal;
	private JTextField txtEspec;
	private JTextField txtMedico;
	private JTextArea txtComents;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public CadConsPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(196, 137, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		add(lblData);
		
		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta");
		lblAgendarConsulta.setBounds(240, 35, 321, 48);
		lblAgendarConsulta.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblAgendarConsulta.setForeground(new Color(255, 255, 255));
		add(lblAgendarConsulta);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(196, 194, 143, 15);
		lblLocal.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblLocal.setForeground(new Color(255, 255, 255));
		add(lblLocal);
		
		txtLocal = new JTextField();
		txtLocal.setBounds(196, 209, 410, 30);
		txtLocal.setToolTipText("");
		txtLocal.setBorder(null);
		txtLocal.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtLocal.setForeground(new Color(102, 102, 102));
		add(txtLocal);
		txtLocal.setColumns(10);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(470, 137, 114, 15);
		lblEspecialidade.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBounds(470, 152, 136, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtEspec.setForeground(new Color(102, 102, 102));
		add(txtEspec);
		txtEspec.setColumns(10);
		
		JLabel lblMedico = new JLabel("Médico");
		lblMedico.setBounds(196, 251, 114, 15);
		lblMedico.setForeground(new Color(255, 255, 255));
		lblMedico.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(196, 266, 410, 30);
		txtMedico.setToolTipText("");
		txtMedico.setBorder(null);
		txtMedico.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtMedico.setForeground(new Color(102, 102, 102));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JLabel lblComentarios = new JLabel("Comentários");
		lblComentarios.setBounds(196, 308, 114, 15);
		lblComentarios.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblComentarios.setForeground(new Color(255, 255, 255));
		add(lblComentarios);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta c = new Consulta(idGest, txtData.getText(), txtHora.getText(), txtLocal.getText(), txtEspec.getText(), txtMedico.getText(), txtComents.getText(), false);

				newCons = new TextFileConsultaDao();
				if(newCons.adicionar(c) == true)
					JOptionPane.showMessageDialog(CadConsPanel.this, "Nova consulta agendada!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(CadConsPanel.this, "Erro ao agendar nova consulta!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAgendar.setToolTipText("Agendar");
		btnAgendar.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnAgendar.setBackground(new Color(153, 51, 255));
		btnAgendar.setForeground(new Color(255, 255, 255));
		btnAgendar.setBorder(null);
		btnAgendar.setBounds(550, 530, 200, 40);
		add(btnAgendar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ConsultasPanel(frame, idGest));
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
		
		JLabel lblHorario = new JLabel("Horário");
		lblHorario.setForeground(new Color(255, 255, 255));
		lblHorario.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		lblHorario.setBounds(358, 137, 143, 15);
		add(lblHorario);
		
		txtData = new JFormattedTextField();
		txtData.setBounds(196, 152, 150, 30);
		txtData.setBorder(null);
		add(txtData);
		
		txtHora = new JFormattedTextField();
		txtHora.setBounds(358, 152, 100, 30);
		txtHora.setBorder(null);
		add(txtHora);
		
		txtComents = new JTextArea();
		txtComents.setForeground(new Color(102, 102, 102));
		txtComents.setBorder(null);
		txtComents.setFont(new Font("UnDinaru", Font.PLAIN, 15));
		txtComents.setBounds(196, 326, 410, 137);
		add(txtComents);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("/home/wanderlan/workspace/M@e Digital/img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}
}
