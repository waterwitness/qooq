import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

public class mng
  implements View.OnClickListener
{
  public mng(SubAccountMessageActivity paramSubAccountMessageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (SubAccountManager)this.a.app.getManager(60);
    if ((paramView != null) && (paramView.a() == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      SubAccountMessageActivity.a(this.a, bool);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */