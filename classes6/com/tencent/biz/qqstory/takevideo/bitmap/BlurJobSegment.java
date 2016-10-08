package com.tencent.biz.qqstory.takevideo.bitmap;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StackBlur;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class BlurJobSegment
  extends JobSegment
{
  public static final String a = "BlurJobSegment";
  public int a;
  
  public BlurJobSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 10;
  }
  
  public BlurJobSegment(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    StackBlur.a(paramBitmap, paramInt);
    return paramBitmap;
  }
  
  private void a(String paramString1, String paramString2)
  {
    SLog.b(paramString1, paramString2);
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    paramJobContext = a(paramBitmap, this.a, false);
    a("BlurJobSegment", "blur time = " + (System.currentTimeMillis() - l) + ", blur ratio = " + this.a);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("BlurJobSegment", 7));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\bitmap\BlurJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */