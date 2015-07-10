//author : jordan micah bennett
import javax.swing.JFrame;
import java.awt.GraphicsDevice.WindowTranslucency.*;
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
        //establish duration pack for all splash panels
        static int [ ] splashPanelDurationCollection = { 200 };

    //establish main program gui panel stuff
        //establish screen dimensions
        static Dimension screenDimension = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
        //establsih gui panel: takes frame,
        static UNICODE_GuiPanel mainProgramPanel = new UNICODE_GuiPanel ( frame, ( int ) screenDimension.getWidth ( ), ( int ) screenDimension.getHeight ( ) );   
        
    //establish splash screen panel stuff
        static GENERIC_SPLASH_PANEL splashPanel = null;
        
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
                        frame.remove ( splashPanel ); //splashPanel has been defined at this point of run time. Now we can remove splash panel from the frame, and add the main program panel instead.
                        //add main program panel
                        frame.add ( mainProgramPanel );
                        //corectly display all panel components by passing panel to set content pane
                        frame.setContentPane ( mainProgramPanel ); /*translucency requirement*/
                        //set application window dimension
                        frame.setSize ( new Dimension ( ( int ) screenDimension.getWidth ( ), ( int ) screenDimension.getHeight ( ) ) );
                        //center application on screen buffer based on user's screen size
                        frame.setLocationRelativeTo ( null );
                        //set frame shape
                        frame.setShape ( new Rectangle2D.Double ( 0, 0, screenDimension.getWidth ( ), screenDimension.getHeight ( ) ) );
                        //enable full screen mode
                        //conveniencePack.enableFullScreenMode ( frame );
                        //set opacity
                        frame.setOpacity ( mainProgramPanel.getStartupOpacityLevel ( ) );
                }
            }
        );

        
        //splash screen stuff
            //ENGINE LOGO
            splashPanel = new GENERIC_SPLASH_PANEL ( splashPanelDurationCollection [ 0 ], "data/images/splash.png", mainPogramThread, null ); 
            Thread splashPanelThread = new Thread
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
                            frame.add ( splashPanel );
                            //corectly display all panel components by passing panel to set content pane
                            frame.setContentPane ( splashPanel ); /*translucency requirement*/
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
            splashPanel.commence ( );
            splashPanelThread.start ( );
    }

}