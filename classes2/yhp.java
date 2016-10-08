import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;

public class yhp
  extends Handler
{
  public yhp(ShowNodeTaskManager paramShowNodeTaskManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "handleMessage() START_TASK_2MIN");
      }
      if (ShowNodeTaskManager.a(this.a).hasMessages(1)) {
        ShowNodeTaskManager.a(this.a).removeMessages(1);
      }
    } while (!HotSpotNodeUtil.a(BaseApplicationImpl.getContext()));
    ShowNodeTaskManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */