import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ejercicio extends JFrame {
    JComboBox jc=new JComboBox();
    JComboBox jc2=new JComboBox();
    JComboBox jc3=new JComboBox();
    JComboBox jc4=new JComboBox();

    JPanel panel=new JPanel();
    Connection con;
    Statement st;
    ResultSet rs;

    public ejercicio(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
        con= DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","jp","12345");
        st=con.createStatement();
        String s="select * from productos";
        rs=st.executeQuery(s);
        while(rs.next()){

            jc.addItem(rs.getString(1));
            jc2.addItem(rs.getString(2));
            jc3.addItem(rs.getString(3));
            jc4.addItem(rs.getString(4));


        }

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }

        panel.add(jc);
        panel.add(jc2);
        panel.add(jc3);
        panel.add(jc4);
        this.getContentPane().add(panel);
        this.setVisible(true);
    }


    public static void main(String[] args) {
    new ejercicio();
    }
}
