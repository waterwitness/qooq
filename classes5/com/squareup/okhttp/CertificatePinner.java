package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class CertificatePinner
{
  public static final CertificatePinner DEFAULT = new Builder().build();
  private final Map<String, Set<ByteString>> hostnameToPins;
  
  private CertificatePinner(Builder paramBuilder)
  {
    this.hostnameToPins = Util.immutableMap(paramBuilder.hostnameToPins);
  }
  
  public static String pin(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha1/" + sha1((X509Certificate)paramCertificate).base64();
  }
  
  private static ByteString sha1(X509Certificate paramX509Certificate)
  {
    return Util.sha1(ByteString.of(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public void check(String paramString, List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    Set localSet = findMatchingPins(paramString);
    if (localSet == null) {
      return;
    }
    int i = 0;
    int j = paramList.size();
    label24:
    StringBuilder localStringBuilder;
    if (i >= j)
    {
      localStringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
      i = 0;
      j = paramList.size();
      label60:
      if (i < j) {
        break label145;
      }
      localStringBuilder.append("\n  Pinned certificates for ").append(paramString).append(":");
      paramString = localSet.iterator();
    }
    for (;;)
    {
      if (!paramString.hasNext())
      {
        throw new SSLPeerUnverifiedException(localStringBuilder.toString());
        if (localSet.contains(sha1((X509Certificate)paramList.get(i)))) {
          break;
        }
        i += 1;
        break label24;
        label145:
        X509Certificate localX509Certificate = (X509Certificate)paramList.get(i);
        localStringBuilder.append("\n    ").append(pin(localX509Certificate)).append(": ").append(localX509Certificate.getSubjectDN().getName());
        i += 1;
        break label60;
      }
      paramList = (ByteString)paramString.next();
      localStringBuilder.append("\n    sha1/").append(paramList.base64());
    }
  }
  
  public void check(String paramString, Certificate... paramVarArgs)
    throws SSLPeerUnverifiedException
  {
    check(paramString, Arrays.asList(paramVarArgs));
  }
  
  Set<ByteString> findMatchingPins(String paramString)
  {
    Set localSet2 = (Set)this.hostnameToPins.get(paramString);
    Set localSet1 = null;
    int i = paramString.indexOf('.');
    if (i != paramString.lastIndexOf('.')) {
      localSet1 = (Set)this.hostnameToPins.get("*." + paramString.substring(i + 1));
    }
    if ((localSet2 == null) && (localSet1 == null)) {
      return null;
    }
    if ((localSet2 != null) && (localSet1 != null))
    {
      paramString = new LinkedHashSet();
      paramString.addAll(localSet2);
      paramString.addAll(localSet1);
      return paramString;
    }
    if (localSet2 != null) {
      return localSet2;
    }
    return localSet1;
  }
  
  public static final class Builder
  {
    private final Map<String, Set<ByteString>> hostnameToPins = new LinkedHashMap();
    
    public Builder add(String paramString, String... paramVarArgs)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("hostname == null");
      }
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      paramString = (Set)this.hostnameToPins.put(paramString, Collections.unmodifiableSet(localLinkedHashSet));
      if (paramString != null) {
        localLinkedHashSet.addAll(paramString);
      }
      int j = paramVarArgs.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return this;
        }
        paramString = paramVarArgs[i];
        if (!paramString.startsWith("sha1/")) {
          throw new IllegalArgumentException("pins must start with 'sha1/': " + paramString);
        }
        ByteString localByteString = ByteString.decodeBase64(paramString.substring("sha1/".length()));
        if (localByteString == null) {
          throw new IllegalArgumentException("pins must be base64: " + paramString);
        }
        localLinkedHashSet.add(localByteString);
        i += 1;
      }
    }
    
    public CertificatePinner build()
    {
      return new CertificatePinner(this, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\CertificatePinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */