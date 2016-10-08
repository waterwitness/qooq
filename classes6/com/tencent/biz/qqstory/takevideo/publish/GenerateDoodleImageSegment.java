package com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.lang.ref.WeakReference;

public class GenerateDoodleImageSegment
  extends JobSegment
{
  private static final String a = "GenerateDoodleImageSegment";
  
  public GenerateDoodleImageSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Bitmap a(GenerateContext paramGenerateContext, Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      paramGenerateContext = paramGenerateContext.a();
      SLog.a("GenerateDoodleImageSegment", "filter view = %s", paramGenerateContext);
      if (paramGenerateContext == null)
      {
        SLog.e("GenerateDoodleImageSegment", "filter view has been recycled.");
        return null;
      }
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramGenerateContext.getWidth();
      float f4 = paramGenerateContext.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramGenerateContext.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramGenerateContext)
    {
      SLog.c("GenerateDoodleImageSegment", "create filterBitmap error : %s", paramGenerateContext);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    long l1 = SystemClock.uptimeMillis();
    GenerateThumbResult localGenerateThumbResult = paramGenerateContext.a();
    if ((localGenerateThumbResult == null) || (localGenerateThumbResult.jdField_a_of_type_JavaLangString == null))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    GenerateDoodleArgs localGenerateDoodleArgs = paramGenerateContext.a();
    DoodleLayout localDoodleLayout;
    Bitmap localBitmap;
    if (localGenerateDoodleArgs != null)
    {
      localDoodleLayout = (DoodleLayout)localGenerateDoodleArgs.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localDoodleLayout != null) && ((!localDoodleLayout.b()) || (paramGenerateContext.a() != null)))
      {
        paramJobContext = localDoodleLayout.a();
        if (paramJobContext != null)
        {
          localBitmap = a(paramGenerateContext, paramJobContext);
          if (localBitmap != null)
          {
            SLog.a("GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
            paramJobContext = localBitmap;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localBitmap = BitmapFactory.decodeFile(localGenerateThumbResult.jdField_a_of_type_JavaLangString);
        if (localBitmap == null) {
          break label667;
        }
        if (paramJobContext.getWidth() * 1.0F / localBitmap.getWidth() < paramJobContext.getHeight() * 1.0F / localBitmap.getHeight())
        {
          j = paramJobContext.getWidth();
          i = (int)(localBitmap.getHeight() * j * 1.0F / localBitmap.getWidth());
          SLog.a("GenerateDoodleImageSegment", "resize and crop doodle image, clipWidth=%d, clipHeight=%d", Integer.valueOf(j), Integer.valueOf(i));
          paramJobContext = BitmapUtils.a(paramJobContext, j, i, false);
          if (paramJobContext == null) {
            break label661;
          }
          bool1 = BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, localGenerateDoodleArgs.jdField_a_of_type_JavaLangString);
          if ((paramJobContext == null) || (!bool1)) {
            continue;
          }
          SLog.b("GenerateDoodleImageSegment", "resize and crop original doodle image success");
          paramGenerateContext.a(true);
          BitmapUtils.a(localBitmap);
          BitmapUtils.a(paramJobContext);
          if (!paramGenerateContext.a()) {
            break label539;
          }
          notifyResult(paramGenerateContext);
          l2 = SystemClock.uptimeMillis();
          StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          return;
          SLog.d("GenerateDoodleImageSegment", "generateFilterBitmap failed");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        SLog.b("GenerateDoodleImageSegment", "decode video thumb image failed %s", localOutOfMemoryError);
        Object localObject = null;
        continue;
        int i = paramJobContext.getHeight();
        int j = (int)(((Bitmap)localObject).getWidth() * i * 1.0F / ((Bitmap)localObject).getHeight());
        continue;
        boolean bool2;
        if (paramJobContext != null)
        {
          bool2 = true;
          SLog.d("GenerateDoodleImageSegment", "resize and save doodle image failed, resize result=%s, save result=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          bool1 = localDoodleLayout.a(localGenerateDoodleArgs.jdField_a_of_type_JavaLangString);
          SLog.b("GenerateDoodleImageSegment", "generate original doodle png file : success = " + bool1 + ", path = " + localGenerateDoodleArgs.jdField_a_of_type_JavaLangString);
          if (bool1)
          {
            SLog.b("GenerateDoodleImageSegment", "use the original doodle image instead");
            paramGenerateContext.a(true);
          }
        }
        else
        {
          bool2 = false;
          continue;
        }
        SLog.d("GenerateDoodleImageSegment", "copy the original doodle image failed, we'll ignore the doodle then publish");
        paramGenerateContext.a(false);
        continue;
      }
      SLog.d("GenerateDoodleImageSegment", "generate original doodle image failed");
      paramGenerateContext.a(false);
      continue;
      label539:
      notifyError(new ErrorMessage(-1, "DoodleLayout generate image failed"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      return;
      SLog.d("GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty, generateDoodleArgs=" + localGenerateDoodleArgs);
      paramGenerateContext.a(false);
      notifyResult(paramGenerateContext);
      long l2 = SystemClock.uptimeMillis();
      StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
      StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
      return;
      label661:
      boolean bool1 = false;
      continue;
      label667:
      paramJobContext = null;
      bool1 = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateDoodleImageSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */