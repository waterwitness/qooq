import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class ggv
  implements Runnable
{
  public ggv(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a, this.a.getString(2131363947), 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */