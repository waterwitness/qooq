package com.tencent.mobileqq.ark;

import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArkAppEntityManagerFactory
  extends QQEntityManagerFactory
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "ArkAppDBVersion";
  private static final String b = "ArkApp.ArkAppEntityManagerFactory";
  
  public ArkAppEntityManagerFactory(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    String str1;
    Cursor localCursor2;
    if (localCursor1 != null) {
      do
      {
        if (!localCursor1.moveToNext()) {
          break;
        }
        str1 = SecurityUtile.a(localCursor1.getString(0));
        localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str1 });
      } while (localCursor2 == null);
    }
    for (;;)
    {
      Field localField;
      int i;
      boolean bool;
      try
      {
        Object localObject = TableBuilder.a(Class.forName(paramString + "." + str1));
        if (localCursor2.moveToFirst())
        {
          String[] arrayOfString = SecurityUtile.a(localCursor2.getString(0)).split(",");
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            localField = (Field)((Iterator)localObject).next();
            i = 1;
            if (i >= arrayOfString.length) {
              break label401;
            }
            String str2 = arrayOfString[i].trim().split(" ")[0];
            if (!localField.getName().equals(str2)) {
              break label282;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            if (!localField.isAnnotationPresent(defaultzero.class)) {
              break label291;
            }
            i = 0;
            bool = true;
            localArrayList.add(TableBuilder.a(str1, localField.getName(), (String)TableBuilder.a.get(localField.getType()), bool, i));
            continue;
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localCursor2.close();
      }
      label282:
      i += 1;
      continue;
      label291:
      if (localField.isAnnotationPresent(defaultValue.class))
      {
        i = ((defaultValue)localField.getAnnotation(defaultValue.class)).a();
        bool = true;
        continue;
        localCursor1.close();
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
      else
      {
        i = 0;
        bool = false;
        continue;
        label401:
        i = 0;
      }
    }
  }
  
  protected void a(com.tencent.mobileqq.app.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.a(TableBuilder.a(new ArkAppTestData()));
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "arkapp_" + paramString + ".db", null, 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(getPackageName(), paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppEntityManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */