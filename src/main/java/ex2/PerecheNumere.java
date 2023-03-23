package ex2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PerecheNumere {
    private int first;
    private int second;
    public PerecheNumere(){}
    public PerecheNumere(int f, int s)
    {
        this.first = f;
        this.second = s;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @JsonIgnore
    public int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public boolean Fibonacci(){
        List<Integer> numereFibonacci = new ArrayList<>();
        numereFibonacci.add(fib(0));
        int i=0;
        while(numereFibonacci.get(numereFibonacci.size()-1) < Integer.max(first,second))
        {
            i++;
            numereFibonacci.add(fib(i));
        }

        System.out.println(numereFibonacci);
        System.out.println("INDEX MAX: " + numereFibonacci.lastIndexOf(Integer.max(first,second)));
        System.out.println("INDEX MIN: " + numereFibonacci.lastIndexOf(Integer.min(first,second)));
        return numereFibonacci.lastIndexOf(Integer.max(first,second))==numereFibonacci.lastIndexOf(Integer.min(first,second))+1;
    }


    public  int DigitSum(int a)
    {
        System.out.println("intra");
        int sum=0;
        while(a > 0)
        {
            sum+=a%10;
            a/=10;
        }
        return sum;
    }
    public  int getEvenDigits(int a)
    {

        int sum=0;
        while(a > 0)
        {
            if(a%10%2==0)
                sum++;
            a/=10;
        }
        return sum;
    }

    public boolean DigitsSumEqual()
    {
        return DigitSum(first)== DigitSum(second);
    }


    public int cmmc(){
        int a=first;
        int b=second;
        while(a!=b)
        {
            if(a>b)
                a-=b;
            else
                b-=a;
        }
        return (first*second)/a;
    }
    @Override
    public  String toString()
    {
        StringBuilder sb = new StringBuilder("First: "+this.first + "\nSecond: "+this.second);
        return sb.toString();
    }
}
