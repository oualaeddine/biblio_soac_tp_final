package soac.miniprojet.api;



import soac.miniprojet.model.beans.Students;
import soac.miniprojet.model.beans.StudentsBiblioInsc;
import soac.miniprojet.model.dao.daos.StudentsDAO;
import soac.miniprojet.utils.ScholarYearHelper;

import java.util.LinkedList;

public class StudentsApi {

    StudentsDAO dao;

    public StudentsApi() {
        this.dao=new StudentsDAO();
    }

    public Object getById(int id) {

        return dao.getById(id);


    }


    public boolean deleteById(int id) {

        return dao.deleteById(id);
    }


    public boolean update(Object object) {

        return dao.update(object);
    }


    public boolean add(Students student) {
      if (ScholarYearHelper.isInscPeriodOpen())
            return dao.add(student);
        else
            return false;
    }


    public LinkedList<Students> getAll() {

        return dao.getAll();
    }

    public int countAll() {

        return dao.countAll();

    }

    public boolean Reinscrire(StudentsBiblioInsc studentInscription) {
        if (ScholarYearHelper.isReInscPeriodOpen())
        return dao.Reinscrire(studentInscription);
       else return false;
    }

}
