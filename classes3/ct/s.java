package ct;

import android.text.TextUtils;

public final class s
{
  public String a = "";
  public int b = -1;
  
  public s() {}
  
  public s(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public final String a()
  {
    return this.a + ":" + this.b;
  }
  
  public final boolean a(s params)
  {
    return (params != null) && (this.a.equals(params.a)) && (this.b == params.b);
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.split(":");
    } while (paramString.length != 2);
    this.a = paramString[0];
    try
    {
      this.b = Integer.parseInt(paramString[1]);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public final String toString()
  {
    if (this.b == -1) {
      return this.a;
    }
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */