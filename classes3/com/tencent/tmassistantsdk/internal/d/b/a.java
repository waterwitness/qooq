package com.tencent.tmassistantsdk.internal.d.b;

public class a
  extends com.tencent.tmassistant.common.a.a
{
  protected static a a = null;
  
  public static a g()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  protected String[] b(int paramInt)
  {
    if (paramInt > 1) {
      return new String[] { e() };
    }
    return null;
  }
  
  protected String d()
  {
    return "BusinessInfoLogTable";
  }
  
  protected String e()
  {
    return "CREATE TABLE if not exists BusinessInfoLogTable( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
  
  protected String f()
  {
    return "INSERT INTO BusinessInfoLogTable logData = ?";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */