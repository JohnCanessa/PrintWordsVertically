import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 */
public class PrintWordsVerically {


    /**
     * Return all the words vertically in the same order in which they appear in s.
     * 
     * Runtime: 1 ms, faster than 87.78% of Java online submissions.
     * Memory Usage: 37.5 MB, less than 72.16% of Java online submissions.
     * 
     * Runtime: O(n * m)
     */
    static List<String> printVertically1(String s) {

        // **** sanity checks ****
        if (s == null || s.length() == 0)
            return null;

        // **** initialization ***
        char ch;

        // **** split words ****
        String[] words = s.split(" ");

        // **** ****
        int L = words.length;

        // **** ****
        int N = 0;
        for (int i = 0; i < L; i++) {
            if (words[i].length() >= N)
                N = words[i].length();
        }

        // **** declare and initialize array of string builders ****
        StringBuilder[] sba = new StringBuilder[N];
        for (int i = 0; i < N; i++)
            sba[i] = new StringBuilder();

        // **** ****
        for (int i = 0; i < N; i++) {

            // **** pick a char from each word ****
            for (int j = 0; j < L; j++) {

                // **** get next character from this word ****
                if (i < words[j].length())
                    ch = words[j].charAt(i);
                else 
                    ch = ' ';

                // **** append character to string builder ****
                sba[i].append(ch);
            }
        }

        // **** populate list ****
        List<String> lst = new ArrayList<String>();
        for (int i = 0; i < sba.length; i++)
            lst.add(sba[i].toString().stripTrailing());

        // **** return list ****
        return lst;
    }


    /**
     * Return all the words vertically in the same order in which they appear in s.
     * 
     * Runtime: 1 ms, faster than 87.78% of Java online submissions.
     * Memory Usage: 37.4 MB, less than 72.16% of Java online submissions.
     * 
     * Runtime: O(n * m)
     */
    static List<String> printVertically(String s) {

        // **** sanity checks ****
        if (s == null || s.length() == 0)
            return null;

        // **** initialization ****
        int wordCount           = 0;
        int maxLength           = 0;
        List<StringBuilder> sbl = null;

        // **** split string into words ****
        String[] words = s.split(" ");

        // **** get the word count ****
        wordCount = words.length;

        // **** set the max length and index ****
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= maxLength)
                maxLength   = words[i].length();
        }

        // **** initialize array list of string builders ****
        sbl = new ArrayList<>(maxLength);
        for (int i = 0; i < maxLength; i++)
            sbl.add(new StringBuilder());

        // **** loop once per word ****
        for (int i = 0; i < wordCount; i++) {

            // **** current word ****
            String w = words[i];

            // **** put each character in a consecutive string builder ****
            for (int j = 0; j < w.length(); j++) {
                StringBuilder sb = sbl.get(j);
                sb.append(w.charAt(j));
            }

            // **** append blanks (as needed) ****
            if (w.length() < maxLength) {
                for (int j = w.length(); j < maxLength; j++) {
                    StringBuilder sb = sbl.get(j);
                    sb.append(' ');
                }
            }

        }

        // **** populate list ****
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < maxLength; i++)
            lst.add(sbl.get(i).toString().stripTrailing());

        // **** return list ****
        return lst;
    }


    /**
     * Test scaffold.
     * 
     * !!! NOT PART OF SOLUTION !!!
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read string ****
        String s = br.readLine().trim();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** generate solution ****
        List<String> lst = printVertically1(s);

        // **** display result ****
        for (String str : lst)
            System.out.println("main <<< str ==>" + str + "<==");
        System.out.println();

        // **** generate solution ****
        lst = printVertically(s);

        // **** display result ****
        for (String str : lst)
            System.out.println("main <<< str ==>" + str + "<==");
    }

}