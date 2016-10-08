import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class nmi
  implements Runnable
{
  public nmi(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a.getApplicationContext(), this.a.getString(2131368694), 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */