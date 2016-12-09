package View;

import Controller.MenuListener;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author gkueny
 */
class MenuView extends JMenuBar
{

    private ArrayList<JMenu> menus;
    private ArrayList<ArrayList<String>> menusTitle;

 


    MenuView(ArrayList<ArrayList<String>> menusTitle, Class listener)
    { 

        this.menus      = new ArrayList<>();
        this.menusTitle = menusTitle;

        this.initMenuView(listener);


    } 

    private void initMenuView(Class listener)
    {

        int size = this.menusTitle.size();
        for (int i = 0 ; i < size ; i++) {

            this.menus.add( new JMenu( this.menusTitle.get(i).get(0) ) );

            JMenu menu = this.menus.get(i);

            int subMenuSize = this.menusTitle.get(i).size();
            for (int j = 1 ; j < subMenuSize ; j++) {
            
                JMenuItem item = new JMenuItem( this.menusTitle.get(i).get(j) );

                menu.add( item );

                try {

                     item.addActionListener( (MenuListener)listener.newInstance() );

                } catch(Exception e) {
                   e.printStackTrace();
                }

            }

            this.add(menu);

        }

    }

}
