package com.tencent.upload.uinterface.data;

import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.MoodUploadAction;
import com.tencent.upload.uinterface.protocol.ImageUploadTaskType;
import java.util.List;
import java.util.Map;

public class MoodUploadTask
  extends AbstractUploadTask
{
  public byte[] businessData = null;
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public List<PictureInfo> pictureInfoList = null;
  public String sAlbumID = "";
  
  public IUploadTaskType getUploadTaskType()
  {
    return new ImageUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new MoodUploadAction(this);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    b.a(paramIUploadServiceContext, this, "");
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
  
  public static final class PictureInfo
  {
    public String albumid;
    public int hdheight;
    public String hdid;
    public int hdwidth;
    public int isAppExtPic;
    public boolean ishd;
    public Map<String, String> mapWaterMarkParams;
    public String picUrl;
    public int picheight;
    public String pictureid;
    public int pictype;
    public int picwidth;
    public String richval;
    public String sloc;
    public String strWaterMarkID;
    public String strWaterMarkMemo;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\MoodUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */