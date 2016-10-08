package com.tencent.beacon.upload;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.a.j;
import com.tencent.beacon.b.a.c;
import com.tencent.beacon.event.o;
import java.util.ArrayList;
import java.util.List;

public final class i
  implements h
{
  private static i a = null;
  private SparseArray<g> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private f d;
  private Context e = null;
  private boolean f = true;
  private boolean g = true;
  
  private i(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext != null) {}
    for (this.e = localContext;; this.e = paramContext)
    {
      this.f = paramBoolean;
      this.d = f.a(this.e);
      return;
    }
  }
  
  private static c a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.beacon.a.b.d.a();
        if (localObject == null) {
          break label85;
        }
        int i = ((com.tencent.beacon.a.b.d)localObject).k();
        paramArrayOfByte = com.tencent.beacon.a.f.b(paramArrayOfByte, ((com.tencent.beacon.a.b.d)localObject).l(), i, ((com.tencent.beacon.a.b.d)localObject).o());
        if (paramArrayOfByte != null)
        {
          localObject = new com.tencent.beacon.e.d();
          ((com.tencent.beacon.e.d)localObject).a(paramArrayOfByte);
          paramArrayOfByte = new c();
          com.tencent.beacon.d.a.b(" covert to ResponsePackage ", new Object[0]);
          paramArrayOfByte = (c)((com.tencent.beacon.e.d)localObject).b("detail", paramArrayOfByte);
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.beacon.d.a.a(paramArrayOfByte);
      }
      return null;
      label85:
      paramArrayOfByte = null;
    }
  }
  
  public static i a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new i(paramContext, true);
        com.tencent.beacon.d.a.h(" create uphandler up:true", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static i a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (a == null)
      {
        a = new i(paramContext, paramBoolean);
        com.tencent.beacon.d.a.h(" create uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (a.a() != paramBoolean)
      {
        a.b(paramBoolean);
        com.tencent.beacon.d.a.h(" change uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = c();
    if (arrayOfUploadHandleListener != null)
    {
      int j = arrayOfUploadHandleListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUploadHandleListener[i].onUploadEnd(paramInt1, paramInt2, paramLong1, paramLong2, paramBoolean, paramString);
        i += 1;
      }
    }
  }
  
  private static void a(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    if ((paramInt1 != 0) && (paramLong1 != 0L))
    {
      o localo = o.d();
      if ((localo != null) && (localo.d != null)) {
        localo.d.a(paramInt1, paramBoolean, paramLong2, paramLong1, paramInt2, paramInt3, paramString1, paramString2, paramInt4, paramString3);
      }
    }
  }
  
  private boolean a(SparseArray<g> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      paramSparseArray = (g)paramSparseArray.get(paramInt);
      if (paramSparseArray == null)
      {
        com.tencent.beacon.d.a.c(" no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      break;
    case 103: 
      try
      {
        com.tencent.beacon.d.a.a(" process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
        paramSparseArray = new com.tencent.beacon.e.a(paramArrayOfByte);
        paramArrayOfByte = new com.tencent.beacon.b.c.a();
        paramArrayOfByte.a(paramSparseArray);
        if (paramArrayOfByte.a != null)
        {
          j.a(this.e).a(paramArrayOfByte.a);
          new com.tencent.beacon.d.b(this.e).a(paramArrayOfByte.a);
        }
        com.tencent.beacon.d.a.h(" Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s ", new Object[] { paramArrayOfByte.a, paramArrayOfByte.b, paramArrayOfByte.d, paramArrayOfByte.e, paramArrayOfByte.c });
      }
      catch (Throwable paramSparseArray)
      {
        for (;;)
        {
          com.tencent.beacon.d.a.a(paramSparseArray);
        }
      }
      return true;
    }
    try
    {
      com.tencent.beacon.d.a.b(" key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      com.tencent.beacon.d.a.a(paramSparseArray);
      com.tencent.beacon.d.a.d(" handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static byte[] b(a parama)
  {
    if (parama != null) {
      try
      {
        Object localObject1 = parama.a();
        if (localObject1 != null)
        {
          com.tencent.beacon.d.a.b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((com.tencent.beacon.b.a.b)localObject1).b, ((com.tencent.beacon.b.a.b)localObject1).d, ((com.tencent.beacon.b.a.b)localObject1).c, Integer.valueOf(((com.tencent.beacon.b.a.b)localObject1).f) });
          Object localObject2 = new com.tencent.beacon.e.d();
          ((com.tencent.beacon.e.d)localObject2).a();
          ((com.tencent.beacon.e.d)localObject2).b("test");
          ((com.tencent.beacon.e.d)localObject2).a("test");
          ((com.tencent.beacon.e.d)localObject2).a("detail", localObject1);
          localObject1 = ((com.tencent.beacon.e.d)localObject2).b();
          localObject2 = com.tencent.beacon.a.b.d.a();
          if (localObject2 != null)
          {
            int i = ((com.tencent.beacon.a.b.d)localObject2).k();
            localObject1 = com.tencent.beacon.a.f.a((byte[])localObject1, ((com.tencent.beacon.a.b.d)localObject2).l(), i, ((com.tencent.beacon.a.b.d)localObject2).o());
            return (byte[])localObject1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.d(" parseSendDatas error", new Object[0]);
        com.tencent.beacon.d.a.a(localThrowable);
        parama.b();
      }
    }
    return null;
  }
  
  /* Error */
  private UploadHandleListener[] c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/beacon/upload/i:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 42	com/tencent/beacon/upload/i:c	Ljava/util/List;
    //   13: invokeinterface 275 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 42	com/tencent/beacon/upload/i:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 140	com/tencent/beacon/upload/UploadHandleListener
    //   29: invokeinterface 279 2 0
    //   34: checkcast 281	[Lcom/tencent/beacon/upload/UploadHandleListener;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	i
    //   37	7	1	arrayOfUploadHandleListener	UploadHandleListener[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private f d()
  {
    try
    {
      f localf = this.d;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private SparseArray<g> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/beacon/upload/i:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 37	com/tencent/beacon/upload/i:b	Landroid/util/SparseArray;
    //   13: invokevirtual 284	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 286	com/tencent/beacon/d/d
    //   22: dup
    //   23: invokespecial 287	com/tencent/beacon/d/d:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 37	com/tencent/beacon/upload/i:b	Landroid/util/SparseArray;
    //   31: invokestatic 290	com/tencent/beacon/d/d:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	i
    //   34	7	1	localSparseArray	SparseArray
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	44	finally
  }
  
  /* Error */
  public final void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 129	com/tencent/beacon/upload/i:a	()Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 296	com/tencent/beacon/upload/i:b	()Z
    //   11: ifne +64 -> 75
    //   14: aload_1
    //   15: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   18: iconst_2
    //   19: if_icmpne +18 -> 37
    //   22: ldc_w 300
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_1
    //   33: iconst_0
    //   34: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   37: aload_1
    //   38: getfield 303	com/tencent/beacon/upload/a:b	I
    //   41: ifeq +24 -> 65
    //   44: ldc_w 305
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   57: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: return
    //   65: ldc_w 307
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_0
    //   76: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   79: invokestatic 311	com/tencent/beacon/a/f:t	(Landroid/content/Context;)Z
    //   82: ifne +27 -> 109
    //   85: ldc_w 313
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_1
    //   96: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   99: iconst_2
    //   100: if_icmpne -36 -> 64
    //   103: aload_1
    //   104: iconst_0
    //   105: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   108: return
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   114: invokestatic 318	com/tencent/beacon/a/h:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/h;
    //   117: invokevirtual 321	com/tencent/beacon/upload/i:a	(Lcom/tencent/beacon/upload/UploadHandleListener;)Z
    //   120: pop
    //   121: aload_1
    //   122: ifnonnull +14 -> 136
    //   125: ldc_w 323
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: return
    //   136: aload_1
    //   137: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   140: istore 11
    //   142: aload_1
    //   143: invokevirtual 325	com/tencent/beacon/upload/a:e	()Ljava/lang/String;
    //   146: astore 4
    //   148: aload 4
    //   150: ifnull +17 -> 167
    //   153: ldc_w 327
    //   156: aload 4
    //   158: invokevirtual 332	java/lang/String:trim	()Ljava/lang/String;
    //   161: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +40 -> 204
    //   167: ldc_w 338
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_1
    //   178: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   181: iconst_2
    //   182: if_icmpne +8 -> 190
    //   185: aload_1
    //   186: iconst_0
    //   187: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   190: aload_0
    //   191: iload 11
    //   193: iconst_m1
    //   194: lconst_0
    //   195: lconst_0
    //   196: iconst_0
    //   197: ldc_w 340
    //   200: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   203: return
    //   204: aload_1
    //   205: invokestatic 344	com/tencent/beacon/upload/i:b	(Lcom/tencent/beacon/upload/a;)[B
    //   208: astore 6
    //   210: aload_1
    //   211: invokevirtual 346	com/tencent/beacon/upload/a:d	()Ljava/lang/String;
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_2
    //   217: aload_3
    //   218: ifnull +21 -> 239
    //   221: new 348	java/lang/StringBuilder
    //   224: dup
    //   225: ldc_w 350
    //   228: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload_3
    //   232: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore_2
    //   239: invokestatic 69	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   242: astore 5
    //   244: aload_2
    //   245: astore_3
    //   246: aload 5
    //   248: ifnull +53 -> 301
    //   251: aload 5
    //   253: invokevirtual 360	com/tencent/beacon/a/b/d:p	()Ljava/lang/String;
    //   256: astore 5
    //   258: aload_2
    //   259: astore_3
    //   260: aload 5
    //   262: ifnull +39 -> 301
    //   265: aload_2
    //   266: astore_3
    //   267: ldc_w 327
    //   270: aload 5
    //   272: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifne +26 -> 301
    //   278: aload_2
    //   279: ifnonnull +107 -> 386
    //   282: new 348	java/lang/StringBuilder
    //   285: dup
    //   286: ldc_w 362
    //   289: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload 5
    //   294: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore_3
    //   301: aload_3
    //   302: ifnull +1469 -> 1771
    //   305: new 348	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   312: aload 4
    //   314: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore_2
    //   325: ldc_w 365
    //   328: iconst_3
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: iload 11
    //   336: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: aload_2
    //   343: aastore
    //   344: dup
    //   345: iconst_2
    //   346: aload_1
    //   347: invokevirtual 220	java/lang/Object:getClass	()Ljava/lang/Class;
    //   350: invokevirtual 225	java/lang/Class:toString	()Ljava/lang/String;
    //   353: aastore
    //   354: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload 6
    //   359: ifnonnull +56 -> 415
    //   362: ldc_w 367
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: aload_0
    //   373: iload 11
    //   375: iconst_m1
    //   376: lconst_0
    //   377: lconst_0
    //   378: iconst_0
    //   379: ldc_w 369
    //   382: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   385: return
    //   386: new 348	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   393: aload_2
    //   394: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 371
    //   400: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload 5
    //   405: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: astore_3
    //   412: goto -111 -> 301
    //   415: aload_0
    //   416: invokespecial 373	com/tencent/beacon/upload/i:d	()Lcom/tencent/beacon/upload/f;
    //   419: astore 7
    //   421: aload 7
    //   423: ifnonnull +27 -> 450
    //   426: ldc_w 375
    //   429: iconst_0
    //   430: anewarray 4	java/lang/Object
    //   433: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: aload_0
    //   437: iload 11
    //   439: iconst_m1
    //   440: lconst_0
    //   441: lconst_0
    //   442: iconst_0
    //   443: ldc_w 377
    //   446: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   449: return
    //   450: aload_0
    //   451: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   454: invokestatic 380	com/tencent/beacon/a/f:k	(Landroid/content/Context;)Ljava/lang/String;
    //   457: astore 4
    //   459: new 382	com/tencent/beacon/upload/e
    //   462: dup
    //   463: invokespecial 383	com/tencent/beacon/upload/e:<init>	()V
    //   466: astore 5
    //   468: invokestatic 389	com/tencent/beacon/a/d:m	()Lcom/tencent/beacon/a/d;
    //   471: invokevirtual 392	com/tencent/beacon/a/d:h	()J
    //   474: new 394	java/util/Date
    //   477: dup
    //   478: invokespecial 395	java/util/Date:<init>	()V
    //   481: invokevirtual 398	java/util/Date:getTime	()J
    //   484: ladd
    //   485: ldc2_w 399
    //   488: ldiv
    //   489: lstore 14
    //   491: aload 7
    //   493: aload_2
    //   494: aload 6
    //   496: aload 5
    //   498: aload_1
    //   499: invokevirtual 403	com/tencent/beacon/upload/f:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/e;Lcom/tencent/beacon/upload/a;)[B
    //   502: astore_3
    //   503: aload_3
    //   504: ifnonnull +1262 -> 1766
    //   507: iload 11
    //   509: bipush 100
    //   511: if_icmpne +1255 -> 1766
    //   514: ldc_w 405
    //   517: aload_2
    //   518: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   521: ifne +1245 -> 1766
    //   524: aload 7
    //   526: ldc_w 405
    //   529: aload 6
    //   531: aload 5
    //   533: aload_1
    //   534: invokevirtual 403	com/tencent/beacon/upload/f:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/e;Lcom/tencent/beacon/upload/a;)[B
    //   537: astore_2
    //   538: aload 5
    //   540: invokevirtual 407	com/tencent/beacon/upload/e:a	()J
    //   543: lstore 16
    //   545: aload 5
    //   547: invokevirtual 409	com/tencent/beacon/upload/e:b	()J
    //   550: lstore 18
    //   552: aload_2
    //   553: invokestatic 411	com/tencent/beacon/upload/i:a	([B)Lcom/tencent/beacon/b/a/c;
    //   556: astore_2
    //   557: aload_2
    //   558: ifnull +1199 -> 1757
    //   561: aload_2
    //   562: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   565: istore 10
    //   567: aload_2
    //   568: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   571: istore 9
    //   573: iload 9
    //   575: ifne +147 -> 722
    //   578: iconst_1
    //   579: istore 20
    //   581: iload 10
    //   583: istore 9
    //   585: iload 20
    //   587: istore 21
    //   589: iload 20
    //   591: istore 22
    //   593: ldc_w 417
    //   596: iconst_2
    //   597: anewarray 4	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload_2
    //   603: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   606: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   609: aastore
    //   610: dup
    //   611: iconst_1
    //   612: aload_2
    //   613: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   616: invokestatic 422	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   619: aastore
    //   620: invokestatic 101	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   623: goto +1154 -> 1777
    //   626: iload 10
    //   628: istore 9
    //   630: iload 20
    //   632: istore 21
    //   634: iload 20
    //   636: istore 22
    //   638: aload_0
    //   639: iload 11
    //   641: iload 10
    //   643: lload 16
    //   645: lload 18
    //   647: iload 20
    //   649: aconst_null
    //   650: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   653: iload 10
    //   655: istore 9
    //   657: iload 20
    //   659: istore 21
    //   661: iload 20
    //   663: istore 22
    //   665: iload 11
    //   667: lload 16
    //   669: iload 20
    //   671: lload 14
    //   673: aload 5
    //   675: invokevirtual 424	com/tencent/beacon/upload/e:d	()J
    //   678: l2i
    //   679: aload_1
    //   680: invokevirtual 426	com/tencent/beacon/upload/a:f	()I
    //   683: aload 4
    //   685: aload 5
    //   687: invokevirtual 427	com/tencent/beacon/upload/e:e	()Ljava/lang/String;
    //   690: aload 5
    //   692: invokevirtual 428	com/tencent/beacon/upload/e:c	()I
    //   695: new 348	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   702: aload_2
    //   703: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   706: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   709: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 433	com/tencent/beacon/upload/i:a	(IJZJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   715: aload_1
    //   716: iload 20
    //   718: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   721: return
    //   722: iconst_0
    //   723: istore 20
    //   725: goto -144 -> 581
    //   728: iload 10
    //   730: istore 9
    //   732: iload 20
    //   734: istore 21
    //   736: iload 20
    //   738: istore 22
    //   740: invokestatic 389	com/tencent/beacon/a/d:m	()Lcom/tencent/beacon/a/d;
    //   743: astore_3
    //   744: aload_3
    //   745: ifnull +131 -> 876
    //   748: iload 10
    //   750: istore 9
    //   752: iload 20
    //   754: istore 21
    //   756: iload 20
    //   758: istore 22
    //   760: aload_2
    //   761: getfield 434	com/tencent/beacon/b/a/c:d	Ljava/lang/String;
    //   764: ifnull +26 -> 790
    //   767: iload 10
    //   769: istore 9
    //   771: iload 20
    //   773: istore 21
    //   775: iload 20
    //   777: istore 22
    //   779: aload_3
    //   780: aload_2
    //   781: getfield 434	com/tencent/beacon/b/a/c:d	Ljava/lang/String;
    //   784: invokevirtual 332	java/lang/String:trim	()Ljava/lang/String;
    //   787: invokevirtual 435	com/tencent/beacon/a/d:b	(Ljava/lang/String;)V
    //   790: iload 10
    //   792: istore 9
    //   794: iload 20
    //   796: istore 21
    //   798: iload 20
    //   800: istore 22
    //   802: new 394	java/util/Date
    //   805: dup
    //   806: invokespecial 395	java/util/Date:<init>	()V
    //   809: astore 6
    //   811: iload 10
    //   813: istore 9
    //   815: iload 20
    //   817: istore 21
    //   819: iload 20
    //   821: istore 22
    //   823: aload_3
    //   824: aload_2
    //   825: getfield 438	com/tencent/beacon/b/a/c:e	J
    //   828: aload 6
    //   830: invokevirtual 398	java/util/Date:getTime	()J
    //   833: lsub
    //   834: invokevirtual 441	com/tencent/beacon/a/d:a	(J)V
    //   837: iload 10
    //   839: istore 9
    //   841: iload 20
    //   843: istore 21
    //   845: iload 20
    //   847: istore 22
    //   849: ldc_w 443
    //   852: iconst_2
    //   853: anewarray 4	java/lang/Object
    //   856: dup
    //   857: iconst_0
    //   858: aload_3
    //   859: invokevirtual 445	com/tencent/beacon/a/d:g	()Ljava/lang/String;
    //   862: aastore
    //   863: dup
    //   864: iconst_1
    //   865: aload_3
    //   866: invokevirtual 392	com/tencent/beacon/a/d:h	()J
    //   869: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   872: aastore
    //   873: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   876: iload 10
    //   878: istore 9
    //   880: iload 20
    //   882: istore 21
    //   884: iload 20
    //   886: istore 22
    //   888: aload_2
    //   889: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   892: bipush 101
    //   894: if_icmpeq +45 -> 939
    //   897: iload 10
    //   899: istore 9
    //   901: iload 20
    //   903: istore 21
    //   905: iload 20
    //   907: istore 22
    //   909: aload_2
    //   910: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   913: bipush 103
    //   915: if_icmpeq +24 -> 939
    //   918: iload 10
    //   920: istore 9
    //   922: iload 20
    //   924: istore 21
    //   926: iload 20
    //   928: istore 22
    //   930: aload_2
    //   931: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   934: bipush 105
    //   936: if_icmpne +114 -> 1050
    //   939: iload 10
    //   941: istore 9
    //   943: iload 20
    //   945: istore 21
    //   947: iload 20
    //   949: istore 22
    //   951: aload_0
    //   952: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   955: invokestatic 455	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   958: invokevirtual 457	com/tencent/beacon/a/b/b:e	()Lcom/tencent/beacon/a/b/d;
    //   961: astore_3
    //   962: aload_3
    //   963: ifnull +87 -> 1050
    //   966: iload 10
    //   968: istore 9
    //   970: iload 20
    //   972: istore 21
    //   974: iload 20
    //   976: istore 22
    //   978: aload_3
    //   979: invokevirtual 459	com/tencent/beacon/a/b/d:m	()Ljava/lang/String;
    //   982: ifnull +48 -> 1030
    //   985: iload 10
    //   987: istore 9
    //   989: iload 20
    //   991: istore 21
    //   993: iload 20
    //   995: istore 22
    //   997: aload_2
    //   998: getfield 461	com/tencent/beacon/b/a/c:f	Ljava/lang/String;
    //   1001: ifnull +49 -> 1050
    //   1004: iload 10
    //   1006: istore 9
    //   1008: iload 20
    //   1010: istore 21
    //   1012: iload 20
    //   1014: istore 22
    //   1016: aload_3
    //   1017: invokevirtual 459	com/tencent/beacon/a/b/d:m	()Ljava/lang/String;
    //   1020: aload_2
    //   1021: getfield 461	com/tencent/beacon/b/a/c:f	Ljava/lang/String;
    //   1024: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1027: ifne +23 -> 1050
    //   1030: iload 10
    //   1032: istore 9
    //   1034: iload 20
    //   1036: istore 21
    //   1038: iload 20
    //   1040: istore 22
    //   1042: aload_3
    //   1043: aload_2
    //   1044: getfield 461	com/tencent/beacon/b/a/c:f	Ljava/lang/String;
    //   1047: invokevirtual 462	com/tencent/beacon/a/b/d:b	(Ljava/lang/String;)V
    //   1050: iload 10
    //   1052: istore 9
    //   1054: iload 20
    //   1056: istore 21
    //   1058: iload 20
    //   1060: istore 22
    //   1062: aload_2
    //   1063: getfield 465	com/tencent/beacon/b/a/c:c	[B
    //   1066: astore_3
    //   1067: aload_3
    //   1068: ifnonnull +132 -> 1200
    //   1071: iload 10
    //   1073: istore 9
    //   1075: iload 20
    //   1077: istore 21
    //   1079: iload 20
    //   1081: istore 22
    //   1083: ldc_w 467
    //   1086: iconst_0
    //   1087: anewarray 4	java/lang/Object
    //   1090: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1093: goto -467 -> 626
    //   1096: astore_2
    //   1097: iload 21
    //   1099: istore 20
    //   1101: aload 5
    //   1103: invokevirtual 407	com/tencent/beacon/upload/e:a	()J
    //   1106: lstore 16
    //   1108: aload 5
    //   1110: invokevirtual 409	com/tencent/beacon/upload/e:b	()J
    //   1113: lstore 18
    //   1115: aload_2
    //   1116: invokevirtual 468	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1119: ldc_w 470
    //   1122: ldc_w 327
    //   1125: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1128: astore_3
    //   1129: aload_0
    //   1130: iload 11
    //   1132: iload 9
    //   1134: lload 16
    //   1136: lload 18
    //   1138: iconst_0
    //   1139: aload_3
    //   1140: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   1143: iload 11
    //   1145: lload 16
    //   1147: iconst_0
    //   1148: lload 14
    //   1150: aload 5
    //   1152: invokevirtual 424	com/tencent/beacon/upload/e:d	()J
    //   1155: l2i
    //   1156: aload_1
    //   1157: invokevirtual 426	com/tencent/beacon/upload/a:f	()I
    //   1160: aload 4
    //   1162: aload 5
    //   1164: invokevirtual 427	com/tencent/beacon/upload/e:e	()Ljava/lang/String;
    //   1167: aload 5
    //   1169: invokevirtual 428	com/tencent/beacon/upload/e:c	()I
    //   1172: aload_3
    //   1173: invokestatic 433	com/tencent/beacon/upload/i:a	(IJZJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1176: ldc_w 476
    //   1179: iconst_1
    //   1180: anewarray 4	java/lang/Object
    //   1183: dup
    //   1184: iconst_0
    //   1185: aload_2
    //   1186: invokevirtual 468	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1189: aastore
    //   1190: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1193: aload_1
    //   1194: iload 20
    //   1196: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   1199: return
    //   1200: iload 10
    //   1202: istore 9
    //   1204: iload 20
    //   1206: istore 21
    //   1208: iload 20
    //   1210: istore 22
    //   1212: aload_0
    //   1213: invokespecial 478	com/tencent/beacon/upload/i:e	()Landroid/util/SparseArray;
    //   1216: astore 6
    //   1218: aload 6
    //   1220: ifnull +23 -> 1243
    //   1223: iload 10
    //   1225: istore 9
    //   1227: iload 20
    //   1229: istore 21
    //   1231: iload 20
    //   1233: istore 22
    //   1235: aload 6
    //   1237: invokevirtual 284	android/util/SparseArray:size	()I
    //   1240: ifgt +37 -> 1277
    //   1243: iload 10
    //   1245: istore 9
    //   1247: iload 20
    //   1249: istore 21
    //   1251: iload 20
    //   1253: istore 22
    //   1255: ldc_w 480
    //   1258: iconst_0
    //   1259: anewarray 4	java/lang/Object
    //   1262: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1265: goto -639 -> 626
    //   1268: astore_2
    //   1269: aload_1
    //   1270: iload 22
    //   1272: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   1275: aload_2
    //   1276: athrow
    //   1277: iload 10
    //   1279: istore 9
    //   1281: iload 20
    //   1283: istore 21
    //   1285: iload 20
    //   1287: istore 22
    //   1289: aload_1
    //   1290: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   1293: istore 12
    //   1295: iload 10
    //   1297: istore 9
    //   1299: iload 20
    //   1301: istore 21
    //   1303: iload 20
    //   1305: istore 22
    //   1307: aload_2
    //   1308: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   1311: istore 13
    //   1313: iload 10
    //   1315: istore 9
    //   1317: iload 20
    //   1319: istore 21
    //   1321: iload 20
    //   1323: istore 22
    //   1325: aload_2
    //   1326: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   1329: ifne +155 -> 1484
    //   1332: iload 12
    //   1334: ifle +150 -> 1484
    //   1337: iload 12
    //   1339: iconst_5
    //   1340: if_icmpgt +144 -> 1484
    //   1343: iload 10
    //   1345: istore 9
    //   1347: iload 20
    //   1349: istore 21
    //   1351: iload 20
    //   1353: istore 22
    //   1355: new 200	com/tencent/beacon/d/b
    //   1358: dup
    //   1359: aload_0
    //   1360: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   1363: invokespecial 203	com/tencent/beacon/d/b:<init>	(Landroid/content/Context;)V
    //   1366: astore 7
    //   1368: iload 10
    //   1370: istore 9
    //   1372: iload 20
    //   1374: istore 21
    //   1376: iload 20
    //   1378: istore 22
    //   1380: ldc_w 327
    //   1383: aload_0
    //   1384: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   1387: invokestatic 195	com/tencent/beacon/a/j:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/j;
    //   1390: invokevirtual 482	com/tencent/beacon/a/j:b	()Ljava/lang/String;
    //   1393: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1396: ifeq +88 -> 1484
    //   1399: iload 10
    //   1401: istore 9
    //   1403: iload 20
    //   1405: istore 21
    //   1407: iload 20
    //   1409: istore 22
    //   1411: invokestatic 69	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   1414: invokevirtual 485	com/tencent/beacon/a/b/d:j	()Z
    //   1417: ifne +67 -> 1484
    //   1420: iload 10
    //   1422: istore 9
    //   1424: iload 20
    //   1426: istore 21
    //   1428: iload 20
    //   1430: istore 22
    //   1432: new 487	com/tencent/beacon/upload/d
    //   1435: dup
    //   1436: aload_0
    //   1437: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   1440: invokespecial 488	com/tencent/beacon/upload/d:<init>	(Landroid/content/Context;)V
    //   1443: astore 8
    //   1445: iload 10
    //   1447: istore 9
    //   1449: iload 20
    //   1451: istore 21
    //   1453: iload 20
    //   1455: istore 22
    //   1457: invokestatic 491	com/tencent/beacon/a/b/b:c	()Lcom/tencent/beacon/upload/h;
    //   1460: aload 8
    //   1462: invokeinterface 493 2 0
    //   1467: iload 10
    //   1469: istore 9
    //   1471: iload 20
    //   1473: istore 21
    //   1475: iload 20
    //   1477: istore 22
    //   1479: aload 7
    //   1481: invokevirtual 495	com/tencent/beacon/d/b:c	()V
    //   1484: iload 13
    //   1486: ifne +302 -> 1788
    //   1489: iload 10
    //   1491: istore 9
    //   1493: iload 20
    //   1495: istore 21
    //   1497: iload 20
    //   1499: istore 22
    //   1501: ldc_w 497
    //   1504: iconst_0
    //   1505: anewarray 4	java/lang/Object
    //   1508: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1511: goto -885 -> 626
    //   1514: iload 10
    //   1516: istore 9
    //   1518: iload 20
    //   1520: istore 21
    //   1522: iload 20
    //   1524: istore 22
    //   1526: ldc_w 499
    //   1529: iconst_1
    //   1530: anewarray 4	java/lang/Object
    //   1533: dup
    //   1534: iconst_0
    //   1535: iload 12
    //   1537: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1540: aastore
    //   1541: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1544: goto -918 -> 626
    //   1547: iload 13
    //   1549: bipush 101
    //   1551: if_icmpeq +140 -> 1691
    //   1554: iload 10
    //   1556: istore 9
    //   1558: iload 20
    //   1560: istore 21
    //   1562: iload 20
    //   1564: istore 22
    //   1566: ldc_w 501
    //   1569: iconst_2
    //   1570: anewarray 4	java/lang/Object
    //   1573: dup
    //   1574: iconst_0
    //   1575: iload 12
    //   1577: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1580: aastore
    //   1581: dup
    //   1582: iconst_1
    //   1583: iload 13
    //   1585: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1588: aastore
    //   1589: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1592: goto -966 -> 626
    //   1595: iload 13
    //   1597: bipush 105
    //   1599: if_icmpeq +92 -> 1691
    //   1602: iload 10
    //   1604: istore 9
    //   1606: iload 20
    //   1608: istore 21
    //   1610: iload 20
    //   1612: istore 22
    //   1614: ldc_w 501
    //   1617: iconst_2
    //   1618: anewarray 4	java/lang/Object
    //   1621: dup
    //   1622: iconst_0
    //   1623: iload 12
    //   1625: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1628: aastore
    //   1629: dup
    //   1630: iconst_1
    //   1631: iload 13
    //   1633: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1636: aastore
    //   1637: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1640: goto -1014 -> 626
    //   1643: iload 13
    //   1645: bipush 103
    //   1647: if_icmpeq +44 -> 1691
    //   1650: iload 10
    //   1652: istore 9
    //   1654: iload 20
    //   1656: istore 21
    //   1658: iload 20
    //   1660: istore 22
    //   1662: ldc_w 503
    //   1665: iconst_2
    //   1666: anewarray 4	java/lang/Object
    //   1669: dup
    //   1670: iconst_0
    //   1671: iload 12
    //   1673: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1676: aastore
    //   1677: dup
    //   1678: iconst_1
    //   1679: iload 13
    //   1681: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1684: aastore
    //   1685: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1688: goto -1062 -> 626
    //   1691: iload 10
    //   1693: istore 9
    //   1695: iload 20
    //   1697: istore 21
    //   1699: iload 20
    //   1701: istore 22
    //   1703: aload_0
    //   1704: aload 6
    //   1706: iload 13
    //   1708: aload_3
    //   1709: invokespecial 505	com/tencent/beacon/upload/i:a	(Landroid/util/SparseArray;I[B)Z
    //   1712: pop
    //   1713: goto -1087 -> 626
    //   1716: astore_2
    //   1717: iconst_0
    //   1718: istore 22
    //   1720: goto -451 -> 1269
    //   1723: astore_2
    //   1724: iload 20
    //   1726: istore 22
    //   1728: goto -459 -> 1269
    //   1731: astore_2
    //   1732: iconst_m1
    //   1733: istore 9
    //   1735: iconst_0
    //   1736: istore 20
    //   1738: goto -637 -> 1101
    //   1741: astore_2
    //   1742: iconst_0
    //   1743: istore 20
    //   1745: iload 10
    //   1747: istore 9
    //   1749: goto -648 -> 1101
    //   1752: astore 7
    //   1754: goto -270 -> 1484
    //   1757: iconst_m1
    //   1758: istore 10
    //   1760: iconst_0
    //   1761: istore 20
    //   1763: goto +14 -> 1777
    //   1766: aload_3
    //   1767: astore_2
    //   1768: goto -1230 -> 538
    //   1771: aload 4
    //   1773: astore_2
    //   1774: goto -1449 -> 325
    //   1777: aload_1
    //   1778: ifnull -1152 -> 626
    //   1781: aload_2
    //   1782: ifnonnull -1054 -> 728
    //   1785: goto -1159 -> 626
    //   1788: iload 12
    //   1790: lookupswitch	default:+34->1824, 4:+-195->1595, 100:+-243->1547, 102:+-147->1643
    //   1824: goto -310 -> 1514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1827	0	this	i
    //   0	1827	1	parama	a
    //   216	847	2	localObject1	Object
    //   1096	90	2	localThrowable1	Throwable
    //   1268	58	2	localObject2	Object
    //   1716	1	2	localObject3	Object
    //   1723	1	2	localObject4	Object
    //   1731	1	2	localThrowable2	Throwable
    //   1741	1	2	localThrowable3	Throwable
    //   1767	15	2	localObject5	Object
    //   214	1553	3	localObject6	Object
    //   146	1626	4	str	String
    //   242	926	5	localObject7	Object
    //   208	1497	6	localObject8	Object
    //   419	1061	7	localObject9	Object
    //   1752	1	7	localException	Exception
    //   1443	18	8	locald	d
    //   571	1177	9	i	int
    //   565	1194	10	j	int
    //   140	1004	11	k	int
    //   1293	496	12	m	int
    //   1311	396	13	n	int
    //   489	660	14	l1	long
    //   543	603	16	l2	long
    //   550	587	18	l3	long
    //   579	1183	20	bool1	boolean
    //   587	1111	21	bool2	boolean
    //   591	1136	22	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   593	623	1096	java/lang/Throwable
    //   638	653	1096	java/lang/Throwable
    //   665	715	1096	java/lang/Throwable
    //   740	744	1096	java/lang/Throwable
    //   760	767	1096	java/lang/Throwable
    //   779	790	1096	java/lang/Throwable
    //   802	811	1096	java/lang/Throwable
    //   823	837	1096	java/lang/Throwable
    //   849	876	1096	java/lang/Throwable
    //   888	897	1096	java/lang/Throwable
    //   909	918	1096	java/lang/Throwable
    //   930	939	1096	java/lang/Throwable
    //   951	962	1096	java/lang/Throwable
    //   978	985	1096	java/lang/Throwable
    //   997	1004	1096	java/lang/Throwable
    //   1016	1030	1096	java/lang/Throwable
    //   1042	1050	1096	java/lang/Throwable
    //   1062	1067	1096	java/lang/Throwable
    //   1083	1093	1096	java/lang/Throwable
    //   1212	1218	1096	java/lang/Throwable
    //   1235	1243	1096	java/lang/Throwable
    //   1255	1265	1096	java/lang/Throwable
    //   1289	1295	1096	java/lang/Throwable
    //   1307	1313	1096	java/lang/Throwable
    //   1325	1332	1096	java/lang/Throwable
    //   1355	1368	1096	java/lang/Throwable
    //   1380	1399	1096	java/lang/Throwable
    //   1411	1420	1096	java/lang/Throwable
    //   1432	1445	1096	java/lang/Throwable
    //   1457	1467	1096	java/lang/Throwable
    //   1479	1484	1096	java/lang/Throwable
    //   1501	1511	1096	java/lang/Throwable
    //   1526	1544	1096	java/lang/Throwable
    //   1566	1592	1096	java/lang/Throwable
    //   1614	1640	1096	java/lang/Throwable
    //   1662	1688	1096	java/lang/Throwable
    //   1703	1713	1096	java/lang/Throwable
    //   593	623	1268	finally
    //   638	653	1268	finally
    //   665	715	1268	finally
    //   740	744	1268	finally
    //   760	767	1268	finally
    //   779	790	1268	finally
    //   802	811	1268	finally
    //   823	837	1268	finally
    //   849	876	1268	finally
    //   888	897	1268	finally
    //   909	918	1268	finally
    //   930	939	1268	finally
    //   951	962	1268	finally
    //   978	985	1268	finally
    //   997	1004	1268	finally
    //   1016	1030	1268	finally
    //   1042	1050	1268	finally
    //   1062	1067	1268	finally
    //   1083	1093	1268	finally
    //   1212	1218	1268	finally
    //   1235	1243	1268	finally
    //   1255	1265	1268	finally
    //   1289	1295	1268	finally
    //   1307	1313	1268	finally
    //   1325	1332	1268	finally
    //   1355	1368	1268	finally
    //   1380	1399	1268	finally
    //   1411	1420	1268	finally
    //   1432	1445	1268	finally
    //   1457	1467	1268	finally
    //   1479	1484	1268	finally
    //   1501	1511	1268	finally
    //   1526	1544	1268	finally
    //   1566	1592	1268	finally
    //   1614	1640	1268	finally
    //   1662	1688	1268	finally
    //   1703	1713	1268	finally
    //   491	503	1716	finally
    //   514	538	1716	finally
    //   538	557	1716	finally
    //   561	567	1716	finally
    //   567	573	1716	finally
    //   1101	1193	1723	finally
    //   491	503	1731	java/lang/Throwable
    //   514	538	1731	java/lang/Throwable
    //   538	557	1731	java/lang/Throwable
    //   561	567	1731	java/lang/Throwable
    //   567	573	1741	java/lang/Throwable
    //   1380	1399	1752	java/lang/Exception
    //   1411	1420	1752	java/lang/Exception
    //   1432	1445	1752	java/lang/Exception
    //   1457	1467	1752	java/lang/Exception
    //   1479	1484	1752	java/lang/Exception
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean a(UploadHandleListener paramUploadHandleListener)
  {
    boolean bool;
    if (paramUploadHandleListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.c.contains(paramUploadHandleListener)) {
          this.c.add(paramUploadHandleListener);
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(g paramg)
  {
    boolean bool;
    if (paramg == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.b.append(101, paramg);
        bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   6: invokestatic 518	com/tencent/beacon/a/f:s	(Landroid/content/Context;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +9 -> 20
    //   14: iconst_1
    //   15: istore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_2
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 48	com/tencent/beacon/upload/i:g	Z
    //   24: istore_2
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	i
    //   28	4	1	localObject	Object
    //   9	16	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	10	28	finally
    //   20	25	28	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\upload\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */