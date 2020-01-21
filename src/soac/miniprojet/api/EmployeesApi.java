package soac.miniprojet.api;


import soac.miniprojet.model.beans.Employees;
import soac.miniprojet.model.dao.daos.EmployeesDAO;

import java.util.LinkedList;

public class EmployeesApi {
    public EmployeesApi() {
        this.dao = new EmployeesDAO();
    }

    EmployeesDAO dao;

    public Object getById(int id) {
        return   dao.getById(id);
    }

    public boolean isAuth(String username, String password) {
        return  dao.isAuth(username,password);
    }



    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }


    public boolean update(Object object) {
        return  dao.update(object);
    }


    public boolean add(Object object) {
        return dao.add(object);
    }


    public LinkedList<Employees> getAll() {
        return dao.getAll();
    }

    public int countAll() {
      return dao.countAll();
}
}
