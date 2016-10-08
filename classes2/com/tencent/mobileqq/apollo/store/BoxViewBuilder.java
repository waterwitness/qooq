package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;
import psc;

public abstract class BoxViewBuilder
{
  protected float a;
  protected final int a;
  protected Context a;
  protected TextView a;
  protected ApolloBoxData a;
  private psc a;
  protected float b;
  protected final int b;
  protected TextView b;
  protected final int c;
  protected final int d;
  protected final int e;
  
  public BoxViewBuilder(Context paramContext, ApolloBoxData paramApolloBoxData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData = paramApolloBoxData;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ApolloUtil.a(13.0F, ApolloBoxWindow.jdField_b_of_type_Float);
    this.jdField_b_of_type_Int = ApolloUtil.a(175.0F, ApolloBoxWindow.jdField_b_of_type_Float);
    this.c = ApolloUtil.a(250.0F, ApolloBoxWindow.jdField_b_of_type_Float);
    this.e = ((int)DeviceInfoUtil.i());
    this.d = ((int)DeviceInfoUtil.h());
    this.jdField_a_of_type_Float = (FontSettingManager.a() / 16.0F);
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = 1.0F;
    }
  }
  
  protected float a()
  {
    return this.c;
  }
  
  protected View a()
  {
    return null;
  }
  
  public abstract ApolloWrapperCardView a(int paramInt, ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem);
  
  protected void a()
  {
    if (this.jdField_a_of_type_Psc != null) {
      this.jdField_a_of_type_Psc.c();
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData == null)) {}
    do
    {
      return;
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setGravity(17);
      paramRelativeLayout.addView(localLinearLayout, new RelativeLayout.LayoutParams(-1, -1));
      int j = ApolloUtil.a(15.0F, ApolloBoxWindow.jdField_b_of_type_Float);
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.a != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.a.size() == 2)
        {
          i = j;
          if (DeviceInfoUtil.a() >= 3.0F) {
            i = ApolloUtil.a(22.0F, ApolloBoxWindow.jdField_b_of_type_Float);
          }
        }
      }
      paramRelativeLayout = b();
      if (paramRelativeLayout != null)
      {
        paramRelativeLayout.setClickable(true);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = i;
        localLinearLayout.addView(paramRelativeLayout, localLayoutParams);
      }
      this.jdField_a_of_type_Psc = new psc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData);
      paramRelativeLayout = new LinearLayout.LayoutParams(-1, (int)a());
      localLinearLayout.addView(this.jdField_a_of_type_Psc, paramRelativeLayout);
      this.jdField_a_of_type_Psc.a(this);
      paramRelativeLayout = a();
    } while (paramRelativeLayout == null);
    paramRelativeLayout.setClickable(true);
    this.jdField_a_of_type_Psc.addView(paramRelativeLayout);
  }
  
  protected View b()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("获得一张贴片");
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = ApolloUtil.a(2.0F, ApolloBoxWindow.jdField_b_of_type_Float);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-2130706433);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("XXX的胶囊");
    localLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    if (ApolloWrapperCardView.a)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F / this.jdField_a_of_type_Float);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(13.0F / this.jdField_a_of_type_Float);
      return localLinearLayout;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F / this.jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F / this.jdField_a_of_type_Float);
    return localLinearLayout;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Psc != null) {
      this.jdField_a_of_type_Psc.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\BoxViewBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */