package com.facebook.stetho.inspector.database;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDatabaseFilesProvider
  implements DatabaseFilesProvider
{
  private final Context mContext;
  
  public DefaultDatabaseFilesProvider(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public List<File> getDatabaseFiles()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.mContext.databaseList();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localArrayList;
      }
      localArrayList.add(new File(arrayOfString[i]));
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\database\DefaultDatabaseFilesProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */