package com.tencent.upload.uinterface.protocol;

import com.tencent.upload.uinterface.IUploadTaskType;

public class LoverImageUploadTaskType
  implements IUploadTaskType
{
  public int getProtocolFileType()
  {
    return 0;
  }
  
  public int getProtocolUploadType()
  {
    return 6;
  }
  
  public int getServerCategory()
  {
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\protocol\LoverImageUploadTaskType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */