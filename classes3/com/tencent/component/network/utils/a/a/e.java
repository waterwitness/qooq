package com.tencent.component.network.utils.a.a;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

final class e
  implements X509HostnameVerifier
{
  public final void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {}
  
  public final void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {}
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {}
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */