package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.widget.BidirectionSeekBar;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import gqb;
import gqc;
import gqd;
import gqe;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class BeautySettingUi
  implements SeekBar.OnSeekBarChangeListener
{
  static final String jdField_a_of_type_JavaLangString = "BeautySettingUi";
  int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface a;
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver;
  TipsManager jdField_a_of_type_ComTencentAvUtilsTipsManager;
  public BidirectionSeekBar a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public int c;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  
  BeautySettingUi(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    if (QLog.isDevelopLevel()) {
      QLog.d("BeautySettingUi", 2, "BeautySettingUi");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
  }
  
  public static boolean a(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoController.a().i) || (!paramVideoController.a().jdField_f_of_type_Boolean) || (!AVNotifyCenter.e(paramVideoAppInterface.a())) || (!paramVideoController.a().j)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  int a(int paramInt)
  {
    return (paramInt + 9) / 10;
  }
  
  void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BeautySettingUi", 2, "onCreate");
    }
    b();
    g();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams());
      this.jdField_b_of_type_Int = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_Int = (((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getLayoutParams()).leftMargin + this.jdField_b_of_type_Int / 2);
    }
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getWidth();
    int j = this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getWidth();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (this.jdField_a_of_type_Int - i / 2 + (j - this.jdField_b_of_type_Int) * paramInt / 100);
    this.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt + "%");
  }
  
  void a(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131299004: 
    case 2131299005: 
    default: 
      return;
    case 2131299006: 
      AVNotifyCenter.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(117) });
      if (this.jdField_c_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800501E", "0X800501E", 0, 0, "", "", "", "");
        if (this.jdField_c_of_type_Int == 0) {
          ReportController.b(null, "CliOper", "", "", "0X800501F", "0X800501F", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_c_of_type_Int <= 0) {
          break;
        }
        paramView = SessionMgr.a().a();
        if (paramView == null) {
          break;
        }
        paramView.r = true;
        return;
        ReportController.b(null, "CliOper", "", "", "0X8005019", "0X8005019", 0, 0, "", "", "", "");
        if (this.jdField_c_of_type_Int == 0) {
          ReportController.b(null, "CliOper", "", "", "0X800501A", "0X800501A", 0, 0, "", "", "", "");
        }
      }
    }
    a();
  }
  
  void a(TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = paramTipsManager;
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = paramBoolean;
    int i = AVNotifyCenter.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    this.jdField_d_of_type_Int = i;
    this.jdField_c_of_type_Int = i;
    if (this.jdField_c_of_type_Int == -1)
    {
      this.jdField_c_of_type_Int = 10;
      this.jdField_d_of_type_Int = 0;
    }
    d(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setProgress(this.jdField_c_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363734);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363735));
      ReportController.b(null, "CliOper", "", "", "0X800501C", "0X800501C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363736));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363732);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363733));
      ReportController.b(null, "CliOper", "", "", "0X8005017", "0X8005017", 0, 0, "", "", "", "");
    }
  }
  
  boolean a()
  {
    h();
    d(this.jdField_d_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(117) });
      return true;
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(true) });
    ReportController.b(null, "CliOper", "", "", "0X8005018", "0X8005018", 0, 0, "", "", "", "");
    return false;
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localAVActivity.getLayoutInflater().inflate(2130903527, this.jdField_a_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_AndroidContentResResources = localAVActivity.getResources();
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299003));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299006));
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = ((BidirectionSeekBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299007));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299008));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    if (this.jdField_a_of_type_AndroidContentResResources != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839005);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839007);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839008);
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839006);
    }
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setMax(100);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getViewTreeObserver().addOnGlobalLayoutListener(new gqb(this));
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeautySettingUi", 2, "onDetectNoDeviceLimits type ： " + paramInt);
    }
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramInt == 1) || (paramInt == 2))
    {
      String str = ((AVActivity)localObject).getString(2131363688);
      localObject = DialogUtil.a((Context)localObject, 230).setMessage(str).setPositiveButton(((AVActivity)localObject).getString(2131363687), new gqd(this, paramInt));
      ((QQCustomDialog)localObject).setOnDismissListener(new gqe(this, paramInt));
      ((QQCustomDialog)localObject).show();
    }
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void c()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
    if (i != -1) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.remove(i);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().h = 1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().K = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(117), Integer.valueOf(paramInt) });
    if (this.jdField_c_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X800501E", "0X800501E", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_Int == 0) {
        ReportController.b(null, "CliOper", "", "", "0X800501F", "0X800501F", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005019", "0X8005019", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_Int == 0) {
        ReportController.b(null, "CliOper", "", "", "0X800501A", "0X800501A", 0, 0, "", "", "", "");
      }
    }
  }
  
  boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  void d() {}
  
  public void d(int paramInt)
  {
    try
    {
      GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(a(paramInt), 0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BeautySettingUi", 2, "BeautySettingUi UnsatisfiedLinkError! libqav_graphics.so no impl");
    }
  }
  
  void e() {}
  
  void f()
  {
    d(0);
  }
  
  void g()
  {
    ThreadManager.a(new gqc(this), 5, null, false);
  }
  
  void h()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      d(paramInt);
      a(paramInt);
      if ((paramInt != 0) || (this.jdField_c_of_type_Int <= 0)) {
        break label88;
      }
      this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363736) + paramInt + "%");
      }
      this.jdField_c_of_type_Int = paramInt;
      return;
      label88:
      if ((paramInt > 0) && (paramInt <= 30) && ((this.jdField_c_of_type_Int <= 0) || (this.jdField_c_of_type_Int > 30))) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      } else if ((paramInt > 30) && (paramInt <= 60) && ((this.jdField_c_of_type_Int <= 30) || (this.jdField_c_of_type_Int > 60))) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      } else if ((paramInt > 60) && (paramInt <= 100) && ((this.jdField_c_of_type_Int <= 60) || (this.jdField_c_of_type_Int > 100))) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\BeautySettingUi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */