package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool
{
  private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
  private static final ConnectionPool systemDefault;
  private final LinkedList<Connection> connections = new LinkedList();
  private final Runnable connectionsCleanupRunnable = new Runnable()
  {
    public void run()
    {
      ConnectionPool.this.runCleanupUntilPoolIsEmpty();
    }
  };
  private Executor executor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  
  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    if (str2 != null) {}
    for (long l = Long.parseLong(str2); (str1 != null) && (!Boolean.parseBoolean(str1)); l = 300000L)
    {
      systemDefault = new ConnectionPool(0, l);
      return;
    }
    if (str3 != null)
    {
      systemDefault = new ConnectionPool(Integer.parseInt(str3), l);
      return;
    }
    systemDefault = new ConnectionPool(5, l);
  }
  
  public ConnectionPool(int paramInt, long paramLong)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = (paramLong * 1000L * 1000L);
  }
  
  private void addConnection(Connection paramConnection)
  {
    boolean bool = this.connections.isEmpty();
    this.connections.addFirst(paramConnection);
    if (bool)
    {
      this.executor.execute(this.connectionsCleanupRunnable);
      return;
    }
    notifyAll();
  }
  
  public static ConnectionPool getDefault()
  {
    return systemDefault;
  }
  
  private void runCleanupUntilPoolIsEmpty()
  {
    while (performCleanup()) {}
  }
  
  public void evictAll()
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList(this.connections);
        this.connections.clear();
        notifyAll();
        i = 0;
        int j = localArrayList.size();
        if (i >= j) {
          return;
        }
      }
      finally {}
      Util.closeQuietly(((Connection)((List)localObject).get(i)).getSocket());
      i += 1;
    }
  }
  
  /* Error */
  public Connection get(Address paramAddress)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 68	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   8: aload_0
    //   9: getfield 68	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   12: invokevirtual 166	java/util/LinkedList:size	()I
    //   15: invokevirtual 170	java/util/LinkedList:listIterator	(I)Ljava/util/ListIterator;
    //   18: astore 4
    //   20: aload 4
    //   22: invokeinterface 175 1 0
    //   27: ifne +28 -> 55
    //   30: aload_2
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +18 -> 51
    //   36: aload_1
    //   37: invokevirtual 178	com/squareup/okhttp/Connection:isFramed	()Z
    //   40: ifeq +11 -> 51
    //   43: aload_0
    //   44: getfield 68	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   47: aload_1
    //   48: invokevirtual 119	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: areturn
    //   55: aload 4
    //   57: invokeinterface 182 1 0
    //   62: checkcast 154	com/squareup/okhttp/Connection
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 186	com/squareup/okhttp/Connection:getRoute	()Lcom/squareup/okhttp/Route;
    //   70: invokevirtual 192	com/squareup/okhttp/Route:getAddress	()Lcom/squareup/okhttp/Address;
    //   73: aload_1
    //   74: invokevirtual 198	com/squareup/okhttp/Address:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -57 -> 20
    //   80: aload_3
    //   81: invokevirtual 201	com/squareup/okhttp/Connection:isAlive	()Z
    //   84: ifeq -64 -> 20
    //   87: invokestatic 205	java/lang/System:nanoTime	()J
    //   90: aload_3
    //   91: invokevirtual 208	com/squareup/okhttp/Connection:getIdleStartTimeNs	()J
    //   94: lsub
    //   95: aload_0
    //   96: getfield 105	com/squareup/okhttp/ConnectionPool:keepAliveDurationNs	J
    //   99: lcmp
    //   100: ifge -80 -> 20
    //   103: aload 4
    //   105: invokeinterface 211 1 0
    //   110: aload_3
    //   111: invokevirtual 178	com/squareup/okhttp/Connection:isFramed	()Z
    //   114: istore 6
    //   116: iload 6
    //   118: ifne +13 -> 131
    //   121: invokestatic 216	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   124: aload_3
    //   125: invokevirtual 158	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   128: invokevirtual 219	com/squareup/okhttp/internal/Platform:tagSocket	(Ljava/net/Socket;)V
    //   131: aload_3
    //   132: astore_1
    //   133: goto -101 -> 32
    //   136: astore 5
    //   138: aload_3
    //   139: invokevirtual 158	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   142: invokestatic 162	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   145: invokestatic 216	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   148: new 221	java/lang/StringBuilder
    //   151: dup
    //   152: ldc -33
    //   154: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload 5
    //   159: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 237	com/squareup/okhttp/internal/Platform:logW	(Ljava/lang/String;)V
    //   168: goto -148 -> 20
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	ConnectionPool
    //   0	176	1	paramAddress	Address
    //   3	28	2	localObject	Object
    //   65	74	3	localConnection	Connection
    //   18	86	4	localListIterator	ListIterator
    //   136	22	5	localSocketException	SocketException
    //   114	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   121	131	136	java/net/SocketException
    //   4	20	171	finally
    //   20	30	171	finally
    //   36	51	171	finally
    //   55	116	171	finally
    //   121	131	171	finally
    //   138	168	171	finally
  }
  
  public int getConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  List<Connection> getConnections()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getHttpConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      int j = getMultiplexedConnectionCount();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getMultiplexedConnectionCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 68	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   8: invokevirtual 250	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface 255 1 0
    //   18: istore_3
    //   19: iload_3
    //   20: ifne +7 -> 27
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: aload_1
    //   28: invokeinterface 258 1 0
    //   33: checkcast 154	com/squareup/okhttp/Connection
    //   36: invokevirtual 178	com/squareup/okhttp/Connection:isFramed	()Z
    //   39: istore_3
    //   40: iload_3
    //   41: ifeq -29 -> 12
    //   44: iload_2
    //   45: iconst_1
    //   46: iadd
    //   47: istore_2
    //   48: goto -36 -> 12
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ConnectionPool
    //   11	17	1	localIterator	java.util.Iterator
    //   51	4	1	localObject	Object
    //   3	45	2	i	int
    //   18	23	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	12	51	finally
    //   12	19	51	finally
    //   27	40	51	finally
  }
  
  @Deprecated
  public int getSpdyConnectionCount()
  {
    try
    {
      int i = getMultiplexedConnectionCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean performCleanup()
  {
    for (;;)
    {
      ArrayList localArrayList;
      long l2;
      long l1;
      ListIterator localListIterator;
      try
      {
        if (this.connections.isEmpty()) {
          return false;
        }
        localArrayList = new ArrayList();
        i = 0;
        l2 = System.nanoTime();
        l1 = this.keepAliveDurationNs;
        localListIterator = this.connections.listIterator(this.connections.size());
        if (!localListIterator.hasPrevious())
        {
          localListIterator = this.connections.listIterator(this.connections.size());
          if ((localListIterator.hasPrevious()) && (i > this.maxIdleConnections)) {
            break label221;
          }
          boolean bool = localArrayList.isEmpty();
          if (!bool) {
            break;
          }
        }
      }
      finally {}
      try
      {
        l2 = l1 / 1000000L;
        wait(l2, (int)(l1 - 1000000L * l2));
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        int j;
        for (;;) {}
      }
      Connection localConnection = (Connection)localListIterator.previous();
      long l3 = localConnection.getIdleStartTimeNs() + this.keepAliveDurationNs - l2;
      if ((l3 <= 0L) || (!localConnection.isAlive()))
      {
        localListIterator.remove();
        localArrayList.add(localConnection);
      }
      else if (localConnection.isIdle())
      {
        i += 1;
        l1 = Math.min(l1, l3);
        continue;
        label221:
        localConnection = (Connection)localListIterator.previous();
        if (localConnection.isIdle())
        {
          ((List)localObject).add(localConnection);
          localListIterator.remove();
          i -= 1;
        }
      }
    }
    int i = 0;
    j = ((List)localObject).size();
    for (;;)
    {
      if (i >= j) {
        return true;
      }
      Util.closeQuietly(((Connection)((List)localObject).get(i)).getSocket());
      i += 1;
    }
  }
  
  void recycle(Connection paramConnection)
  {
    if (paramConnection.isFramed()) {}
    while (!paramConnection.clearOwner()) {
      return;
    }
    if (!paramConnection.isAlive())
    {
      Util.closeQuietly(paramConnection.getSocket());
      return;
    }
    try
    {
      Platform.get().untagSocket(paramConnection.getSocket());
      try
      {
        addConnection(paramConnection);
        paramConnection.incrementRecycleCount();
        paramConnection.resetIdleStartTime();
        return;
      }
      finally {}
      return;
    }
    catch (SocketException localSocketException)
    {
      Platform.get().logW("Unable to untagSocket(): " + localSocketException);
      Util.closeQuietly(paramConnection.getSocket());
    }
  }
  
  void replaceCleanupExecutorForTests(Executor paramExecutor)
  {
    this.executor = paramExecutor;
  }
  
  void share(Connection paramConnection)
  {
    if (!paramConnection.isFramed()) {
      throw new IllegalArgumentException();
    }
    if (!paramConnection.isAlive()) {
      return;
    }
    try
    {
      addConnection(paramConnection);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */