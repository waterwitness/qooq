package com.weiyun.sdk.job.af;

import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.IllegalFormatException;

public abstract class AddressFetcher
{
  private static final String TAG = "AddressFetcher";
  private TransferAddress mAddress = null;
  private FetchAddressException mException = null;
  
  private void setAddress(TransferAddress paramTransferAddress)
  {
    try
    {
      this.mAddress = paramTransferAddress;
      return;
    }
    finally
    {
      paramTransferAddress = finally;
      throw paramTransferAddress;
    }
  }
  
  private void setException(FetchAddressException paramFetchAddressException)
  {
    try
    {
      this.mException = paramFetchAddressException;
      return;
    }
    finally
    {
      paramFetchAddressException = finally;
      throw paramFetchAddressException;
    }
  }
  
  protected void failedGetAddress(FetchAddressException paramFetchAddressException)
  {
    setException(paramFetchAddressException);
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public TransferAddress getAddress(int paramInt)
    throws AddressFetcher.FetchAddressException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: invokespecial 64	com/weiyun/sdk/job/af/AddressFetcher:setAddress	(Lcom/weiyun/sdk/job/af/AddressFetcher$TransferAddress;)V
    //   5: aload_0
    //   6: aconst_null
    //   7: invokespecial 55	com/weiyun/sdk/job/af/AddressFetcher:setException	(Lcom/weiyun/sdk/job/af/AddressFetcher$FetchAddressException;)V
    //   10: aload_0
    //   11: invokevirtual 68	com/weiyun/sdk/job/af/AddressFetcher:sendRequest	()I
    //   14: istore 5
    //   16: iload 5
    //   18: ifeq +15 -> 33
    //   21: new 9	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException
    //   24: dup
    //   25: iload 5
    //   27: ldc 70
    //   29: invokespecial 73	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException:<init>	(ILjava/lang/String;)V
    //   32: athrow
    //   33: invokestatic 79	java/lang/Thread:interrupted	()Z
    //   36: ifeq +7 -> 43
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_2
    //   42: areturn
    //   43: ldc 35
    //   45: new 81	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   52: ldc 84
    //   54: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   60: invokevirtual 96	java/lang/Thread:getName	()Ljava/lang/String;
    //   63: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 98
    //   68: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_1
    //   72: sipush 1000
    //   75: imul
    //   76: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 110	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 45	com/weiyun/sdk/job/af/AddressFetcher:mAddress	Lcom/weiyun/sdk/job/af/AddressFetcher$TransferAddress;
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 47	com/weiyun/sdk/job/af/AddressFetcher:mException	Lcom/weiyun/sdk/job/af/AddressFetcher$FetchAddressException;
    //   96: astore_3
    //   97: aload_2
    //   98: ifnull +12 -> 110
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: areturn
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: aload_3
    //   111: ifnull +18 -> 129
    //   114: aload_3
    //   115: athrow
    //   116: astore_2
    //   117: new 9	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException
    //   120: dup
    //   121: sipush 55534
    //   124: aload_2
    //   125: invokespecial 113	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException:<init>	(ILjava/lang/Throwable;)V
    //   128: athrow
    //   129: iload_1
    //   130: sipush 1000
    //   133: imul
    //   134: i2l
    //   135: lstore 6
    //   137: aload_0
    //   138: lload 6
    //   140: invokevirtual 117	java/lang/Object:wait	(J)V
    //   143: aload_0
    //   144: getfield 45	com/weiyun/sdk/job/af/AddressFetcher:mAddress	Lcom/weiyun/sdk/job/af/AddressFetcher$TransferAddress;
    //   147: astore_3
    //   148: aload_0
    //   149: getfield 47	com/weiyun/sdk/job/af/AddressFetcher:mException	Lcom/weiyun/sdk/job/af/AddressFetcher$FetchAddressException;
    //   152: astore 4
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_3
    //   157: astore_2
    //   158: aload_3
    //   159: ifnonnull -118 -> 41
    //   162: aload 4
    //   164: ifnull +6 -> 170
    //   167: aload 4
    //   169: athrow
    //   170: aconst_null
    //   171: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	AddressFetcher
    //   0	172	1	paramInt	int
    //   40	64	2	localTransferAddress	TransferAddress
    //   105	4	2	localObject1	Object
    //   116	9	2	localInterruptedException	InterruptedException
    //   157	1	2	localObject2	Object
    //   96	63	3	localObject3	Object
    //   152	16	4	localFetchAddressException	FetchAddressException
    //   14	12	5	i	int
    //   135	4	6	l	long
    // Exception table:
    //   from	to	target	type
    //   87	97	105	finally
    //   101	103	105	finally
    //   106	108	105	finally
    //   114	116	105	finally
    //   117	129	105	finally
    //   137	154	105	finally
    //   154	156	105	finally
    //   87	97	116	java/lang/InterruptedException
    //   114	116	116	java/lang/InterruptedException
    //   137	154	116	java/lang/InterruptedException
  }
  
  protected abstract int sendRequest();
  
  protected void successGetAddress(TransferAddress paramTransferAddress)
  {
    if (paramTransferAddress == null) {
      throw new NullPointerException("address is null");
    }
    setAddress(paramTransferAddress);
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public static class DownloadAddress
    extends AddressFetcher.TransferAddress
  {
    private static final String FORMAT = "/ftn_handler/%s/%s?cn=%s&cv=%s";
    private final String mCookieName;
    private final String mCookieValue;
    
    public DownloadAddress(String paramString1, int paramInt, String paramString2)
    {
      this(paramString1, paramInt, paramString2, null, null);
    }
    
    public DownloadAddress(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5)
    {
      super(paramInt1, getUrlFile(paramString2, paramString3, paramInt2));
      this.mCookieName = paramString4;
      this.mCookieValue = paramString5;
    }
    
    public DownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      super(paramInt, paramString2);
      this.mCookieName = paramString3;
      this.mCookieValue = paramString4;
    }
    
    public DownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this(paramString1, paramInt, paramString2, paramString3, 30001, paramString4, paramString5);
    }
    
    private static String getUrlFile(String paramString1, String paramString2, int paramInt)
    {
      int i = NetworkUtils.getNetWorkType(null);
      return String.format("/ftn_handler/%s/%s?cn=%s&cv=%s", new Object[] { paramString2, Utils.encodeUrlString(paramString1), Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    
    public String getCookieName()
    {
      return this.mCookieName;
    }
    
    public String getCookieValue()
    {
      return this.mCookieValue;
    }
  }
  
  public static class FetchAddressException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    private final int mErrorCode;
    
    public FetchAddressException(int paramInt)
    {
      super();
      this.mErrorCode = paramInt;
    }
    
    public FetchAddressException(int paramInt, String paramString)
    {
      super();
      this.mErrorCode = paramInt;
    }
    
    public FetchAddressException(int paramInt, String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
      this.mErrorCode = paramInt;
    }
    
    public FetchAddressException(int paramInt, Throwable paramThrowable)
    {
      super();
      this.mErrorCode = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.mErrorCode;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("fetch address meet error code ");
      localStringBuilder.append(this.mErrorCode);
      localStringBuilder.append("\n");
      localStringBuilder.append(super.toString());
      return localStringBuilder.toString();
    }
  }
  
  public static class ImageDownloadAddress
    extends AddressFetcher.DownloadAddress
  {
    private static final String PIC_TYPE = "cut";
    private static final String THUMBNAIL_FORMAT = "/ftn_handler/%s/%s?pictype=%s&size=%s&cn=%d&cv=%d";
    private final String mThumbnailFile;
    
    public ImageDownloadAddress(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
    {
      super(paramInt1, paramString2, paramString3, paramInt2, paramString4, paramString5);
      this.mThumbnailFile = getThumbnailFile(paramString3, paramInt2, paramString2, paramString6);
    }
    
    public ImageDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this(paramString1, paramInt, paramString2, paramString3, 30001, paramString4, paramString5, paramString6);
    }
    
    public static String getThumbnailFile(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      int i = NetworkUtils.getNetWorkType(null);
      return String.format("/ftn_handler/%s/%s?pictype=%s&size=%s&cn=%d&cv=%d", new Object[] { paramString1, Utils.encodeUrlString(paramString2), "cut", paramString3, Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    
    public String getThumbnailFile()
    {
      return this.mThumbnailFile;
    }
  }
  
  public static class OfflineFileDownloadAddress
    extends AddressFetcher.DownloadAddress
  {
    private static final int CLIENT_VERSION = 2173;
    private static final String FORMAT = "/ver=%d&rkey=%s";
    
    public OfflineFileDownloadAddress(String paramString1, int paramInt, String paramString2)
    {
      super(paramInt, paramString2);
    }
    
    public OfflineFileDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      super(paramInt, getUrlFile(paramString3));
    }
    
    public static String getUrlFile(String paramString)
    {
      return String.format("/ver=%d&rkey=%s", new Object[] { Integer.valueOf(2173), paramString });
    }
    
    private static String getValidHost(String paramString1, String paramString2)
    {
      if ((paramString1 != null) && (!paramString1.equals(""))) {
        return paramString1;
      }
      return paramString2;
    }
  }
  
  public static class OfflineFileThumbnailDownloadAddress
    extends AddressFetcher.OfflineFileDownloadAddress
  {
    private static final String FORMAT = "/ver=%d&rkey=%s&size=%s";
    
    public OfflineFileThumbnailDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      super(paramInt, getUrlFile(paramString2, paramString4));
    }
    
    private static String getUrlFile(String paramString1, String paramString2)
    {
      return String.format("/ver=%d&rkey=%s&size=%s", new Object[] { Integer.valueOf(2173), paramString1, paramString2 });
    }
  }
  
  public static class ShareFileDownloadAddress
    extends AddressFetcher.DownloadAddress
  {
    public ShareFileDownloadAddress(URL paramURL)
      throws MalformedURLException
    {
      super(paramURL.getPort(), paramURL.getFile());
    }
    
    public ShareFileDownloadAddress(URL paramURL, String paramString1, String paramString2)
      throws MalformedURLException
    {
      super(paramURL.getPort(), paramURL.getFile(), paramString1, paramString2);
    }
  }
  
  public static class SimpleHttpAddress
    extends AddressFetcher.TransferAddress
  {
    public static final String HTTP = "http";
    
    public SimpleHttpAddress(String paramString)
      throws MalformedURLException
    {
      this(Utils.getURL(paramString));
    }
    
    public SimpleHttpAddress(URL paramURL)
    {
      super(paramURL.getPort(), paramURL.getFile());
    }
  }
  
  public static abstract class TransferAddress
  {
    private final String mFile;
    private final String mHost;
    private final int mPort;
    
    public TransferAddress(String paramString1, int paramInt, String paramString2)
    {
      this.mHost = paramString1;
      this.mPort = paramInt;
      this.mFile = paramString2;
    }
    
    public String getFile()
    {
      return this.mFile;
    }
    
    public String getHost()
    {
      return this.mHost;
    }
    
    public int getPort()
    {
      return this.mPort;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://").append(this.mHost).append(":").append(this.mPort).append(this.mFile);
      return localStringBuilder.toString();
    }
    
    public String toUrl()
    {
      return toString();
    }
  }
  
  public static class UploadAddress
    extends AddressFetcher.TransferAddress
  {
    private static final String FORMAT = "/ftn_handler/?cn=%d&cv=%d";
    private final String mUkey;
    
    public UploadAddress(String paramString1, int paramInt, String paramString2)
      throws IllegalFormatException
    {
      this(paramString1, paramInt, paramString2, 30001);
    }
    
    public UploadAddress(String paramString1, int paramInt1, String paramString2, int paramInt2)
      throws IllegalFormatException
    {
      super(paramInt1, getUrlFile(paramInt2));
      this.mUkey = paramString2;
    }
    
    private static String getUrlFile(int paramInt)
    {
      return String.format("/ftn_handler/?cn=%d&cv=%d", new Object[] { Integer.valueOf(NetworkUtils.getNetWorkType(null)), Integer.valueOf(paramInt) });
    }
    
    public String getUKey()
    {
      return this.mUkey;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\af\AddressFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */