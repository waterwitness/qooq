package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class BoxViewBuilder$DataFillViewBuilder
  extends BoxViewBuilder
{
  public BoxViewBuilder$DataFillViewBuilder(Context paramContext, ApolloBoxData paramApolloBoxData)
  {
    super(paramContext, paramApolloBoxData);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected float a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList == null)) {
      return super.a();
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      return this.c + this.jdField_a_of_type_Int * 2;
    }
    if (i == 2) {
      return (this.c + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.b;
    }
    if (i <= 4) {
      return (this.c + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.c * 2.0F;
    }
    return super.a();
  }
  
  protected ApolloWrapperCardView a(int paramInt, ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem)
  {
    if ((paramApolloBoxDataItem == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList == null)) {}
    do
    {
      return null;
      i = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList.size();
      if (i == 1)
      {
        paramInt = this.jdField_b_of_type_Int + this.jdField_a_of_type_Int * 2;
        i = this.c + this.jdField_a_of_type_Int * 2;
        localApolloWrapperCardView = new ApolloWrapperCardView(paramInt, i, ApolloWrapperCardView.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext);
        localLayoutParams = new RelativeLayout.LayoutParams(paramInt, i);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(10, -1);
        localLayoutParams.leftMargin = (this.d - paramInt >> 1);
        localLayoutParams.topMargin = 0;
        localApolloWrapperCardView.setLayoutParams(localLayoutParams);
        localApolloWrapperCardView.a(paramApolloBoxDataItem);
        return localApolloWrapperCardView;
      }
      if (i == 2)
      {
        i = (int)((this.jdField_b_of_type_Int + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.b);
        j = (int)((this.c + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.b);
        localApolloWrapperCardView = new ApolloWrapperCardView(i, j, ApolloWrapperCardView.b, (int)(this.jdField_a_of_type_Int * ApolloWrapperCardView.b), this.jdField_a_of_type_AndroidContentContext);
        localLayoutParams = new RelativeLayout.LayoutParams(i, j);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(10, -1);
        localLayoutParams.leftMargin = ((this.d - i * 2 >> 1) + paramInt * i);
        localLayoutParams.topMargin = 0;
        localApolloWrapperCardView.setLayoutParams(localLayoutParams);
        localApolloWrapperCardView.a(paramApolloBoxDataItem);
        return localApolloWrapperCardView;
      }
      if (i == 3)
      {
        int k = (int)((this.jdField_b_of_type_Int + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.c);
        int m = (int)((this.c + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.c);
        localApolloWrapperCardView = new ApolloWrapperCardView(k, m, ApolloWrapperCardView.c, (int)(this.jdField_a_of_type_Int * ApolloWrapperCardView.c), this.jdField_a_of_type_AndroidContentContext);
        localLayoutParams = new RelativeLayout.LayoutParams(k, m);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(10, -1);
        if (paramInt == 0)
        {
          j = this.d - k >> 1;
          i = paramInt;
        }
        for (paramInt = j;; paramInt = this.d - k * 2 >> 1)
        {
          localLayoutParams.leftMargin = (paramInt + i % 2 * k);
          localLayoutParams.topMargin = (i / 2 * m);
          localApolloWrapperCardView.setLayoutParams(localLayoutParams);
          localApolloWrapperCardView.a(paramApolloBoxDataItem);
          return localApolloWrapperCardView;
          i = paramInt + 1;
        }
      }
    } while (i != 4);
    int i = (int)((this.jdField_b_of_type_Int + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.c);
    int j = (int)((this.c + this.jdField_a_of_type_Int * 2) * ApolloWrapperCardView.c);
    ApolloWrapperCardView localApolloWrapperCardView = new ApolloWrapperCardView(i, j, ApolloWrapperCardView.c, (int)(this.jdField_a_of_type_Int * ApolloWrapperCardView.c), this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.leftMargin = ((this.d - i * 2 >> 1) + paramInt % 2 * i);
    localLayoutParams.topMargin = (paramInt / 2 * j);
    localApolloWrapperCardView.setLayoutParams(localLayoutParams);
    localApolloWrapperCardView.a(paramApolloBoxDataItem);
    return localApolloWrapperCardView;
  }
  
  public View b()
  {
    View localView = super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("胶囊已开，抢到" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Int + "张贴纸！");
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("我的胶囊");
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\BoxViewBuilder$DataFillViewBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */