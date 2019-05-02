# Bean 2 xlsx / Excel (Java Beans to Excel files Exporter / Converter)

Converts Java Beans to Excel files (xlxs) via Apache POI including cellformats


I got a little bit annoyed by the Primefaces datatable exporter (p:dataexporter), because it's just formating
every cell in String (which can cause problems with functions in Excel) and doesn't support files with more than 65,536 rows - So I decided to write my own exporter.

I use Apache POI - the Java API for Microsoft Documents (http://poi.apache.org/)

**Fileformat:**
The default Excel 2007 and later workbook format. 
In reality a ZIP compressed archive with a directory structure of XML text documents. Functions as the primary replacement for the former binary .xls format, although it does not support Excel macros for security reasons.


Feel free to contribute

## Features

 - Formats every cell with cell dataformat like money, decimal etc
 - CellTypes
 - "New" Excel Format
 - Simple setup via BeanColumn - class:
 
 BeanColumn[] columns = new BeanColumn[] {
				new BeanColumn("name", "Carmodel", FormatType.TEXT),
				new BeanColumn("power", "Power", FormatType.INTEGER),
				new BeanColumn("priceinEuro", "Price in Euro", FormatType.MONEY) };
                
This simple setup transforms the attribute name to Text in Excel, priceinEuro to MONEY ("#,##0.00\\ €" = Euro) and so on.
            
    

## TODO
Implement more cell formats like percent, Date, text with wrap (+width) etc. 

Sincerely, your WurstCommander :)
