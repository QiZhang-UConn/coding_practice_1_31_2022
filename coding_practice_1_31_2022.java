import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class coding_practice_1_31_2022 {
    public static void main(String[] args) {
        System.out.println("********************Problem One***********************");
        /*
        Problem 1. Filter Out Strings from an Array
        */
//        filterArray([1, 2, "a", "b"]) ➞ [1, 2]
        ArrayList<Object> test1=new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add("a");
        test1.add("b");
        System.out.println("Before: "+test1);
        System.out.println("After: "+numFilter(test1));
        System.out.println("________________________________");
//        filterArray([1, "a", "b", 0, 15]) ➞ [1, 0, 15]
        ArrayList<Object> test2=new ArrayList<>();
        test2.add(1);
        test2.add("a");
        test2.add("b");
        test2.add(0);
        test2.add(15);
        System.out.println("Before: "+test2);
        System.out.println("After: "+numFilter(test2));
        System.out.println("________________________________");
//        filterArray([1, 2, "aasf", "1", "123", 123]) ➞ [1, 2, 123]
        ArrayList<Object> test3=new ArrayList<>();
        test3.add(1);
        test3.add(2);
        test3.add("aasf");
        test3.add("1");
        test3.add("123");
        test3.add(123);
        System.out.println("Before: "+test3);
        System.out.println("After: "+numFilter(test3));
        System.out.println("________________________________");
        System.out.println("********************Problem Two***********************");
//        multiplyBy11("11") ➞ "121"
        System.out.println(multiplyBy11("11"));
        System.out.println("________________________________");
//        multiplyBy11("111111111") ➞ "1222222221"
        System.out.println(multiplyBy11("111111111"));
        System.out.println("________________________________");
//        multiplyBy11("1213200020") ➞ "13345200220"
        System.out.println(multiplyBy11("1213200020"));
        System.out.println("________________________________");
//        multiplyBy11("1217197941") ➞ "13389177351"
        System.out.println(multiplyBy11("1217197941"));
        System.out.println("________________________________");
//        multiplyBy11("9473745364784876253253263723") ➞ "104211199012633638785785900953"
        System.out.println(multiplyBy11("9473745364784876253253263723"));
        System.out.println("________________________________");
        System.out.println("********************Problem Two***********************");
        /*
        3. Logical Reasoning Question:
            In this logic question, you are standing in a room with three light switches.
            The switches all correspond to three different light bulbs in an adjacent room that you cannot see into.
            With all the light switches starting in the off position, how can you find out which switch connects to which light bulb?
            TODO:
            We have three light bulbs A,B,C and three switches As,Bs,Cs.
            1. If we have a circuit diagram, we can tell their mapping right of way.
            2. If we can have any feedback from the light bulbs' room. The answer if easy. Since all light are off, as we
            turn each switch on there will be a corresponding light being turn on. Once we have feedback, just record
            the relationship mapping for switches to light bulbs. The feedback can be you walk in to the room, another
            person's word or any experimental set up.
            3. If we don't have any feedback at all. There is no way to know the actual mapping except logical guessing.
            Just like black holes.
            Scientists can only make some hypothesises based on math and physics rules outside the black hole. People
            can't really tell if we got the correct theories about black holes or not. Because black holes catches light,
            scientists cannot observe and obtain any feedback to correct their theory.
        */
    }
    public static List<Object> numFilter(ArrayList<Object> List){
        return List.stream().filter(c-> c.getClass()==Integer.class && (Integer)c>0).collect(Collectors.toList());
    }
    public static String multiplyBy11(String inputNum){
        StringBuffer result=new StringBuffer();
        result.append(inputNum.charAt(inputNum.length()-1));
        boolean carry=false;
        for(int i=inputNum.length()-2; i>=0;i--){
            int sum=inputNum.charAt(i)+inputNum.charAt(i+1)-48*2;
            if(carry){
                sum++;
                carry=false;
            }
            if(sum>=10){
                result.append(Character.toChars(sum-10+48));
                carry=true;
            }
            else{
                result.append((Character.toChars(sum+48)));
            }
        }
        if(carry){
            int sum=inputNum.charAt(0)+1-48;
            if(sum==10)result.append("01");
            else result.append((Character.toChars(sum-10+48)));
        }
        else{
            result.append(inputNum.charAt(0));
        }

        return result.reverse().toString();
    }
}
