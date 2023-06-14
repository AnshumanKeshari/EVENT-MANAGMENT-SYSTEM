import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EventManagementSystem extends JFrame implements ActionListener {
   //Declare GUI components as instance variables
   JLabel eventLabel, dateLabel, timeLabel;
   JTextField eventField, dateField, timeField, usernameField;
   JButton addBtn, viewBtn, clearBtn, loginBtn , registerBtn;
   ;
   JTable eventsTable;
   DefaultTableModel tableModel;

   //Declare login page components as instance variables
   JFrame loginFrame;
   JLabel usernameLabel, passwordLabel;
   JTextField passwordField;
   JButton submitBtn;
   

   public EventManagementSystem() {
      //Set up the JFrame
      setTitle("Event Management System");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600, 500);
      setLayout(new BorderLayout());

      //Initialize GUI components
      JPanel inputPanel = new JPanel(new GridLayout(5, 2));
      eventLabel = new JLabel("Event Name:");
      dateLabel = new JLabel("Date:");
      timeLabel = new JLabel("Time:");
      eventField = new JTextField();
      dateField = new JTextField();
      timeField = new JTextField();
      addBtn = new JButton("Add Event");
      viewBtn = new JButton("View Events");
      clearBtn = new JButton("Clear Fields");
      inputPanel.add(eventLabel);
      inputPanel.add(eventField);
      inputPanel.add(dateLabel);
      inputPanel.add(dateField);
      inputPanel.add(timeLabel);
      inputPanel.add(timeField);
      inputPanel.add(addBtn);
      inputPanel.add(viewBtn);
      inputPanel.add(clearBtn);
      add(inputPanel, BorderLayout.NORTH);


      //Create table for events
      eventsTable = new JTable();
      tableModel = new DefaultTableModel(new Object[]{"Event Name", "Date", "Time"}, 0);
      eventsTable.setModel(tableModel);
      JScrollPane scrollPane = new JScrollPane(eventsTable);
      add(scrollPane, BorderLayout.CENTER);



      //Register event listeners for buttons
      addBtn.addActionListener(this);
      viewBtn.addActionListener(this);
      clearBtn.addActionListener(this);



      //Create login page
      loginFrame = new JFrame("Login");
      loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      loginFrame.setSize(800, 500);
      loginFrame.setLayout(new GridLayout(5, 2));
      usernameLabel = new JLabel("Username:");
      passwordLabel = new JLabel("Password:");
      usernameField = new JTextField();
      passwordField = new JTextField();
      loginBtn = new JButton("Login");
      clearBtn = new JButton("clear");
      loginFrame.add(usernameLabel);
      loginFrame.add(usernameField);
      loginFrame.add(passwordLabel);
      loginFrame.add(passwordField);
      loginFrame.add(loginBtn);
      loginFrame.add(clearBtn);
      registerBtn = new JButton("Register");
      loginFrame.add(registerBtn);

      registerBtn.addActionListener(this);
      loginBtn.addActionListener(this);
      clearBtn.addActionListener(this);


      //Make JFrame visible
      setVisible(false);
      loginFrame.setVisible(true);
   }

   
   

   //Handle button click events
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == loginBtn) {
         //Handle Login button click
         String username = usernameField.getText();
         String password = passwordField.getText();
         //Add code here to validate the username and password
         //If the username and password are valid, show the EventManagementSystem JFrame
         if (username.equals("Anshuman") && password.equals("123")) {
            loginFrame.setVisible(false);
            setVisible(true);
         } else {
            JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.");
         }
      } else if (e.getSource() == addBtn) {



         //Handle Add Event button click
         String event = eventField.getText();
         String date = dateField.getText();
         String time = timeField.getText();
         //Add code here to store event data in a database or file
         tableModel.addRow(new Object[]{event, date, time});
         JOptionPane.showMessageDialog(this, "Event added successfully.");
      } else if (e.getSource() == viewBtn) {
         //Handle View Events button click
         //Add code here to display events from database or file
         viewEvents();
      } else if (e.getSource() == clearBtn) {
         //Handle Clear Fields button click
         eventField.setText("");
         dateField.setText("");
         timeField.setText("");
      } else if (e.getSource() == registerBtn) {
         //Handle Register button click
         JFrame registerFrame = new JFrame("Register");
         registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         registerFrame.setSize(500, 250);
         registerFrame.setLayout(new GridLayout(5, 2));
         JLabel nameLabel = new JLabel("Name:");
         JLabel emailLabel = new JLabel("Email:");
         JLabel regUsernameLabel = new JLabel("Username:");
         JLabel regPasswordLabel = new JLabel("Password:");
         JTextField nameField = new JTextField();
         JTextField emailField = new JTextField();
         JTextField regUsernameField = new JTextField();
         JTextField regPasswordField = new JTextField();
         JButton registerSubmitBtn = new JButton("Register");
         JButton registerClearBtn = new JButton("Clear");
         registerFrame.add(nameLabel);
         registerFrame.add(nameField);
         registerFrame.add(emailLabel);
         registerFrame.add(emailField);
         registerFrame.add(regUsernameLabel);
         registerFrame.add(regUsernameField);
         registerFrame.add(regPasswordLabel);
         registerFrame.add(regPasswordField);
         registerFrame.add(registerSubmitBtn);
         registerFrame.add(registerClearBtn);
         registerSubmitBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //Add code here to store user registration information in a database or file
                 String name = nameField.getText();
                 String email = emailField.getText();
                 String username = regUsernameField.getText();
                 String password = regPasswordField.getText();
                 JOptionPane.showMessageDialog(registerFrame, "User registered successfully.");
                 registerFrame.dispose();
             }
         });
         registerClearBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 nameField.setText("");
                 emailField.setText("");
                 regUsernameField.setText("");
                 regPasswordField.setText("");
             }
         });
         registerFrame.setVisible(true);
     }
     
   }



   //Displays events in a JTable
   private void viewEvents() {
      //Clear existing table data
      tableModel.setRowCount(0);
      //Add code here to retrieve event data from database or file
      //For demonstration purposes, we'll add some sample data
      tableModel.addRow(new Object[]{"Event 1", "2023-04-15", "10:00 AM"});
      tableModel.addRow(new Object[]{"Event 2", "2023-04-20", "2:00 PM"});
      tableModel.addRow(new Object[]{"Event 3", "2023-05-01", "9:00 AM"});
   }

   
   public static void main(String[] args) {
      //Create new instance of EventManagementSystem
      new EventManagementSystem();
   }
}