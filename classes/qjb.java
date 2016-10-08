import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class qjb
  extends DownloadListener
{
  public qjb(EcShopFirstRunMsgConfigs paramEcShopFirstRunMsgConfigs)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.z == 0) && (EcShopFirstRunMsgConfigs.a(this.a).b != null)) {
      if (EcShopFirstRunMsgConfigs.b(this.a).b != null)
      {
        EcShopFirstRunMsgConfigs.c(this.a).b.a().getSharedPreferences("ecshop_sp", 0).edit().putLong(EcShopAssistantManager.D, paramDownloadTask.i).commit();
        ((EcshopReportHandler)EcShopFirstRunMsgConfigs.d(this.a).b.a(88)).a();
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "download json success.");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Ecshop", 2, "download json failed.");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */