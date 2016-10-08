package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.protocol.NewQunUploadTaskType;

public class NewQunUploadTask
  extends ImageUploadTask
{
  public byte[] a2_key = null;
  public String appid = "";
  public String userid = "";
  
  public NewQunUploadTask(String paramString)
  {
    super(false, paramString);
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    return new NewQunUploadTaskType();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\NewQunUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */