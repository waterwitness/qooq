package oicq.wlogin_sdk.request;

import android.content.Context;
import oicq.wlogin_sdk.tools.util;

public class g
  extends Thread
{
  private Context a;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
    setName("WtCleanThread");
  }
  
  public void run()
  {
    util.deleteExpireLog(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */