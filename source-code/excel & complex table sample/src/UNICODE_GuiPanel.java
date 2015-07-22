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
    private UNICODE_Structure_ComplexTable table = new UNICODE_Structure_ComplexTable ( this );
    
    //establish excel reader
    private UNICODE_ExcelReader excelReader = new UNICODE_ExcelReader ( );
    
    //establish constructor
    public UNICODE_GuiPanel ( )
    {
        //background
        setBackground ( Color.white );
        
        //establish table 
            //setup table column headers
            table.describeColumns ( table.makeColumnDescription ( "Time Monday Tuesday Wendesday Thursday Friday", 6 ) );
            //define colour scheme [ default(1)background, default(2)foreground, higlighted(3)background, higlighted(4)foreground ]                    
            table.establishColourScheme ( new Color ( 255, 255, 255 ), new Color ( 0, 0, 0 ), new Color ( 253, 253, 253 ), new Color ( 200, 200, 200 ) );
            //setup table body for updating
            table.setup ( 100, "data/images/", "table background.png", "center", "data/images/intervolve/thumb.png", "data/images/intervolve/track.png", Color.white ); //BACKGROUND IMAGES ARE ENGINE INTERNAL, must be placed in data/packags/UNICODE/
            //table setup DONE!!!!!!!!!!!!!!     
            
            //fill table with excel data!!!!!
            ////////////////String [ ] [ ] getDataArray ( String filename, int current_sheet, int num_rows, int num_columns ) 
            ////////////////void addRows ( String [ ] [ ] data, int num_rows, int initial_row )
            table.addRows ( excelReader.getDataArray ( "excel document.xls", 0, 6, 6 ), 6, 1 );
            
            //add an image at first row, via first column (displays flexibility of data types UNICODE tm table)
            table.addImageIcon ( new javax.swing.ImageIcon ( "data/images/table icon.png" ), 0, 0 );
            
    }
    
   
    //standard paint component for drawing
    public void paintComponent ( Graphics graphics )
    {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;
        
        //set table bounds
        table.getScrollPane ( ).setBounds ( table.getScrollPane ( ).getX ( ), 80, table.getScrollPane ( ).getWidth ( ), table.getScrollPane ( ).getHeight ( ) );
        
        //OPTIONAL describe label
        font.write ( graphics, "uni-code(tm) graphics engine {excel} ..excel document.xls", 80, 30, 22, "metro.ttf" );
    }
}

