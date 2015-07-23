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
        private int MAXIMUM_BUTTONS = 4; //MAIN MENU BUTTON DOCK

    
    //checkbox menu
        //maximum
        private int max_checkboxes = 50;
        //labels
        private ArrayList checkboxLabels = new ArrayList ( );
        //platform
        public CHECKBOX_STRUCTURE checkboxPlatform;
        
        
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
        menuButtonDock = new MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_BUTTONS - BUTTON_SPAN * MAXIMUM_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 6, MAXIMUM_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/checkbox menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "rr", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );       
     
        add ( menuButtonDock );
        
        
        //////////////////////////////////////////////
        //CHECBOX plattform
        //////////////////////////////////////////////   
            checkboxPlatform = new CHECKBOX_STRUCTURE ( 0, max_checkboxes, menuButtonDock, 1, 10, 10 );
            //generate some checbox labels
            for ( int i = 0; i < max_checkboxes; i ++ )
                checkboxLabels.add ( "ITEM00" + i );
            
            //add some boxes
            for ( int boxes = 0; boxes < max_checkboxes; boxes ++ )
                checkboxPlatform.addBox ( "data/images/checkbox menu/checkbox/", ( String ) checkboxLabels.get ( boxes ), false, "default.png", "hovered.png", "selected.png", "hovered selection.png" );
            //tell checkbox platforms to setup checboxes wrt to this panel, and establish panel wrt to 
            //this background's colour.
            checkboxPlatform.setup ( getBackground ( ), Color.lightGray );
    }
    
    //add custom components which dont exist in UNICODE_MenuPanel by default,
    //where button click response is conceerned.
    public ArrayList <Object> generatedCustomComponentList ( )
    {
        ArrayList <Object> value = new ArrayList <Object> ( );
        
        value.add ( this );
        
        return value;
    }

   
    
    public void paintComponent ( Graphics graphics )
    {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;
        
    
        //establish dock dimensions   
        menuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        
        //establish checkboxPlatform dimensions   
        checkboxPlatform.PLATFORM.setBounds ( applicationWidth/2 - checkboxPlatform.PLATFORM.getWidth ( )/2, applicationHeight/2 - checkboxPlatform.PLATFORM.getHeight ( ), checkboxPlatform.PLATFORM.getWidth ( ), checkboxPlatform.PLATFORM.getHeight ( ) );
    }
    
    
  
}

