import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class ECSSystem
{
    static ECSPanel dueTimePanel, moduleCodePanel, moduleTitlePanel, tutorPanel,courseNumberPanel, courseTitlePanel,issueDatePanel, dueDatePanel, typePanel, markPanel;
    final static boolean MULTICOLORED = false;
    JButton downloadButton = new JButton("Download");
    JTextField studentIDText = new JTextField(20);
    JPanel mainPane;
    JTextArea log;
    JLabel outputLabel = new JLabel();
    JTextField studentNameText = new JTextField(20);

    Map<String, Student> login = new HashMap<>();

//user interface
    public ECSSystem() {

        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame mainFrame = new JFrame("Output");
                mainFrame.setSize(400,400);
                mainFrame.setLayout(new GridLayout(3, 1));
                JLabel headerLabel = new JLabel("Module Code : " + moduleCodePanel.textField.getText());
                JLabel headerLabel1 = new JLabel("Module Title : " + moduleTitlePanel.textField.getText());
                JLabel headerLabel2 = new JLabel("Module Tutor : " + tutorPanel.textField.getText());
                JLabel headerLabel3 = new JLabel("Coursework Number : " + courseNumberPanel.textField.getText());
                JLabel headerLabel4 = new JLabel("Coursework Title : " + courseTitlePanel.textField.getText());
                JLabel headerLabel5 = new JLabel("Issue Date : " + issueDatePanel.textField.getText());
                JLabel headerLabel6 = new JLabel("Due Date : " + dueDatePanel.textField.getText());
                JLabel headerLabel7 = new JLabel("Due Time : " + dueTimePanel.textField.getText());
                JLabel headerLabel8 = new JLabel("Assessment Type : " + typePanel.textField.getText());
                JLabel headerLabel9 = new JLabel("% of Module Mark : " + markPanel.textField.getText());
                JLabel userLabel = new JLabel("Student ID :");
                userLabel.setBounds(10, 10, 80, 25);
                studentIDText.setBounds(100, 10, 160, 25);
                studentIDText.setText("");
                JLabel passwordLabel = new JLabel("Student Name :");
                passwordLabel.setBounds(10, 40, 80, 25);
                studentNameText.setBounds(100, 40, 160, 25);
                studentNameText.setText("");
                mainFrame.setLayout(new GridLayout(20, 1));

                mainFrame.add(headerLabel);
                mainFrame.add(headerLabel1);
                mainFrame.add(headerLabel2);
                mainFrame.add(headerLabel3);
                mainFrame.add(headerLabel4);
                mainFrame.add(headerLabel5);
                mainFrame.add(headerLabel6);
                mainFrame.add(headerLabel7);
                mainFrame.add(headerLabel8);
                mainFrame.add(headerLabel9);
                mainFrame.add(userLabel);
                mainFrame.add(studentIDText);
                mainFrame.add(passwordLabel);
                mainFrame.add(studentNameText);
                mainFrame.add(downloadButton);
                mainFrame.add(outputLabel);
                mainFrame.setVisible(true);
            }
        });
        downloadButton.addActionListener(new ActionListener() 
 {
            Student student;
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter writer = new PrintWriter("Output.txt", "UTF-8");
                    writer.println( "Module Code : " + moduleCodePanel.textField.getText());
                    writer.println("Module Title : " + moduleTitlePanel.textField.getText());
                    writer.println("Module Tutor : " + tutorPanel.textField.getText());
                    writer.println("CourseWork Number : " + courseNumberPanel.textField.getText());
                    writer.println("CourseWork Title : " + courseTitlePanel.textField.getText());
                    writer.println("Issue Date : " + issueDatePanel.textField.getText());
                    writer.println("Due Date : " + dueDatePanel.textField.getText());
                    writer.println("Due Time : " + dueTimePanel.textField.getText());
                    writer.println("Assessment Type : " + typePanel.textField.getText());
                    writer.println("% of Module Mark : " + markPanel.textField.getText());
                    writer.println("Student ID" + studentIDText.getText());
                    writer.println("Student Name" + studentNameText.getText());
                    student = new Student(studentIDText.getText(), studentNameText.getText());
                    login.put(studentIDText.getText(), student);
                    
                    student.setInfo(dueTimePanel.textField.getText(), moduleCodePanel.textField.getText(), moduleTitlePanel.textField.getText(), tutorPanel.textField.getText(),courseNumberPanel.textField.getText(), courseTitlePanel.textField.getText(),issueDatePanel.textField.getText(), dueDatePanel.textField.getText(), typePanel.textField.getText(), markPanel.textField.getText());
                    writer.close();
                }
                catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                outputLabel.setText("File Downloaded as Output.txt");
                
                //Display the window.
                frame.pack();
                frame.setVisible(true);

            }
        });
        moduleCodePanel = new ECSPanel(this, "Module Code", "String");

        moduleTitlePanel = new ECSPanel(this, "Title", "String");
        tutorPanel = new ECSPanel(this, "Module Tutor", "String");

        courseNumberPanel = new ECSPanel(this, "CourseWork Number", "number");
        courseTitlePanel = new ECSPanel(this, "CourseWork Title", "String");
        issueDatePanel = new ECSPanel(this, "Issue Date", "date");

        dueDatePanel = new ECSPanel(this, "Due Date", "date");

        dueTimePanel = new ECSPanel(this, "Due Time", "time");

        typePanel = new ECSPanel(this, "Assessment Type", "String");

        markPanel = new ECSPanel(this, "% of Module Mark", "number");
        
        mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        if (MULTICOLORED) {
            mainPane.setOpaque(true);
            mainPane.setBackground(new Color(255, 0, 0));
        }
        mainPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(moduleCodePanel);
        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(moduleTitlePanel);
        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(tutorPanel);

        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(courseNumberPanel);

        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(courseTitlePanel);

        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(issueDatePanel);

        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(dueDatePanel);

        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(dueTimePanel);
        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(typePanel);

        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(markPanel);
        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(javaButton);
        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPane.add(loginButton);
        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));

        mainPane.add(Box.createGlue());
        
    }
    
        private static void createAndShowGUI() {

        JFrame frame = new JFrame("ECSSystem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ECSSystem ECSSystem = new ECSSystem();
        ECSSystem.mainPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(ECSSystem.mainPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}

    
        
