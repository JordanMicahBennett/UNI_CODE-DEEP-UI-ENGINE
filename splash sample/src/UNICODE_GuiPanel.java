//author : jordan micah bennett
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import data.packages.UNICODE.*;

public class UNICODE_GuiPanel extends JPanel
{
    //establish custom font
    public UNICODE_CustomFont font = new UNICODE_CustomFont ( "data/fonts/" );

    //establish constructor
    public UNICODE_GuiPanel ( )
    {
        
    }
    
   
    //standard paint component for drawing
    public void paintComponent ( Graphics graphics )
    {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;
        
        font.write ( graphics, "uni-code(tm) graphics engine {splash}", 80, 100, 30, "metro.ttf" );
    }
}

