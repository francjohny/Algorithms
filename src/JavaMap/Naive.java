package JavaMap;

import java.util.HashMap;
import java.util.Scanner;

class Naive{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        HashMap<String, Integer> phonebook = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            Integer phone=in.nextInt();
            phonebook.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            System.out.println(phonebook.get(s) == null ? "Not found" : s + "=" + phonebook.get(s));
        }
    }
}

