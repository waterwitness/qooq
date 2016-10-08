import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class vrz
  implements BusinessObserver
{
  public vrz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label156;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        paramInt = localWebSsoResponseBody.ret.get();
        if (paramInt == 0)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "likeTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_like ok~~~");
          return;
        }
        paramBundle = new JSONObject(localWebSsoResponseBody.data.get());
        paramBundle = "likeTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_like failed1, errorCode = " + paramInt + ", msg = " + paramBundle;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle = "likeTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_like failed4, msg = " + QLog.getStackTraceString(paramBundle);
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.w(".troop.troop_topic.TroopTopicMgr", 2, paramBundle);
      return;
      label156:
      if (QLog.isColorLevel()) {
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, "likeTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_like failed2, data is null !!!!");
      }
    }
    else
    {
      paramBundle = "likeTopic cmd=MQUpdateSvc_com_qq_buluo.web.sbar_like failed3, isSuccess is " + paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.w(".troop.troop_topic.TroopTopicMgr", 2, paramBundle + paramBoolean);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */