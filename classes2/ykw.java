import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty;

public class ykw
  implements View.OnClickListener
{
  public ykw(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QZoneLiveVideoBaseDownLoadActivty.a(this.a, true);
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */