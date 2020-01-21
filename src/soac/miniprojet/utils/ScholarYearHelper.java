package soac.miniprojet.utils;


import soac.miniprojet.model.beans.InscriptionPeriod;

import java.util.Date;


public class ScholarYearHelper {


    public static boolean isInscPeriodOpen() {
        InscriptionPeriodDAO periodDAO = new InscriptionPeriodDAO();
        InscriptionPeriod lp = periodDAO.GetLastPeriode();
        return new Date().after(lp.getStartInscDate()) && new Date().before(lp.getEndInscDate());
    }

    public static boolean isReInscPeriodOpen() {
        InscriptionPeriodDAO periodDAO = new InscriptionPeriodDAO();
        InscriptionPeriod lp = periodDAO.GetLastPeriode();
        return  new Date().after(lp.getStartReinscDate()) && new Date().before(lp.getEndReinscDate());
    }
}
