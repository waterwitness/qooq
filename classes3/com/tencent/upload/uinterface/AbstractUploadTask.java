package com.tencent.upload.uinterface;

import java.util.Map;

public abstract class AbstractUploadTask
{
  public byte[] b2Gt = null;
  public Object extra;
  public int flowId;
  public boolean hasRetried = true;
  public int iLoginType = 0;
  public int iSync = 0;
  public long iUin = 0L;
  public long iUploadTime = 0L;
  public String md5 = null;
  public int preupload = 0;
  public volatile IProgressDelegate progressListener = null;
  public String reportRefer = "mqzone";
  public String sDescMD5;
  public String sFileMD5;
  public String sRefer = "mqzone";
  public Map<String, String> transferData = null;
  public String uiRefer;
  public int uploadEntrance = 14;
  public String uploadFilePath = null;
  public IUploadTaskCallback uploadTaskCallback = null;
  public byte[] vLoginData = null;
  public byte[] vLoginKey = null;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (AbstractUploadTask)paramObject;
    } while (this.flowId == ((AbstractUploadTask)paramObject).flowId);
    return false;
  }
  
  public abstract IUploadTaskType getUploadTaskType();
  
  public abstract IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception;
  
  public abstract void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext);
  
  public abstract boolean onVerifyUploadFile();
  
  public static abstract interface IProgressDelegate
  {
    public abstract void onProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2);
  }
  
  public static final class PreUploadFlag
  {
    public static final int HIT_PRE_UPLOAD = 2;
    public static final int NORMAL_UPLOAD = 0;
    public static final int PRE_UPLOAD = 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\AbstractUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */