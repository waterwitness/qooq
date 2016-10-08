package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.QunUppUploadAction;
import com.tencent.upload.uinterface.protocol.QunUploadTaskType;

public class QunUppUploadTask
  extends AbstractUploadTask
{
  public static final String QunUppAppId = "";
  public String A2;
  public String albumId = "";
  public String appId = "";
  public boolean autoRotate = false;
  public long batchId = 0L;
  public String clientFakeKey;
  public String desc = "";
  public String deviceInfo = "";
  public int iUploadType = 0;
  public MultiPicInfo mutipic;
  public long photoHeight = 0L;
  public long photoSize = 0L;
  public long photoType = 0L;
  public long photoWidth = 0L;
  public String picPath = "";
  public String poiName = "";
  public int poiType = 0;
  public String poiX = "";
  public String poiY = "";
  public String title = "";
  public int type = 0;
  public long uploadIp = 0L;
  public String userId = "";
  
  public IUploadTaskType getUploadTaskType()
  {
    return new QunUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new QunUppUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    b.a(paramIUploadServiceContext, this, this.iUploadType, true);
  }
  
  public boolean onVerifyUploadFile()
  {
    return b.a(this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\QunUppUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */