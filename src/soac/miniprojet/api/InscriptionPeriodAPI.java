package soac.miniprojet.api;

import soac.miniprojet.model.dao.daos.InscriptionPeriodDAO;
import soac.miniprojet.model.dao.daos.StudentsBiblioInscDAO;

import java.util.LinkedList;

public class InscriptionPeriodAPI {

    InscriptionPeriodDAO dao;

    public InscriptionPeriodAPI() {
        this.dao = new InscriptionPeriodDAO();
    }

    public Object getById(int id) {

        return dao.getById(id);
    }


    public boolean deleteById(int id) {

        return dao.deleteById(id, "students_biblio_insc");
    }


    public boolean update(Object object) {

        return dao.update(object);
    }


    public boolean add(Object object) {

        return dao.add(object);
    }


    public LinkedList getAll() {


        return dao.getAll();
    }

    public int countAll() {

        return dao.countAll();
    }

}
