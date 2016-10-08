import android.os.Handler;
import com.tencent.mobileqq.app.HotChatManager.OnVListUpdateListener;
import com.tencent.mobileqq.hotchat.HCTopicSeatsView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ssy
  implements HotChatManager.OnVListUpdateListener
{
  public ssy(HCTopicSeatsView paramHCTopicSeatsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HCTopicSeatsView", 2, "onVListUpdate");
    }
    this.a.a.sendEmptyMessage(2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */