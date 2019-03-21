public class NoSuchCustomerException extends Exception {

    String name;

    public NoSuchCustomerException(String name) {
        this.name = name;

    }

    public String toString() {
        return "W bazie nie ma klienta o podanym nazwisku " + this.name;
    }
}
