Base project for learning automation testing. 

In realization WebSearch was used Java/Maven/Selenium Web Driver/TestNJ/PageObject

In code was used specific flags:
First of all add flags to VM (in Run > Edit configuration): 
-Dtestng.dtd.http=true -Dbrowser=chrome -DsearchRequest=Java

-Dbrowser=chrome   - flag for launching differrent drivers (chrome/firefox)
DsearchRequest=Java  -flag for performing searching with provided text and opening specific link according to the typed request

or provide these flags if you will be run tests from CMD

