package com.tencent.av.ui;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioHelper;
import gss;
import java.lang.ref.WeakReference;

public class EffectSettingBtn
{
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  
  EffectSettingBtn(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new gss(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().at) {
      return false;
    }
    if (!UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
      return false;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0) {
      return false;
    }
    if (!this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299349).isEnabled()) {
      return false;
    }
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.e()) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().f == 2;
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().at = true;
    Object localObject = new TextView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    ((TextView)localObject).setBackgroundResource(2130839112);
    ((TextView)localObject).setText("特效变脸，换种花样来视频。");
    ((TextView)localObject).setTextColor(-16777216);
    ((TextView)localObject).setTextSize(1, 15.0F);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    ((TextView)localObject).setPadding(AIOUtils.a(9.25F, this.jdField_a_of_type_AndroidViewViewGroup.getResources()), AIOUtils.a(6.5F, this.jdField_a_of_type_AndroidViewViewGroup.getResources()), AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources()), AIOUtils.a(14.5F, this.jdField_a_of_type_AndroidViewViewGroup.getResources()));
    b();
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView((View)localObject);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131558623);
    localObject = new int[2];
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
    int i = (int)(this.jdField_a_of_type_AndroidViewViewGroup.getWidth() / 2.0D + 0.5D);
    int j = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
    int k = AIOUtils.a(40.5F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
    int m = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDisplayMetrics().widthPixels;
    int n = localObject[0];
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewViewGroup, 53, m - n - i - j, localObject[1] - k);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().at = true;
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    b();
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    AudioHelper.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), (Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299349), paramBoolean, 2130839051);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void c()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  void d()
  {
    b();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\EffectSettingBtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */