package start;

import dao.Dao;
import daoImpl.DaoImpl;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class ConsoleStart {
    public static void main(String[] args) {
        Dao<Person> dao=new DaoImpl();
        List<Person> personList=new ArrayList<>();
        personList=dao.findAll();
        for(Person p: personList){
            System.out.println(p);
        }
    }
}
