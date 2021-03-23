import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

/*Author: Suraj Sharma
 * ID: ss2261*/

public class vignereCipherQ3 {


     public static int[] total = new int[256];


    //key has a length of 6 letters
    public static void main(String[] args) {


        findFrequencies("TOEEMYHCPRKJNUXZVQQCRUIHTRIIMXNPKKHTTVLVRIUGRUEEYUSDHDJAMEDUJRMEZKUQPUKKNPWRGTKKRUBDLVLVUESGWFMXNPKJTDIUYTABNMIRGTQKZZGWWGQRBDXOYJMRJOSIXYSVIIXIYKRXMEJOWKBBQKJKAUDQRCRASQAVWEKOINHKQFXYTJXQQVUEIAAFNBIISIHKSFEEWJJNPVFMMCXKAUWGMJEYAKRXTCTPKVFQSFXYXOYJMEDYSIRFMXNPKFYXNOMWIQXQRKKYSILRFMMQHZLSTXIIXTRGLRWBNXIUAUIJEUHDJKXZFIZTIKXIXRSJMFTPIUAUWCVXNCJPXJHDYJMJAYLJTIHZJEXKBBQULVAQIIVRIFQGHNBJMRVVLINPKDTJYGVJBDMCRUPXNELJXURGHCBJYNIZFFWQZVWRDJIIKURKXKTDHGWNAUSKRUHEWPITXIXKXZXIMCHSXUSGEJXTXJIKNHSGHYXHFVXVGJNQRKHUCVIIGQQVLZGWXKXNTISQAKAUXGEJHDKQVGEQSVMEZQSFWFPYSIQRGOLCVUXDXCRUTBQQXDXDYUSWMXJXMCEQLGVJAQICPIXQIAVVVUNXIUMXJKVJIHNPKKBBQCKVUKYVLVZQWFIETDIVLVTBQQXDXDYQJKAUIWVSXOKKICWIBGVVUUMKRUAQSFWYXVTWRUMEMGVUBIRCCKAQYVLZLMFUSNBDLVSKAUNTLROYSIIRMUSCPCMXJUIVWFTVEKHUXVLRMBFUXCTFXGSWMXJKQGKEAKHVGJFVXYXUFTPZXIYOSDXDYULVHRYCMEXTBJEKHJMGVJLXJESLETUTSTNH", 6);

        System.out.println("Decrpyted as: "+vignereCipher.decryptVignere("TOEEMYHCPRKJNUXZVQQCRUIHTRIIMXNPKKHTTVLVRIUGRUEEYUSDHDJAMEDUJRMEZKUQPUKKNPWRGTKKRUBDLVLVUESGWFMXNPKJTDIUYTABNMIRGTQKZZGWWGQRBDXOYJMRJOSIXYSVIIXIYKRXMEJOWKBBQKJKAUDQRCRASQAVWEKOINHKQFXYTJXQQVUEIAAFNBIISIHKSFEEWJJNPVFMMCXKAUWGMJEYAKRXTCTPKVFQSFXYXOYJMEDYSIRFMXNPKFYXNOMWIQXQRKKYSILRFMMQHZLSTXIIXTRGLRWBNXIUAUIJEUHDJKXZFIZTIKXIXRSJMFTPIUAUWCVXNCJPXJHDYJMJAYLJTIHZJEXKBBQULVAQIIVRIFQGHNBJMRVVLINPKDTJYGVJBDMCRUPXNELJXURGHCBJYNIZFFWQZVWRDJIIKURKXKTDHGWNAUSKRUHEWPITXIXKXZXIMCHSXUSGEJXTXJIKNHSGHYXHFVXVGJNQRKHUCVIIGQQVLZGWXKXNTISQAKAUXGEJHDKQVGEQSVMEZQSFWFPYSIQRGOLCVUXDXCRUTBQQXDXDYUSWMXJXMCEQLGVJAQICPIXQIAVVVUNXIUMXJKVJIHNPKKBBQCKVUKYVLVZQWFIETDIVLVTBQQXDXDYQJKAUIWVSXOKKICWIBGVVUUMKRUAQSFWYXVTWRUMEMGVUBIRCCKAQYVLZLMFUSNBDLVSKAUNTLROYSIIRMUSCPCMXJUIVWFTVEKHUXVLRMBFUXCTFXGSWMXJKQGKEAKHVGJFVXYXUFTPZXIYOSDXDYULVHRYCMEXTBJEKHJMGVJLXJESLETUTSTNH", "FCERTQ").substring(0,30));

    }

//The modern english alphabet has a standard frequency distribution of their letters. this is useful becuase
    //it tells me a probabilty of each character appearing
    public static StringBuilder findFrequencies(String text, int decryptionKeylength){
        String cipherText = text;
        StringBuilder decryptedString = new StringBuilder();
        String result = "";
        int encryptedTextSize = cipherText.length();
        ArrayList<String> bins = new ArrayList<>();

        System.out.println();
        System.out.println("split into bins:");
        System.out.println();

      //I am spliting the  letters into "bins"
         for(int i=0; i <decryptionKeylength; i++) {
             result="";
             for (int x =i; x < cipherText.length(); x = x + decryptionKeylength) {
                 result +=cipherText.charAt(x);
             }
             bins.add(i,result);


         }
        for (int x = 0; x < decryptionKeylength; x++) {
        System.out.println(bins.get(x));
            System.out.println();
    }
        //total occurrences of each letters
        System.out.println();
        System.out.println();
        for(int x=0; x<decryptionKeylength; x++) {
            System.out.println();
            getTotalOccurences(bins.get(x));
            System.out.println();
            int max = Arrays.stream(total).max().getAsInt();
            System.out.println("biggest : " + max);
            System.out.println();
            System.out.println();
        }


        return null;

        }



    public static void getTotalOccurences(String input){
        int len=input.length();
        int count;
        for(char ch='A';ch<='Z'; ch++){
            count=0;
            for(int i=0; i<len; i++){
                if(ch==input.charAt(i)){
                    count++;
                    total[i] = count;
                }
            }
            if(count>=0){
                System.out.print(ch+": "+ count+" ");
            }
        }
    }


    }


