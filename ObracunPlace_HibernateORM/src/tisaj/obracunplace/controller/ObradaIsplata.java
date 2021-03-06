/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisaj.obracunplace.controller;

import tisaj.obracunplace.model.Isplata;
import tisaj.obracunplace.pomocno.ObracunPlaceException;
import tisaj.obracunplace.pomocno.HibernateUtil;
import tisaj.obracunplace.pomocno.ObradaSucelje;
import java.util.List;

/**
 *
 * @author Josip
 */
public class ObradaIsplata extends Obrada<Isplata> implements ObradaSucelje<Isplata> {

    public ObradaIsplata() {
        super();
    }

    public List<Isplata> getLista() {
        return HibernateUtil.getSession().createQuery("from Isplata").list();
    }

    public Isplata save(Isplata i) throws ObracunPlaceException {

        kontrola(i);

        return dao.save(i);
    }

    public void delete(Isplata i) throws ObracunPlaceException {

        if (!i.getObracuni().isEmpty()) {
            throw new ObracunPlaceException("Isplata se ne može obrisati jer ima napravljen obračun");
        }
        dao.delete(i);
    }

    public void kontrola(Isplata i) throws ObracunPlaceException {

        
        if (i.getNazivIsplate().trim().isEmpty()) {
            throw new ObracunPlaceException("Naziv isplate nije definiran");
        }
        if (i.getNazivIsplate() == null) {
            throw new ObracunPlaceException("Obavezan unos naziv isplate");
        }
        if (i.getVrstaIsplate().trim().isEmpty()) {
            throw new ObracunPlaceException("Vrsta isplate nije definirana");
        }
        if (i.getVrstaIsplate()==null) {
            throw new ObracunPlaceException("Obavezan unos isplate");
        }
        if (i.getDatum() == null) {
            throw new ObracunPlaceException("Datum nije definiran");
        }

    }

}
