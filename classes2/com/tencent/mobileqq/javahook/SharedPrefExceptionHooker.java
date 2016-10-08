package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import swy;

public class SharedPrefExceptionHooker
{
  private static swy a = new swy(null);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 31
    //   2: invokestatic 37	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_0
    //   6: aload_0
    //   7: ldc 39
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: getstatic 22	com/tencent/mobileqq/javahook/SharedPrefExceptionHooker:a	Lswy;
    //   18: aastore
    //   19: invokestatic 45	com/tencent/mobileqq/javahooksdk/JavaHookBridge:findAndHookMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: ldc 47
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc 49
    //   33: invokestatic 37	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: getstatic 22	com/tencent/mobileqq/javahook/SharedPrefExceptionHooker:a	Lswy;
    //   42: aastore
    //   43: invokestatic 45	com/tencent/mobileqq/javahooksdk/JavaHookBridge:findAndHookMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: return
    //   47: astore_0
    //   48: aload_0
    //   49: invokestatic 54	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Throwable;)V
    //   52: return
    //   53: astore_1
    //   54: aload_1
    //   55: invokestatic 54	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Throwable;)V
    //   58: goto -36 -> 22
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic 54	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Throwable;)V
    //   66: return
    //   67: astore_0
    //   68: aload_0
    //   69: invokestatic 54	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Throwable;)V
    //   72: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	18	0	localClass	Class
    //   47	2	0	localClassNotFoundException1	ClassNotFoundException
    //   61	2	0	localClassNotFoundException2	ClassNotFoundException
    //   67	2	0	localNoSuchMethodException1	NoSuchMethodException
    //   53	2	1	localNoSuchMethodException2	NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   0	6	47	java/lang/ClassNotFoundException
    //   6	22	53	java/lang/NoSuchMethodException
    //   22	46	61	java/lang/ClassNotFoundException
    //   22	46	67	java/lang/NoSuchMethodException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\SharedPrefExceptionHooker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */