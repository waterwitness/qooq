package com.tencent.common.galleryactivity;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.net.URL;

public abstract class URLGalleryImage
  extends GalleryImage
{
  public URLGalleryImage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public abstract URLDrawable a(Drawable paramDrawable1, Drawable paramDrawable2);
  
  public abstract URL a();
  
  @Deprecated
  public abstract boolean a();
  
  public abstract Drawable b();
  
  public abstract URLDrawable b(Drawable paramDrawable1, Drawable paramDrawable2);
  
  @Deprecated
  public abstract String b();
  
  public abstract URL b();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\galleryactivity\URLGalleryImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */