package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yko;

public class QZoneClickReport$ReportRunnable
  implements Runnable
{
  private static final int c = 1;
  private static final int d = 1;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  
  public QZoneClickReport$ReportRunnable(ArrayList paramArrayList, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    Object localObject1;
    try
    {
      localJSONObject.put("count", ((ArrayList)localObject2).size());
      localJSONObject.put("qua", QUA.a());
      localJSONObject.put("device_info", PlatformInfor.a().e());
      localJSONObject.put("uin", this.jdField_a_of_type_Long);
      localJSONArray = new JSONArray();
      localObject2 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localJSONArray.put(((QZoneClickReport.ReportInfo)((Iterator)localObject2).next()).a());
          continue;
          if (localObject1 == null) {
            break;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localObject1 = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).toString();
      this.jdField_a_of_type_Boolean = true;
      return;
      ((JSONObject)localObject1).put("data", localJSONArray);
    }
  }
  
  public void run()
  {
    String str = QzoneConfig.a().a("ReportSetting", "TraceReportURL", "http://client.qzone.com/cgi-bin/client/client_report_statis");
    a();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      label35:
      if (QLog.isDevelopLevel()) {
        QLog.d(QZoneClickReport.access$100(), 4, "report body:" + this.jdField_a_of_type_JavaLangString);
      }
      try
      {
        HttpResponse localHttpResponse = QZoneHttpUtil.a(BaseApplication.getContext(), str, new ByteArrayEntity(QZoneClickReport.zip(this.jdField_a_of_type_JavaLangString)));
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_b_of_type_Boolean = true;
          if (QLog.isDevelopLevel()) {
            QLog.d(QZoneClickReport.access$100(), 4, "report success.");
          }
        }
        while ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int <= 1))
        {
          if (this.jdField_a_of_type_Int <= 1) {
            break label35;
          }
          ThreadManager.b().postDelayed(new yko(this), 300000L);
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_Int = 0;
          return;
          QLog.e(QZoneClickReport.access$100(), 1, "HttpStatus error when report : " + localHttpResponse.getStatusLine().getStatusCode());
          this.jdField_a_of_type_Int += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(QZoneClickReport.access$100(), 1, "exception when report", localException);
          this.jdField_a_of_type_Int += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneClickReport$ReportRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */