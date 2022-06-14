import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Geldautomat extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int guthaben;
	private static int[] scheine = {500,200,100,50,20,10,5};
	private static int zwischensumme;
	private static int summe;
	private static int i = 0;
	private static int abbuchSumme = 0;

	private JPanel contentPane;
	private JTextField textField_auszahlung;
	private JLabel lbl_log = new JLabel("");
	private JLabel lbl_guthaben = new JLabel("0");
	private String logAusgabe = "";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtn_abheben = new JRadioButton("Geld abheben");
	private JRadioButton rdbtn_einzahlen = new JRadioButton("Geld einzahlen");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Geldautomat frame = new Geldautomat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Geldautomat() {
		setTitle("Geldautomat");
		setMaximumSize(new Dimension(515, 365));
		setMinimumSize(new Dimension(515, 365));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ihr Guthaben:");
		lblNewLabel.setBounds(10, 11, 81, 14);
		contentPane.add(lblNewLabel);
		
		lbl_guthaben.setBounds(101, 11, 111, 14);
		contentPane.add(lbl_guthaben);
		
		textField_auszahlung = new JTextField();
		textField_auszahlung.setEnabled(false);
		textField_auszahlung.setBounds(101, 46, 86, 20);
		contentPane.add(textField_auszahlung);
		textField_auszahlung.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Abheben");
		lblNewLabel_2.setBounds(10, 49, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_abheben = new JButton("Betrag Abheben");
		btn_abheben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int txt2Int = Integer.parseInt(textField_auszahlung.getText());
				checkGuthaben(txt2Int);
			}
		});
		btn_abheben.setBounds(10, 84, 177, 23);
		contentPane.add(btn_abheben);
		
		
		lbl_log.setVerticalAlignment(SwingConstants.TOP);
		lbl_log.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_log.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_log.setBounds(10, 118, 358, 180);
		contentPane.add(lbl_log);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(378, 11, 111, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Einzahlen");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 89, 14);
		panel.add(lblNewLabel_3);
		
		JButton btn_500 = new JButton("500\u20AC");
		btn_500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen(500);
			}
		});
		btn_500.setBounds(10, 36, 89, 23);
		panel.add(btn_500);
		
		JButton btn_200 = new JButton("200\u20AC");
		btn_200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen(200);
			}
		});
		btn_200.setBounds(10, 70, 89, 23);
		panel.add(btn_200);
		
		JButton btn_100 = new JButton("100\u20AC");
		btn_100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen(100);
			}
		});
		btn_100.setBounds(10, 104, 89, 23);
		panel.add(btn_100);
		
		JButton btn_50 = new JButton("50\u20AC");
		btn_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen(50);
			}
		});
		btn_50.setBounds(10, 138, 89, 23);
		panel.add(btn_50);
		
		JButton btn_20 = new JButton("20\u20AC");
		btn_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen(20);
			}
		});
		btn_20.setBounds(10, 172, 89, 23);
		panel.add(btn_20);
		
		JButton btn_10 = new JButton("10\u20AC");
		btn_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen(10);
			}
		});
		btn_10.setBounds(10, 206, 89, 23);
		panel.add(btn_10);
		
		JButton btn_5 = new JButton("5\u20AC");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen(5);
			}
		});
		btn_5.setBounds(10, 240, 89, 23);
		panel.add(btn_5);
		buttonGroup.add(rdbtn_abheben);
		rdbtn_abheben.setBounds(230, 45, 109, 23);
		contentPane.add(rdbtn_abheben);
		
		buttonGroup.add(rdbtn_einzahlen);
		rdbtn_einzahlen.setSelected(true);
		rdbtn_einzahlen.setBounds(230, 11, 109, 23);
		contentPane.add(rdbtn_einzahlen);
	}
	
	private void getGuthaben() {
		lbl_guthaben.setText(guthaben+"€");
	}
	
	private void addGutenhaben(int sum) {
		guthaben = guthaben + sum;
		getGuthaben();
	}
	
	private void checkGuthaben(int sum) {	
		if(sum == 0) {			
			lbl_log.setText(sum+" € abbuchen *gg* ;-)");
		}else if (sum <= guthaben) {
			summe = sum;
			lbl_log.setText("<html>"+subGuthaben(sum)+"</html>");
			logAusgabe = "";
			abbuchSumme = 0;
			textField_auszahlung.setText("");
		}else {
			lbl_log.setText("<html>Du hast nicht genug Guthaben!<br>Du kannst nur max. "+guthaben+"€ abhaben.<html>");
			abbuchSumme = 0;
			textField_auszahlung.setText("");
		}
	}
	
	private String subGuthaben(int sum) {
		zwischensumme = sum;
		if(i < scheine.length) {
			if(sum >= scheine[i]) {
				int sum1 = sum/scheine[i];
				int sum2 = sum%scheine[i];
				zwischensumme = zwischensumme - (sum1*scheine[i]);
				summe = (sum1*scheine[i]);
				logAusgabe += "Ausgabe: " + sum1 + " x " + scheine[i] + "€<br>";
				i++;
				guthaben = guthaben - summe;
				subGuthaben(zwischensumme);
			}else {
				i++;
				subGuthaben(zwischensumme);
			}
			
		}
		i = 0;
		getGuthaben();
		return logAusgabe;
	}
	
	private void buchen(int sum) {
		if(rdbtn_abheben.isSelected()) {
			abbuchSumme = abbuchSumme + sum;
			textField_auszahlung.setText(Integer.toString(abbuchSumme));
		}else if(rdbtn_einzahlen.isSelected()) {
			addGutenhaben(sum);
		}
	}
}
