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


public class COLOUR_MENU_BUTTON_DOCK  extends UNICODE_MenuPanel
{
    //constructor
    public COLOUR_MENU_BUTTON_DOCK ( ArrayList <Object> customComponentList, boolean menuVisibility, int _xCoord, int _yCoord, int _MAXIMUM_BUTTONS, int BUTTON_PROXIMITY, int AXIS_PROXIMITY, String axisDirection, String axisLayoutType, String buttonListDirectory, int buttonWidth, int buttonHeight, Color bgColour, Color buttonOutlineColour, String buttonShapeType, int arcHeight, int arcDepth, int lastButtonChopValue )
    {
        super ( customComponentList, menuVisibility, _xCoord, _yCoord, _MAXIMUM_BUTTONS, BUTTON_PROXIMITY, AXIS_PROXIMITY, axisDirection, axisLayoutType, buttonListDirectory, buttonWidth, buttonHeight, bgColour, buttonOutlineColour, buttonShapeType, arcHeight, arcDepth, lastButtonChopValue );
    }  
    
    //abstract method
    public void mouseClickedExtendedDefinition ( MouseEvent mEvent )
    { 
        //button 0
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 12 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 12 ] );
        }
        
        //button 1
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 11 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 11 ] );
        }  
        
        
        //button 2
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 10 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 10 ] );
        }
        
        //button 3
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 9 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 9 ] );
        }
        
        
        //button 4
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 8 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 8 ] );
        }
        
        //button 5
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 7 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 7 ] );
        }
        
        
        //button 6
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 6 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 6 ] );
        }
        
        //button 7
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 5 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 5 ] );
        }
        
        //button 8
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 4 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 4 ] );
        }
        
        //button 9
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 3 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 3 ] );
        }
        
        //button 10
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 2 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 2 ] );
        }
        
        //button 11
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 1 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            setBackground ( guiPanel.panelColourArray [ LAST_BUTTON - 1 ] );
        }
        
        //exit button
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
        	audioPlayer.playAudio ( "" + getAudioByAlias ( "t" ) ); 
            this.setVisible ( false );
            
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            guiPanel.settingsMenuButtonDock.setVisible ( true );
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
    
    public void drawMore ( )
    {
    }
}  