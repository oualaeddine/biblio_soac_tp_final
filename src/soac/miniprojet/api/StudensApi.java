package soac.miniprojet.api;

import soac.miniprojet.model.beans.Students;
import soac.miniprojet.model.dao.daos.StudentsDAO;

import java.util.LinkedList;

public class
StudensApi {
    public LinkedList<Students> getStudents() {

        return   new StudentsDAO().getAll();
    }
}
