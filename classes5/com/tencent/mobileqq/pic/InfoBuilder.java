package com.tencent.mobileqq.pic;

import android.content.Intent;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import java.util.ArrayList;

public abstract interface InfoBuilder
{
  public abstract CompressInfo a(Intent paramIntent);
  
  public abstract PicDownloadInfo a(Intent paramIntent);
  
  public abstract PicFowardInfo a(Intent paramIntent);
  
  public abstract PicFowardInfo a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract PicUploadInfo a(Intent paramIntent);
  
  public abstract ArrayList a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\InfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */