package com.tencent.mobileqq.highway.codec;

import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.msf.core.net.MsfHttpResp;
import com.tencent.mobileqq.msf.core.net.MsfHttpRespParse;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpException;
import org.apache.http.StatusLine;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;

public class HttpProtocolDataCodec
  extends TcpProtocolDataCodec
{
  public static final int HTTP_DEFAULT_PORT = 80;
  
  private byte[] createHttpReqData(EndPoint paramEndPoint, byte[] paramArrayOfByte)
  {
    paramEndPoint = ("POST /cgi-bin/httpconn?htcmd=0x6ff0082 HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: " + paramEndPoint.host + ":" + paramEndPoint.port + "\r\n" + "Accept: */*\r\n" + "User-Agent: javaMsfClient\r\n" + "Content-Type: application/x-www-form-urlencoded\r\n" + "Content-Length: " + paramArrayOfByte.length + "\r\n\r\n").getBytes();
    byte[] arrayOfByte = new byte[paramEndPoint.length + paramArrayOfByte.length];
    System.arraycopy(paramEndPoint, 0, arrayOfByte, 0, paramEndPoint.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, paramEndPoint.length, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] encodeC2SData(EndPoint paramEndPoint, HwRequest paramHwRequest, byte[] paramArrayOfByte)
  {
    return createHttpReqData(paramEndPoint, super.encodeC2SData(paramEndPoint, paramHwRequest, paramArrayOfByte));
  }
  
  public void onRecvData(MsfSocketInputBuffer paramMsfSocketInputBuffer)
    throws IOException, HttpException
  {
    MsfHttpResp localMsfHttpResp = new MsfHttpRespParse(paramMsfSocketInputBuffer).parse();
    label44:
    int i;
    if (MsfHttpRespParse.canResponseHaveBody(localMsfHttpResp))
    {
      if (localMsfHttpResp.getContentLen() != -1) {
        localMsfHttpResp.setContent(new ContentLengthInputStream(paramMsfSocketInputBuffer, localMsfHttpResp.getContentLen()));
      }
    }
    else
    {
      i = localMsfHttpResp.getStatusLine().getStatusCode();
      if (i >= 200) {
        break label120;
      }
      if (i == 100) {}
    }
    while (!paramMsfSocketInputBuffer.hasBufferedData())
    {
      return;
      if (localMsfHttpResp.getTransferEncoding().equalsIgnoreCase("chunked"))
      {
        localMsfHttpResp.setContent(new ChunkedInputStream(paramMsfSocketInputBuffer));
        break label44;
      }
      localMsfHttpResp.setContent(new IdentityInputStream(paramMsfSocketInputBuffer));
      break label44;
      label120:
      byte[] arrayOfByte2 = new byte['倀'];
      byte[] arrayOfByte1 = null;
      i = 0;
      for (;;)
      {
        int j = localMsfHttpResp.getContent().read(arrayOfByte2);
        if (j <= 0) {
          break;
        }
        i += j;
        arrayOfByte1 = new byte[j];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte1.length);
      }
      decodeS2CData(arrayOfByte1);
    }
  }
  
  public void setProtocolCodecListener(IProtocolCodecListener paramIProtocolCodecListener)
  {
    super.setProtocolCodecListener(paramIProtocolCodecListener);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\codec\HttpProtocolDataCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */