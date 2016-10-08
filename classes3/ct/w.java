package ct;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class w
  extends SQLiteOpenHelper
  implements v
{
  private static String a = "";
  private static w b;
  
  private w(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 5);
    try
    {
      paramContext.deleteDatabase("access.db");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static w a()
  {
    if (b == null)
    {
      a = p.b() + "-access.db";
      b = new w(p.a(), a);
    }
    return b;
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  /* Error */
  private boolean a(String paramString, t.a parama, long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 79	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 5
    //   11: aload 5
    //   13: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   16: ifne +15 -> 31
    //   19: aload 5
    //   21: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   24: istore 9
    //   26: iload 9
    //   28: ifeq +31 -> 59
    //   31: ldc2_w 87
    //   34: invokestatic 94	java/lang/Thread:sleep	(J)V
    //   37: goto -26 -> 11
    //   40: astore 6
    //   42: aload 6
    //   44: invokevirtual 95	java/lang/InterruptedException:printStackTrace	()V
    //   47: goto -36 -> 11
    //   50: astore_1
    //   51: iconst_0
    //   52: istore 8
    //   54: aload_0
    //   55: monitorexit
    //   56: iload 8
    //   58: ireturn
    //   59: new 97	android/content/ContentValues
    //   62: dup
    //   63: invokespecial 98	android/content/ContentValues:<init>	()V
    //   66: astore 6
    //   68: aload 6
    //   70: ldc 100
    //   72: aload_2
    //   73: invokevirtual 104	ct/t$a:a	()Ljava/lang/String;
    //   76: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 6
    //   81: ldc 110
    //   83: aload_2
    //   84: getfield 114	ct/t$a:e	J
    //   87: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   90: invokevirtual 123	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   93: aload 6
    //   95: ldc 125
    //   97: lload_3
    //   98: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   101: invokevirtual 123	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   104: aload 6
    //   106: ldc 127
    //   108: aload_2
    //   109: getfield 129	ct/t$a:b	Ljava/lang/String;
    //   112: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 5
    //   117: ldc -125
    //   119: aload 6
    //   121: ldc -123
    //   123: iconst_2
    //   124: anewarray 135	java/lang/String
    //   127: dup
    //   128: iconst_0
    //   129: aload_1
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: aload_2
    //   134: getfield 136	ct/t$a:a	Ljava/lang/String;
    //   137: aastore
    //   138: invokevirtual 140	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   141: istore 7
    //   143: iload 7
    //   145: ifne +108 -> 253
    //   148: aload 6
    //   150: ldc -114
    //   152: aload_1
    //   153: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 6
    //   158: ldc -112
    //   160: aload_2
    //   161: getfield 136	ct/t$a:a	Ljava/lang/String;
    //   164: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 6
    //   169: ldc 127
    //   171: aload_2
    //   172: getfield 129	ct/t$a:b	Ljava/lang/String;
    //   175: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 5
    //   180: ldc -125
    //   182: aconst_null
    //   183: aload 6
    //   185: invokevirtual 148	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   188: lstore_3
    //   189: new 40	java/lang/StringBuilder
    //   192: dup
    //   193: ldc -106
    //   195: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: lload_3
    //   199: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: ldc -99
    //   204: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc -97
    //   213: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_2
    //   217: getfield 136	ct/t$a:a	Ljava/lang/String;
    //   220: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc -95
    //   225: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_2
    //   229: invokevirtual 104	ct/t$a:a	()Ljava/lang/String;
    //   232: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: invokestatic 165	ct/bc:b	()V
    //   239: ldc2_w 166
    //   242: lload_3
    //   243: lcmp
    //   244: ifne -190 -> 54
    //   247: iconst_0
    //   248: istore 8
    //   250: goto -196 -> 54
    //   253: new 40	java/lang/StringBuilder
    //   256: dup
    //   257: ldc -87
    //   259: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: iload 7
    //   264: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: ldc -99
    //   269: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc -97
    //   278: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_2
    //   282: getfield 136	ct/t$a:a	Ljava/lang/String;
    //   285: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc -95
    //   290: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_2
    //   294: invokevirtual 104	ct/t$a:a	()Ljava/lang/String;
    //   297: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: iconst_0
    //   302: istore 8
    //   304: invokestatic 165	ct/bc:b	()V
    //   307: goto -253 -> 54
    //   310: astore_1
    //   311: aload_0
    //   312: monitorexit
    //   313: aload_1
    //   314: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	w
    //   0	315	1	paramString	String
    //   0	315	2	parama	t.a
    //   0	315	3	paramLong	long
    //   9	170	5	localSQLiteDatabase	SQLiteDatabase
    //   40	3	6	localInterruptedException	InterruptedException
    //   66	118	6	localContentValues	android.content.ContentValues
    //   141	122	7	i	int
    //   1	302	8	bool1	boolean
    //   24	3	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   31	37	40	java/lang/InterruptedException
    //   5	11	50	java/lang/Exception
    //   11	26	50	java/lang/Exception
    //   31	37	50	java/lang/Exception
    //   42	47	50	java/lang/Exception
    //   59	143	50	java/lang/Exception
    //   148	239	50	java/lang/Exception
    //   253	301	50	java/lang/Exception
    //   304	307	50	java/lang/Exception
    //   5	11	310	finally
    //   11	26	310	finally
    //   31	37	310	finally
    //   42	47	310	finally
    //   59	143	310	finally
    //   148	239	310	finally
    //   253	301	310	finally
    //   304	307	310	finally
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      bc.b();
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  public final t a(String paramString)
  {
    label244:
    label262:
    for (;;)
    {
      try
      {
        Object localObject = getReadableDatabase();
        boolean bool;
        if (!((SQLiteDatabase)localObject).isDbLockedByOtherThreads())
        {
          bool = ((SQLiteDatabase)localObject).isDbLockedByCurrentThread();
          if (!bool) {}
        }
        else
        {
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          continue;
        }
        Cursor localCursor;
        String str1;
        String str2;
        String str3;
        long l;
        paramString = null;
      }
      catch (Exception paramString)
      {
        localObject = null;
        return (t)localObject;
      }
      finally
      {
        try
        {
          localCursor = ((SQLiteDatabase)localObject).query("access_tbl", null, "apn=?", new String[] { paramString }, null, null, null);
          if (localCursor == null) {
            break label262;
          }
        }
        finally
        {
          localObject = null;
          if (localObject != null) {
            ((Cursor)localObject).close();
          }
        }
        try
        {
          if (!localCursor.moveToFirst()) {
            break label262;
          }
          paramString = new t(paramString);
          localObject = localCursor.getString(localCursor.getColumnIndex("domain"));
          str1 = localCursor.getString(localCursor.getColumnIndex("iplist"));
          str2 = localCursor.getString(localCursor.getColumnIndex("last_suc_ip"));
          str3 = localCursor.getString(localCursor.getColumnIndex("rule"));
          l = localCursor.getLong(localCursor.getColumnIndex("schedule_lasttime"));
          localCursor.getLong(localCursor.getColumnIndex("apn_lasttime"));
          paramString.a(new t.a((String)localObject, l, str1, str3, str2));
          bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
          localObject = paramString;
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
        }
        finally
        {
          localObject = localCursor;
          break label244;
        }
        paramString = finally;
      }
    }
  }
  
  /* Error */
  public final void a(t paramt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_1
    //   13: getfield 222	ct/t:b	Ljava/util/Map;
    //   16: astore_2
    //   17: invokestatic 228	java/lang/System:currentTimeMillis	()J
    //   20: lstore 5
    //   22: aload_2
    //   23: invokeinterface 234 1 0
    //   28: invokeinterface 240 1 0
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface 245 1 0
    //   40: ifeq +37 -> 77
    //   43: aload_2
    //   44: invokeinterface 249 1 0
    //   49: checkcast 102	ct/t$a
    //   52: astore_3
    //   53: aload_0
    //   54: aload_1
    //   55: getfield 250	ct/t:a	Ljava/lang/String;
    //   58: aload_3
    //   59: lload 5
    //   61: invokespecial 252	ct/w:a	(Ljava/lang/String;Lct/t$a;J)Z
    //   64: istore 7
    //   66: iload 7
    //   68: ifeq +241 -> 309
    //   71: iconst_1
    //   72: istore 4
    //   74: goto -40 -> 34
    //   77: iload 4
    //   79: ifeq -70 -> 9
    //   82: invokestatic 255	ct/bc:c	()V
    //   85: aload_0
    //   86: invokevirtual 79	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   89: astore_3
    //   90: aload_3
    //   91: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   94: ifne +14 -> 108
    //   97: aload_3
    //   98: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   101: istore 7
    //   103: iload 7
    //   105: ifeq +24 -> 129
    //   108: ldc2_w 87
    //   111: invokestatic 94	java/lang/Thread:sleep	(J)V
    //   114: goto -24 -> 90
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 95	java/lang/InterruptedException:printStackTrace	()V
    //   122: goto -32 -> 90
    //   125: astore_1
    //   126: goto -117 -> 9
    //   129: aload_3
    //   130: ldc -125
    //   132: iconst_1
    //   133: anewarray 135	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: ldc -114
    //   140: aastore
    //   141: aconst_null
    //   142: aconst_null
    //   143: ldc -114
    //   145: aconst_null
    //   146: ldc 125
    //   148: invokevirtual 184	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull +150 -> 303
    //   156: aload_1
    //   157: invokeinterface 259 1 0
    //   162: invokestatic 264	ct/b:a	()Lct/b;
    //   165: getfield 267	ct/b:b	Lct/d;
    //   168: getfield 272	ct/d:c	I
    //   171: if_icmple +132 -> 303
    //   174: aload_1
    //   175: invokeinterface 189 1 0
    //   180: ifeq +123 -> 303
    //   183: aload_1
    //   184: aload_1
    //   185: ldc -114
    //   187: invokeinterface 196 2 0
    //   192: invokeinterface 200 2 0
    //   197: astore_2
    //   198: aload_2
    //   199: invokestatic 278	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifne +101 -> 303
    //   205: invokestatic 255	ct/bc:c	()V
    //   208: aload_1
    //   209: ifnull +9 -> 218
    //   212: aload_1
    //   213: invokeinterface 218 1 0
    //   218: aload_2
    //   219: invokestatic 278	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne -213 -> 9
    //   225: aload_3
    //   226: ldc -125
    //   228: ldc -76
    //   230: iconst_1
    //   231: anewarray 135	java/lang/String
    //   234: dup
    //   235: iconst_0
    //   236: aload_2
    //   237: aastore
    //   238: invokevirtual 282	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   241: istore 4
    //   243: new 40	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 284
    //   250: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_2
    //   254: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 286
    //   260: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 4
    //   265: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: invokestatic 255	ct/bc:c	()V
    //   272: goto -263 -> 9
    //   275: astore_1
    //   276: aload_0
    //   277: monitorexit
    //   278: aload_1
    //   279: athrow
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull +9 -> 293
    //   287: aload_1
    //   288: invokeinterface 218 1 0
    //   293: aload_2
    //   294: athrow
    //   295: astore_1
    //   296: goto -287 -> 9
    //   299: astore_2
    //   300: goto -17 -> 283
    //   303: ldc 14
    //   305: astore_2
    //   306: goto -98 -> 208
    //   309: goto -235 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	w
    //   0	312	1	paramt	t
    //   16	238	2	localObject1	Object
    //   280	14	2	localObject2	Object
    //   299	1	2	localObject3	Object
    //   305	1	2	str	String
    //   52	174	3	localObject4	Object
    //   1	263	4	i	int
    //   20	40	5	l	long
    //   64	40	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   108	114	117	java/lang/InterruptedException
    //   82	90	125	java/lang/Exception
    //   90	103	125	java/lang/Exception
    //   108	114	125	java/lang/Exception
    //   118	122	125	java/lang/Exception
    //   212	218	125	java/lang/Exception
    //   218	272	125	java/lang/Exception
    //   287	293	125	java/lang/Exception
    //   293	295	125	java/lang/Exception
    //   12	34	275	finally
    //   34	66	275	finally
    //   82	90	275	finally
    //   90	103	275	finally
    //   108	114	275	finally
    //   118	122	275	finally
    //   212	218	275	finally
    //   218	272	275	finally
    //   287	293	275	finally
    //   293	295	275	finally
    //   129	152	280	finally
    //   12	34	295	java/lang/Exception
    //   34	66	295	java/lang/Exception
    //   156	208	299	finally
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 79	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 4
    //   8: aload 4
    //   10: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   13: ifne +15 -> 28
    //   16: aload 4
    //   18: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   21: istore 7
    //   23: iload 7
    //   25: ifeq +26 -> 51
    //   28: ldc2_w 87
    //   31: invokestatic 94	java/lang/Thread:sleep	(J)V
    //   34: goto -26 -> 8
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 95	java/lang/InterruptedException:printStackTrace	()V
    //   44: goto -36 -> 8
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: new 97	android/content/ContentValues
    //   54: dup
    //   55: invokespecial 98	android/content/ContentValues:<init>	()V
    //   58: astore 5
    //   60: aload 5
    //   62: ldc -54
    //   64: aload_3
    //   65: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload 4
    //   70: ldc -125
    //   72: aload 5
    //   74: ldc -123
    //   76: iconst_2
    //   77: anewarray 135	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: aload_1
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload_2
    //   87: aastore
    //   88: invokevirtual 140	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   91: istore 6
    //   93: new 40	java/lang/StringBuilder
    //   96: dup
    //   97: ldc_w 289
    //   100: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 291
    //   110: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload 6
    //   115: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: invokestatic 165	ct/bc:b	()V
    //   122: goto -74 -> 48
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	w
    //   0	130	1	paramString1	String
    //   0	130	2	paramString2	String
    //   0	130	3	paramString3	String
    //   6	63	4	localSQLiteDatabase	SQLiteDatabase
    //   37	3	5	localInterruptedException	InterruptedException
    //   58	15	5	localContentValues	android.content.ContentValues
    //   91	23	6	i	int
    //   21	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   28	34	37	java/lang/InterruptedException
    //   2	8	47	java/lang/Exception
    //   8	23	47	java/lang/Exception
    //   28	34	47	java/lang/Exception
    //   39	44	47	java/lang/Exception
    //   51	122	47	java/lang/Exception
    //   2	8	125	finally
    //   8	23	125	finally
    //   28	34	125	finally
    //   39	44	125	finally
    //   51	122	125	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      bc.b();
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
      bc.d();
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        bc.b();
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 300	android/database/sqlite/SQLiteOpenHelper:onOpen	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   5: aload_1
    //   6: invokevirtual 303	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +16 -> 27
    //   14: iload_2
    //   15: iconst_5
    //   16: if_icmpge +12 -> 28
    //   19: aload_1
    //   20: invokestatic 305	ct/w:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   23: aload_1
    //   24: invokestatic 307	ct/w:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   27: return
    //   28: iload_2
    //   29: iconst_5
    //   30: if_icmple -3 -> 27
    //   33: aload_1
    //   34: invokestatic 305	ct/w:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   37: aload_1
    //   38: invokestatic 307	ct/w:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   41: return
    //   42: astore_1
    //   43: return
    //   44: astore_1
    //   45: return
    //   46: astore_1
    //   47: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	w
    //   0	48	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	22	2	i	int
    // Exception table:
    //   from	to	target	type
    //   33	41	42	java/lang/Exception
    //   5	10	44	java/lang/Exception
    //   19	27	46	java/lang/Exception
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        bc.b();
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */