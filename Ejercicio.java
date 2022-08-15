import javax.swing.*;
import java.sql.*;

public class Ejercicio extends  JFrame{
    JComboBox jc = new JComboBox();
    JComboBox direc = new JComboBox();
    JComboBox mail = new JComboBox();
    JComboBox id = new JComboBox();
    JComboBox celular = new JComboBox();
    JComboBox password = new JComboBox();
    JPanel panel= new JPanel();
    JLabel label1= new JLabel("ID: ");
    JLabel label2= new JLabel("Email: ");
    JLabel label3= new JLabel("Nombres: ");
    JLabel label4= new JLabel("Direccion: ");
    JLabel label5= new JLabel("Password: ");
    Connection con;
    Statement st;
    ResultSet rs;

    public Ejercicio(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Datos");

        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost/mi_tienda?serverTimezone=UTC", "root", "");
            st=con.createStatement();
            String s= "select * from users";
            rs= st.executeQuery(s);

            while(rs.next()){

                id.addItem(rs.getString(1));
                mail.addItem(rs.getString(2));
                jc.addItem(rs.getString(3));
                direc.addItem(rs.getString(4));
                password.addItem(rs.getString(5));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar!" );
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al conectar!" );
            }
        }

        String salto="\n";

        panel.add(label1);
        panel.add(id);
        

        panel.add(label2);
        panel.add(mail);

        panel.add(label3);
        panel.add(jc);

        panel.add(label4);
        panel.add(direc);

        panel.add(label5);
        panel.add(password);



        this.getContentPane().add(panel);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        new Ejercicio();
    }
}
