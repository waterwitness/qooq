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
import com.tencent.upload.uinterface.action.ImageUploadAction;
import com.tencent.upload.uinterface.protocol.HeadUploadTaskType;
import com.tencent.upload.uinterface.protocol.ImageUploadTaskType;
import java.util.HashMap;

public class ImageUploadTask
  extends AbstractUploadTask
{
  public boolean autoRotate = false;
  public boolean bWaterType = false;
  public String clientFakeKey;
  public String exifTime = "";
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public int iBitmap = 0;
  public int iBusiNessType = 0;
  public int iDistinctUse = 0;
  public int iUpPicType = 0;
  public int iUploadType = 0;
  public final boolean isHead;
  public HashMap<String, String> mapExt = null;
  public MultiPicInfo mutliPicInfo = null;
  public final String originalPath;
  public String sAlbumID = "";
  public String sAlbumName = "";
  public String sPicDesc = "";
  public String sPicTitle = "";
  public PicExtendInfo stExtendInfo = null;
  public HashMap<String, String> stExternalMapExt = null;
  public stPoi uploadPoi = null;
  public byte[] vBusiNessData = null;
  public String waterTemplateId;
  public String watermarkPoiName;
  
  public ImageUploadTask(boolean paramBoolean, String paramString)
  {
    this.isHead = paramBoolean;
    this.originalPath = paramString;
    this.uploadFilePath = paramString;
  }
  
  public final String getOriginalUploadFilePath()
  {
    return this.originalPath;
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    if (this.isHead) {
      return new HeadUploadTaskType();
    }
    return new ImageUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    if (this.preupload == 1) {
      paramBoolean = false;
    }
    return new ImageUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    com.tencent.upload.a.b.b("ServiceImpl", " onProcessUploadTask, iUploadType:" + this.iUploadType + " flowId:" + this.flowId);
    if (this.iUploadType == 3)
    {
      com.tencent.upload.a.b.a(paramIUploadServiceContext, this, "", 3145728);
      return;
    }
    boolean bool2 = false;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool1 = bool2;
    if (this.preupload == 2)
    {
      Context localContext = f.a();
      String str = com.tencent.upload.common.b.a(localContext, this.uploadFilePath, this.md5);
      localObject1 = localObject2;
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = com.tencent.upload.common.b.a(localContext, this.uploadFilePath, this.md5, this.flowId);
        bool1 = com.tencent.upload.common.b.a(str, (String)localObject1);
      }
    }
    if (bool1)
    {
      com.tencent.upload.a.b.a(paramIUploadServiceContext, this, (String)localObject1, "uploadByTempFile");
      return;
    }
    com.tencent.upload.a.b.a(paramIUploadServiceContext, this, this.iUploadType, this.autoRotate);
  }
  
  public boolean onVerifyUploadFile()
  {
    return com.tencent.upload.a.b.a(this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\ImageUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */