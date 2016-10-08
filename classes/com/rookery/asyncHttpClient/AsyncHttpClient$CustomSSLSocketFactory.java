package com.rookery.asyncHttpClient;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class AsyncHttpClient$CustomSSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a;
  
  public AsyncHttpClient$CustomSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = SSLContext.getInstance("TLS");
    try
    {
      paramKeyStore = new AsyncHttpClient.MyX509TrustManager();
      this.a.init(null, new TrustManager[] { paramKeyStore }, null);
      return;
    }
    catch (Exception paramKeyStore)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[cancel] cancel task" + paramKeyStore);
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


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\rookery\asyncHttpClient\AsyncHttpClient$CustomSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */