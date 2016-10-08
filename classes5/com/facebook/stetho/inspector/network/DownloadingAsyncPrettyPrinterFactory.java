package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

public abstract class DownloadingAsyncPrettyPrinterFactory
  implements AsyncPrettyPrinterFactory
{
  private static void doErrorPrint(PrintWriter paramPrintWriter, InputStream paramInputStream, String paramString)
    throws IOException
  {
    paramPrintWriter.print(paramString + "\n" + Util.readAsUTF8(paramInputStream));
  }
  
  private static AsyncPrettyPrinter getErrorAsyncPrettyPrinter(String paramString1, final String paramString2)
  {
    new AsyncPrettyPrinter()
    {
      public PrettyPrinterDisplayType getPrettifiedType()
      {
        return PrettyPrinterDisplayType.TEXT;
      }
      
      public void printTo(PrintWriter paramAnonymousPrintWriter, InputStream paramAnonymousInputStream)
        throws IOException
      {
        DownloadingAsyncPrettyPrinterFactory.doErrorPrint(paramAnonymousPrintWriter, paramAnonymousInputStream, "[Failed to parse header: " + DownloadingAsyncPrettyPrinterFactory.this + " : " + paramString2 + " ]");
      }
    };
  }
  
  @Nullable
  private static URL parseURL(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  protected abstract void doPrint(PrintWriter paramPrintWriter, InputStream paramInputStream, String paramString)
    throws IOException;
  
  public AsyncPrettyPrinter getInstance(String paramString1, String paramString2)
  {
    final MatchResult localMatchResult = matchAndParseHeader(paramString1, paramString2);
    if (localMatchResult == null) {}
    URL localURL;
    do
    {
      return null;
      localURL = parseURL(localMatchResult.getSchemaUri());
      if (localURL == null) {
        return getErrorAsyncPrettyPrinter(paramString1, paramString2);
      }
      paramString1 = AsyncPrettyPrinterExecutorHolder.getExecutorService();
    } while (paramString1 == null);
    new AsyncPrettyPrinter()
    {
      public PrettyPrinterDisplayType getPrettifiedType()
      {
        return localMatchResult.getDisplayType();
      }
      
      public void printTo(PrintWriter paramAnonymousPrintWriter, InputStream paramAnonymousInputStream)
        throws IOException
      {
        try
        {
          String str = (String)this.val$response.get();
          throw localInterruptedException;
        }
        catch (ExecutionException localExecutionException)
        {
          try
          {
            DownloadingAsyncPrettyPrinterFactory.this.doPrint(paramAnonymousPrintWriter, paramAnonymousInputStream, str);
            return;
          }
          catch (ExecutionException paramAnonymousPrintWriter)
          {
            throw ExceptionUtil.propagate(paramAnonymousPrintWriter.getCause());
          }
          localExecutionException = localExecutionException;
          if (IOException.class.isInstance(localExecutionException.getCause()))
          {
            DownloadingAsyncPrettyPrinterFactory.doErrorPrint(paramAnonymousPrintWriter, paramAnonymousInputStream, "Cannot successfully download schema: " + localExecutionException.getMessage());
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          DownloadingAsyncPrettyPrinterFactory.doErrorPrint(paramAnonymousPrintWriter, paramAnonymousInputStream, "Encountered spurious interrupt while downloading schema for pretty printing: " + localInterruptedException.getMessage());
          return;
        }
      }
    };
  }
  
  @Nullable
  protected abstract MatchResult matchAndParseHeader(String paramString1, String paramString2);
  
  protected class MatchResult
  {
    private final PrettyPrinterDisplayType mDisplayType;
    private final String mSchemaUri;
    
    public MatchResult(String paramString, PrettyPrinterDisplayType paramPrettyPrinterDisplayType)
    {
      this.mSchemaUri = paramString;
      this.mDisplayType = paramPrettyPrinterDisplayType;
    }
    
    public PrettyPrinterDisplayType getDisplayType()
    {
      return this.mDisplayType;
    }
    
    public String getSchemaUri()
    {
      return this.mSchemaUri;
    }
  }
  
  private static class Request
    implements Callable<String>
  {
    private URL url;
    
    public Request(URL paramURL)
    {
      this.url = paramURL;
    }
    
    public String call()
      throws IOException
    {
      Object localObject1 = (HttpURLConnection)this.url.openConnection();
      int i = ((HttpURLConnection)localObject1).getResponseCode();
      if (i != 200) {
        throw new IOException("Got status code: " + i + " while downloading " + "schema with url: " + this.url.toString());
      }
      localObject1 = ((HttpURLConnection)localObject1).getInputStream();
      try
      {
        String str = Util.readAsUTF8((InputStream)localObject1);
        return str;
      }
      finally
      {
        ((InputStream)localObject1).close();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\DownloadingAsyncPrettyPrinterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */