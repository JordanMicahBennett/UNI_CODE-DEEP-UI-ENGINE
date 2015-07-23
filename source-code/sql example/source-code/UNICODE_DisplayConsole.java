import javax.swing.JFrame;
//import java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;
import java.awt.Dimension;
import data.packages.UNICODE.*;

public class UNICODE_DisplayConsole 
{

    //ESTABLISH FRAME
    static JFrame frame = new JFrame ( );

    //establish main program gui panel stuff
        //establish covenience pack
        static UNICODE_ConveniencePack conveniencePack = new UNICODE_ConveniencePack ( );
        //establish duration pack for all splash panels //DEFAULT ~  { 100, 100, 100 }; //TESTING = { 10, 10, 10 };
        static int [ ] splashPanelDurationCollection = { 100, 100, 100 };
        //establsih gui panel: takes frame,
        static UNICODE_GuiPanel guiPanel = new UNICODE_GuiPanel ( );
        //establish screen dimensions
        static Dimension screenDimension = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
        
    //establish splash screen panel stuff
        static SplashPanelInstanceI splashPanelI = null, splashPanelII = null;
   
    public static void main ( String [ ] args ) 
    {
        //main program stuff
        Thread mainPogramThread = new Thread
        (
            new Runnable ( )
            {
                public void run ( )
                {
                    //establish Jframe stuff
                        //remove splash panel
                        frame.remove ( splashPanelII ); //splashPanel has been defined at this point of run time. Now we can remove splash panel from the frame, and add the main program panel instead.
                        //add main program panel
                        frame.add ( guiPanel );
                         //corectly display all panel components by passing panel to set content pane
                        frame.setContentPane ( guiPanel ); /*translucency requirement*/
                        ///set application window dimension
                        frame.setSize ( new Dimension ( ( int ) new UNICODE_ConfigurationManager ( "data/config/CONFIG.ini" ).getBufferDimensionFromFile ( ).getWidth ( ), ( int ) new UNICODE_ConfigurationManager ( "data/config/CONFIG.ini" ).getBufferDimensionFromFile ( ).getHeight ( ) ) );
                        //center application on screen buffer based on user's screen size
                        frame.setLocationRelativeTo ( null );
                        //set frame shape
                        frame.setShape ( new Rectangle2D.Double ( 0, 0, new UNICODE_ConfigurationManager ( "data/config/CONFIG.ini" ).getBufferDimensionFromFile ( ).getWidth ( ), new UNICODE_ConfigurationManager ( "data/config/CONFIG.ini" ).getBufferDimensionFromFile ( ).getHeight ( ) ) );
                        //enable full screen mode
                        //conveniencePack.enableFullScreenMode ( frame );
                        //set opacity
                        frame.setOpacity ( guiPanel.getStartupOpacityLevel ( ) );
                }
            }
        );

        
        //splash screen stuff
            //ENGINE LOGO
            splashPanelII = new SplashPanelInstanceI ( splashPanelDurationCollection [ 1 ], "data/images/splash1.png", mainPogramThread, null ); 
            Thread splashPanelIIThread = new Thread
            (
                new Runnable ( )
                {
                    public void run ( )
                    {
                        //establish Jframe stuff      
                            //clear previous splash panel from frame.
                            frame.remove ( splashPanelI ); //splashPanel has been defined at this point of run time. Now we can remove splash panel from the frame, and add the main program panel instead.
                            //add gui panel
                            frame.add ( splashPanelII );
                            //corectly display all panel components by passing panel to set content pane
                            frame.setContentPane ( splashPanelII ); /*translucency requirement*/
                            //set application window dimension
                            frame.setSize ( new Dimension ( 500, 220 ) );
                            //center application on screen buffer based on user's screen size
                            frame.setLocationRelativeTo ( null );
                            //set frame shape
                            frame.setShape ( new RoundRectangle2D.Double ( 0, 0, 500, 220, 20, 20 ) );  
                            //show the frame
                            frame.setVisible ( true );
                    }
                }
            );
            
            //OS NAME LOGO
            splashPanelI = new SplashPanelInstanceI ( splashPanelDurationCollection [ 0 ], "data/images/splash0.png", splashPanelIIThread, splashPanelII ); 
            Thread splashPanelIThread = new Thread
            (
                new Runnable ( )
                {
                    public void run ( )
                    {
                        //establish Jframe stuff
                            //establish look and feel
                            frame.setDefaultLookAndFeelDecorated ( true ); /*translucency requirement*/
                            //remove frame from window
                            frame.setUndecorated ( true );
                            //add gui panel
                            frame.add ( splashPanelI );
                            //corectly display all panel components by passing panel to set content pane
                            frame.setContentPane ( splashPanelI ); /*translucency requirement*/
                            //set application window dimension
                            frame.setSize ( new Dimension ( 500, 220 ) );
                            //center application on screen buffer based on user's screen size
                            frame.setLocationRelativeTo ( null );
                            //set frame shape
                            frame.setShape ( new RoundRectangle2D.Double ( 0, 0, 500, 220, 20, 20 ) );  
                            //show the frame
                            frame.setVisible ( true );
                    }
                }
            );
            splashPanelI.commence ( );
            splashPanelIThread.start ( );

    }

}