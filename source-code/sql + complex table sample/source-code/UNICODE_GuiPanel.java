//Author: Jordan Micah Bennett
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import data.packages.UNICODE.*;

public class UNICODE_GuiPanel extends JPanel
{
    //establish uni-code (tm) managers
    public UNICODE_ConfigurationManager configurationManager = new UNICODE_ConfigurationManager ( "data/config/CONFIG.ini" );
       
    //establish uni-code (tm) controllers
            //establish opacity manager
            private UNICODE_OpacityController opacityController = new UNICODE_OpacityController ( ); 
            //establish rendering hint to install anti-aliasing
            private UNICODE_AntiAliasingController antiAliasController = new UNICODE_AntiAliasingController ( configurationManager.getAntiAliasingStateFromFile ( ) );

    //establish menus and related requirments  
    private BUTTON_DOCK buttonDock = null;
            //button dimension
            private int buttonSpan = 84, maximumButtons = 6; //MAIN MENU BUTTON DOCK
            
    //constructor     
    //establish audio player
    private UNICODE_AudioPlayer audioPlayer = new UNICODE_AudioPlayer ( );
   
    //USER database requirements
        //database manager
        public UNICODE_DatabaseManager DATABASE_MANAGER = null;
        //outcome table 
        public UNICODE_Structure_ComplexTable OUTCOME_TABLE = null;
            //table initialization query
            private String initializationQuery = "select * from schedule";
        //field
        public JTextArea QUERY_AREA = new JTextArea ( initializationQuery );
        //bounds
        public Rectangle OUTCOME_TABLE_BOUNDS = new Rectangle ( -10, 250, 560, 80 ), QUERY_AREA_BOUNDS = new Rectangle ( 650, 8, 170, 160 );
        
    //constructor
    public UNICODE_GuiPanel (  )
    {     
        //INIT DATABASE_MANAGER MANAGER
        //////////////////////////////////////////////   
        DATABASE_MANAGER = new UNICODE_DatabaseManager ( configurationManager );

        ////////////////////////////////////////////////////
        //ESTABLISH USER DISPLAY TABLE
        ////////////////////////////////////////////////////
        OUTCOME_TABLE = DATABASE_MANAGER.getDefinedTable ( 80, "data/images/table menu/", "table background.png", "center", "data/images/intervolve/thumb.png", "data/images/intervolve/track.png", Color.white, this, initializationQuery,  new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), new Color ( 253, 253, 253 ), new Color ( 230, 230, 230 ) );
      
        ////////////////////////////////////////////////////
        //ESTABLISH MAIN MENU
        ////////////////////////////////////////////////////
        buttonDock = new BUTTON_DOCK ( generatedCustomComponentList ( ), true, 120, 80, maximumButtons, 60, 2220, "clockwise", "horizontal", "data/images/main menu/", buttonSpan, buttonSpan, configurationManager.getColourFromFile ( ), configurationManager.getColourFromFile ( ), "rr", 0, 0, buttonSpan/3 );    
      
        ////////////////////////////////////////////////////
        //POPULATE GUI PANEL
        //////////////////////////////////////////////////// 
            setBackground ( configurationManager.getColourFromFile ( ) );
            //add docks to this panel
            add ( buttonDock );
            add ( QUERY_AREA );
        UNICODE_DatabaseLogicModule mn; UNICODE_DatabaseConnectionModule d;
        
        //set focus to this panel
        setFocusable ( true );
    }
    
    //return current opacity level
    public float getStartupOpacityLevel ( )
    {
        opacityController.setOpacLevel ( configurationManager.getOpacityFromFile ( ) );
        return opacityController.getOpacLevel ( );
    }
    
    //paint component
    public void paintComponent ( Graphics graphics )
    {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;


        //establish anti aliasing
        antiAliasController.setupAntiAliasing ( graphics2d );     
        
        //establish dock dimensions
        buttonDock.setBounds ( ( ( int ) new UNICODE_ConfigurationManager ( "data/config/CONFIG.ini" ).getBufferDimensionFromFile ( ).getWidth ( ) / 2 ) - ( maximumButtons * buttonSpan ) / 2, 460, 900, 200 );
        
        //QUERY_AREA bounds
        QUERY_AREA.setBounds ( QUERY_AREA_BOUNDS );
        QUERY_AREA.setBorder ( BorderFactory.createLineBorder ( Color.white ) );
        
        //table bounds
        OUTCOME_TABLE.getTable ( ).setBounds ( OUTCOME_TABLE_BOUNDS );
    }

    //add custom components which dont exist in UNICODE_MenuPanel by default,
    //where button click response is conceerned.
    public ArrayList <Object> generatedCustomComponentList ( )
    {
        ArrayList <Object> value = new ArrayList <Object> ( );
        
        value.add ( this ); //0
        
        return value;
    }
}