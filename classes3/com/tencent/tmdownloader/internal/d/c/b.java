package com.tencent.tmdownloader.internal.d.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmdownloader.internal.d.a.a;
import java.util.ArrayList;

public class b
  implements c
{
  private static int a(com.tencent.tmdownloader.internal.a.d paramd, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (paramd == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmdownloader.internal.a.d.a(localContentValues, paramd);
        int j = paramSQLiteDatabase.update("downloadInfo", localContentValues, "taskUrl = ?", new String[] { paramd.b });
        i = j;
        if (j <= 0) {
          return 0;
        }
      }
      catch (Exception paramd)
      {
        m.c("DownloadInfoTable", "exception: ", paramd);
        paramd.printStackTrace();
      }
    }
    return -2;
  }
  
  public static void a(com.tencent.tmdownloader.internal.a.d paramd)
  {
    if (paramd != null) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if ((localSQLiteDatabase != null) && (a(paramd, localSQLiteDatabase) <= 0))
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmdownloader.internal.a.d.a(localContentValues, paramd);
        localSQLiteDatabase.insert("downloadInfo", null, localContentValues);
      }
      return;
    }
    catch (Exception paramd)
    {
      m.c("DownloadInfoTable", "exception: ", paramd);
      paramd.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.delete("downloadInfo", "taskUrl = ?", new String[] { paramString });
      }
      return;
    }
    catch (Exception paramString)
    {
      m.c("DownloadInfoTable", "exception: ", paramString);
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static void a(ArrayList<com.tencent.tmdownloader.internal.a.d> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +92 -> 93
    //   4: invokestatic 58	com/tencent/tmdownloader/internal/d/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   7: invokevirtual 64	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +81 -> 93
    //   15: aload_1
    //   16: invokevirtual 83	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   19: aload_0
    //   20: invokevirtual 89	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_0
    //   24: aload_0
    //   25: invokeinterface 95 1 0
    //   30: ifeq +64 -> 94
    //   33: aload_0
    //   34: invokeinterface 99 1 0
    //   39: checkcast 20	com/tencent/tmdownloader/internal/a/d
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokestatic 66	com/tencent/tmdownloader/internal/d/c/b:a	(Lcom/tencent/tmdownloader/internal/a/d;Landroid/database/sqlite/SQLiteDatabase;)I
    //   48: ifgt -24 -> 24
    //   51: new 17	android/content/ContentValues
    //   54: dup
    //   55: invokespecial 18	android/content/ContentValues:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: aload_2
    //   61: invokestatic 23	com/tencent/tmdownloader/internal/a/d:a	(Landroid/content/ContentValues;Lcom/tencent/tmdownloader/internal/a/d;)V
    //   64: aload_1
    //   65: ldc 25
    //   67: aconst_null
    //   68: aload_3
    //   69: invokevirtual 70	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   72: pop2
    //   73: goto -49 -> 24
    //   76: astore_0
    //   77: ldc 41
    //   79: ldc 43
    //   81: aload_0
    //   82: invokestatic 49	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: aload_0
    //   86: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   89: aload_1
    //   90: invokevirtual 102	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   93: return
    //   94: aload_1
    //   95: invokevirtual 105	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   98: aload_1
    //   99: invokevirtual 102	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   102: return
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   108: return
    //   109: astore_0
    //   110: aload_1
    //   111: invokevirtual 102	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramArrayList	ArrayList<com.tencent.tmdownloader.internal.a.d>
    //   10	101	1	localSQLiteDatabase	SQLiteDatabase
    //   42	19	2	locald	com.tencent.tmdownloader.internal.a.d
    //   58	11	3	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   15	24	76	java/lang/Exception
    //   24	73	76	java/lang/Exception
    //   94	98	76	java/lang/Exception
    //   4	11	103	java/lang/Exception
    //   89	93	103	java/lang/Exception
    //   98	102	103	java/lang/Exception
    //   110	116	103	java/lang/Exception
    //   15	24	109	finally
    //   24	73	109	finally
    //   77	89	109	finally
    //   94	98	109	finally
  }
  
  /* Error */
  public static com.tencent.tmdownloader.internal.a.d b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload 4
    //   7: astore_1
    //   8: aload_0
    //   9: ifnull +78 -> 87
    //   12: aload 4
    //   14: astore_1
    //   15: aload_0
    //   16: invokevirtual 75	java/lang/String:length	()I
    //   19: ifle +68 -> 87
    //   22: invokestatic 58	com/tencent/tmdownloader/internal/d/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   25: invokevirtual 111	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore_2
    //   29: aload 4
    //   31: astore_1
    //   32: aload_2
    //   33: ifnull +54 -> 87
    //   36: aload_2
    //   37: ldc 113
    //   39: iconst_1
    //   40: anewarray 29	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: aastore
    //   47: invokevirtual 117	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +83 -> 135
    //   55: aload_0
    //   56: astore_1
    //   57: aload_0
    //   58: invokeinterface 122 1 0
    //   63: ifeq +72 -> 135
    //   66: aload_0
    //   67: astore_1
    //   68: aload_0
    //   69: invokestatic 125	com/tencent/tmdownloader/internal/a/d:a	(Landroid/database/Cursor;)Lcom/tencent/tmdownloader/internal/a/d;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_0
    //   76: ifnull +11 -> 87
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: invokeinterface 128 1 0
    //   87: aload_1
    //   88: areturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_0
    //   92: aload_0
    //   93: astore_1
    //   94: ldc 41
    //   96: ldc 43
    //   98: aload_2
    //   99: invokestatic 49	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_0
    //   103: astore_1
    //   104: aload_2
    //   105: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   108: aload 4
    //   110: astore_1
    //   111: aload_0
    //   112: ifnull -25 -> 87
    //   115: aload_3
    //   116: astore_1
    //   117: goto -36 -> 81
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +9 -> 133
    //   127: aload_1
    //   128: invokeinterface 128 1 0
    //   133: aload_0
    //   134: athrow
    //   135: aload 4
    //   137: astore_1
    //   138: aload_0
    //   139: ifnull -52 -> 87
    //   142: aload_3
    //   143: astore_1
    //   144: goto -63 -> 81
    //   147: astore_0
    //   148: goto -25 -> 123
    //   151: astore_2
    //   152: goto -60 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   7	137	1	localObject1	Object
    //   28	52	2	localObject2	Object
    //   89	16	2	localException1	Exception
    //   151	1	2	localException2	Exception
    //   4	139	3	localObject3	Object
    //   1	135	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	51	89	java/lang/Exception
    //   36	51	120	finally
    //   57	66	147	finally
    //   68	73	147	finally
    //   94	102	147	finally
    //   104	108	147	finally
    //   57	66	151	java/lang/Exception
    //   68	73	151	java/lang/Exception
  }
  
  public static ArrayList<com.tencent.tmdownloader.internal.a.d> c()
  {
    localObject3 = null;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = a.c().getReadableDatabase();
    if (localObject4 != null) {}
    try
    {
      localObject4 = ((SQLiteDatabase)localObject4).rawQuery("select * from downloadInfo", null);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(com.tencent.tmdownloader.internal.a.d.a((Cursor)localObject4));
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
      if (localObject4 == null) {
        break label90;
      }
      localObject1 = localObject4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label90:
        localObject3 = localObject1;
        m.c("DownloadInfoTable", "exception: ", localException);
        localObject3 = localObject1;
        localException.printStackTrace();
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label127;
      }
      ((Cursor)localObject3).close();
    }
    ((Cursor)localObject1).close();
    return localArrayList;
  }
  
  public static ArrayList<com.tencent.tmdownloader.internal.a.a.b> d()
  {
    localObject3 = null;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = a.c().getReadableDatabase();
    if (localObject4 != null) {}
    try
    {
      localObject4 = ((SQLiteDatabase)localObject4).rawQuery("select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)", null);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            Object localObject5 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("clientId"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            String str = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("taskUrl"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            int i = ((Cursor)localObject4).getInt(((Cursor)localObject4).getColumnIndex("status"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            localObject5 = new com.tencent.tmdownloader.internal.a.a.b((String)localObject5, str);
            localObject1 = localObject4;
            localObject3 = localObject4;
            ((com.tencent.tmdownloader.internal.a.a.b)localObject5).c = i;
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localObject5);
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
      if (localObject4 == null) {
        break label176;
      }
      localObject1 = localObject4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label176:
        localObject3 = localObject1;
        m.c("DownloadInfoTable", "exception: ", localException);
        localObject3 = localObject1;
        localException.printStackTrace();
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label213;
      }
      ((Cursor)localObject3).close();
    }
    ((Cursor)localObject1).close();
    return localArrayList;
  }
  
  public String a()
  {
    return "downloadInfo";
  }
  
  public String[] a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 2)) {
      return new String[] { "alter table downloadInfo add column headerParams TEXT;" };
    }
    if ((paramInt1 == 2) && (paramInt2 == 3)) {
      return new String[] { "alter table downloadInfo add column appId INTEGER;", "alter table downloadInfo add column taskPakcageName TEXT;", "alter table downloadInfo add column taskVersioncode TEXT;", "alter table downloadInfo add column clientIp TEXT;", "alter table downloadInfo add column startTime INTEGER;", "alter table downloadInfo add column endTime INTEGER;", "alter table downloadInfo add column downloadType INTEGER;", "alter table downloadInfo add column uin INTEGER;", "alter table downloadInfo add column uintype TEXT;", "alter table downloadInfo add column via TEXT;", "alter table downloadInfo add column channelId TEXT;", "alter table downloadInfo add column traceId TEXT;", "alter table downloadInfo add column extraData TEXT;" };
    }
    if ((paramInt1 == 3) && (paramInt2 == 4)) {
      return new String[] { "alter table downloadInfo add column iconUrl TEXT;", "alter table downloadInfo add column appName TEXT;" };
    }
    return new String[] { "alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;" };
  }
  
  public String b()
  {
    return "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, finalUrl TEXT, fileName TEXT, contentType TEXT, redirectCnt INTEGER, retryCnt INTEGER, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER, netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT,appId INTEGER,taskPakcageName TEXT,taskVersioncode TEXT,clientIp TEXT,startTime INTEGER,endTime INTEGER,downloadType INTEGER,uin INTEGER,uintype TEXT,via TEXT,channelId TEXT,traceId TEXT,extraData TEXT,iconUrl TEXT,appName TEXT);";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\d\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */