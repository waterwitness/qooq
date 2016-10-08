package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import iwx;

public class QQStoryTakeVideoCloseAnimationActivity
  extends QQStoryBaseActivity
{
  public ImageView a;
  
  public QQStoryTakeVideoCloseAnimationActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = new ImageView(this);
    super.getWindow().addFlags(1024);
    super.setContentViewNoTitle(this.a);
    paramBundle = getIntent().getStringExtra("path");
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    try
    {
      int i = getResources().getDisplayMetrics().widthPixels;
      paramBundle = BitmapFactory.decodeFile(paramBundle).copy(Bitmap.Config.ARGB_8888, true);
      float f = paramBundle.getWidth() / i;
      this.a.setImageBitmap(paramBundle);
      i = (int)(DisplayUtil.a(this, 35.0F) * f);
      int j = (int)(f * (DisplayUtil.a(this, 50.0F) + getTitleBarHeight()));
      paramBundle = new iwx(this, paramBundle, 200.0F, paramBundle.getWidth() / 1.5F, paramBundle.getHeight() * 0.8F, i, j);
      this.a.post(paramBundle);
      return true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      finish();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\QQStoryTakeVideoCloseAnimationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */