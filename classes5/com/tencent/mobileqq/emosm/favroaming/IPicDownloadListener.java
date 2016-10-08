package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.List;

public class IPicDownloadListener
  implements Serializable
{
  public IPicDownloadListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(List paramList1, List paramList2) {}
  
  public void onFileDone(CustomEmotionData paramCustomEmotionData, boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\favroaming\IPicDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */