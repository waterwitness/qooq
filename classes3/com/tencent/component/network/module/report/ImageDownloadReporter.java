package com.tencent.component.network.module.report;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.common.a;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.common.NetworkState;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;

public class ImageDownloadReporter
  implements ReportHandler
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static int a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null)
    {
      paramHttpResponse = null;
      if (paramHttpResponse == null) {}
    }
    for (;;)
    {
      if (!paramHttpResponse.hasNext())
      {
        return 0;
        paramHttpResponse = paramHttpResponse.headerIterator("Retcode");
        break;
      }
      Header localHeader = paramHttpResponse.nextHeader();
      if (localHeader != null) {
        try
        {
          int i = Integer.parseInt(localHeader.getValue());
          return i;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          a.a("ImageDownload", "getRetCodeFrom", localNumberFormatException);
        }
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return new String(arrayOfChar);
      }
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = a[(j & 0xF)];
      i += 1;
    }
  }
  
  /* Error */
  private static byte[] a(File paramFile, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnull +17 -> 21
    //   7: aload_0
    //   8: invokevirtual 90	java/io/File:exists	()Z
    //   11: ifeq +10 -> 21
    //   14: aload_0
    //   15: invokevirtual 93	java/io/File:isFile	()Z
    //   18: ifne +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: invokevirtual 97	java/io/File:length	()J
    //   27: lstore 9
    //   29: lload_1
    //   30: lstore 7
    //   32: lload_1
    //   33: lconst_0
    //   34: lcmp
    //   35: ifge +6 -> 41
    //   38: lconst_0
    //   39: lstore 7
    //   41: lload 7
    //   43: lload 9
    //   45: lcmp
    //   46: ifge -25 -> 21
    //   49: sipush 1024
    //   52: lload 9
    //   54: lload 7
    //   56: lsub
    //   57: l2i
    //   58: invokestatic 103	java/lang/Math:min	(II)I
    //   61: istore 6
    //   63: iload 6
    //   65: newarray <illegal type>
    //   67: astore 4
    //   69: new 105	java/io/RandomAccessFile
    //   72: dup
    //   73: aload_0
    //   74: ldc 107
    //   76: invokespecial 110	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   79: astore_3
    //   80: aload_3
    //   81: lload 7
    //   83: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   86: aload_3
    //   87: aload 4
    //   89: invokevirtual 118	java/io/RandomAccessFile:read	([B)I
    //   92: istore 6
    //   94: iload 6
    //   96: ifgt +15 -> 111
    //   99: aload 5
    //   101: astore_0
    //   102: aload_3
    //   103: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   106: aload_0
    //   107: areturn
    //   108: astore_3
    //   109: aload_0
    //   110: areturn
    //   111: iload 6
    //   113: aload 4
    //   115: arraylength
    //   116: if_icmpge +64 -> 180
    //   119: iload 6
    //   121: newarray <illegal type>
    //   123: astore_0
    //   124: aload 4
    //   126: iconst_0
    //   127: aload_0
    //   128: iconst_0
    //   129: iload 6
    //   131: invokestatic 127	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   134: goto -32 -> 102
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull -120 -> 21
    //   144: aload_0
    //   145: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_3
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   164: aload_0
    //   165: athrow
    //   166: astore_3
    //   167: goto -3 -> 164
    //   170: astore_0
    //   171: goto -15 -> 156
    //   174: astore_0
    //   175: aload_3
    //   176: astore_0
    //   177: goto -37 -> 140
    //   180: aload 4
    //   182: astore_0
    //   183: goto -81 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramFile	File
    //   0	186	1	paramLong	long
    //   79	24	3	localRandomAccessFile	java.io.RandomAccessFile
    //   108	1	3	localIOException1	IOException
    //   155	6	3	localObject1	Object
    //   166	10	3	localIOException2	IOException
    //   67	114	4	arrayOfByte	byte[]
    //   1	99	5	localObject2	Object
    //   61	69	6	i	int
    //   30	52	7	l1	long
    //   27	26	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   102	106	108	java/io/IOException
    //   63	80	137	java/lang/Throwable
    //   144	148	150	java/io/IOException
    //   63	80	153	finally
    //   160	164	166	java/io/IOException
    //   80	94	170	finally
    //   111	134	170	finally
    //   80	94	174	java/lang/Throwable
    //   111	134	174	java/lang/Throwable
  }
  
  public static int getRetCodeFrom(Throwable paramThrowable, int paramInt)
  {
    int i = paramInt;
    if (paramThrowable != null)
    {
      if (!(paramThrowable instanceof ClientProtocolException)) {
        break label18;
      }
      i = 8;
    }
    label18:
    do
    {
      return i;
      if ((paramThrowable instanceof SSLPeerUnverifiedException)) {
        return 12;
      }
      if ((paramThrowable instanceof NoHttpResponseException)) {
        return 11;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return 9;
      }
      if ((paramThrowable instanceof ConnectionPoolTimeoutException)) {
        return 13;
      }
      if ((paramThrowable instanceof ConnectTimeoutException)) {
        return 10;
      }
      if ((paramThrowable instanceof IllegalStateException)) {
        return 5;
      }
      if ((paramThrowable instanceof SocketException)) {
        return 6;
      }
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return 7;
      }
      if ((paramThrowable instanceof FileNotFoundException)) {
        return 1;
      }
      if ((paramThrowable instanceof IOException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("No space left on device"))) {
          return 50003;
        }
        return 2;
      }
      if ((paramThrowable instanceof Exception)) {
        return 4;
      }
      i = paramInt;
    } while (!(paramThrowable instanceof OutOfMemoryError));
    return 3;
  }
  
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (;;)
    {
      return false;
      if (a.e((String)localObject1, "text/html"))
      {
        localObject2 = null;
        localObject1 = null;
        try
        {
          paramHttpResponse = paramHttpResponse.getEntity().getContent();
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          Object localObject3 = new byte['Ѐ'];
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          int i = paramHttpResponse.read((byte[])localObject3);
          if (i > 0)
          {
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            localObject3 = new String((byte[])localObject3, 0, i);
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            paramDownloadResult.getContent().content = localObject3;
          }
          if (paramHttpResponse != null) {
            try
            {
              paramHttpResponse.close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              a.a("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        catch (IOException paramDownloadResult)
        {
          localObject2 = localObject1;
          a.a("ImageDownloadReporter", "handleContentType", paramDownloadResult);
          if (localObject1 != null) {
            try
            {
              ((InputStream)localObject1).close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              a.a("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        finally
        {
          if (localObject2 == null) {}
        }
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      throw paramDownloadResult;
    }
    catch (IOException paramHttpResponse)
    {
      for (;;)
      {
        a.a("ImageDownloader", "", paramHttpResponse);
      }
    }
  }
  
  public void handleReport(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    uploadReport(obtainReportObj(paramDownloadResult, paramDownloadReport));
  }
  
  public ReportHandler.DownloadReportObject obtainReportObj(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    ReportHandler.DownloadReportObject localDownloadReportObject = new ReportHandler.DownloadReportObject();
    localDownloadReportObject.init();
    localDownloadReportObject.setUrl(paramDownloadReport.url);
    localDownloadReportObject.fileSize = paramDownloadReport.fileSize;
    localDownloadReportObject.startTime = paramDownloadReport.startTime;
    localDownloadReportObject.endTime = paramDownloadReport.endTime;
    localDownloadReportObject.elapse = (localDownloadReportObject.endTime - localDownloadReportObject.startTime);
    localDownloadReportObject.flow = paramDownloadReport.id;
    localDownloadReportObject.networkType = NetworkState.g().getNetworkType();
    localDownloadReportObject.serverIp = paramDownloadReport.remoteAddress;
    localDownloadReportObject.dnsIp = paramDownloadReport.dns;
    localDownloadReportObject.retry = paramDownloadReport.currAttempCount;
    localDownloadReportObject.strategyInfo = paramDownloadReport.strategyInfo;
    localDownloadReportObject.clientip = paramDownloadReport.clientip;
    localDownloadReportObject.totaltime = paramDownloadReport.totaltime;
    localDownloadReportObject.t_wait = paramDownloadReport.t_wait;
    localDownloadReportObject.t_prepare = paramDownloadReport.t_prepare;
    localDownloadReportObject.t_conn = paramDownloadReport.t_conn;
    localDownloadReportObject.t_recvrsp = paramDownloadReport.t_recvrsp;
    localDownloadReportObject.t_recvdata = paramDownloadReport.t_recvdata;
    localDownloadReportObject.t_process = paramDownloadReport.t_process;
    localDownloadReportObject.content_type = paramDownloadReport.content_type;
    localDownloadReportObject.concurrent = paramDownloadReport.concurrent;
    localDownloadReportObject.refer = paramDownloadReport.refer;
    localDownloadReportObject.t = paramDownloadReport.exception;
    if (paramDownloadResult.getStatus().isSucceed())
    {
      if (paramDownloadResult.getContent().noCache)
      {
        localDownloadReportObject.retCode = a(paramDownloadReport.response);
        if (localDownloadReportObject.retCode == 0) {
          localDownloadReportObject.retCode = -2;
        }
        return localDownloadReportObject;
      }
      if (paramDownloadResult.getContent().size != paramDownloadResult.getContent().length)
      {
        localDownloadReportObject.retCode = -3;
        localDownloadReportObject.errMsg.append(";content-length:" + paramDownloadResult.getContent().length + ";actual-size:" + paramDownloadResult.getContent().size);
        paramDownloadReport = new File(paramDownloadResult.getPath());
        paramDownloadResult = a(a(paramDownloadReport, 0L));
        paramDownloadReport = a(a(paramDownloadReport, paramDownloadReport.length() - 1024L));
        localDownloadReportObject.errMsg.append(";head-content:" + paramDownloadResult);
        localDownloadReportObject.errMsg.append(";tail-content:" + paramDownloadReport);
        return localDownloadReportObject;
      }
      if ((paramDownloadResult.getContent().realsize > 0L) && (paramDownloadResult.getContent().realsize != paramDownloadResult.getContent().length))
      {
        localDownloadReportObject.retCode = 50002;
        localDownloadReportObject.errMsg.append(";content-length:" + paramDownloadResult.getContent().length + ";real-size:" + paramDownloadResult.getContent().realsize);
        return localDownloadReportObject;
      }
      localDownloadReportObject.retCode = 0;
      return localDownloadReportObject;
    }
    localDownloadReportObject.errMsg.append("httpStatus:" + paramDownloadReport.httpStatus + "; ");
    if (paramDownloadReport.exception != null)
    {
      localDownloadReportObject.retCode = getRetCodeFrom(paramDownloadReport.exception, localDownloadReportObject.retCode);
      localDownloadReportObject.errMsg.append(Log.getStackTraceString(paramDownloadReport.exception));
      return localDownloadReportObject;
    }
    if (paramDownloadResult.getStatus().getFailReason() == 5)
    {
      localDownloadReportObject.retCode = -1;
      localDownloadReportObject.errMsg.append("content-type:" + paramDownloadResult.getContent().type + "; data:" + paramDownloadResult.getContent().content + "; ");
      return localDownloadReportObject;
    }
    if (paramDownloadReport.response == null)
    {
      localDownloadReportObject.retCode = -99997;
      return localDownloadReportObject;
    }
    localDownloadReportObject.retCode = paramDownloadReport.httpStatus;
    return localDownloadReportObject;
  }
  
  public void uploadReport(ReportHandler.DownloadReportObject paramDownloadReportObject)
  {
    if (paramDownloadReportObject == null) {
      return;
    }
    BusinessReport.uploadReport(paramDownloadReportObject, paramDownloadReportObject.appIdType, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\report\ImageDownloadReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */