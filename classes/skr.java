import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class skr
  implements Runnable
{
  skr(skq paramskq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (NetworkUtil.a(BaseApplication.getContext()) != 0) {
      QQToast.a(this.a.a.a.a(), 2, 2131369287, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\skr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */