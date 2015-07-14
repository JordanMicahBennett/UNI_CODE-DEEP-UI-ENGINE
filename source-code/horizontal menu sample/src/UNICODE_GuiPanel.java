//author : jordan micah bennett
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import data.packages.UNICODE.*;

public class UNICODE_GuiPanel extends JPanel
{
    //establish frame connection
    public JFrame applicationFrame; //will allow repositioning of frame by user
 
    //establish button docks
    private int applicationWidth, applicationHeight;
        //button dimension
        private int BUTTON_SPAN = 84;
        //main menu button dock 
        public MENU_BUTTON_DOCK menuButtonDock;
        private int MAXIMUM_BUTTONS = 10; //MMBD = MAIN MENU BUTTON DOCK


    public UNICODE_GuiPanel ( JFrame UNICODE_frame, int applicationWidth, int applicationHeight )
    {
        //establish application frame
        applicationFrame = UNICODE_frame;
        this.applicationWidth = applicationWidth;
        this.applicationHeight = applicationHeight;

        //establish bg colour
        setBackground ( Color.black ); //so black buttons outline is visible
        
            
        //////////////////////////////////////////////
        //MENUS
        ////////////////////////////////////////////// 
        //establish button dock
        //UNICODE_MenuPanel ( ArrayList <Object> _customComponentList, boolean menuVisibility, int _xCoord, int _yCoord, int _MAXIMUM_BUTTONS, int BUTTON_PROXIMITY, int AXIS_PROXIMITY, String axisDirection, String axisLayoutType, String buttonListDirectory, int buttonWidth, int buttonHeight, Color bgColour, Color buttonOutlineColour, String _buttonShapeType,  int arcHeight, int arcDepth, int lastButtonChopValue )
        menuButtonDock = new MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_BUTTONS + 10 * MAXIMUM_BUTTONS ), BUTTON_SPAN, MAXIMUM_BUTTONS, 24, 1080, "clockwise", "horizontal", "data/images/main menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "rr", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );       
     
        add ( menuButtonDock );
    }
    
    //add custom components which dont exist in UNICODE_MenuPanel by default,
    //where button click response is conceerned.
    public ArrayList <Object> generatedCustomComponentList ( )
    {
        ArrayList <Object> value = new ArrayList <Object> ( );
        
    
        
        return value;
    }

   
    
    public void paintComponent ( Graphics graphics )
    {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;
    
        //establish dock dimensions   
        menuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
    }
    
    
  
}

