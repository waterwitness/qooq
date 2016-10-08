package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BoxViewBuilder$DataLostViewBuilder
  extends BoxViewBuilder
{
  public BoxViewBuilder$DataLostViewBuilder(Context paramContext, ApolloBoxData paramApolloBoxData)
  {
    super(paramContext, paramApolloBoxData);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected float a()
  {
    return (this.c + this.jdField_a_of_type_Int) * ApolloWrapperCardView.b;
  }
  
  protected View a()
  {
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = ApolloImageDownloader.a("apollo_error.png", null, ApolloImageDownloader.a("apollo_error.png"));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi / 2);
    localURLImageView.setImageDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, (int)(this.c * ApolloWrapperCardView.b));
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = ApolloUtil.a(20.0F, ApolloBoxWindow.b);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    return localURLImageView;
  }
  
  protected ApolloWrapperCardView a(int paramInt, ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem)
  {
    return null;
  }
  
  public View b()
  {
    View localView = super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData != null)
    {
      if (this.b != null)
      {
        this.b.setText(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.c + "的胶囊");
        this.b.setVisibility(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.i == 0L) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h != -501031L)) {
        break label146;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.i == -501027L) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("本轮你已抢过,未抢到贴纸！");
      }
    }
    else
    {
      return localView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.i == -501028L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("来晚一步，贴纸刚被主人领走啦~");
      return localView;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("本轮你已抢过,未抢到贴纸！");
    return localView;
    label146:
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h == -501027L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("手慢了贴纸已被抢光！");
      return localView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h == -501028L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("来晚一步，贴纸刚被主人领走啦~");
      return localView;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("手气不佳，没有抢到贴纸！");
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\BoxViewBuilder$DataLostViewBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */