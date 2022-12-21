import java.util.Arrays;
import java.util.Collections;

class Coffee implements Comparable<Coffee> {
    private String name;
    private int price;

    public Coffee(String name, int age){
        this.name = name;
        this.price= age;
    }

    public String print(){
        return this.name+"("+this.price+"��)";
    }

    @Override
    public int compareTo(Coffee coffee) {
        // TODO Auto-generated method stub
        if (this.price < coffee.price) {
            return -1;
        } else if (this.price == coffee.price) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class ComparableCoffee{
    public static void main(String[] args)  {
        Coffee[] arr = { new Coffee("�Ƹ޸�ī��", 4000)
                , new Coffee("��", 4500)
                , new Coffee("��������", 6000)
                , new Coffee("���̽�Ƽ", 3000)
                , new Coffee("��Ϻ극��", 8000)};

        Arrays.sort(arr); //�������� ����

        for (Coffee i : arr) {
            System.out.print(i.print()+" ");
        }

        Arrays.sort(arr,Collections.reverseOrder()); //�������� ����
        System.out.println();

        for (Coffee i : arr) {
            System.out.print(i.print()+" ");
        }
    }
}