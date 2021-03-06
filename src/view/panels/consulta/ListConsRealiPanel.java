package view.panels.consulta;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.dao.textfiledao.TextFileConsultaDao;
import model.Consulta;
import view.FontsProj;
import view.panels.prescricao.PrescricaoPanel;

/**
 * A classe {@code ListConsRealiPanel} gera o panel com a lista de consultas realizadas
 * @author Wanderlan Carvalho
 *
 */

public class ListConsRealiPanel extends JPanel {
	private static final long serialVersionUID = 2025089466083834981L;
	private TextFileConsultaDao cons;
	private JTable table;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ListConsRealiPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		FontsProj fontes = new FontsProj();
		
		JLabel lblConsultasRealizadas = new JLabel("Consultas Realizadas");
		lblConsultasRealizadas.setBounds(220, 35, 393, 48);
		lblConsultasRealizadas.setFont(fontes.unDinaruB);
		lblConsultasRealizadas.setForeground(new Color(255, 255, 255));
		add(lblConsultasRealizadas);
		
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
		btnVoltar.setFont(fontes.Raleway);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(50, 530, 200, 40);
		add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(153, 51, 255));
		scrollPane.getViewport().setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(50, 95, 704, 423);
		add(scrollPane);
		
		cons = new TextFileConsultaDao();
		
		String[] colNomes = {"ID", "Data", "Horário", "Local", "Especialidade", "Médico", "Comentários", "Realizada"};
		ArrayList<Consulta> lista = cons.listar();
		DefaultTableModel tableModel = new DefaultTableModel(colNomes, 0);
		
		table = new JTable(tableModel);
		table.setBackground(new Color(153, 51, 255));
		table.setForeground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idCons = (int) table.getValueAt(table.rowAtPoint(e.getPoint()), 0);
				frame.setContentPane(new PrescricaoPanel(frame, idGest, idCons));
				frame.revalidate();
				frame.repaint();
			}
		});
		table.setBounds(50, 95, 704, 423);
		//add(table);
		scrollPane.setViewportView(table);
		
		for(Consulta c : lista) {
			if((c.getIdGest() == idGest)&&(c.isRealizada() ==  true)) {
				Object[] data = {c.getId(), c.getData(), c.getHorario(), c.getLocal(), c.getEspecialidade(), c.getMedico(), c.getComentarios(), "Sim"};
			
				tableModel.addRow(data);
			}
		}
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("./img/backgroundx.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}


}
