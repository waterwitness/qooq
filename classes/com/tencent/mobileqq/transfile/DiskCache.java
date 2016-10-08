package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class DiskCache
{
  File a;
  
  public DiskCache(File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramFile;
  }
  
  DiskCache.Editor a(String paramString)
  {
    return new DiskCache.Editor(this, paramString);
  }
  
  File a(String paramString)
  {
    if (!this.a.exists()) {
      this.a.mkdirs();
    }
    return new File(this.a, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\DiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */