import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ohz
  implements View.OnClickListener
{
  public ohz(SearchBaseActivity paramSearchBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */