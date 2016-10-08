package com.tencent.biz.qqstory.database;

import android.database.Cursor;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQStoryEntityManagerFactory
  extends QQEntityManagerFactory
{
  protected static final int a = 29;
  private static final String a = "Q.qqstory.QQStoryEntityManagerFactory";
  protected static final int b = 31;
  protected static final int c = 31;
  
  public QQStoryEntityManagerFactory(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.a(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.equals(UserEntry.class.getSimpleName())) {
                continue;
              }
              localClass = UserEntry.class;
              OGEntityManager.a(localArrayList, str, localCursor2, localClass);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Class localClass;
              continue;
            }
            localCursor2.close();
            break;
            if (str.equals(StoryEntry.class.getSimpleName())) {
              localClass = StoryEntry.class;
            } else if (str.equals(StoryVideoEntry.class.getSimpleName())) {
              localClass = StoryVideoEntry.class;
            } else if (str.equals(StoryVideoListEntry.class.getSimpleName())) {
              localClass = StoryVideoListEntry.class;
            } else if (str.startsWith(PublishVideoEntry.class.getSimpleName())) {
              localClass = PublishVideoEntry.class;
            } else if (str.equals(FirstVideoEntry.class.getSimpleName())) {
              localClass = FirstVideoEntry.class;
            } else {
              localClass = Class.forName(paramString + "." + str);
            }
          }
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.g();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.h();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.h();
    SLog.a("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange take time:%d", Long.valueOf(System.currentTimeMillis() - l));
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "qqstory_" + paramString + ".db", null, 31);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(new UserEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoListEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new PublishVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new FirstVideoEntry()));
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 29)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(StoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(StoryVideoListEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoListEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(UserEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new UserEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(PublishVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new PublishVideoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(FirstVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new FirstVideoEntry()));
    }
    if (paramInt1 < 31) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ReportWatchVideoEntry()));
    }
    a("com.tencent.biz.qqstory.database", paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\QQStoryEntityManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */