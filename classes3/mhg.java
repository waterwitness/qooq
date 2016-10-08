import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSpaceCleanActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mhg
  implements Runnable
{
  public mhg(QQSpaceCleanActivity paramQQSpaceCleanActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQSpaceCleanActivity.a(this.a, false);
    QQSpaceCleanActivity.a(this.a).setText(2131369623);
    QQSpaceCleanActivity.b(this.a).setVisibility(0);
    QQSpaceCleanActivity.a(this.a).setVisibility(0);
    QQSpaceCleanActivity.a(this.a).setVisibility(8);
    FMToastUtil.a(2131368805);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */