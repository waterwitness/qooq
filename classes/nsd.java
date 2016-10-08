import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

class nsd
  implements Runnable
{
  nsd(nsc paramnsc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), -1, BaseApplicationImpl.a().getResources().getString(2131365288), 0).b(BaseApplicationImpl.a().getResources().getDimensionPixelSize(2131492908));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */