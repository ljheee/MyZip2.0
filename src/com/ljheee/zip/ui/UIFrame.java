package com.ljheee.zip.ui;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipFile;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import com.ljheee.zip.ui.about.About;
import com.ljheee.ziptool.core.ZipTool;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 * MyZip
 * 
 * @author ljheee
 *
 */
public class UIFrame {

	private JFrame jf = null;
	private JLabel leftInfo = new JLabel("״̬��:");
	private JLabel pathInfo = new JLabel("  ");
	private JLabel timeInfo = new JLabel("  ");

	private JMenuItem openFileItem, exitItem, findFileItem, viewLogItem, delLogItem, aboutItem;
	private JMenuItem switchSuanfa;


	ActionHandle handle = new ActionHandle();
	
	private JTextField srcFiles;
	private JTextField destZip;
	private JTextField srcZip;
	private JTextField destFiles;

	JButton btn_srcFiles,btn_destZip,compact,btn_srcZip,btn_destFiles,unCompact;
	JFileChooser fileChooser = new JFileChooser();
	
	JCheckBox checkBox = null;
	
	File src = null;
	File dest = null;
	File src2 = null;
	File dest2 = null;

	public UIFrame() {
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//��ѡ��Ŀ¼

		jf = new JFrame("Zip Tool 1.0");
		jf.setSize(750,510 );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);

		JPanel topJPanel = new JPanel();
		topJPanel.setLayout(new GridLayout(2, 1));

		JRootPane rootPane = new JRootPane(); // ��panel����Ӳ˵�
		rootPane.setBackground(Color.gray);
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("�ļ�(F)");
		JMenu commandMenu = new JMenu("����(C)");
		JMenu toolMenu = new JMenu("����(S)");
		JMenu optionMenu = new JMenu("ѡ��(N)");
		JMenu helpMenu = new JMenu("����(H)");

		rootPane.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(commandMenu);
		menuBar.add(toolMenu);
		menuBar.add(optionMenu);
		menuBar.add(helpMenu);

		findFileItem = new JMenuItem("�����ļ�");
		switchSuanfa = new JMenuItem("ת��ѹ����ʽ");
		findFileItem.addActionListener(handle);
		switchSuanfa.addActionListener(handle);
		toolMenu.add(findFileItem);
		toolMenu.add(switchSuanfa);

		viewLogItem = new JMenuItem("�鿴��־");
		delLogItem = new JMenuItem("�����־");
		viewLogItem.addActionListener(handle);
		delLogItem.addActionListener(handle);
		optionMenu.add(viewLogItem);
		optionMenu.add(delLogItem);

		openFileItem = new JMenuItem("��ѹ���ļ�");
		exitItem = new JMenuItem("�˳�");
		openFileItem.addActionListener(handle);
		exitItem.addActionListener(handle);

		aboutItem = new JMenuItem("����");
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(handle);

		// ���˵� ��Ӳ˵���
		fileMenu.add(openFileItem);
		fileMenu.add(exitItem);


		topJPanel.add(rootPane);// ����panel :�ļ����༭���鿴
		jf.getContentPane().add(topJPanel, BorderLayout.NORTH);
		
		

		// center
		JPanel centerP = new JPanel();
		jf.getContentPane().add(centerP, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u5F85\u538B\u7F29\u6587\u4EF6\u6E90\uFF1A");//��ѹ�����ļ�Դ
		
		srcFiles = new JTextField();
		srcFiles.setColumns(10);
		
		//���srcFiles--ѹ��
		btn_srcFiles = new JButton("\u6D4F\u89C8");//���
		
		JLabel label_1 = new JLabel("\u538B\u7F29\u5230\uFF1A");//ѹ����:
		
		destZip = new JTextField();
		destZip.setColumns(10);
		
		//view destZip
		btn_destZip = new JButton("\u6D4F\u89C8");//���
		
		//ѹ��
		compact = new JButton("\u538B\u7F29");

		
		JLabel label_2 = new JLabel("\u5F85\u89E3\u538B\u6587\u4EF6\u6E90\uFF1A");
		
		srcZip = new JTextField();
		srcZip.setColumns(10);
		
		//���--srcZip
		btn_srcZip = new JButton("\u6D4F\u89C8");
		
		
		JLabel label_3 = new JLabel("\u89E3\u538B\u5230\uFF1A");
		
		destFiles = new JTextField();
		destFiles.setColumns(10);
		
		
		//���--destFiles
		btn_destFiles = new JButton("\u6D4F\u89C8");
		
		//��ѹ
		unCompact = new JButton("\u89E3\u538B");
		
		btn_srcFiles.addActionListener(handle);
		btn_destZip.addActionListener(handle);
		btn_srcZip.addActionListener(handle);
		btn_destFiles.addActionListener(handle);
		
		compact.addActionListener(handle);
		unCompact.addActionListener(handle);
		
		//��ѹ��ɾ��Դ
		checkBox = new JCheckBox("\u89E3\u538B\u540E\u5220\u9664\u6E90");
		
		
		GroupLayout gl_centerP = new GroupLayout(centerP);
		gl_centerP.setHorizontalGroup(
			gl_centerP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerP.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_centerP.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(label_2)
						.addComponent(label_1)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING, false)
						.addComponent(destFiles)
						.addComponent(srcZip)
						.addComponent(destZip)
						.addComponent(srcFiles, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerP.createSequentialGroup()
							.addComponent(btn_srcZip)
							.addContainerGap())
						.addGroup(gl_centerP.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_centerP.createSequentialGroup()
								.addComponent(btn_srcFiles)
								.addContainerGap(206, Short.MAX_VALUE))
							.addGroup(gl_centerP.createSequentialGroup()
								.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
									.addComponent(btn_destZip)
									.addComponent(btn_destFiles))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(checkBox)
								.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
								.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
									.addComponent(unCompact)
									.addComponent(compact))
								.addGap(15)))))
		);
		gl_centerP.setVerticalGroup(
			gl_centerP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerP.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(srcFiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_srcFiles))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(destZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_destZip)
						.addComponent(compact))
					.addGap(59)
					.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
							.addComponent(srcZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_srcZip)))
					.addGap(18)
					.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(destFiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_destFiles)
						.addComponent(unCompact)
						.addComponent(checkBox))
					.addContainerGap(184, Short.MAX_VALUE))
		);
		centerP.setLayout(gl_centerP);
		

		// south--״̬��
		JToolBar bottomToolBar = new JToolBar();
		bottomToolBar.setFloatable(false);// ����JToolBar�����϶�

		bottomToolBar.setPreferredSize(new Dimension(jf.getWidth(), 20));
		bottomToolBar.add(leftInfo);

		// bottomToolBar.addSeparator(); //�˷�����ӷָ��� ��Ч
		JSeparator jsSeparator = new JSeparator(SwingConstants.VERTICAL);
		bottomToolBar.add(jsSeparator);// ��ӷָ���

		leftInfo.setPreferredSize(new Dimension(200, 20));
		leftInfo.setHorizontalTextPosition(SwingConstants.LEFT);

		bottomToolBar.add(pathInfo);
		pathInfo.setHorizontalTextPosition(SwingConstants.LEFT);
		bottomToolBar.add(new JSeparator(SwingConstants.VERTICAL));// ��ӷָ���

		bottomToolBar.add(timeInfo);
		timeInfo.setPreferredSize(new Dimension(70, 20));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		timeInfo.setText(sdf.format(new Date()));

		jf.getContentPane().add(bottomToolBar, BorderLayout.SOUTH);// ����--�š�״̬����

		jf.setVisible(true);
	}

	/**
	 * ������˵�--�¼�����
	 * @author ljheee
	 *
	 */
	class ActionHandle implements ActionListener {

		File f = null;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == openFileItem) { // 
				
			}

			if (e.getSource() == exitItem) {// exit application
				System.exit(0);
			}

			if (e.getSource() == aboutItem) {// show about
//				JOptionPane.showMessageDialog(jf, "@Author:ljheee \n 2016");
				new About(jf,"����",true);
			}

			if (e.getSource() == findFileItem) {// viewItem 
				jf.repaint();
			}

			if (e.getSource() == switchSuanfa) {// �л�ѹ���㷨
												// 
			}

			if (e.getSource() == viewLogItem) {// �鿴��־

			}

			if (e.getSource() == delLogItem) {// ɾ����־
				
			}
			
			if (e.getSource() == btn_srcFiles){//ѡ��yaoѹ�����ļ�·��
				fileChooser.showOpenDialog(jf);
				src = fileChooser.getSelectedFile();
				System.out.println(src);
				srcFiles.setText(src.getAbsolutePath());
			}
			
			if (e.getSource() == btn_destZip){//ѡ��ѹ�����ļ�--Ŀ��·��
				fileChooser.showOpenDialog(jf);
				f = fileChooser.getSelectedFile();
				destZip.setText(f.getAbsolutePath());
			}
			if (e.getSource() == compact){//ѹ���ļ�
				dest = new File(f.getAbsolutePath(), src.getName()+".zip");
				System.out.println(dest.getName());
//				new CompactAlgorithm(dest).zipFiles(src);
				try {
					ZipTool.zip(new File[]{src}, dest);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(jf, "ѹ�����");
			}
			
			
			if (e.getSource() == btn_srcZip){//ѡ��yao�������ļ�
				fileChooser.showOpenDialog(jf);
				src2 = fileChooser.getSelectedFile();
				srcZip.setText(src2.getAbsolutePath());
			}
			if (e.getSource() == btn_destFiles){//ѡ������ļ�--Ŀ��·��
				fileChooser.showOpenDialog(jf);
				dest2 = fileChooser.getSelectedFile();
				destFiles.setText(dest2.getAbsolutePath());
			}
			if (e.getSource() == unCompact){//��ѹ�ļ�
				File src22 = new File(src2.getAbsolutePath());
				src2 = null;
				System.gc();
				try {
					String targetName = dest2.getAbsolutePath().replaceAll("\\*", "/")+"/"+src22.getName().substring(0, src22.getName().lastIndexOf('.'));
					ZipTool.unzip(src22, new File(targetName));
					
					if(checkBox.isSelected()){
						boolean b = src22.delete();//��ѹ��ɾ��Դ
						
						System.out.println("��ѹ��ɾ��Դ"+b);
					}
					JOptionPane.showMessageDialog(jf, "��ѹ���");
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(jf, "��ѹError"+e1.getMessage());
				}
			}

		}
	}

}
