package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import jfh;
import jfi;
import jfj;
import jfk;
import jfl;
import jfm;
import jfn;
import jfo;

public class CustomMenuBar
  extends LinearLayout
{
  protected int a;
  public Handler a;
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  public CustomMenuBar.OnMenuItemClickListener a;
  public PopupWindows a;
  public Runnable a;
  protected List a;
  public boolean a;
  private int b;
  public boolean b;
  
  public CustomMenuBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new jfo(this);
    super.setFocusable(true);
    super.setOrientation(0);
    super.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843014);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getText(2131364497));
    if (a()) {
      setBackgroundColor(paramContext.getResources().getColor(2131427685));
    }
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.leftMargin = 0;
    paramAttributeSet.rightMargin = DisplayUtil.a(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903342, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131298196));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
  }
  
  public static int a(Context paramContext)
  {
    return ImmersiveUtils.a(paramContext);
  }
  
  public static boolean a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    return (str != null) && (str.equals("1000"));
  }
  
  View a(MenuItem paramMenuItem, String paramString)
  {
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2130903344, null);
    Object localObject = (TextView)localView.findViewById(2131298199);
    if (a()) {
      ((TextView)localObject).setTextColor(Color.parseColor("#00a5e0"));
    }
    ((TextView)localObject).setText(paramMenuItem.a());
    ImageView localImageView = (ImageView)localView.findViewById(2131298198);
    ArrowShape localArrowShape = new ArrowShape();
    localArrowShape.a(((TextView)localObject).getTextColors().getDefaultColor());
    localArrowShape.a(getResources().getDisplayMetrics().density);
    localArrowShape.a(true);
    localImageView.setBackgroundDrawable(new ShapeDrawable(localArrowShape));
    localObject = new PopupMenuPA(super.getContext(), this.jdField_a_of_type_Int);
    ((PopupMenuPA)localObject).a(paramString);
    ((PopupMenuPA)localObject).b(paramMenuItem.a());
    int i = 0;
    while (i < paramMenuItem.b())
    {
      ((PopupMenuPA)localObject).a(paramMenuItem.a(i));
      i += 1;
    }
    ((PopupMenuPA)localObject).a(new jfh(this, localImageView));
    ((PopupMenuPA)localObject).a(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener);
    localView.setOnTouchListener(new jfi(this));
    localView.setOnClickListener(new jfj(this, (PopupMenuPA)localObject, localImageView));
    return localView;
  }
  
  public void a()
  {
    this.b = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(MenuItem paramMenuItem, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 17;
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        return;
      }
      paramString = a(paramMenuItem, paramString);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      int i = getResources().getDrawable(2130843014).getIntrinsicWidth();
      int j = localMarginLayoutParams.leftMargin;
      localLayoutParams.rightMargin = (localMarginLayoutParams.rightMargin + (i + j));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
      paramString.setFocusable(true);
      paramString.setClickable(true);
      paramString.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramString);
      return;
      paramString = b(paramMenuItem, paramString);
    }
  }
  
  View b(MenuItem paramMenuItem, String paramString)
  {
    String str = paramMenuItem.a();
    Object localObject = paramMenuItem.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2130903343, null);
    ImageView localImageView2;
    TextView localTextView;
    ImageView localImageView1;
    if (a())
    {
      localView.setBackgroundResource(2130838905);
      localImageView2 = (ImageView)localView.findViewById(2131298198);
      localTextView = (TextView)localView.findViewById(2131298199);
      localImageView1 = (ImageView)localView.findViewById(2131298200);
      if (localObject == null) {
        break label224;
      }
      localImageView2.setImageDrawable((Drawable)localObject);
      label95:
      if (str == null) {
        break label243;
      }
      if (SubString.a(str) <= 10) {
        break label234;
      }
      localTextView.setText(SubString.a(str, 10, "..."));
    }
    int j;
    int i;
    for (;;)
    {
      localObject = paramMenuItem.b();
      j = paramMenuItem.a();
      if (!paramMenuItem.a()) {
        break label352;
      }
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130839563);
      localObject = new PopupMenu(super.getContext());
      i = 0;
      while (i < paramMenuItem.b())
      {
        ((PopupMenu)localObject).a(paramMenuItem.a(i));
        i += 1;
      }
      localView.setBackgroundResource(2130838496);
      localView.findViewById(2131298197).setVisibility(8);
      break;
      label224:
      localImageView2.setVisibility(8);
      break label95;
      label234:
      localTextView.setText(str);
      continue;
      label243:
      localTextView.setVisibility(8);
    }
    ((PopupMenu)localObject).a(new jfk(this, localImageView1, localTextView));
    ((PopupMenu)localObject).a(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener);
    localView.setOnTouchListener(new jfl(this, localImageView1));
    localView.setOnClickListener(new jfm(this, localImageView1, localTextView, (PopupMenu)localObject, paramString, j, str));
    for (;;)
    {
      i = this.b;
      this.b = (i + 1);
      if (i == 0) {
        localView.findViewById(2131298197).setVisibility(8);
      }
      return localView;
      label352:
      localView.setOnClickListener(new jfn(this, (String)localObject, j));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizUiPopupWindows == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizUiPopupWindows instanceof PopupMenuPA))
    {
      ((PopupMenuPA)this.jdField_a_of_type_ComTencentBizUiPopupWindows).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiPopupWindows.c();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentBizUiPopupWindows != null) {
      this.jdField_a_of_type_ComTencentBizUiPopupWindows.c();
    }
  }
  
  public void setCoverView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setMenuType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnBackClickListner(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\CustomMenuBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */