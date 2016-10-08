package com.tencent.mobileqq.fts;

import android.content.ContentValues;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.fts.entity.FTSEntity;
import com.tencent.mobileqq.fts.logger.ILogger;
import com.tencent.mobileqq.fts.logger.Logger;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.mobileqq.fts.utils.FileUtils;
import com.tencent.mobileqq.fts.utils.SQLUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FTSDatabase
{
  private static ILogger jdField_a_of_type_ComTencentMobileqqFtsLoggerILogger = new Logger();
  private static final String jdField_a_of_type_JavaLangString = "FTSDatabase";
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FTSDatabase()
  {
    if (!this.b) {
      log("FTSDatabase", "w", "load so failed.");
    }
  }
  
  public static ILogger a()
  {
    return jdField_a_of_type_ComTencentMobileqqFtsLoggerILogger;
  }
  
  public static void a(ILogger paramILogger)
  {
    jdField_a_of_type_ComTencentMobileqqFtsLoggerILogger = paramILogger;
  }
  
  private void b()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Cannot operate database on UI Thread.");
    }
  }
  
  private native void closeNative();
  
  private native boolean execSQLNative(String paramString);
  
  private native String getErrorMsg();
  
  private native boolean initNative(String paramString, boolean paramBoolean);
  
  private native boolean insertNative(String paramString, int[] paramArrayOfInt, byte[]... paramVarArgs);
  
  public static void log(String paramString1, String paramString2, String paramString3)
  {
    a().a(paramString1, paramString2, paramString3);
  }
  
  private native Object queryNative(String paramString, int[] paramArrayOfInt);
  
  private native boolean updateNative(String paramString, int[] paramArrayOfInt, byte[]... paramVarArgs);
  
  public List a(FTSQueryArgs paramFTSQueryArgs)
  {
    b();
    if (!d()) {
      log("FTSDatabase", "w", "query failed. FTSDatabase is not available");
    }
    Object localObject3;
    for (;;)
    {
      return null;
      Object localObject1 = new ArrayList();
      localObject3 = SQLUtils.a(paramFTSQueryArgs, (List)localObject1);
      int[] arrayOfInt = new int[((List)localObject1).size()];
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        arrayOfInt[i] = ((Integer)((List)localObject1).get(i)).intValue();
        i += 1;
      }
      long l1 = System.currentTimeMillis();
      try
      {
        localObject1 = (List)queryNative((String)localObject3, arrayOfInt);
        long l2 = System.currentTimeMillis();
        log("FTSDatabase", "d", "query cost time = " + (l2 - l1) + " ; sql = " + (String)localObject3);
        localObject3 = new ArrayList();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((List)localObject3).add(SQLUtils.a((Map)((Iterator)localObject1).next(), paramFTSQueryArgs.a));
          }
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    return (List)localObject3;
  }
  
  @Deprecated
  public List a(String paramString, int[] paramArrayOfInt)
  {
    b();
    if (!d())
    {
      log("FTSDatabase", "w", "querySQL failed. FTSDatabase is not available");
      return null;
    }
    try
    {
      paramString = (List)queryNative(paramString, paramArrayOfInt);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public void a()
  {
    if (d()) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      closeNative();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    b();
    if (this.jdField_a_of_type_Boolean)
    {
      log("FTSDatabase", "w", "already initialized.");
      return;
    }
    if (!this.b)
    {
      this.jdField_a_of_type_Boolean = true;
      log("FTSDatabase", "w", "init failed because so is not available.");
      return;
    }
    FileUtils.a(new File(paramString));
    try
    {
      bool = initNative(paramString, true);
      if (!bool)
      {
        this.b = false;
        this.jdField_a_of_type_Boolean = true;
        log("FTSDatabase", "w", "init failed because initNative failed.");
        return;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = false;
      }
      this.jdField_a_of_type_Boolean = true;
      log("FTSDatabase", "d", "initNative succeed.");
    }
  }
  
  protected boolean a()
  {
    try
    {
      System.loadLibrary("FTSDatabaseV2");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      a().a("FTSDatabase", "w", "load FTSDatabaseV2 failed.", localUnsatisfiedLinkError);
    }
    return false;
  }
  
  public boolean a(ContentValues paramContentValues, FTSQueryArgs paramFTSQueryArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    b();
    if (!d()) {
      log("FTSDatabase", "w", "update failed. FTSDatabase is not available");
    }
    do
    {
      return bool2;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramContentValues = SQLUtils.a(paramContentValues, paramFTSQueryArgs, localArrayList2, localArrayList1);
      paramFTSQueryArgs = new int[localArrayList2.size()];
      int i = 0;
      while (i < localArrayList2.size())
      {
        paramFTSQueryArgs[i] = ((Integer)localArrayList2.get(i)).intValue();
        i += 1;
      }
      try
      {
        bool2 = updateNative(paramContentValues, paramFTSQueryArgs, (byte[][])localArrayList1.toArray(new byte[localArrayList1.size()][]));
        bool1 = bool2;
      }
      catch (UnsatisfiedLinkError paramContentValues)
      {
        for (;;)
        {
          paramContentValues.printStackTrace();
        }
      }
      bool2 = bool1;
    } while (bool1);
    try
    {
      log("FTSDatabase", "w", "update failed. error msg = " + getErrorMsg());
      return bool1;
    }
    catch (UnsatisfiedLinkError paramContentValues)
    {
      paramContentValues.printStackTrace();
      return bool1;
    }
  }
  
  public boolean a(FTSQueryArgs paramFTSQueryArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    b();
    if (!d()) {
      log("FTSDatabase", "w", "delete failed. FTSDatabase is not available");
    }
    do
    {
      return bool2;
      paramFTSQueryArgs = SQLUtils.a(paramFTSQueryArgs);
      try
      {
        bool2 = execSQLNative(paramFTSQueryArgs);
        bool1 = bool2;
      }
      catch (UnsatisfiedLinkError paramFTSQueryArgs)
      {
        for (;;)
        {
          paramFTSQueryArgs.printStackTrace();
        }
      }
      bool2 = bool1;
    } while (bool1);
    try
    {
      log("FTSDatabase", "w", "delete failed. error msg = " + getErrorMsg());
      return bool1;
    }
    catch (UnsatisfiedLinkError paramFTSQueryArgs)
    {
      paramFTSQueryArgs.printStackTrace();
      return bool1;
    }
  }
  
  public boolean a(FTSEntity paramFTSEntity)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    b();
    if (!d()) {
      log("FTSDatabase", "w", "insert failed. FTSDatabase is not available");
    }
    do
    {
      return bool2;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramFTSEntity = SQLUtils.a(paramFTSEntity, localArrayList2, localArrayList1);
      int[] arrayOfInt = new int[localArrayList2.size()];
      int i = 0;
      while (i < localArrayList2.size())
      {
        arrayOfInt[i] = ((Integer)localArrayList2.get(i)).intValue();
        i += 1;
      }
      try
      {
        bool2 = insertNative(paramFTSEntity, arrayOfInt, (byte[][])localArrayList1.toArray(new byte[localArrayList1.size()][]));
        bool1 = bool2;
      }
      catch (UnsatisfiedLinkError paramFTSEntity)
      {
        for (;;)
        {
          paramFTSEntity.printStackTrace();
        }
      }
      bool2 = bool1;
    } while (bool1);
    try
    {
      log("FTSDatabase", "w", "insert failed. error msg = " + getErrorMsg());
      return bool1;
    }
    catch (UnsatisfiedLinkError paramFTSEntity)
    {
      paramFTSEntity.printStackTrace();
      return bool1;
    }
  }
  
  public boolean a(Class paramClass)
  {
    b();
    if (!d())
    {
      log("FTSDatabase", "w", "createTable failed. FTSDatabase is not available");
      return false;
    }
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = true;
    String str2;
    for (;;)
    {
      str2 = SQLUtils.a(paramClass, FTSUtils.a(), bool1, bool2, bool3);
      try
      {
        bool4 = execSQLNative(str2);
        if (!bool4) {
          localObject = "";
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        try
        {
          boolean bool4;
          String str1 = getErrorMsg();
          Object localObject = str1;
          log("FTSDatabase", "e", "Can't create virtual table. " + (String)localObject);
          if (!FTSUtils.a())
          {
            log("FTSDatabase", "e", "createTable failed." + (String)localObject);
            return false;
            localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
            localUnsatisfiedLinkError1.printStackTrace();
            bool4 = false;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          for (;;)
          {
            localUnsatisfiedLinkError2.printStackTrace();
          }
          if (TextUtils.isEmpty(localUnsatisfiedLinkError1))
          {
            log("FTSDatabase", "e", "createTable failed. No error msg.");
            return false;
          }
          if ((localUnsatisfiedLinkError1.contains("unrecognized parameter: notindexed")) && (bool2))
          {
            bool2 = false;
          }
          else if ((localUnsatisfiedLinkError1.contains("unrecognized parameter: compress")) && (bool3))
          {
            bool3 = false;
          }
          else if ((localUnsatisfiedLinkError1.contains("near \"NOT\": syntax error")) && (bool1))
          {
            bool1 = false;
          }
          else
          {
            if (localUnsatisfiedLinkError1.contains("table " + paramClass.getSimpleName() + " already exists"))
            {
              log("FTSDatabase", "d", "createTable succeed. " + str2);
              return true;
            }
            log("FTSDatabase", "e", "createTable failed. " + localUnsatisfiedLinkError1);
            return false;
          }
        }
      }
    }
    log("FTSDatabase", "d", "createTable succeed. " + str2);
    return true;
  }
  
  public boolean a(String paramString)
  {
    b();
    if (!d())
    {
      log("FTSDatabase", "w", "execSQL failed. FTSDatabase is not available");
      return false;
    }
    try
    {
      boolean bool = execSQLNative(paramString);
      return bool;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean a(List paramList)
  {
    b();
    if (!d()) {
      log("FTSDatabase", "w", "insert failed. FTSDatabase is not available");
    }
    while (!b()) {
      return false;
    }
    int i = 0;
    while (i < paramList.size())
    {
      a((FTSEntity)paramList.get(i));
      i += 1;
    }
    return c();
  }
  
  public boolean b()
  {
    b();
    boolean bool1;
    if (!d())
    {
      log("FTSDatabase", "w", "beginTransaction failed. FTSDatabase is not available");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool2 = a("BEGIN;");
        bool1 = bool2;
      } while (bool2);
      log("FTSDatabase", "e", "beginTransaction failed.");
      bool1 = bool2;
    } while (a("ROLLBACK;"));
    log("FTSDatabase", "e", "beginTransaction ROLLBACK failed.");
    return bool2;
  }
  
  public boolean c()
  {
    b();
    boolean bool1;
    if (!d())
    {
      log("FTSDatabase", "w", "commitTransaction failed. FTSDatabase is not available");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool2 = a("COMMIT;");
        bool1 = bool2;
      } while (bool2);
      log("FTSDatabase", "e", "commitTransaction failed.");
      bool1 = bool2;
    } while (a("ROLLBACK;"));
    log("FTSDatabase", "e", "commitTransaction ROLLBACK failed.");
    return bool2;
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\FTSDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */