import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.security.SecureRandom;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vernam extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea_EinAusgabe = new JTextArea();
	private JRadioButton rdbtn_crypt = new JRadioButton("Verschl\u00FCsseln");
	private JRadioButton rdbtnuncrypt = new JRadioButton("Entschl\u00FCsseln");
	private JButton btn_goCrypt = new JButton("Key erstellen & verschl\u00FCsseln");
	private JTextArea textArea_key = new JTextArea();
	private JLabel lblDeinSchlssel = new JLabel("Dein Schl\u00FCssel");
	
	private String text;
	private int textLen;
	private String keyText;
	private String cryptText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vernam frame = new Vernam();
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
	public Vernam() {
		setTitle("Vernam Master 1.3 by Musti 2022");
		setMaximumSize(new Dimension(640, 480));
		setMinimumSize(new Dimension(640, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 604, 180);
		contentPane.add(scrollPane);
		
		
		textArea_EinAusgabe.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(textArea_EinAusgabe);
		textArea_EinAusgabe.setLineWrap(true);
		textArea_EinAusgabe.setWrapStyleWord(true);
		
		JLabel lblNewLabel = new JLabel("Ein & Ausgabe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 150, 14);
		contentPane.add(lblNewLabel);
		
		
		buttonGroup.add(rdbtn_crypt);
		rdbtn_crypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn_crypt.isSelected()) {
					btn_goCrypt.setText("Key erstellen & verschl�sseln");
					lblNewLabel.setText("Ein & Ausgabe");
				}
			}
		});
		rdbtnuncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnuncrypt.isSelected()) {
					btn_goCrypt.setText("Text entschl�sseln");
					lblNewLabel.setText("Geheimtext hier");
				}
			}
		});
		rdbtn_crypt.setSelected(true);
		rdbtn_crypt.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtn_crypt.setBounds(266, 6, 140, 23);
		contentPane.add(rdbtn_crypt);
		buttonGroup.add(rdbtnuncrypt);
		rdbtnuncrypt.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnuncrypt.setBounds(416, 7, 140, 23);
		contentPane.add(rdbtnuncrypt);
		btn_goCrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getText();
				if(rdbtn_crypt.isSelected()) {
					createKeyword(textLen);
					cryptText();
				}else if(rdbtnuncrypt.isSelected()) {
					uncryptText();
				}
				

			}
		});
		
		
		btn_goCrypt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_goCrypt.setBounds(179, 227, 260, 23);
		contentPane.add(btn_goCrypt);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 261, 604, 169);
		contentPane.add(scrollPane_1);
		textArea_key.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textArea_key.setLineWrap(true);
		textArea_key.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textArea_key);
		
		lblDeinSchlssel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeinSchlssel.setBounds(10, 236, 150, 14);
		contentPane.add(lblDeinSchlssel);
	}
	
	private void createKeyword(int keyLen) {		
		
		String key0 = "0123456789";
		String key1 = "abcdefghijklmnopqrstuvwxyz";
		String key2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String key3 = "!?#=&%$";
		String allKeys = key0+key1+key2+key3;
		
		SecureRandom rand = new SecureRandom();
		StringBuilder secureKey = new StringBuilder(keyLen);
		
		for(int i = 1; i <= keyLen; i++) {
			secureKey.append(allKeys.charAt(rand.nextInt(allKeys.length())));
		}	
		
		keyText = secureKey.toString();
		textArea_key.setText(keyText);
		
	}
	
	private void getText() {
		text = textArea_EinAusgabe.getText();
		textLen = text.length();
	}
	
	private void cryptText() {
		StringBuilder ascii = new StringBuilder();
		
		for(int i = 0; i < textLen; i++) {
			int klarTxt = text.charAt(i);
			int keyTxt = keyText.charAt(i);
			int modTxt = ((klarTxt+keyTxt)%256);
			char cryptChar = (char) modTxt;
			ascii.append(cryptChar);
		}
		
		cryptText = ascii.toString();
		textArea_EinAusgabe.setText(cryptText);
		
	}
	
	private void uncryptText() {
		StringBuilder ascii = new StringBuilder();
		
		String cryptkeys = textArea_key.getText();
		String cryptText = textArea_EinAusgabe.getText();
		
		
		for(int i = 0; i < textLen; i++) {
			int cryptKey = cryptkeys.charAt(i);
			int cryptTxt = cryptText.charAt(i);
			int orgTextAscii = (cryptTxt>256 ? cryptTxt+256 : cryptTxt)-cryptKey;
			char charTxt = (char) orgTextAscii;
			ascii.append(charTxt);
		}
		
		textArea_EinAusgabe.setText(ascii.toString());
		
	}
	
}
