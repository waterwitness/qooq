import MyCarrier.Carrier;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;

public class ooo
  implements View.OnClickListener
{
  public ooo(ContactListView paramContactListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    Context localContext = this.a.getContext();
    Object localObject = ((MyBusinessManager)this.a.a.getManager(48)).a();
    if ((localObject == null) || (TextUtils.isEmpty(((Carrier)localObject).carrierURL))) {
      return;
    }
    localObject = ((Carrier)localObject).carrierURL;
    Intent localIntent = new Intent(localContext, MyBusinessActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("uin", this.a.a.a());
    localIntent.putExtra("title", localContext.getString(2131371273));
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hideRightButton", true);
    this.a.b(localIntent, 1000);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131301448: 
    case 2131301449: 
    default: 
      return;
    case 2131301450: 
      ContactListView.a(this.a, true);
      ContactListView.a(this.a, "P_CliOper", "QQwangting", "txl_close_bluebar", "close_bluebar");
      return;
    }
    ContactListView.a(this.a, true);
    ContactListView.a(this.a, "P_CliOper", "QQwangting", "txl_clk_bluebar", "clk_bluebar");
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ooo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */