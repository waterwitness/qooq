import android.content.res.Resources;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class gwz
  implements Runnable
{
  public gwz(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "TimeoutRunnable Run");
    }
    QQToast.a(MultiVideoEnterPageActivity.b(this.a), 2131363676, 1).b(MultiVideoEnterPageActivity.a(this.a).getDimensionPixelSize(2131492908));
    if (!this.a.a) {
      MultiVideoEnterPageActivity.f(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */