import java.util.Scanner;

/**
 * CS180 - Bookwork - DnaSequence
 *
 * DnaSequence looks for a specified subsequence of DNA in a specified sequence of DNA
 * Prints out the number of times the subsequence was found in the DNA sequence
 *
 * @author Andrew Peterson, peter343@purdue.edu
 * @version 9.11.2015
 *
 */
    public class DnaSequence {

    private String dnaSeq;
    private String dnaSub;
    boolean valid;
    char c;

    public DnaSequence(String sequence, String subsequence){

        dnaSeq = sequence.toUpperCase();
        dnaSub = subsequence.toUpperCase();
    }

    public void findSubsequence() {

        do {

            dnaSeq.toUpperCase();
            valid = true;
            for (int i = 0; i < dnaSeq.length() && valid; i++) {
                c = dnaSeq.charAt(i);
                if (c != 'A' && c != 'C' && c != 'G' && c != 'T')
                    valid = false;
            }

        } while (!valid);

        do {
            dnaSub.toUpperCase();
            valid = true;
            for (int i = 0; i < dnaSub.length() && valid; i++) {
                c = dnaSub.charAt(i);
                if (c != 'A' && c != 'C' && c != 'G' && c != 'T')
                    valid = false;
            }

        } while (!valid);

        int found = 0;
        for (int i = 0; i < dnaSeq.length() - dnaSub.length() + 1; i++) {
            for (int j = 0; j < dnaSub.length(); j++) {
                if (dnaSub.charAt(j) != dnaSeq.charAt(i + j))
                    break;
                if (j == dnaSeq.length() - 1) { // matches
                    System.out.println(" Match found at index " + i);
                    found++;

                }
            }
        }
        if( found == 1 )
            System.out.println (" One match found.");
        else
            System.out.println ( found + " matches found.");
    }





    public static void main(String[] args){
        Scanner dnaIn = new Scanner(System.in);
        System.out.println("Enter a DNA sequence: ");
        String input = dnaIn.nextLine();
        System.out.println("Enter a subsequence you would like to search for: ");
        String find = dnaIn.nextLine();
        DnaSequence dna = new DnaSequence(input, find);
        dna.findSubsequence();

    }

}
