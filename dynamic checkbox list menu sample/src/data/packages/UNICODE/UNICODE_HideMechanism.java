package data.packages.UNICODE; //Author(s): Jordan Micah Bennett
import java.awt.TrayIcon;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Date;
import java.awt.Shape;



public class UNICODE_HideMechanism
{
    //attributes
		//establish audio player
		private UNICODE_AudioPlayer audioPlayer = new UNICODE_AudioPlayer ( );
        //establish application tray icon appearance
        private TrayIcon tray_icon = null;
        //establish system tray
        private SystemTray system_tray = null;
        //establish popup menu
        private PopupMenu popup_menu = null;
        //establish menu item
        private MenuItem menu_item = null;
        //tray properties 
        private String tray_icon_label, menu_item_label;
        private Image tray_icon_image;	
		private String tray_icon_directory = null;
		private int initialScreenWidth, initialScreenHeight;
        
        //disclose menu
        private boolean running_disclose_session = false;
		
        //establish runtime
        private Runtime runtime = null;
        private double used_memory = 0.0, free_memory = 0.0, total_memory = 0.0;

        //establish convenience pack
        private UNICODE_ConveniencePack convenience_access = new UNICODE_ConveniencePack ( );
		
		//establish application frame & dimension
		private JFrame applicationFrame = null;
		private int applicationFrameWidth, applicationFrameHeight;
		
		//establish audio clip name that describes audio to be played when menu is restored
		private String unhideAudioClipName = "";
		
		//establish box attributes
		private String boxRestorationMessage, boxDirectory, boxButtonType;
		private float boxOpacityLevel;
		private Color boxColour, boxTextBackgroundColour, boxTextForegroundColour;
		private int boxButtonWidth, boxButtonHeight, boxButtonChopValue;
		private int arcWidth, arcHeight, axisRadiusDisplacement;
		private boolean boxRoundedEnquiry;
		public int RESIZE_BUFFER_WIDTH, RESIZE_BUFFER_HEIGHT;
		
        public UNICODE_HideMechanism ( int RESIZE_BUFFER_WIDTH, int RESIZE_BUFFER_HEIGHT, String _tray_icon_label, String _menu_item_label, String _tray_icon_directory, boolean _surface_contact, JFrame _applicationFrame, int _applicationFrameWidth, int _applicationFrameHeight, String _unhideAudioClipName, String _boxRestorationMessage, String _boxDirectory, String _boxButtonType, float _boxOpacityLevel, Color _boxColour, Color _boxTextBackgroundColour, Color _boxTextForegroundColour, int _boxButtonWidth, int _boxButtonHeight, int arcWidth, int arcHeight, int axisRadiusDisplacement, int _boxButtonChopValue, boolean _boxRoundedEnquiry )
        {
			this.RESIZE_BUFFER_WIDTH = RESIZE_BUFFER_WIDTH;
			this.RESIZE_BUFFER_HEIGHT = RESIZE_BUFFER_HEIGHT;
			//establish app frame & dimension
			applicationFrame = _applicationFrame;
			applicationFrameWidth = _applicationFrameWidth;
			applicationFrameHeight = _applicationFrameHeight;
			
			//establish audio clip name
			unhideAudioClipName = _unhideAudioClipName;
			
            //establish properties
            tray_icon_label = _tray_icon_label;
            menu_item_label = _menu_item_label;
            tray_icon_directory = _tray_icon_directory;
            //establish moemry stuff
                //initialize runtime
                runtime = Runtime.getRuntime ( );
                //initialize used meomory
                used_memory = runtime.totalMemory ( ) - runtime.freeMemory ( );
                //initialize total memory
                total_memory = runtime.totalMemory ( );
                //initialize free memory
                free_memory = runtime.freeMemory ( );
				
			//establish components
			establishComponents ( );	

			//establish box attributes
			boxRestorationMessage = _boxRestorationMessage;
			boxDirectory = _boxDirectory;
			boxButtonType = _boxButtonType;
			boxOpacityLevel = _boxOpacityLevel;
			boxColour = _boxColour;
			boxTextBackgroundColour = _boxTextBackgroundColour;
			boxTextForegroundColour = _boxTextForegroundColour;
			boxButtonWidth = _boxButtonWidth;
			boxButtonHeight = _boxButtonHeight;
			boxButtonChopValue = _boxButtonChopValue;
			boxRoundedEnquiry = _boxRoundedEnquiry;
			this.arcWidth = arcWidth;
			this.arcHeight = arcHeight;
			this.axisRadiusDisplacement = axisRadiusDisplacement;
        }
        
        //convenience constructor
        public UNICODE_HideMechanism ( )
        {
        }
        
        //methods
            //accessors
			public int getInitialWidth ( )
			{
				return initialScreenWidth;
			}
			public int getInitialHeight ( )
			{
				return initialScreenHeight;
			}
			
			
            public double [ ] getMemoryData ( )
            {
                double [ ] data = null;
                data [ 0 ] = total_memory;
                data [ 1 ] = free_memory;
                data [ 2 ] = used_memory;
                return data;
            }

            public boolean getDiscloseRunSessionEnquiry ( ) //tell whether a disclose session has been toggled. a disclose session is toggled when programmer begins to hide frame.
            {
                return running_disclose_session;
            }
			public String getTrayIconDirectory ( )
			{
				return tray_icon_directory;
			}

            public void setDiscloseRunSessionEnquiry ( boolean value )
            {
                running_disclose_session = value;
            }
			public void setTrayIconDirectory ( String value )
			{
				tray_icon_directory = value;
			}
            //mutators
                //dynamic
                public void setDiscloseButtonVisibility ( boolean value )
                {
                    setDiscloseRunSessionEnquiry ( false );
                }

            //misc
            public void killDiscloseSession ( )
            {
                setDiscloseRunSessionEnquiry ( false );
            }
            
            public void establishComponents ( )
            {
                //define menus
                menu_item = new MenuItem ( menu_item_label );
                popup_menu = new PopupMenu ( );
                popup_menu.add ( menu_item );
                
                //define tray icon image
                tray_icon_image = Toolkit.getDefaultToolkit ( ).getImage ( getTrayIconDirectory ( ) );
                
                //define tray icon
                tray_icon = new TrayIcon ( tray_icon_image, tray_icon_label, popup_menu );
                
                //add listeners
                menu_item.addActionListener ( new trayListening ( ) );
                tray_icon.addActionListener ( new trayListening ( ) );
                
                //define system tray
                system_tray = SystemTray.getSystemTray ( );
                
                //add icon to tray
                try
                {
                    system_tray.add ( tray_icon );
                }
                catch ( Exception error )
                {
                }
				
				//establish screenDimensions
				initialScreenWidth = applicationFrameWidth;
				initialScreenHeight = applicationFrameHeight;
            }

            public void triggerFrameResized ( float targertFrameOpacity )
            {
				applicationFrame.setBounds ( 0, 0, RESIZE_BUFFER_WIDTH, RESIZE_BUFFER_HEIGHT );
                //applicationFrame.setBounds ( initialScreenWidth / 2 - targetFrameWidth / 2, initialScreenHeight / 2 - targetFrameHeight / 2, targetFrameWidth, targetFrameHeight );
                applicationFrame.setShape ( new Ellipse2D.Double ( 0, 0, RESIZE_BUFFER_WIDTH, RESIZE_BUFFER_HEIGHT ) );
                applicationFrame.setOpacity ( targertFrameOpacity );
                applicationFrame.repaint ( );
            }
            public void triggerFrameUnresized ( )
            {
                applicationFrame.setBounds ( 0, 0, initialScreenWidth, initialScreenHeight );
                applicationFrame.setLocationRelativeTo ( null );
                applicationFrame.setShape ( new Rectangle2D.Double ( 0, 0, initialScreenWidth, initialScreenHeight ) );
				applicationFrame.setOpacity ( 1.0f );
                applicationFrame.repaint ( );
            }    
            
            
            public void triggerMemoryImprinting ( UNICODE_DateCreator date_creator, UNICODE_TextField clock_field )
            {
                try
                {
                    PrintWriter pw = new PrintWriter ( new FileWriter ( "data/logs/memory_log.ini", true ) );
                    pw.println ( ":------------------------------------------------------------------:" );
                    pw.println ( ":-- " + date_creator.getDate ( ) );
                    pw.println ( ":-- " + clock_field.getLabel ( ) );
                    pw.println ( ":-- Total Memory : " + total_memory );
                    pw.println ( ":-- Free Memory : " + free_memory );
                    pw.println ( ":-- Used Memory : " + used_memory );
                    pw.println ( ":------------------------------------------------------------------:" );
                    pw.close ( );
                }
                catch ( Exception error )
                {
                }
                new UNICODE_MessageBoxWindow ( true, "memory print saved in data/prints/memory_log.ini", 0.9f, new Color ( 245, 245, 245 ), new Color ( 245, 245, 245 ), new Color ( 245, 245, 245 ), new Color ( 170, 170, 170 ), true, "data/images/all/message box/okay/","rr", 64, 64, 10, 10, 0, 0 );    
            }
			
	//requirement for tray listener		
    private class trayListening implements ActionListener 
    {
        public void actionPerformed ( ActionEvent aEvent )
        {
			Thread toggleUnhideThread = new Thread 
			(
				new Runnable ( )
				{
					public void run ( )
					{
						triggerFrameUnresized ( );
						killDiscloseSession ( );
						audioPlayer.playAudio ( unhideAudioClipName );
					}
				}
			);
			
			Thread toggleUnhideCancelThread = new Thread 
			(
				new Runnable ( )
				{
					public void run ( )
					{
						killDiscloseSession ( );
					}
				}
			);                                                           
			new UNICODE_MessageBoxWindow ( true, toggleUnhideThread, toggleUnhideCancelThread, boxRestorationMessage, boxOpacityLevel, boxColour, Color.black, boxTextBackgroundColour, boxTextForegroundColour, boxRoundedEnquiry, boxDirectory, boxButtonType, boxButtonWidth, boxButtonHeight, arcWidth, arcHeight, axisRadiusDisplacement, boxButtonChopValue );
		}
    }    
}
