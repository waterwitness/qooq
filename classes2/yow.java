import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.util.ArrayList;
import java.util.Iterator;

public class yow
  extends IActionListener.Stub
{
  public yow(RemoteHandleManager paramRemoteHandleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramRecvMsg.getServiceCmd())) && (this.a.a != null))
      {
        Iterator localIterator = this.a.a.iterator();
        while (localIterator.hasNext()) {
          ((WebEventListener)localIterator.next()).onWebEvent(paramRecvMsg.getServiceCmd(), paramRecvMsg.extraData);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */