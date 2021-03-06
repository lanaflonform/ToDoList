package Model;


import java.io.Serializable;

/**
 * <h1>Range les {@link Tache} dans des Categories</h1>
 * Comporte le Titre et une Abreviation de la Categorie
 *
 * @author  Vincent THOMAS
 */
public class Categorie implements Serializable{
    /**
     * Titre de la Categorie
     */
    private String titre;

    /**
     * Abreviation de la Categorie
     */
    private String abreviation;

    /**
     * Constructeur de la class
     *
     * @param titre Titre de la Categorie
     * @param abreviation Abreviation de la Categorie
     */
    public Categorie(String titre, String abreviation){
        this.titre = titre;
        this.abreviation = abreviation;
    }

    /**
     * Setter de l'atribut @link titre
     * @param titre Titre de la Categorie
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @param abreviation Abreviation de la Categorie
     */
    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    /**
     * Getter de l'attribut titre
     *
     * @return {@link String} titre
     */
    public String getTitre() {
        return this.titre;
    }

    /**
     * Getter de l'attribut abreviation
     *
     * @return {@link String} abreviation
     */
    public String getAbreviation() {
        return this.abreviation;
    }
}