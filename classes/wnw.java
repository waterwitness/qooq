import android.graphics.drawable.Animatable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class wnw
  implements Runnable
{
  public wnw(QQProgressDialog paramQQProgressDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQProgressDialog.a(this.a).start();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */