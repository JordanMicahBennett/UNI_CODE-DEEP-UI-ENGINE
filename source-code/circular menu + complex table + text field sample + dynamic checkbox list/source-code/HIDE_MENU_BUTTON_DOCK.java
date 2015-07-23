import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;
import java.awt.Dimension;
//author : jordan micah bennett
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import data.packages.UNICODE.*;


public class HIDE_MENU_BUTTON_DOCK extends UNICODE_MenuPanel
{
    //constructor
    public HIDE_MENU_BUTTON_DOCK ( ArrayList <Object> customComponentList, boolean menuVisibility, int _xCoord, int _yCoord, int _MAXIMUM_BUTTONS, int BUTTON_PROXIMITY, int AXIS_PROXIMITY, String axisDirection, String axisLayoutType, String buttonListDirectory, int buttonWidth, int buttonHeight, Color bgColour, Color buttonOutlineColour, String buttonShapeType, int arcHeight, int arcDepth, int lastButtonChopValue )
    {
        super ( customComponentList, menuVisibility, _xCoord, _yCoord, _MAXIMUM_BUTTONS, BUTTON_PROXIMITY, AXIS_PROXIMITY, axisDirection, axisLayoutType, buttonListDirectory, buttonWidth, buttonHeight, bgColour, buttonOutlineColour, buttonShapeType, arcHeight, arcDepth, lastButtonChopValue );
    }  
    
    //abstract method
    public void mouseClickedExtendedDefinition ( MouseEvent mEvent )
    { 
        
        //button 0
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 8 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            audioPlayer.playAudio ( "" + getAudioByAlias ( "e" ) ); 
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            guiPanel.hider.triggerMemoryImprinting ( guiPanel.dateCreator, guiPanel.clockField );
        }
        
        //button 1
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 7 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            audioPlayer.playAudio ( "" + getAudioByAlias ( "rs" ) ); //restoration success message audio clip. Encapsulated in getAudioByAlias, as this clip is engine internal;
            this.setVisible ( false );
            
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            guiPanel.mainMenuButtonDock.setVisible ( true );
            guiPanel.hider.triggerFrameUnresized ( );
        }
        //exit button
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            audioPlayer.playAudio ( "" + getAudioByAlias ( "t" ) ); 
            System.exit ( 0 );
        }
        
        repaint ( );
    }

    public void mouseMovedExtendedDefinition ( MouseEvent mEvent )
    {
        UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
        this.repaint ( );
        guiPanel.applicationFrame.setOpacity ( 0.8f );
    }
    
    public void mouseEnteredExtendedDefinition ( MouseEvent mEvent )
    {
        UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
        this.repaint ( );
        guiPanel.applicationFrame.setOpacity ( 0.8f );
    }
    
    public void mouseExitedExtendedDefinition ( MouseEvent mEvent )
    {
        UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
        this.repaint ( );
        guiPanel.applicationFrame.setOpacity ( 0.1f );
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