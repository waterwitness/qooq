package com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class MergeThumbSegment
  extends JobSegment
{
  private static final String a = "MergeThumbSegment";
  
  public MergeThumbSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    Bitmap localBitmap = null;
    GenerateDoodleArgs localGenerateDoodleArgs = paramGenerateContext.a();
    paramJobContext = paramGenerateContext.a();
    if ((paramJobContext == null) || (paramJobContext.a == null))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject = paramJobContext.a;
    paramJobContext = localBitmap;
    if (localGenerateDoodleArgs != null)
    {
      paramJobContext = localBitmap;
      if (paramGenerateContext.a()) {
        paramJobContext = localGenerateDoodleArgs.a;
      }
    }
    if (paramJobContext != null) {}
    for (;;)
    {
      try
      {
        paramJobContext = BitmapFactory.decodeFile(paramJobContext);
        localObject = BitmapFactory.decodeFile((String)localObject);
        localBitmap = BitmapUtils.a((Bitmap)localObject, paramJobContext);
        paramJobContext.recycle();
        ((Bitmap)localObject).recycle();
        paramJobContext = QQStoryConstant.q + "story_thumb_merged_" + System.currentTimeMillis() + ".jpg";
        FileUtils.a(QQStoryConstant.q);
        boolean bool = BitmapUtils.a(localBitmap, paramJobContext);
        localBitmap.recycle();
        if (!bool) {
          continue;
        }
        paramGenerateContext.d(paramJobContext);
        SLog.b("MergeThumbSegment", "merge doodle and thumb image success : " + paramJobContext);
      }
      catch (OutOfMemoryError paramJobContext)
      {
        SLog.e("MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
        continue;
      }
      super.notifyResult(paramGenerateContext);
      return;
      SLog.d("MergeThumbSegment", "merge doodle and thumb image failed");
      continue;
      SLog.b("MergeThumbSegment", "use thumb image as merged image : " + (String)localObject);
      paramGenerateContext.d((String)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\MergeThumbSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */