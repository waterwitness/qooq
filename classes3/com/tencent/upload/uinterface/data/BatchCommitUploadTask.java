package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.stPoi;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.upload.common.f;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.BatchCommitUploadAction;
import com.tencent.upload.uinterface.protocol.BatchCommitUploadType;
import java.util.Iterator;
import java.util.List;

public class BatchCommitUploadTask
  extends AbstractUploadTask
{
  public List<ImageUploadTask> commitImageTasks = null;
  
  public IUploadTaskType getUploadTaskType()
  {
    return new BatchCommitUploadType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new BatchCommitUploadAction(this);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    if (this.commitImageTasks == null) {
      return;
    }
    Iterator localIterator = this.commitImageTasks.iterator();
    while (localIterator.hasNext())
    {
      ImageUploadTask localImageUploadTask = (ImageUploadTask)localIterator.next();
      Object localObject = f.a();
      String str = com.tencent.upload.common.b.a((Context)localObject, localImageUploadTask.uploadFilePath, localImageUploadTask.md5);
      if (!TextUtils.isEmpty(str))
      {
        localObject = com.tencent.upload.common.b.a((Context)localObject, localImageUploadTask.uploadFilePath, localImageUploadTask.md5, localImageUploadTask.flowId);
        if (com.tencent.upload.common.b.a(str, (String)localObject)) {
          localImageUploadTask.uploadFilePath = ((String)localObject);
        }
      }
    }
    com.tencent.upload.a.b.a(paramIUploadServiceContext, this, "");
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
  
  public static final class ImageCommitUploadData
  {
    public int flowId;
    public int iAlbumTypeID = 0;
    public long iBatchID = 0L;
    public int iBitmap = 0;
    public int iBusiNessType = 0;
    public int iDistinctUse = 0;
    public int iUpPicType = 0;
    public long iUploadTime = 0L;
    public int iUploadType = 0;
    public MultiPicInfo mutliPicInfo = null;
    public String sAlbumID = "";
    public String sAlbumName = "";
    public String sPicDesc = "";
    public String sPicTitle = "";
    public PicExtendInfo stExtendInfo = null;
    public String uploadFilePath;
    public stPoi uploadPoi = null;
    public byte[] vBusiNessData = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\BatchCommitUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */