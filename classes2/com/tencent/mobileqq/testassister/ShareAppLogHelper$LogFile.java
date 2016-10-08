package com.tencent.mobileqq.testassister;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class ShareAppLogHelper$LogFile
  extends File
{
  public String stuffix;
  
  public ShareAppLogHelper$LogFile(File paramFile, String paramString)
  {
    super(paramFile, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.stuffix = "";
  }
  
  public ShareAppLogHelper$LogFile(String paramString)
  {
    super(paramString);
    this.stuffix = "";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\testassister\ShareAppLogHelper$LogFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */