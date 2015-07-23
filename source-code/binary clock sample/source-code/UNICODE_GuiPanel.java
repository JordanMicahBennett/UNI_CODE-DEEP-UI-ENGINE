//author : jordan micah bennett
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Toolkit;

import data.packages.UNICODE.*; //important

public class UNICODE_GuiPanel extends JPanel
{
    //establish custom font
    public UNICODE_CustomFont font = new UNICODE_CustomFont ( "data/fonts/" );

    //establish complex table
    private UNICODE_BinaryClock binaryClock = null;
    private Color activeColour = null, inactiveColour = null;
    
    //establish constructor
    public UNICODE_GuiPanel ( int visualDelayLimit )
    {
        //establish binary clock
                                                        //public UNICODE_BinaryClock 
                                                        //(
                                                            //Dimension bufferDimension, 
                                                            //double visualDelayLimit (delay showing clock for splash screen duration=2000), 
                                                            //int yDisplacementHelper, 
                                                            //Color clockElementBaseColour, 
                                                            //Color clockBaseContainerColour, 
                                                            //Color clockElementEnabledColour,
                                                            //Color clockElementDisabledColour, 
                                                            //int tickDelay, 
                                                            //int clockElementSize, 
                                                            //Color defaultDateStringColour, 
                                                            //String fontName,
                                                            //int bufferWidth,
                                                            //int yLocation, 
                                                            //float fontSize, 
                                                            //String 
                                                            //binaryModeEnquiryAnswer 
                                                        //)
        //describe active colours in variables, so we can display such as strings to the user
        activeColour = new Color ( 64, 224, 208 ); //turquoise
        inactiveColour = new Color ( 160, 160, 160 );
        
        //describe binary clock structure
        binaryClock = new UNICODE_BinaryClock 
                        ( 
                            Toolkit.getDefaultToolkit ( ).getScreenSize ( ), 
                            visualDelayLimit, 
                            56, 
                            new Color ( 245, 245, 245 ), 
                            new Color ( 245, 245, 245 ), 
                            activeColour,
                            inactiveColour, 
                            1, 
                            6,
                            Color.white, 
                            "metro.ttf", 
                            200, 
                            50, 
                            26.0f, 
                            "on" 
                        );
    }
    
   
    //standard paint component for drawing
    public void paintComponent ( Graphics graphics )
    {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;
        
        //OPTIONAL describe label
        font.write ( graphics, "uni-code(tm) graphics engine {binary clock}", 80, 30, 22, "metro.ttf" );
        font.write ( graphics, "the binary clock is draggable!", 80, 400, 22, "metro.ttf" );
        font.write ( graphics, "active colour : " + activeColour, 80, 440, 22, "metro.ttf" );
        font.write ( graphics, "inactive colour : " + inactiveColour, 80, 480, 22, "metro.ttf" );
    }
}

