package view.panels.prescricao;

import java.awt.Color;
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

import control.dao.textfiledao.TextFilePrescricaoDao;
import model.Prescricao;
import view.FontsProj;

/**
 * A classe {@code ViewPrescPanel} gera o panel para a visualizacao de prescricoes
 * @author Wanderlan Carvalho
 *
 */

public class ViewPrescPanel extends JPanel {
	private static final long serialVersionUID = 7452803468155077625L;
	private TextFilePrescricaoDao newPresc;
	private Prescricao presc;
	private JFormattedTextField txtData;
	private JTextField txtEspec;
	private JTextField txtMedico;
	private JTextArea txtPresc;
	
	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 * @param idCons
	 */
	public ViewPrescPanel(JFrame frame, int idGest, int idCons) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		newPresc = new TextFilePrescricaoDao();
		presc = newPresc.buscar(idCons);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(50, 134, 70, 15);
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(fontes.unDinaru);
		add(lblData);
		
		JLabel lblPrescricao = new JLabel("Prescrição");
		lblPrescricao.setBounds(295, 35, 181, 48);
		lblPrescricao.setFont(fontes.unDinaruB);
		lblPrescricao.setForeground(new Color(255, 255, 255));
		add(lblPrescricao);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(216, 134, 114, 15);
		lblEspecialidade.setFont(fontes.unDinaru);
		lblEspecialidade.setForeground(new Color(255, 255, 255));
		add(lblEspecialidade);
		
		txtEspec = new JTextField();
		txtEspec.setBackground(new Color(153, 51, 255));
		txtEspec.setBounds(216, 149, 200, 30);
		txtEspec.setToolTipText("");
		txtEspec.setBorder(null);
		txtEspec.setText(presc.getEspecialidade());
		txtEspec.setFont(fontes.unDinaru);
		txtEspec.setForeground(new Color(255, 255, 255));
		add(txtEspec);
		txtEspec.setColumns(10);
		
		JLabel lblMedico = new JLabel("Médico");
		lblMedico.setBounds(428, 134, 114, 15);
		lblMedico.setForeground(new Color(255, 255, 255));
		lblMedico.setFont(fontes.unDinaru);
		add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBackground(new Color(153, 51, 255));
		txtMedico.setBounds(428, 149, 322, 30);
		txtMedico.setToolTipText("");
		txtMedico.setBorder(null);
		txtMedico.setText(presc.getMedico());
		txtMedico.setFont(fontes.unDinaru);
		txtMedico.setForeground(new Color(255, 255, 255));
		add(txtMedico);
		txtMedico.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new PrescricaoPanel(frame, idGest, idCons));
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
		
		txtData = new JFormattedTextField();
		txtData.setForeground(new Color(255, 255, 255));
		txtData.setBackground(new Color(153, 51, 255));
		txtData.setBorder(null);
		txtData.setBounds(50, 149, 150, 30);
		txtData.setText(presc.getData());
		add(txtData);
		
		txtPresc = new JTextArea();
		txtPresc.setBackground(new Color(153, 51, 255));
		txtPresc.setForeground(new Color(255, 255, 255));
		txtPresc.setText(presc.getPrescricao());
		txtPresc.setFont(fontes.unDinaru);
		txtPresc.setBounds(50, 209, 700, 300);
		add(txtPresc);
		
		JLabel lblPrescrio = new JLabel("Prescrição");
		lblPrescrio.setForeground(Color.WHITE);
		lblPrescrio.setFont(fontes.unDinaru);
		lblPrescrio.setBounds(50, 191, 114, 15);
		add(lblPrescrio);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
