import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hql
  extends BroadcastReceiver
{
  public hql(PublicAccountManager paramPublicAccountManager, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    double d1 = Double.parseDouble(paramIntent.getStringExtra("latitude"));
    double d2 = Double.parseDouble(paramIntent.getStringExtra("longitude"));
    paramIntent = paramIntent.getStringExtra("name");
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(d1, d2, paramIntent, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    try
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.c);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.c = null;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */