import java.util.Random;

public class ElGamal {

    Random random = new Random();

    public int modulo = 26;

    public int randomRange = 5;

    public int pK = random.nextInt(randomRange+1);







    public static void main(String[] args) {new ElGamal("XDDDDD");}



    public ElGamal(String wiadomoscString){

        System.out.println("MODULOOOOO: " +modulo);

        System.out.println("Klucz publiczny: "+ pK);


        while(pK == 0){
            pK = random.nextInt(randomRange+1);
        }



        //ALICE

        int privateKeyAlice = random.nextInt(randomRange+1);
        System.out.println("Alice key: "+privateKeyAlice);
        int valuesForBob = (int) Math.pow(pK, privateKeyAlice) % modulo; // liczba dla boba
        System.out.println(valuesForBob);
        System.out.println();

        //BOB
        int privateKeyBob = random.nextInt(randomRange+1);
        System.out.println("Bob key: " + privateKeyBob);
        int valuesForAlice = (int) Math.pow(pK, privateKeyBob) % modulo; // liczba dla Alice
        System.out.println(valuesForAlice);
        System.out.println();

        //Alice szyfruje  -  zakładamy że po prostu do danego stringa dodamy wartość szyfrowana i pozniej przy odszyfrowywaniu zredukujemy

        System.out.print("Wiadomość do zaszyfrowania: " + wiadomoscString);
        System.out.println();

        long encryptedMessage = (long) Math.pow(valuesForAlice, privateKeyAlice) % modulo;
        System.out.println("szyfr kod: " +encryptedMessage);

        //char[] charArray = wiadomoscString.toCharArray();
        //int randomNumberForEncrypted = random.nextInt(charArray.length);  //losowanie liczby w zaleznosci od dlugosci stringa
        //char randomNumberForEncryptedToChar = charArray[randomNumberForEncrypted];
        //byte charToByte = (byte) randomNumberForEncryptedToChar;  // to jest nasz X  :)  do zakodowania i odkodowania

        long encryptedMessageKeyForBob = (encryptedMessage * wiadomoscString.length()) % modulo;  // kodowanie
        System.out.println("Zaszyfrowany kod: "+encryptedMessageKeyForBob);



        //Bob odszyfrowywuje

        long decryptedMessage = (long) Math.pow(valuesForBob, privateKeyBob) % modulo;

        //liczenie Odwrotnej liczby do decryptedMessage  :)

        System.out.println(decryptedMessage);

        long reverseNumber = (long) Math.pow(decryptedMessage, EulerMethod(modulo)-1) % modulo;
        System.out.println(reverseNumber);
        long decryptedMessageF = (reverseNumber * encryptedMessageKeyForBob) % modulo;

        System.out.println(decryptedMessageF);





        //char znak = 'A';
        //byte hehe = (byte) znak;   // to jest do zakodowania
        //char xd = (char) hehe;    // to jest juz znak odkodowany


    }

    public static int gcd(int a,int b){
        int i, hcf = 0;
        for(i = 1; i <= a || i <= b; i++) {
            if( a%i == 0 && b%i == 0 )
                hcf = i;
        }
        return hcf;
    }

    public int EulerMethod(int n){

        int eulerScore = 0;

        for (int i = 1; i <= n; i++){
            int x = 1;
            for (int j = 2; j < i; j++){
                if (gcd(j, n) == 1){
                    x++;
                }
            }
            eulerScore = x;
        }
            return eulerScore;
    }



    public int podniesc(int a, int b){

        int score = 1;


        for (int i = 1; i <= b; i++) {
            score *= a;
        }

        return score;

    }

}
