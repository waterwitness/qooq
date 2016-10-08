package com.tencent.biz.qqstory.base.videoupload.meta;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.ShortVideoUploadSegment;
import com.tencent.biz.qqstory.base.videoupload.VideoUploadHelper.UploadResult;
import com.tencent.biz.qqstory.support.ImageDownloader.HTTP;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import iii;

public class StoryVideoFileObject
  extends UploadObject
{
  public static final String a = "Q.qqstory.publish:StoryVideoFileObject  ";
  public int a;
  public VideoUploadHelper.UploadResult a;
  public String b;
  public String c;
  
  public StoryVideoFileObject(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramInt;
  }
  
  protected void a()
  {
    if ((!TextUtils.isEmpty(this.b)) && (!ImageDownloader.HTTP.a(this.b)))
    {
      this.b = Uri.parse(this.b).getPath();
      Stream.of(new ErrorMessage()).map(new ThreadOffFunction(16)).map(new ShortVideoUploadSegment(this.b, this.c, this.a)).subscribe(new iii(this, null));
      return;
    }
    SLog.d("Q.qqstory.publish:StoryVideoFileObject  ", "this file had been upload:" + this.b);
    super.notifyResult(new ErrorMessage());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\meta\StoryVideoFileObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */