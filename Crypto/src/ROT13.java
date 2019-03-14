
public class ROT13  {

    private static String alphabets = "abcdefghijklmnopqrstuvwxyz";
    private static String crptedAlphabets;
    ROT13(Character cs, Character cf) {
        cs = Character.toLowerCase(cs);
        cf = Character.toLowerCase(cf);
        crptedAlphabets = rotate(alphabets, (char)('a' + (cf - cs)));
    }

    ROT13() {
        this('a', 'n');
    }


    public String crypt(String text) {

        StringBuilder builder = new StringBuilder();
        char inputText[] = text.toCharArray();
        for(int i = 0; i < inputText.length; i++ ) {
            char charater = inputText[i];
            builder.append(getEncryptedChar(charater));
        }
        return builder.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int splitIdx = s.indexOf(c);
        return s.substring(splitIdx) + s.substring(0, splitIdx);
    }

    private char getEncryptedChar(char charater){
        char encryptedChar = charater;
        if(Character.isLetter(charater)) {
            boolean isUpper = Character.isUpperCase(charater);
            int cryptIndex = alphabets.indexOf(Character.toLowerCase(charater));
            char cryptedChar = crptedAlphabets.charAt(cryptIndex);
            encryptedChar = (isUpper ? Character.toUpperCase(cryptedChar) : cryptedChar);
        }
        return encryptedChar;
    }

}
