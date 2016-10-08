import android.os.SystemClock;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class lro
  implements Runnable
{
  public lro(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = LebaShowListManager.a().a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.a.jdField_a_of_type_MqqOsMqqHandler.post(new lrp(this, (List)localObject));
    if (Leba.a(this.a))
    {
      Leba.a(this.a, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = Leba.a(this.a);
      StatisticCollector.a(BaseApplication.getContext()).a(QQUtils.a(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
      localObject = LebaShowListManager.a().b();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
          if (localLebaViewItem != null) {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005416", "0X8005416", 0, 0, localLebaViewItem.a.uiResId + "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */