package com.tencent.biz.qqstory.takevideo.doodle.loader;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

public class ImageLoader
{
  private static ImageLoader jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLoaderImageLoader;
  private static final String jdField_a_of_type_JavaLangString = "ImageLoader";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new ImageLoader();
  }
  
  public static ImageLoader a()
  {
    return a;
  }
  
  public void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      SLog.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    SLog.b("ImageLoader", "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mRequestWidth = paramInt1;
    paramContext.mRequestHeight = paramInt2;
    paramContext.mFailedDrawable = URLDrawableHelper.e;
    paramContext.mLoadingDrawable = URLDrawableHelper.e;
    paramContext.mUseAutoScaleParams = false;
    paramContext = URLDrawable.getDrawable(paramString, paramContext);
    if (paramURLDrawableListener != null)
    {
      if (paramContext.getStatus() != 1) {
        break label148;
      }
      SLog.b("ImageLoader", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramContext);
    }
    for (;;)
    {
      paramContext.setURLDrawableListener(paramURLDrawableListener);
      paramContext.startDownload();
      paramImageView.setImageDrawable(paramContext);
      return;
      label148:
      SLog.b("ImageLoader", "start load URLDrawable.");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\loader\ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */