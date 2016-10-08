import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class uzz
  implements WeakNetCallback
{
  private StatisticCollector a;
  
  public uzz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = StatisticCollector.a(BaseApplication.getContext());
  }
  
  public void onResultOverflow(HashMap paramHashMap)
  {
    this.a.a(QQUtils.a(), "actWeaknetProbe", true, 0L, paramHashMap.size(), paramHashMap, "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */