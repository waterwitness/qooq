package sm;

import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.impl.SecureService.a;
import com.tencent.securemodule.service.ICallback;

public class ac
  implements Runnable
{
  public ac(SecureService.a parama, String paramString, ICallback paramICallback) {}
  
  public void run()
  {
    int i = SecureService.a(this.c.a, this.a);
    if (this.b != null) {
      this.b.onTaskFinished(i);
    }
    this.c.a.stopSelf();
    SecureService.a(this.c.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */