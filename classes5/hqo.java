import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendOrderPayEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public final class hqo
  implements BusinessObserver
{
  public hqo(NewIntent paramNewIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      try
      {
        mobileqq_mp.SendOrderPayEventResponse localSendOrderPayEventResponse = new mobileqq_mp.SendOrderPayEventResponse();
        localSendOrderPayEventResponse.mergeFrom(paramBundle.getByteArray("data"));
        if (localSendOrderPayEventResponse.ret_info.has())
        {
          localSendOrderPayEventResponse.ret_info.ret_code.get();
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */