package nik.dir.models;

import javax.persistence.*;

public class Norma {
    private int id;
    private String age;
    private String sex;
    private double erythrocytes;
    private int platelets;
    private double leukocytes;
    private int hemoglobin;
    private String result;
    private String edit;
    private String delete;
    private String firstname;
    private String surname;

    public Norma(){}

    public Norma(int id, String age, String sex, int platelets, double erythrocytes, double leukocytes, int hemoglobin) {
        this.age=age;
        this.sex=sex;
        this.id = id;
        this.hemoglobin=hemoglobin;
        this.platelets=platelets;
        this.erythrocytes=erythrocytes;
        this.leukocytes=leukocytes;
    }
    public Norma(int id, String age, String sex, int platelets, double erythrocytes, double leukocytes, int hemoglobin, String firstname, String surname, String result) {
        this.age=age;
        this.sex=sex;
        this.id = id;
        this.hemoglobin=hemoglobin;
        this.platelets=platelets;
        this.erythrocytes=erythrocytes;
        this.leukocytes=leukocytes;
        this.result=result;
        this.firstname = firstname;
        this.surname = surname;
        this.edit="/untitled15_war/patients/"+id+"/edit";
        this.delete="/untitled15_war/patients/"+id+"/delete";
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getResult() {
        return result;
    }
    public String Delete()
    {
        return delete;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public String Edit()
    {
        return edit;
    }

    public double getLeukocytes() {
        return leukocytes;
    }

    public void setLeukocytes(double leukocytes) {
        this.leukocytes = leukocytes;
    }

    public int getPlatelets() {
        return platelets;
    }

    public void setPlatelets(int platelets) {
        this.platelets = platelets;
    }

    public double getErythrocytes() {
        return erythrocytes;
    }

    public void setErythrocytes(double erythrocytes) {
        this.erythrocytes = erythrocytes;
    }

    public int getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(int hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
