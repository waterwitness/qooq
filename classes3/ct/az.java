package ct;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

public final class az
{
  private static az b = new az();
  ba a;
  private int c = 20000;
  private Socket d;
  private int e = -1;
  private s f;
  private OutputStream g;
  private InputStream h;
  private int i = -1;
  private int j = -1;
  private long k = -1L;
  private int l = -1;
  private int m = -1;
  
  public static az a()
  {
    try
    {
      az localaz = b;
      return localaz;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      a(paramInt, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    try
    {
      if ((paramInt != this.e) && (this.a != null))
      {
        this.a.e = paramInt;
        if (paramString != null) {
          this.a.f = paramString;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  final boolean a(ba paramba)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: iconst_0
    //   5: istore 5
    //   7: iload 5
    //   9: ifne +271 -> 280
    //   12: aload_1
    //   13: ifnull +138 -> 151
    //   16: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   19: aload_1
    //   20: getfield 74	ct/ba:l	J
    //   23: lsub
    //   24: aload_1
    //   25: getfield 75	ct/ba:m	I
    //   28: i2l
    //   29: lcmp
    //   30: ifge +121 -> 151
    //   33: iconst_0
    //   34: istore 4
    //   36: iload 4
    //   38: ifne +242 -> 280
    //   41: iload_3
    //   42: iconst_5
    //   43: if_icmpge +237 -> 280
    //   46: iload_3
    //   47: iconst_1
    //   48: iadd
    //   49: istore 4
    //   51: aload_0
    //   52: invokevirtual 78	ct/az:c	()Z
    //   55: istore 6
    //   57: iload 6
    //   59: ifeq +211 -> 270
    //   62: new 80	java/lang/StringBuilder
    //   65: dup
    //   66: ldc 82
    //   68: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: aload_1
    //   72: getfield 87	ct/ba:d	I
    //   75: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc 93
    //   80: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 98	ct/az:d	Ljava/net/Socket;
    //   87: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: invokestatic 105	ct/bc:b	()V
    //   94: aload_1
    //   95: getfield 108	ct/ba:b	[B
    //   98: astore_2
    //   99: aload_0
    //   100: getfield 110	ct/az:g	Ljava/io/OutputStream;
    //   103: aload_2
    //   104: iconst_0
    //   105: aload_2
    //   106: arraylength
    //   107: invokevirtual 116	java/io/OutputStream:write	([BII)V
    //   110: aload_0
    //   111: getfield 110	ct/az:g	Ljava/io/OutputStream;
    //   114: invokevirtual 119	java/io/OutputStream:flush	()V
    //   117: aload_0
    //   118: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   121: putfield 46	ct/az:k	J
    //   124: new 80	java/lang/StringBuilder
    //   127: dup
    //   128: ldc 121
    //   130: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_2
    //   134: arraylength
    //   135: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: invokestatic 123	ct/bc:a	()V
    //   142: iconst_1
    //   143: istore 5
    //   145: iload 4
    //   147: istore_3
    //   148: goto -141 -> 7
    //   151: iconst_1
    //   152: istore 4
    //   154: goto -118 -> 36
    //   157: astore_2
    //   158: aload_1
    //   159: bipush -5
    //   161: putfield 60	ct/ba:e	I
    //   164: aload_1
    //   165: aload_2
    //   166: invokestatic 128	ct/be:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   169: putfield 63	ct/ba:f	Ljava/lang/String;
    //   172: iload 4
    //   174: istore_3
    //   175: iload 5
    //   177: ifne -170 -> 7
    //   180: aload_0
    //   181: aload_1
    //   182: getfield 60	ct/ba:e	I
    //   185: invokespecial 130	ct/az:a	(I)V
    //   188: aload_0
    //   189: getfield 110	ct/az:g	Ljava/io/OutputStream;
    //   192: invokevirtual 133	java/io/OutputStream:close	()V
    //   195: aload_0
    //   196: getfield 98	ct/az:d	Ljava/net/Socket;
    //   199: invokevirtual 136	java/net/Socket:close	()V
    //   202: aload_0
    //   203: invokevirtual 138	ct/az:e	()V
    //   206: iload 4
    //   208: istore_3
    //   209: goto -202 -> 7
    //   212: astore_2
    //   213: aload_2
    //   214: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   217: iload 4
    //   219: istore_3
    //   220: goto -213 -> 7
    //   223: astore_1
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_1
    //   227: athrow
    //   228: astore_2
    //   229: iload 5
    //   231: ifne +29 -> 260
    //   234: aload_0
    //   235: aload_1
    //   236: getfield 60	ct/ba:e	I
    //   239: invokespecial 130	ct/az:a	(I)V
    //   242: aload_0
    //   243: getfield 110	ct/az:g	Ljava/io/OutputStream;
    //   246: invokevirtual 133	java/io/OutputStream:close	()V
    //   249: aload_0
    //   250: getfield 98	ct/az:d	Ljava/net/Socket;
    //   253: invokevirtual 136	java/net/Socket:close	()V
    //   256: aload_0
    //   257: invokevirtual 138	ct/az:e	()V
    //   260: aload_2
    //   261: athrow
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   267: goto -7 -> 260
    //   270: aload_0
    //   271: invokevirtual 138	ct/az:e	()V
    //   274: iload 4
    //   276: istore_3
    //   277: goto -270 -> 7
    //   280: aload_0
    //   281: monitorexit
    //   282: iload 5
    //   284: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	az
    //   0	285	1	paramba	ba
    //   98	36	2	arrayOfByte	byte[]
    //   157	9	2	localException1	Exception
    //   212	2	2	localException2	Exception
    //   228	33	2	localObject	Object
    //   3	274	3	n	int
    //   34	241	4	i1	int
    //   5	278	5	bool1	boolean
    //   55	3	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   62	142	157	java/lang/Exception
    //   180	206	212	java/lang/Exception
    //   16	33	223	finally
    //   51	57	223	finally
    //   180	206	223	finally
    //   213	217	223	finally
    //   234	260	223	finally
    //   260	262	223	finally
    //   263	267	223	finally
    //   270	274	223	finally
    //   62	142	228	finally
    //   158	172	228	finally
    //   234	260	262	java/lang/Exception
  }
  
  final void b()
  {
    int n = 0;
    long l1;
    int i1;
    int i2;
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        try
        {
          new StringBuilder("doReadData: try read data...sk:").append(this.d);
          bc.b();
          byte[] arrayOfByte = new byte[4];
          i1 = n;
          if (n < 4)
          {
            bc.a();
            i2 = this.h.read(arrayOfByte, n, 4 - n);
            if (i2 <= 0) {
              continue;
            }
            this.l = ((int)(System.currentTimeMillis() - this.k));
            i1 = n + i2;
            n = i1;
            if (i1 != 4) {
              continue;
            }
          }
          if (i1 != 4) {
            continue;
          }
          n = be.a(arrayOfByte);
          if ((n > 4) && (n <= 524288)) {
            break;
          }
          a(-6, "packSizeFail:" + n);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          a(-7, be.a(localException1));
          continue;
        }
        return;
      }
      finally {}
      i1 = n;
      if (i2 != -1)
      {
        continue;
        a(-6, "readLen fail:" + i1);
      }
    }
    Object localObject2 = new byte[n];
    System.arraycopy(localObject1, 0, localObject2, 0, 4);
    long l2 = System.currentTimeMillis();
    label229:
    while (i1 < n)
    {
      bc.a();
      i2 = this.h.read((byte[])localObject2, i1, n - i1);
      bc.a();
      if (i2 <= 0) {
        break label571;
      }
      i1 += i2;
    }
    for (;;)
    {
      if (i1 != n)
      {
        new StringBuilder("read fail. readLen:").append(i1).append(",packSize:").append(n);
        bc.c();
        a(-6, "readLen != packSize,rspBuff:" + be.b((byte[])localObject2));
        break;
      }
      this.m = ((int)(System.currentTimeMillis() - l2));
      bc.b();
      bj localbj = new bj();
      try
      {
        if (localObject2.length >= 4) {
          break label389;
        }
        throw new IllegalArgumentException("decode package must include size head");
      }
      catch (Exception localException2)
      {
        a(-8, be.a(localException2));
      }
      break;
      try
      {
        label389:
        localObject2 = new bg((byte[])localObject2, (byte)0);
        ((bg)localObject2).b = localException2.b;
        localException2.c.a((bg)localObject2);
        localObject2 = new bg(localException2.c.e);
        ((bg)localObject2).b = localException2.b;
        if (bj.d == null)
        {
          localHashMap = new HashMap();
          bj.d = localHashMap;
          localHashMap.put("", new byte[0]);
        }
        HashMap localHashMap = bj.d;
        localException2.a = ((HashMap)((bg)localObject2).a(new HashMap(), localHashMap, 0, false));
        if (this.a == null) {
          break;
        }
        this.a.c = localException2;
        this.a.e = 0;
        this.m = ((int)(System.currentTimeMillis() - l1));
        this.a.i = this.l;
        this.a.g = this.j;
        this.a.j = this.m;
      }
      catch (Exception localException3)
      {
        throw new RuntimeException(localException3);
      }
      label571:
      if (i2 != -1) {
        break label229;
      }
    }
  }
  
  final boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.d != null)
      {
        bool1 = bool2;
        if (this.d.isConnected())
        {
          bool1 = bool2;
          if (!this.d.isClosed())
          {
            OutputStream localOutputStream = this.g;
            bool1 = bool2;
            if (localOutputStream != null) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	ct/az:h	Ljava/io/InputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 145	ct/az:h	Ljava/io/InputStream;
    //   15: invokevirtual 243	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 145	ct/az:h	Ljava/io/InputStream;
    //   23: aload_0
    //   24: getfield 110	ct/az:g	Ljava/io/OutputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: getfield 110	ct/az:g	Ljava/io/OutputStream;
    //   36: invokevirtual 133	java/io/OutputStream:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 110	ct/az:g	Ljava/io/OutputStream;
    //   44: aload_0
    //   45: getfield 98	ct/az:d	Ljava/net/Socket;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +15 -> 65
    //   53: aload_0
    //   54: getfield 98	ct/az:d	Ljava/net/Socket;
    //   57: invokevirtual 136	java/net/Socket:close	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 98	ct/az:d	Ljava/net/Socket;
    //   65: invokestatic 246	ct/ax:a	()V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 145	ct/az:h	Ljava/io/InputStream;
    //   77: goto -54 -> 23
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 145	ct/az:h	Ljava/io/InputStream;
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 110	ct/az:g	Ljava/io/OutputStream;
    //   99: goto -55 -> 44
    //   102: astore_1
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 110	ct/az:g	Ljava/io/OutputStream;
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 98	ct/az:d	Ljava/net/Socket;
    //   116: goto -51 -> 65
    //   119: astore_1
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 98	ct/az:d	Ljava/net/Socket;
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	az
    //   6	44	1	localObject1	Object
    //   71	1	1	localException1	Exception
    //   80	4	1	localObject2	Object
    //   85	7	1	localObject3	Object
    //   93	1	1	localException2	Exception
    //   102	7	1	localObject4	Object
    //   110	1	1	localException3	Exception
    //   119	7	1	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	71	java/lang/Exception
    //   2	7	80	finally
    //   18	23	80	finally
    //   23	28	80	finally
    //   39	44	80	finally
    //   44	49	80	finally
    //   60	65	80	finally
    //   65	68	80	finally
    //   72	77	80	finally
    //   86	93	80	finally
    //   94	99	80	finally
    //   103	110	80	finally
    //   111	116	80	finally
    //   120	127	80	finally
    //   11	18	85	finally
    //   32	39	93	java/lang/Exception
    //   32	39	102	finally
    //   53	60	110	java/lang/Exception
    //   53	60	119	finally
  }
  
  /* Error */
  final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 173	ct/bc:c	()V
    //   5: new 248	ct/ay
    //   8: dup
    //   9: invokespecial 249	ct/ay:<init>	()V
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 57	ct/az:a	Lct/ba;
    //   17: getfield 75	ct/ba:m	I
    //   20: ifle +346 -> 366
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 57	ct/az:a	Lct/ba;
    //   28: getfield 75	ct/ba:m	I
    //   31: putfield 250	ct/ay:c	I
    //   34: invokestatic 255	ct/b:a	()Lct/b;
    //   37: getfield 258	ct/b:b	Lct/d;
    //   40: getfield 261	ct/d:d	I
    //   43: istore 4
    //   45: iload 4
    //   47: ifle +21 -> 68
    //   50: iload 4
    //   52: iconst_4
    //   53: if_icmpge +15 -> 68
    //   56: aload_1
    //   57: iload 4
    //   59: putfield 263	ct/ay:a	I
    //   62: aload_1
    //   63: iload 4
    //   65: putfield 265	ct/ay:b	I
    //   68: getstatic 270	ct/c:a	[I
    //   71: astore_2
    //   72: aload_1
    //   73: ldc_w 272
    //   76: putfield 273	ct/ay:f	Ljava/lang/String;
    //   79: aload_2
    //   80: invokestatic 276	ct/ay:a	([I)V
    //   83: invokestatic 281	ct/u:a	()Lct/u;
    //   86: ldc_w 272
    //   89: invokevirtual 284	ct/u:a	(Ljava/lang/String;)Lct/t$a;
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +25 -> 119
    //   97: new 286	java/util/ArrayList
    //   100: dup
    //   101: invokespecial 287	java/util/ArrayList:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: aload_2
    //   107: getfield 292	ct/t$a:c	Ljava/util/List;
    //   110: invokevirtual 296	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   113: pop
    //   114: aload_1
    //   115: aload_3
    //   116: putfield 299	ct/ay:d	Ljava/util/ArrayList;
    //   119: invokestatic 255	ct/b:a	()Lct/b;
    //   122: getfield 302	ct/b:a	Lct/c;
    //   125: getfield 304	ct/c:b	J
    //   128: lconst_0
    //   129: lcmp
    //   130: ifle +11 -> 141
    //   133: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   136: pop2
    //   137: invokestatic 255	ct/b:a	()Lct/b;
    //   140: pop
    //   141: aload_1
    //   142: invokestatic 255	ct/b:a	()Lct/b;
    //   145: getfield 302	ct/b:a	Lct/c;
    //   148: invokevirtual 307	ct/c:c	()Ljava/util/ArrayList;
    //   151: putfield 309	ct/ay:e	Ljava/util/ArrayList;
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 42	ct/az:j	I
    //   159: aload_1
    //   160: invokevirtual 310	ct/ay:a	()V
    //   163: aload_0
    //   164: aload_1
    //   165: getfield 311	ct/ay:j	I
    //   168: putfield 40	ct/az:i	I
    //   171: aload_0
    //   172: aload_1
    //   173: getfield 313	ct/ay:k	I
    //   176: putfield 42	ct/az:j	I
    //   179: aload_0
    //   180: getfield 57	ct/az:a	Lct/ba;
    //   183: aload_0
    //   184: getfield 40	ct/az:i	I
    //   187: putfield 315	ct/ba:h	I
    //   190: aload_0
    //   191: getfield 57	ct/az:a	Lct/ba;
    //   194: aload_0
    //   195: getfield 42	ct/az:j	I
    //   198: putfield 230	ct/ba:g	I
    //   201: aload_1
    //   202: getfield 316	ct/ay:h	I
    //   205: ifne +295 -> 500
    //   208: aload_0
    //   209: aload_1
    //   210: getfield 318	ct/ay:g	Ljava/net/Socket;
    //   213: putfield 98	ct/az:d	Ljava/net/Socket;
    //   216: aload_0
    //   217: aload_1
    //   218: getfield 320	ct/ay:l	Lct/s;
    //   221: putfield 322	ct/az:f	Lct/s;
    //   224: aload_0
    //   225: getfield 57	ct/az:a	Lct/ba;
    //   228: aload_0
    //   229: getfield 322	ct/az:f	Lct/s;
    //   232: putfield 324	ct/ba:k	Lct/s;
    //   235: new 80	java/lang/StringBuilder
    //   238: dup
    //   239: ldc_w 326
    //   242: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 98	ct/az:d	Ljava/net/Socket;
    //   249: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: ldc_w 328
    //   255: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 322	ct/az:f	Lct/s;
    //   262: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: invokestatic 173	ct/bc:c	()V
    //   269: aload_0
    //   270: getfield 98	ct/az:d	Ljava/net/Socket;
    //   273: ifnull +160 -> 433
    //   276: aload_0
    //   277: getfield 98	ct/az:d	Ljava/net/Socket;
    //   280: invokevirtual 239	java/net/Socket:isConnected	()Z
    //   283: ifeq +150 -> 433
    //   286: aload_0
    //   287: getfield 98	ct/az:d	Ljava/net/Socket;
    //   290: invokevirtual 242	java/net/Socket:isClosed	()Z
    //   293: istore 5
    //   295: iload 5
    //   297: ifne +136 -> 433
    //   300: aload_0
    //   301: getfield 98	ct/az:d	Ljava/net/Socket;
    //   304: aload_0
    //   305: getfield 36	ct/az:c	I
    //   308: invokevirtual 331	java/net/Socket:setSoTimeout	(I)V
    //   311: aload_0
    //   312: getfield 98	ct/az:d	Ljava/net/Socket;
    //   315: ldc -101
    //   317: invokevirtual 334	java/net/Socket:setReceiveBufferSize	(I)V
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 98	ct/az:d	Ljava/net/Socket;
    //   325: invokevirtual 338	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   328: putfield 110	ct/az:g	Ljava/io/OutputStream;
    //   331: aload_0
    //   332: aload_0
    //   333: getfield 98	ct/az:d	Ljava/net/Socket;
    //   336: invokevirtual 342	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   339: putfield 145	ct/az:h	Ljava/io/InputStream;
    //   342: new 80	java/lang/StringBuilder
    //   345: dup
    //   346: ldc_w 344
    //   349: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: aload_0
    //   353: getfield 98	ct/az:d	Ljava/net/Socket;
    //   356: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: invokestatic 105	ct/bc:b	()V
    //   363: aload_0
    //   364: monitorexit
    //   365: return
    //   366: aload_1
    //   367: invokestatic 255	ct/b:a	()Lct/b;
    //   370: getfield 258	ct/b:b	Lct/d;
    //   373: getfield 345	ct/d:a	I
    //   376: putfield 250	ct/ay:c	I
    //   379: goto -345 -> 34
    //   382: astore_1
    //   383: aload_0
    //   384: monitorexit
    //   385: aload_1
    //   386: athrow
    //   387: astore_1
    //   388: aload_1
    //   389: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   392: new 80	java/lang/StringBuilder
    //   395: dup
    //   396: ldc_w 347
    //   399: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   402: aload_0
    //   403: getfield 98	ct/az:d	Ljava/net/Socket;
    //   406: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: invokestatic 349	ct/bc:d	()V
    //   413: aload_0
    //   414: bipush -3
    //   416: aload_1
    //   417: invokestatic 128	ct/be:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   420: invokespecial 55	ct/az:a	(ILjava/lang/String;)V
    //   423: aload_0
    //   424: invokevirtual 350	ct/az:d	()V
    //   427: goto -64 -> 363
    //   430: astore_1
    //   431: aload_1
    //   432: athrow
    //   433: aload_0
    //   434: getfield 98	ct/az:d	Ljava/net/Socket;
    //   437: ifnonnull +15 -> 452
    //   440: aload_0
    //   441: bipush -3
    //   443: ldc_w 352
    //   446: invokespecial 55	ct/az:a	(ILjava/lang/String;)V
    //   449: goto -86 -> 363
    //   452: aload_0
    //   453: bipush -3
    //   455: new 80	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 354
    //   462: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: aload_0
    //   466: getfield 98	ct/az:d	Ljava/net/Socket;
    //   469: invokevirtual 239	java/net/Socket:isConnected	()Z
    //   472: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   475: ldc_w 359
    //   478: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_0
    //   482: getfield 98	ct/az:d	Ljava/net/Socket;
    //   485: invokevirtual 242	java/net/Socket:isClosed	()Z
    //   488: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   491: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokespecial 55	ct/az:a	(ILjava/lang/String;)V
    //   497: goto -134 -> 363
    //   500: invokestatic 363	ct/bb:e	()Z
    //   503: ifeq +63 -> 566
    //   506: ldc_w 365
    //   509: invokestatic 370	ct/i:b	(Ljava/lang/String;)Z
    //   512: ifeq +45 -> 557
    //   515: aload_0
    //   516: bipush -3
    //   518: new 80	java/lang/StringBuilder
    //   521: dup
    //   522: ldc_w 372
    //   525: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   528: aload_1
    //   529: getfield 316	ct/ay:h	I
    //   532: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: ldc_w 374
    //   538: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_1
    //   542: getfield 376	ct/ay:i	Ljava/lang/String;
    //   545: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokespecial 55	ct/az:a	(ILjava/lang/String;)V
    //   554: goto -191 -> 363
    //   557: aload_0
    //   558: bipush -16
    //   560: invokespecial 130	ct/az:a	(I)V
    //   563: goto -200 -> 363
    //   566: aload_0
    //   567: bipush -4
    //   569: invokespecial 130	ct/az:a	(I)V
    //   572: goto -209 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	az
    //   12	355	1	localay	ay
    //   382	4	1	localObject1	Object
    //   387	30	1	localException	Exception
    //   430	112	1	localObject2	Object
    //   71	36	2	localObject3	Object
    //   104	12	3	localArrayList	java.util.ArrayList
    //   43	21	4	n	int
    //   293	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	34	382	finally
    //   34	45	382	finally
    //   56	68	382	finally
    //   68	93	382	finally
    //   97	119	382	finally
    //   119	141	382	finally
    //   141	295	382	finally
    //   366	379	382	finally
    //   431	433	382	finally
    //   433	449	382	finally
    //   452	497	382	finally
    //   500	554	382	finally
    //   557	563	382	finally
    //   566	572	382	finally
    //   300	363	387	java/lang/Exception
    //   300	363	430	finally
    //   388	427	430	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */