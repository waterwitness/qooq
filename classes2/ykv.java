import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty;

public class ykv
  implements View.OnClickListener
{
  public ykv(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QZoneLiveVideoBaseDownLoadActivty.a(this.a).setText("");
    QZoneLiveVideoBaseDownLoadActivty.a(this.a).setOnClickListener(null);
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */