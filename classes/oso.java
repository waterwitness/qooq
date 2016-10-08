import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class oso
  implements Runnable
{
  public oso(qfileJumpActivity paramqfileJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DataLineReportUtil.r(this.a.app);
    Intent localIntent = new Intent(this.a, LiteActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("targetUin", this.a.a);
    localIntent.putExtra("leftViewText", this.a.app.a().getString(2131367975));
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */