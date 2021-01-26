package nik.dir.models;

import nik.dir.dao.NormaDAO;
import nik.dir.dao.PatientDAO;
import org.springframework.stereotype.Component;

@Component
public class Analysis {
    public Analysis(){}
    public String Process(NormaDAO normaDAO, Norma patient){
        for (Norma norma: normaDAO.all())
        {
            if(patient.getAge().equals(norma.getAge()) &&patient.getSex().equals(norma.getSex())){
                return Analy(patient, norma);
            }
        }
        return "Oops, something is wrong";
    }
    private String Analy(Norma patient, Norma norma){
        String result="";
        result=result+Solving(patient.getErythrocytes(),norma.getErythrocytes(), "erythrocytes")+Solving(patient.getHemoglobin(),norma.getHemoglobin(), "hemoglobin")+Solving(patient.getLeukocytes(),norma.getLeukocytes(), "leukocytes")+Solving(patient.getPlatelets(),norma.getPlatelets(), "platelets");
        if(result.equals("")){
            result="You are normal";
        }
        return result;
    }
    private String Solving(int i, int i1, String st){
        if(0.8*i>i1){
            return "You have too much "+st+".\n";
        }
        else if(i<0.8*i1){
            return "You dont have enough "+st+".\n";
        }
        return "";
    }
    private String Solving(double i, double i1, String st){
        if(0.8*i>i1){
            return "You have too much "+st+".\n";
        }
        else if(i<0.8*i1){
            return "You dont have enough "+st+".\n";
        }
        return "";
    }
}
