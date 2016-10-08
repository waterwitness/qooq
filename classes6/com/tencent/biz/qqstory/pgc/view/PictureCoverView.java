package com.tencent.biz.qqstory.pgc.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import imj;

public class PictureCoverView
  extends BaseCoverView
  implements Runnable
{
  protected int c;
  public ImageView d;
  
  public PictureCoverView(Context paramContext, Story paramStory)
  {
    super(paramContext, paramStory);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = new URLImageView(getContext());
    this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    super.addView(this.d, 0);
    this.d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl))) {}
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.themeColor);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable(ThumbnailUrlHelper.a(getContext(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setFadeInImage(true);
      this.d.setImageDrawable((Drawable)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new imj(this));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("View", 2, QLog.getStackTraceString(localException));
    }
  }
  
  public void c()
  {
    e();
    super.c();
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(this.b, this.c);
    super.postDelayed(this, 50L);
  }
  
  public void d()
  {
    f();
    super.d();
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.c += 8;
      if (this.c > 100) {
        this.c = 0;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(this.b, this.c);
      super.postDelayed(this, 50L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\PictureCoverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */