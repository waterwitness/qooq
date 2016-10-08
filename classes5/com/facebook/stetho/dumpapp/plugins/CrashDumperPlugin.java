package com.facebook.stetho.dumpapp.plugins;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class CrashDumperPlugin
  implements DumperPlugin
{
  private static final String NAME = "crash";
  private static final String OPTION_EXIT_DEFAULT = "0";
  private static final String OPTION_KILL_DEFAULT = "9";
  private static final String OPTION_THROW_DEFAULT = "java.lang.Error";
  
  /* Error */
  private void doKill(DumperContext paramDumperContext, Iterator<String> paramIterator)
    throws DumpException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 19
    //   3: invokestatic 39	com/facebook/stetho/dumpapp/ArgsHelper:nextOptionalArg	(Ljava/util/Iterator;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: new 41	java/lang/ProcessBuilder
    //   10: dup
    //   11: iconst_0
    //   12: anewarray 43	java/lang/String
    //   15: invokespecial 46	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   18: iconst_3
    //   19: anewarray 43	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 48
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: new 50	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 52
    //   35: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aastore
    //   46: dup
    //   47: iconst_2
    //   48: invokestatic 69	android/os/Process:myPid	()I
    //   51: invokestatic 73	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: aastore
    //   55: invokevirtual 77	java/lang/ProcessBuilder:command	([Ljava/lang/String;)Ljava/lang/ProcessBuilder;
    //   58: iconst_1
    //   59: invokevirtual 81	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   62: invokevirtual 85	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 91	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   70: aload_1
    //   71: invokevirtual 97	com/facebook/stetho/dumpapp/DumperContext:getStdout	()Ljava/io/PrintStream;
    //   74: sipush 1024
    //   77: newarray <illegal type>
    //   79: invokestatic 103	com/facebook/stetho/common/Util:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
    //   82: aload_2
    //   83: invokevirtual 106	java/lang/Process:destroy	()V
    //   86: return
    //   87: astore_1
    //   88: aload_2
    //   89: invokevirtual 106	java/lang/Process:destroy	()V
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: new 31	com/facebook/stetho/dumpapp/DumpException
    //   98: dup
    //   99: new 50	java/lang/StringBuilder
    //   102: dup
    //   103: ldc 108
    //   105: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	CrashDumperPlugin
    //   0	119	1	paramDumperContext	DumperContext
    //   0	119	2	paramIterator	Iterator<String>
    // Exception table:
    //   from	to	target	type
    //   66	82	87	finally
    //   7	66	94	java/io/IOException
    //   82	86	94	java/io/IOException
    //   88	94	94	java/io/IOException
  }
  
  private void doSystemExit(Iterator<String> paramIterator)
  {
    System.exit(Integer.parseInt(ArgsHelper.nextOptionalArg(paramIterator, "0")));
  }
  
  /* Error */
  private void doUncaughtException(Iterator<String> paramIterator)
    throws DumpException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 22
    //   3: invokestatic 39	com/facebook/stetho/dumpapp/ArgsHelper:nextOptionalArg	(Ljava/util/Iterator;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: invokestatic 149	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   11: astore_1
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 145	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: ldc 43
    //   21: aastore
    //   22: invokestatic 153	com/facebook/stetho/dumpapp/plugins/CrashDumperPlugin:tryGetDeclaredConstructor	(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +45 -> 72
    //   30: aload_2
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc -101
    //   39: aastore
    //   40: invokevirtual 161	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 163	java/lang/Throwable
    //   46: astore_1
    //   47: new 165	java/lang/Thread
    //   50: dup
    //   51: new 8	com/facebook/stetho/dumpapp/plugins/CrashDumperPlugin$ThrowRunnable
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 168	com/facebook/stetho/dumpapp/plugins/CrashDumperPlugin$ThrowRunnable:<init>	(Ljava/lang/Throwable;)V
    //   59: invokespecial 171	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 173	java/lang/Thread:start	()V
    //   67: aload_1
    //   68: invokestatic 177	com/facebook/stetho/common/Util:joinUninterruptibly	(Ljava/lang/Thread;)V
    //   71: return
    //   72: aload_1
    //   73: iconst_0
    //   74: anewarray 145	java/lang/Class
    //   77: invokevirtual 181	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokevirtual 161	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 163	java/lang/Throwable
    //   90: astore_1
    //   91: goto -44 -> 47
    //   94: astore_1
    //   95: new 31	com/facebook/stetho/dumpapp/DumpException
    //   98: dup
    //   99: new 50	java/lang/StringBuilder
    //   102: dup
    //   103: ldc -73
    //   105: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   118: athrow
    //   119: astore_1
    //   120: new 31	com/facebook/stetho/dumpapp/DumpException
    //   123: dup
    //   124: new 50	java/lang/StringBuilder
    //   127: dup
    //   128: ldc -73
    //   130: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_1
    //   134: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   143: athrow
    //   144: astore_1
    //   145: new 31	com/facebook/stetho/dumpapp/DumpException
    //   148: dup
    //   149: new 50	java/lang/StringBuilder
    //   152: dup
    //   153: ldc -73
    //   155: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload_1
    //   159: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: astore_1
    //   170: new 31	com/facebook/stetho/dumpapp/DumpException
    //   173: dup
    //   174: new 50	java/lang/StringBuilder
    //   177: dup
    //   178: ldc -73
    //   180: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_1
    //   184: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: astore_1
    //   195: new 31	com/facebook/stetho/dumpapp/DumpException
    //   198: dup
    //   199: new 50	java/lang/StringBuilder
    //   202: dup
    //   203: ldc -73
    //   205: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload_1
    //   209: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   218: athrow
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 187	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   224: invokestatic 193	com/facebook/stetho/common/ExceptionUtil:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	CrashDumperPlugin
    //   0	228	1	paramIterator	Iterator<String>
    //   25	6	2	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   7	26	94	java/lang/ClassNotFoundException
    //   30	47	94	java/lang/ClassNotFoundException
    //   47	71	94	java/lang/ClassNotFoundException
    //   72	91	94	java/lang/ClassNotFoundException
    //   7	26	119	java/lang/ClassCastException
    //   30	47	119	java/lang/ClassCastException
    //   47	71	119	java/lang/ClassCastException
    //   72	91	119	java/lang/ClassCastException
    //   7	26	144	java/lang/NoSuchMethodException
    //   30	47	144	java/lang/NoSuchMethodException
    //   47	71	144	java/lang/NoSuchMethodException
    //   72	91	144	java/lang/NoSuchMethodException
    //   7	26	169	java/lang/IllegalAccessException
    //   30	47	169	java/lang/IllegalAccessException
    //   47	71	169	java/lang/IllegalAccessException
    //   72	91	169	java/lang/IllegalAccessException
    //   7	26	194	java/lang/InstantiationException
    //   30	47	194	java/lang/InstantiationException
    //   47	71	194	java/lang/InstantiationException
    //   72	91	194	java/lang/InstantiationException
    //   7	26	219	java/lang/reflect/InvocationTargetException
    //   30	47	219	java/lang/reflect/InvocationTargetException
    //   47	71	219	java/lang/reflect/InvocationTargetException
    //   72	91	219	java/lang/reflect/InvocationTargetException
  }
  
  private void doUsage(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Usage: dumpapp crash " + "<command> [command-options]");
    paramPrintStream.println("Usage: dumpapp crash " + "throw");
    paramPrintStream.println("       dumpapp crash " + "kill");
    paramPrintStream.println("       dumpapp crash " + "exit");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash throw: Throw an uncaught exception (simulates a program crash)");
    paramPrintStream.println("    <Throwable>: Throwable class to use (default: java.lang.Error)");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash kill: Send a signal to this process (simulates the low memory killer)");
    paramPrintStream.println("    <SIGNAL>: Either signal name or number to send (default: 9)");
    paramPrintStream.println("              See `adb shell kill -l` for more information");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash exit: Invoke System.exit (simulates an abnormal Android exit strategy)");
    paramPrintStream.println("    <code>: Exit code (default: 0)");
  }
  
  @Nullable
  private static <T> Constructor<? extends T> tryGetDeclaredConstructor(Class<T> paramClass, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(paramVarArgs);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    Iterator localIterator = paramDumperContext.getArgsAsList().iterator();
    String str = ArgsHelper.nextOptionalArg(localIterator, null);
    if ("throw".equals(str)) {
      doUncaughtException(localIterator);
    }
    do
    {
      return;
      if ("kill".equals(str))
      {
        doKill(paramDumperContext, localIterator);
        return;
      }
      if ("exit".equals(str))
      {
        doSystemExit(localIterator);
        return;
      }
      doUsage(paramDumperContext.getStdout());
    } while (str == null);
    throw new DumpUsageException("Unsupported command: " + str);
  }
  
  public String getName()
  {
    return "crash";
  }
  
  private static class ThrowRunnable
    implements Runnable
  {
    private final Throwable mThrowable;
    
    public ThrowRunnable(Throwable paramThrowable)
    {
      this.mThrowable = paramThrowable;
    }
    
    public void run()
    {
      ExceptionUtil.sneakyThrow(this.mThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\dumpapp\plugins\CrashDumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */