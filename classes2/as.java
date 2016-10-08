import android.view.View;
import android.view.View.OnLongClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class as
  implements View.OnLongClickListener
{
  public as(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    return this.a.a(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */