package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gvg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiVideoEnterPageMembersControlUI
  extends MultiMembersVideoUI
{
  public static int c;
  public static int e = 2;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  public ProgressBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public TextView c;
  int f = e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_Int = 1;
  }
  
  public MultiVideoEnterPageMembersControlUI(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    a(paramContext);
  }
  
  public MultiVideoEnterPageMembersControlUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    a(paramContext);
  }
  
  void a(int paramInt)
  {
    this.f = paramInt;
    d();
    if (this.f == jdField_c_of_type_Int)
    {
      localDrawable = super.getResources().getDrawable(2130839215);
      paramInt = (int)(super.getResources().getDisplayMetrics().density * 20.0F);
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    }
    while (this.f != e) {
      return;
    }
    Drawable localDrawable = super.getResources().getDrawable(2130839216);
    paramInt = (int)(super.getResources().getDisplayMetrics().density * 20.0F);
    localDrawable.setBounds(0, 0, paramInt, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)localBaseActivity.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      localBaseActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      localBaseActivity.finish();
      return;
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    LayoutInflater.from(paramContext).inflate(2130903585, this);
    this.jdField_a_of_type_AndroidViewView = this;
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131299186));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131299184));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299340));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299341));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131299342);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299327));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
    this.jdField_a_of_type_AndroidWidgetGridView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Gvg = new gvg(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Gvg);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299326));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131299325));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void a(ArrayList paramArrayList)
  {
    super.a(paramArrayList);
    d();
  }
  
  void d()
  {
    if (this.f == jdField_c_of_type_Int)
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (i > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(" 群视频(%d人)", new Object[] { Integer.valueOf(i) }));
        this.jdField_b_of_type_AndroidWidgetTextView.setText("全民群视频，礼物送不停");
        this.jdField_a_of_type_AndroidWidgetButton.setText("加入视频");
      }
    }
    while (this.f != e) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(" 群视频");
      }
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i > 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(" QQ电话(%d人)", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("多人通话，支持远程演示");
      this.jdField_a_of_type_AndroidWidgetButton.setText("加入通话");
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(" QQ电话");
    }
  }
  
  public void setLowHeightMode()
  {
    float f1 = super.getResources().getDisplayMetrics().density;
    if (super.getResources().getDisplayMetrics().heightPixels / f1 < 600.0F)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(10.0F * f1), 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(4.0F * f1), 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(10.0F * f1), 0, 0);
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(10.0F * f1), 0, (int)(f1 * 20.0F));
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiVideoEnterPageMembersControlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */