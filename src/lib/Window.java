
package lib;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Window extends JFrame {
    
    public static JPanel pnl = new JPanel();
    public static JPanel grid = new JPanel();
    public static JButton show = new JButton("Show library");
    public static JButton add = new JButton("Add book");
    public static JButton delete = new JButton("Delete book");
    public static JButton find = new JButton("Find book");
    public static JButton sort = new JButton("Show sorted list of books");
    public static JButton changeCost = new JButton("Change cost of book");
    
    Listener ls = new Listener();
    public Window(){
        super("Welcom to the library");
        setSize(700, 100);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        add(pnl);
        
        setVisible(true);
        //pnl.add(lab);
        pnl.add(show);
        pnl.add(add);
        pnl.add(delete);
        pnl.add(find);
        pnl.add(sort);
        
        pnl.add(changeCost);
        show.addActionListener(ls);
        add.addActionListener(ls);
        delete.addActionListener(ls);
        find.addActionListener(ls);
        sort.addActionListener(ls);
        changeCost.addActionListener(ls);
        
        
        
        
        
    }

    
    
}
