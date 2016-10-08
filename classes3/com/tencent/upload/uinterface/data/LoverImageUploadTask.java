package com.tencent.upload.uinterface.data;

import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.LoverImageUploadAction;
import com.tencent.upload.uinterface.protocol.LoverImageUploadTaskType;

public class LoverImageUploadTask
  extends AbstractUploadTask
{
  public int iUploadType = 0;
  public String mAddress = "";
  public String mAlbumID = "";
  public String mAppVersion = "";
  public long mBatchID = 0L;
  public String mClientip = "";
  public int mCurPicNum = 0;
  public String mDeviceID = "";
  public int mFromQZone = 0;
  public int mIsShareFeeds = 0;
  public String mLocalid = "";
  public String mOs = "";
  public String mOsVersion = "";
  public String mPicDesc = "";
  public int mPicHight = 0;
  public String mPicTitle = "";
  public String mPicUrl = "";
  public int mPicWidth = 0;
  public int mPictotalNum = 0;
  public int mPictureType = 0;
  public String mUserAgent = "";
  
  public IUploadTaskType getUploadTaskType()
  {
    return new LoverImageUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new LoverImageUploadAction(this, paramBoolean);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\LoverImageUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */