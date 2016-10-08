package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver.ExecuteResultHandler;
import com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SqliteDatabaseDriver
  extends Database.DatabaseDriver
{
  private static final String[] UNINTERESTING_FILENAME_SUFFIXES = { "-journal", "-shm", "-uid", "-wal" };
  private final DatabaseFilesProvider mDatabaseFilesProvider;
  private List<String> mDatabases;
  
  @Deprecated
  public SqliteDatabaseDriver(Context paramContext)
  {
    this(paramContext, new DefaultDatabaseFilesProvider(paramContext));
  }
  
  public SqliteDatabaseDriver(Context paramContext, DatabaseFilesProvider paramDatabaseFilesProvider)
  {
    super(paramContext);
    this.mDatabaseFilesProvider = paramDatabaseFilesProvider;
  }
  
  private <T> T executeInsert(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    return (T)paramExecuteResultHandler.handleInsert(paramSQLiteDatabase.compileStatement(paramString).executeInsert());
  }
  
  private <T> T executeRawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    paramSQLiteDatabase.execSQL(paramString);
    return (T)paramExecuteResultHandler.handleRawQuery();
  }
  
  private <T> T executeSelect(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, null);
    try
    {
      paramString = paramExecuteResultHandler.handleSelect(paramSQLiteDatabase);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  @TargetApi(11)
  private <T> T executeUpdateDelete(SQLiteDatabase paramSQLiteDatabase, String paramString, Database.DatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler)
  {
    return (T)paramExecuteResultHandler.handleUpdateDelete(paramSQLiteDatabase.compileStatement(paramString).executeUpdateDelete());
  }
  
  private static String getFirstWord(String paramString)
  {
    String str = paramString.trim();
    int i = str.indexOf(' ');
    paramString = str;
    if (i >= 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
  
  private SQLiteDatabase openDatabase(String paramString)
    throws SQLiteException
  {
    Util.throwIfNull(paramString);
    return SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(paramString).getAbsolutePath(), null, 0);
  }
  
  private static String removeSuffix(String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return paramString;
      }
      String str = paramArrayOfString[i];
      if (paramString.endsWith(str)) {
        return paramString.substring(0, paramString.length() - str.length());
      }
      i += 1;
    }
  }
  
  static List<File> tidyDatabaseList(List<File> paramList)
  {
    HashSet localHashSet = new HashSet(paramList);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localArrayList;
      }
      File localFile = (File)paramList.next();
      String str1 = localFile.getPath();
      String str2 = removeSuffix(str1, UNINTERESTING_FILENAME_SUFFIXES);
      if ((str2.equals(str1)) || (!localHashSet.contains(new File(str2)))) {
        localArrayList.add(localFile);
      }
    }
  }
  
  public Database.ExecuteSQLResponse executeSQL(String paramString1, String paramString2, Database.DatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler)
    throws SQLiteException
  {
    Util.throwIfNull(paramString2);
    Util.throwIfNull(paramExecuteResultHandler);
    paramString1 = openDatabase(paramString1);
    try
    {
      String str = getFirstWord(paramString2).toUpperCase();
      if (("UPDATE".equals(str)) || ("DELETE".equals(str)))
      {
        paramString2 = (Database.ExecuteSQLResponse)executeUpdateDelete(paramString1, paramString2, paramExecuteResultHandler);
        return paramString2;
      }
      if ("INSERT".equals(str))
      {
        paramString2 = (Database.ExecuteSQLResponse)executeInsert(paramString1, paramString2, paramExecuteResultHandler);
        return paramString2;
      }
      if (("SELECT".equals(str)) || ("PRAGMA".equals(str)) || ("EXPLAIN".equals(str)))
      {
        paramString2 = (Database.ExecuteSQLResponse)executeSelect(paramString1, paramString2, paramExecuteResultHandler);
        return paramString2;
      }
      paramString2 = (Database.ExecuteSQLResponse)executeRawQuery(paramString1, paramString2, paramExecuteResultHandler);
      return paramString2;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public List<String> getDatabaseNames()
  {
    Object localObject;
    if (this.mDatabases == null)
    {
      this.mDatabases = new ArrayList();
      localObject = this.mDatabaseFilesProvider.getDatabaseFiles();
      Collections.sort((List)localObject);
      localObject = tidyDatabaseList((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return this.mDatabases;
      }
      String str = ((File)((Iterator)localObject).next()).getName();
      this.mDatabases.add(str);
    }
  }
  
  /* Error */
  public List<String> getTableNames(String paramString)
    throws SQLiteException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 199	com/facebook/stetho/inspector/database/SqliteDatabaseDriver:openDatabase	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   5: astore_1
    //   6: aload_1
    //   7: ldc_w 256
    //   10: iconst_2
    //   11: anewarray 16	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 258
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: ldc_w 260
    //   25: aastore
    //   26: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_2
    //   30: new 158	java/util/ArrayList
    //   33: dup
    //   34: invokespecial 160	java/util/ArrayList:<init>	()V
    //   37: astore_3
    //   38: aload_2
    //   39: invokeinterface 263 1 0
    //   44: istore 4
    //   46: iload 4
    //   48: ifne +15 -> 63
    //   51: aload_2
    //   52: invokeinterface 85 1 0
    //   57: aload_1
    //   58: invokevirtual 213	android/database/sqlite/SQLiteDatabase:close	()V
    //   61: aload_3
    //   62: areturn
    //   63: aload_3
    //   64: aload_2
    //   65: iconst_0
    //   66: invokeinterface 267 2 0
    //   71: invokeinterface 194 2 0
    //   76: pop
    //   77: goto -39 -> 38
    //   80: astore_3
    //   81: aload_2
    //   82: invokeinterface 85 1 0
    //   87: aload_3
    //   88: athrow
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 213	android/database/sqlite/SQLiteDatabase:close	()V
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	SqliteDatabaseDriver
    //   0	96	1	paramString	String
    //   29	53	2	localCursor	Cursor
    //   89	6	2	localObject1	Object
    //   37	27	3	localArrayList	ArrayList
    //   80	8	3	localObject2	Object
    //   44	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	38	80	finally
    //   38	46	80	finally
    //   63	77	80	finally
    //   6	30	89	finally
    //   51	57	89	finally
    //   81	89	89	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\database\SqliteDatabaseDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */