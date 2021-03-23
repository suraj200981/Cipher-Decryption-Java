public class vignereCipher {

    /*Author: Suraj Sharma
     * ID: ss2261*/

    public static String mainKey = "TESSOFTHEDURBERVILLES"; //key has a length of 6 letters

    public static void main(String[] args) {


        System.out.println("Encrypted as: "+ encrpytVignere("NEATHITANDSHELIFTEDTHECANDLETO", mainKey).toString());
        System.out.println();
        System.out.println("Decrypted as: "+ decryptVignere("GISLVNMHRGMYFPZABPOXZXGSFRQXAS", mainKey).toString().substring(0,30));

    }


    //I made encryption method to if the decryted value can encrypt properly with the given key
    public static StringBuilder encrpytVignere(String text, String encryptionKey){

        String plainText = text;
        StringBuilder encryptedString = new StringBuilder();
        StringBuilder newEncrpytpedStringLength= new StringBuilder();


        //making the key the same length as String
        int y=0;
        for(int x=0;x<plainText.length();x++) {
            if(y==encryptionKey.length()) {
                y = 0;
            }
            if(plainText.charAt(x)==' ') {
                newEncrpytpedStringLength.append(" ");
            }
            else {
                newEncrpytpedStringLength.append(encryptionKey.charAt(y++));
            }
        }

        //loop through every character in plaintext
        for (int x =0; x< plainText.length(); x++){

            char eachChar = (char) (((plainText.charAt(x) + newEncrpytpedStringLength.charAt(x)) % 26) + 'A');//shift each char int by key char int val and then convert back to alphabet


            encryptedString.append(eachChar); //append each character

        }
        return encryptedString;
        }



        /*Decryption method*/

        public static StringBuilder decryptVignere(String text, String decryptionKey){
            String cipherText = text;
            StringBuilder decryptedString = new StringBuilder();
            StringBuilder newDecryptedStringLength= new StringBuilder();


            //making the key the same length as String
            int y=0;
            for(int x=0;x<cipherText.length();x++) {
                if(y==decryptionKey.length()) {
                    y = 0;
                }
                if(cipherText.charAt(x)==' ') {
                    newDecryptedStringLength.append(" ");
                }
                else {
                    newDecryptedStringLength.append(decryptionKey.charAt(y++));
                }
            }

            for (int x =0; x< cipherText.length(); x++){


                char eachChar = (char) ((((cipherText.charAt(x) - newDecryptedStringLength.charAt(x))+26) % 26) + 'A');//remove shift  of each char int by key char int value and then convert back to alphabet

                //checking the char values
            /*System.out.print(cipherText.charAt(x));
            System.out.print(newDecryptedStringLength.charAt(x));*/


                decryptedString.append(eachChar); //append each character

            }
            return decryptedString;
        }

    }









