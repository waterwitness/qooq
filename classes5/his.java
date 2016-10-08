import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class his
  extends Handler
{
  public his(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Bundle)paramMessage.obj;
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(17, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\his.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */