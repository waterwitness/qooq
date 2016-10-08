package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class ApolloMainViewBinder
  extends ApolloViewBinder
  implements View.OnClickListener
{
  public static final String a = "http://cmshow.qq.com/qqshow/admindata/comdata/vipData_apollo_source/panel_open_cover.png";
  public static final String b = "http://cmshow.qq.com/qqshow/admindata/comdata/vipData_apollo_source/panel_bottom_man.png";
  private static int n;
  private static int o;
  private static int p;
  private static int q;
  private int jdField_a_of_type_Int;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private OpenCallback jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ApolloMainViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 4;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.l = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    int j = 1;
    int k = this.jdField_a_of_type_Int * this.jdField_b_of_type_Int;
    int i = j;
    switch (this.k)
    {
    case 2: 
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
    case 2: 
    default: 
      return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.l);
    case 0: 
      return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.l);
    case 1: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903096, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903093, null);
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    URLImageView localURLImageView1 = (URLImageView)paramView.findViewById(2131297055);
    URLImageView localURLImageView2 = (URLImageView)paramView.findViewById(2131297057);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131297056));
    localURLImageView1.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText("去商城开通");
    }
    Object localObject = new ColorDrawable();
    URLDrawable localURLDrawable = URLDrawable.getDrawable("http://cmshow.qq.com/qqshow/admindata/comdata/vipData_apollo_source/panel_open_cover.png", (Drawable)localObject, (Drawable)localObject);
    localObject = URLDrawable.getDrawable("http://cmshow.qq.com/qqshow/admindata/comdata/vipData_apollo_source/panel_bottom_man.png", (Drawable)localObject, (Drawable)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView1.getLayoutParams();
    localLayoutParams.height = ((int)(XPanelContainer.c - 85.0F * paramView.getResources().getDisplayMetrics().density));
    localLayoutParams.width = (localLayoutParams.height * 600 / 340);
    localURLImageView1.setBackgroundDrawable(localURLDrawable);
    localURLImageView2.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(View paramView, int paramInt)
  {
    switch (this.k)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 0: 
      b(paramView, paramInt);
      return;
    }
    b(paramView);
  }
  
  public void a(OpenCallback paramOpenCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback = paramOpenCallback;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297051));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "panel is not jsonFail and panelView.class=" + paramView.getClass().getSimpleName());
    return;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297052));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297049));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297050));
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!(paramView instanceof ApolloLinearLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "panel is not apolloLinearLayout");
      }
    }
    label242:
    label364:
    label416:
    label498:
    label581:
    label617:
    label645:
    label699:
    label897:
    label903:
    label910:
    label917:
    label975:
    label1019:
    label1108:
    label1115:
    label1122:
    label1164:
    label1202:
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
          break label1202;
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
          Object localObject;
          float f;
          int i3;
          if (m < this.jdField_a_of_type_JavaUtilList.size())
          {
            localApolloActionData = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).a;
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_b_of_type_Int == 1)
            {
              localObject = new RedTouch(this.jdField_a_of_type_AndroidContentContext, localViewHolder.jdField_a_of_type_AndroidWidgetImageView).a(5).a();
              ((RedTouch)localObject).a(((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("103100.103200"));
              localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837751);
              localViewHolder.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = ((RedTouch)localObject);
              localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
              localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m));
              localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.c = 0;
              if (localApolloActionData.icon == 1)
              {
                localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837746);
                localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              }
              if (localApolloActionData.icon == 2)
              {
                localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837744);
                localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              }
              if (TextUtils.isEmpty(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_JavaLangString)) {
                break label1122;
              }
              if (XPanelContainer.e != 0) {
                break label897;
              }
              m = 1;
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              localViewHolder.f.setVisibility(0);
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_JavaLangString);
              if (m == 0) {
                break label903;
              }
              f = 3.0F;
              i3 = AIOUtils.a(f, this.jdField_a_of_type_AndroidContentContext.getResources());
              localObject = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject).topMargin = i3;
              ((RelativeLayout.LayoutParams)localObject).width = (ApolloLinearLayout.e - i3 * 2);
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i3 * 3);
              localObject = (RelativeLayout.LayoutParams)localViewHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
              if (m == 0) {
                break label910;
              }
              f = 2.0F;
              ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(f, this.jdField_a_of_type_AndroidContentContext.getResources());
              localViewHolder.f.setBackgroundResource(2130837713);
              if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d != 1) {
                break label975;
              }
              if (m == 0) {
                break label917;
              }
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(8.0F);
              if (p == 0) {
                p = ApolloBarrageUtil.a(localViewHolder.jdField_b_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject).width = p;
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4473925);
              localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
              localObject = localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
              if (m == 0) {
                break label1115;
              }
              f = 3.0F;
              ((RelativeLayout)localObject).setPadding(0, 0, 0, AIOUtils.a(f, this.jdField_a_of_type_AndroidContentContext.getResources()));
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(3);
              if (localApolloActionData.feeType == 9)
              {
                if ((localApolloActionData.limitFree != 1) || (System.currentTimeMillis() <= localApolloActionData.limitStart) || (System.currentTimeMillis() >= localApolloActionData.limitEnd)) {
                  break label1164;
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
              localView.setContentDescription(localApolloActionData.actionName);
            }
          }
          for (;;)
          {
            i += 1;
            k += 1;
            break;
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
            break label242;
            m = 0;
            break label364;
            f = 5.0F;
            break label416;
            f = 5.0F;
            break label498;
            localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i3 * 2);
            localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(12.0F);
            if (n == 0) {
              n = ApolloBarrageUtil.a(localViewHolder.jdField_b_of_type_AndroidWidgetTextView.getPaint());
            }
            ((RelativeLayout.LayoutParams)localObject).width = n;
            break label581;
            if (m != 0)
            {
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(7.0F);
              if (q == 0) {
                q = ApolloBarrageUtil.a(localViewHolder.jdField_b_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject).width = q;
              localObject = localViewHolder.jdField_b_of_type_AndroidWidgetTextView;
              if (m == 0) {
                break label1108;
              }
            }
            for (f = 7.0F;; f = 10.0F)
            {
              ((TextView)localObject).setTextSize(f);
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
              localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837714);
              break;
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(10.0F);
              if (o == 0) {
                o = ApolloBarrageUtil.a(localViewHolder.jdField_b_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject).width = o;
              break label1019;
            }
            f = 9.0F;
            break label617;
            localViewHolder.f.setBackgroundDrawable(null);
            localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            localViewHolder.f.setVisibility(8);
            break label645;
            ApolloUtil.a(localViewHolder.c, localApolloActionData.vipLevel);
            break label699;
            localView.setContentDescription(null);
            localView.setOnClickListener(null);
          }
        }
        j += 1;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback == null);
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.d();
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.b();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback == null);
      paramView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)paramView.getParent()).findViewById(2131297058));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.a();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.c();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    paramView.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloMainViewBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */