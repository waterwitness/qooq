package com.tencent.mobileqq.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import rce;
import rcg;

public class QQEntityManagerFactory$SQLiteOpenHelperImpl
  extends SQLiteOpenHelper
{
  private String databaseName;
  private SQLiteDatabase dbR;
  private SQLiteDatabase dbW;
  private SQLiteDatabase mInnerDb;
  
  public QQEntityManagerFactory$SQLiteOpenHelperImpl(QQEntityManagerFactory paramQQEntityManagerFactory, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(BaseApplication.getContext(), paramString, new rce(paramQQEntityManagerFactory, null), paramInt);
    this.databaseName = paramString;
  }
  
  public QQEntityManagerFactory$SQLiteOpenHelperImpl(QQEntityManagerFactory paramQQEntityManagerFactory, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, rcg paramrcg)
  {
    super(BaseApplication.getContext(), paramString, new rce(paramQQEntityManagerFactory, null), paramInt, paramrcg);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.databaseName = paramString;
  }
  
  private void dropAllTable(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = getAllTableName(paramSQLiteDatabase);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ("android_metadata".equals(str)) {}
        for (;;)
        {
          i += 1;
          break;
          if (!"sqlite_sequence".equals(str))
          {
            try
            {
              paramSQLiteDatabase.execSQL(TableBuilder.a(str));
            }
            catch (SQLiteException localSQLiteException)
            {
              localSQLiteException.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.w(this.this$0.TAG, 2, "[DB] dropAllTable " + str, localSQLiteException);
            }
          }
        }
      }
    }
    onCreate(paramSQLiteDatabase);
  }
  
  /* Error */
  private String[] getAllTableName(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ldc 113
    //   6: aconst_null
    //   7: invokevirtual 117	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +140 -> 152
    //   15: aload_2
    //   16: astore_3
    //   17: aload_2
    //   18: invokeinterface 122 1 0
    //   23: ifeq +129 -> 152
    //   26: aload_2
    //   27: astore_3
    //   28: aload_2
    //   29: invokeinterface 126 1 0
    //   34: anewarray 55	java/lang/String
    //   37: astore_1
    //   38: aload_2
    //   39: astore_3
    //   40: aload_1
    //   41: iload 5
    //   43: aload_2
    //   44: iconst_0
    //   45: invokeinterface 130 2 0
    //   50: invokestatic 133	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   53: aastore
    //   54: aload_2
    //   55: astore_3
    //   56: aload_2
    //   57: invokeinterface 136 1 0
    //   62: istore 6
    //   64: iload 6
    //   66: ifne +77 -> 143
    //   69: aload_1
    //   70: astore_3
    //   71: aload_2
    //   72: ifnull +11 -> 83
    //   75: aload_2
    //   76: invokeinterface 139 1 0
    //   81: aload_1
    //   82: astore_3
    //   83: aload_3
    //   84: areturn
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_2
    //   92: astore_3
    //   93: aload 4
    //   95: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   98: aload_1
    //   99: astore_3
    //   100: aload_2
    //   101: ifnull -18 -> 83
    //   104: aload_2
    //   105: invokeinterface 139 1 0
    //   110: aload_1
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: ifnull +9 -> 125
    //   119: aload_3
    //   120: invokeinterface 139 1 0
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: goto -13 -> 115
    //   131: astore 4
    //   133: aconst_null
    //   134: astore_1
    //   135: goto -44 -> 91
    //   138: astore 4
    //   140: goto -49 -> 91
    //   143: iload 5
    //   145: iconst_1
    //   146: iadd
    //   147: istore 5
    //   149: goto -111 -> 38
    //   152: aconst_null
    //   153: astore_1
    //   154: goto -85 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	SQLiteOpenHelperImpl
    //   0	157	1	paramSQLiteDatabase	SQLiteDatabase
    //   10	95	2	localCursor	android.database.Cursor
    //   16	104	3	localObject	Object
    //   85	9	4	localException1	Exception
    //   131	1	4	localException2	Exception
    //   138	1	4	localException3	Exception
    //   1	147	5	i	int
    //   62	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	11	85	java/lang/Exception
    //   3	11	112	finally
    //   17	26	127	finally
    //   28	38	127	finally
    //   40	54	127	finally
    //   56	64	127	finally
    //   93	98	127	finally
    //   17	26	131	java/lang/Exception
    //   28	38	131	java/lang/Exception
    //   40	54	138	java/lang/Exception
    //   56	64	138	java/lang/Exception
  }
  
  public void close()
  {
    try
    {
      if ((this.dbR != null) && (this.dbR.isOpen()))
      {
        this.dbR.close();
        this.dbR = null;
      }
      if ((this.dbW != null) && (this.dbW.isOpen()))
      {
        this.dbW.close();
        this.dbW = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dropAllTable()
  {
    dropAllTable(this.mInnerDb);
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      this.dbR = super.getReadableDatabase();
      SQLiteDatabase localSQLiteDatabase = this.dbR;
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      this.dbW = super.getWritableDatabase();
      this.dbW.setLockingEnabled(false);
      SQLiteDatabase localSQLiteDatabase = this.dbW;
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onCreate");
    }
    this.this$0.createDatabase(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onOpen");
    }
    this.mInnerDb = paramSQLiteDatabase;
    try
    {
      localObject1 = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(paramSQLiteDatabase);
      localObject2 = localObject1.getClass().getDeclaredField("maxSqlCacheSize");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(localObject1, Integer.valueOf(150));
      localObject2 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(paramSQLiteDatabase);
      Method[] arrayOfMethod = localObject2.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      i = 0;
      if (i >= j) {
        break label567;
      }
      paramSQLiteDatabase = arrayOfMethod[i];
      if (!TextUtils.equals(paramSQLiteDatabase.getName(), "reconfigure")) {
        break label294;
      }
    }
    catch (NoSuchFieldException paramSQLiteDatabase)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int i;
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
        }
      }
    }
    catch (IllegalArgumentException paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
        }
      }
    }
    catch (IllegalAccessException paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
        }
      }
    }
    catch (InvocationTargetException paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
          continue;
          paramSQLiteDatabase = null;
        }
      }
    }
    if (paramSQLiteDatabase != null)
    {
      paramSQLiteDatabase.setAccessible(true);
      paramSQLiteDatabase.invoke(localObject2, new Object[] { localObject1 });
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " LRU MAX SIZE = " + 150);
      }
    }
    for (;;)
    {
      paramSQLiteDatabase = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
      if ((paramSQLiteDatabase.exists()) && (System.currentTimeMillis() - paramSQLiteDatabase.lastModified() > 259200000L)) {
        paramSQLiteDatabase.delete();
      }
      return;
      label294:
      i += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + " not find reconfigure()");
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onUpgrade" + " oldVersion: " + paramInt1 + " newVersion: " + paramInt2);
    }
    this.this$0.upgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    AIOInputTypeHelper.a();
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB] onUpgrade end");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\QQEntityManagerFactory$SQLiteOpenHelperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */