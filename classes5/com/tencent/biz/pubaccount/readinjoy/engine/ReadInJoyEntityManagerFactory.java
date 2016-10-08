package com.tencent.biz.pubaccount.readinjoy.engine;

import android.database.Cursor;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyEntityManagerFactory
  extends QQEntityManagerFactory
{
  private static final int jdField_a_of_type_Int = 34;
  private static final String jdField_a_of_type_JavaLangString = "readinjoy_message_node_";
  private static final String b = "readinjoy_message_node_verify_entity";
  
  public ReadInJoyEntityManagerFactory(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.TAG = "ReadInJoy.MessageNode.EntityManagerFactory";
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
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
              if (!str.equals(ArticleInfo.TABLE_NAME)) {
                continue;
              }
              localClass = ArticleInfo.class;
              OGEntityManager.a(localArrayList, str, localCursor2, localClass);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Class localClass;
              continue;
            }
            localCursor2.close();
            break;
            if (str.equals(ArticleReadInfo.TABLE_NAME)) {
              localClass = ArticleReadInfo.class;
            } else if (str.equals(ChannelInfo.TABLE_NAME)) {
              localClass = ChannelInfo.class;
            } else if (str.equals(ChannelTopCookie.TABLE_NAME)) {
              localClass = ChannelTopCookie.class;
            } else if (str.equals(InterestLabelInfo.TABLE_NAME)) {
              localClass = InterestLabelInfo.class;
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
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "readinjoy_message_node_" + paramString + ".db", null, 34);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ArticleInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ArticleReadInfo()));
    paramSQLiteDatabase.execSQL("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on " + ArticleInfo.TABLE_NAME + " for each row begin " + " delete from " + ArticleReadInfo.TABLE_NAME + " where mArticleID = old.mArticleID;" + " end ");
  }
  
  protected String getPackageName()
  {
    return "com.tencent.biz.pubaccount.readinjoy.struct";
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = 1;
    QLog.i(this.TAG, 1, "[DB]|upgrade. oldver=" + paramInt1 + ",newver=" + paramInt2);
    a(getPackageName(), paramSQLiteDatabase);
    try
    {
      paramSQLiteDatabase.execSQL("select * from " + ArticleReadInfo.TABLE_NAME + " limit 1 ");
      paramInt1 = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramInt1 = 0;
      }
    }
    if (paramInt1 == 0) {
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ArticleReadInfo()));
    }
    paramSQLiteDatabase.execSQL("create trigger if not exists readinjoy_readinfo_delete_trigger after delete on " + ArticleInfo.TABLE_NAME + " for each row begin " + " delete from " + ArticleReadInfo.TABLE_NAME + " where mArticleID = old.mArticleID;" + " end ");
  }
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      EntityManager localEntityManager = createEntityManager();
      ReadInJoyEntityManagerFactory.VerifyEntity localVerifyEntity = (ReadInJoyEntityManagerFactory.VerifyEntity)localEntityManager.a(ReadInJoyEntityManagerFactory.VerifyEntity.class, "flags=?", new String[] { "readinjoy_message_node_verify_entity" });
      if (localVerifyEntity == null)
      {
        localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localEntityManager.b(localVerifyEntity);
        return true;
      }
      if ((!localVerifyEntity.flags.equals("readinjoy_message_node_verify_entity")) || (!localVerifyEntity.name.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
        localVerifyEntity = new ReadInJoyEntityManagerFactory.VerifyEntity();
        localVerifyEntity.name = this.name;
        localEntityManager.b(localVerifyEntity);
        return false;
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\engine\ReadInJoyEntityManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */