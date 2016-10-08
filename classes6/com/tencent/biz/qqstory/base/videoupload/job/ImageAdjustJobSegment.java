package com.tencent.biz.qqstory.base.videoupload.job;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class ImageAdjustJobSegment
  extends JobSegment
{
  public static final int a = 1080;
  public static final String a = "Q.qqstory.publish:ImageAdjustJobSegment";
  public final int b;
  
  public ImageAdjustJobSegment()
  {
    this.b = 1080;
  }
  
  public ImageAdjustJobSegment(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = Math.min(1080, paramInt);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    if (super.isCanceled()) {
      return;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    SLog.b("Q.qqstory.publish:ImageAdjustJobSegment", "bitmap file outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ", outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ", orientation = " + 0);
    int i = BitmapUtils.a(((BitmapFactory.Options)localObject).outWidth, 0, 1080);
    SLog.b("Q.qqstory.publish:ImageAdjustJobSegment", "sample size : " + i);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    paramJobContext = null;
    try
    {
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      paramJobContext = (JobContext)localObject;
      SLog.b("Q.qqstory.publish:ImageAdjustJobSegment", "bitmap : " + localObject);
      paramJobContext = (JobContext)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        SLog.d("Q.qqstory.publish:ImageAdjustJobSegment", "decode file oom");
      }
      SLog.b("Q.qqstory.publish:ImageAdjustJobSegment", "bitmap width after decode : " + paramJobContext.getWidth());
      JobContext localJobContext = paramJobContext;
      if (paramJobContext.getWidth() <= this.b) {
        break label318;
      }
      i = paramJobContext.getWidth();
      float f = (float)(this.b * 1.0D / i);
      SLog.b("Q.qqstory.publish:ImageAdjustJobSegment", "scale factor : " + f);
      paramJobContext = BitmapUtils.a(paramJobContext, f, true);
      localJobContext = paramJobContext;
      if (paramJobContext != null) {
        break label318;
      }
      super.notifyError(new BitmapError("Q.qqstory.publish:ImageAdjustJobSegment", 5));
      return;
      SLog.c("Q.qqstory.publish:ImageAdjustJobSegment", "Adjust bitmap result, width = " + localJobContext.getWidth() + ", height = " + localJobContext.getHeight());
      super.notifyResult(new ImageUploadJobSegment.UploadParam(paramString, localJobContext));
    }
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("Q.qqstory.publish:ImageAdjustJobSegment", 6));
      return;
    }
    label318:
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\job\ImageAdjustJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */