import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.qphone.base.util.QLog;

public class idm
  implements View.OnFocusChangeListener
{
  public idm(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      SubscriptFeedsActivity.a(this.a);
      long l = System.currentTimeMillis();
      if (l - SubscriptFeedsActivity.a(this.a) > 1500L)
      {
        SubscriptFeedsActivity.a(this.a, l);
        GroupSearchActivity.a(this.a, null, 12);
        if (QLog.isColorLevel()) {
          QLog.d(SubscriptFeedsActivity.a(), 2, "Search Subscript Account...");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */