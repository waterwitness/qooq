import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class rer
  implements Runnable
{
  public rer(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatingTopListActivity.a(this.a, 1);
    QQToast.a(this.a.getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */