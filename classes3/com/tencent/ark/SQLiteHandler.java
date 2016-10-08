package com.tencent.ark;

import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import java.util.ArrayList;

public class SQLiteHandler
{
  private static final String TAG = "ark.SQLiteHandler";
  
  public static boolean closeDB(DBInstanse paramDBInstanse)
  {
    if ((paramDBInstanse != null) && (paramDBInstanse.db != null)) {
      try
      {
        paramDBInstanse.db.close();
        return true;
      }
      catch (Exception paramDBInstanse)
      {
        Log.e("ark.SQLiteHandler", "Failed to find closeDB", paramDBInstanse);
      }
    }
    return false;
  }
  
  public static boolean closeStatement(DBStatement paramDBStatement)
  {
    boolean bool = false;
    if (paramDBStatement != null) {}
    try
    {
      if (paramDBStatement.cursor != null)
      {
        paramDBStatement.cursor.close();
        DBStatement.access$502(paramDBStatement, null);
      }
      if (paramDBStatement.stmt != null)
      {
        paramDBStatement.stmt.close();
        DBStatement.access$302(paramDBStatement, null);
      }
      DBStatement.access$002(paramDBStatement, false);
      DBStatement.access$202(paramDBStatement, null);
      DBStatement.access$102(paramDBStatement, null);
      bool = true;
      return bool;
    }
    catch (Exception paramDBStatement)
    {
      Log.e("ark.SQLiteHandler", "Failed to find closeStatement", paramDBStatement);
    }
    return false;
  }
  
  public static DBInstanse createDB(String paramString)
  {
    try
    {
      paramString = SQLiteDatabase.openOrCreateDatabase(paramString, null);
      if ((paramString != null) && (paramString.isOpen()))
      {
        DBInstanse localDBInstanse = new DBInstanse();
        localDBInstanse.db = paramString;
        return localDBInstanse;
      }
    }
    catch (Exception paramString)
    {
      Log.e("ark.SQLiteHandler", "Failed to find createDB", paramString);
    }
    return null;
  }
  
  public static DBStatement createStatement(DBInstanse paramDBInstanse, String paramString, boolean paramBoolean)
  {
    if (paramDBInstanse != null) {
      try
      {
        DBStatement localDBStatement = new DBStatement();
        localDBStatement.db = paramDBInstanse.db;
        DBStatement.access$002(localDBStatement, paramBoolean);
        if (paramBoolean)
        {
          DBStatement.access$102(localDBStatement, paramString);
          DBStatement.access$202(localDBStatement, new ArrayList());
          return localDBStatement;
        }
        DBStatement.access$302(localDBStatement, paramDBInstanse.db.compileStatement(paramString));
        return localDBStatement;
      }
      catch (Exception paramDBInstanse)
      {
        Log.e("ark.SQLiteHandler", "Failed to find createStatement", paramDBInstanse);
      }
    }
    return null;
  }
  
  public static boolean execSQL(DBInstanse paramDBInstanse, String paramString)
  {
    if (paramDBInstanse != null) {
      try
      {
        Log.d("ark.SQLiteHandler", String.format("execSQL  %s", new Object[] { paramString }));
        paramDBInstanse.db.execSQL(paramString);
        return true;
      }
      catch (Exception paramDBInstanse)
      {
        Log.e("ark.SQLiteHandler", "Failed to find execSQL", paramDBInstanse);
      }
    }
    return false;
  }
  
  public static boolean moveToNext(DBStatement paramDBStatement)
  {
    return paramDBStatement.cursor.moveToNext();
  }
  
  public static byte[] queryGetBlobField(DBStatement paramDBStatement, int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramDBStatement != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramDBStatement.isQuery)
      {
        arrayOfByte = paramArrayOfByte;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      arrayOfByte = paramDBStatement.cursor.getBlob(paramInt);
      return arrayOfByte;
    }
    catch (Exception paramDBStatement)
    {
      Log.e("ark.SQLiteHandler", "Failed to find queryGetBlobField", paramDBStatement);
    }
    return paramArrayOfByte;
  }
  
  public static double queryGetDoubleField(DBStatement paramDBStatement, int paramInt, double paramDouble)
  {
    double d = paramDouble;
    if (paramDBStatement != null)
    {
      d = paramDouble;
      if (paramDBStatement.isQuery)
      {
        d = paramDouble;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      d = paramDBStatement.cursor.getDouble(paramInt);
      return d;
    }
    catch (Exception paramDBStatement)
    {
      Log.e("ark.SQLiteHandler", "Failed to find queryGetDoubleField", paramDBStatement);
    }
    return paramDouble;
  }
  
  public static long queryGetLongField(DBStatement paramDBStatement, int paramInt, long paramLong)
  {
    long l = paramLong;
    if (paramDBStatement != null)
    {
      l = paramLong;
      if (paramDBStatement.isQuery)
      {
        l = paramLong;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      l = paramDBStatement.cursor.getLong(paramInt);
      return l;
    }
    catch (Exception paramDBStatement)
    {
      Log.e("ark.SQLiteHandler", "Failed to find queryGetLongField", paramDBStatement);
    }
    return paramLong;
  }
  
  public static String queryGetStrField(DBStatement paramDBStatement, int paramInt, String paramString)
  {
    String str = paramString;
    if (paramDBStatement != null)
    {
      str = paramString;
      if (paramDBStatement.isQuery)
      {
        str = paramString;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      str = paramDBStatement.cursor.getString(paramInt);
      return str;
    }
    catch (Exception paramDBStatement)
    {
      Log.e("ark.SQLiteHandler", "Failed to find queryGetStrField", paramDBStatement);
    }
    return paramString;
  }
  
  public static boolean statementBindBlob(DBStatement paramDBStatement, byte[] paramArrayOfByte)
  {
    if (paramDBStatement != null) {
      try
      {
        if (paramDBStatement.isQuery) {
          return false;
        }
        paramDBStatement.stmt.bindBlob(DBStatement.access$408(paramDBStatement), paramArrayOfByte);
        return true;
      }
      catch (Exception paramDBStatement)
      {
        Log.e("ark.SQLiteHandler", "Failed to find statementBindBlob", paramDBStatement);
      }
    }
    return false;
  }
  
  public static boolean statementBindDouble(DBStatement paramDBStatement, double paramDouble)
  {
    if (paramDBStatement != null) {
      try
      {
        if (paramDBStatement.isQuery) {
          paramDBStatement.queryParams.add(String.valueOf(paramDouble));
        } else {
          paramDBStatement.stmt.bindDouble(DBStatement.access$408(paramDBStatement), paramDouble);
        }
      }
      catch (Exception paramDBStatement)
      {
        Log.e("ark.SQLiteHandler", "Failed to find statementBindDouble", paramDBStatement);
      }
    }
    return false;
    return true;
  }
  
  public static boolean statementBindLong(DBStatement paramDBStatement, long paramLong)
  {
    if (paramDBStatement != null) {
      try
      {
        if (paramDBStatement.isQuery) {
          paramDBStatement.queryParams.add(String.valueOf(paramLong));
        } else {
          paramDBStatement.stmt.bindLong(DBStatement.access$408(paramDBStatement), paramLong);
        }
      }
      catch (Exception paramDBStatement)
      {
        Log.e("ark.SQLiteHandler", "Failed to find statementBindLong", paramDBStatement);
      }
    }
    return false;
    return true;
  }
  
  public static boolean statementBindStr(DBStatement paramDBStatement, String paramString)
  {
    try
    {
      if (paramDBStatement.isQuery) {
        paramDBStatement.queryParams.add(paramString);
      } else {
        paramDBStatement.stmt.bindString(DBStatement.access$408(paramDBStatement), paramString);
      }
    }
    catch (Exception paramDBStatement)
    {
      Log.e("ark.SQLiteHandler", "Failed to find statementBindStr", paramDBStatement);
      return false;
    }
    return true;
  }
  
  public static boolean statementExec(DBStatement paramDBStatement)
  {
    if (paramDBStatement != null) {}
    try
    {
      if (paramDBStatement.isQuery)
      {
        Log.d("ark.SQLiteHandler", String.format("statementExec is query %s", new Object[] { paramDBStatement.querySql }));
        String[] arrayOfString = new String[paramDBStatement.queryParams.size()];
        arrayOfString = (String[])paramDBStatement.queryParams.toArray(arrayOfString);
        DBStatement.access$502(paramDBStatement, paramDBStatement.db.rawQuery(paramDBStatement.querySql, arrayOfString));
        DBStatement.access$602(paramDBStatement, paramDBStatement.cursor.moveToFirst());
        return paramDBStatement.queryHasRow;
      }
      paramDBStatement.stmt.execute();
      return true;
    }
    catch (SQLiteConstraintException paramDBStatement)
    {
      return false;
    }
    catch (Exception paramDBStatement)
    {
      for (;;)
      {
        Log.e("ark.SQLiteHandler", "Failed to find statementExec", paramDBStatement);
      }
    }
  }
  
  public static class DBInstanse
  {
    SQLiteDatabase db;
  }
  
  public static class DBStatement
  {
    private Cursor cursor;
    SQLiteDatabase db;
    private int index = 1;
    private boolean isQuery = false;
    private boolean queryHasRow = false;
    private ArrayList<String> queryParams;
    private String querySql;
    private SQLiteStatement stmt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ark\SQLiteHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */