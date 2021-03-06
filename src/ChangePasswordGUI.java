import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * Changes password GUI class
 * 
 * @author Ian Tibe
 *
 */
public class ChangePasswordGUI extends JFrame {

	// data fields
	private JPanel panel; // main panel
	private JPanel oldPasswordPanel; // sub panel for old password items
	private JPanel newPasswordPanel; // sub panel for new password items
	private JPanel buttonPanel; // sub panel for buttons
	private JLabel oldPasswordLabel; // label for old password input
	private JLabel newPasswordLabel; // label for new password input
	private JPasswordField oldPasswordInput; // old password input field
	private JPasswordField newPasswordInput; // new password input field
	private JButton changePasswordButton; // change password button
	private JButton exitButton; // exit button
	private ImageIcon img; // icon image
	private changePasswordButtonAction changePasswordButtonAction;
	private exitButtonAction exitButtonAction;
	private String changePasswordButtonText = "Change Password"; // change password button text
	private String exitButtonText = "Exit"; // exit button text
	private String oldPasswordLabelText = "Input Current Password: "; // old password label text
	private String newPasswordLabelText = "Input New Password: "; // new password label text
	private String header = "Change Admin Password"; // frame header text
	private final int oldPasswordWidth = 25; // width of old password text field
	private final int newPasswordWidth = 25; // width of new password text field
	private final int WIDTH = 350; // frame width
	private final int HEIGHT = 250; // frame height
	private String iconName = "dmacc_icon.png";	//icon file name

	/**
	 * default constructor
	 */
	public ChangePasswordGUI() {
		panel = new JPanel();
		oldPasswordPanel = new JPanel();
		newPasswordPanel = new JPanel();
		buttonPanel = new JPanel();
		oldPasswordLabel = new JLabel();
		newPasswordLabel = new JLabel();
		oldPasswordInput = new JPasswordField(oldPasswordWidth);
		newPasswordInput = new JPasswordField(newPasswordWidth);
		changePasswordButton = new JButton();
		exitButton = new JButton();
		img = new ImageIcon(iconName);
		changePasswordButtonAction = new changePasswordButtonAction();
		exitButtonAction = new exitButtonAction();
	}

	/**
	 * generates window
	 */
	public void generatewindow() {
		// set up main panel
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		// set up components
		oldPasswordLabel.setText(oldPasswordLabelText);
		newPasswordLabel.setText(newPasswordLabelText);
		changePasswordButton.setText(changePasswordButtonText);
		exitButton.setText(exitButtonText);

		// add action listeners
		changePasswordButton.addActionListener(changePasswordButtonAction);
		exitButton.addActionListener(exitButtonAction);

		// create sub panels
		oldPasswordPanel.add(oldPasswordLabel);
		oldPasswordPanel.add(oldPasswordInput);
		newPasswordPanel.add(newPasswordLabel);
		newPasswordPanel.add(newPasswordInput);
		buttonPanel.add(changePasswordButton);
		buttonPanel.add(exitButton);

		// add sub panels to main panel
		panel.add(oldPasswordPanel);
		panel.add(newPasswordPanel);
		panel.add(buttonPanel);

		this.setSize(WIDTH, HEIGHT);
		this.add(panel);
		this.setTitle(header);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setIconImage(img.getImage());
		this.setVisible(true);

	}

	/**
	 * Action listener for change password button
	 * 
	 * @author Ian Tibe
	 *
	 */
	class changePasswordButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				// check old password
				Password instance = new Password();
				if (instance.passwordexist() == false) {
					throw new MissingPasswordException("Missing old password");
				}
				if (instance.validatepassword(oldPasswordInput.getPassword()) == false) {
					
					throw new OldPasswordIncorrectException("Incorrect old password");
				}
				// change password
				instance.changepassword(newPasswordInput.getPassword());
				dispose();
			} catch (IOException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(1);
			} catch (MissingPasswordException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(10);
			} catch (InvalidKeyException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(7);
			} catch (NoSuchAlgorithmException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(10);
			} catch (NoSuchPaddingException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(10);
			} catch (IllegalBlockSizeException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(10);
			} catch (BadPaddingException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(10);
			} catch (OldPasswordIncorrectException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(11);
			} catch (PasswordToShortException e) {
				ErrorGUI error = new ErrorGUI();
				error.generateMessage(12);
			}

		}

	}

	/**
	 * Action listener for exit button
	 * 
	 * @author Ian Tibe
	 *
	 */
	class exitButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();

		}

	}

}
