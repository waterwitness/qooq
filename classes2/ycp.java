import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.HYIvrBusinessCache;
import cooperation.huangye.HYIvrBusinessManager;
import cooperation.huangye.download.DownloadParams;
import cooperation.huangye.download.DownloadResult;
import cooperation.huangye.download.HYDownloadAsyncTask;
import org.json.JSONException;
import org.json.JSONObject;

public class ycp
  extends HYDownloadAsyncTask
{
  private ycp(HYIvrBusinessManager paramHYIvrBusinessManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    this.a.jdField_a_of_type_Ycp = null;
    int i = -1;
    if (paramDownloadParams.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        paramDownloadParams = new String(paramDownloadParams.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (paramDownloadParams == null) {}
      }
      catch (Exception paramDownloadParams)
      {
        try
        {
          Object localObject = new JSONObject(paramDownloadParams);
          i = ((JSONObject)localObject).getInt("retcode");
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onPostDownloadComplete : retcode = " + i);
          }
          if (((JSONObject)localObject).has("result"))
          {
            localJSONObject = ((JSONObject)localObject).getJSONObject("result");
            if (!localJSONObject.has("errCode")) {
              continue;
            }
            localObject = localJSONObject.getString("errCode");
          }
        }
        catch (JSONException localJSONException1)
        {
          JSONObject localJSONObject;
          str = null;
        }
        try
        {
          localJSONObject.getJSONObject("result");
          if (i != 0) {
            continue;
          }
          HYIvrBusinessManager.a(this.a).a(paramDownloadParams);
          this.a.a(HYIvrBusinessManager.a(this.a).a());
          return;
        }
        catch (JSONException localJSONException2)
        {
          int j;
          continue;
        }
        paramDownloadParams = paramDownloadParams;
        if (QLog.isColorLevel()) {
          QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onPostDownloadComplete :" + paramDownloadParams.toString());
        }
        paramDownloadParams = null;
        continue;
        j = -2;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onPostDownloadComplete : errorCode = " + str + ",ret = " + -2);
          i = j;
        }
        continue;
        HYIvrBusinessManager.a(this.a).a(null);
        continue;
        String str = null;
        continue;
      }
      i = -1;
      paramDownloadParams = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */