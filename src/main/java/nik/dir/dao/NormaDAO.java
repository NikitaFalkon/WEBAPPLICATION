package nik.dir.dao;

import nik.dir.models.Norma;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class NormaDAO {
    private int COUNT=0;
    private List<Norma> normals = new ArrayList<Norma>();
    String tabl;

    public void setTabl(String tabl) {
        this.tabl = tabl;
    }
    public List<Norma> Reload() {
        normals.clear();
        try{
            String url = "jdbc:mysql://localhost:3307/bloodtest?serverTimezone=Europe/Minsk&useSSL=false";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery(tabl);
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String sex = resultSet.getString(2);
                    String age = resultSet.getString(3);
                    int erythrocytes = resultSet.getInt(4);
                    int platelets = resultSet.getInt(5);
                    int leukocytes = resultSet.getInt(6);
                    int hemoglobin = resultSet.getInt(7);

                    System.out.println(hemoglobin);

                    if(this.tabl.equals("SELECT * FROM patients"))
                    {
                        String firstname = resultSet.getString(8);
                        String surname = resultSet.getString(9);
                        String result = resultSet.getString(10);
                        normals.add(new Norma(id, age, sex, platelets, erythrocytes, leukocytes, hemoglobin, firstname, surname, result));
                    }
                    else
                    {
                        normals.add(new Norma(id, age, sex, platelets, erythrocytes, leukocytes, hemoglobin));
                    }

                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return normals;
    }
    public NormaDAO(){}
    public  List<Norma> all(){
        return normals;
    }
    public Norma show(int id){
        for (Norma norm: normals) {
            if(norm.getId()==id){
                return norm;
            }
        }
        return null;
    }
}
