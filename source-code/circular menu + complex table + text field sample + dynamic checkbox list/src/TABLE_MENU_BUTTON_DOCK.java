//author : jordan micah bennett
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.text.NumberFormat;

import data.packages.UNICODE.*;


public class TABLE_MENU_BUTTON_DOCK extends UNICODE_MenuPanel
{
    //constructor
    public TABLE_MENU_BUTTON_DOCK ( ArrayList <Object> customComponentList, boolean menuVisibility, int _xCoord, int _yCoord, int _MAXIMUM_BUTTONS, int BUTTON_PROXIMITY, int AXIS_PROXIMITY, String axisDirection, String axisLayoutType, String buttonListDirectory, int buttonWidth, int buttonHeight, Color bgColour, Color buttonOutlineColour, String buttonShapeType, int arcHeight, int arcDepth, int lastButtonChopValue )
    {
        super ( customComponentList, menuVisibility, _xCoord, _yCoord, _MAXIMUM_BUTTONS, BUTTON_PROXIMITY, AXIS_PROXIMITY, axisDirection, axisLayoutType, buttonListDirectory, buttonWidth, buttonHeight, bgColour, buttonOutlineColour, buttonShapeType, arcHeight, arcDepth, lastButtonChopValue );
    }  
    
    //abstract method
    public void mouseClickedExtendedDefinition ( MouseEvent mEvent )
    { 
        
        //button 0 - add element
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 1 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );

            guiPanel.tables [ 0 ].getTableModel ( ).addRow ( new Object [ ] { "item-1", "item-2", new javax.swing.ImageIcon ( "data/images/table menu/table item 0.png" ), "item-4", "item-5", "item-6" } );
            guiPanel.tables [ 0 ].incrementItemCount ( );
            
            guiPanel.tables [ 1 ].getTableModel ( ).addRow ( new Object [ ] { "item-1", "item-2" } );
            guiPanel.tables [ 1 ].incrementItemCount ( );
            
            guiPanel.tables [ 2 ].getTableModel ( ).addRow ( new Object [ ] { "item-1" } );
            guiPanel.tables [ 2 ].incrementItemCount ( );
            
            guiPanel.tables [ 3 ].getTableModel ( ).addRow ( new Object [ ] { "item-1" } );
            guiPanel.tables [ 3 ].incrementItemCount ( );
            
            guiPanel.tables [ 4 ].getTableModel ( ).addRow ( new Object [ ] { "item-1", new javax.swing.ImageIcon ( "data/images/table menu/table item 1.png" ) } );
            guiPanel.tables [ 4 ].incrementItemCount ( );
        }
        
        
        //button 1 - remove element
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 2 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            
            guiPanel.tables [ 0 ].removeRow ( );       
            guiPanel.tables [ 1 ].removeRow ( );    
            guiPanel.tables [ 2 ].removeRow ( );    
            guiPanel.tables [ 3 ].removeRow ( );    
            guiPanel.tables [ 4 ].removeRow ( );    
        }
         
        //button 2 - clear table
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 3 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            
            guiPanel.tables [ 0 ].clean ( );   
            guiPanel.tables [ 1 ].clean ( );  
            guiPanel.tables [ 2 ].clean ( );  
            guiPanel.tables [ 3 ].clean ( );  
            guiPanel.tables [ 4 ].clean ( );  
        }
        
        
        //exit button
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
        	audioPlayer.playAudio ( "" + getAudioByAlias ( "t" ) ); 
            this.setVisible ( false );
            
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            guiPanel.mainMenuButtonDock.setVisible ( true );
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