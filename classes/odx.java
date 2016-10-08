import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class odx
  extends DownloadListener
{
  odx(odw paramodw, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.z == 0) {
      localObject = paramDownloadTask.a().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramDownloadTask = new File((String)localObject);
        String str = FileUtils.b(paramDownloadTask);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new JSONObject(str);
          this.jdField_a_of_type_Odw.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = new TroopGiftAioPanelData((JSONObject)localObject);
          this.jdField_a_of_type_Odw.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(this.jdField_a_of_type_Odw.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_Odw.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_Odw.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
            this.jdField_a_of_type_Odw.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.b.post(new ody(this));
          }
          paramDownloadTask.deleteOnExit();
        }
        return;
      }
      catch (IOException paramDownloadTask)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.aio.TroopChatPie", 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.aio.TroopChatPie", 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
    }
    QLog.d("Q.aio.TroopChatPie", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Odw.jdField_a_of_type_Long) + ", errorCode = " + paramDownloadTask.z);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */