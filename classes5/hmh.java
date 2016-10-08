import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hmh
  implements View.OnClickListener
{
  public hmh(AccountDetailActivity paramAccountDetailActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */