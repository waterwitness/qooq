import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class u
  implements View.OnClickListener
{
  public u(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckadv");
    paramView = new Intent(this.a, LiteAdvanceActivity.class);
    paramView.putExtra("targetUin", this.a.g);
    this.a.startActivityForResult(paramView, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */