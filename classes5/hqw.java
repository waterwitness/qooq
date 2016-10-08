import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class hqw
  extends BroadcastReceiver
{
  public hqw(PublicAccountManager paramPublicAccountManager, boolean paramBoolean, MqqHandler paramMqqHandler)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.biz.pubaccount.scanResultData");
    int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.scanResultType", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(str, i, 12, -1, null);
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(19);
      }
    }
    try
    {
      for (;;)
      {
        paramContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a);
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a = null;
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(str, i, 11, -1, null);
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */