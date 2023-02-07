public class MangalaExceptions extends Exception{
    protected MangalaExceptions(String errorMessage){
        super(errorMessage);
    }
}

class EmptyHoleException extends MangalaExceptions{
    public EmptyHoleException(int holeNum){
        super("Selected hole is not contain any stone. Hole Number:" +(holeNum +1));
    }
}

class HoleNumberException extends MangalaExceptions{
    public HoleNumberException(){
        super("Given hole number is not valid! Give a number between 1-6.");
    }
}