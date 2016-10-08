package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.Collections;
import java.util.List;

public class ApolloFavViewBinder
  extends ApolloViewBinder
{
  private static int n;
  private static int o;
  private static int p;
  private static int q;
  private int a;
  private int b;
  
  public ApolloFavViewBinder(Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 4;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.l = 2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    int j = 1;
    int k = this.jdField_a_of_type_Int * this.jdField_b_of_type_Int;
    int i = j;
    switch (this.k)
    {
    default: 
      i = 0;
    }
    int m;
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        i = j;
      } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
      m = this.jdField_a_of_type_JavaUtilList.size();
      if ((this.jdField_a_of_type_JavaUtilList == null) || (m <= 0)) {
        break;
      }
      j = m / k + 0;
      i = j;
    } while (m % k == 0);
    return j + 1;
  }
  
  public View a()
  {
    switch (this.k)
    {
    default: 
      return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.l);
    case 4: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903094, null);
    }
    return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.l);
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public void a(View paramView, int paramInt)
  {
    b(paramView, paramInt);
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 1))
    {
      ApolloInfo localApolloInfo = (ApolloInfo)paramList.remove(0);
      Collections.reverse(paramList);
      paramList.add(0, localApolloInfo);
    }
    super.a(paramList);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!(paramView instanceof ApolloLinearLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "panel is not apolloLinearLayout");
      }
    }
    label196:
    label241:
    label292:
    label374:
    label455:
    label489:
    label517:
    label571:
    label788:
    label794:
    label801:
    label808:
    label866:
    label910:
    label999:
    label1006:
    label1013:
    label1055:
    label1093:
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_Int;
      int i2 = this.jdField_b_of_type_Int;
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (j >= this.jdField_b_of_type_Int) {
          break label1093;
        }
        LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
        int k = 0;
        if (k < this.jdField_a_of_type_Int)
        {
          View localView = localLinearLayout.getChildAt(k);
          ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)localView.getTag();
          int m = i1 * i2 * paramInt + i;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          ApolloActionData localApolloActionData;
          float f;
          int i3;
          Object localObject;
          if (m < this.jdField_a_of_type_JavaUtilList.size())
          {
            localApolloActionData = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).a;
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m));
            if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 2)
            {
              localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837739);
              localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
              localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.c = 0;
              if (TextUtils.isEmpty(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_JavaLangString)) {
                break label1013;
              }
              if (XPanelContainer.e != 0) {
                break label788;
              }
              m = 1;
              localViewHolder.b.setVisibility(0);
              localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              localViewHolder.f.setVisibility(0);
              localViewHolder.b.setText(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_JavaLangString);
              if (m == 0) {
                break label794;
              }
              f = 3.0F;
              i3 = AIOUtils.a(f, this.jdField_a_of_type_AndroidContentContext.getResources());
              localObject = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject).topMargin = i3;
              ((RelativeLayout.LayoutParams)localObject).width = (ApolloLinearLayout.e - i3 * 2);
              localViewHolder.b.setMaxHeight(ApolloLinearLayout.e - i3 * 3);
              localObject = (RelativeLayout.LayoutParams)localViewHolder.b.getLayoutParams();
              if (m == 0) {
                break label801;
              }
              f = 2.0F;
              ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(f, this.jdField_a_of_type_AndroidContentContext.getResources());
              localViewHolder.f.setBackgroundResource(2130837713);
              if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d != 1) {
                break label866;
              }
              if (m == 0) {
                break label808;
              }
              localViewHolder.b.setTextSize(8.0F);
              if (p == 0) {
                p = ApolloBarrageUtil.a(localViewHolder.b.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject).width = p;
              localViewHolder.b.setTextColor(-4473925);
              localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
              localObject = localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
              if (m == 0) {
                break label1006;
              }
              f = 3.0F;
              ((RelativeLayout)localObject).setPadding(0, 0, 0, AIOUtils.a(f, this.jdField_a_of_type_AndroidContentContext.getResources()));
              localViewHolder.b.setMaxLines(3);
              if (localApolloActionData.feeType == 9)
              {
                if ((localApolloActionData.limitFree != 1) || (System.currentTimeMillis() <= localApolloActionData.limitStart) || (System.currentTimeMillis() >= localApolloActionData.limitEnd)) {
                  break label1055;
                }
                localViewHolder.c.setImageResource(2130837745);
                localViewHolder.c.setVisibility(0);
              }
              if (localApolloActionData.feeType == 6)
              {
                localViewHolder.c.setBackgroundResource(2130837742);
                localViewHolder.c.setVisibility(0);
              }
              if (localApolloActionData.feeType == 7)
              {
                localViewHolder.c.setBackgroundResource(2130837743);
                localViewHolder.c.setVisibility(0);
              }
              if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))) {
                localViewHolder.d.setVisibility(0);
              }
              if (localApolloActionData.hasSound) {
                localViewHolder.e.setVisibility(0);
              }
              localView.setContentDescription(localApolloActionData.actionName + "按钮");
            }
          }
          for (;;)
          {
            i += 1;
            k += 1;
            break;
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
            break label196;
            m = 0;
            break label241;
            f = 5.0F;
            break label292;
            f = 5.0F;
            break label374;
            localViewHolder.b.setMaxHeight(ApolloLinearLayout.e - i3 * 2);
            localViewHolder.b.setTextSize(12.0F);
            if (n == 0) {
              n = ApolloBarrageUtil.a(localViewHolder.b.getPaint());
            }
            ((RelativeLayout.LayoutParams)localObject).width = n;
            break label455;
            if (m != 0)
            {
              localViewHolder.b.setTextSize(7.0F);
              if (q == 0) {
                q = ApolloBarrageUtil.a(localViewHolder.b.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject).width = q;
              localObject = localViewHolder.b;
              if (m == 0) {
                break label999;
              }
            }
            for (f = 7.0F;; f = 10.0F)
            {
              ((TextView)localObject).setTextSize(f);
              localViewHolder.b.setTextColor(-8947849);
              localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837714);
              break;
              localViewHolder.b.setTextSize(10.0F);
              if (o == 0) {
                o = ApolloBarrageUtil.a(localViewHolder.b.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject).width = o;
              break label910;
            }
            f = 9.0F;
            break label489;
            localViewHolder.f.setBackgroundDrawable(null);
            localViewHolder.b.setVisibility(8);
            localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            localViewHolder.f.setVisibility(8);
            break label517;
            ApolloUtil.a(localViewHolder.c, localApolloActionData.vipLevel);
            break label571;
            localView.setContentDescription(null);
            localView.setOnClickListener(null);
          }
        }
        j += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloFavViewBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */