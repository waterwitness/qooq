package com.tencent.biz.qqstory.base.videoupload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Random;

public class UploadVideoThumbnail
  extends UploadObject
{
  public static final int a = 2;
  public static final String a = "UploadVideoThumbnail";
  public static final int b = 30;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public UploadVideoThumbnail(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = paramString;
  }
  
  public UploadVideoThumbnail(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.b = paramString2;
  }
  
  protected void a()
  {
    Object localObject1 = ThumbnailUtils.createVideoThumbnail(this.c, 1);
    if (localObject1 == null)
    {
      super.notifyError(new ErrorMessage(940005, "create video thumbnail fail"));
      return;
    }
    Bitmap localBitmap2 = BitmapUtils.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2, true);
    Bitmap localBitmap1 = null;
    if (this.b != null) {}
    for (localObject1 = localBitmap1;; localObject1 = localBitmap2)
    {
      try
      {
        Bitmap localBitmap3 = BitmapFactory.decodeFile(this.b);
        localObject1 = localBitmap1;
        localBitmap1 = BitmapUtils.a(localBitmap2, localBitmap3);
        localObject1 = localBitmap1;
        localBitmap2.recycle();
        localObject1 = localBitmap1;
        localBitmap3.recycle();
        localObject1 = localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          SLog.b("UploadVideoThumbnail", "decode file", localOutOfMemoryError);
        }
      }
      if (localObject1 != null) {
        break;
      }
      super.notifyError(new ErrorMessage(940005, "compress thumbnail fail"));
      return;
    }
    Object localObject2 = new Random(System.currentTimeMillis());
    localObject2 = QQStoryConstant.q + ((Random)localObject2).nextInt() + "_video.jpg";
    FileUtils.a(QQStoryConstant.q);
    if (!BitmapUtils.a((Bitmap)localObject1, (String)localObject2))
    {
      SLog.c("UploadVideoThumbnail", "create video thumbnail fail");
      super.notifyError(new ErrorMessage(940005, "compress thumbnail fail"));
      return;
    }
    SLog.c("UploadVideoThumbnail", "create video thumbnail success:" + (String)localObject2);
    this.d = ImageDownloader.FILE.a((String)localObject2);
    super.b();
    super.notifyResult(new ErrorMessage());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\UploadVideoThumbnail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */