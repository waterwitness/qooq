import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.download.DownloadParams;
import cooperation.huangye.download.DownloadResult;
import cooperation.huangye.download.HYDownloadAsyncTask;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class grg
  extends HYDownloadAsyncTask
{
  public grg(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    if (paramDownloadParams.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        paramDownloadParams = new String(paramDownloadParams.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (paramDownloadParams != null)
        {
          try
          {
            paramDownloadParams = new JSONObject(paramDownloadParams);
            j = paramDownloadParams.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d("ConferenceFlyTicketActivity", 2, "onPostDownloadComplete : retcode = " + j);
            }
            i = j;
            if (paramDownloadParams.has("result"))
            {
              paramDownloadParams = paramDownloadParams.getJSONObject("result");
              i = j;
              if (paramDownloadParams.has("result_code"))
              {
                paramDownloadParams.getString("result_code");
                i = j;
              }
            }
          }
          catch (JSONException paramDownloadParams)
          {
            int j = -2;
            i = j;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("ConferenceFlyTicketActivity", 2, "onPostDownloadComplete : result_code = " + null + ",retcode = " + -2);
            i = j;
            continue;
            this.a.a.d(Long.parseLong(this.a.e));
            this.a.a(1, 0);
            return;
          }
          if (i == 0)
          {
            this.a.a.a(Long.parseLong(this.a.e), this.a.c);
            this.a.a(this.a.e, this.a.c);
            this.a.finish();
            return;
          }
        }
      }
      catch (Exception paramDownloadParams)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConferenceFlyTicketActivity", 2, "onPostDownloadComplete :" + paramDownloadParams.toString());
        }
        paramDownloadParams = null;
        continue;
      }
      int i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */