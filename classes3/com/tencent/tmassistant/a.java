package com.tencent.tmassistant;

import android.content.Context;
import com.tencent.tmassistantsdk.internal.b.b;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  protected static a a = null;
  protected static ArrayList<TMAssistantDownloadClient> c = new ArrayList();
  protected static ArrayList<b> d = new ArrayList();
  protected Context b = null;
  
  protected a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public b a(String paramString)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = d.iterator();
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          boolean bool = localb.mClientKey.equals(paramString);
          if (bool == true)
          {
            paramString = localb;
            return paramString;
          }
        }
        else
        {
          paramString = new b(this.b, paramString, "com.tencent.android.qqdownloader.SDKService");
          if (paramString.initTMAssistantDownloadSDK()) {
            d.add(paramString);
          } else {
            paramString = null;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	com/tencent/tmassistant/a:c	Ljava/util/ArrayList;
    //   5: invokevirtual 39	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   8: astore_2
    //   9: aload_2
    //   10: invokeinterface 45 1 0
    //   15: ifeq +47 -> 62
    //   18: aload_2
    //   19: invokeinterface 49 1 0
    //   24: checkcast 75	com/tencent/tmdownloader/TMAssistantDownloadClient
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull -20 -> 9
    //   32: aload_3
    //   33: getfield 76	com/tencent/tmdownloader/TMAssistantDownloadClient:mClientKey	Ljava/lang/String;
    //   36: aload_1
    //   37: invokevirtual 61	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: iconst_1
    //   41: if_icmpne -32 -> 9
    //   44: aload_3
    //   45: invokevirtual 79	com/tencent/tmdownloader/TMAssistantDownloadClient:unInitTMAssistantDownloadSDK	()V
    //   48: aload_2
    //   49: invokeinterface 82 1 0
    //   54: iconst_1
    //   55: istore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: iload 4
    //   61: ireturn
    //   62: iconst_0
    //   63: istore 4
    //   65: goto -8 -> 57
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	a
    //   0	73	1	paramString	String
    //   8	41	2	localIterator	Iterator
    //   27	18	3	localTMAssistantDownloadClient	TMAssistantDownloadClient
    //   55	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	68	finally
    //   9	28	68	finally
    //   32	54	68	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */