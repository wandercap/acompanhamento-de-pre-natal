package view.panels.exame;

import java.awt.Color;
import java.awt.Font;
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

import control.dao.textfiledao.TextFileExameDao;
import model.Exame;
import view.panels.laudo.LaudoPanel;

/**
 * A classe {@code ListExamRealiPanel} gera o panel com a lista de exames realizados
 * @author Wanderlan Carvalho
 *
 */

public class ListExamRealiPanel extends JPanel {
	private static final long serialVersionUID = 2231455156863387840L;
	private TextFileExameDao exam;
	private JTable table;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ListExamRealiPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblExamesRealizados = new JLabel("Exames Realizados");
		lblExamesRealizados.setBounds(227, 35, 321, 48);
		lblExamesRealizados.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblExamesRealizados.setForeground(new Color(255, 255, 255));
		add(lblExamesRealizados);
		
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
		btnVoltar.setFont(new Font("Raleway", Font.PLAIN, 20));
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(50, 530, 200, 40);
		add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(153, 51, 255));
		scrollPane.getViewport().setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(50, 95, 704, 423);
		add(scrollPane);
		
		exam = new TextFileExameDao();
		
		String[] colNomes = {"ID", "Data", "Horário", "Local", "Especialidade", "Médico", "Comentários", "Realizado"};
		ArrayList<Exame> lista = exam.listar();
		DefaultTableModel tableModel = new DefaultTableModel(colNomes, 0);
		
		table = new JTable(tableModel);
		table.setBackground(new Color(153, 51, 255));
		table.setForeground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idExam = (int) table.getValueAt(table.rowAtPoint(e.getPoint()), 0);
				frame.setContentPane(new LaudoPanel(frame, idGest, -1, idExam));
				frame.revalidate();
				frame.repaint();
			}
		});
		table.setBounds(50, 95, 704, 423);
		//add(table);
		scrollPane.setViewportView(table);
		
		for(Exame ex : lista) {
			if((ex.getIdGest() == idGest)&&(ex.isRealizado() ==  true)) {
				Object[] data = {ex.getId(), ex.getData(), ex.getHorario(), ex.getLocal(), ex.getEspecialidade(), ex.getMedico(), ex.getComentarios(), "Sim"};
			
				tableModel.addRow(data);
			}
		}
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("/home/wanderlan/workspace/M@e Digital/img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
