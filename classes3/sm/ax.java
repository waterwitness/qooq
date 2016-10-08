package sm;

import android.util.Log;

public final class ax
{
  private static boolean a = false;
  private static aw b = new bc();
  
  public static void a(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      Log.e(paramString, "log message is null");
      return;
    }
    b.a(paramString, paramObject.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */