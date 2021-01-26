package nik.dir.dao;
import nik.dir.models.Analysis;
import nik.dir.models.Norma;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class PatientDAO extends NormaDAO
{
    public PatientDAO()
    {
    }
    private Analysis analysis= new Analysis();
    private int COUNT=0;
    private List<Norma> normals;
    private String url = "jdbc:mysql://localhost:3307/bloodtest?serverTimezone=Europe/Minsk&useSSL=false";
    private String username = "root";
    private String password = "root";
    {
        normals = new ArrayList<>();
    }
    public void update(int id, Norma patient)
    {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("UPDATE patients  SET sex = '"+patient.getSex()+"', age = '"+patient.getAge()+"', Erythrocytes = "+patient.getErythrocytes()+", Platelets = "+patient.getPlatelets()+", Leukocytes = "+patient.getLeukocytes()+", Hemoglobin = "+patient.getHemoglobin()+", Firstname = '"+patient.getFirstname()+"', Surname = '"+patient.getSurname()+"', Result = '"+patient.getResult()+"'WHERE id ="+id+"");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public void save(Norma norma){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                String sex = norma.getSex();
                String age = norma.getAge();
                double Eryt = norma.getErythrocytes();
                int Plat = norma.getPlatelets();
                double Leu = norma.getLeukocytes();
                int Hemo = norma.getHemoglobin();
                String Firs = norma.getFirstname();
                String Sec = norma.getSurname();
                String Res = norma.getResult();
                int rows = statement.executeUpdate("INSERT patients(sex, age, Erythrocytes, Platelets, Leukocytes, Hemoglobin, Firstname, Surname, Result) VALUES ('"+sex+"','"+ age +"',"+Eryt+","+Plat+","+ Leu+","+Hemo+",'"+Firs+"','"+Sec+"','"+ Res+"')");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public void delete(int id)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                int rows = statement.executeUpdate("DELETE FROM patients WHERE id = "+id+"");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}