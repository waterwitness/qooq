package com.facebook.react.modules.network;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.internal.Util;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

class RequestBodyUtil
{
  private static final String CONTENT_ENCODING_GZIP = "gzip";
  
  public static RequestBody create(MediaType paramMediaType, final InputStream paramInputStream)
  {
    new RequestBody()
    {
      public long contentLength()
      {
        try
        {
          int i = paramInputStream.available();
          return i;
        }
        catch (IOException localIOException) {}
        return 0L;
      }
      
      public MediaType contentType()
      {
        return this.val$mediaType;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        Object localObject = null;
        try
        {
          Source localSource = Okio.source(paramInputStream);
          localObject = localSource;
          paramAnonymousBufferedSink.writeAll(localSource);
          Util.closeQuietly(localSource);
          return;
        }
        finally
        {
          Util.closeQuietly((Closeable)localObject);
        }
      }
    };
  }
  
  @Nullable
  public static RequestBody createGzip(MediaType paramMediaType, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes());
      localGZIPOutputStream.close();
      return RequestBody.create(paramMediaType, localByteArrayOutputStream.toByteArray());
    }
    catch (IOException paramMediaType) {}
    return null;
  }
  
  @Nullable
  public static InputStream getFileInputStream(Context paramContext, String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      paramContext = paramContext.getContentResolver().openInputStream(localUri);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (FLog.isLoggable(6)) {
        FLog.e("React", "Could not retrieve file for contentUri " + paramString, paramContext);
      }
    }
    return null;
  }
  
  public static boolean isGzipEncoding(@Nullable String paramString)
  {
    return "gzip".equalsIgnoreCase(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\network\RequestBodyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */