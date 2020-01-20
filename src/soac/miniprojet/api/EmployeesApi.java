package soac.miniprojet.api;

import soac.miniprojet.model.beans.Employees;
import soac.miniprojet.model.dao.daos.EmployeesDAO;

import java.util.LinkedList;

public class EmployeesApi {
    EmployeesDAO dao;

    public EmployeesApi() {
        this.dao = new EmployeesDAO();
    }

    public LinkedList<Employees> getEmployees() {
        return dao.getAll();
    }

    public boolean login(String username, String password) {
        return dao.isAuth(username, password);
    }

    public Employees getByUsername(String username) {
        return dao.getByUsername(username);
    }
}
