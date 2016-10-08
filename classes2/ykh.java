import android.app.Dialog;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class ykh
  implements View.OnClickListener
{
  public ykh(Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    QQToast.a(BaseApplicationImpl.a(), "开始dump内存,文件目录为:/Tencent/MobileQQ/log/", 1).a();
    paramView = ThreadManager.a("qzone-leaker", 10);
    paramView.start();
    paramView = paramView.getLooper();
    if (paramView != null) {
      new Handler(paramView).post(new yki(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */