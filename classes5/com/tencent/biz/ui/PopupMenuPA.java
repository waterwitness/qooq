package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import jfx;
import jfy;
import jfz;

public class PopupMenuPA
  extends PopupWindows
{
  int jdField_a_of_type_Int;
  public View a;
  protected CustomMenuBar.OnMenuItemClickListener a;
  PopupMenuPA.AnimationCallbacks jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  public String a;
  List jdField_a_of_type_JavaUtilList;
  String b;
  
  public PopupMenuPA(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks = new jfz(this);
    a(2130903487);
  }
  
  public PopupMenuPA(Context paramContext, int paramInt)
  {
    this(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public MenuItem a(int paramInt)
  {
    return (MenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
    {
      ((CellLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem())).b();
      return;
    }
    c();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(paramInt, null));
    super.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131296820);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131298774));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC4", "0X8005EC4", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(0);
      ((CellLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(0)).a();
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, paramInt1, paramInt2);
      localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131298201);
      if (localObject1 != null) {
        ((View)localObject1).setClickable(true);
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, paramInt1, paramInt2);
      if ((localQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005ECF", "0X8005ECF", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(1), "", "");
      }
    }
    label694:
    do
    {
      return;
      b();
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(paramInt3);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(paramInt4);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903344, null);
      Object localObject2 = (TextView)((View)localObject1).findViewById(2131298199);
      ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangString);
      ((TextView)localObject2).setTextColor(Color.parseColor("#00a5e0"));
      Object localObject3 = new ArrowShape();
      ((ArrowShape)localObject3).a(((TextView)localObject2).getTextColors().getDefaultColor());
      ((ArrowShape)localObject3).a(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
      ((ArrowShape)localObject3).a(false);
      localObject2 = new ShapeDrawable((Shape)localObject3);
      ((ImageView)((View)localObject1).findViewById(2131298198)).setBackgroundDrawable((Drawable)localObject2);
      ((View)localObject1).setOnClickListener(new jfx(this, (View)localObject1));
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).height = paramInt5;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((View)localObject1).setPadding(0, paramInt6, 0, paramInt7);
      ((ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131297013)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new MenuAdapter(paramView.getContext());
      ((MenuAdapter)localObject1).a(this.jdField_a_of_type_JavaLangString);
      ((MenuAdapter)localObject1).a(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener);
      ((MenuAdapter)localObject1).a(this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks);
      ((MenuAdapter)localObject1).a(this.jdField_a_of_type_Int);
      ((MenuAdapter)localObject1).a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter((PagerAdapter)localObject1);
      if (this.jdField_a_of_type_Int == 1)
      {
        paramInt4 = this.jdField_a_of_type_JavaUtilList.size() / 9;
        if (this.jdField_a_of_type_JavaUtilList.size() % 9 > 0) {}
        for (paramInt3 = 1;; paramInt3 = 0)
        {
          paramInt4 += paramInt3;
          if (paramInt4 <= 1) {
            break label694;
          }
          localObject1 = (RadioGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131298775);
          paramInt3 = 0;
          while (paramInt3 < paramInt4)
          {
            localObject2 = new RadioButton(paramView.getContext());
            ((RadioButton)localObject2).setButtonDrawable(2130838487);
            ((RadioButton)localObject2).setClickable(false);
            ((RadioButton)localObject2).setFocusable(false);
            localObject3 = paramView.getContext().getResources().getDrawable(2130837548);
            localObject3 = new RadioGroup.LayoutParams(((Drawable)localObject3).getIntrinsicWidth(), ((Drawable)localObject3).getIntrinsicHeight());
            if (paramInt3 > 0) {
              ((RadioGroup.LayoutParams)localObject3).leftMargin = MenuViewFactory.a(paramView.getContext(), 10.0F);
            }
            ((RadioButton)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((RadioGroup)localObject1).addView((View)localObject2);
            paramInt3 += 1;
          }
        }
        ((RadioGroup)localObject1).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(new jfy(this, (RadioGroup)localObject1, localQQAppInterface));
        ((RadioButton)((RadioGroup)localObject1).getChildAt(0)).setChecked(true);
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("PA_anim", 4, "Animation End(first): " + System.currentTimeMillis());
      }
    } while ((localQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005ECF", "0X8005ECF", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(1), "", "");
  }
  
  public void a(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void a(MenuItem paramMenuItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\PopupMenuPA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */