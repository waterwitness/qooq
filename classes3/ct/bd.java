package ct;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class bd
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a = SSLContext.getInstance("TLS");
  private String b = "";
  
  public bd(KeyStore paramKeyStore, String paramString)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
    this.b = paramString;
    paramKeyStore = new a(this.b);
    this.a.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public final Socket createSocket()
    throws IOException
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return this.a.getSocketFactory().createSocket(paramSocket, this.b, paramInt, paramBoolean);
  }
  
  public static final class a
    implements X509TrustManager
  {
    private String a = "";
    
    public a(String paramString)
    {
      this.a = paramString;
    }
    
    public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      int i = bf.a(paramArrayOfX509Certificate, paramString, this.a);
      if (i > 0) {
        throw new CertificateException("result :" + i);
      }
    }
    
    public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      int i = bf.a(paramArrayOfX509Certificate, paramString, this.a);
      if (i > 0) {
        throw new CertificateException("result :" + i);
      }
    }
    
    public final X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */