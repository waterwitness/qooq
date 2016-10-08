package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageCache
  extends LruCache
{
  public static final String a = "qqstory.ImageCache";
  
  public ImageCache(int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  protected void a(boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super.entryRemoved(paramBoolean, paramString, paramBitmap1, paramBitmap2);
  }
  
  public boolean a(String paramString, Bitmap paramBitmap)
  {
    int i = a(paramString, paramBitmap);
    SLog.b("qqstory.ImageCache", "putBitmap2Cache=" + Thread.currentThread().getName() + ", key=" + paramString + ",size=" + i);
    if (i > 512000)
    {
      remove(paramString);
      return false;
    }
    put(paramString, paramBitmap);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\ImageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */