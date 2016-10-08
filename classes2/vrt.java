import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class vrt
  extends DownloadListener
{
  public vrt(TroopTopicMgr paramTroopTopicMgr, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.z == 0)
    {
      Object localObject = paramDownloadTask.a().getString("filePath");
      try
      {
        paramDownloadTask = new File((String)localObject);
        String str = FileUtils.b(paramDownloadTask);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        boolean bool = TextUtils.isEmpty(str);
        if (bool) {
          return;
        }
        try
        {
          localObject = new JSONObject(str);
          ((JSONObject)localObject).put("version", this.jdField_a_of_type_Int);
          TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr).a().getSharedPreferences(TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr).a() + "_TroopTopic", 0).edit().putString("ShareCommentWhiteList", ((JSONObject)localObject).toString()).commit();
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.b(((JSONObject)localObject).toString());
          paramDownloadTask.deleteOnExit();
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "handleSaveWhiteList exception: " + localJSONException.getMessage());
            }
          }
        }
        QLog.d(".troop.troop_topic.TroopTopicMgr", 2, QLog.getStackTraceString(paramDownloadTask));
      }
      catch (IOException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "errorCode = " + paramDownloadTask.z);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */