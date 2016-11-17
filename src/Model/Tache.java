package Model;

import java.util.Calendar;
import java.util.Date;

/**
 * <h1>Class Tache</h1>
 *
 * @author  gkueny
 */
public abstract class Tache {

    /**
     * Titre de la Tache
     */
    protected String title;

    /**
     * Boolean permettant de savoir si la tache est termine ou pas
     */
    protected Boolean achieve;

    /**
     * Fin de la Tache
     */
    protected Calendar end;



    /**
     * Constructeur de la class
     *
     * @param title titre de la Tache
     * @param end   fin de la Tache
     */
    public Tache(String title, Calendar end){

        this.title      = title;
        this.achieve    = false;
        this.end        = end;

    }

    /**
     * Setter de l'attribut  title
     *
     * @param title nouveau titre de la Tache
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter de l'attribut achieve
     *
     * @param achieve boolean indiquant si la Tache est termine ou pas
     */
    public void setAchieve(Boolean achieve) {
        this.achieve = achieve;
    }

    /**
     * Setter de l'attribut end
     *
     * @param end date de fin de la tache
     */
    public void setEnd(Calendar end) {
        this.end = end;
    }


    /**
     * Getter de l'attribut title
     *
     * @return String title
     */
    public String getTitle() {

        return title;
    }

    /**
     * Getter de l'attribut achieve
     *
     * @return Boolean achieve
     */
    public Boolean getAchieve() {
        return achieve;
    }


    /**
     * Getter de l'attribut end
     *
     * @return {@link Calendar} end
     */
    public Calendar getEnd() {
        return end;
    }

    /**
     * Savoir si la tache est en retard ou pas
     *
     * @return true if Tache is late, false if tache is not late
     */
    public abstract Boolean isLate();

}