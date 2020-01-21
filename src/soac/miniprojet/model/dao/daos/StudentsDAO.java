package soac.miniprojet.model.dao.daos;
// Generated 7 janv. 2020 11:56:55 by Hibernate Tools 5.4.7.Final

import soac.miniprojet.model.beans.Students;
import soac.miniprojet.model.beans.StudentsBiblioInsc;
import soac.miniprojet.model.dao.DAO;
import soac.miniprojet.model.dao.DAOInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


/**
 * Students generated by hbm2java
 */
public class StudentsDAO extends DAO implements DAOInterface {
	@Override
	public Object getById(int id) {
		ResultSet result;
		try {
			result = statement.executeQuery("SELECT * FROM Students WHERE id=" + id);
			if (result.next()) {
				Students student = new Students();
				student.setId(result.getInt("id"));
				student.setNom(result.getString("nom"));
				student.setPrenom(result.getString("prenom"));
				student.setDateNaiss(result.getDate("date"));
				student.setSexe(result.getString("sexe"));
				student.setNumBac(result.getString("num_bac"));
				student.setDateInsc(result.getDate("date_insc"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;    }

	@Override
	public boolean deleteById(int id) {
		return  deleteById(id,"Students");
	}

	@Override
	public boolean update(Object object) {

		Students student = (Students) object;
		try {
			statement.execute("UPDATE Students SET " +
					"nom = '" + student.getNom() + "'," +
					"prenom = '" + student.getPrenom() + "'," +
					"date_naiss = '" + student.getDateNaiss() + "'," +
					"sexe = '" + student.getSexe() + "'," +
					"num_bac = '" + student.getNumBac() + "'," +
					"date_insc = '" + student.getDateInsc() + "'," +

					" WHERE Students.id=" + student.getId() + ";");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean add(Object object) {
		Students student = (Students) object;
		try {
			statement.execute("INSERT INTO Students (`nom`,`prenom`,`role` ) VALUES(" +
					"'" + student.getNom() + "'," +
					"'" + student.getPrenom() + "'," +
					");");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LinkedList<Students> getAll() {
		LinkedList<Students> list = new LinkedList<>();
		ResultSet result;
		try {
			result = statement.executeQuery("SELECT * FROM Students;");
			while (result.next()) {
				Students student = new Students();
				student.setId(result.getInt("id"));
				student.setNom(result.getString("nom"));
				student.setPrenom(result.getString("prenom"));
				student.setDateNaiss(result.getDate("date_naiss"));
				student.setSexe(result.getString("sexe"));
				student.setNumBac(result.getString("num_bac"));
				student.setDateInsc(result.getDate("date_insc"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int countAll() {
		ResultSet result;
		try {
			result = statement.executeQuery("SELECT count(id) FROM Students;");
			if (result.next()) {
				return result.getInt("count(id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	public boolean Reinscrire(StudentsBiblioInsc studentInscription) {
		try {
			statement.execute("INSERT INTO students_biblio_insc (student_id, biblio_insc_period_id , date_insc)" +
					"VALUES(" +
					studentInscription.getStudent().getId() + "," +
					studentInscription.getInscPeriod().getId() + "," +
					"now()," +
					");");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
