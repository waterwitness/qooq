package com.tencent.biz.qqstory.takevideo.bitmap;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class SaveBitmapJobSegment
  extends JobSegment
{
  public String a;
  
  public SaveBitmapJobSegment(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
    if (paramString == null) {
      throw new IllegalArgumentException("filePath should not be null");
    }
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      notifyError(new ErrorMessage(-1, "bitmap is null"));
      return;
    }
    if (BitmapUtils.a(paramBitmap, this.a))
    {
      notifyResult(paramBitmap);
      return;
    }
    notifyError(new ErrorMessage(-1, "compress failed"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\bitmap\SaveBitmapJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */