package com.facebook.stetho.inspector.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver.ExecuteResultHandler;
import com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ContentProviderDatabaseDriver
  extends Database.DatabaseDriver
{
  private static final String sDatabaseName = "content-providers";
  private final ContentProviderSchema[] mContentProviderSchemas;
  private List<String> mDatabaseNames;
  private List<String> mTableNames;
  
  public ContentProviderDatabaseDriver(Context paramContext, ContentProviderSchema... paramVarArgs)
  {
    super(paramContext);
    this.mContentProviderSchemas = paramVarArgs;
  }
  
  private String fetchTableName(String paramString)
  {
    Iterator localIterator = this.mTableNames.iterator();
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        return "";
      }
      str = (String)localIterator.next();
    } while (!paramString.contains(str));
    return str;
  }
  
  public Database.ExecuteSQLResponse executeSQL(String paramString1, String paramString2, Database.DatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler)
    throws SQLiteException
  {
    paramString1 = fetchTableName(paramString2);
    int i = this.mTableNames.indexOf(paramString1);
    paramString1 = this.mContentProviderSchemas[i];
    paramString1 = this.mContext.getContentResolver().query(paramString1.getUri(), paramString1.getProjection(), null, null, null);
    try
    {
      paramString2 = (Database.ExecuteSQLResponse)paramExecuteResultHandler.handleSelect(paramString1);
      return paramString2;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public List<String> getDatabaseNames()
  {
    if ((this.mDatabaseNames == null) && (this.mContentProviderSchemas != null))
    {
      this.mDatabaseNames = new ArrayList();
      this.mDatabaseNames.add("content-providers");
    }
    return this.mDatabaseNames;
  }
  
  public List<String> getTableNames(String paramString)
  {
    int j;
    int i;
    if (this.mTableNames == null)
    {
      this.mTableNames = new ArrayList();
      paramString = this.mContentProviderSchemas;
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return this.mTableNames;
      }
      Object localObject = paramString[i];
      this.mTableNames.add(((ContentProviderSchema)localObject).getTableName());
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\database\ContentProviderDatabaseDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */