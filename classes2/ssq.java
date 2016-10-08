import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.gameparty.GamePartyManager.AsyncRequestCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.manager.TicketManager;

public class ssq
  implements Runnable
{
  public ssq(GamePartyManager paramGamePartyManager, String paramString, GamePartyManager.AsyncRequestCallback paramAsyncRequestCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject1 = (HttpURLConnection)new URL(this.jdField_a_of_type_JavaLangString).openConnection();
      ((HttpURLConnection)localObject1).setRequestMethod("GET");
      ((HttpURLConnection)localObject1).setConnectTimeout(30000);
      ((HttpURLConnection)localObject1).setReadTimeout(30000);
      Object localObject2 = GamePartyManager.a(this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager).a();
      Object localObject3 = (TicketManager)GamePartyManager.a(this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager).getManager(2);
      String str = ((TicketManager)localObject3).getSkey((String)localObject2);
      localObject3 = ((TicketManager)localObject3).getPskey((String)localObject2, "openmobile.qq.com");
      ((HttpURLConnection)localObject1).setRequestProperty("Cookie", "uin=o" + (String)localObject2 + "; skey=" + str + "; p_uin=o" + (String)localObject2 + "; p_skey=" + (String)localObject3);
      if (((HttpURLConnection)localObject1).getResponseCode() == 200)
      {
        localObject1 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getInputStream()));
        localObject2 = new StringBuffer();
        for (;;)
        {
          str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break;
          }
          ((StringBuffer)localObject2).append(str);
        }
      }
      while (!QLog.isColorLevel()) {}
    }
    catch (MalformedURLException localMalformedURLException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(GamePartyManager.a(), 2, "http request, url invalid, url = " + this.jdField_a_of_type_JavaLangString);
      }
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(GamePartyManager.a(), 2, "http request succeeded, url = " + this.jdField_a_of_type_JavaLangString);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager$AsyncRequestCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqGamepartyGamePartyManager$AsyncRequestCallback.a(((StringBuffer)localObject2).toString());
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(GamePartyManager.a(), 2, "http request, ioexception");
      return;
    }
    QLog.d(GamePartyManager.a(), 2, "http request failed, url = " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ssq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */