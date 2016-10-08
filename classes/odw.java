import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class odw
  extends TroopGiftCallback
{
  public odw(TroopChatPie paramTroopChatPie, long paramLong, TroopGiftManager paramTroopGiftManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "onGetExtraData() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", configURL = " + paramString);
    }
    if ((paramInt <= this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a()) && (TroopGiftAioPanelData.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a) != null)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new File(AppConstants.by);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = AppConstants.by + "troopGiftConfig.tmp";
    paramString = new DownloadTask(paramString, new File((String)localObject));
    paramString.A = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a().a(paramString, new odx(this, paramInt), localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */