import android.app.Dialog;
import android.content.Context;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

public class hot
  implements Runnable
{
  public hot(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((MultiVideoPlayActivity.a(this.a) != null) && (MultiVideoPlayActivity.a(this.a).isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "showMobileNetHint() mNetworkDialog.isShowing()=true, RETURN");
      }
      return;
    }
    this.a.a.b(true);
    MultiVideoPlayActivity.a(this.a, DialogUtil.a(this.a, 232, this.a.getApplicationContext().getString(2131371551), this.a.getApplicationContext().getString(2131371552), this.a.getApplicationContext().getString(2131367262), "继续观看", new hou(this), new hov(this)));
    MultiVideoPlayActivity.a(this.a).show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */