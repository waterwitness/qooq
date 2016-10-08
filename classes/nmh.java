import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class nmh
  implements Runnable
{
  public nmh(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a.getApplicationContext(), this.a.getString(2131368690), 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */