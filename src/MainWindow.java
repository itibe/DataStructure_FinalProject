import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Ian Tibe
 *
 */
public class MainWindow extends JFrame{
	
		//Ian Tibe
		//data fields
		//main panel is seperated into three sections, top, bottom, middle
		//top contains quick action buttons, center is image, and bottom is status panel
		private JPanel centerWindow;	//center section sub panel
		private JPanel topWindow;		//top section sub panel
		private JPanel bottomWindow;	//bottom section sub panel
		private JPanel panel;		//main panel
		private JLabel statusBoard;	//label for bottom section
		private JLabel imageBoard;	//label on which picture is place
		private JMenuBar menu;		//menu bar
		private JMenu fileMenu;		//file menu item
		private JMenu functionsMenu;	//function menu item
		private JMenu adminMenu;	//admin menu
		private JMenu aboutMenu;	//about menu
		private JMenuItem exitMenuItem;	//exit menu item
		private JMenuItem addStudentMenuItem;	//add student menu item
		private JMenuItem addClassMenuItem;		// add class menu item
		private JMenuItem takeAttendanceMenuItem;	//take attendance menu item
		private JMenuItem changeAdminPasswordMenuItem;	//change admin password item
		private JMenuItem aboutMenuItem;	//about menu item
		private JButton takeAttendanceButton;	//take atteendance button
		private JButton addClassButton;	//add class button
		private JButton addStudentButton;	//add student button
		private ImageIcon mainImage;	//center image
		private String fileMenuText = "File";	//text for file menu
		private String functionsMenuText = "Functions";	//text for function menu
		private String adminMenuText = "Admin";	//text for admin menu
		private String aboutMenuText = "About";	//text for about menu
		private String exitMenuItemText = "Exit";	//test for exit menu item
		private String addStudentMenuItemText = "Add Student";	//text for add student menu item
		private String addClassMenuItemText = "Add Class";	//text for add class menu item
		private String takeAttendanceMenuItemText = "Take Attendance";	//test for take attendance menu item
		private String changeAdminPasswordMenuItemText = "Change Password";	//text for change admin password menu item
		private String aboutMenuItemText = "About DMACC Attendance";	//text for about menu item
		private String takeAttendanceButtonText = "Take Attendance";	//text for take attendance button
		private String addClassButtonText = "Add Class";	//text for add class button
		private String addStudentButtonText = "Add Student";	//text for add student button
		private String imageName = "urban.jpg";	//	image class for center image
		private String header = "DMACC Attendance";	//main window frame title
		private final int WIDTH = 900;	//main frame width
		private final int HEIGHT = 660;	//main fram height
		private exitMenuItemAction exitMenuItemActionActionListener;	//action listener exit
		private addStudentMenuItemAction addStudentMenuItemAction;	//action listener add student
		private addClassMenuItemAction addClassMenuItemAction;	//action listener add class
		private takeAttendanceMenuItemAction takeAttendanceMenuItemAction;	//action listener for take attenedance
		private changeAdminPasswordMenuItemAction changeAdminPasswordMenuItemAction;	//action listener for change pasword
		private aboutMenuItemAction aboutMenuItemAction;	//action listener for about menu 
		private ImageIcon img; //icon image
		private String iconName = "C:\\Users\\Ian Tibe\\DataStructure_FinalProject\\src\\dmacc_icon.png";
		
		//constructor
		/**
		 * default constructor
		 */
		public MainWindow()
		{
			
			imageBoard =  new JLabel("", mainImage, JLabel.CENTER);
			centerWindow = new JPanel(new BorderLayout());
			topWindow = new JPanel();
			bottomWindow = new JPanel();
			panel = new JPanel();
			statusBoard = new JLabel();
			menu = new JMenuBar();
			fileMenu = new JMenu();
			functionsMenu = new JMenu();
			adminMenu = new JMenu();
			aboutMenu = new JMenu();
			exitMenuItem = new JMenuItem();
			addStudentMenuItem = new JMenuItem();
			addClassMenuItem = new JMenuItem();
			takeAttendanceMenuItem = new JMenuItem();
			changeAdminPasswordMenuItem = new JMenuItem();
			aboutMenuItem = new JMenuItem();
			takeAttendanceButton = new JButton();
			addClassButton = new JButton();
			addStudentButton = new JButton();
			mainImage = new ImageIcon("C:\\Users\\Ian Tibe\\DataStructure_FinalProject\\src\\urban3.jpg");
			exitMenuItemActionActionListener = new exitMenuItemAction();
			addStudentMenuItemAction = new addStudentMenuItemAction();
			addClassMenuItemAction = new addClassMenuItemAction();
			takeAttendanceMenuItemAction = new takeAttendanceMenuItemAction();
			changeAdminPasswordMenuItemAction = new changeAdminPasswordMenuItemAction();
			aboutMenuItemAction = new aboutMenuItemAction();
			img = new ImageIcon(iconName);
		}
		
		/**
		 * generates main window
		 */
		public void generateWindow()
		{
			//create menu
			fileMenu.setText(fileMenuText);
			functionsMenu.setText(functionsMenuText);
			adminMenu.setText(adminMenuText);
			aboutMenu.setText(aboutMenuText);
			exitMenuItem.setText(exitMenuItemText);
			addStudentMenuItem.setText(addStudentMenuItemText);
			addClassMenuItem.setText(addClassMenuItemText);
			takeAttendanceMenuItem.setText(takeAttendanceMenuItemText);
			changeAdminPasswordMenuItem.setText(changeAdminPasswordMenuItemText);
			aboutMenuItem.setText(aboutMenuItemText);
			
			//set action listeners for menu items
			exitMenuItem.addActionListener(exitMenuItemActionActionListener);
			addStudentMenuItem.addActionListener(addStudentMenuItemAction);
			addClassMenuItem.addActionListener(addClassMenuItemAction);
			takeAttendanceMenuItem.addActionListener(takeAttendanceMenuItemAction);
			changeAdminPasswordMenuItem.addActionListener(changeAdminPasswordMenuItemAction);
			aboutMenuItem.addActionListener(aboutMenuItemAction);
			
			//build menu
			menu.add(fileMenu);
			menu.add(functionsMenu);
			menu.add(adminMenu);
			menu.add(aboutMenu);
			fileMenu.add(exitMenuItem);
			functionsMenu.add(addClassMenuItem);
			functionsMenu.add(addStudentMenuItem);
			functionsMenu.add(takeAttendanceMenuItem);
			adminMenu.add(changeAdminPasswordMenuItem);
			aboutMenu.add(aboutMenuItem);
			
			
			
			
			//set up statusboard
			statusBoard.setBorder(BorderFactory.createLineBorder(Color.black));
			statusBoard.setText("Status: Welcome to DMACC Attendance");
			statusBoard.setPreferredSize(new Dimension(875,25));
			
			//setup image
			imageBoard.setIcon(mainImage);
			
			//add button text
			addClassButton.setText(addClassButtonText);
			addStudentButton.setText(addStudentButtonText);
			takeAttendanceButton.setText(takeAttendanceButtonText);
			
			//add action listeners to buttons
			addClassButton.addActionListener(addClassMenuItemAction);
			addStudentButton.addActionListener(addStudentMenuItemAction);
			takeAttendanceButton.addActionListener(takeAttendanceMenuItemAction);
			
			//add items to sub panel
			topWindow.add(addClassButton);
			topWindow.add(addStudentButton);
			topWindow.add(takeAttendanceButton);
			topWindow.setBackground(Color.BLUE);
						
			centerWindow.add(imageBoard);
		
			bottomWindow.add(statusBoard);
			bottomWindow.setBackground(Color.white);
			
			
			//add sub panels to main panel
			panel.setLayout(new BorderLayout());
			panel.add(centerWindow,BorderLayout.CENTER);
			panel.add(topWindow, BorderLayout.NORTH);
			panel.add(bottomWindow, BorderLayout.SOUTH);
			
			//configure main JFrame
			this.setSize(WIDTH, HEIGHT);
			this.add(panel);
			this.setTitle(header);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setJMenuBar(menu);
			this.setLocation(getX(), getY());
			this.setIconImage(img.getImage());
			this.setVisible(true);
			
					
		}
		
		/**
		 * 
		 * Action Listener for exit menu item
		 * @author Ian Tibe
		 *
		 */
		class exitMenuItemAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//exits program
				System.exit(0);
				
			}
			
		}
		
		/**
		 * action listener for add student menu item
		 * @author Ian Tibe
		 *
		 */
		class addStudentMenuItemAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("add studetn selected");
				
			}
			
		}
		
		/**
		 * Action Listener for add class menu item
		 * @author Ian Tibe
		 *
		 */
		class addClassMenuItemAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("add class selected");
				
			}
			
		}
		/**
		 * Action listener for take attendance menu item
		 * @author Ian Tibe
		 *
		 */
		class takeAttendanceMenuItemAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("take attendance selected");
				
			}
			
		}
		
		/**
		 * Action listener for change admin password menu item
		 * @author Ian Tibe
		 *
		 */
		class changeAdminPasswordMenuItemAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("change admin password");
				
			}
			
		}
		
		/**
		 * 
		 * Action listener for about menu item
		 * @author Ian Tibe
		 *
		 */
		class aboutMenuItemAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("About menu items selected");
				AboutGUI display = new AboutGUI();
				display.generateWindow();
				
			}
			
		}

}
