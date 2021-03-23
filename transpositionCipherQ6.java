import java.util.*;


/*Author: Suraj Sharma
 * ID: ss2261*/

public class transpositionCipherQ6 {


    private static Collections Collectons;

    public static void main(String[] args) {




            decryptTrans("MLNRUETDIYFEYLETNAOOLOLELKDMTSEEIOKDAETNEYEVYLNGDSTULOUOATWURNASIHUYRDIONKAIOONAERTTEYATMAEMHNAEDENEEERAEGHWONMTAIEEPOORSCAEDTDOIMCTLEEOENSSLIDOSDLNTSURMUENLAIINBASRTOHHOEEAOLYATNLTCSORNAITOOTPNEDTGLTSEINOETDEOEPYTFMOOEIERNETYWCMTDEHEMEMHOLBEMCDERMUNHELKFIAIAENBHHUNVHTSIRAHPADWTECOERWEOTABAIIIDLLDMGWDGCUIIRATOEILMUHCLMODISDALMETPYOLWENAVYOVITROCNEAGEUIONGLHHOHEAMUDMCMARTTCENTLNLNRNEROUDFRIHDTSADYDHESRNGANETOEGTISNYAAOUIAOWNOTEDVFLMIISCSIEEHLNTTROUVFDAREHIIFANEALOIAOIORYOCTDEOUAMAWTOLANLSANUEFYIERORREMEEOEVOTELTEHDGIHETVEFTGIIAEHHHPFMUINFREANFFICDEHDTHATDUEDYMLLEOFOONOSOTEYMOLNOEYHOYNEVRCNEEROTUAADEADGHYHYRONLNYOIASTYYFALBYGMFDOSLRNGVAUHHTOROENMWRSRRTWORVRENRAIOADMESSRHLRNIAETTAITRREUOTRHORDHDCIUIBCTHOHGEWNEENANIINOFHWUETYRHUYORAEEEHMEYDYTLUWOOEIBELIHYRFOUSIONUTSOHYINNTNNTDEOONOEOSFAAEDIAUOEIOESRDBLDEDYEAFDENYGSIEREEEHTTRNARDIAHH",6);

    }

    public static void decryptTrans(String cipher,int columns){

        Integer[] intArray = { 0, 1, 2, 3, 4, 5,  };

        ArrayList<String> bins = new ArrayList<>();
        StringBuilder decryptedMessage = new StringBuilder();

        int rows = cipher.length()/columns;
        System.out.println();
        System.out.println("Breaking the cipher down into rows and columns:");
        System.out.println();
        System.out.println("Number of rows: "+rows);

        String result;
        for(int i=0; i <rows; i++) {
            result="";
            for (int x =i; x < cipher.length(); x = x + rows) {
                result +=cipher.charAt(x);
            }
            bins.add(i,result);
        }

        /*for(int x=0; x<rows; x++) {

            System.out.println((x+1)+"   "+bins.get(x));
        }*/

        for(int x=0; x<rows; x++) {

            System.out.println((x+1)+"   "+bins.get(x));
        }


        System.out.println();
        System.out.println();

        for(int x=0; x<rows; x++) {

            decryptedMessage.append(bins.get(x));

        }

        System.out.println("This reads as : "+ decryptedMessage.substring(0,41));
        System.out.println("With collumns defined as: "+ columns);

        System.out.println(bins);

        System.out.println();
        System.out.println();
        System.out.println();

        //seems to consistently decipher within 1000 iterations but there are 720 possible combination of the letters
        //I have used 1000 interations so that i can comfortably find the exact columns without encountering too manny duplicate combinations
        for(int x=0; x<1000;x++) {
            bruteForce(bins, rows);
        }

    }
    public static void bruteForce(ArrayList<String> bins, int numRows){

        //random column generation
        Integer[] intArray = {0,1,2,3,4,5};
        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);

        List<String> newBins;
        newBins = bins;//orginal list

        StringBuilder decrypedVal = new StringBuilder();

        //swapping characters randomly
        for(int x=0; x<newBins.size(); x++){

            StringBuilder result = new StringBuilder();

            String str =  newBins.get(x);

            result.append(str.charAt(intArray[0]));
            result.append(str.charAt(intArray[1]));
            result.append(str.charAt(intArray[2]));
            result.append(str.charAt(intArray[3]));
            result.append(str.charAt(intArray[4]));
            result.append(str.charAt(intArray[5]));

            str = result.toString();
            newBins.set(x,str);
            decrypedVal.append(newBins.get(x));

        }

        System.out.println();
        System.out.println();
        System.out.println("Decrypted as: "+ decrypedVal.substring(0,30));
        System.out.println("With column order: "+ intArray[0].toString()+", "+intArray[1].toString()+", "+intArray[2].toString()+", "+intArray[3].toString()+", "+intArray[4].toString()+", "+intArray[5].toString());

    }
}
