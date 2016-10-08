package com.tencent.upload.uinterface.protocol;

import com.tencent.upload.uinterface.IUploadTaskType;

public class PhotoWallUploadTaskType
  implements IUploadTaskType
{
  public int getProtocolFileType()
  {
    return 0;
  }
  
  public int getProtocolUploadType()
  {
    return 17;
  }
  
  public int getServerCategory()
  {
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\protocol\PhotoWallUploadTaskType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */