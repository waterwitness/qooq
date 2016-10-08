package ct;

import java.nio.ByteBuffer;
import java.util.HashMap;

public final class bj
{
  public static HashMap d = null;
  public HashMap a = new HashMap();
  public String b = "GBK";
  public bk c = new bk();
  private bg e = new bg();
  
  public final Object a(String paramString, Object paramObject)
    throws Exception
  {
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.a.get(paramString);
    try
    {
      this.e.a = ByteBuffer.wrap(paramString);
      this.e.b = this.b;
      paramString = this.e.a(paramObject, 0, true);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */