package com.tencent.biz.qqstory.takevideo.bitmap;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class BitmapAdjustJobSegment
  extends JobSegment
{
  public static final float a = 0.5F;
  public static final String a = "Q.qqstory.publish:ImageAdjustJobSegment";
  public final boolean a;
  public final float b;
  
  public BitmapAdjustJobSegment()
  {
    this.b = 0.5F;
    this.a = false;
  }
  
  public BitmapAdjustJobSegment(float paramFloat, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramFloat;
    this.a = paramBoolean;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    paramJobContext = BitmapUtils.a(paramBitmap, this.b, this.a);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("Q.qqstory.publish:ImageAdjustJobSegment", 5));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\bitmap\BitmapAdjustJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */