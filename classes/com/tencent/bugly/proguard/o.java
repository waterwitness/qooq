package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import com.tencent.bugly.crashreport.common.info.b;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class o
  extends SQLiteOpenHelper
{
  private static int a = 12;
  private Context b;
  private List<a> c;
  
  public o(Context paramContext, List<a> paramList)
  {
    super(paramContext, localStringBuilder.toString(), null, a);
    this.b = paramContext;
    this.c = paramList;
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: iconst_4
    //   6: anewarray 54	java/lang/String
    //   9: astore_2
    //   10: aload_2
    //   11: iconst_0
    //   12: ldc 56
    //   14: aastore
    //   15: aload_2
    //   16: iconst_1
    //   17: ldc 58
    //   19: aastore
    //   20: aload_2
    //   21: iconst_2
    //   22: ldc 60
    //   24: aastore
    //   25: aload_2
    //   26: iconst_3
    //   27: ldc 62
    //   29: aastore
    //   30: aload_2
    //   31: arraylength
    //   32: istore 5
    //   34: iconst_0
    //   35: istore 4
    //   37: iload 7
    //   39: istore 6
    //   41: iload 4
    //   43: iload 5
    //   45: if_icmpge +52 -> 97
    //   48: aload_2
    //   49: iload 4
    //   51: aaload
    //   52: astore_3
    //   53: aload_1
    //   54: new 20	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 64
    //   60: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 73	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   73: iload 4
    //   75: iconst_1
    //   76: iadd
    //   77: istore 4
    //   79: goto -42 -> 37
    //   82: astore_1
    //   83: aload_1
    //   84: invokestatic 78	com/tencent/bugly/proguard/v:b	(Ljava/lang/Throwable;)Z
    //   87: ifne +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 81	java/lang/Throwable:printStackTrace	()V
    //   94: iconst_0
    //   95: istore 6
    //   97: aload_0
    //   98: monitorexit
    //   99: iload 6
    //   101: ireturn
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	o
    //   0	107	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	40	2	arrayOfString	String[]
    //   52	12	3	str	String
    //   35	43	4	i	int
    //   32	14	5	j	int
    //   39	61	6	bool1	boolean
    //   1	37	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	10	82	java/lang/Throwable
    //   30	34	82	java/lang/Throwable
    //   53	73	82	java/lang/Throwable
    //   5	10	102	finally
    //   30	34	102	finally
    //   53	73	102	finally
    //   83	94	102	finally
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    int i = 0;
    Object localObject = null;
    while ((localObject == null) && (i < 5))
    {
      i += 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getReadableDatabase();
        localObject = localSQLiteDatabase2;
      }
      catch (Throwable localThrowable)
      {
        v.d("try db count %d", new Object[] { Integer.valueOf(i) });
        if (i == 5) {
          v.e("get db fail!", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    return localSQLiteDatabase1;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    int i = 0;
    Object localObject = null;
    while ((localObject == null) && (i < 5))
    {
      i += 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        localObject = localSQLiteDatabase2;
      }
      catch (Throwable localThrowable)
      {
        v.d("try db %d", new Object[] { Integer.valueOf(i) });
        if (i == 5) {
          v.e("get db fail!", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    if (localSQLiteDatabase1 == null) {
      v.d("db error delay error record 1min", new Object[0]);
    }
    return localSQLiteDatabase1;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_ui").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _ut").append(" int").append(" , _tp").append(" int").append(" , _dt").append(" blob").append(" , _pc").append(" text").append(" ) ");
        v.c("create %s", new Object[] { ((StringBuilder)localObject).toString() });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_lr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tp").append(" int").append(" , _tm").append(" int").append(" , _pc").append(" text").append(" , _th").append(" text").append(" , _dt").append(" blob").append(" ) ");
        v.c("create %s", new Object[] { ((StringBuilder)localObject).toString() });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_pf").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
        v.c("create %s", new Object[] { ((StringBuilder)localObject).toString() });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_crd").append(" ( _id").append(" integer").append(" , _pc").append(" text").append(" , _tm").append(" int").append(" , _fl").append(" int").append(" , _sv").append(" text").append(" , _av").append(" text").append(" , _uid").append(" integer").append(",primary key(_id").append(",_pc").append(",_uid").append(" )) ");
        v.c("create %s", new Object[] { ((StringBuilder)localObject).toString() });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS t_cr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _s1").append(" text").append(" , _up").append(" int").append(" , _me").append(" int").append(" , _uc").append(" int").append(" , _dt").append(" blob").append(" ) ");
        v.c("create %s", new Object[] { localObject });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS dl_1002").append(" (_id").append(" integer primary key autoincrement, _dUrl").append(" varchar(100), _sFile").append(" varchar(100), _sLen").append(" INTEGER, _tLen").append(" INTEGER, _MD5").append(" varchar(100), _DLTIME").append(" INTEGER)");
        v.c("create %s", new Object[] { localObject });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS ge_1002").append(" (_id").append(" integer primary key autoincrement, _time").append(" INTEGER, _datas").append(" blob)");
        v.c("create %s", new Object[] { localObject });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append(" CREATE TABLE IF NOT EXISTS st_1002").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
        v.c("create %s", new Object[] { ((StringBuilder)localObject).toString() });
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
        localObject = this.c;
        if (localObject == null) {
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        if (v.b(localThrowable1)) {
          continue;
        }
        localThrowable1.printStackTrace();
        continue;
      }
      finally {}
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        try
        {
          locala.onDbCreate(paramSQLiteDatabase);
        }
        catch (Throwable localThrowable2) {}
        if (!v.b(localThrowable2)) {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  @TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      if (b.c() < 11) {
        break label121;
      }
      v.d("drowngrade %d to %d drop tables!}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.c != null)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          try
          {
            locala.onDbDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
          }
          catch (Throwable localThrowable) {}
          if (!v.b(localThrowable)) {
            localThrowable.printStackTrace();
          }
        }
      }
      if (!a(paramSQLiteDatabase)) {
        break label124;
      }
    }
    finally {}
    onCreate(paramSQLiteDatabase);
    for (;;)
    {
      label121:
      return;
      label124:
      v.d("drop fail delete db", new Object[0]);
      paramSQLiteDatabase = this.b.getDatabasePath("bugly_db");
      if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
        paramSQLiteDatabase.delete();
      }
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      v.d("upgrade %d to %d , drop tables!", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.c != null)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          try
          {
            locala.onDbUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
          }
          catch (Throwable localThrowable) {}
          if (!v.b(localThrowable)) {
            localThrowable.printStackTrace();
          }
        }
      }
      if (!a(paramSQLiteDatabase)) {
        break label117;
      }
    }
    finally {}
    onCreate(paramSQLiteDatabase);
    for (;;)
    {
      return;
      label117:
      v.d("drop fail delete db", new Object[0]);
      paramSQLiteDatabase = this.b.getDatabasePath("bugly_db");
      if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
        paramSQLiteDatabase.delete();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */