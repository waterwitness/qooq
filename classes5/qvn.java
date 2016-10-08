import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvn
  implements View.OnClickListener
{
  public qvn(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a(i);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */