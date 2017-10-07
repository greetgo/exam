package reflection.singleton;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleChecker {

  private static final int POOL_SIZE = 1000;

  public static void main(String[] args) throws InterruptedException {


    BlockingDeque<Runnable> allProcesses = new LinkedBlockingDeque<>();

    final Set<String> instanceIds = new TreeSet<>();

    Thread lastThread = null;

    for (int i = 0; i < POOL_SIZE ; i++) {

      Runnable runnable = new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          instanceIds.add(MySingleton.getInstance().toString());
        }
      };

      lastThread = new Thread(runnable);

      lastThread.start();
    }

    Thread.sleep(5000);

    System.out.println("size : " + instanceIds.size());





  }


}
