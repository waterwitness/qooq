import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.HYIvrSessionIdManager;
import cooperation.huangye.download.DownloadParams;
import cooperation.huangye.download.DownloadResult;
import cooperation.huangye.download.HYDownloadAsyncTask;
import org.json.JSONException;
import org.json.JSONObject;

public class ycs
  extends HYDownloadAsyncTask
{
  private ycs(HYIvrSessionIdManager paramHYIvrSessionIdManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    if (TextUtils.isEmpty((String)paramDownloadParams.jdField_a_of_type_JavaLangObject)) {
      return;
    }
    if (paramDownloadParams.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        localObject1 = new String(paramDownloadParams.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (localObject1 == null) {
          break label347;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            i = ((JSONObject)localObject1).getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "onPostDownloadComplete : retcode = " + i);
            }
            if (i != 0) {
              break label337;
            }
            localObject8 = ((JSONObject)localObject1).getJSONObject("result");
            if (localObject8 == null) {
              break label337;
            }
            i = 0;
            localObject7 = ((JSONObject)localObject8).getString("errCode");
          }
          catch (JSONException localJSONException1)
          {
            Object localObject1;
            Object localObject8;
            Object localObject2;
            localObject7 = null;
            Object localObject3 = null;
            localObject6 = null;
            if (QLog.isColorLevel()) {
              QLog.i(this.a.a, 2, "onPostDownloadComplete : errorCode = " + (String)localObject7 + ",ret = " + -2);
            }
            i = -2;
            localObject7 = localObject6;
            localObject6 = localObject3;
            localObject3 = null;
            continue;
            this.a.a((String)paramDownloadParams.jdField_a_of_type_JavaLangObject, null, null, null);
            return;
          }
          try
          {
            localObject6 = ((JSONObject)localObject8).getString("sessionID");
          }
          catch (JSONException localJSONException2)
          {
            Object localObject4 = null;
            localObject6 = null;
            continue;
          }
          try
          {
            localObject1 = ((JSONObject)localObject8).getString("appid");
          }
          catch (JSONException localJSONException3)
          {
            localObject5 = null;
            continue;
          }
          try
          {
            localObject8 = ((JSONObject)localObject8).getString("userinfo");
            localObject7 = localObject6;
            localObject6 = localObject1;
            localObject1 = localObject8;
            if (i != 0) {
              continue;
            }
            this.a.a((String)paramDownloadParams.jdField_a_of_type_JavaLangObject, (String)localObject7, (String)localObject6, (String)localObject1);
            return;
          }
          catch (JSONException localJSONException4) {}
        }
        localException = localException;
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + localException.toString());
        }
        localObject2 = null;
        continue;
      }
      label337:
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject5 = null;
      continue;
      label347:
      localObject5 = null;
      localObject6 = null;
      int i = -1;
      localObject7 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */