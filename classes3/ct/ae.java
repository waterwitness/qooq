package ct;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public final class ae
  implements aa
{
  public int a = 1;
  public byte[] b = null;
  public int c = 0;
  public int d = 0;
  public HttpResponse e;
  public int f = 0;
  
  public final int a()
  {
    return this.a;
  }
  
  public final String a(String paramString)
  {
    if (this.e != null)
    {
      paramString = this.e.getFirstHeader(paramString);
      if (paramString != null) {
        return paramString.getValue();
      }
    }
    return null;
  }
  
  public final byte[] b()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */