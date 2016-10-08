package com.tencent.mobileqq.vas;

import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class LooperGifImage
  extends NativeGifImage
{
  private int a;
  
  public LooperGifImage(File paramFile, boolean paramBoolean, float paramFloat, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 1;
    this.a = paramInt;
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentLoop == this.a) {
      return;
    }
    super.executeNewTask();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\LooperGifImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */