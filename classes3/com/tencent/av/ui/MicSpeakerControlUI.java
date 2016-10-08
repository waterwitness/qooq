package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import guq;
import java.lang.ref.WeakReference;

public class MicSpeakerControlUI
  extends DoubleVideoCtrlUI
{
  static final String b = "MicSpeakerControlUI";
  final int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  final int d;
  final int e;
  
  public MicSpeakerControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver, String paramString)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.d = 1;
    this.e = 2;
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  protected int a()
  {
    return 2130903535;
  }
  
  public void a(View paramView)
  {
    if ((paramView.getId() == 2131299013) || (paramView.getId() == 2131299025))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MicSpeakerControlUI", 2, "onClick view.getId = " + paramView.getId());
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      while ((this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().w)) {
        return;
      }
      guq localguq = new guq(this, 0, paramView);
      paramView = new guq(this, 1, paramView);
      DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230, null, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131363623), 2131363161, 2131363538, localguq, paramView).show();
      return;
    }
    super.a(paramView);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (int i = UITools.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());; i = 0)
    {
      Object localObject2 = (RelativeLayout)this.b.findViewById(2131299045);
      int j;
      TextView localTextView;
      Object localObject1;
      if (i <= 800)
      {
        j = DisplayUtil.a(((RelativeLayout)localObject2).getContext(), 26.0F);
        localTextView = new TextView(((RelativeLayout)localObject2).getContext());
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, j, 0, 0);
        localTextView.setId(2131297123);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localTextView.setTextColor(-12297620);
        localTextView.setTextSize(1, 22.0F);
        ((RelativeLayout)localObject2).addView(localTextView);
        localObject1 = new RelativeLayout(((RelativeLayout)localObject2).getContext());
        if (i > 800) {
          break label407;
        }
      }
      label407:
      for (i = DisplayUtil.a(((RelativeLayout)localObject2).getContext(), 166.0F);; i = DisplayUtil.a(((RelativeLayout)localObject2).getContext(), 212.0F))
      {
        Object localObject3 = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(0, DisplayUtil.a(((RelativeLayout)localObject2).getContext(), 80.0F), 0, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((RelativeLayout.LayoutParams)localObject3).addRule(14);
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RelativeLayout)localObject2).addView((View)localObject1);
        localObject3 = new QavPanelSoundWaveView(((RelativeLayout)localObject2).getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ((QavPanelSoundWaveView)localObject3).setId(2131297013);
        localLayoutParams.setMargins(0, 0, 0, 0);
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(14);
        ((QavPanelSoundWaveView)localObject3).setLayoutParams(localLayoutParams);
        ((QavPanelSoundWaveView)localObject3).setRoundStyle(true);
        ((RelativeLayout)localObject1).addView((View)localObject3);
        localObject2 = new ImageView(((RelativeLayout)localObject2).getContext());
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ((ImageView)localObject2).setId(2131300338);
        localLayoutParams.setMargins(0, 0, 0, 0);
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(14);
        ((ImageView)localObject2).setLayoutParams(localLayoutParams);
        ((RelativeLayout)localObject1).addView((View)localObject2);
        localTextView.setText(2131363622);
        ((ImageView)localObject2).setBackgroundResource(2130839214);
        ((QavPanelSoundWaveView)localObject3).f();
        return;
        j = DisplayUtil.a(((RelativeLayout)localObject2).getContext(), 36.0F);
        break;
      }
    }
  }
  
  public void d()
  {
    super.d();
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && (AVActivity.class.isInstance(localObject))) {
      localObject = (AVActivity)localObject;
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  void g(int paramInt)
  {
    super.g(paramInt);
  }
  
  public void k()
  {
    this.i = null;
    super.k();
  }
  
  public void m()
  {
    super.m();
    TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    TraeHelper.a().b("DEVICE_SPEAKERPHONE");
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
  }
  
  void u_()
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = new QQFrameByFrameAnimation();
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(100);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.c(8);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(new int[] { 2130839040, 2130839041 });
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MicSpeakerControlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */