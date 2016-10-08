package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class ApolloWrapperCardView
  extends RelativeLayout
{
  public static float a;
  public static int a;
  public static boolean a;
  public static float b;
  public static int b;
  public static float c;
  public static int c;
  public static int d;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final ApolloWrapperCardView.ApolloCardView jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView;
  private final int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Float = 1.0F;
    jdField_b_of_type_Float = 0.75F;
    jdField_c_of_type_Float = 0.66F;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    d = 4;
    int i = (int)DeviceInfoUtil.i();
    int j = (int)DeviceInfoUtil.h();
    if (ApolloBoxWindow.jdField_b_of_type_Float == 0.0F) {
      ApolloBoxWindow.a();
    }
    float f = ApolloUtil.a(250.0F, ApolloBoxWindow.jdField_b_of_type_Float);
    f = i - f;
    if (f < (int)(ApolloUtil.a(276.0F, ApolloBoxWindow.jdField_b_of_type_Float) * jdField_b_of_type_Float * 2.0F)) {
      jdField_c_of_type_Float = f / ApolloUtil.a(276.0F, ApolloBoxWindow.jdField_b_of_type_Float) / 2.0F;
    }
    if (j <= 480) {
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public ApolloWrapperCardView(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Context paramContext)
  {
    super(paramContext);
    this.e = paramInt;
    paramInt = (int)(paramFloat1 - this.e * 2);
    int i = (int)(paramFloat2 - this.e * 2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView = new ApolloWrapperCardView.ApolloCardView(paramInt, i, paramFloat3, paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt, i);
    localLayoutParams.addRule(13);
    super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if (paramInt == jdField_a_of_type_Int) {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView.a();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt == jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          return;
        }
        if (paramInt == jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
      } while ((paramInt != d) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView == null) || (ApolloWrapperCardView.ApolloCardView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView) == null));
      if (!ApolloWrapperCardView.ApolloCardView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView).b)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView.b();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWrapperCardView$ApolloCardView.a(paramApolloBoxDataItem);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloWrapperCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */