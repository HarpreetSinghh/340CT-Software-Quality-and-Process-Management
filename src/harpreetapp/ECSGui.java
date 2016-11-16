
package harpreetapp;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class ECSGui extends JFrame{
	private Module module;
	private JLabel codeLabel = new JLabel("Module code:", JLabel.CENTER);
	private JLabel titleLabel= new JLabel("Module title:", JLabel.CENTER);
	private JLabel tutorLabel = new JLabel("Module tutor responsible:", JLabel.CENTER);
	private JLabel courseNumberLabel = new JLabel("Coursework number", JLabel.CENTER);
	private JLabel courseTitleLabel= new JLabel("Coursework title", JLabel.CENTER);
	private JLabel issueDateLabel= new JLabel("Issue date", JLabel.CENTER);
	private JLabel dueDateLabel= new JLabel("Due date and time", JLabel.CENTER);
	private JLabel assessmentTypeLabel= new JLabel("Assessment Type", JLabel.CENTER);
	private JLabel percentageMarkLabel= new JLabel("% of module mark", JLabel.CENTER);

	private JTextField code;
	private JTextField title;
	private JTextField tutor;
	private JTextField courseNumber;
	private JTextField courseTitle;
	private JTextField issueDate;
	private JTextField dueDate;
	private JTextField assessmentType;
	private JTextField percentageMark;
	String s = "";
	private JPanel jPanel;
	private JButton submit;
	public ECSGui(String s) {
                
		super(s);
                this.s = s;
		setLayout(new BorderLayout());
		jPanel = new JPanel();
		GridLayout layout = new GridLayout(9,2);
		layout.setHgap(5);
		layout.setVgap(5);
		jPanel.setLayout(layout);
		code = new JTextField();
		title= new JTextField();
		tutor= new JTextField();
		courseNumber= new JTextField();
		courseTitle= new JTextField();
		issueDate= new JTextField();
		dueDate= new JTextField();
		assessmentType= new JTextField();
		percentageMark= new JTextField();
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String _code = code.getText();
				String _title = title.getText();
				String _tutor = tutor.getText();
				String _courseNumber = courseNumber.getText();
				String _courseTitle = courseTitle.getText();
				String _issueDate = issueDate.getText();
				String _dueDate = dueDate.getText();
				String _assessmentType = assessmentType.getText();
				double _percentageMark = Double.parseDouble(percentageMark.getText());
				module = new Module(_code, _title, _tutor, _courseNumber, _courseTitle, _issueDate, _dueDate, _assessmentType, _percentageMark);
				System.out.println(module);
                                String insertquery = "insert into DATA values ('"+_code+"','"+_title+"','"+_tutor+"','"
                                        +_courseNumber+"','"+_courseTitle+"','"+_issueDate+"','"+_dueDate+"','"+_assessmentType+"','"
                                        +Double.toString(_percentageMark)+"')";
                                DBclass db = new DBclass(insertquery);
                                DBclass db1 = new DBclass(_code,_courseNumber);
			}
		});
		jPanel.add(codeLabel);
		jPanel.add(code);
		jPanel.add(titleLabel);
		jPanel.add(title);
		jPanel.add(tutorLabel);
		jPanel.add(tutor);
		jPanel.add(courseNumberLabel);
		jPanel.add(courseNumber);
		jPanel.add(courseTitleLabel);
		jPanel.add(courseTitle);
		jPanel.add(issueDateLabel);
		jPanel.add(issueDate);
		jPanel.add(dueDateLabel);
		jPanel.add(dueDate);
		jPanel.add(assessmentTypeLabel);
		jPanel.add(assessmentType);
		jPanel.add(percentageMarkLabel);
		jPanel.add(percentageMark);
		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.setResizeWeight(0.9);
        sp.setEnabled(false);
        sp.setDividerSize(5);

        sp.add(jPanel);
        sp.add(submit);
        add(sp, BorderLayout.CENTER);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
        
        public ECSGui(String mcode,String mtitle,String mtutor,String cwnum,String cwtitle,String isdate,String ddate,String astype,String percemark){
                super("Result");
                this.s = s;
		setLayout(new BorderLayout());
		jPanel = new JPanel();
		GridLayout layout = new GridLayout(9,2);
		layout.setHgap(5);
		layout.setVgap(5);
		jPanel.setLayout(layout);
             JLabel _code =new JLabel(mcode, JLabel.CENTER);
             JLabel _title= new JLabel(mtitle, JLabel.CENTER);
             JLabel _tutor = new JLabel(mtutor, JLabel.CENTER);
             JLabel _courseNumber=new JLabel(cwnum, JLabel.CENTER);
             JLabel _courseTitle = new JLabel(cwtitle, JLabel.CENTER);
             JLabel _issueDate=new JLabel(isdate, JLabel.CENTER);
             JLabel _dueDate=new JLabel(ddate, JLabel.CENTER);
             JLabel _assessmentType=new JLabel(astype, JLabel.CENTER);
             JLabel _percentageMark=new JLabel(percemark, JLabel.CENTER);
                jPanel.add(codeLabel);
                jPanel.add(_code);
		jPanel.add(titleLabel);
		jPanel.add(_title);
		jPanel.add(tutorLabel);
		jPanel.add(_tutor);
		jPanel.add(courseNumberLabel);
		jPanel.add(_courseNumber);
		jPanel.add(courseTitleLabel);
		jPanel.add(_courseTitle);
		jPanel.add(issueDateLabel);
		jPanel.add(_issueDate);
		jPanel.add(dueDateLabel);
		jPanel.add(_dueDate);
		jPanel.add(assessmentTypeLabel);
		jPanel.add(_assessmentType);
		jPanel.add(percentageMarkLabel);
		jPanel.add(_percentageMark);
                JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.setResizeWeight(0.9);
        sp.setEnabled(false);
        sp.setDividerSize(5);

        sp.add(jPanel);
        
        add(sp, BorderLayout.CENTER);
		setVisible(true);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
                
        }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ECSGui ecs = new ECSGui("Electronic Coursework Submission");
			}
		});
		
	}
}