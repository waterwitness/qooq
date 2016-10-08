package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UniformDownloaderAppBabySdk$RParam
{
  public long a;
  public long b;
  
  public UniformDownloaderAppBabySdk$RParam(long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public static RParam a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return new RParam(paramBundle.getLong("RPARAM_RECV_SIZE"), paramBundle.getLong("RPARAM_TRANS_SIZE"));
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("RPARAM_RECV_SIZE", this.a);
    localBundle.putLong("RPARAM_TRANS_SIZE", this.b);
    return localBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\UniformDownloaderAppBabySdk$RParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */