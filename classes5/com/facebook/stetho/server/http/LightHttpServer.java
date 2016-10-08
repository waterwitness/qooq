package com.facebook.stetho.server.http;

import android.net.Uri;
import com.facebook.stetho.server.LeakyBufferedInputStream;
import com.facebook.stetho.server.SocketLike;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class LightHttpServer
{
  private static final String TAG = "LightHttpServer";
  private final HandlerRegistry mHandlerRegistry;
  
  public LightHttpServer(HandlerRegistry paramHandlerRegistry)
  {
    this.mHandlerRegistry = paramHandlerRegistry;
  }
  
  private boolean dispatchToHandler(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse)
    throws IOException
  {
    Object localObject = this.mHandlerRegistry.lookup(paramLightHttpRequest.uri.getPath());
    if (localObject == null)
    {
      paramLightHttpResponse.code = 404;
      paramLightHttpResponse.reasonPhrase = "Not found";
      paramLightHttpResponse.body = LightHttpBody.create("No handler found\n", "text/plain");
      return true;
    }
    try
    {
      boolean bool = ((HttpHandler)localObject).handleRequest(paramSocketLike, paramLightHttpRequest, paramLightHttpResponse);
      return bool;
    }
    catch (RuntimeException paramLightHttpRequest)
    {
      paramLightHttpResponse.code = 500;
      paramLightHttpResponse.reasonPhrase = "Internal Server Error";
      localObject = new StringWriter();
      paramSocketLike = new PrintWriter((Writer)localObject);
      try
      {
        paramLightHttpRequest.printStackTrace(paramSocketLike);
        paramSocketLike.close();
        paramLightHttpResponse.body = LightHttpBody.create(((StringWriter)localObject).toString(), "text/plain");
        return true;
      }
      finally
      {
        paramSocketLike.close();
      }
    }
  }
  
  private static void readHeaders(LightHttpMessage paramLightHttpMessage, HttpMessageReader paramHttpMessageReader)
    throws IOException
  {
    for (;;)
    {
      String str = paramHttpMessageReader.readLine();
      if (str == null) {
        throw new EOFException();
      }
      if ("".equals(str)) {
        return;
      }
      Object localObject = str.split(": ", 2);
      if (localObject.length != 2) {
        throw new IOException("Malformed header: " + str);
      }
      str = localObject[0];
      localObject = localObject[1];
      paramLightHttpMessage.headerNames.add(str);
      paramLightHttpMessage.headerValues.add(localObject);
    }
  }
  
  @Nullable
  private static LightHttpRequest readRequestMessage(LightHttpRequest paramLightHttpRequest, HttpMessageReader paramHttpMessageReader)
    throws IOException
  {
    paramLightHttpRequest.reset();
    String str = paramHttpMessageReader.readLine();
    if (str == null) {
      return null;
    }
    String[] arrayOfString = str.split(" ", 3);
    if (arrayOfString.length != 3) {
      throw new IOException("Invalid request line: " + str);
    }
    paramLightHttpRequest.method = arrayOfString[0];
    paramLightHttpRequest.uri = Uri.parse(arrayOfString[1]);
    paramLightHttpRequest.protocol = arrayOfString[2];
    readHeaders(paramLightHttpRequest, paramHttpMessageReader);
    return paramLightHttpRequest;
  }
  
  private static void writeFullResponse(LightHttpResponse paramLightHttpResponse, HttpMessageWriter paramHttpMessageWriter, OutputStream paramOutputStream)
    throws IOException
  {
    paramLightHttpResponse.prepare();
    writeResponseMessage(paramLightHttpResponse, paramHttpMessageWriter);
    if (paramLightHttpResponse.body != null) {
      paramLightHttpResponse.body.writeTo(paramOutputStream);
    }
  }
  
  public static void writeResponseMessage(LightHttpResponse paramLightHttpResponse, HttpMessageWriter paramHttpMessageWriter)
    throws IOException
  {
    paramHttpMessageWriter.writeLine("HTTP/1.1 " + paramLightHttpResponse.code + " " + paramLightHttpResponse.reasonPhrase);
    int i = 0;
    int j = paramLightHttpResponse.headerNames.size();
    for (;;)
    {
      if (i >= j)
      {
        paramHttpMessageWriter.writeLine();
        paramHttpMessageWriter.flush();
        return;
      }
      String str1 = (String)paramLightHttpResponse.headerNames.get(i);
      String str2 = (String)paramLightHttpResponse.headerValues.get(i);
      paramHttpMessageWriter.writeLine(str1 + ": " + str2);
      i += 1;
    }
  }
  
  public void serve(SocketLike paramSocketLike)
    throws IOException
  {
    Object localObject = new LeakyBufferedInputStream(paramSocketLike.getInput(), 1024);
    OutputStream localOutputStream = paramSocketLike.getOutput();
    HttpMessageReader localHttpMessageReader = new HttpMessageReader((BufferedInputStream)localObject);
    HttpMessageWriter localHttpMessageWriter = new HttpMessageWriter(new BufferedOutputStream(localOutputStream));
    paramSocketLike = new SocketLike(paramSocketLike, (LeakyBufferedInputStream)localObject);
    localObject = new LightHttpRequest();
    LightHttpResponse localLightHttpResponse = new LightHttpResponse();
    for (;;)
    {
      LightHttpRequest localLightHttpRequest = readRequestMessage((LightHttpRequest)localObject, localHttpMessageReader);
      if (localLightHttpRequest == null) {}
      do
      {
        return;
        localLightHttpResponse.reset();
      } while (!dispatchToHandler(paramSocketLike, localLightHttpRequest, localLightHttpResponse));
      writeFullResponse(localLightHttpResponse, localHttpMessageWriter, localOutputStream);
    }
  }
  
  private static class HttpMessageReader
  {
    private final StringBuilder mBuffer = new StringBuilder();
    private final BufferedInputStream mIn;
    private final NewLineDetector mNewLineDetector = new NewLineDetector(null);
    
    public HttpMessageReader(BufferedInputStream paramBufferedInputStream)
    {
      this.mIn = paramBufferedInputStream;
    }
    
    @Nullable
    public String readLine()
      throws IOException
    {
      for (;;)
      {
        int i = this.mIn.read();
        if (i < 0) {
          return null;
        }
        char c = (char)i;
        this.mNewLineDetector.accept(c);
        switch (this.mNewLineDetector.state())
        {
        case 2: 
        default: 
          break;
        case 1: 
          this.mBuffer.append(c);
        }
      }
      String str = this.mBuffer.toString();
      this.mBuffer.setLength(0);
      return str;
    }
    
    private static class NewLineDetector
    {
      private static final int STATE_ON_CR = 2;
      private static final int STATE_ON_CRLF = 3;
      private static final int STATE_ON_OTHER = 1;
      private int state = 1;
      
      public void accept(char paramChar)
      {
        switch (this.state)
        {
        default: 
          throw new IllegalArgumentException("Unknown state: " + this.state);
        case 1: 
          if (paramChar == '\r') {
            this.state = 2;
          }
          return;
        case 2: 
          if (paramChar == '\n')
          {
            this.state = 3;
            return;
          }
          this.state = 1;
          return;
        }
        if (paramChar == '\r')
        {
          this.state = 2;
          return;
        }
        this.state = 1;
      }
      
      public int state()
      {
        return this.state;
      }
    }
  }
  
  public static class HttpMessageWriter
  {
    private static final byte[] CRLF = "\r\n".getBytes();
    private final BufferedOutputStream mOut;
    
    public HttpMessageWriter(BufferedOutputStream paramBufferedOutputStream)
    {
      this.mOut = paramBufferedOutputStream;
    }
    
    public void flush()
      throws IOException
    {
      this.mOut.flush();
    }
    
    public void writeLine()
      throws IOException
    {
      this.mOut.write(CRLF);
    }
    
    public void writeLine(String paramString)
      throws IOException
    {
      int i = 0;
      int j = paramString.length();
      for (;;)
      {
        if (i >= j)
        {
          this.mOut.write(CRLF);
          return;
        }
        int k = paramString.charAt(i);
        this.mOut.write(k);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */