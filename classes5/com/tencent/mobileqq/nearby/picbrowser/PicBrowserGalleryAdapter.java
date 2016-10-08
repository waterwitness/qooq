package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import tkw;
import tkx;
import tky;

public class PicBrowserGalleryAdapter
  extends AbstractImageAdapter
  implements PicBrowserImage.OnLoadListener
{
  public static final String a = "PicBrowser";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  public PicBrowserGalleryAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    int i = HttpUtil.a();
    if ((i != 1) && (i != 4)) {}
    PicBrowserImage localPicBrowserImage;
    do
    {
      return;
      localPicBrowserImage = (PicBrowserImage)getItem(paramInt + 1);
      if (localPicBrowserImage != null) {
        localPicBrowserImage.a();
      }
      localPicBrowserImage = (PicBrowserImage)getItem(paramInt - 1);
    } while (localPicBrowserImage == null);
    localPicBrowserImage.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tkw(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tky(this, paramInt, paramBoolean));
  }
  
  public void a(View paramView, int paramInt)
  {
    ((PicBrowserImage)getItem(paramInt)).a(paramView, paramInt, this);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tkx(this, paramInt1, paramInt2));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {
      return paramView;
    }
    paramView = (PicBrowserImage)getItem(paramInt);
    paramViewGroup = paramView.a;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).a)) {
      ((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).app.a().b(paramViewGroup.a);
    }
    paramView = paramView.a(paramInt, this.jdField_a_of_type_AndroidOsHandler, this);
    paramView.setTag(2131296390, Boolean.valueOf(true));
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\picbrowser\PicBrowserGalleryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */