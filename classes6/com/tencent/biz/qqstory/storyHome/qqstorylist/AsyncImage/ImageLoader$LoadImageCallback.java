package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageLoader$LoadImageCallback
  implements URLDrawable.URLDrawableListener
{
  public ImageLoader$LoadImageCallback()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\ImageLoader$LoadImageCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */