package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector
{
  private final List<ConnectionSpec> connectionSpecs;
  private boolean isFallback;
  private boolean isFallbackPossible;
  private int nextModeIndex = 0;
  
  public ConnectionSpecSelector(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = paramList;
  }
  
  private boolean isFallbackPossible(SSLSocket paramSSLSocket)
  {
    int i = this.nextModeIndex;
    for (;;)
    {
      if (i >= this.connectionSpecs.size()) {
        return false;
      }
      if (((ConnectionSpec)this.connectionSpecs.get(i)).isCompatible(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
  }
  
  public ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket)
    throws IOException
  {
    Object localObject = null;
    int i = this.nextModeIndex;
    int j = this.connectionSpecs.size();
    for (;;)
    {
      if (i >= j) {}
      for (;;)
      {
        if (localObject != null) {
          break label129;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
        ConnectionSpec localConnectionSpec = (ConnectionSpec)this.connectionSpecs.get(i);
        if (!localConnectionSpec.isCompatible(paramSSLSocket)) {
          break;
        }
        localObject = localConnectionSpec;
        this.nextModeIndex = (i + 1);
      }
      i += 1;
    }
    label129:
    this.isFallbackPossible = isFallbackPossible(paramSSLSocket);
    Internal.instance.apply((ConnectionSpec)localObject, paramSSLSocket, this.isFallback);
    return (ConnectionSpec)localObject;
  }
  
  public boolean connectionFailed(IOException paramIOException)
  {
    this.isFallback = true;
    if ((paramIOException instanceof ProtocolException)) {}
    while (((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)) || ((!(paramIOException instanceof SSLHandshakeException)) && (!(paramIOException instanceof SSLProtocolException))) || (!this.isFallbackPossible)) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\ConnectionSpecSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */