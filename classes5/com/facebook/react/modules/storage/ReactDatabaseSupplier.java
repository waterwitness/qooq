package com.facebook.react.modules.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

public class ReactDatabaseSupplier
  extends SQLiteOpenHelper
{
  public static final String DATABASE_NAME = "RKStorage";
  private static final int DATABASE_VERSION = 1;
  private static final long DEFAULT_MAX_DB_SIZE = 6291456L;
  static final String KEY_COLUMN = "key";
  private static final int SLEEP_TIME_MS = 30;
  static final String TABLE_CATALYST = "catalystLocalStorage";
  static final String VALUE_COLUMN = "value";
  static final String VERSION_TABLE_CREATE = "CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)";
  @Nullable
  private static ReactDatabaseSupplier sReactDatabaseSupplierInstance;
  private Context mContext;
  @Nullable
  private SQLiteDatabase mDb;
  
  private ReactDatabaseSupplier(Context paramContext)
  {
    super(paramContext, "RKStorage", null, 1);
    this.mContext = paramContext;
  }
  
  private void closeDatabase()
  {
    try
    {
      if ((this.mDb != null) && (this.mDb.isOpen()))
      {
        this.mDb.close();
        this.mDb = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean deleteDatabase()
  {
    try
    {
      closeDatabase();
      boolean bool = this.mContext.deleteDatabase("RKStorage");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void deleteInstance()
  {
    sReactDatabaseSupplierInstance = null;
  }
  
  public static ReactDatabaseSupplier getInstance(Context paramContext)
  {
    if (sReactDatabaseSupplierInstance == null) {
      sReactDatabaseSupplierInstance = new ReactDatabaseSupplier(paramContext.getApplicationContext());
    }
    return sReactDatabaseSupplierInstance;
  }
  
  void clear()
  {
    try
    {
      get().delete("catalystLocalStorage", null, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void clearAndCloseDatabase()
    throws RuntimeException
  {
    try
    {
      clear();
      closeDatabase();
      if (FLog.isLoggable(3)) {
        FLog.d("React", "Cleaned RKStorage");
      }
      return;
    }
    catch (Exception localException)
    {
      while (deleteDatabase()) {
        if (FLog.isLoggable(3)) {
          FLog.d("React", "Deleted Local Database RKStorage");
        }
      }
    }
    finally {}
    throw new RuntimeException("Clearing and deleting database RKStorage failed");
  }
  
  /* Error */
  boolean ensureDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 48	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 54	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifeq +7 -> 27
    //   23: aload_0
    //   24: monitorexit
    //   25: iconst_1
    //   26: ireturn
    //   27: aconst_null
    //   28: astore_1
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: iconst_2
    //   33: if_icmpge +20 -> 53
    //   36: iload_3
    //   37: ifle +8 -> 45
    //   40: aload_0
    //   41: invokespecial 108	com/facebook/react/modules/storage/ReactDatabaseSupplier:deleteDatabase	()Z
    //   44: pop
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 124	com/facebook/react/modules/storage/ReactDatabaseSupplier:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: putfield 48	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   53: aload_0
    //   54: getfield 48	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   57: ifnonnull +34 -> 91
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: ldc2_w 125
    //   71: invokestatic 132	java/lang/Thread:sleep	(J)V
    //   74: iload_3
    //   75: iconst_1
    //   76: iadd
    //   77: istore_3
    //   78: goto -47 -> 31
    //   81: astore_2
    //   82: invokestatic 136	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   85: invokevirtual 139	java/lang/Thread:interrupt	()V
    //   88: goto -14 -> 74
    //   91: aload_0
    //   92: getfield 48	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   95: ldc2_w 14
    //   98: invokevirtual 143	android/database/sqlite/SQLiteDatabase:setMaximumSize	(J)J
    //   101: pop2
    //   102: goto -79 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	ReactDatabaseSupplier
    //   28	33	1	localObject1	Object
    //   62	4	1	localObject2	Object
    //   67	1	1	localSQLiteException	android.database.sqlite.SQLiteException
    //   81	1	2	localInterruptedException	InterruptedException
    //   30	48	3	i	int
    //   16	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	62	finally
    //   40	45	62	finally
    //   45	53	62	finally
    //   53	62	62	finally
    //   68	74	62	finally
    //   82	88	62	finally
    //   91	102	62	finally
    //   40	45	67	android/database/sqlite/SQLiteException
    //   45	53	67	android/database/sqlite/SQLiteException
    //   68	74	81	java/lang/InterruptedException
  }
  
  SQLiteDatabase get()
  {
    try
    {
      ensureDatabase();
      SQLiteDatabase localSQLiteDatabase = this.mDb;
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      deleteDatabase();
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\storage\ReactDatabaseSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */