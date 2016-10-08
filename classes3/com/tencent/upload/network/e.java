package com.tencent.upload.network;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.uinterface.IUploadAction;
import java.util.LinkedList;

final class e
  implements Runnable
{
  e(d paramd) {}
  
  public final void run()
  {
    if (UploadConfiguration.isNetworkAvailable()) {}
    while (c.c(this.a.a).size() == 0) {
      return;
    }
    ((IUploadAction)c.c(this.a.a).get(0)).onError(null, 35000, "no network notify", true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */