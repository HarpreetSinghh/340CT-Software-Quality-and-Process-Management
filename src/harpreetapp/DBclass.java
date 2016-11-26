
package harpreetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**

 */
public class DBclass {
    String Host = "";
    String uName = "";
    String uPass= " ";
    public DBclass(String mcode,String course_num){         //the host name and the password.
        this.Host = "jdbc:derby://localhost:1527/HarpreetDB";
        this.uName ="harpreet";
        this.uPass = "harpreet";
        try{
        Connection con = DriverManager.getConnection(this.Host, this.uName, this.uPass);
        Statement stmt = con.createStatement();
        String SQL = "SELECT * FROM Data";
        ResultSet rs = stmt.executeQuery( SQL );
        while(rs.next()){
        String m_code = rs.getString("M_CODE");
        String m_title = rs.getString("M_TITLE");
        String m_tutor = rs.getString("M_TUTOR");
        String coursework_num = rs.getString("COURSEWORK_NUM");
        String coursework_title = rs.getString("COURSEWORK_TITLE");
        String issue_date = rs.getString("ISSUE_DATE");
        String due_date_and_time = rs.getString("DUE_DATE_AND_TIME");
        String ass_type = rs.getString("ASS_TYPE");
        String percentage_mark = rs.getString("PERCENTAGE_MARK");
        //System.out.println(m_code+" "+m_title+" "+coursework_num+" "+issue_date+" "+ percentage_mark);
        ECSGui eg = new ECSGui(m_code,m_title,m_tutor,coursework_num,coursework_title,issue_date,due_date_and_time,ass_type,percentage_mark);
        }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
