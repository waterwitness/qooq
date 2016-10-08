import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;

public class tmu
  implements DownloadListener
{
  public tmu(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    this.a.d = 2;
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.d = 4;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    if (NearbyProfileDisplayPanel.a(this.a) != null) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_done", 0, 0, NearbyProfileDisplayPanel.a(this.a).uin, "", "yes", "android");
    }
  }
  
  public void a(List paramList)
  {
    this.a.d = 1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (DownloadInfo)paramList.get(0);
      Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 2;
      localMessage.arg1 = paramList.l;
      localMessage.sendToTarget();
      if ((paramList.l == 0) && (NearbyProfileDisplayPanel.a(this.a) != null)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_begin", 0, 0, NearbyProfileDisplayPanel.a(this.a).uin, "", "yes", "android");
      }
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    this.a.d = 2;
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    this.a.d = 3;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(5);
    }
    if (NearbyProfileDisplayPanel.a(this.a) != null) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_done", 0, 0, NearbyProfileDisplayPanel.a(this.a).uin, "", "yes", "android");
    }
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    this.a.d = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */