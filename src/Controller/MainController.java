package Controller;

import View.*;
import Model.*;

import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MainController
{

	private static MainView f;

	private static ArrayList<ArrayList<String>> menu;
	private static ArrayList<TacheView> tachesView;

	private static Calendar end;
	private static Calendar end2;
	private static Calendar end3;
	
	private static ArrayList<Tache> allTaches;

	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
	

	public static void main(String args[])  
    { 

	    allTaches = getTaches();

	    allTaches = sortTaches(allTaches);
	    
        menu 		= getMenu();
        tachesView	= getTachesView(allTaches);

        f 			= new MainView("ToDo List", tachesView, menu, MenuListener.class); 

        f.setVisible(true);

 
    } 

    private static ArrayList<ArrayList<String>> getMenu()
    {

		ArrayList<ArrayList<String>> menu   = new ArrayList<ArrayList<String>>();

	    ArrayList<String> submenu           = new ArrayList<String>();
	    ArrayList<String> submenu2          = new ArrayList<String>();
	    ArrayList<String> submenu3          = new ArrayList<String>();

	    submenu.add("Créer");
	    submenu.add(MenuItems.CARTEPONCTUELLE.toString());
	    submenu.add(MenuItems.CARTEAULONGCOURS.toString());

	    submenu2.add("Manager");
	    submenu2.add(MenuItems.CATEGORIE.toString());

	    submenu3.add("Autres");
	    submenu3.add(MenuItems.SAUVEGARDER.toString());
	    submenu3.add(MenuItems.QUITTER.toString());

	    menu.add(submenu);
	    menu.add(submenu2);
	    menu.add(submenu3);

	    return menu;

    }

    public static void removeTache()
    {

    }

    private static ArrayList<Tache> getTaches()
    {

    	end = Calendar.getInstance();
    	end.setTime(new Date(System.currentTimeMillis() + (5 * 24 * 60 * 60 * 1000)));
	    end.set(Calendar.HOUR_OF_DAY, 0);
	    end.set(Calendar.MINUTE, 0);
	    end.set(Calendar.SECOND, 0);
	    end.set(Calendar.MILLISECOND, 0);

	    end2 = Calendar.getInstance();
    	end2.setTime(new Date(System.currentTimeMillis() + (2 * 24 * 60 * 60 * 1000)));
	    end2.set(Calendar.HOUR_OF_DAY, 0);
	    end2.set(Calendar.MINUTE, 0);
	    end2.set(Calendar.SECOND, 0);
	    end2.set(Calendar.MILLISECOND, 0);

	    end3 = Calendar.getInstance();
    	end3.setTime(new Date(System.currentTimeMillis() + (1 * 24 * 60 * 60 * 1000)));
	    end3.set(Calendar.HOUR_OF_DAY, 0);
	    end3.set(Calendar.MINUTE, 0);
	    end3.set(Calendar.SECOND, 0);
	    end3.set(Calendar.MILLISECOND, 0);

    	ArrayList<Tache> allTaches = new ArrayList<Tache>();

    	AuLongCours aloLongCour = new AuLongCours(6, "TacheAuLongCours2", end);
    	aloLongCour.setPercentage(40);

        allTaches.add(new Ponctuelle(1, "TachePonctuelle1", end));
		allTaches.add(new Ponctuelle(2, "TachePonctuelle2", end2));
		allTaches.add(new Ponctuelle(3, "TachePonctuelle3", end));
		allTaches.add(new Ponctuelle(4, "TachePonctuelle4", end3));

		allTaches.add(new AuLongCours(4, "TacheAuLongCours1", end2));
		allTaches.add(aloLongCour);

        return allTaches;
    }

    private static ArrayList<Tache> sortTaches(ArrayList<Tache> allTaches)
    {
    	// Sorting
		Collections.sort(allTaches, new Comparator<Tache>() {
			@Override
			public int compare(Tache tache1, Tache tache2)
			{

				return  tache1.getEnd().compareTo(tache2.getEnd());
			}
		});

		return allTaches;
    }
    private static ArrayList<TacheView> getTachesView(ArrayList<Tache> allTaches)
    {
    	ArrayList<TacheView> tachesView = new ArrayList<TacheView>();

    	

    	int size = allTaches.size();

    	for (int i = 0; i < size ; i++ ) {


    		String dateFormated = formatDate.format(allTaches.get(i).getEnd().getTime());

    		if(allTaches.get(i) instanceof Ponctuelle)
				tachesView.add(new TacheView(allTaches.get(i).getTitle(), dateFormated, "Unknow", allTaches.get(i).isLate(), new TacheListener(allTaches.get(i).getId())));
    		else if (allTaches.get(i) instanceof AuLongCours)
    			tachesView.add(new TacheAuLongCourView(allTaches.get(i).getTitle(), dateFormated, "Unknow", allTaches.get(i).isLate(), ((AuLongCours)allTaches.get(i)).getPercentage(), new TacheListener(allTaches.get(i).getId())));
    	}


        return tachesView;
    }
}