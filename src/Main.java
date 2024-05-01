import java.sql.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    static boolean isanqgram(String a, String b){
        int jml = b.length()-1;
        boolean hasil = false;
        String kataA = a.toLowerCase();
        String kataB = b.toLowerCase();
        char[] arrA = kataA.toCharArray();
        char[] arrB = kataB.toCharArray();
        int tampungA = 0;
        int tampungB = 0;
        char tampung = 0;

        if(a.equalsIgnoreCase(b)){
            return true;
        } else if(a.length()!=b.length()){
            return false;
        }

        for(int i=0;i<a.length()-1;i++){
            for(int j=0;j<jml-i;j++){
                if(arrA[j]>arrA[j+1]){
                    tampung=arrA[j];
                    arrA[j]=arrA[j+1];
                    arrA[j+1]=tampung;
                }
                if(arrB[j]>arrB[j+1]){
                    tampung=arrB[j];
                    arrB[j]=arrB[j+1];
                    arrB[j+1]=tampung;
                }
            }
        }

        for(int i=0;i<arrB.length;i++){
            if (arrA[i]==arrB[i]){
                tampungA = tampungA+arrA[i];
                tampungB = tampungB+arrB[i];
            }else return false;
        }
        if(tampungA==tampungB){
            return true;
        }
        return hasil;
    }
    static void sorting(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input one line of words (S): ");
        String input = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

        ArrayList<String> vowels = new ArrayList<>();
        ArrayList<String> consonants = new ArrayList<>();
        String tampung = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels.add(String.valueOf(ch));
            } else if (ch >= 'a' && ch <= 'z') {
                consonants.add(String.valueOf(ch));
            }
        }

        for (int i=0;i<vowels.size();i++){
            for (int j=i;j< vowels.size();j++){
                if (vowels.get(i).equals(vowels.get(j))){
                    for (int k=j;k>i;k--){
                        vowels.set(k, vowels.get(k-1));
                    }
                }
            }
        }

        for (int i=0;i<consonants.size();i++){
            for (int j=i;j< consonants.size();j++){
                if (consonants.get(i).equals(consonants.get(j))){
                    for (int k=j;k>i;k--){
                        consonants.set(k, consonants.get(k-1));
                    }
                }
            }
        }

        System.out.println("Vowel Characters: " + vowels);
        System.out.println("Consonant Characters: " + consonants);
    }
    static void looping(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan angka pertama : ");
        int angkapertama = scanner.nextInt();
        scanner.nextLine();
        System.out.print("masukkan angka kedua : ");
        String angkakedua = scanner.nextLine();
        String[] angkas = angkakedua.split(" ");
        int tot = 0;
        int jml = 0;

        if (angkapertama!=angkas.length){
            System.out.println("gagal");
        }else {
            for (int i=0;i<angkas.length;i++){
                int index = Integer.parseInt(angkas[i]);
                tot = tot+ index;
            }

            while (tot >= 4) {
                jml++;
                tot = tot - 4;
            }

            if (tot > 0) {
                jml++;
                tot = 0;
            }

            System.out.println(jml);
        }
    }
    static void query(){
        String url = "jdbc:mysql://127.0.0.1:3306/flutter";
        String user = "root";
        String pass = "1m2h3b4y5W&";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            String quer = "SELECT * FROM pengguna";
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(quer);
            while (set.next()){
                int id = set.getInt("id");
                String menu = set.getString("email");
                String stok = set.getString("pass");
                System.out.println(id+menu+stok);
            }
            set.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    static void dika1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        int input = scanner.nextInt();
        System.out.println("Output :");
        for(int i=1;i<=input;i++){
            for (int j=1;j<=i*2;j++){
                if (j%2!=0){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
    }
}