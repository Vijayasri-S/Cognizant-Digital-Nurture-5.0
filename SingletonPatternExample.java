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
        //SingletonPatternExample s=new SingletonPatternExample();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l1==l2);
    }
}