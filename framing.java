package applicationapp;

import java.util.Scanner;
public class framing
{   
    public static String bitStuffing(String data)
    {
        int repeat=0;
        String result="";
        for(int i=0;i<data.length();i++)
        {
            result+=data.charAt(i);
            if(data.charAt(i)=='1')
            {
                repeat++;     
            }
            else
            {
                repeat=0;
            }
            if(repeat==5)
            {
                result+='0';
                repeat=0;
            }
        }
        return result;
    }
    public static String physicalCoding(String data)
    {
        String result="";
        for(int i=0;i<data.length();i++)
        {
            if(data.charAt(i)=='0')
            {
                result+="01";
                continue;
            }
            result+="10";      
          }
          return "00"+result+"11";
    }
    public static String stringMatcher(String s,String p)
    {
        int len=p.length();
        String result="";
        for(int i=0;i<s.length();i++)
        {
            if(i+len <= s.length() && s.substring(i, i+len).equals(p))
            {
                result+=p;
                result+=p;
                i=i+len;
                result+=s.substring(i,i+1);
            }
            else
            {
                result+=s.substring(i,i+1);
            }
        }
        return result;
    }
    public static String byteStuffing(String data)
    {
        String flag="01111110";
        String esc= "10000001";  
        if(data.contains(flag))
        {
          data=  stringMatcher(data, flag);
        }
        if(data.contains(esc))
        {
            data=  stringMatcher(data, esc);
        }
        data=flag+data+flag;
        return data;
    }
    public static String characterCount(String data)
    {
         int n=data.length()+1;
         data= String.valueOf(n)+data;

         return data;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        boolean iscont=true;
        while (iscont) 
        {
            System.out.println("\nMenu: \n1.Counting Characters\n2.Byte Stuffing\n3.Bit Stuffing\n4.Physical Codign Violation \n5.Exit");
            System.out.println("Enter your choice: ");
            int ch=sc.nextInt();
            if(ch==5){
                System.exit(1);
            }
            sc.nextLine();
            System.out.println("Enter message:  ");
            String data=sc.nextLine();
            
            switch(ch)
            {
                case 1:  System.out.println(characterCount(data));
                break;
                case 2:  System.out.println(byteStuffing(data));
                break;
                case 3:  System.out.println(bitStuffing(data));
                break;
                case 4: System.out.println(physicalCoding(data));
                break;
                default : System.out.println("Enter valid choice");
                
            }
        }
    }
}