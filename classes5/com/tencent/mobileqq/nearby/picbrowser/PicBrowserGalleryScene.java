package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import java.io.File;
import tkz;

public class PicBrowserGalleryScene
  extends AbstractGalleryScene
{
  public static final int a = 1001;
  public static final String a = "PicBrowser";
  private PicBrowserActivity jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity;
  private PicBrowserGalleryAdapter jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter;
  private PicBrowserModel jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel;
  private boolean jdField_a_of_type_Boolean;
  
  public PicBrowserGalleryScene(PicBrowserActivity paramPicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramPicBrowserActivity, paramAbstractImageListModel);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel = ((PicBrowserModel)paramAbstractImageListModel);
  }
  
  private void a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_thumb", paramString);
    localIntent.putExtra("key_flag_from_plugin", true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.startActivityForResult(localIntent, 1001);
  }
  
  private void c(int paramInt)
  {
    Object localObject3 = "";
    Object localObject4 = null;
    Object localObject1 = localObject4;
    Object localObject2 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt) != null)
    {
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {
          break label106;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c;
      }
    }
    for (localObject1 = new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c); localObject1 == null; localObject1 = AbsDownloader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a))
    {
      return;
      label106:
      localObject2 = AbsDownloader.d(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
    }
    localObject3 = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
    ((ActionSheet)localObject3).c("保存到手机");
    ((ActionSheet)localObject3).c("发送给QQ好友");
    ((ActionSheet)localObject3).d("取消");
    ((ActionSheet)localObject3).a(new tkz(this, (ActionSheet)localObject3, (File)localObject1, (String)localObject2));
    ((ActionSheet)localObject3).show();
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130904250, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter = new PicBrowserGalleryAdapter(paramContext);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter;
  }
  
  public void a()
  {
    PicBrowserImage localPicBrowserImage = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a();
    if (localPicBrowserImage != null)
    {
      localPicBrowserImage.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localPicBrowserImage.c = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1001)) {}
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      c(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b());
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    c(paramInt);
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.c();
  }
  
  public void f()
  {
    super.f();
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel instanceof PicBrowserModel))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a();
      this.jdField_a_of_type_Boolean = true;
    }
    super.n();
  }
  
  public void o()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel instanceof PicBrowserModel)) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_Boolean = false;
    super.o();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\picbrowser\PicBrowserGalleryScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */