package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.List;
import xuk;
import xul;

public class PopupMenuDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private static final String jdField_a_of_type_JavaLangString = "PopupMenuDialog";
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private PopupMenuDialog.MenuItem jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem;
  private PopupMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener;
  private PopupMenuDialog.OnDismissListener jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener;
  private int b;
  
  private PopupMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  private static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  private static View a(Activity paramActivity, List paramList)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)LayoutInflater.from(paramActivity).inflate(2130904912, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localBounceScrollView.findViewById(2131297013);
    localBounceScrollView.setVerticalScrollBarEnabled(false);
    localBounceScrollView.h = 1;
    new LinearLayout.LayoutParams(-1, 1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a(paramActivity, 2131493352));
    int i = 0;
    if (i < paramList.size())
    {
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)paramList.get(i);
      LinearLayout localLinearLayout1;
      label107:
      ImageView localImageView;
      if (i == 0)
      {
        localLinearLayout1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2130904911, null);
        localImageView = (ImageView)localLinearLayout1.findViewById(2131301928);
        TextView localTextView = (TextView)localLinearLayout1.findViewById(2131301929);
        if (localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable == null) {
          break label288;
        }
        localImageView.setImageDrawable(localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable);
        label147:
        if (localMenuItem.jdField_b_of_type_Int == 0)
        {
          localImageView.setVisibility(8);
          localLinearLayout1.setPadding(0, 0, 0, 0);
        }
        localTextView.setText(localMenuItem.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localMenuItem.jdField_b_of_type_JavaLangString)) {
          break label301;
        }
        localLinearLayout1.setContentDescription(localMenuItem.jdField_b_of_type_JavaLangString + " 按钮");
      }
      for (;;)
      {
        localLinearLayout1.setTag(localMenuItem);
        localLinearLayout2.addView(localLinearLayout1, localLayoutParams);
        i += 1;
        break;
        if (i == paramList.size() - 1)
        {
          localLinearLayout1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2130904909, null);
          break label107;
        }
        localLinearLayout1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2130904910, null);
        break label107;
        label288:
        localImageView.setImageResource(localMenuItem.jdField_b_of_type_Int);
        break label147;
        label301:
        localLinearLayout1.setContentDescription(localMenuItem.jdField_a_of_type_JavaLangString + " 按钮");
      }
    }
    return localBounceScrollView;
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List paramList)
  {
    return a(paramActivity, paramList, null, null);
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener)
  {
    return a(paramActivity, paramList, paramOnClickActionListener, null);
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener)
  {
    return a(paramActivity, paramList, paramOnClickActionListener, paramOnDismissListener, 0);
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = b(paramActivity, paramList.size());
    if (paramInt <= 0) {
      paramInt = a(paramActivity, 2131493351);
    }
    for (;;)
    {
      paramActivity = new PopupMenuDialog(paramActivity, a(paramActivity, paramList), paramInt, i, true);
      paramActivity.setAnimationStyle(2131559132);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      if (Build.VERSION.SDK_INT >= 9) {
        a(paramActivity, 1002);
      }
      if (AppSetting.j) {
        a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.jdField_b_of_type_Int = i;
      paramActivity.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener = paramOnClickActionListener;
      paramActivity.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener = paramOnDismissListener;
      return paramActivity;
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof PopupMenuDialog.MenuItem))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  private static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    if (!AppSetting.j) {}
    for (;;)
    {
      return;
      Method[] arrayOfMethod = PopupWindow.class.getMethods();
      int j = arrayOfMethod.length;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (localMethod.getName().equals("setTouchModal")) {
          try
          {
            localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
            return;
          }
          catch (Exception paramPopupWindow)
          {
            paramPopupWindow.printStackTrace();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  private static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    int i = 0;
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    for (;;)
    {
      Method localMethod;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if (!localMethod.getName().equals("setWindowLayoutType")) {}
      }
      else
      {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  private static int b(Context paramContext, int paramInt)
  {
    return a(paramContext, 2131493352) * paramInt + a(paramContext, 2131493353) + (paramInt - 1) * 1;
  }
  
  private void b()
  {
    int j = -1;
    int i;
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1000;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label242;
          }
          i = j;
        }
      }
    }
    label242:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131559133;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427360));
        this.jdField_a_of_type_AndroidViewView.setContentDescription("返回");
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new xuk(this));
      }
      if ((AppSetting.j) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new xul(this));
      }
      return;
    }
  }
  
  public void a()
  {
    if ((Build.VERSION.SDK_INT < 9) && (isShowing())) {
      dismiss();
    }
  }
  
  public void dismiss()
  {
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem != null)) {
          this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem);
        }
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = null;
        if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener != null) {
          this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener.a();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PopupMenuDialog", 2, localException.toString());
          }
        }
      } while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())));
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968805);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem != null)) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem);
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = null;
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = ((PopupMenuDialog.MenuItem)paramView.getTag());
    dismiss();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int j = getMaxAvailableHeight(paramView, paramInt2);
    if (j != this.jdField_a_of_type_Int)
    {
      int i = 0;
      if (j < this.jdField_b_of_type_Int) {
        i = (1 - a(this.jdField_a_of_type_AndroidAppActivity, 2131493353) + j) / (a(this.jdField_a_of_type_AndroidAppActivity, 2131493352) + 1);
      }
      if (i <= 0) {
        break label110;
      }
      setHeight(b(this.jdField_a_of_type_AndroidAppActivity, i));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = j;
      try
      {
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        super.showAsDropDown(paramView, paramInt1, paramInt2);
        return;
        label110:
        setHeight(this.jdField_b_of_type_Int);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PopupMenuDialog", 2, localException.toString());
          }
        }
      }
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PopupMenuDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\PopupMenuDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */