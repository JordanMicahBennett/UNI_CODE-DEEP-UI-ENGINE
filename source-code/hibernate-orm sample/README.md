WAVES
=======

A database-hibernate-orm aligned, viable radio-station mechanism.




SEQUENCE
==============
[DisplayConsole ( ).void ( )](https://github.com/JordanMicahBennett/UNI_CODE-DEEP-UI-ENGINE/blob/master/source-code/hibernate-orm sample/source-code/DisplayConsole.java) -> SELECT ( See SELECTING ) 


or


[DisplayConsole ( ).void ( )](https://github.com/JordanMicahBennett/UNI_CODE-DEEP-UI-ENGINE/blob/master/source-code/hibernate-orm sample/source-code/DisplayConsole.java) -> INSERT ( See INSERTING )



SELECTING
==============
[SQLComposer](https://github.com/JordanMicahBennett/UNI_CODE-DEEP-UI-ENGINE/blob/master/source-code/hibernate-orm sample/source-code/SQLComposer.java).getSqlResultFromSelection ( String message, String queryString, int columnIndex )




INSERTING
==============
[SQLComposer](https://github.com/JordanMicahBennett/UNI_CODE-DEEP-UI-ENGINE/blob/master/source-code/hibernate-orm sample/source-code/SQLComposer.java).insertItem ( String message, String classNameString, Object [ ] insertionParameters ), where message is optional, see OPTIONAL.


[SQLComposer](https://github.com/JordanMicahBennett/UNI_CODE-DEEP-UI-ENGINE/blob/master/source-code/hibernate-orm sample/source-code/SQLComposer.java).insertItem (...) allows for dynamism; allows for insertion based wrt any annotated class, 3 parameter long signature, of message(optional, see OPTIONAL), classNameString, and input parameters.

NOTE: 'Inserting' requires the creation of [map relation url](https://github.com/JordanMicahBennett/UNI_CODE-DEEP-UI-ENGINE/blob/master/source-code/hibernate-orm sample/hibernate.cfg.xml) and [annotated class](https://github.com/JordanMicahBennett/UNI_CODE-DEEP-UI-ENGINE/blob/master/source-code/hibernate-orm sample/Sharedplaylists.java) (if these components aren't already existent)




OPTIONAL
==============
Message is simply a user-interface display string, indicating details regarding the sql-hibernate command executed.

To ommit, pass empty string.





AUTHOR PORTFOLIO
============================================
http://folioverse.appspot.com/
