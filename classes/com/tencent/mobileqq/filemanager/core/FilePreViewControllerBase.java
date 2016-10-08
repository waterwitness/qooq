package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class FilePreViewControllerBase
{
  public FilePreviewActivity.ControlerCallback a;
  
  public FilePreViewControllerBase()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract int a();
  
  public void a(FilePreviewActivity.ControlerCallback paramControlerCallback)
  {
    this.a = paramControlerCallback;
  }
  
  public abstract boolean a();
  
  public abstract void b();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\FilePreViewControllerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */