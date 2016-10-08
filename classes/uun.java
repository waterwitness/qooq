import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class uun
  implements Runnable
{
  public uun(StatisticCollector paramStatisticCollector, ToServiceMsg paramToServiceMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MsfServiceSdk.get().sendMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */