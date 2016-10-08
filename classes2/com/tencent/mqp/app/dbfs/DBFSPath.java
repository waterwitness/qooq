package com.tencent.mqp.app.dbfs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DBFSPath
{
  public static final String a = "dbPath://";
  public static final String b = "/";
  public DBFSPath a;
  public boolean a;
  public DBFSPath b;
  public String c;
  
  public DBFSPath(DBFSPath paramDBFSPath1, DBFSPath paramDBFSPath2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath = paramDBFSPath1;
    this.b = paramDBFSPath2;
    this.c = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public DBFSPath(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = a(paramString);
  }
  
  public boolean a(String paramString)
  {
    if (-1 != paramString.indexOf("\t")) {}
    while ((-1 != paramString.indexOf(" ")) || (-1 == paramString.indexOf("dbPath://"))) {
      return false;
    }
    String[] arrayOfString = paramString.substring("dbPath://".length()).split("/");
    int j = arrayOfString.length;
    int i = 0;
    String str1 = null;
    paramString = this;
    if (i < j)
    {
      String str2 = arrayOfString[i];
      if (paramString != null)
      {
        paramString.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath = null;
        paramString.b = null;
        paramString.c = str2;
      }
      for (;;)
      {
        i += 1;
        str1 = paramString;
        paramString = null;
        break;
        paramString = new DBFSPath(str1, null, str2);
        str1.b = paramString;
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\dbfs\DBFSPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */