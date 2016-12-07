package view.panels.procedimento;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.dao.textfiledao.TextFileProcedimentoDao;
import model.Procedimento;

/**
 * A classe {@code ListProcAgendPanel} gera o panel com a lista de procedimentos agendadas
 * @author Wanderlan Carvalho
 *
 */

public class ListProcAgendPanel extends JPanel {
	private static final long serialVersionUID = 5769704682830146895L;
	private TextFileProcedimentoDao proc;
	private JTable table;

	/**
	 * Gera o Panel
	 * @param frame
	 * @param idGest
	 */
	public ListProcAgendPanel(JFrame frame, int idGest) {
		setBackground(new Color(204, 153, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblExamesAgendados = new JLabel("Procedimentos Agendados");
		lblExamesAgendados.setBounds(188, 35, 463, 48);
		lblExamesAgendados.setFont(new Font("UnDinaru", Font.BOLD, 40));
		lblExamesAgendados.setForeground(new Color(255, 255, 255));
		add(lblExamesAgendados);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ProcedimentosPanel(frame, idGest));
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
		
		proc = new TextFileProcedimentoDao();
		
		String[] colNomes = {"ID", "Data", "Horário", "Local", "Especialidade", "Médico", "Comentários", "Realizado"};
		ArrayList<Procedimento> lista = proc.listar();
		DefaultTableModel tableModel = new DefaultTableModel(colNomes, 0);
		
		table = new JTable(tableModel);
		table.setBackground(new Color(153, 51, 255));
		table.setForeground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idProc = (int) table.getValueAt(table.rowAtPoint(e.getPoint()), 0);
				Procedimento p = new Procedimento(proc.buscar(idProc));
				Object[] opt = {"Sim", "Não"};
				int n = JOptionPane.showOptionDialog(ListProcAgendPanel.this, "Este procedimento foi realizado?", "Procedimento!",
					    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);
				
				if(n==0) {
					p.setRealizado(true);
					if(proc.alterar(p) == true)
						JOptionPane.showMessageDialog(ListProcAgendPanel.this, "Procedimento realizado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(ListProcAgendPanel.this, "Erro ao alterar o procedimento!", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		table.setBounds(50, 95, 704, 423);
		//add(table);
		scrollPane.setViewportView(table);
		
		for(Procedimento p : lista) {
			if((p.getIdGest() == idGest)&&(p.isRealizado() ==  false)) {
				Object[] data = {p.getId(), p.getData(), p.getHorario(), p.getLocal(), p.getEspecialidade(), p.getMedico(), p.getComentarios(), "Não"};
			
				tableModel.addRow(data);
			}
		}
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("/home/wanderlan/workspace/M@e Digital/img/background.png"));
		background.setBounds(0, 0, 800, 600);
	    add(background);
	}

}
