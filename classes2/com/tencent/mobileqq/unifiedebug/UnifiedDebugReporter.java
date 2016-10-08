package com.tencent.mobileqq.unifiedebug;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogReq;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import vwz;

public class UnifiedDebugReporter
{
  public static final String a = "ClubDebugging.report";
  private static final String b = UnifiedDebugReporter.class.getSimpleName();
  public QQAppInterface a;
  public BusinessObserver a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UnifiedDebugReporter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new vwz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public String a(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("status", paramInt);
      JSONObject localJSONObject1 = paramJSONObject;
      if (paramJSONObject == null) {
        localJSONObject1 = new JSONObject();
      }
      localJSONObject2.put("data", localJSONObject1);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(b, 2, "reportStatus: exception=" + paramJSONObject.getMessage());
        }
      }
    }
    return localJSONObject2.toString();
  }
  
  public void a(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    RemoteDebugReportMsg.RemoteLogReq localRemoteLogReq = new RemoteDebugReportMsg.RemoteLogReq();
    localRemoteLogReq.str_seq.set(String.valueOf(paramLong));
    localRemoteLogReq.str_data.set(a(paramInt, paramJSONObject));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), UnifiedDebugReportServlet.class);
    localNewIntent.putExtra("extra_cmd", "ClubDebugging.report");
    localNewIntent.putExtra("extra_data", localRemoteLogReq.toByteArray());
    localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "reportStatus: seq=" + paramLong + ", statusCode=" + paramInt + ", data=" + paramJSONObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\UnifiedDebugReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */