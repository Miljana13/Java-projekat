package Drawing_MiljanaBogunovic_MH35_2017;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class clsColors extends JLabel  implements ListCellRenderer {



	public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {

    if (value instanceof Color) {
        Color color = (Color) value;

        if (color.equals(Color.red)) {
            setText("Crvena");
        } 
        else if (color.equals(Color.white)) {
            setText("Bela");
        }
        else if (color.equals(Color.green)) {
            setText("Zelena");
        }
        else if (color.equals(Color.blue)) {
            setText("Plava");
        }
        else if (color.equals(Color.gray)) {
            setText("Siva");
        }
        else if (color.equals(Color.pink)) {
            setText("Roze");
        }
        else if (color.equals(Color.cyan)) {
            setText("Cijanid");
        }
        else if (color.equals(Color.yellow)) {
            setText("Zuta");
        }
        else if (color.equals(Color.black)) {
            setText("Crna");
        }
   
	        
	    } else {
	        setText(" ");
	    }
    return this;

}
}
