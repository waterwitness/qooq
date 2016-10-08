package com.tencent.component.network.utils.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.auth.x500.X500Principal;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.conn.util.InetAddressUtils;

public final class c
  implements X509HostnameVerifier
{
  private static final String[] a;
  
  static
  {
    String[] arrayOfString = new String[14];
    arrayOfString[0] = "ac";
    arrayOfString[1] = "co";
    arrayOfString[2] = "com";
    arrayOfString[3] = "ed";
    arrayOfString[4] = "edu";
    arrayOfString[5] = "go";
    arrayOfString[6] = "gouv";
    arrayOfString[7] = "gov";
    arrayOfString[8] = "info";
    arrayOfString[9] = "lg";
    arrayOfString[10] = "ne";
    arrayOfString[11] = "net";
    arrayOfString[12] = "or";
    arrayOfString[13] = "org";
    a = arrayOfString;
    Arrays.sort(arrayOfString);
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && ((InetAddressUtils.isIPv4Address(paramString)) || (InetAddressUtils.isIPv6Address(paramString)));
  }
  
  private static String[] a(X509Certificate paramX509Certificate, String paramString)
  {
    int i;
    if (a(paramString)) {
      i = 7;
    }
    for (;;)
    {
      paramString = new LinkedList();
      try
      {
        paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
        if (paramX509Certificate != null)
        {
          paramX509Certificate = paramX509Certificate.iterator();
          if (paramX509Certificate.hasNext()) {}
        }
        else
        {
          if (paramString.isEmpty()) {
            break label122;
          }
          paramX509Certificate = new String[paramString.size()];
          paramString.toArray(paramX509Certificate);
          return paramX509Certificate;
          i = 2;
        }
      }
      catch (CertificateParsingException paramX509Certificate)
      {
        for (;;)
        {
          paramX509Certificate = null;
          continue;
          List localList = (List)paramX509Certificate.next();
          if (((Integer)localList.get(0)).intValue() == i) {
            paramString.add((String)localList.get(1));
          }
        }
      }
    }
    label122:
    return null;
  }
  
  public final void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new StringTokenizer(paramX509Certificate.getSubjectX500Principal().toString(), ",");
    if (!((StringTokenizer)localObject).hasMoreTokens())
    {
      if (localLinkedList.isEmpty()) {
        break label117;
      }
      localObject = new String[localLinkedList.size()];
      localLinkedList.toArray((Object[])localObject);
    }
    for (;;)
    {
      verify(paramString, (String[])localObject, a(paramX509Certificate, paramString));
      return;
      String str = ((StringTokenizer)localObject).nextToken().trim();
      if ((str.length() <= 3) || (!str.substring(0, 3).equalsIgnoreCase("CN="))) {
        break;
      }
      localLinkedList.add(str.substring(3));
      break;
      label117:
      localObject = null;
    }
  }
  
  public final void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    if (paramString == null) {
      throw new NullPointerException("host to verify is null");
    }
    d.a(paramSSLSocket, paramString);
    SSLSession localSSLSession2 = paramSSLSocket.getSession();
    SSLSession localSSLSession1 = localSSLSession2;
    if (localSSLSession2 == null)
    {
      paramSSLSocket.getInputStream().available();
      localSSLSession2 = paramSSLSocket.getSession();
      localSSLSession1 = localSSLSession2;
      if (localSSLSession2 == null)
      {
        paramSSLSocket.startHandshake();
        localSSLSession1 = paramSSLSocket.getSession();
      }
    }
    verify(paramString, (X509Certificate)localSSLSession1.getPeerCertificates()[0]);
  }
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {
    Object localObject1 = new LinkedList();
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0) && (paramArrayOfString1[0] != null)) {
      ((LinkedList)localObject1).add(paramArrayOfString1[0]);
    }
    int j;
    int i;
    if (paramArrayOfString2 != null)
    {
      j = paramArrayOfString2.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        if (!((LinkedList)localObject1).isEmpty()) {
          break;
        }
        throw new SSLException("Certificate for <" + paramString + "> doesn't contain CN or DNS subjectAlt");
      }
      paramArrayOfString1 = paramArrayOfString2[i];
      if (paramArrayOfString1 != null) {
        ((LinkedList)localObject1).add(paramArrayOfString1);
      }
      i += 1;
    }
    paramArrayOfString1 = new StringBuilder();
    paramArrayOfString2 = paramString.trim().toLowerCase(Locale.US);
    localObject1 = ((LinkedList)localObject1).iterator();
    boolean bool1 = false;
    boolean bool2;
    if (!((Iterator)localObject1).hasNext())
    {
      bool2 = bool1;
      label156:
      if (!bool2) {
        throw new SSLException("hostname in certificate didn't match: <" + paramString + "> !=" + paramArrayOfString1);
      }
    }
    else
    {
      String str = ((String)((Iterator)localObject1).next()).toLowerCase(Locale.US);
      paramArrayOfString1.append(" <");
      paramArrayOfString1.append(str);
      paramArrayOfString1.append('>');
      if (((Iterator)localObject1).hasNext()) {
        paramArrayOfString1.append(" OR");
      }
      Object localObject2 = str.split("\\.");
      Object localObject3;
      if ((localObject2.length >= 3) && (localObject2[0].endsWith("*")))
      {
        localObject3 = str.split("\\.");
        if ((localObject3.length != 3) || (localObject3[2].length() != 2))
        {
          i = 1;
          label309:
          if ((i == 0) || (a(paramString))) {
            break label450;
          }
          i = 1;
          label324:
          if (i == 0) {
            break label477;
          }
          localObject3 = localObject2[0];
          if (((String)localObject3).length() <= 1) {
            break label462;
          }
          localObject2 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
          str = str.substring(((String)localObject3).length());
          localObject3 = paramArrayOfString2.substring(((String)localObject2).length());
          if ((!paramArrayOfString2.startsWith((String)localObject2)) || (!((String)localObject3).endsWith(str))) {
            break label456;
          }
          bool2 = true;
          label404:
          bool1 = bool2;
          if (!bool2) {}
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool1) {
          break label156;
        }
        break;
        if (Arrays.binarySearch(a, localObject3[1]) < 0)
        {
          i = 1;
          break label309;
        }
        i = 0;
        break label309;
        label450:
        i = 0;
        break label324;
        label456:
        bool2 = false;
        break label404;
        label462:
        bool2 = paramArrayOfString2.endsWith(str.substring(1));
        break label404;
        label477:
        bool1 = paramArrayOfString2.equals(str);
      }
    }
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return true;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */