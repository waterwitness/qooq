package com.tencent.common.galleryactivity;

import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;

public abstract class AbstractGalleryPageView
{
  public AbstractGalleryPageView()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(Activity paramActivity, AbstractGalleryScene paramAbstractGalleryScene, int paramInt);
  
  public abstract void a(AdapterView paramAdapterView, int paramInt);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\galleryactivity\AbstractGalleryPageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */