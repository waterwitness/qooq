package com.tencent.beacon.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.beacon.d.a;

public final class e
  extends SQLiteOpenHelper
{
  public static Object a = new Object();
  private static SQLiteDatabase c = null;
  private Context b;
  
  private e(Context paramContext)
  {
    super(paramContext, "beacon_db", null, 21);
    this.b = paramContext;
  }
  
  public static e a(Context paramContext)
  {
    try
    {
      paramContext = new e(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 38	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 39	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aload_1
    //   12: ldc 41
    //   14: iconst_1
    //   15: anewarray 43	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 45
    //   22: aastore
    //   23: ldc 47
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 53	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +68 -> 102
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokeinterface 59 1 0
    //   45: ifeq +57 -> 102
    //   48: aload_3
    //   49: astore_2
    //   50: aload 4
    //   52: aload_3
    //   53: iconst_0
    //   54: invokeinterface 63 2 0
    //   59: invokeinterface 69 2 0
    //   64: pop
    //   65: goto -28 -> 37
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: aload_1
    //   72: invokestatic 74	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   75: aload_3
    //   76: ifnull +18 -> 94
    //   79: aload_3
    //   80: invokeinterface 77 1 0
    //   85: ifne +9 -> 94
    //   88: aload_3
    //   89: invokeinterface 80 1 0
    //   94: iconst_0
    //   95: istore 6
    //   97: aload_0
    //   98: monitorexit
    //   99: iload 6
    //   101: ireturn
    //   102: aload_3
    //   103: astore_2
    //   104: aload 4
    //   106: invokeinterface 84 1 0
    //   111: ifle +133 -> 244
    //   114: aload_3
    //   115: astore_2
    //   116: aload 4
    //   118: invokeinterface 88 1 0
    //   123: astore 4
    //   125: aload_3
    //   126: astore_2
    //   127: aload 4
    //   129: invokeinterface 93 1 0
    //   134: ifeq +110 -> 244
    //   137: aload_3
    //   138: astore_2
    //   139: aload 4
    //   141: invokeinterface 97 1 0
    //   146: checkcast 43	java/lang/String
    //   149: astore 5
    //   151: aload_3
    //   152: astore_2
    //   153: aload 5
    //   155: ldc 99
    //   157: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifne -35 -> 125
    //   163: aload_3
    //   164: astore_2
    //   165: aload 5
    //   167: ldc 104
    //   169: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifne -47 -> 125
    //   175: aload_3
    //   176: astore_2
    //   177: aload_1
    //   178: getstatic 110	java/util/Locale:US	Ljava/util/Locale;
    //   181: ldc 112
    //   183: iconst_1
    //   184: anewarray 14	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload 5
    //   191: aastore
    //   192: invokestatic 116	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   195: invokevirtual 120	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   198: aload_3
    //   199: astore_2
    //   200: ldc 122
    //   202: iconst_1
    //   203: anewarray 14	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload 5
    //   210: aastore
    //   211: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -89 -> 125
    //   217: astore_1
    //   218: aload_2
    //   219: ifnull +18 -> 237
    //   222: aload_2
    //   223: invokeinterface 77 1 0
    //   228: ifne +9 -> 237
    //   231: aload_2
    //   232: invokeinterface 80 1 0
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    //   244: aload_3
    //   245: ifnull +18 -> 263
    //   248: aload_3
    //   249: invokeinterface 77 1 0
    //   254: ifne +9 -> 263
    //   257: aload_3
    //   258: invokeinterface 80 1 0
    //   263: iconst_1
    //   264: istore 6
    //   266: goto -169 -> 97
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_2
    //   272: goto -54 -> 218
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_3
    //   278: goto -209 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	e
    //   0	281	1	paramSQLiteDatabase	SQLiteDatabase
    //   38	234	2	localCursor1	android.database.Cursor
    //   32	246	3	localCursor2	android.database.Cursor
    //   9	131	4	localObject	Object
    //   149	60	5	str	String
    //   95	170	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	48	68	java/lang/Throwable
    //   50	65	68	java/lang/Throwable
    //   104	114	68	java/lang/Throwable
    //   116	125	68	java/lang/Throwable
    //   127	137	68	java/lang/Throwable
    //   139	151	68	java/lang/Throwable
    //   153	163	68	java/lang/Throwable
    //   165	175	68	java/lang/Throwable
    //   177	198	68	java/lang/Throwable
    //   200	214	68	java/lang/Throwable
    //   39	48	217	finally
    //   50	65	217	finally
    //   71	75	217	finally
    //   104	114	217	finally
    //   116	125	217	finally
    //   127	137	217	finally
    //   139	151	217	finally
    //   153	163	217	finally
    //   165	175	217	finally
    //   177	198	217	finally
    //   200	214	217	finally
    //   79	94	239	finally
    //   222	237	239	finally
    //   237	239	239	finally
    //   248	263	239	finally
    //   2	33	269	finally
    //   2	33	275	java/lang/Throwable
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    int i = 0;
    try
    {
      for (;;)
      {
        SQLiteDatabase localSQLiteDatabase1 = c;
        if ((localSQLiteDatabase1 != null) || (i >= 5)) {
          break;
        }
        i += 1;
        try
        {
          c = super.getWritableDatabase();
        }
        catch (Exception localException)
        {
          a.c("getWritableDatabase error count %d", new Object[] { Integer.valueOf(i) });
          if (i == 5) {
            a.d("error get DB failed", new Object[0]);
          }
          try
          {
            Thread.sleep(200L);
          }
          catch (InterruptedException localInterruptedException)
          {
            a.a(localInterruptedException);
          }
        }
      }
      localSQLiteDatabase2 = c;
    }
    finally {}
    SQLiteDatabase localSQLiteDatabase2;
    return localSQLiteDatabase2;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (d.a != null)
      {
        String[][] arrayOfString = d.a;
        int j = arrayOfString.length;
        while (i < j)
        {
          String[] arrayOfString1 = arrayOfString[i];
          a.g("table:%s", new Object[] { arrayOfString1[0] });
          paramSQLiteDatabase.execSQL(arrayOfString1[1]);
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/beacon/a/a/e:b	Landroid/content/Context;
    //   6: invokestatic 176	com/tencent/beacon/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/f;
    //   9: pop
    //   10: invokestatic 179	com/tencent/beacon/a/f:d	()Ljava/lang/String;
    //   13: invokestatic 183	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   16: bipush 11
    //   18: if_icmplt +53 -> 71
    //   21: ldc -71
    //   23: iconst_3
    //   24: anewarray 14	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: ldc 25
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: iload_2
    //   35: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: iload_3
    //   42: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 187	com/tencent/beacon/a/a/e:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   54: ifeq +20 -> 74
    //   57: ldc -67
    //   59: iconst_0
    //   60: anewarray 14	java/lang/Object
    //   63: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 191	com/tencent/beacon/a/a/e:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: ldc -63
    //   76: iconst_0
    //   77: anewarray 14	java/lang/Object
    //   80: invokestatic 149	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_0
    //   84: getfield 30	com/tencent/beacon/a/a/e:b	Landroid/content/Context;
    //   87: ldc 25
    //   89: invokevirtual 199	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -23 -> 71
    //   97: aload_1
    //   98: invokevirtual 204	java/io/File:canWrite	()Z
    //   101: ifeq -30 -> 71
    //   104: aload_1
    //   105: invokevirtual 207	java/io/File:delete	()Z
    //   108: pop
    //   109: goto -38 -> 71
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	e
    //   0	117	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	117	2	paramInt1	int
    //   0	117	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	71	112	finally
    //   74	93	112	finally
    //   97	109	112	finally
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc -45
    //   4: iconst_3
    //   5: anewarray 14	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 25
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iload_2
    //   16: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: iload_3
    //   23: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 187	com/tencent/beacon/a/a/e:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   35: ifeq +20 -> 55
    //   38: ldc -67
    //   40: iconst_0
    //   41: anewarray 14	java/lang/Object
    //   44: invokestatic 126	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 191	com/tencent/beacon/a/a/e:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: ldc -63
    //   57: iconst_0
    //   58: anewarray 14	java/lang/Object
    //   61: invokestatic 149	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: getfield 30	com/tencent/beacon/a/a/e:b	Landroid/content/Context;
    //   68: ldc 25
    //   70: invokevirtual 199	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull -23 -> 52
    //   78: aload_1
    //   79: invokevirtual 204	java/io/File:canWrite	()Z
    //   82: ifeq -30 -> 52
    //   85: aload_1
    //   86: invokevirtual 207	java/io/File:delete	()Z
    //   89: pop
    //   90: goto -38 -> 52
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	e
    //   0	98	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	98	2	paramInt1	int
    //   0	98	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	52	93	finally
    //   55	74	93	finally
    //   78	90	93	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */