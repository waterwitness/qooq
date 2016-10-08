package com.weiyun.sdk.util;

import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

public class ErrCodeUtil
{
  public static int getErrCodeFromIOException(IOException paramIOException)
  {
    int j = 35528;
    int i;
    if ((paramIOException instanceof ConnectException))
    {
      paramIOException = paramIOException.getMessage();
      if ((paramIOException != null) && (paramIOException.indexOf("Network is unreachable") >= 0)) {
        i = 55533;
      }
    }
    do
    {
      do
      {
        return i;
        return 35526;
        if ((paramIOException instanceof ConnectTimeoutException)) {
          return 35508;
        }
        if ((paramIOException instanceof MalformedURLException)) {
          return 35510;
        }
        if ((paramIOException instanceof SocketTimeoutException)) {
          return 35534;
        }
        if ((paramIOException instanceof UnknownHostException)) {
          return 35524;
        }
        if (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof ClientProtocolException))) {
          return 35523;
        }
        if ((paramIOException instanceof PortUnreachableException)) {
          return 35522;
        }
        if ((paramIOException instanceof NoRouteToHostException)) {
          return 35521;
        }
        if ((paramIOException instanceof EOFException)) {
          return 35520;
        }
        i = j;
      } while ((paramIOException instanceof BindException));
      if ((paramIOException instanceof NoHttpResponseException)) {
        return 55512;
      }
      if (!(paramIOException instanceof SocketException)) {
        break;
      }
      paramIOException = paramIOException.getMessage();
      if (paramIOException == null) {
        return 35518;
      }
      paramIOException = paramIOException.toLowerCase();
      if (Pattern.compile(".*etimedout.*").matcher(paramIOException).matches()) {
        return 35535;
      }
      if (Pattern.compile(".*socket.*is.*closed.*").matcher(paramIOException).matches()) {
        return 35533;
      }
      if (Pattern.compile(".*connect.*reset.*by.*peer.*").matcher(paramIOException).matches()) {
        return 35531;
      }
      if (Pattern.compile(".*connect.*reset.*").matcher(paramIOException).matches()) {
        return 35532;
      }
      if (Pattern.compile(".*broken.*pipe.*").matcher(paramIOException).matches()) {
        return 35530;
      }
      if (Pattern.compile(".*connection.*refused.*").matcher(paramIOException).matches()) {
        return 35525;
      }
      if (Pattern.compile(".*too.*many.*open.*files.*").matcher(paramIOException).matches()) {
        return 35529;
      }
      if (Pattern.compile(".*address.*family.*").matcher(paramIOException).matches()) {
        return 35527;
      }
      i = j;
    } while (Pattern.compile(".*jvm_bind.*").matcher(paramIOException).matches());
    do
    {
      return 35513;
      if ((paramIOException instanceof ClosedByInterruptException)) {
        return 35516;
      }
      if ((paramIOException instanceof AsynchronousCloseException)) {
        return 35517;
      }
      if ((paramIOException instanceof ClosedChannelException)) {
        return 35514;
      }
      paramIOException = paramIOException.getMessage();
      if (paramIOException == null) {
        return 35513;
      }
      if (paramIOException.indexOf("unexpected end of stream") >= 0) {
        return 35509;
      }
    } while (!paramIOException.contains("No space left on device"));
    return 55528;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\util\ErrCodeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */