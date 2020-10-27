# Base project for learning automation testing.

In realization WebSearch was used Java/Maven/Selenium Web Driver/TestNG/PageObject

## Installation

In code was used specific flags:
###### First of all add flags to VM (in Run > Edit configuration): 

```java
-Dtestng.dtd.http=true -Dbrowser=chrome -DsearchRequest=Java
```
## Flags

```bash
-Dtestng.dtd.http=true - disables loading DTD from unsecure Urls (bug: https://github.com/cbeust/testng/issues/2022)
-Dbrowser=chrome       - launching differrent drivers (chrome/firefox)
-DsearchRequest=Java   - performing searching with provided text 
```
##### or provide these flags if you will be run tests from CMD
