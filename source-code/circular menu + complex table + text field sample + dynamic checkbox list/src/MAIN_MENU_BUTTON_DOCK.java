//author : jordan micah bennett
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;
import java.util.ArrayList;

import data.packages.UNICODE.*;


public class MAIN_MENU_BUTTON_DOCK extends UNICODE_MenuPanel
{    
    //constructor
    public MAIN_MENU_BUTTON_DOCK ( ArrayList <Object> customComponentList, boolean menuVisibility, int _xCoord, int _yCoord, int _MAXIMUM_BUTTONS, int BUTTON_PROXIMITY, int AXIS_PROXIMITY, String axisDirection, String axisLayoutType, String buttonListDirectory, int buttonWidth, int buttonHeight, Color bgColour, Color buttonOutlineColour, String buttonShapeType, int arcHeight, int arcDepth, int lastButtonChopValue )
    {
        super ( customComponentList, menuVisibility, _xCoord, _yCoord, _MAXIMUM_BUTTONS, BUTTON_PROXIMITY, AXIS_PROXIMITY, axisDirection, axisLayoutType, buttonListDirectory, buttonWidth, buttonHeight, bgColour, buttonOutlineColour, buttonShapeType, arcHeight, arcDepth, lastButtonChopValue );
    }
    
    //abstract method
    public void mouseClickedExtendedDefinition ( MouseEvent mEvent )
    { 
        
        //button 0
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 9 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            audioPlayer.playAudio ( "" + getAudioByAlias ( "e" ) ); 
            this.setVisible ( false );
            
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            guiPanel.tableMenuButtonDock.setVisible ( true );
        }
        //button 1
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 8 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            audioPlayer.playAudio ( "" + getAudioByAlias ( "e" ) ); 
            this.setVisible ( false );
            
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            guiPanel.dynamicCheckboxMenuButtonDock.setVisible ( true );
        }
        
        //button 7
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 2 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {/*
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            
            this.setVisible ( false );
            guiPanel.clockTimer.start ( );
            
            new UNICODE_AudioPlayer ( ).playAudio ( "" + getAudioByAlias ( "ms" ) ); 
            new UNICODE_AudioPlayer ( ).playAudio ( "" + getAudioByAlias ( "t" ) ); 
               
            guiPanel.hider.triggerFrameResized ( guiPanel.applicationFrame, 0.2f, guiPanel.applicationFrame.getWidth ( ), guiPanel.applicationFrame.getHeight ( ) );
            String stream = "blank.png:0.png:activated.png,blank.png:1.png:activated.png,blank.png:2.png:activated.png,blank.png:3.png:activated.png,blank.png:4.png:activated.png,blank.png:5.png:activated.png,blank.png:6.png:activated.png,blank.png:7.png:activated.png,blank.png:8.png:activated.png,blank.png:9.png:activated.png,blank.png:10.png:activated.png";
            guiPanel.hider.createDiscloseMenu ( guiPanel.bmAccess, guiPanel.bbAccess, 12, 130, "data/images/all/hide mechanism/", 50, 50, guiPanel.hAccess.makeDiscloseButtonPackStream ( stream, ",", 3, ":" ) );
        */
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            
            audioPlayer.playAudio ( "" + getAudioByAlias ( "ms" ) );  //byt default UNI-CODE UX engine has a "ms" clip, (minimization success clip)
            
            this.setVisible ( false );
            guiPanel.hideMenuButtonDock.setVisible ( true );
            guiPanel.hider.triggerFrameResized ( .4f );
        }
        
        //button 8
        if ( getMenu ( ).getButtonList ( ).get ( LAST_BUTTON - 1 ).contains ( mEvent.getX ( ), mEvent.getY ( ) ) )
        {
            audioPlayer.playAudio ( "" + getAudioByAlias ( "e" ) ); 
            this.setVisible ( false );
            
            UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
            guiPanel.settingsMenuButtonDock.setVisible ( true );
        }

        //exit button (button 9)
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
        UNICODE_GuiPanel guiPanel = ( UNICODE_GuiPanel ) getCustomComponentList ( ).get ( 0 );
        guiPanel.applicationFrame.setOpacity ( 1.0f );
        repaint ( );
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