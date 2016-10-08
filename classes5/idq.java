import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class idq
  implements AsyncBack
{
  public idq(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SubscriptFeedsActivity.a(), 2, "HtmlOffline.checkUpByBusinessId businessId=2278, code=" + paramInt);
    }
    this.a.app.getApplication();
    int i = NetworkUtil.a(MobileQQ.getContext());
    paramString = new HashMap();
    paramString.put("network", "" + i);
    paramString.put("status_code", "" + paramInt);
    StatisticCollector.a(this.a).a(null, "subscription_htmloffline", true, 0L, 0L, paramString, "", false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */