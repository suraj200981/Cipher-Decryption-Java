    /*Author: Suraj Sharma
    * ID: ss2261*/

    public class caesarCipher {

    /*only 25 possible keys, i can change this to brute force attack until i see a message that makes sense in tess*/
    public static int mainKey = 4;


    public static void main(String[] args) {

        System.out.println("Encrpted as :" +encryptCaesar("LLINFORMEDANDVERSATILEWHICHWASCERTAINLYTRUEHERNATURALQUICKNESSANDHERADMIRATIONFORHIMHAVINGLEDHERTOPICKUPHISVOCABULARYHISACCENTANDFRAGMENTSOFHISKNOWLEDGETOASURPRISINGEXTENTAFTERTHESETENDERCONTESTSANDHERVICTORYSHEWOULDGOAWAYBYHERSELFUNDERTHEREMOTESTCOWIFATMILKINGTIMEORINTOTHESEDGEORINTOHERROOMIFATALEISUREINTERVALANDMOURNSILENTLYNOTAMINUTEAFTERANAPPARENTLYPHLEGMATICNEGATIVETHESTRUGGLEWASSOFEARFULHEROWNHEARTWASSOSTRONGLYONTHESIDEOFHISTWOARDENTHEARTSAGAINSTONEPOORLITTLECONSCIENCETHATSHETRIEDTOFORTIFYHERRESOLUTIONBYEVERYMEANSINHERPOWERSHEHADCOMETOTALBOTHAYSWITHAMADEUPMINDONNOACCOUNTCOULDSHEAGREETOASTEPWHICHMIGHTAFTERWARDSCAUSEBITTERRUEINGTOHERHUSBANDFORHISBLINDNESSINWEDDINGHERANDSHEHELDTHATWHATHERCONSCIENCEHADDECIDEDFORHERWHENHERMINDWASUNBIASSEDOUGHTNOTTOBEOVERRULEDNOWWHYDONTSOMEBODYTELLHIMALLABOUTMESHESAIDITWASONLYFORTYMILESOFFWHYHAS",mainKey));
        System.out.println();
        System.out.println("Decrypted as : " +decryptCaesar("PPMRJSVQIHERHZIVWEXMPIALMGLAEWGIVXEMRPCXVYILIVREXYVEPUYMGORIWWERHLIVEHQMVEXMSRJSVLMQLEZMRKPIHLIVXSTMGOYTLMWZSGEFYPEVCLMWEGGIRXERHJVEKQIRXWSJLMWORSAPIHKIXSEWYVTVMWMRKIBXIRXEJXIVXLIWIXIRHIVGSRXIWXWERHLIVZMGXSVCWLIASYPHKSEAECFCLIVWIPJYRHIVXLIVIQSXIWXGSAMJEXQMPOMRKXMQISVMRXSXLIWIHKISVMRXSLIVVSSQMJEXEPIMWYVIMRXIVZEPERHQSYVRWMPIRXPCRSXEQMRYXIEJXIVERETTEVIRXPCTLPIKQEXMGRIKEXMZIXLIWXVYKKPIAEWWSJIEVJYPLIVSARLIEVXAEWWSWXVSRKPCSRXLIWMHISJLMWXASEVHIRXLIEVXWEKEMRWXSRITSSVPMXXPIGSRWGMIRGIXLEXWLIXVMIHXSJSVXMJCLIVVIWSPYXMSRFCIZIVCQIERWMRLIVTSAIVWLILEHGSQIXSXEPFSXLECWAMXLEQEHIYTQMRHSRRSEGGSYRXGSYPHWLIEKVIIXSEWXITALMGLQMKLXEJXIVAEVHWGEYWIFMXXIVVYIMRKXSLIVLYWFERHJSVLMWFPMRHRIWWMRAIHHMRKLIVERHWLILIPHXLEXALEXLIVGSRWGMIRGILEHHIGMHIHJSVLIVALIRLIVQMRHAEWYRFMEWWIHSYKLXRSXXSFISZIVVYPIHRSAALCHSRXWSQIFSHCXIPPLMQEPPEFSYXQIWLIWEMHMXAEWSRPCJSVXCQMPIWSJJALCLEW",mainKey).substring(0,30));

        System.out.println();
        System.out.println("Below I have brute forced the possible key shifts until I spot english text from tess:");
        for(int x=0; x<26;x++){
            int key= x;

            System.out.println("Decrypted as : " +decryptCaesar("PPMRJSVQIHERHZIVWEXMPIALMGLAEWGIVXEMRPCXVYILIVREXYVEPUYMGORIWWERHLIVEHQMVEXMSRJSVLMQLEZMRKPIHLIVXSTMGOYTLMWZSGEFYPEVCLMWEGGIRXERHJVEKQIRXWSJLMWORSAPIHKIXSEWYVTVMWMRKIBXIRXEJXIVXLIWIXIRHIVGSRXIWXWERHLIVZMGXSVCWLIASYPHKSEAECFCLIVWIPJYRHIVXLIVIQSXIWXGSAMJEXQMPOMRKXMQISVMRXSXLIWIHKISVMRXSLIVVSSQMJEXEPIMWYVIMRXIVZEPERHQSYVRWMPIRXPCRSXEQMRYXIEJXIVERETTEVIRXPCTLPIKQEXMGRIKEXMZIXLIWXVYKKPIAEWWSJIEVJYPLIVSARLIEVXAEWWSWXVSRKPCSRXLIWMHISJLMWXASEVHIRXLIEVXWEKEMRWXSRITSSVPMXXPIGSRWGMIRGIXLEXWLIXVMIHXSJSVXMJCLIVVIWSPYXMSRFCIZIVCQIERWMRLIVTSAIVWLILEHGSQIXSXEPFSXLECWAMXLEQEHIYTQMRHSRRSEGGSYRXGSYPHWLIEKVIIXSEWXITALMGLQMKLXEJXIVAEVHWGEYWIFMXXIVVYIMRKXSLIVLYWFERHJSVLMWFPMRHRIWWMRAIHHMRKLIVERHWLILIPHXLEXALEXLIVGSRWGMIRGILEHHIGMHIHJSVLIVALIRLIVQMRHAEWYRFMEWWIHSYKLXRSXXSFISZIVVYPIHRSAALCHSRXWSQIFSHCXIPPLMQEPPEFSYXQIWLIWEMHMXAEWSRPCJSVXCQMPIWSJJALCLEW",key).substring(0,30));
            System.out.println();
            System.out.println();
            key=key+1;
            System.out.println("With key of: "+ key);
        }
    }

    //method has to retunn stringbulider inordeer to append each newly shifted character
   public static StringBuilder encryptCaesar(String text, int encryptKey){

        //stores the string in lowercase
        String plainText = text.toLowerCase();

       StringBuilder encryptedString = new StringBuilder();
       String modernAlphabet ="abcdefghijklmnopqrstuvwxyz";

       //loop through every character in plaintext
       for (int x =0; x< plainText.length(); x++){

          char eachChar;

           eachChar = (char) (plainText.charAt(x)+encryptKey); //shift the char by the key amound and this will be the new shifted value

           if (eachChar > 'z'){ // if surpasses z in alphabet in mod will wrap it round
               eachChar = (char) (plainText.charAt(x) - (26 - encryptKey%26));

           }
           encryptedString.append(Character.toUpperCase(eachChar)); //append each character
       }

       System.out.println();

       return encryptedString; // returns the encrypted string
       }


    public static StringBuilder decryptCaesar(String text, int decryptKey){


        return encryptCaesar(text, 26 -(decryptKey%26)); //apply the encryption method but jus subtract the key to get orignal value
    }
}
