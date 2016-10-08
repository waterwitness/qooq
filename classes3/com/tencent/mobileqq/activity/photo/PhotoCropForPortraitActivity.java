package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;
import orh;

public class PhotoCropForPortraitActivity
  extends PhotoCropActivity
{
  public URLImageView a;
  boolean c;
  
  public PhotoCropForPortraitActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Boolean = true;
  }
  
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(50)).a(this.app.a());
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getApplicationContext());
    int i = paramInt1;
    int j = paramInt2;
    if (localExtensionInfo != null)
    {
      i = paramInt1;
      j = paramInt2;
      if (localExtensionInfo.isPendantValid())
      {
        i = paramInt1;
        j = paramInt2;
        if (this.jdField_c_of_type_Boolean)
        {
          int k = Math.min(this.app.getApplication().getApplicationContext().getResources().getDisplayMetrics().heightPixels, this.app.getApplication().getApplicationContext().getResources().getDisplayMetrics().widthPixels);
          i = paramInt1;
          j = paramInt2;
          if (k < 640)
          {
            float f = 1.0F * paramInt2 / paramInt1;
            i = (int)(k / 1.257D);
            this.b = i;
            j = (int)(i * f);
            this.jdField_c_of_type_Int = j;
          }
          this.jdField_a_of_type_AndroidOsHandler = new orh(this, i, j, localExtensionInfo);
        }
      }
    }
    super.a(paramString, i, j, paramInt3, paramInt4, paramInt5);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("PhotoConst.IS_WITH_PENDANT", true);
    boolean bool = super.doOnCreate(paramBundle);
    if ((Build.VERSION.SDK_INT < 11) || ((Build.MODEL.equals("M040")) && (Build.VERSION.SDK_INT == 16))) {
      return bool;
    }
    getWindow().setFlags(16777216, 16777216);
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PhotoCropForPortraitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */