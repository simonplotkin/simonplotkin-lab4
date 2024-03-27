public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        String decryptedString = "";
        for(int i = 0; i < message.length(); i++){
            char currentChar = message.charAt(i);

            int outeridx = rotors[2].indexOf(currentChar);
            char middleChar = rotors[1].charAt(outeridx);
            
            int firstidx = rotors[2].indexOf(middleChar);
            char addChar = rotors[0].charAt(firstidx);

            decryptedString = decryptedString + addChar;

            rotate();
            
        }

        return decryptedString;
    }


    
    public String encrypt(String message){
        String encryptedString = "";

        for(int i = 0; i < message.length(); i++){
            char currentChar = message.charAt(i);

            int firstidx = rotors[0].indexOf(currentChar);
            char outerchar = rotors[2].charAt(firstidx);
            
            int middleidx = rotors[1].indexOf(outerchar);
            char addChar = rotors[2].charAt(middleidx);

            encryptedString = encryptedString + addChar;

            rotate();
        }
        return encryptedString;

    }
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
