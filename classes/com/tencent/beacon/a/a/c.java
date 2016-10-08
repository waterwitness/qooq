package com.tencent.beacon.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.beacon.d.a;

public final class c
{
  private static int a = -22876499;
  
  /* Error */
  public static java.util.List<b> a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 20	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: ldc 22
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: ifnonnull +16 -> 34
    //   21: ldc 30
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokestatic 33	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_3
    //   31: monitorexit
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: invokestatic 36	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   38: invokevirtual 40	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   41: ldc 42
    //   43: aconst_null
    //   44: ldc 44
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 50	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_0
    //   54: new 52	java/util/ArrayList
    //   57: dup
    //   58: invokespecial 55	java/util/ArrayList:<init>	()V
    //   61: astore_1
    //   62: aload_0
    //   63: invokeinterface 61 1 0
    //   68: ifeq +165 -> 233
    //   71: new 63	com/tencent/beacon/a/a/b
    //   74: dup
    //   75: invokespecial 64	com/tencent/beacon/a/a/b:<init>	()V
    //   78: astore_2
    //   79: aload_2
    //   80: aload_0
    //   81: aload_0
    //   82: ldc 66
    //   84: invokeinterface 70 2 0
    //   89: invokeinterface 74 2 0
    //   94: i2l
    //   95: putfield 77	com/tencent/beacon/a/a/b:a	J
    //   98: aload_2
    //   99: new 79	java/lang/String
    //   102: dup
    //   103: aload_0
    //   104: aload_0
    //   105: ldc 81
    //   107: invokeinterface 70 2 0
    //   112: invokeinterface 85 2 0
    //   117: iconst_1
    //   118: ldc 87
    //   120: invokestatic 92	com/tencent/beacon/a/f:b	([BILjava/lang/String;)[B
    //   123: invokespecial 95	java/lang/String:<init>	([B)V
    //   126: putfield 98	com/tencent/beacon/a/a/b:b	Ljava/lang/String;
    //   129: aload_2
    //   130: aload_0
    //   131: aload_0
    //   132: ldc 100
    //   134: invokeinterface 70 2 0
    //   139: invokeinterface 74 2 0
    //   144: getstatic 11	com/tencent/beacon/a/a/c:a	I
    //   147: ixor
    //   148: putfield 103	com/tencent/beacon/a/a/b:c	I
    //   151: aload_0
    //   152: aload_0
    //   153: ldc 105
    //   155: invokeinterface 70 2 0
    //   160: invokeinterface 74 2 0
    //   165: iconst_1
    //   166: if_icmpne +61 -> 227
    //   169: iconst_1
    //   170: istore 4
    //   172: aload_2
    //   173: iload 4
    //   175: putfield 108	com/tencent/beacon/a/a/b:d	Z
    //   178: aload_1
    //   179: aload_2
    //   180: invokeinterface 114 2 0
    //   185: pop
    //   186: goto -124 -> 62
    //   189: astore_2
    //   190: aload_0
    //   191: ifnull +18 -> 209
    //   194: aload_0
    //   195: invokeinterface 117 1 0
    //   200: ifne +9 -> 209
    //   203: aload_0
    //   204: invokeinterface 120 1 0
    //   209: ldc 122
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_3
    //   219: monitorexit
    //   220: aload_1
    //   221: areturn
    //   222: astore_0
    //   223: aload_3
    //   224: monitorexit
    //   225: aload_0
    //   226: athrow
    //   227: iconst_0
    //   228: istore 4
    //   230: goto -58 -> 172
    //   233: new 124	java/lang/StringBuilder
    //   236: dup
    //   237: ldc 126
    //   239: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_1
    //   243: invokeinterface 133 1 0
    //   248: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 143	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_0
    //   262: ifnull +18 -> 280
    //   265: aload_0
    //   266: invokeinterface 117 1 0
    //   271: ifne +9 -> 280
    //   274: aload_0
    //   275: invokeinterface 120 1 0
    //   280: ldc 122
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: goto -71 -> 218
    //   292: aload_0
    //   293: ifnull +18 -> 311
    //   296: aload_0
    //   297: invokeinterface 117 1 0
    //   302: ifne +9 -> 311
    //   305: aload_0
    //   306: invokeinterface 120 1 0
    //   311: ldc 122
    //   313: iconst_0
    //   314: anewarray 4	java/lang/Object
    //   317: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: aload_1
    //   321: athrow
    //   322: astore_1
    //   323: goto -31 -> 292
    //   326: astore_0
    //   327: aconst_null
    //   328: astore_0
    //   329: aload_2
    //   330: astore_1
    //   331: goto -141 -> 190
    //   334: astore_1
    //   335: aload_2
    //   336: astore_1
    //   337: goto -147 -> 190
    //   340: astore_1
    //   341: aconst_null
    //   342: astore_0
    //   343: goto -51 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramContext	Context
    //   61	260	1	localArrayList	java.util.ArrayList
    //   322	1	1	localObject1	Object
    //   330	1	1	localException1	Exception
    //   334	1	1	localException2	Exception
    //   336	1	1	localException3	Exception
    //   340	1	1	localObject2	Object
    //   1	179	2	localb	b
    //   189	147	2	localException4	Exception
    //   5	219	3	localObject3	Object
    //   170	59	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   62	169	189	java/lang/Exception
    //   172	186	189	java/lang/Exception
    //   233	261	189	java/lang/Exception
    //   8	17	222	finally
    //   21	32	222	finally
    //   194	209	222	finally
    //   209	218	222	finally
    //   218	220	222	finally
    //   265	280	222	finally
    //   280	289	222	finally
    //   296	311	222	finally
    //   311	322	222	finally
    //   54	62	322	finally
    //   62	169	322	finally
    //   172	186	322	finally
    //   233	261	322	finally
    //   34	54	326	java/lang/Exception
    //   54	62	334	java/lang/Exception
    //   34	54	340	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, java.util.List<b> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 20	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   5: astore 4
    //   7: aload 4
    //   9: monitorenter
    //   10: ldc -106
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: ifnull +16 -> 36
    //   23: aload_1
    //   24: ifnull +12 -> 36
    //   27: aload_1
    //   28: invokeinterface 133 1 0
    //   33: ifne +8 -> 41
    //   36: aload 4
    //   38: monitorexit
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: invokestatic 36	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   45: invokevirtual 40	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 153	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   53: aload_1
    //   54: invokeinterface 157 1 0
    //   59: astore_1
    //   60: aload_1
    //   61: invokeinterface 162 1 0
    //   66: ifeq +163 -> 229
    //   69: aload_1
    //   70: invokeinterface 166 1 0
    //   75: checkcast 63	com/tencent/beacon/a/a/b
    //   78: astore_3
    //   79: new 168	android/content/ContentValues
    //   82: dup
    //   83: invokespecial 169	android/content/ContentValues:<init>	()V
    //   86: astore 5
    //   88: aload 5
    //   90: ldc 81
    //   92: aload_3
    //   93: getfield 98	com/tencent/beacon/a/a/b:b	Ljava/lang/String;
    //   96: invokevirtual 173	java/lang/String:getBytes	()[B
    //   99: iconst_1
    //   100: ldc 87
    //   102: invokestatic 175	com/tencent/beacon/a/f:a	([BILjava/lang/String;)[B
    //   105: invokevirtual 179	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   108: aload 5
    //   110: ldc 100
    //   112: aload_3
    //   113: getfield 103	com/tencent/beacon/a/a/b:c	I
    //   116: getstatic 11	com/tencent/beacon/a/a/c:a	I
    //   119: ixor
    //   120: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: invokevirtual 188	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   126: aload_3
    //   127: getfield 108	com/tencent/beacon/a/a/b:d	Z
    //   130: ifeq +87 -> 217
    //   133: iconst_1
    //   134: istore 6
    //   136: aload 5
    //   138: ldc 105
    //   140: iload 6
    //   142: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: invokevirtual 188	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   148: iload_2
    //   149: ifeq +74 -> 223
    //   152: iconst_1
    //   153: istore 6
    //   155: aload 5
    //   157: ldc -66
    //   159: iload 6
    //   161: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: invokevirtual 188	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   167: aload_0
    //   168: ldc 42
    //   170: aconst_null
    //   171: aload 5
    //   173: iconst_4
    //   174: invokevirtual 194	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   177: pop2
    //   178: goto -118 -> 60
    //   181: astore_1
    //   182: ldc -60
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   195: ldc -55
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: iconst_0
    //   205: istore_2
    //   206: aload 4
    //   208: monitorexit
    //   209: iload_2
    //   210: ireturn
    //   211: astore_0
    //   212: aload 4
    //   214: monitorexit
    //   215: aload_0
    //   216: athrow
    //   217: iconst_0
    //   218: istore 6
    //   220: goto -84 -> 136
    //   223: iconst_0
    //   224: istore 6
    //   226: goto -71 -> 155
    //   229: aload_0
    //   230: invokevirtual 204	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   233: aload_0
    //   234: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   237: ldc -55
    //   239: iconst_0
    //   240: anewarray 4	java/lang/Object
    //   243: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: iconst_1
    //   247: istore_2
    //   248: goto -42 -> 206
    //   251: aload_0
    //   252: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   255: ldc -55
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 28	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_1
    //   265: athrow
    //   266: astore_1
    //   267: goto -16 -> 251
    //   270: astore_1
    //   271: goto -20 -> 251
    //   274: astore_0
    //   275: aload_3
    //   276: astore_0
    //   277: goto -95 -> 182
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_0
    //   283: goto -32 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramContext	Context
    //   0	286	1	paramList	java.util.List<b>
    //   0	286	2	paramBoolean	boolean
    //   1	275	3	localb	b
    //   5	208	4	localObject	Object
    //   86	86	5	localContentValues	android.content.ContentValues
    //   134	91	6	i	int
    // Exception table:
    //   from	to	target	type
    //   49	60	181	java/lang/Throwable
    //   60	133	181	java/lang/Throwable
    //   136	148	181	java/lang/Throwable
    //   155	178	181	java/lang/Throwable
    //   229	233	181	java/lang/Throwable
    //   10	19	211	finally
    //   27	36	211	finally
    //   36	39	211	finally
    //   191	204	211	finally
    //   206	209	211	finally
    //   233	246	211	finally
    //   251	266	211	finally
    //   49	60	266	finally
    //   60	133	266	finally
    //   136	148	266	finally
    //   155	178	266	finally
    //   229	233	266	finally
    //   182	191	270	finally
    //   41	49	274	java/lang/Throwable
    //   41	49	280	finally
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    synchronized (e.a)
    {
      a.b(" updateAppUseData start", new Object[0]);
      if (paramContext == null) {
        return false;
      }
      try
      {
        e.a(paramContext).getWritableDatabase().execSQL("update t_apple set _d = 1 where _d = 0");
        bool = true;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          a.b("updateAppUseData failure!", new Object[0]);
          a.b("updateAppUseData end", new Object[0]);
        }
      }
      finally
      {
        a.b("updateAppUseData end", new Object[0]);
      }
      return bool;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    bool2 = false;
    bool1 = false;
    synchronized (e.a)
    {
      a.b(" deleteAppUseData start", new Object[0]);
      if (paramContext == null)
      {
        a.a(" delete() context is null arg", new Object[0]);
        return false;
      }
      try
      {
        int i = e.a(paramContext).getWritableDatabase().delete("t_apple", null, null);
        a.b(" deleted num: " + i, new Object[0]);
        if (i > 0) {
          bool1 = true;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          a.b(paramContext.getMessage(), new Object[0]);
          a.b(" deleteAppUseData end", new Object[0]);
          bool1 = bool2;
        }
      }
      finally
      {
        a.b(" deleteAppUseData end", new Object[0]);
      }
      return bool1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */