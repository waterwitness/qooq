import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvr
  implements View.OnClickListener
{
  public qvr(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      this.a.a(paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */