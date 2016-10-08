package com.tencent.upload.uinterface.data;

import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.UpsImageUploadAction;
import com.tencent.upload.uinterface.protocol.UpsUploadTaskType;
import java.util.Map;

public class UpsImageUploadTask
  extends AbstractUploadTask
{
  public static final String BUSINESS_CHAT_IMAGE = "gappchat";
  public static final String BUSINESS_COVER = "mqzonecover";
  public static final String BUSINESS_FACADE = "mqfacade";
  public static final String BUSINESS_FAVOR_PHOTO = "favpic";
  public static final String BUSINESS_MESSAGE = "msgboardpic";
  public static final String BUSINESS_SECRET_MOOD = "secretpic";
  public static final String BUSINESS_SHAREALBUM = "qqshare_photo";
  public static final String BUSINESS_SMART_VIDEO_COVER = "micro_video";
  public static final String BUSINESS_TOPIC_GROUP_PHOTO = "topicgroup_pic";
  public static final int TYPE_COVER = 2;
  public static final int TYPE_FACADE = 5;
  public static final int TYPE_FAVOR_PHOTO = 3;
  public static final int TYPE_MESSAGE = 0;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_SECRET_MOOD = 4;
  public static final int TYPE_SHAREALBUM_PHOTO = 1;
  public final int appid;
  public int dataType;
  public String fileId;
  public long iBatchID;
  public int iBatchUploadCount;
  public int iBusiNessType;
  public int iCurrentUploadOrder;
  public int iUploadType = 0;
  public int keepRaw;
  public Map<String, byte[]> mapExt;
  public String sBusinessId = "";
  public String sCommand;
  public byte[] vBusiNessData;
  
  public UpsImageUploadTask(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 65538;; i = 1000027)
    {
      this.appid = i;
      return;
    }
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    return new UpsUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new UpsImageUploadAction(this, paramBoolean);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\UpsImageUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */