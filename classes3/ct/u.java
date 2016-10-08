package ct;

import android.text.TextUtils;

public final class u
{
  private static u b;
  public v a = w.a();
  private t c;
  
  private u()
  {
    a(false);
  }
  
  public static u a()
  {
    try
    {
      if (b == null) {
        b = new u();
      }
      u localu = b;
      return localu;
    }
    finally {}
  }
  
  /* Error */
  public final t.a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: invokevirtual 24	ct/u:a	(Z)V
    //   7: aload_0
    //   8: getfield 32	ct/u:c	Lct/t;
    //   11: ifnull +40 -> 51
    //   14: aload_0
    //   15: getfield 32	ct/u:c	Lct/t;
    //   18: getfield 37	ct/t:a	Ljava/lang/String;
    //   21: invokestatic 42	ct/bb:a	()Ljava/lang/String;
    //   24: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +24 -> 51
    //   30: aload_0
    //   31: getfield 32	ct/u:c	Lct/t;
    //   34: getfield 51	ct/t:b	Ljava/util/Map;
    //   37: aload_1
    //   38: invokeinterface 57 2 0
    //   43: checkcast 59	ct/t$a
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aconst_null
    //   52: astore_1
    //   53: goto -6 -> 47
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	u
    //   0	61	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	47	56	finally
  }
  
  /* Error */
  public final void a(t paramt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 64	ct/bc:b	()V
    //   5: aload_1
    //   6: ifnonnull +9 -> 15
    //   9: invokestatic 66	ct/bc:c	()V
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 32	ct/u:c	Lct/t;
    //   20: aload_0
    //   21: getfield 21	ct/u:a	Lct/v;
    //   24: aload_1
    //   25: invokeinterface 70 2 0
    //   30: goto -18 -> 12
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	u
    //   0	38	1	paramt	t
    // Exception table:
    //   from	to	target	type
    //   2	5	33	finally
    //   9	12	33	finally
    //   15	30	33	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        String str = bb.a();
        bc.a();
        if ((TextUtils.isEmpty(str)) || (str.equals("unknown")))
        {
          bc.c();
          return;
        }
        if ((this.c != null) && (this.c.a.equals(str)) && (!paramBoolean)) {
          break label94;
        }
        this.c = this.a.a(str);
        if (this.c != null)
        {
          bc.a();
          continue;
        }
        bc.c();
      }
      finally {}
      continue;
      label94:
      bc.b();
    }
  }
  
  /* Error */
  public final boolean a(java.util.Set paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 64	ct/bc:b	()V
    //   5: aload_0
    //   6: iconst_0
    //   7: invokevirtual 24	ct/u:a	(Z)V
    //   10: aload_0
    //   11: getfield 32	ct/u:c	Lct/t;
    //   14: ifnonnull +14 -> 28
    //   17: invokestatic 64	ct/bc:b	()V
    //   20: iconst_1
    //   21: istore 5
    //   23: aload_0
    //   24: monitorexit
    //   25: iload 5
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 32	ct/u:c	Lct/t;
    //   32: getfield 51	ct/t:b	Ljava/util/Map;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnonnull +12 -> 49
    //   40: invokestatic 64	ct/bc:b	()V
    //   43: iconst_1
    //   44: istore 5
    //   46: goto -23 -> 23
    //   49: aload_2
    //   50: invokeinterface 88 1 0
    //   55: aload_1
    //   56: invokeinterface 91 1 0
    //   61: if_icmpge +31 -> 92
    //   64: new 93	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 95
    //   70: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: invokeinterface 88 1 0
    //   79: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: invokestatic 64	ct/bc:b	()V
    //   86: iconst_1
    //   87: istore 5
    //   89: goto -66 -> 23
    //   92: aload_1
    //   93: invokeinterface 106 1 0
    //   98: astore_1
    //   99: aload_1
    //   100: invokeinterface 112 1 0
    //   105: ifeq +66 -> 171
    //   108: aload_1
    //   109: invokeinterface 116 1 0
    //   114: checkcast 44	java/lang/String
    //   117: astore_3
    //   118: aload_2
    //   119: aload_3
    //   120: invokeinterface 57 2 0
    //   125: checkcast 59	ct/t$a
    //   128: astore 4
    //   130: aload 4
    //   132: ifnull +11 -> 143
    //   135: aload 4
    //   137: invokevirtual 118	ct/t$a:b	()Z
    //   140: ifeq -41 -> 99
    //   143: new 93	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 120
    //   149: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_3
    //   153: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 125
    //   158: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: invokestatic 64	ct/bc:b	()V
    //   165: iconst_1
    //   166: istore 5
    //   168: goto -145 -> 23
    //   171: iconst_0
    //   172: istore 5
    //   174: goto -151 -> 23
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	u
    //   0	182	1	paramSet	java.util.Set
    //   35	84	2	localMap	java.util.Map
    //   117	36	3	str	String
    //   128	8	4	locala	t.a
    //   21	152	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	177	finally
    //   28	36	177	finally
    //   40	43	177	finally
    //   49	86	177	finally
    //   92	99	177	finally
    //   99	130	177	finally
    //   135	143	177	finally
    //   143	165	177	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */