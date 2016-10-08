package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import javax.annotation.Nullable;

public class DecompressionHelper
{
  static final String DEFLATE_ENCODING = "deflate";
  static final String GZIP_ENCODING = "gzip";
  
  public static InputStream teeInputWithDecompression(NetworkPeerManager paramNetworkPeerManager, String paramString1, InputStream paramInputStream, OutputStream paramOutputStream, @Nullable String paramString2, ResponseHandler paramResponseHandler)
    throws IOException
  {
    OutputStream localOutputStream = paramOutputStream;
    Object localObject3 = null;
    Object localObject1 = localOutputStream;
    Object localObject2 = localObject3;
    boolean bool2;
    if (paramString2 != null)
    {
      boolean bool1 = "gzip".equals(paramString2);
      bool2 = "deflate".equals(paramString2);
      if ((!bool1) && (!bool2)) {
        break label115;
      }
      paramOutputStream = new CountingOutputStream(paramOutputStream);
      if (!bool1) {
        break label87;
      }
      localObject1 = GunzippingOutputStream.create(paramOutputStream);
      localObject2 = paramOutputStream;
    }
    for (;;)
    {
      return new ResponseHandlingInputStream(paramInputStream, paramString1, (OutputStream)localObject1, (CountingOutputStream)localObject2, paramNetworkPeerManager, paramResponseHandler);
      label87:
      localObject1 = localOutputStream;
      localObject2 = paramOutputStream;
      if (bool2)
      {
        localObject1 = new InflaterOutputStream(paramOutputStream);
        localObject2 = paramOutputStream;
        continue;
        label115:
        CLog.writeToConsole(paramNetworkPeerManager, Console.MessageLevel.WARNING, Console.MessageSource.NETWORK, "Unsupported Content-Encoding in response for request #" + paramString1 + ": " + paramString2);
        localObject1 = localOutputStream;
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\DecompressionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */