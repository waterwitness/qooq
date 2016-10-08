import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.DownloadGftData;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.DownloadGiftResStateObservable;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class vqy
  extends DownloadListener
{
  public vqy(TroopGiftManager paramTroopGiftManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    TroopGiftManager.DownloadGftData localDownloadGftData = new TroopGiftManager.DownloadGftData();
    Object localObject2 = paramDownloadTask.a();
    String str = ((Bundle)localObject2).getString("GiftAnimationId");
    localObject2 = ((Bundle)localObject2).getString("TroopUin");
    localDownloadGftData.jdField_a_of_type_Boolean = true;
    localDownloadGftData.jdField_a_of_type_JavaLangString = str;
    TroopGiftManager.DownloadGiftResStateObservable.a().setChanged();
    TroopGiftManager.DownloadGiftResStateObservable.a().notifyObservers(localDownloadGftData);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "onDone Id=" + str + " task:" + paramDownloadTask);
    }
    ReportController.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, paramDownloadTask.z, str, "", "", "");
    if (paramDownloadTask.z == 0)
    {
      paramDownloadTask = new File(TroopGiftUtil.b(str));
      if (!paramDownloadTask.exists()) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.a(paramDownloadTask.getAbsolutePath(), AppConstants.cW, false);
        paramDownloadTask.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(3));
        ReportController.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, (String)localObject2, "", "", "");
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
          break label435;
        }
        i = 1;
        if (this.a.jdField_a_of_type_AndroidAppActivity == null) {
          break label441;
        }
        j = 1;
        if ((i | j) != 0) {}
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
      finally
      {
        paramDownloadTask.delete();
      }
      this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(4));
      int i = NetworkUtil.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
      if (i == 1)
      {
        i = 0;
        label314:
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
          break label429;
        }
      }
      label429:
      for (paramDownloadTask = "0";; paramDownloadTask = "1")
      {
        ReportController.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", 0, 0, (String)localObject2, (String)localObject1 + "", paramDownloadTask, i + "");
        break;
        if (i == 2)
        {
          i = 3;
          break label314;
        }
        if (i == 3)
        {
          i = 2;
          break label314;
        }
        if (i == 4)
        {
          i = 1;
          break label314;
        }
        i = 4;
        break label314;
      }
      label435:
      i = 0;
      continue;
      label441:
      int j = 0;
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("GiftAnimationId");
    TroopGiftManager.DownloadGftData localDownloadGftData = new TroopGiftManager.DownloadGftData();
    localDownloadGftData.jdField_a_of_type_Boolean = false;
    localDownloadGftData.jdField_a_of_type_JavaLangString = str;
    TroopGiftManager.DownloadGiftResStateObservable.a().setChanged();
    TroopGiftManager.DownloadGiftResStateObservable.a().notifyObservers(localDownloadGftData);
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */