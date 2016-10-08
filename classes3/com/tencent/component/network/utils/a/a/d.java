package com.tencent.component.network.utils.a.a;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

public final class d
  extends SSLSocketFactory
{
  public d()
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(null);
    setHostnameVerifier(new e());
  }
  
  public static void a(Socket paramSocket, String paramString)
  {
    if ((paramSocket != null) && ((paramSocket instanceof SSLSocket))) {}
    for (paramSocket = (SSLSocket)paramSocket;; paramSocket = null)
    {
      if (paramSocket != null) {}
      try
      {
        a.a(paramString, paramSocket);
        return;
      }
      catch (Exception paramSocket)
      {
        paramSocket.printStackTrace();
        return;
      }
    }
  }
  
  public final Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
    throws IOException
  {
    return super.connectSocket(paramSocket, paramString, paramInt1, paramInetAddress, paramInt2, paramHttpParams);
  }
  
  public final Socket createSocket()
    throws IOException
  {
    return super.createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws UnknownHostException, IOException
  {
    return super.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public static final class a
  {
    private static final AtomicReference<a> a = new AtomicReference();
    private final WeakReference<Class<?>> b;
    private final WeakReference<Method> c;
    
    private a(Class<?> paramClass, Method paramMethod)
    {
      this.b = new WeakReference(paramClass);
      if (paramMethod == null) {}
      for (paramClass = null;; paramClass = new WeakReference(paramMethod))
      {
        this.c = paramClass;
        return;
      }
    }
    
    private static Method a(Class<?> paramClass)
    {
      Object localObject = null;
      try
      {
        Method localMethod = paramClass.getMethod("setHostname", new Class[] { String.class });
        localObject = localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      catch (SecurityException localSecurityException)
      {
        for (;;) {}
      }
      a.set(new a(paramClass, (Method)localObject));
      return (Method)localObject;
    }
    
    public static void a(String paramString, SSLSocket paramSSLSocket)
    {
      int j = 1;
      Class localClass = paramSSLSocket.getClass();
      Object localObject = (a)a.get();
      if (localObject == null) {
        localObject = a(localClass);
      }
      label79:
      label105:
      label141:
      for (;;)
      {
        if (localObject != null) {}
        try
        {
          ((Method)localObject).invoke(paramSSLSocket, new Object[] { paramString });
          return;
        }
        catch (InvocationTargetException paramString)
        {
          int i;
          return;
        }
        catch (IllegalAccessException paramString)
        {
          return;
        }
        catch (IllegalArgumentException paramString) {}
        if (((a)localObject).b.get() != localClass) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label79;
          }
          localObject = a(localClass);
          break;
        }
        if (((a)localObject).c == null) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label105;
          }
          localObject = null;
          break;
        }
        localObject = (Method)((a)localObject).c.get();
        if (localObject == null) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label141;
          }
          localObject = a(localClass);
          break;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */