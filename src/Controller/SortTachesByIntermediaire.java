package Controller;

import Model.Tache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implémentation du trie par échéance intermédiaire
 */
class SortTachesByIntermediaire implements SortTaches
{

    // Comparaisons des echances intermediaire de chaque tache
    private Comparator<Tache> comparator = (left, right) -> left.getDateEcheanceIntermediaire().getTime().compareTo(right.getDateEcheanceIntermediaire().getTime());

    /**
     * Fonction de trie des taches
     *
     * @param allTaches ArrayList de toute les taches
     * @return ArrayList de taches triées
     */
    public ArrayList<Tache> sort(ArrayList<Tache> allTaches)
    {
        // Sorting
        Collections.sort(allTaches, comparator);

        return allTaches;
    }
}