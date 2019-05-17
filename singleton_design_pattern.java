// Lazy initialization
public class LazySingleton {
    private static LazySingleton instance;
    // Prevent instantiation from other functions
    private LazySingleton() { }
    public static LazySingleton getInstance() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}

// Early initialization
public class EarlySingleton {
    private static final EarlySingleton instance = new EarlySingleton();
    private EarlySingleton() { }
    public static EarlySingleton getInstance() {
      return instance;
    }
}

// Thread-safe
public class ThreadSafeSingleton {
  private static ThreadSafeSingleton instance;
  private ThreadSafeSingleton() { }
  public static synchronized ThreadSafeSingleton getInstance() {
    if (instance == null)
      instance = new ThreadSafeSingleton();
    return instance;
  }

  // Thread-safe: Double locking check method
  public static ThreadSafeSingleton getInstanceWithDoubleLocking() {
    if (instance == null) {
      synchronized (ThreadSafeSingleton.class) {
        if (instance == null)
          instance = new ThreadSafeSingleton();
      }
    }
    return instance;
  }
}

// static block (exception handling)
public class StaticBlockSingleton {
  private static StaticBlockSingleton instance;
  private StaticBlockSingleton() { }
  static {
    try {
      instance = new StaticBlockSingleton();
    } catch (Exception e) {
      throw new RuntimeException("Exception in creating StaticBlockSingleton");
    }
  }
  public static StaticBlockSingleton getInstance() {
    return instance;
  }
}

// Bill Pugh
public class BillPughSingleton {
  private BillPughSingleton() { }

  private static class SingletonHelper() {
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance() {
    return SingletonHelper.INSTANCE;
  }
}

// Enum (to prevent reflection that breaks singleton)
public enum EnumSingleton {
  INSTANCE;
  public static void doSomething() { }
}
