package opdrachten;

public class Opdracht4TextBlocks {
   //Run me
    public static void main(String[] args) {
        // FIXME maak hier gebruik van TextBlocks
        String html = "<html>\n"
                + "  <head>\n"
                + "    <title>Voorbeeld</title>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <h1>Deze tekst gaat ook over \" en \\ of te wel quotes en backslashes</h1>\n"
                + "    <p>\n"
                + "      Zodra je in java in een lange string een \" wil plaatsen ben je verplicht om daar "
                + "een \\ voor te zetten.</br>\n Om een line break te forceren moet je \\n typen en als je dan "
                + "zoals dit een mooie layout voor je html wilt moet je goed op de spaties letten. Neem deze regel die staat "
                + "namelijk niet netjes.\n"
                + "    </p>\n"
                + "    <p>\n"
                + "      Maar vanaf java 15 hebben we TextBlocks. Door dan \"\"\" aan het begin en aan het eind te typen kan"
                + " je alle \" aan het begin en eind van de regel net als de '\\n' en de + weglaten. "
                + "Het is dus ook niet meer nodig om een \" te \"escapen\" in een tekst.</br>\n"
                + "      En als je een enter in je tekst wil dan begin je gewoon op een nieuwe regel.\n"
                + "      Ook de indentation werkt goed. De formatting indents worden namelijk overgeslagen.</br>\n"
                + "      En als je een hele lange regel hebt en je wilt niet over de max van bijvoorbeeld 132 characters per regel"
                + " dan is het mogelijk om aan het eind van de regel een enkele \\ te zetten. Hiermee kan je in je textblock naar "
                + "een nieuwe regel maar deze line break komt dan niet in de uiteindelijke tekst terecht.  Let dan wel op dat je "
                + "de extra indentation die je IDE toevoegd om op hetzelfde niveau als de vorige regel te beginnen weghaald."
                + "      Anders heb je extra spaties in je tekst staan die je niet wilt. Regels die je afbreekt moet je in dit \n"
                + "voorbeeld laten beginnen op positie 17 net als de html-openings-tag."
                + "        Probeer het eens uit met deze tekst.\n"
                + "    </p>\n"
                + "  </body>\n"
                + "</html>";
        System.out.println(html);
    }
}
