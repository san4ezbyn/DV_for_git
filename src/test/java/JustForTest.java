import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JustForTest {


    public static void main(String[] args) throws ParseException {

       /* DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("ddMMyyyy");
        String str = fmt.print(dt);

        System.out.println(str);


        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("yyyy/dd/MMMM").parse(sDate1);
        System.out.println(sDate1+"\t"+date1);
*/
        Dogs.getDogsCount();

        Dogs lab = new Dogs();
        lab.setName("Jack");
        lab.setBreed("labrador");

        lab.setSize(Size.AVERAGE);
        lab.bark();


        Dogs shep = new Dogs();
        shep.setName("Bobs");
        shep.setBreed("sheppard");

        shep.setSize(Size.BIG);
        shep.bark();

        Dogs mops = new Dogs();
        mops.setName("Puffi");
        mops.setSize(Size.SMALL);
        mops.bark();


        System.out.println("Labrador is " + lab.getName());
        System.out.println("Sheppard is " + shep.getName());
        System.out.println("Mops is " + mops.getName());

        Size s = Size.SMALL;
        Size s1 = Size.valueOf("BIG");
        System.out.println(s1);
        Size[] values = Size.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println("values " + values[i]);
        }
    }

}
