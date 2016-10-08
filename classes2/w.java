import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.ItemHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class w
  implements View.OnClickListener
{
  public w(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    paramView = (ItemHolder)paramView.getTag();
    this.a.b(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */