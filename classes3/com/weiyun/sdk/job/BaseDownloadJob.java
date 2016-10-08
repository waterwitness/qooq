package com.weiyun.sdk.job;

import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.transfer.DownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class BaseDownloadJob
  extends BaseJob
{
  private static final int MAX_FETCH_URL_TIMES = 3;
  protected static final int[] RETRY_ERROR_CODES = { 190041, 190042, 190043, 190045, 190071 };
  private static final String TAG = "BaseDownloadJob";
  protected AddressFetcher.DownloadAddress mDownloadAddress;
  protected final DownloadJobContext mJobContext;
  
  public BaseDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext)
  {
    super(paramLong, paramDownloadJobContext);
    this.mJobContext = paramDownloadJobContext;
  }
  
  private String getSubFileName(String paramString)
  {
    Object localObject = paramString.getBytes();
    paramString = paramString.substring(paramString.lastIndexOf("."));
    localObject = new String((byte[])localObject, 0, 200 - paramString.getBytes().length);
    return ((String)localObject).substring(0, ((String)localObject).length() - 1) + paramString;
  }
  
  protected boolean canRetry(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = RETRY_ERROR_CODES;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected boolean checkCondition()
  {
    if (!checkContent()) {}
    while ((!checkEnvironment()) || (!checkFile())) {
      return false;
    }
    return true;
  }
  
  protected boolean checkContent()
  {
    if ((this.mJobContext == null) || (this.mJobContext.getFileId() == null) || (this.mJobContext.getParentDirKey() == null) || (this.mJobContext.getFileName() == null) || (this.mJobContext.getDestDirectoryPath() == null) || (this.mJobContext.getDestFileName() == null) || (this.mJobContext.getDestFilePath() == null) || (this.mJobContext.getDataFilePath() == null))
    {
      setLastErrorNo(55535);
      return false;
    }
    return true;
  }
  
  public boolean checkEnvironment()
  {
    return true;
  }
  
  public boolean checkFile()
  {
    if (!Utils.checkDirAndCreate(this.mJobContext.getDestDirectoryPath()))
    {
      setLastErrorNo(55529);
      return false;
    }
    if (!Utils.checkDirAndCreate(this.mJobContext.getDataDirectoryPath()))
    {
      setLastErrorNo(55529);
      return false;
    }
    String str = this.mJobContext.getDestFileName();
    if (str.getBytes().length >= 200) {
      renameDestFile(getSubFileName(str));
    }
    while (Utils.checkFileExist(this.mJobContext.getDestFilePath()) == true) {
      renameDestFile(Utils.generateNewFilename(this.mJobContext.getDestFileName()));
    }
    this.mJobContext.setCurSize(Math.max(0L, Utils.getFileSize(this.mJobContext.getDataFilePath())));
    return true;
  }
  
  protected boolean createDestFile(String paramString)
  {
    try
    {
      new FileOutputStream(new File(paramString)).close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      Log.w("BaseDownloadJob", paramString);
      return false;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.w("BaseDownloadJob", paramString);
      }
    }
  }
  
  protected abstract AddressFetcher createDownloadAddressFetcher();
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new DownloadTransfer((AddressFetcher.DownloadAddress)paramTransferAddress, this.mJobContext, this);
  }
  
  protected boolean doTransfer()
  {
    return doTransferImpl();
  }
  
  protected boolean doTransferImpl()
  {
    AddressFetcher.TransferAddress localTransferAddress = getDownloadAddress();
    if (localTransferAddress == null) {
      setLastErrorNo(55524);
    }
    while (!checkEnvironment()) {
      return false;
    }
    long l1 = this.mJobContext.getCurSize();
    long l2 = System.currentTimeMillis();
    int i = createTransfer(localTransferAddress).transfer();
    setLastErrorNo(i);
    if (i != 55534) {
      reportDownloadStatistics(i, l2, l1);
    }
    if (i == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected int fetchDownloadUrl()
  {
    try
    {
      AddressFetcher localAddressFetcher = createDownloadAddressFetcher();
      AddressFetcher.TransferAddress localTransferAddress = localAddressFetcher.getAddress(45);
      if (localTransferAddress == null)
      {
        Log.w("BaseDownloadJob", "get address failed!");
        return 55525;
      }
      handleFetchUrlSuccess(localAddressFetcher, localTransferAddress);
      return 0;
    }
    catch (AddressFetcher.FetchAddressException localFetchAddressException)
    {
      Log.w("BaseDownloadJob", "fetch download address failed: error code:" + localFetchAddressException.getErrorCode() + ", error message:" + localFetchAddressException.getMessage());
      setLastErrorString(localFetchAddressException.getMessage());
      return handleFetchUrlFailed(localFetchAddressException.getErrorCode());
    }
  }
  
  protected boolean fetchUrl()
  {
    return fetchUrlImpl();
  }
  
  protected boolean fetchUrlImpl()
  {
    int j = 0;
    long l = System.currentTimeMillis();
    int i = 0;
    if (i < 3)
    {
      if (!isAlive()) {}
      label20:
      while (!checkEnvironment()) {
        return false;
      }
      Log.i("BaseDownloadJob", "start fetch download address. file=" + this.mJobContext.getFileName());
      j = fetchDownloadUrl();
      if (j != 0) {
        break label93;
      }
    }
    for (;;)
    {
      setLastErrorNo(j);
      if (j != 55534) {
        reportPreDownloadStatistics(j, l);
      }
      if (j != 0) {
        break label20;
      }
      return true;
      label93:
      if (j == 5901) {
        i -= 1;
      }
      do
      {
        i += 1;
        break;
        setLastErrorNo(j);
      } while (canRetry(j));
    }
  }
  
  public AddressFetcher.TransferAddress getDownloadAddress()
  {
    return this.mDownloadAddress;
  }
  
  public DownloadJobContext getDownloadJobContext()
  {
    return this.mJobContext;
  }
  
  protected int handleFetchUrlFailed(int paramInt)
  {
    return paramInt;
  }
  
  protected void handleFetchUrlSuccess(AddressFetcher paramAddressFetcher, AddressFetcher.TransferAddress paramTransferAddress)
  {
    setDownloadAddress((AddressFetcher.DownloadAddress)paramTransferAddress);
  }
  
  protected void handleFileNameChanged(String paramString) {}
  
  public void renameDestFile(String paramString)
  {
    this.mJobContext.setDestFileName(paramString);
    handleFileNameChanged(paramString);
  }
  
  public void reportDownloadStatistics(int paramInt, long paramLong1, long paramLong2) {}
  
  public void reportDownloadTransferSize(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public void reportPreDownloadStatistics(int paramInt, long paramLong) {}
  
  protected void setDownloadAddress(AddressFetcher.DownloadAddress paramDownloadAddress)
  {
    this.mDownloadAddress = paramDownloadAddress;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\BaseDownloadJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */