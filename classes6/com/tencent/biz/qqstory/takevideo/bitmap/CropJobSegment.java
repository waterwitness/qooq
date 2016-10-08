package com.tencent.biz.qqstory.takevideo.bitmap;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class CropJobSegment
  extends JobSegment
{
  public int a;
  public int b;
  
  public CropJobSegment(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      notifyError(new ErrorMessage(-1, "input bitmap null"));
      return;
    }
    paramJobContext = BitmapUtils.a(paramBitmap, this.a, this.b, false);
    if (paramJobContext == null)
    {
      notifyError(new ErrorMessage(-1, "resize and crop failed"));
      return;
    }
    notifyResult(paramJobContext);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\bitmap\CropJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */