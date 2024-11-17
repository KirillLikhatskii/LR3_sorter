import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        int length;
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Какое кол-во чисел вы хотите отсортировать: ");
            try
            {
                length = scanner.nextInt();
                break;
            }catch (InputMismatchException fg)
            {
                System.out.println("Введите число");
            }
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0; i<length; i++)
        {
            int number;
            while (true)
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите число " + (i+1) +": ");
                try
                {
                    number = scanner.nextInt();
                    break;
                }catch (InputMismatchException fg)
                {
                    System.out.println("Введите число");
                }
            }
            numbers.add(number);
        }
        int last_positive_index = 0;
        for (int i=0; i<numbers.size(); i++)
        {
            if (numbers.get(i)>0)
            {
                last_positive_index = i;
                continue;
            }else
            {
                for (int j=numbers.size()-1; j>last_positive_index; j--)
                {
                    int temp;
                    if (numbers.get(j)>0)
                    {
                        temp = numbers.get(j);
                        numbers.set(j, numbers.get(i));
                        numbers.set(i, temp);
                        break;
                    }else
                        continue;
                }
                last_positive_index = i;
            }
        }
        System.out.println(numbers);
    }

}