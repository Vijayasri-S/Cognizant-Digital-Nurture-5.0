/* Singleton Pattern is creational pattern where a class can only have one instance
    Example: In a school there can be multiple instance to student class but only one instance to Principal class as there is only one principal in a school.
    To make this possible we make the constructor of the class private so object can't be created outside the class.

    In this activity Logger has only one instance "instance"
    To make it thread safe object is created imediately as the class is loaded. And Final keyword makes sure that there is only one instance.
    l1==l2 gives true as output which means both point to same instance*/
    
class Logger{
    private static final Logger instance=new Logger();
    private Logger(){

    }
    public static Logger getInstance(){
        return instance;
    }
}
public class SingletonPatternExample{
    public static void main(String[] args){
        Logger l1=Logger.getInstance ();
        Logger l2=Logger.getInstance();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l1==l2);
    }
}
