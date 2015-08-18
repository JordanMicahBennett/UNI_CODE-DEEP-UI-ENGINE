//Author: Jordan Micah Bennett
public class DisplayConsole
{
    
    public static void main ( String [ ] args ) 
    {
         /////////////////////////////////////////
         //Load sql queries from file
         /////////////////////////////////////////
         String __query0 = new data.packages.UNICODE.UNICODE_ConveniencePack ( ).getFileContent ( "data/text/__query0.txt" );
         String __query1 = new data.packages.UNICODE.UNICODE_ConveniencePack ( ).getFileContent ( "data/text/__query1.txt" );
         String __query2 = new data.packages.UNICODE.UNICODE_ConveniencePack ( ).getFileContent ( "data/text/__query2.txt" );
         String __query3 = new data.packages.UNICODE.UNICODE_ConveniencePack ( ).getFileContent ( "data/text/__query3.txt" );
       
         
         
         /////////////////////////////////////////
         //Load sql results through hibernate orm
         /////////////////////////////////////////
         SQLComposer _SQLComposer = new SQLComposer ( );
       
         _SQLComposer.getSqlResultFromSelection ( "1. What was the most popular song for the month of January?", __query0, 0 );
         _SQLComposer.getSqlResultFromSelection ( "2. How many spins does Gertrude McKenzie have remaining on her account?", __query1, 0 );
         _SQLComposer.getSqlResultFromSelection ( "3. Who is the most featured artist?", __query2, 0 );
         _SQLComposer.getSqlResultFromSelection ( "4. Which artist has the most songs from the playlist (either as main or featured)?", __query3, 0 );
         _SQLComposer.insertItem ( "5. Robert Mathis shared his playlist with Gertrude.", "Sharedplaylists", new Object [ ] { "20150101", 0, 2, 1, 1 } );
         new SQLComposerDebugger ( _SQLComposer ).showAccessorMethodsAtInsert ( "Sharedplaylists" );
    }
}