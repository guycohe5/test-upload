package ProjectEnd.company;

import java.util.Scanner;

public class Main {

    public static String func1(List<String> l1)//מציאת המילה ארוכה ביותר
    {
        Node<String> pf1=l1.getFirst();
        Node<String> pf1_2=pf1.GetNext();

        while(pf1_2!=null)
        {
            if(pf1_2.GetInfo().length()>pf1.GetInfo().length())
            {
                pf1=pf1_2;
            }
            pf1_2=pf1_2.GetNext();
        }
        return pf1.GetInfo();
    }
    public static boolean func2(List<Integer> l3,int num)
    {
       Node<Integer> pf2=l3.getFirst();
       if(!(pf2!=null))
           return false;
       if(pf2.GetInfo()==num)
           return true;
       l3.Remove(pf2);

       return func2(l3,num);
    }
    public static int func3(List<Integer> l4)
    {
        Node<Integer> pf3=l4.getFirst();
        int check_num=0,sum=0,numd=0,sum_check;
        while(pf3!=null)
        {
            check_num=pf3.GetInfo();
            sum_check=0;
            while(check_num>0)
            {
                numd=check_num%10;
                sum_check=sum_check*10+numd;
                check_num=check_num/10;
            }
            if(sum_check==pf3.GetInfo())
            {
                sum+=pf3.GetInfo();
            }
            pf3=pf3.GetNext();
        }
        return sum;
    }
    public static int func4(List<Integer> l5)
    {
        Node<Integer> pf4=l5.getFirst();
        Node<Integer> pf4_1=null;
        int C_T=0,count,max=0,check=0;
        while(pf4!=null)
        {
            count=1;
            pf4_1=pf4.GetNext();
            while(pf4_1!=null)
            {
                if(pf4_1.GetInfo()==pf4.GetInfo())
                    count++;
                pf4_1=pf4_1.GetNext();
            }
            if(count>max)
            {
                max=count;
                check=pf4.GetInfo();
            }
            pf4=pf4.GetNext();
            C_T++;
        }

        if(max>=C_T/2)
            return check;

        return 0;

    }
    public static int func5(List<Integer> l6)//מספרים ראשונים
    {
        Node<Integer>pf5=l6.getFirst();
        int sum=0;
        while(pf5!=null)
        {
            if(checkP(pf5.GetInfo()))
            {
                int num=pf5.GetInfo();
                int mul=1;
                for(int i=1;i<=num;i++)
                    mul*=i;
                sum+=mul;
                pf5=pf5.GetNext();
            }
            else
                pf5=pf5.GetNext();
        }
        return sum;
    }
    public static boolean checkP(int num)//function help for func5
    {
        int i;
        if(num<=1)
            return false;
        if(num<=3)
            return true;
        if(num%2==0||num%3==0)
            return false;
        else
        {
            for(i=5;i*i<=num;i+=6)
                if(num%i==0||num%(i+2)==0)
                    return false;
        }
        return true;
    }
    public static List<Integer> func6(int num)
    {
        List<Integer>List_new=new List<Integer>();
        Node<Integer>pf7=List_new.getFirst();
        int a=0,b=0,c=1;
        pf7=List_new.Insert(pf7,0);
        pf7=List_new.Insert(pf7,1);
        for(int i=2;i<num;i++)
        {
            b=c;
            c=a+b;
            pf7=List_new.Insert(pf7,c);
            a=b;
        }
        return List_new;
    }
    public static void func7(List<Integer> ls7)
    {
        if(ls7==null)
            return;
        for(Node<Integer>pf8=ls7.getFirst();pf8!=null;pf8=pf8.GetNext())
        {
            Node<Integer>q=pf8.GetNext();
            while(q!=null)
            {
                if(q.GetInfo()==pf8.GetInfo())
                {
                    q=ls7.Remove(q);
                }
                else
                    q=q.GetNext();
            }
        }
    }
    public static void func8(List<Integer> l8)//היפוך הרשימה ברקורסיה 
    {
        int x;
        Node<Integer>pos=l8.getFirst();
        while (pos!=null)
        {
            x=pos.GetInfo();
            pos=l8.Remove(pos);
            l8.Insert(null,x);
        }
    }
    public static List<Integer> func9(List<Integer> l1,List<Integer> l2)
    {
        List<Integer> l3=new List<Integer>();
        Node<Integer> pf9=l3.getFirst();
        Node<Integer> pf9_1=l1.getFirst();
        Node<Integer> pf9_2=l2.getFirst();
        int sum=0;
        while(pf9_1!=null&&pf9_2!=null)
        {
            sum=0;
            sum+=pf9_1.GetInfo()+pf9_2.GetInfo();
            pf9=l3.Insert(pf9,sum);

            pf9_1=pf9_1.GetNext();
            pf9_2=pf9_2.GetNext();
        }
        if(pf9_1!=null)
        {
            while (pf9_1!=null)
            {
                pf9=l3.Insert(pf9,pf9_1.GetInfo());
                pf9_1=pf9_1.GetNext();
            }
        }
        else if(pf9_2!=null)
        {
            while (pf9_2!=null)
            {
                pf9=l3.Insert(pf9,pf9_2.GetInfo());
                pf9_2.GetNext();
            }
        }

        return l3;
    }
    public static List<Integer> func10(List<Integer> l10)
    {
        Node<Integer>pf10=l10.getFirst();
        List<Integer> l10_new=new List<Integer>();
        Node<Integer>pf10_new=l10_new.getFirst();

        while (pf10!=null)
        {
            int num=pf10.GetInfo();
            while (num>0)
            {
                pf10_new=l10_new.Insert(pf10_new,pf10.GetInfo());
                num--;
            }
            pf10=pf10.GetNext();
        }

        return l10_new;
    }

    public static void main(String[] args) {

        System.out.println("function 1");
        List<String>str=new List<String>();
        Node<String>p=str.getFirst();
        p=str.Insert(p,"guy");
        p=str.Insert(p,"stave");
        p=str.Insert(p,"bar");
        System.out.println("name long:"+func1(str));

        System.out.println("==============================================");

        System.out.println("function 2");
        List<Integer>l4=new List<Integer>();
        Node<Integer>p1=l4.getFirst();
        p1=l4.Insert(p1,60);
        p1=l4.Insert(p1,11);
        p1=l4.Insert(p1,95);
        p1=l4.Insert(p1,10);
        p1=l4.Insert(p1,32);
        System.out.println("? :"+func2(l4,32));

        System.out.println("==============================================");

        System.out.println("function 3");
        List<Integer>l3=new List<Integer>();
        Node<Integer>p2=l3.getFirst();
        p2=l3.Insert(p2,13);
        p2=l3.Insert(p2,212);
        p2=l3.Insert(p2,22);
        p2=l3.Insert(p2,44);
        p2=l3.Insert(p2,4);
        p2=l3.Insert(p2,3);

        System.out.println("sum:"+func3(l3));

        System.out.println("==============================================");
        System.out.println("function 4");
        List<Integer>l2=new List<Integer>();
        Node<Integer>p3=l2.getFirst();
        p3=l2.Insert(p3,1);
        p3=l2.Insert(p3,1);
        p3=l2.Insert(p3,1);
        p3=l2.Insert(p3,5);
        p3=l2.Insert(p3,4);
        p3=l2.Insert(p3,3);
        p3=l2.Insert(p3,2);
        p3=l2.Insert(p3,1);

        int check=func4(l2);

        if(check!=0)
            System.out.println("The common number:"+check);
        else
            System.out.println("There is no such number");

        System.out.println("==============================================");
        System.out.println("function 5");
        List<Integer>prime=new List<Integer>();
        Node<Integer>p4=prime.getFirst();
        p4=prime.Insert(p4,4);
        p4=prime.Insert(p4,6);
        p4=prime.Insert(p4,2);
        p4=prime.Insert(p4,12);
        p4=prime.Insert(p4,3);
        p4=prime.Insert(p4,7);
        p4=prime.Insert(p4,20);
        int R=func5(prime);
        System.out.println("sum numbers prime:"+R);

        System.out.println("==============================================");
        System.out.println("function 6");
        List<Integer> fibonacci=new List<Integer>();
        Scanner number_f=new Scanner(System.in);
        System.out.println("enter number: ");
       int num = number_f.nextInt();
        fibonacci=func6(num);
        System.out.println("fibonacci: "+fibonacci.PrintList());

        System.out.println("==============================================");
        System.out.println("function 7");

        List<Integer>l7=new List<Integer>();
        Node<Integer>p6=l7.getFirst();

        p6=l7.Insert(p6,4);
        p6=l7.Insert(p6,5);
        p6=l7.Insert(p6,5);
        p6=l7.Insert(p6,5);
        p6=l7.Insert(p6,7);
        p6=l7.Insert(p6,5);
        p6=l7.Insert(p6,9);
        System.out.println("Before :" + l7.PrintList());
        func7(l7);
        System.out.println("After :" + l7.PrintList());

        System.out.println("==============================================");
        System.out.println("function 8");

        List<Integer>l8=new List<Integer>();
        Node<Integer>p8=l8.getFirst();

        p8=l8.Insert(p8,9);
        p8=l8.Insert(p8,1);
        p8=l8.Insert(p8,8);
        p8=l8.Insert(p8,10);

        System.out.println("Before reversing: "+l8.PrintList());
        func8(l8);
        System.out.println("After reversing: "+l8.PrintList());

        System.out.println("==============================================");
        System.out.println("function 9");
        List<Integer>l9=new List<Integer>();
        Node<Integer>p9=l9.getFirst();

        p9=l9.Insert(p9,-3);
        p9=l9.Insert(p9,6);
        p9=l9.Insert(p9,8);
        p9=l9.Insert(p9,10);
        p9=l9.Insert(p9,-5);
        p9=l9.Insert(p9,3);

        List<Integer>l9_1=new List<Integer>();
        Node<Integer>p9_1=l9_1.getFirst();

        p9_1=l9_1.Insert(p9_1,-4);
        p9_1=l9_1.Insert(p9_1,6);
        p9_1=l9_1.Insert(p9_1,2);
        p9_1=l9_1.Insert(p9_1,76);

        List<Integer>l9_3=func9(l9,l9_1);
        System.out.println("list: "+l9_3.PrintList());

        System.out.println("==============================================");
        System.out.println("function 10");

        List<Integer>l10=new List<Integer>();
        Node<Integer>p10=l10.getFirst();

        p10=l10.Insert(p10,4);
        p10=l10.Insert(p10,6);
        p10=l10.Insert(p10,8);

        System.out.println("list new "+func10(l10).PrintList());
    }
}
