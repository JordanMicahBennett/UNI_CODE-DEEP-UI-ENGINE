import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.text.NumberFormat;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimerTask;
import javax.swing.BorderFactory;

import data.packages.UNICODE.*;

public class BUTTON_DOCK extends UNICODE_MenuPanel
{
    public BUTTON_DOCK ( ArrayList <Object> customComponentList, boolean menuVisibility, int _xCoord, int _yCoord, int _MAXIMUM_BUTTONS, int BUTTON_PROXIMITY, int AXIS_PROXIMITY, String axisDirection, String axisLayoutType, String buttonListDirectory, int buttonWidth, int buttonHeight, Color bgColour, Color buttonOutlineColour, String buttonShapeType, int arcHeight, int arcDepth, int lastButtonChopValue )
    {
        super ( customComponentList, menuVisibility, _xCoord, _yCoord, _MAXIMUM_BUTTONS, BUTTON_PROXIMITY, AXIS_PROXIMITY, axisDirection, axisLayoutType, buttonListDirectory, buttonWidth, buttonHeight, bgColour, buttonOutlineColour, buttonShapeType, arcHeight, arcDepth, lastButtonChopValue );

    }
    
    //abstract method
    public void mouseClickedExtendedDefinition ( MouseEvent mEvent )
    { 
        for ( int i = 3; i < 5; i ++ )
            if ( getMenu ( ).getButtonList ( ).get ( i ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
            {
                audioPlayer.playAudio ( "" + getAudioByAlias ( "e" ) ); 
                new UNICODE_MessageBoxWindow ( true, "not avilable in current version", 0.9f, new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), false, "data/images/message box/okay/","rr", 64, 64, 0, 0, 0, 0 );    
            }
        
        //item 0 - see all lab techs
        if ( getMenu ( ).getButtonList ( ).get ( 0 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            final UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            
            ///////////////////////////////////////
            //SELECT MODE
            ///////////////////////////////////////
            if ( guiPanel.QUERY_AREA.getText ( ).contains ( "select" ) )
            {
                //remove previous tables
                guiPanel.remove ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                    
                //RE-ESTABLISH OUTCOME TABLE based on latest query
                guiPanel.OUTCOME_TABLE = guiPanel.DATABASE_MANAGER.getDefinedTable ( 80, "data/images/table menu/", "table background.png", "center", "data/images/intervolve/thumb.png", "data/images/intervolve/track.png", Color.white, guiPanel, guiPanel.QUERY_AREA.getText ( ),  new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), new Color ( 253, 253, 253 ), new Color ( 230, 230, 230 ) );

                //add OUTCOME table to guiPanel
                guiPanel.add ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                guiPanel.setLayout ( new javax.swing.BoxLayout ( guiPanel, javax.swing.BoxLayout.Y_AXIS ) );
                guiPanel.revalidate ( );
                guiPanel.repaint ( );
                
                new UNICODE_MessageBoxWindow ( true, "table refreshed from successful <select> query!", 0.9f, new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), false, "data/images/message box/okay/","rr", 64, 64, 0, 0, 0, 0 );    
            }
            ///////////////////////////////////////
            //UPDATE MODES
            ///////////////////////////////////////
            else 
            {
                ///////////////////////////////////////
                //UPDATE MODES (0) - INSERTION QUERY
                ///////////////////////////////////////   
                if ( guiPanel.QUERY_AREA.getText ( ).contains ( "insert" ) )
                {
                    //run insert query
                    guiPanel.DATABASE_MANAGER.insertQuery ( guiPanel.QUERY_AREA.getText ( ) );
                    
                    //remove previous tables
                    guiPanel.remove ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                        
                    //RE-ESTABLISH OUTCOME TABLE based on latest query
                    guiPanel.OUTCOME_TABLE = guiPanel.DATABASE_MANAGER.getDefinedTable ( 80, "data/images/table menu/", "table background.png", "center", "data/images/intervolve/thumb.png", "data/images/intervolve/track.png", Color.white, guiPanel, guiPanel.DATABASE_MANAGER.getSelectQueryAtQuery ( guiPanel.QUERY_AREA.getText ( ) ),  new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), new Color ( 253, 253, 253 ), new Color ( 230, 230, 230 ) );
    
                    //add OUTCOME table to guiPanel
                    guiPanel.add ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                    guiPanel.setLayout ( new javax.swing.BoxLayout ( guiPanel, javax.swing.BoxLayout.Y_AXIS ) );
                    guiPanel.revalidate ( );
                    guiPanel.repaint ( );
                
                    //show message
                    new UNICODE_MessageBoxWindow ( true, "table refreshed from successful <insert> query!", 0.9f, new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), false, "data/images/message box/okay/","rr", 64, 64, 0, 0, 0, 0 );    
                }
                ///////////////////////////////////////
                //UPDATE MODES (0) - UPDATE QUERY
                ///////////////////////////////////////
                if ( guiPanel.QUERY_AREA.getText ( ).contains ( "update" ) )
                {
                    //run update query
                    guiPanel.DATABASE_MANAGER.updateQuery ( guiPanel.QUERY_AREA.getText ( ) );
                    
                    //remove previous tables
                    guiPanel.remove ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                        
                    //RE-ESTABLISH OUTCOME TABLE based on latest query
                    guiPanel.OUTCOME_TABLE = guiPanel.DATABASE_MANAGER.getDefinedTable ( 80, "data/images/table menu/", "table background.png", "center", "data/images/intervolve/thumb.png", "data/images/intervolve/track.png", Color.white, guiPanel, guiPanel.DATABASE_MANAGER.getSelectQueryAtQuery ( guiPanel.QUERY_AREA.getText ( ) ),  new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), new Color ( 253, 253, 253 ), new Color ( 230, 230, 230 ) );
    
                    //add OUTCOME table to guiPanel
                    guiPanel.add ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                    guiPanel.setLayout ( new javax.swing.BoxLayout ( guiPanel, javax.swing.BoxLayout.Y_AXIS ) );
                    guiPanel.revalidate ( );
                    guiPanel.repaint ( );
                
                    //show message
                    new UNICODE_MessageBoxWindow ( true, "table refreshed from successful <update> query!", 0.9f, new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), false, "data/images/message box/okay/","rr", 64, 64, 0, 0, 0, 0 );    
                }  
                ///////////////////////////////////////
                //UPDATE MODES (0) - DELETE QUERY
                ///////////////////////////////////////   
                if ( guiPanel.QUERY_AREA.getText ( ).contains ( "delete" ) )
                {
                    //run delete query
                    guiPanel.DATABASE_MANAGER.updateQuery ( guiPanel.QUERY_AREA.getText ( ) );
                    
                    //remove previous tables
                    guiPanel.remove ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                        
                    //RE-ESTABLISH OUTCOME TABLE based on latest query
                    guiPanel.OUTCOME_TABLE = guiPanel.DATABASE_MANAGER.getDefinedTable ( 80, "data/images/table menu/", "table background.png", "center", "data/images/intervolve/thumb.png", "data/images/intervolve/track.png", Color.white, guiPanel, guiPanel.DATABASE_MANAGER.getSelectQueryAtQuery ( guiPanel.QUERY_AREA.getText ( ) ),  new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), new Color ( 253, 253, 253 ), new Color ( 230, 230, 230 ) );
    
                    //add OUTCOME table to guiPanel
                    guiPanel.add ( guiPanel.OUTCOME_TABLE.getScrollPane ( ) );
                    guiPanel.setLayout ( new javax.swing.BoxLayout ( guiPanel, javax.swing.BoxLayout.Y_AXIS ) );
                    guiPanel.revalidate ( );
                    guiPanel.repaint ( );
                    
                    //show message
                    new UNICODE_MessageBoxWindow ( true, "table refreshed from successful <delete> query!", 0.9f, new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), false, "data/images/message box/okay/","rr", 64, 64, 0, 0, 0, 0 );    
                }    
            }
            
            audioPlayer.playAudio ( "" + getAudioByAlias ( "e" ) ); 
        }

        //get current table name ( or rather name @ last executed sql query )
        if ( getMenu ( ).getButtonList ( ).get ( 1 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            final UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            
            //show message
            new UNICODE_MessageBoxWindow ( true, guiPanel.DATABASE_MANAGER.getTableName ( guiPanel.QUERY_AREA.getText ( ) ), 0.9f, new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), false, "data/images/message box/okay/","rr", 64, 64, 0, 0, 0, 0 );    
 
            audioPlayer.playAudio ( "" + getAudioByAlias ( "t" ) ); 
        }
        
        //get current sql query execution time ( or rather execution time @ last executed sql query )
        if ( getMenu ( ).getButtonList ( ).get ( 2 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            final UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            
            //show message
            new UNICODE_MessageBoxWindow ( true, guiPanel.DATABASE_MANAGER.getExecutionTime ( ), 0.9f, new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), false, "data/images/message box/okay/","rr", 64, 64, 0, 0, 0, 0 );    
 
            audioPlayer.playAudio ( "" + getAudioByAlias ( "t" ) ); 
        }
        
        
        //quit software
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            audioPlayer.playAudio ( "" + getAudioByAlias ( "t" ) ); 
            System.exit ( 0 );
        }
        
        repaint ( );
    }

    public void mouseMovedExtendedDefinition ( MouseEvent mEvent )
    {
    }
    
    public void mouseEnteredExtendedDefinition ( MouseEvent mEvent )
    {
    }
    
    public void mouseExitedExtendedDefinition ( MouseEvent mEvent )
    {
    }
    
    public void mouseDraggedExtendedDefinition ( MouseEvent mEvent )
    {
    }
    
    public void mouseReleasedExtendedDefinition ( MouseEvent mEvent )
    {
    }
    
    public void mousePressedExtendedDefinition ( MouseEvent mEvent )
    {
    }
    
    public void mouseWheelRolledExtendedDefinition ( MouseWheelEvent mwEvent )
    {
    }


    
    //extra rendering
    public void drawMore ( )
    {
    }
}  