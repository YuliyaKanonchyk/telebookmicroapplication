package by.learn.mainmicro.ex;

public class WrongApiKeyOrRole extends RuntimeException {
    public WrongApiKeyOrRole(String key, String role) {
        System.out.println("Wrong key " + key+" or User role "+role);
    }
}
