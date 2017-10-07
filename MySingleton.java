package reflection.singleton;

public class MySingleton {
  private static MySingleton instance;

  public static MySingleton getInstance() {
    if (instance == null) {
      synchronized (MySingleton.class) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        instance = new MySingleton();
      }
    }
    return instance;
  }

  private MySingleton() {
  }
}
