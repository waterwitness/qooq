import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class wiv
  implements Runnable
{
  public wiv(SwiftBrowserStatistics paramSwiftBrowserStatistics, String paramString1, Context paramContext, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      localObject1 = Uri.parse(this.jdField_a_of_type_JavaLangString);
      if (localObject1 != null)
      {
        localObject2 = ((Uri)localObject1).getHost();
        if (((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).endsWith("qq.com"))) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Int < 11))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("QQBrowser_report", 2, "mUrl is null or url is not from qq.com!");
          return;
        }
        localObject2 = ((Uri)localObject1).getQueryParameter("hasRedDot");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Boolean = ((String)localObject2).equalsIgnoreCase("1");
        }
        localObject1 = ((Uri)localObject1).getQueryParameter("crashFrom");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.b = Integer.parseInt((String)localObject1);
        }
      }
    }
    catch (Exception localException)
    {
      label686:
      label702:
      label705:
      for (;;)
      {
        try
        {
          Object localObject1;
          int j;
          int k;
          JSONObject localJSONObject;
          localJSONObject.put("mission", str2);
          ((JSONObject)localObject2).put("redtouch", localJSONObject);
          Object localObject2 = ((JSONObject)localObject2).toString();
          String str2 = this.b;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Boolean)
          {
            i = 1;
            ReportController.b(null, "P_CliOper", "WebStatusReport", "", (String)localObject2, str2, i, 1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Int, (String)localObject1, Build.VERSION.RELEASE, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.b), String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.b));
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.b = -1;
            SwiftBrowserStatistics.CrashStepStatsEntry.d = -1;
            return;
            localException = localException;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("QQBrowser_report", 2, "parse url got some problem!", localException);
            continue;
            String str1 = this.jdField_a_of_type_JavaLangString;
            continue;
            i = 0;
            continue;
          }
          int i = 0;
          continue;
        }
        catch (JSONException localJSONException)
        {
          continue;
        }
      }
    }
    i = this.jdField_a_of_type_JavaLangString.indexOf("?");
    if (i != -1)
    {
      localObject1 = this.jdField_a_of_type_JavaLangString.substring(0, i);
      if (SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.isEmpty())
      {
        SwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a);
        if ((SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.isEmpty()) || (!SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.containsKey("sample_rate"))) {
          SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(10));
        }
      }
      j = ((Integer)SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.get("sample_rate")).intValue();
      if (SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
        j = ((Integer)SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).intValue();
      }
      k = 0;
      localObject2 = BaseApplicationImpl.a().a();
      i = k;
      if (localObject2 != null)
      {
        i = k;
        if (((AppRuntime)localObject2).getLongAccountUin() != 0L)
        {
          if (((AppRuntime)localObject2).getLongAccountUin() % j != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.c) {
            break label686;
          }
          i = 1;
        }
      }
      if (j != 1) {
        break label705;
      }
      i = 1;
      if (i == 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.b == -1) {
        break label702;
      }
      localObject1 = (String)localObject1 + "?type=" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.b;
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser_report", 2, "try report web status, onBackEvent,  step: " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Int + ", hasRedDot : " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Boolean + ", crashFrom : " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.b + ", stepTime: " + (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.b) + ", totalTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.b) + "\n" + (String)localObject1);
      }
      str2 = SwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Boolean, (AppRuntime)localObject2);
      localObject2 = new JSONObject();
      localJSONObject = new JSONObject();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */