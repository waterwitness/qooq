package sm;

import android.os.Handler;
import android.os.Message;
import com.tencent.securemodule.service.ICallback;
import com.tencent.securemodule.ui.TransparentActivity;
import com.tencent.securemodule.ui.TransparentActivity.a;

public class ar
  implements ICallback
{
  public ar(TransparentActivity.a parama) {}
  
  public void onTaskFinished(int paramInt)
  {
    if (paramInt == 0)
    {
      Message localMessage = TransparentActivity.c(this.a.a).obtainMessage(2);
      localMessage.arg1 = 1;
      TransparentActivity.c(this.a.a).sendMessage(localMessage);
      return;
    }
    TransparentActivity.a.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */