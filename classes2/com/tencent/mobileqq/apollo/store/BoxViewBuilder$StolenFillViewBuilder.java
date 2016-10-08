package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BoxViewBuilder$StolenFillViewBuilder
  extends BoxViewBuilder.DataFillViewBuilder
{
  public BoxViewBuilder$StolenFillViewBuilder(Context paramContext, ApolloBoxData paramApolloBoxData)
  {
    super(paramContext, paramApolloBoxData);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
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
        break label170;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.a > 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("本轮你已抢过,抢到" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.a + "张贴纸！");
      }
    }
    else
    {
      return localView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.i == -501027L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("本轮你已抢过,未抢到贴纸！");
      return localView;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("本轮你已抢过,未抢到贴纸！");
    return localView;
    label170:
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.a > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("运气不错，抢到" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.a + "张贴纸！");
      return localView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h == -501027L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("手慢了贴纸已被抢光！");
      return localView;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("手气不佳，没有抢到贴纸！");
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\BoxViewBuilder$StolenFillViewBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */