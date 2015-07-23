//author : jordan micah bennett
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import java.util.Date;


import data.packages.UNICODE.*;

public class UNICODE_GuiPanel extends JPanel
{
    //PASSWORD STUFF
        //establish user profiles
        //a user profile will consist of a user name at index zero and a password at index 1.
        private int MAXIMUM_POFILES = 4;
        private String user_profiles [ ] [ ] = 
                                            {
                                                { "uni", "code" },
                                                { "jordan", "bennett" },
                                                { "Antoine", "Wiles" },
                                                { "Denar", "Brown" }
                                            };
    //establish screen dimensions
        //get screen dimensio
        private Dimension screen_dimension = Toolkit.getDefaultToolkit ( ).getScreenSize ( );  
        //establish variables
        private int screen_width = ( int ) screen_dimension.getWidth ( ), screen_height = ( int ) screen_dimension.getHeight ( );
        //establish memento
        private int initial_screen_width = screen_width, initial_screen_height = screen_height;
        private float initial_opacity = 0.0f;
        
    //establish frame connection
    public JFrame applicationFrame; //will allow repositioning of frame by user
    //establish current coordinates genrated by pressed down mouse
    private Point held_mouse_coords = null;
    //establish current coordinates geenrated by mouse dragging
    private Point dragged_mouse_coords = null;

    //establish audio player
    private UNICODE_AudioPlayer audio_player = new UNICODE_AudioPlayer ( );
 

    private int applicationWidth, applicationHeight;
        //button dimension
        private int BUTTON_SPAN = 84;
        //password menu button dock 
        public PASSWORD_MENU_BUTTON_DOCK passwordMenuButtonDock;
        private int MAXIMUM_PMBD_BUTTONS = 5; //PMBD = PASSWORD MENU BUTTON DOCK
        //main menu button dock 
        public MAIN_MENU_BUTTON_DOCK mainMenuButtonDock;
        private int MAXIMUM_MMBD_BUTTONS = 10; //MMBD = MAIN MENU BUTTON DOCK
        //settings menu button dock 
        public SETTINGS_MENU_BUTTON_DOCK settingsMenuButtonDock;
        private int MAXIMUM_SMBD_BUTTONS = 6; //SMBD = SETTINGS MENU BUTTON DOCK
        //colour menu button dock
        public COLOUR_MENU_BUTTON_DOCK colourMenuButtonDock;
        private int MAXIMUM_CMBD_BUTTONS = 13; //CMBD = COLOUR MENU BUTTON DOCK  
        //opacity menu button dock 
        public OPACITY_MENU_BUTTON_DOCK opacityMenuButtonDock;
        private int MAXIMUM_OMBD_BUTTONS = 4; //OMBD = OPACITY MENU BUTTON DOCK
        //table menu button dock 
        public TABLE_MENU_BUTTON_DOCK tableMenuButtonDock;
        private int MAXIMUM_TMBD_BUTTONS = 4; //TMBD = TABLE MENU BUTTON DOCK
        //dynamic checkbox menu button dock 
        public DYNAMIC_CHECKBOX_MENU_BUTTON_DOCK dynamicCheckboxMenuButtonDock;
        private int MAXIMUM_DCMBD_BUTTONS = 4; //DCMBD = DYNAMIC CHECKBOX MENU BUTTON DOCK
        //anti alias menu button dock
        public ANTI_ALIAS_MENU_BUTTON_DOCK antiAliasMenuButtonDock;
        private int MAXIMUM_AAMBD_BUTTONS = 4; //AAMBD = ANTI ALIAS MENU BUTTON DOCK  
        //hider menu button dock
        public HIDE_MENU_BUTTON_DOCK hideMenuButtonDock;
        private int MAXIMUM_HMBD_BUTTONS = 9; //HMBD = HIDE MENU BUTTON DOCK      
        
                            
    //establish Colour array - used as archive of panel colours/
    public Color [ ] panelColourArray = { Color.lightGray, Color.darkGray, Color.red, Color.green, Color.blue, Color.cyan, Color.yellow, Color.magenta, Color.orange, Color.pink, Color.white, Color.black };
    private int grabbedColourIndex = 0;
    
    //establish menu display strings
    String menuLabelArchive [ ] = { "", ".UNICODE.", "settings", "colour", "visibility", "anliasing", "" };
    
    //establish label orientation variables   
    private float menu_label_size = 170.0f;
                                    
    //establish custom font
    public UNICODE_CustomFont font = new UNICODE_CustomFont ( "data/fonts/" );
    private int menuLabelArchiveIndex = 0;
    
    //establish opacity manager
    public UNICODE_OpacityController opacityManager = new UNICODE_OpacityController ( );
    
    //establish file manager
    private UNICODE_ConfigurationManager configurationManager = new UNICODE_ConfigurationManager ( "data/config/CONFIG.ini" );
  
    //establish background animation timer
    private Timer backgroundAnimationTimer = new Timer ( 1, new backgroundAnimationTimerListener ( ) );
    
    //establish excel reader
    private UNICODE_ExcelReader excelReader = new UNICODE_ExcelReader ( );
 
    //text field tests
    private int MAXIMUM_ENTRANCE_FIELDS = 2;
    public UNICODE_TextField entranceFields [ ] = 
                                            {
                                                new UNICODE_TextField ( 0, 0, "username : ", "? ", 1, true, false, true ),
                                                new UNICODE_TextField ( 0, 0, "password : ", "? ", 1, true, true, true )
                                            };
                                            
                                            
    //hide mechanism
    public UNICODE_HideMechanism hAccess = new UNICODE_HideMechanism ( );
    public UNICODE_HideMechanism hider = null;
   /* ( String _tray_icon_label, String _menu_item_label, String _tray_icon_directory, 
    * boolean _surface_contact, 
    * JFrame _applicationFrame, 
    String _unhideAudioClipName, String _boxRestorationMessage, String _boxDirectory, String _boxButtonType,
    float _boxOpacityLevel, 
    Color _boxColour, Color _boxTextBackgroundColour, Color _boxTextForegroundColour,
    int _boxButtonWidth, int _boxButtonHeight, int arcWidth, int arcHeight, int axisRadiusDisplacement, int _boxButtonChopValue, 
    boolean _boxRoundedEnquiry )*/

    //tables
    public UNICODE_Structure_ComplexTable tables [ ] = 
                                                            {
                                                                new UNICODE_Structure_ComplexTable ( this ),
                                                                new UNICODE_Structure_ComplexTable ( this ),
                                                                new UNICODE_Structure_ComplexTable ( this ),
                                                                new UNICODE_Structure_ComplexTable ( this ),
                                                                new UNICODE_Structure_ComplexTable ( this )
                                                            };
    private UNICODE_Structure_SplitPane bsp_access = new UNICODE_Structure_SplitPane ( ); //convenience functions access                                                        
    private UNICODE_Structure_SplitPane table_platform;
    private JPanel tables_0_1_platform = new JPanel ( );
    private JPanel tables_2_3_4_platform = new JPanel ( );
    
    //checkbox menu
        //maximum
        private int max_checkboxes = 50;
        //labels
        private ArrayList checkboxLabels = new ArrayList ( );
        //platform
        public CHECKBOX_STRUCTURE checkboxPlatform;
  
    //establish a bushman button to access convenience functions ( not actual button )
    public UNICODE_Button bbAccess = new UNICODE_Button ( );
    
    //establish a bushman menu to access convenience functions ( not actual menu )
    public UNICODE_Menu bmAccess = new UNICODE_Menu ( );
    
    //establish a bushman text field to access convenience functions
    public UNICODE_TextField bfAccess = new UNICODE_TextField ( );
    
    
    //clock mechanism
        //date creator
        public UNICODE_DateCreator dateCreator = new UNICODE_DateCreator ( );
        //clock timer
        public Timer clockTimer = new Timer ( 1, new clock_action_listening ( ) );
        //clock text field
        public UNICODE_TextField clockField = new UNICODE_TextField ( 0, 0, " ", ": ", 1, true, false, false );
        
        //estblish rednering hint to install anti-aliasing
        public UNICODE_AntiAliasingController anti_alias_manager = new UNICODE_AntiAliasingController ( configurationManager.getAntiAliasingStateFromFile ( ) );


        
    public UNICODE_GuiPanel ( JFrame UNICODE_frame, int applicationWidth, int applicationHeight )
    {
        //establish application frame
        applicationFrame = UNICODE_frame;
        this.applicationWidth = applicationWidth;
        this.applicationHeight = applicationHeight;
        //establish hider
        hider = new UNICODE_HideMechanism ( 
                                            440, 440,
                                            "tray icon.png", "uni-code ux engine", "uni-code ux engine", 
                                            false, 
                                            applicationFrame, applicationWidth, applicationHeight,
                                            "data/audios/restoration success.wav", "buffer restoration complete", "data/images/all/hide mechanism/", "elipse", 
                                            0.4f,
                                            Color.black, Color.black, Color.white, 
                                            64, 64, 64, 64, 180, 10, true 
                                            );
        //play welcome audio - OPTIONAL replace with your audio files
        //audio_player.playAudio ( "" + new UNICODE_MenuPanel ( ).getAudioByAlias ( "s" ) );
        //audio_player.playAudio ( "" + getAudioByAlias ( "a" ) ); 

        //establish bg colour
        setBackground ( configurationManager.getColourFromFile ( ) ); //so black buttons outline is visible
        
            
        //////////////////////////////////////////////
        //MENUS
        ////////////////////////////////////////////// 
        //establish button dock
        //UNICODE_MenuPanel ( ArrayList <Object> _customComponentList, boolean menuVisibility, int _xCoord, int _yCoord, int _MAXIMUM_BUTTONS, int BUTTON_PROXIMITY, int AXIS_PROXIMITY, String axisDirection, String axisLayoutType, String buttonListDirectory, int buttonWidth, int buttonHeight, Color bgColour, Color buttonOutlineColour, String _buttonShapeType,  int arcHeight, int arcDepth, int lastButtonChopValue )
        passwordMenuButtonDock = new PASSWORD_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_PMBD_BUTTONS - BUTTON_SPAN * MAXIMUM_PMBD_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 2, MAXIMUM_PMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/password menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );
        mainMenuButtonDock = new MAIN_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_MMBD_BUTTONS - BUTTON_SPAN * MAXIMUM_MMBD_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 6, MAXIMUM_MMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/main menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );       
        settingsMenuButtonDock = new SETTINGS_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_SMBD_BUTTONS - BUTTON_SPAN * MAXIMUM_SMBD_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 6, MAXIMUM_SMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/settings menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );
        colourMenuButtonDock = new COLOUR_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_CMBD_BUTTONS - BUTTON_SPAN * MAXIMUM_CMBD_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 6, MAXIMUM_CMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/colour menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );
        opacityMenuButtonDock = new OPACITY_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_OMBD_BUTTONS - BUTTON_SPAN * MAXIMUM_OMBD_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 2, MAXIMUM_OMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/opacity menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );
        antiAliasMenuButtonDock = new ANTI_ALIAS_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_AAMBD_BUTTONS - BUTTON_SPAN * MAXIMUM_AAMBD_BUTTONS  ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 2, MAXIMUM_AAMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/anti alias menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );
        tableMenuButtonDock = new TABLE_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_TMBD_BUTTONS - BUTTON_SPAN * 2 * MAXIMUM_TMBD_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 5, MAXIMUM_TMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/table menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );
        dynamicCheckboxMenuButtonDock = new DYNAMIC_CHECKBOX_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) applicationWidth - ( BUTTON_SPAN * MAXIMUM_DCMBD_BUTTONS - BUTTON_SPAN * MAXIMUM_DCMBD_BUTTONS ), ( BUTTON_SPAN * 5 ) + BUTTON_SPAN * 2, MAXIMUM_DCMBD_BUTTONS, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, UNICODE_MenuPanel.CIRCULAR_AXIS_PROXIMITY, "anti-clockwise", "circular", "data/images/checkbox menu/", BUTTON_SPAN, BUTTON_SPAN, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/2 );
        hideMenuButtonDock = new HIDE_MENU_BUTTON_DOCK ( generatedCustomComponentList ( ), true, ( int ) hider.RESIZE_BUFFER_WIDTH/2 + BUTTON_SPAN * 2, hider.RESIZE_BUFFER_HEIGHT / 2 + ( BUTTON_SPAN * 3 ) + 16, MAXIMUM_HMBD_BUTTONS, UNICODE_MenuPanel.SMALL_CIRCULAR_BUTTON_PROXIMITY + 3, UNICODE_MenuPanel.SMALL_CIRCULAR_AXIS_PROXIMITY - 20, "anti-clockwise", "circular", "data/images/hide menu/", BUTTON_SPAN - 14, BUTTON_SPAN - 14, Color.black, Color.black, "e", BUTTON_SPAN, BUTTON_SPAN, BUTTON_SPAN/3 );
        
        
        //////////////////////////////////////////////
        //SCHEDULE TABLES
        ////////////////////////////////////////////// 
        //establish schedule requirements
            //establish general schedule view table
                //setup table column headers
                tables [ 0 ].describeColumns ( tables [ 0 ].makeColumnDescription ( "header-1 header-2 images header-4 header-5 header-6", 6 ) );
                //define colour scheme [ default(1)background, default(2)foreground, higlighted(3)background, higlighted(4)foreground ]                    
                tables [ 0 ].establishColourScheme ( new Color ( 0, 0, 0, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 0, 0, 0, 255 ) );
                //setup table body for updating
                tables [ 0 ].setup ( 50, "data/images/table menu/", "table bg.png", "center" );
                //setup 
                tables [ 0 ].getTable ( ).setColumnSelectionAllowed ( true );
                tables [ 0 ].getTable ( ).setRowSelectionAllowed ( true );
           //establish schedule info tables
                //establish schedule table - general course infos
                    //setup table column headers
                    tables [ 1 ].describeColumns ( tables [ 1 ].makeColumnDescription ( "header-1 header-2", 2 ) );
                    //define colour scheme [ default(1)background, default(2)foreground, higlighted(3)background, higlighted(4)foreground ]                    
                    tables [ 1 ].establishColourScheme ( new Color ( 0, 0, 0, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 0, 0, 0, 255 ) );
                    //setup table body for updating
                    tables [ 1 ].setup ( 50, "data/images/table menu/", "table bg.png","center" );
                //establish schedule table - personnel general info
                    //setup table column headers
                    tables [ 2 ].describeColumns ( tables [ 2 ].makeColumnDescription ( "header", 1 ) );
                    //define colour scheme [ default(1)background, default(2)foreground, higlighted(3)background, higlighted(4)foreground ]                    
                    tables [ 2 ].establishColourScheme ( new Color ( 0, 0, 0, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 0, 0, 0, 255 ) );
                    //setup table body for updating
                    tables [ 2 ].setup ( 50, "data/images/table menu/", "table bg.png", "center" );
                //establish schedule table - personnel activities 
                    //setup table column headers
                    tables [ 3 ].describeColumns ( tables [ 3 ].makeColumnDescription ( "header", 1 ) );
                    //define colour scheme [ default(1)background, default(2)foreground, higlighted(3)background, higlighted(4)foreground ]                    
                    tables [ 3 ].establishColourScheme ( new Color ( 0, 0, 0, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 0, 0, 0, 255 ) );
                    //setup table body for updating
                    tables [ 3 ].setup ( 50, "data/images/table menu/", "table bg.png", "center" );
                //establish schedule table - schedule component info
                    //setup table column headers
                    tables [ 4 ].describeColumns ( tables [ 4 ].makeColumnDescription ( "header-1 images", 2 ) );
                    //define colour scheme [ default(1)background, default(2)foreground, higlighted(3)background, higlighted(4)foreground ]                    
                    tables [ 4 ].establishColourScheme ( new Color ( 0, 0, 0, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 255, 255, 255, 255 ), new Color ( 0, 0, 0, 255 ) );
                    //setup table body for updating
                    tables [ 4 ].setup ( 50, "data/images/table menu/", "table bg.png", "center" );
            //establish platforms ( sub panels )
                //establish platform for schedule table 0 and a schedule table 1
                tables_0_1_platform.add ( tables [ 0 ].getScrollPane ( ) );
                tables_0_1_platform.add ( tables [ 1 ].getScrollPane ( ) );
                tables_0_1_platform.setLayout ( new BoxLayout ( tables_0_1_platform, BoxLayout.Y_AXIS ) );
                //establish platform for schedule tables 2 - 4
                tables_2_3_4_platform.add ( tables [ 2 ].getScrollPane ( ) );
                tables_2_3_4_platform.add ( tables [ 3 ].getScrollPane ( ) );
                tables_2_3_4_platform.add ( tables [ 4 ].getScrollPane ( ) );
                tables_2_3_4_platform.setLayout ( new BoxLayout ( tables_2_3_4_platform, BoxLayout.Y_AXIS ) );
                //establish main schedule platform to house all sub panels above
                table_platform = new UNICODE_Structure_SplitPane ( 150, 1, tables_2_3_4_platform, tables_0_1_platform, bsp_access.makeDim ( 5, 5 ), true );
                table_platform.establishPanePaneSplit ( );
                tableMenuButtonDock.add ( table_platform.getSplitPane ( ) );
                
        //////////////////////////////////////////////
        //CHECBOX MENU
        //////////////////////////////////////////////   
            checkboxPlatform = new CHECKBOX_STRUCTURE ( 0, max_checkboxes, dynamicCheckboxMenuButtonDock, 1, 10, 10 );
            //generate some checbox labels
            for ( int i = 0; i < max_checkboxes; i ++ )
                checkboxLabels.add ( "ITEM00" + i );
            
            //add some boxes
            for ( int boxes = 0; boxes < max_checkboxes; boxes ++ )
                checkboxPlatform.addBox ( "data/images/checkbox menu/checkbox/", ( String ) checkboxLabels.get ( boxes ), false, "default.png", "hovered.png", "selected.png", "hovered selection.png" );
            //tell checkbox platforms to setup checboxes wrt to this panel, and establish panel wrt to 
            //this background's colour.
            checkboxPlatform.setup ( getBackground ( ), Color.lightGray );
            
        //add mouse listener
        addMouseListener ( new mouseListening ( ) );
        addMouseMotionListener ( new mouseListening ( ) );
        
        //add key listening
        addKeyListener ( new keyListening ( ) );
        
        //set focus to this panel
        setFocusable ( true );
        
        //////////////////////////////////////////////
        //HIDE MECHANISM 
        //////////////////////////////////////////////       
        hider.establishComponents ( );
        
        //initialise initial opcaity level value at startup
        initial_opacity = getStartupOpacityLevel ( );
        
        
        //////////////////////////////////////////////
        //PANEL HIDINGS
        //////////////////////////////////////////////   
            //hide the checkbox menu platform iniitally, or other non-scroled-paned components that have been added
            //will be distorted relative to paned component, position wise.
            //checkboxPlatform.getPane ( ).setVisible ( false );
            

        add ( passwordMenuButtonDock );
        add ( mainMenuButtonDock );
        add ( settingsMenuButtonDock );
        add ( colourMenuButtonDock );
        add ( opacityMenuButtonDock );
        add ( antiAliasMenuButtonDock );
        add ( tableMenuButtonDock );
        add ( dynamicCheckboxMenuButtonDock );   
        add ( hideMenuButtonDock );
        
        passwordMenuButtonDock.setVisible (  true  );
        mainMenuButtonDock.setVisible ( false );
        settingsMenuButtonDock.setVisible ( false );
        colourMenuButtonDock.setVisible ( false );
        opacityMenuButtonDock.setVisible ( false );
        antiAliasMenuButtonDock.setVisible ( false );
        tableMenuButtonDock.setVisible ( false );
        dynamicCheckboxMenuButtonDock.setVisible ( false );  
        hideMenuButtonDock.setVisible ( true );  
    }
    
    //add custom components which dont exist in UNICODE_MenuPanel by default,
    //where button click response is conceerned.
    public ArrayList <Object> generatedCustomComponentList ( )
    {
        ArrayList <Object> value = new ArrayList <Object> ( );
        
        value.add ( this );
        
        return value;
    }

    //return current opacity level
    public float getStartupOpacityLevel ( )
    {
        opacityManager.setOpacLevel ( configurationManager.getOpacityFromFile ( ) );
        return opacityManager.getOpacLevel ( );
    }
    
    //get opacity level at startup so we may pas
    
    public void paintComponent ( Graphics graphics )
    {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;
        
        //establish anti aliasing
        anti_alias_manager.setupAntiAliasing ( graphics2d );
        
        
        //establish docks' dimensions
        passwordMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );        
        mainMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        settingsMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        colourMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        opacityMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        antiAliasMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        dynamicCheckboxMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        checkboxPlatform.PLATFORM.setBounds ( applicationWidth/2 - checkboxPlatform.PLATFORM.getWidth ( )/2, applicationHeight/2 - checkboxPlatform.PLATFORM.getHeight ( ), checkboxPlatform.PLATFORM.getWidth ( ), checkboxPlatform.PLATFORM.getHeight ( ) );
        tableMenuButtonDock.setBounds ( 0, 0, applicationWidth, applicationHeight );   
        table_platform.getSplitPane ( ).setBounds ( applicationWidth/2 - 600/2, applicationHeight/2 - 300, 600, 420 ); 
        //choose an arbitrary size of 400x400 for hider dock. this arbitrary value must match resize param for triggerFrameResized in MAIBN_MENU_BUTTON_DOCK
        hideMenuButtonDock.setBounds ( 0, 0, hider.RESIZE_BUFFER_WIDTH, hider.RESIZE_BUFFER_HEIGHT );             
        
        //show ui axis 
        //passwordMenuButtonDock.getMenu ( ).showUiAxis ( graphics2d, Color.red );
       
        
        //establish menu labels
            //control colour
            if ( grabbedColourIndex == 11 )
                graphics2d.setColor ( Color.black );
            else 
                graphics2d.setColor ( Color.white );
            //show labels
            colourMenuButtonDock.getMenu ( ).createLabel ( graphics, graphics2d, font, "" + menuLabelArchive [ 0 ], menu_label_size, "AristotlePunk.ttf" );
       
       //show background animation
       //bmAccess.showAnimation ( graphics,  graphics2d, this, "sine curve anim bg.png", texture_paint, UNICODE_MenuPanel.CIRCULAR_BUTTON_PROXIMITY, 0.003, 0.005, ( screen_height / 2 + screen_height / 3 ) );  
   
        

        
        //bound other entities display bool wrt menus
//         if ( hider.getDiscloseRunSessionEnquiry ( ) )
//             clockField.draw ( graphics, graphics2d, font, "pricedown.ttf", "AngelicWar.ttf", 4.0f, Color.gray, 30.0f, Color.gray, "yes", 140, 10, 25.0f, ".", 20, Color.white, hider.getResizedFrameWidth ( ), hider.getResizedFrameHeight ( ) );
        
        //restore hider frame mininimal opacity when not focus
   
        
        //menu 0 - password menu
        if ( passwordMenuButtonDock.isVisible ( ) )
        {
            table_platform.getSplitPane ( ).setVisible ( false );
            checkboxPlatform.getPane ( ).setVisible ( false );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( true );
            //draw ( Graphics graphics, Graphics2D graphics2d, UNICODE_CustomFont font, String label_font_name, String text_field_font_name, float text_field_size, Color text_field_colour, float label_size, 
            //Color label_colour, String center_answer, int jump_x, int jump_y, float pointer_size, String pointer, int pointer_distance, 
            //Color pointer_colour )
        }
        //menu 1 - main menu
        if ( mainMenuButtonDock.isVisible ( ) )
        {
            table_platform.getSplitPane ( ).setVisible ( false );  
            checkboxPlatform.getPane ( ).setVisible ( false );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( false );
        }
        //menu 2 - settings menu    
        if ( settingsMenuButtonDock.isVisible ( ) )
        {
            table_platform.getSplitPane ( ).setVisible ( false );  
            checkboxPlatform.getPane ( ).setVisible ( false );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( false );
        }        
        //menu 3 - colour menu    
        if ( colourMenuButtonDock.isVisible ( ) )
        {
            table_platform.getSplitPane ( ).setVisible ( false );  
            checkboxPlatform.getPane ( ).setVisible ( false );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( false );
        }  
        //menu 4 - opacity menu     
        if ( opacityMenuButtonDock.isVisible ( ) )
        {
            table_platform.getSplitPane ( ).setVisible ( false ); 
            checkboxPlatform.getPane ( ).setVisible ( false );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( false );
            //show opacity level
            opacityMenuButtonDock.getMenu ( ).createLabel ( graphics, graphics2d, font, "" + opacityManager.percentageRepresentation ( ) [ 0 ] + " percent transparency", screen_width/5, screen_height/9, 48.0f, "AristotlePunk.ttf" );
            opacityMenuButtonDock.getMenu ( ).createLabel ( graphics, graphics2d, font, "" + opacityManager.percentageRepresentation ( ) [ 1 ] + " percent opacity", screen_width/8, screen_height/5, 48.0f, "AristotlePunk.ttf" );
        }       
        //menu 5 - table menu  
        if ( tableMenuButtonDock.isVisible ( ) )
        {
            table_platform.getSplitPane ( ).setVisible ( true );  
            checkboxPlatform.getPane ( ).setVisible ( false );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( false );
        }        
        //menu 6 - checkbox menu
        if ( dynamicCheckboxMenuButtonDock.isVisible ( ) )
        {
            menuLabelArchiveIndex = 6;
            table_platform.getSplitPane ( ).setVisible ( false );  
            checkboxPlatform.getPane ( ).setVisible ( true );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( false );
        }   
        //menu 7 - anti alias menu
        if ( antiAliasMenuButtonDock.isVisible ( ) )
        {
            menuLabelArchiveIndex = 5;
            table_platform.getSplitPane ( ).setVisible ( false );  
            checkboxPlatform.getPane ( ).setVisible ( false );
            for ( int fields = 0; fields < MAXIMUM_ENTRANCE_FIELDS; fields ++ )
                entranceFields [ fields ].setVisible ( false );
        }   
    }
    
    class mouseListening implements MouseListener, MouseMotionListener
    { 
        public void mouseClicked ( MouseEvent mEvent )
        {
            /////////////////////////////////////////////////////////////
            //ALLOW SCREEN CENTERING ABILITY WHEN USER CLICKS CLIENT AREA
            /////////////////////////////////////////////////////////////
            if ( !hider.getDiscloseRunSessionEnquiry ( ) )
                applicationFrame.setLocationRelativeTo ( null );
            ////////////////////////////////
            //hide mechanism button
            ////////////////////////////////
            /*
            if ( hider.getDiscloseRunSessionEnquiry ( ) )
            {
                if ( hider.getDiscloseButtons ( ) [ 0 ].contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
                {
                    //audio_player.playAudio ( getAudioByAlias ( "mls" ) );
                    //audio_player.playAudio ( getAudioByAlias ( "e" ) );
                    hider.triggerMemoryImprinting ( dateCreator, clockField );
                }
                if ( hider.getDiscloseButtons ( ) [ 1 ].contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
                {
                    applicationFrame.setOpacity ( initial_opacity );
                    applicationFrame.repaint ( );
                    hider.killDiscloseSession ( );
                    clockTimer.stop ( );
                    //audio_player.playAudio ( getAudioByAlias ( "e" ) );
                    //audio_player.playAudio ( getAudioByAlias ( "rs" ) );
                    hider.triggerFrameUnresized ( applicationFrame, initial_screen_width, initial_screen_height );
                    mainMenuButtonDock.getMenu ( ).setVisibility ( true );
                }
                if ( hider.getDiscloseButtons ( ) [ hider.getMaxButtons ( ) - 1 ].contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
                {
                    //audio_player.playAudio ( getAudioByAlias ( "t" ) );
                    hider.killDiscloseSession ( );
                    System.exit ( 0 );
                }
            }*/
            
        }
        
        public void mouseReleased ( MouseEvent mEvent )
        {
        }
        
        public void mouseEntered ( MouseEvent mEvent )
        {
        }  
        
        public void mouseExited ( MouseEvent mEvent )
        {
        }
        public void mouseMoved ( MouseEvent mEvent )
        {
        }
        public void mousePressed ( MouseEvent mEvent )
        {
            //establish mouse pressed coords
            held_mouse_coords = mEvent.getPoint ( );
        }
        
        public void mouseDragged ( MouseEvent mEvent )
        {         
            //establish dragged mouse coordinates
            dragged_mouse_coords = mEvent.getLocationOnScreen ( );    
            applicationFrame.setLocation ( ( int ) ( dragged_mouse_coords.getX ( ) - held_mouse_coords.getX ( ) ), ( int ) ( dragged_mouse_coords.getY ( ) - held_mouse_coords.getY ( ) ) );
        }
    }    
     
   
    //mouse wheel rotation listenening
 
  
    
    //establish background animation timer action listener
    private class backgroundAnimationTimerListener implements ActionListener
    {
        public void actionPerformed ( ActionEvent aEvent )
        {
            bmAccess.incBackgroundAnimationCycle ( 5 );
            repaint ( );
        }
    }
    
    //establish key listeneing
    private class keyListening implements KeyListener 
    {
        public void keyPressed ( KeyEvent kEvent ) 
        {
            entranceFields [ 0 ].allowUpdating ( kEvent, 50, "" );
            entranceFields [ 1 ].allowUpdating ( kEvent, 50, "." );
            repaint ( );
        }
        public void keyReleased ( KeyEvent kEvent ) 
        {
        }
        public void keyTyped ( KeyEvent kEvent ) 
        {
        }
    }
  
  
    
    //clock action listener for hider session
    private class clock_action_listening implements ActionListener
    {  
        public void actionPerformed ( ActionEvent c_event )
        {
            Date time = new Date ( );  
            String hours = "";
            String time_of_day = "";
            if ( time.getHours ( ) <= 12 ) 
            {
                hours = "" + ( time.getHours ( ) );  //if 24 hour clock less than or equal to 12 hours, then don't subtract 12, real 12 hour time is alreadybeing displayed!      
                time_of_day = "am";
            }
            if ( time.getHours ( ) > 12 ) 
            {
                hours = "" + ( time.getHours ( ) - 12 ); //else minus that 12, cause we don't wan 24 hour time, and a non negative value will always be shown!
                time_of_day = "pm";
            }
            clockField.setLabel ( "" + "TIME : " + hours + ":" + time.getMinutes ( ) + ":" + time.getSeconds ( ) + " " + time_of_day );
        }
    }
}

