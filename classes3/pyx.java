import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class pyx
  implements Runnable
{
  public pyx(HotChatShare paramHotChatShare)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a == null) || (!this.a.a.isShowing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "30s has gone, goto share....");
    }
    this.a.c();
    HotChatShare.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */