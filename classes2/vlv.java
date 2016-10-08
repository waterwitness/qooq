import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class vlv
  implements Runnable
{
  public vlv(TroopAndDiscMsgProxy paramTroopAndDiscMsgProxy, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str = TroopAndDiscMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy).a();
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "aio_break_point", bool, 0L, 0L, new HashMap(), "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vlv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */