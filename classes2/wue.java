import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.MyX509TrustManager;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class wue
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext a;
  
  public wue(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = SSLContext.getInstance("TLS");
    try
    {
      paramKeyStore = new HttpBaseUtil.MyX509TrustManager();
      this.a.init(null, new TrustManager[] { paramKeyStore }, null);
      return;
    }
    catch (Exception paramKeyStore)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(HttpBaseUtil.a, 2, paramKeyStore.getMessage());
        }
        paramKeyStore = null;
      }
    }
  }
  
  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */