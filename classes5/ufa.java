import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import org.json.JSONObject;

public class ufa
  implements Runnable
{
  public ufa(RedTouchManager paramRedTouchManager, BusinessInfoCheckUpdate.AppInfo paramAppInfo, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager.a.a()));
    localReportReqBody.clientver.set("6.5.5.2880");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(RedTouchManager.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(18);
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.missions.has()) {
      localReportReqBody.missionid.set(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.missions.get());
    }
    Object localObject1 = new JSONObject();
    try
    {
      localJSONObject = new JSONObject();
    }
    catch (Exception localException2)
    {
      JSONObject localJSONObject;
      label162:
      for (;;) {}
    }
    try
    {
      localJSONObject.put("time_on_page", this.jdField_a_of_type_Long);
      localObject1 = localJSONObject;
    }
    catch (Exception localException1)
    {
      Object localObject2 = localException2;
      break label162;
    }
    localReportReqBody.buffer.set(((JSONObject)localObject1).toString());
    localObject1 = RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager, "RedTouchSvc.ClientReport");
    ((ToServiceMsg)localObject1).putWupBuffer(localReportReqBody.toByteArray());
    RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager, (ToServiceMsg)localObject1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */