package com.tencent.upload.uinterface.protocol;

import com.tencent.upload.uinterface.IUploadTaskType;

public final class AudioUploadTaskType
  implements IUploadTaskType
{
  public final int getProtocolFileType()
  {
    return 2;
  }
  
  public final int getProtocolUploadType()
  {
    return 2;
  }
  
  public final int getServerCategory()
  {
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\protocol\AudioUploadTaskType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */