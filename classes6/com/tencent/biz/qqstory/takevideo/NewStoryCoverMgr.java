package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.bitmap.BitmapAdjustJobSegment;
import com.tencent.biz.qqstory.takevideo.bitmap.BlurJobSegment;
import com.tencent.biz.qqstory.takevideo.bitmap.SaveBitmapJobSegment;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import ium;
import iun;
import java.io.File;

public class NewStoryCoverMgr
  extends NewStoryPart
{
  private static final String a = "NewStoryCoverMgr";
  
  public NewStoryCoverMgr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    Bitmap localBitmap2 = this.a.a(paramInt1, paramInt2);
    if ((paramRMVideoClipSpec == null) || (localBitmap2 == null)) {
      paramRMVideoClipSpec = localBitmap2;
    }
    for (;;)
    {
      return paramRMVideoClipSpec;
      try
      {
        Bitmap localBitmap1 = Bitmap.createBitmap(localBitmap2, paramRMVideoClipSpec.b, paramRMVideoClipSpec.a, paramRMVideoClipSpec.c, paramRMVideoClipSpec.d);
        paramRMVideoClipSpec = localBitmap1;
        if (localBitmap1 != null) {}
      }
      catch (OutOfMemoryError paramRMVideoClipSpec)
      {
        for (;;)
        {
          SLog.c("NewStoryCoverMgr", "getViewBitmap error ", paramRMVideoClipSpec);
        }
      }
    }
    return localBitmap2;
  }
  
  private Bitmap a(RMVideoClipSpec paramRMVideoClipSpec)
  {
    int[] arrayOfInt;
    if (paramRMVideoClipSpec != null)
    {
      arrayOfInt = new int[6];
      arrayOfInt[0] = paramRMVideoClipSpec.a;
      arrayOfInt[1] = paramRMVideoClipSpec.b;
      arrayOfInt[2] = paramRMVideoClipSpec.c;
      arrayOfInt[3] = paramRMVideoClipSpec.d;
      arrayOfInt[4] = paramRMVideoClipSpec.e;
      arrayOfInt[5] = paramRMVideoClipSpec.f;
    }
    for (paramRMVideoClipSpec = arrayOfInt;; paramRMVideoClipSpec = null) {
      try
      {
        paramRMVideoClipSpec = getPreprocessBitmap(paramRMVideoClipSpec);
        return paramRMVideoClipSpec;
      }
      catch (UnsatisfiedLinkError paramRMVideoClipSpec)
      {
        paramRMVideoClipSpec.printStackTrace();
        return null;
      }
    }
  }
  
  public static String a()
  {
    return QQStoryConstant.q + "story_cover_pic_blur.jpg";
  }
  
  public static String b()
  {
    return QQStoryConstant.q + "story_cover_pic.jpg";
  }
  
  private native Bitmap getPreprocessBitmap(int[] paramArrayOfInt);
  
  public Bitmap a()
  {
    Object localObject3 = null;
    String str = a();
    Object localObject1 = localObject3;
    if (new File(str).exists())
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject1).inSampleSize = 2;
    }
    try
    {
      localObject1 = BitmapFactory.decodeFile(str);
      SLog.b("NewStoryCoverMgr", "getInitCameraBitmapBlur : " + localObject1);
      return (Bitmap)localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean, RMVideoClipSpec paramRMVideoClipSpec)
  {
    if (paramBoolean) {
      return a(paramRMVideoClipSpec);
    }
    return a(paramInt2, paramInt1, paramRMVideoClipSpec);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, RMVideoClipSpec paramRMVideoClipSpec)
  {
    SLog.b("NewStoryCoverMgr", "generateCoverPicture");
    paramRMVideoClipSpec = a(paramInt1, paramInt2, paramBoolean, paramRMVideoClipSpec);
    if (paramRMVideoClipSpec != null) {
      Stream.of(paramRMVideoClipSpec).map(new ThreadOffFunction(2)).map(new BitmapAdjustJobSegment(0.6F, false)).map(new SaveBitmapJobSegment(b())).subscribe(new ium(this));
    }
  }
  
  public void b(int paramInt1, int paramInt2, boolean paramBoolean, RMVideoClipSpec paramRMVideoClipSpec)
  {
    SLog.b("NewStoryCoverMgr", "generateCoverPictureBlur");
    paramRMVideoClipSpec = a(paramInt1, paramInt2, paramBoolean, paramRMVideoClipSpec);
    if (paramRMVideoClipSpec != null) {
      Stream.of(paramRMVideoClipSpec).map(new ThreadOffFunction(2)).map(new SaveBitmapJobSegment(b())).map(new BitmapAdjustJobSegment(0.6F, false)).map(new BlurJobSegment(40)).map(new SaveBitmapJobSegment(a())).subscribe(new iun(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryCoverMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */