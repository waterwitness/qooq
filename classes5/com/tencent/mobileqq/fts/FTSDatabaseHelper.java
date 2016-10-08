package com.tencent.mobileqq.fts;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.tencent.mobileqq.data.fts.FTSTroop;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FTSDatabaseHelper
{
  public static final String a = "FTSDatabaseHelper";
  
  public FTSDatabaseHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramString = "SELECT cursor FROM " + paramString + " WHERE id=1;";
    try
    {
      int i = c(paramFTSDatabase, paramString);
      return i;
    }
    catch (SQLiteException paramFTSDatabase) {}
    return -1;
  }
  
  public static int a(FTSDatabase paramFTSDatabase, ArrayList paramArrayList, String paramString, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FTSDatabaseHelper", 2, "batchTransToDatabase: entities == null");
      }
      return -1;
    }
    int j = a(paramFTSDatabase, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FTSDatabaseHelper", 2, "FTSDatabaseHelper.queryCursorTable = " + j);
    }
    if (j == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FTSDatabaseHelper", 2, "batchTransToDatabase: syncCursor == -1");
      }
      return -1;
    }
    if (!paramFTSDatabase.b())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FTSDatabaseHelper", 2, "batchTransToDatabase: beginTransaction failed");
      }
      return -1;
    }
    int i = 0;
    boolean bool1 = true;
    TroopIndex localTroopIndex;
    if (i < paramArrayList.size())
    {
      FTSTroop localFTSTroop = (FTSTroop)paramArrayList.get(i);
      localTroopIndex = new TroopIndex(localFTSTroop.mType, localFTSTroop.mTroopUin, localFTSTroop.mMemberUin, localFTSTroop.mMemberName, localFTSTroop.mMemberCard);
      localTroopIndex.preWrite();
      switch (localFTSTroop.mOpt)
      {
      default: 
        label216:
        if (bool1) {
          break;
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = bool1)
    {
      i = paramInt;
      if (paramInt == -1) {
        i = paramArrayList.size();
      }
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramArrayList.size() != 0)
        {
          bool1 = bool2;
          if (i != 0) {
            bool1 = paramFTSDatabase.a("UPDATE " + paramString + " SET cursor=" + (j + i) + " WHERE id=1;");
          }
        }
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = paramFTSDatabase.c();
      }
      if (bool2)
      {
        return j + i;
        bool1 = paramFTSDatabase.a(localTroopIndex);
        break label216;
        bool1 = a(paramFTSDatabase, localTroopIndex);
        break label216;
        bool2 = a(paramFTSDatabase, localTroopIndex);
        bool1 = bool2;
        if (!bool2) {
          break label216;
        }
        bool1 = paramFTSDatabase.a(localTroopIndex);
        break label216;
        i += 1;
        break;
      }
      return j;
    }
  }
  
  public static boolean a(FTSDatabase paramFTSDatabase, TroopIndex paramTroopIndex)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("DELETE FROM " + paramTroopIndex.getTableName() + " WHERE " + paramTroopIndex.getTableName() + " MATCH 'type:");
    localStringBuilder.append(paramTroopIndex.type);
    localStringBuilder.append(" ext1:");
    localStringBuilder.append(paramTroopIndex.ext1);
    if (!TextUtils.isEmpty(paramTroopIndex.ext6))
    {
      localStringBuilder.append(" ext6:");
      localStringBuilder.append(paramTroopIndex.ext6);
    }
    localStringBuilder.append("';");
    return paramFTSDatabase.a(localStringBuilder.toString());
  }
  
  public static boolean a(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramFTSDatabase = paramFTSDatabase.a("SELECT name FROM sqlite_master WHERE type='table' AND name='" + paramString + "'", new int[] { 3 });
    return (paramFTSDatabase != null) && (paramFTSDatabase.size() > 0);
  }
  
  public static int b(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramString = "SELECT COUNT(*) FROM " + paramString;
    try
    {
      int i = c(paramFTSDatabase, paramString);
      return i;
    }
    catch (SQLiteException paramFTSDatabase) {}
    return -1;
  }
  
  public static boolean b(FTSDatabase paramFTSDatabase, String paramString)
  {
    if (!paramFTSDatabase.b()) {}
    do
    {
      return false;
      paramFTSDatabase.a("CREATE TABLE IF NOT EXISTS " + paramString + "(id INTEGER PRIMARY KEY AUTOINCREMENT, cursor INTEGER);");
      paramFTSDatabase.a("INSERT INTO " + paramString + "(cursor) VALUES(0);");
    } while (!paramFTSDatabase.c());
    return true;
  }
  
  public static int c(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramFTSDatabase = paramFTSDatabase.a(paramString, new int[] { 1 });
    if ((paramFTSDatabase == null) || (paramFTSDatabase.size() != 1)) {
      throw new SQLiteException("No result or result size != 1");
    }
    paramFTSDatabase = (Map)paramFTSDatabase.get(0);
    if ((paramFTSDatabase == null) || (paramFTSDatabase.size() != 1)) {
      throw new SQLiteException("No column or column count != 1");
    }
    try
    {
      int i = ((Long)paramFTSDatabase.values().toArray()[0]).intValue();
      return i;
    }
    catch (Exception paramFTSDatabase)
    {
      throw new SQLiteException("No column or column count != 1");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\FTSDatabaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */