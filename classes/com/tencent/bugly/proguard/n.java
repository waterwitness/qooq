package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class n
{
  public static boolean a = false;
  private static n b = null;
  private static o c = null;
  
  private n(Context paramContext, List<a> paramList)
  {
    c = new o(paramContext, paramList);
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, m paramm)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 8
    //   6: aload_0
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 5
    //   14: getstatic 18	com/tencent/bugly/proguard/n:c	Lcom/tencent/bugly/proguard/o;
    //   17: invokevirtual 41	com/tencent/bugly/proguard/o:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore 7
    //   22: aload 7
    //   24: ifnull +21 -> 45
    //   27: aload 7
    //   29: astore 5
    //   31: aload 7
    //   33: astore 6
    //   35: aload 7
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   43: istore 8
    //   45: aload 4
    //   47: ifnull +3 -> 50
    //   50: iload 8
    //   52: istore 9
    //   54: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   57: ifeq +21 -> 78
    //   60: iload 8
    //   62: istore 9
    //   64: aload 7
    //   66: ifnull +12 -> 78
    //   69: aload 7
    //   71: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   74: iload 8
    //   76: istore 9
    //   78: aload_0
    //   79: monitorexit
    //   80: iload 9
    //   82: ireturn
    //   83: astore_1
    //   84: aload 5
    //   86: astore 6
    //   88: aload_1
    //   89: invokestatic 55	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   92: ifne +11 -> 103
    //   95: aload 5
    //   97: astore 6
    //   99: aload_1
    //   100: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   103: aload 4
    //   105: ifnull +3 -> 108
    //   108: iload 10
    //   110: istore 9
    //   112: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   115: ifeq -37 -> 78
    //   118: iload 10
    //   120: istore 9
    //   122: aload 5
    //   124: ifnull -46 -> 78
    //   127: aload 5
    //   129: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: iload 10
    //   134: istore 9
    //   136: goto -58 -> 78
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: aload 4
    //   147: ifnull +3 -> 150
    //   150: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   153: ifeq +13 -> 166
    //   156: aload 6
    //   158: ifnull +8 -> 166
    //   161: aload 6
    //   163: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	n
    //   0	168	1	paramString1	String
    //   0	168	2	paramString2	String
    //   0	168	3	paramArrayOfString	String[]
    //   0	168	4	paramm	m
    //   12	116	5	localObject1	Object
    //   9	153	6	localObject2	Object
    //   20	50	7	localSQLiteDatabase	SQLiteDatabase
    //   4	71	8	i	int
    //   52	83	9	j	int
    //   1	132	10	k	int
    // Exception table:
    //   from	to	target	type
    //   14	22	83	java/lang/Throwable
    //   35	45	83	java/lang/Throwable
    //   54	60	139	finally
    //   69	74	139	finally
    //   112	118	139	finally
    //   127	132	139	finally
    //   150	156	139	finally
    //   161	166	139	finally
    //   166	168	139	finally
    //   14	22	144	finally
    //   35	45	144	finally
    //   88	95	144	finally
    //   99	103	144	finally
  }
  
  private long a(String paramString, ContentValues paramContentValues, m paramm)
  {
    l2 = 0L;
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = c.getWritableDatabase();
        l1 = l2;
        if (localSQLiteDatabase != null)
        {
          l1 = l2;
          if (paramContentValues != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            l1 = localSQLiteDatabase.replace(paramString, "_id", paramContentValues);
            if (l1 < 0L) {
              continue;
            }
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            v.c("[db] insert %s success", new Object[] { paramString });
          }
        }
        if (paramm != null) {}
        l3 = l1;
      }
      catch (Throwable paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        long l1;
        localObject2 = localObject1;
        if (!v.a(paramString))
        {
          localObject2 = localObject1;
          paramString.printStackTrace();
        }
        if (paramm != null) {}
        long l3 = l2;
        if (!a) {
          continue;
        }
        l3 = l2;
        if (localObject1 == null) {
          continue;
        }
        ((SQLiteDatabase)localObject1).close();
        l3 = l2;
        continue;
      }
      finally
      {
        if ((paramm != null) && ((!a) || (localObject2 == null))) {
          continue;
        }
        ((SQLiteDatabase)localObject2).close();
      }
      try
      {
        if (a)
        {
          l3 = l1;
          if (localSQLiteDatabase != null)
          {
            localSQLiteDatabase.close();
            l3 = l1;
          }
        }
        return l3;
      }
      finally {}
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      v.d("[db] replace %s error", new Object[] { paramString });
    }
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, m paramm)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
      if (localSQLiteDatabase == null) {
        break label80;
      }
      paramString1 = localSQLiteDatabase.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        if (!v.a(paramString1)) {
          paramString1.printStackTrace();
        }
        if (paramm == null) {
          break;
        }
        paramString1 = null;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          throw paramString1;
        }
        finally {}
        paramString1 = null;
        continue;
        label80:
        paramString1 = null;
      }
    }
    if (paramm != null) {}
    return paramString1;
  }
  
  public static n a()
  {
    try
    {
      n localn = b;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static n a(Context paramContext, List<a> paramList)
  {
    try
    {
      if (b == null) {
        b = new n(paramContext, paramList);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private static p a(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return null;
      try
      {
        p localp = new p();
        localp.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localp.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
        localp.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
        localp.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
        localp.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        localp.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        return localp;
      }
      catch (Throwable paramCursor) {}
    } while (v.a(paramCursor));
    paramCursor.printStackTrace();
    return null;
  }
  
  /* Error */
  private Map<String, byte[]> a(int paramInt, m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 148	com/tencent/bugly/proguard/n:c	(I)Ljava/util/List;
    //   5: astore 4
    //   7: new 150	java/util/HashMap
    //   10: dup
    //   11: invokespecial 151	java/util/HashMap:<init>	()V
    //   14: astore_3
    //   15: aload 4
    //   17: invokeinterface 157 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 163 1 0
    //   31: ifeq +65 -> 96
    //   34: aload 4
    //   36: invokeinterface 167 1 0
    //   41: checkcast 93	com/tencent/bugly/proguard/p
    //   44: astore 5
    //   46: aload 5
    //   48: getfield 144	com/tencent/bugly/proguard/p:g	[B
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull -31 -> 24
    //   58: aload_3
    //   59: aload 5
    //   61: getfield 170	com/tencent/bugly/proguard/p:f	Ljava/lang/String;
    //   64: aload 6
    //   66: invokeinterface 176 3 0
    //   71: pop
    //   72: goto -48 -> 24
    //   75: astore 4
    //   77: aload 4
    //   79: invokestatic 55	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   82: ifne +8 -> 90
    //   85: aload 4
    //   87: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   90: aload_2
    //   91: ifnull +3 -> 94
    //   94: aload_3
    //   95: areturn
    //   96: aload_2
    //   97: ifnull +15 -> 112
    //   100: aload_3
    //   101: areturn
    //   102: astore_2
    //   103: aload_2
    //   104: athrow
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_3
    //   109: goto -32 -> 77
    //   112: aload_3
    //   113: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	n
    //   0	114	1	paramInt	int
    //   0	114	2	paramm	m
    //   14	99	3	localHashMap	java.util.HashMap
    //   5	30	4	localObject	Object
    //   75	11	4	localThrowable1	Throwable
    //   105	1	4	localThrowable2	Throwable
    //   44	16	5	localp	p
    //   51	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	24	75	java/lang/Throwable
    //   24	53	75	java/lang/Throwable
    //   58	72	75	java/lang/Throwable
    //   0	15	102	finally
    //   15	24	102	finally
    //   24	53	102	finally
    //   58	72	102	finally
    //   77	90	102	finally
    //   0	15	105	java/lang/Throwable
  }
  
  public static void a(List<p> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
      if (localSQLiteDatabase == null) {
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (p)paramList.next();
        localStringBuilder.append(" or _id").append(" = ").append(((p)localObject).a);
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<p>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        v.c("deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", paramList, null)) });
        return;
      }
      catch (Throwable paramList)
      {
        if (!v.a(paramList)) {
          paramList.printStackTrace();
        }
        return;
      }
      finally
      {
        if (a) {
          localSQLiteDatabase.close();
        }
      }
    }
  }
  
  public static boolean a(int paramInt, String paramString, m paramm)
  {
    localObject2 = null;
    localObject1 = null;
    bool2 = true;
    bool3 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = c.getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          if (paramString == null) {
            continue;
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (paramString.trim().length() <= 0) {
            continue;
          }
          i = 0;
          if (i == 0) {
            continue;
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          paramString = "_id = " + paramInt;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          paramInt = localSQLiteDatabase.delete("t_pf", paramString, null);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          v.c("deleted %s data %d", new Object[] { "t_pf", Integer.valueOf(paramInt) });
          if (paramInt <= 0) {
            continue;
          }
          bool1 = bool2;
        }
        if (paramm != null) {}
        bool2 = bool1;
        if (a)
        {
          bool2 = bool1;
          if (localSQLiteDatabase != null)
          {
            localSQLiteDatabase.close();
            bool2 = bool1;
          }
        }
      }
      catch (Throwable paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        int i;
        localObject2 = localObject1;
        if (v.a(paramString)) {
          continue;
        }
        localObject2 = localObject1;
        paramString.printStackTrace();
        if (paramm == null) {
          continue;
        }
        bool2 = bool3;
        if (!a) {
          continue;
        }
        bool2 = bool3;
        if (localObject1 == null) {
          continue;
        }
        ((SQLiteDatabase)localObject1).close();
        return false;
      }
      finally
      {
        if ((paramm != null) && ((!a) || (localObject2 == null))) {
          continue;
        }
        ((SQLiteDatabase)localObject2).close();
      }
      return bool2;
      i = 1;
      continue;
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      paramString = "_id = " + paramInt + " and _tp" + " = \"" + paramString + "\"";
      continue;
      bool1 = false;
    }
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, m paramm)
  {
    boolean bool1 = false;
    try
    {
      p localp = new p();
      localp.a = paramInt;
      localp.f = paramString;
      localp.e = System.currentTimeMillis();
      localp.g = paramArrayOfByte;
      boolean bool2 = b(localp);
      bool1 = bool2;
    }
    catch (Throwable paramString)
    {
      if (v.a(paramString)) {
        break label71;
      }
      paramString.printStackTrace();
      return false;
    }
    finally
    {
      if (paramm == null) {
        break label84;
      }
    }
    return bool1;
  }
  
  private static p b(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return null;
      try
      {
        p localp = new p();
        localp.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localp.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        localp.f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
        localp.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        return localp;
      }
      catch (Throwable paramCursor) {}
    } while (v.a(paramCursor));
    paramCursor.printStackTrace();
    return null;
  }
  
  public static void b(int paramInt)
  {
    String str = null;
    SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
    if ((localSQLiteDatabase == null) || (paramInt >= 0)) {}
    try
    {
      str = "_tp = " + paramInt;
      v.c("deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", str, null)) });
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      return;
    }
    finally
    {
      if (a) {
        localSQLiteDatabase.close();
      }
    }
  }
  
  private boolean b(p paramp)
  {
    if (paramp == null) {}
    for (;;)
    {
      return false;
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          ContentValues localContentValues = d(paramp);
          if (localContentValues != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            long l = localSQLiteDatabase.replace("t_pf", "_id", localContentValues);
            if (l >= 0L)
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              v.c("insert %s success!", new Object[] { "t_pf" });
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              paramp.a = l;
              if ((a) && (localSQLiteDatabase != null)) {
                localSQLiteDatabase.close();
              }
              return true;
            }
            if ((!a) || (localSQLiteDatabase == null)) {
              continue;
            }
            localSQLiteDatabase.close();
            return false;
          }
        }
        if ((!a) || (localSQLiteDatabase == null)) {
          continue;
        }
        localSQLiteDatabase.close();
        return false;
      }
      catch (Throwable paramp)
      {
        localObject2 = localObject1;
        if (!v.a(paramp))
        {
          localObject2 = localObject1;
          paramp.printStackTrace();
        }
        return false;
      }
      finally
      {
        if ((a) && (localObject2 != null)) {
          ((SQLiteDatabase)localObject2).close();
        }
      }
    }
  }
  
  private static ContentValues c(p paramp)
  {
    if (paramp == null) {}
    do
    {
      return null;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramp.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramp.a));
        }
        localContentValues.put("_tp", Integer.valueOf(paramp.b));
        localContentValues.put("_pc", paramp.c);
        localContentValues.put("_th", paramp.d);
        localContentValues.put("_tm", Long.valueOf(paramp.e));
        if (paramp.g != null) {
          localContentValues.put("_dt", paramp.g);
        }
        return localContentValues;
      }
      catch (Throwable paramp) {}
    } while (v.a(paramp));
    paramp.printStackTrace();
    return null;
  }
  
  /* Error */
  private List<p> c(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 18	com/tencent/bugly/proguard/n:c	Lcom/tencent/bugly/proguard/o;
    //   6: invokevirtual 41	com/tencent/bugly/proguard/o:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +371 -> 382
    //   14: new 187	java/lang/StringBuilder
    //   17: dup
    //   18: ldc -24
    //   20: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: iload_1
    //   24: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 4
    //   32: aload_2
    //   33: ldc -16
    //   35: aconst_null
    //   36: aload 4
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 289	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnonnull +38 -> 85
    //   50: aload_3
    //   51: ifnull +18 -> 69
    //   54: aload_3
    //   55: invokeinterface 292 1 0
    //   60: ifne +9 -> 69
    //   63: aload_3
    //   64: invokeinterface 293 1 0
    //   69: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   72: ifeq +11 -> 83
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   83: aconst_null
    //   84: areturn
    //   85: new 187	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   92: astore 5
    //   94: new 295	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 296	java/util/ArrayList:<init>	()V
    //   101: astore 6
    //   103: aload_3
    //   104: invokeinterface 299 1 0
    //   109: ifeq +176 -> 285
    //   112: aload_3
    //   113: invokestatic 301	com/tencent/bugly/proguard/n:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/p;
    //   116: astore 7
    //   118: aload 7
    //   120: ifnull +66 -> 186
    //   123: aload 6
    //   125: aload 7
    //   127: invokeinterface 305 2 0
    //   132: pop
    //   133: goto -30 -> 103
    //   136: astore 4
    //   138: aload 4
    //   140: invokestatic 55	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   143: ifne +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   151: aload_3
    //   152: ifnull +18 -> 170
    //   155: aload_3
    //   156: invokeinterface 292 1 0
    //   161: ifne +9 -> 170
    //   164: aload_3
    //   165: invokeinterface 293 1 0
    //   170: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   173: ifeq +11 -> 184
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: aload_3
    //   187: aload_3
    //   188: ldc 109
    //   190: invokeinterface 100 2 0
    //   195: invokeinterface 122 2 0
    //   200: astore 7
    //   202: aload 5
    //   204: ldc_w 307
    //   207: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc -60
    //   212: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 7
    //   217: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: goto -118 -> 103
    //   224: astore 7
    //   226: ldc_w 309
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 78	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   236: pop
    //   237: goto -134 -> 103
    //   240: astore 5
    //   242: aload_2
    //   243: astore 4
    //   245: aload 5
    //   247: astore_2
    //   248: aload_3
    //   249: ifnull +18 -> 267
    //   252: aload_3
    //   253: invokeinterface 292 1 0
    //   258: ifne +9 -> 267
    //   261: aload_3
    //   262: invokeinterface 293 1 0
    //   267: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   270: ifeq +13 -> 283
    //   273: aload 4
    //   275: ifnull +8 -> 283
    //   278: aload 4
    //   280: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   283: aload_2
    //   284: athrow
    //   285: aload 5
    //   287: invokevirtual 310	java/lang/StringBuilder:length	()I
    //   290: ifle +56 -> 346
    //   293: aload 5
    //   295: ldc_w 312
    //   298: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc -60
    //   303: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload_1
    //   307: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: ldc_w 314
    //   314: iconst_2
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: ldc -16
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: aload_2
    //   326: ldc -16
    //   328: aload 4
    //   330: iconst_4
    //   331: invokevirtual 211	java/lang/String:substring	(I)Ljava/lang/String;
    //   334: aconst_null
    //   335: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   338: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: invokestatic 78	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   345: pop
    //   346: aload_3
    //   347: ifnull +18 -> 365
    //   350: aload_3
    //   351: invokeinterface 292 1 0
    //   356: ifne +9 -> 365
    //   359: aload_3
    //   360: invokeinterface 293 1 0
    //   365: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   368: ifeq +11 -> 379
    //   371: aload_2
    //   372: ifnull +7 -> 379
    //   375: aload_2
    //   376: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   379: aload 6
    //   381: areturn
    //   382: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   385: ifeq -201 -> 184
    //   388: aload_2
    //   389: ifnull -205 -> 184
    //   392: aload_2
    //   393: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   396: goto -212 -> 184
    //   399: astore_2
    //   400: aconst_null
    //   401: astore_3
    //   402: goto -154 -> 248
    //   405: astore 5
    //   407: aconst_null
    //   408: astore_3
    //   409: aload_2
    //   410: astore 4
    //   412: aload 5
    //   414: astore_2
    //   415: goto -167 -> 248
    //   418: astore 5
    //   420: aload_2
    //   421: astore 4
    //   423: aload 5
    //   425: astore_2
    //   426: goto -178 -> 248
    //   429: astore 4
    //   431: aconst_null
    //   432: astore_2
    //   433: aconst_null
    //   434: astore_3
    //   435: goto -297 -> 138
    //   438: astore 4
    //   440: aconst_null
    //   441: astore_3
    //   442: goto -304 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	n
    //   0	445	1	paramInt	int
    //   9	384	2	localObject1	Object
    //   399	11	2	localObject2	Object
    //   414	19	2	localObject3	Object
    //   45	397	3	localCursor	Cursor
    //   1	36	4	str	String
    //   136	11	4	localThrowable1	Throwable
    //   243	179	4	localObject4	Object
    //   429	1	4	localThrowable2	Throwable
    //   438	1	4	localThrowable3	Throwable
    //   92	111	5	localStringBuilder	StringBuilder
    //   240	54	5	localObject5	Object
    //   405	8	5	localObject6	Object
    //   418	6	5	localObject7	Object
    //   101	279	6	localArrayList	java.util.ArrayList
    //   116	100	7	localObject8	Object
    //   224	1	7	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   85	103	136	java/lang/Throwable
    //   103	118	136	java/lang/Throwable
    //   123	133	136	java/lang/Throwable
    //   226	237	136	java/lang/Throwable
    //   285	346	136	java/lang/Throwable
    //   186	221	224	java/lang/Throwable
    //   85	103	240	finally
    //   103	118	240	finally
    //   123	133	240	finally
    //   186	221	240	finally
    //   226	237	240	finally
    //   285	346	240	finally
    //   3	10	399	finally
    //   14	46	405	finally
    //   138	151	418	finally
    //   3	10	429	java/lang/Throwable
    //   14	46	438	java/lang/Throwable
  }
  
  private static ContentValues d(p paramp)
  {
    Object localObject;
    int i;
    if (paramp != null)
    {
      localObject = paramp.f;
      if ((localObject != null) && (((String)localObject).trim().length() > 0))
      {
        i = 0;
        if (i == 0) {
          break label38;
        }
      }
    }
    else
    {
      localObject = null;
    }
    for (;;)
    {
      return (ContentValues)localObject;
      i = 1;
      break;
      try
      {
        label38:
        ContentValues localContentValues = new ContentValues();
        if (paramp.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramp.a));
        }
        localContentValues.put("_tp", paramp.f);
        localContentValues.put("_tm", Long.valueOf(paramp.e));
        localObject = localContentValues;
        if (paramp.g != null)
        {
          localContentValues.put("_dt", paramp.g);
          return localContentValues;
        }
      }
      catch (Throwable paramp)
      {
        if (!v.a(paramp)) {
          paramp.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, m paramm, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, m paramm, boolean paramBoolean)
  {
    return a(paramString, paramContentValues, null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, m paramm, boolean paramBoolean)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  /* Error */
  public final List<p> a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/bugly/proguard/n:c	Lcom/tencent/bugly/proguard/o;
    //   3: invokevirtual 41	com/tencent/bugly/proguard/o:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +190 -> 200
    //   13: iload_1
    //   14: iflt +71 -> 85
    //   17: new 187	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 261
    //   24: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: iload_1
    //   28: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_2
    //   35: aload 5
    //   37: ldc -37
    //   39: aconst_null
    //   40: aload_2
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 289	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnonnull +40 -> 90
    //   53: aload_3
    //   54: ifnull +18 -> 72
    //   57: aload_3
    //   58: invokeinterface 292 1 0
    //   63: ifne +9 -> 72
    //   66: aload_3
    //   67: invokeinterface 293 1 0
    //   72: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   75: ifeq +8 -> 83
    //   78: aload 5
    //   80: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   83: aconst_null
    //   84: areturn
    //   85: aconst_null
    //   86: astore_2
    //   87: goto -52 -> 35
    //   90: aload_3
    //   91: astore_2
    //   92: new 187	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   99: astore 6
    //   101: aload_3
    //   102: astore_2
    //   103: new 295	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 296	java/util/ArrayList:<init>	()V
    //   110: astore 4
    //   112: aload_3
    //   113: astore_2
    //   114: aload_3
    //   115: invokeinterface 299 1 0
    //   120: ifeq +179 -> 299
    //   123: aload_3
    //   124: astore_2
    //   125: aload_3
    //   126: invokestatic 320	com/tencent/bugly/proguard/n:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/p;
    //   129: astore 7
    //   131: aload 7
    //   133: ifnull +69 -> 202
    //   136: aload_3
    //   137: astore_2
    //   138: aload 4
    //   140: aload 7
    //   142: invokeinterface 305 2 0
    //   147: pop
    //   148: goto -36 -> 112
    //   151: astore 4
    //   153: aload_3
    //   154: astore_2
    //   155: aload 4
    //   157: invokestatic 55	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   160: ifne +10 -> 170
    //   163: aload_3
    //   164: astore_2
    //   165: aload 4
    //   167: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   170: aload_3
    //   171: ifnull +18 -> 189
    //   174: aload_3
    //   175: invokeinterface 292 1 0
    //   180: ifne +9 -> 189
    //   183: aload_3
    //   184: invokeinterface 293 1 0
    //   189: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   192: ifeq +8 -> 200
    //   195: aload 5
    //   197: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   200: aconst_null
    //   201: areturn
    //   202: aload_3
    //   203: astore_2
    //   204: aload_3
    //   205: aload_3
    //   206: ldc 64
    //   208: invokeinterface 100 2 0
    //   213: invokeinterface 104 2 0
    //   218: lstore 8
    //   220: aload_3
    //   221: astore_2
    //   222: aload 6
    //   224: ldc -66
    //   226: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc -60
    //   231: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: lload 8
    //   236: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: goto -128 -> 112
    //   243: astore_2
    //   244: aload_3
    //   245: astore_2
    //   246: ldc_w 309
    //   249: iconst_0
    //   250: anewarray 4	java/lang/Object
    //   253: invokestatic 78	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   256: pop
    //   257: goto -145 -> 112
    //   260: astore 4
    //   262: aload_2
    //   263: astore_3
    //   264: aload 4
    //   266: astore_2
    //   267: aload_3
    //   268: ifnull +18 -> 286
    //   271: aload_3
    //   272: invokeinterface 292 1 0
    //   277: ifne +9 -> 286
    //   280: aload_3
    //   281: invokeinterface 293 1 0
    //   286: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   289: ifeq +8 -> 297
    //   292: aload 5
    //   294: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   297: aload_2
    //   298: athrow
    //   299: aload_3
    //   300: astore_2
    //   301: aload 6
    //   303: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore 6
    //   308: aload_3
    //   309: astore_2
    //   310: aload 6
    //   312: invokevirtual 208	java/lang/String:length	()I
    //   315: ifle +41 -> 356
    //   318: aload_3
    //   319: astore_2
    //   320: ldc_w 314
    //   323: iconst_2
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: ldc -37
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: aload 5
    //   336: ldc -37
    //   338: aload 6
    //   340: iconst_4
    //   341: invokevirtual 211	java/lang/String:substring	(I)Ljava/lang/String;
    //   344: aconst_null
    //   345: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   348: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: aastore
    //   352: invokestatic 78	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   355: pop
    //   356: aload_3
    //   357: ifnull +18 -> 375
    //   360: aload_3
    //   361: invokeinterface 292 1 0
    //   366: ifne +9 -> 375
    //   369: aload_3
    //   370: invokeinterface 293 1 0
    //   375: getstatic 20	com/tencent/bugly/proguard/n:a	Z
    //   378: ifeq +8 -> 386
    //   381: aload 5
    //   383: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   386: aload 4
    //   388: areturn
    //   389: astore_2
    //   390: aconst_null
    //   391: astore_3
    //   392: goto -125 -> 267
    //   395: astore 4
    //   397: aconst_null
    //   398: astore_3
    //   399: goto -246 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	n
    //   0	402	1	paramInt	int
    //   34	188	2	localObject1	Object
    //   243	1	2	localThrowable1	Throwable
    //   245	75	2	localObject2	Object
    //   389	1	2	localObject3	Object
    //   48	351	3	localObject4	Object
    //   110	29	4	localArrayList	java.util.ArrayList
    //   151	15	4	localThrowable2	Throwable
    //   260	127	4	localList	List<p>
    //   395	1	4	localThrowable3	Throwable
    //   6	376	5	localSQLiteDatabase	SQLiteDatabase
    //   99	240	6	localObject5	Object
    //   129	12	7	localp	p
    //   218	17	8	l	long
    // Exception table:
    //   from	to	target	type
    //   92	101	151	java/lang/Throwable
    //   103	112	151	java/lang/Throwable
    //   114	123	151	java/lang/Throwable
    //   125	131	151	java/lang/Throwable
    //   138	148	151	java/lang/Throwable
    //   246	257	151	java/lang/Throwable
    //   301	308	151	java/lang/Throwable
    //   310	318	151	java/lang/Throwable
    //   320	356	151	java/lang/Throwable
    //   204	220	243	java/lang/Throwable
    //   222	240	243	java/lang/Throwable
    //   92	101	260	finally
    //   103	112	260	finally
    //   114	123	260	finally
    //   125	131	260	finally
    //   138	148	260	finally
    //   155	163	260	finally
    //   165	170	260	finally
    //   204	220	260	finally
    //   222	240	260	finally
    //   246	257	260	finally
    //   301	308	260	finally
    //   310	318	260	finally
    //   320	356	260	finally
    //   17	35	389	finally
    //   35	49	389	finally
    //   17	35	395	java/lang/Throwable
    //   35	49	395	java/lang/Throwable
  }
  
  public final Map<String, byte[]> a(int paramInt, m paramm, boolean paramBoolean)
  {
    return a(paramInt, null);
  }
  
  public final boolean a(int paramInt, String paramString, m paramm, boolean paramBoolean)
  {
    return a(paramInt, paramString, null);
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, m paramm, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramm = new a(4, null);
      paramm.a(paramInt, paramString, paramArrayOfByte);
      u.a().b(paramm);
      return true;
    }
    return a(paramInt, paramString, paramArrayOfByte, null);
  }
  
  public final boolean a(p paramp)
  {
    if (paramp == null) {}
    for (;;)
    {
      return false;
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          ContentValues localContentValues = c(paramp);
          if (localContentValues != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            long l = localSQLiteDatabase.replace("t_lr", "_id", localContentValues);
            if (l >= 0L)
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              v.c("insert %s success!", new Object[] { "t_lr" });
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              paramp.a = l;
              if ((a) && (localSQLiteDatabase != null)) {
                localSQLiteDatabase.close();
              }
              return true;
            }
            if ((!a) || (localSQLiteDatabase == null)) {
              continue;
            }
            localSQLiteDatabase.close();
            return false;
          }
        }
        if ((!a) || (localSQLiteDatabase == null)) {
          continue;
        }
        localSQLiteDatabase.close();
        return false;
      }
      catch (Throwable paramp)
      {
        localObject2 = localObject1;
        if (!v.a(paramp))
        {
          localObject2 = localObject1;
          paramp.printStackTrace();
        }
        return false;
      }
      finally
      {
        if ((a) && (localObject2 != null)) {
          ((SQLiteDatabase)localObject2).close();
        }
      }
    }
  }
  
  final class a
    extends Thread
  {
    private int a;
    private m b;
    private String c;
    private ContentValues d;
    private boolean e;
    private String[] f;
    private String g;
    private String[] h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String[] n;
    private int o;
    private String p;
    private byte[] q;
    
    public a(int paramInt, m paramm)
    {
      this.a = paramInt;
      this.b = paramm;
    }
    
    public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
    {
      this.o = paramInt;
      this.p = paramString;
      this.q = paramArrayOfByte;
    }
    
    public final void a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.e = paramBoolean;
      this.c = paramString1;
      this.f = paramArrayOfString1;
      this.g = paramString2;
      this.h = paramArrayOfString2;
      this.i = paramString3;
      this.j = paramString4;
      this.k = paramString5;
      this.l = paramString6;
    }
    
    public final void run()
    {
      switch (this.a)
      {
      default: 
        return;
      case 1: 
        n.a(n.this, this.c, this.d, this.b);
        return;
      case 2: 
        n.a(n.this, this.c, this.m, this.n, this.b);
        return;
      case 3: 
        n.a(n.this, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
        return;
      case 4: 
        n.a(n.this, this.o, this.p, this.q, this.b);
        return;
      case 5: 
        n.a(n.this, this.o, this.b);
        return;
      }
      n localn = n.this;
      n.a(this.o, this.p, this.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */