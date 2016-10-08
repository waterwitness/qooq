package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.widget.BidirectionSeekBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gqf;
import gqg;

public class BeautyToolbar
  extends BaseToolbar
{
  static final String jdField_a_of_type_JavaLangString = "BeautyToolbar";
  public Context a;
  public Drawable a;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QAVPtvTemplateAdapter.IEffectCallback a;
  public BidirectionSeekBar a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public Drawable b;
  public boolean b;
  int c;
  public Drawable c;
  int d;
  public Drawable d;
  int e;
  
  public BeautyToolbar()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new gqf(this);
    this.jdField_a_of_type_Int = 2130903619;
  }
  
  int a(int paramInt)
  {
    return (paramInt + 9) / 10;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
      this.e = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      this.jdField_d_of_type_Int = (((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getLayoutParams()).leftMargin + this.e / 2);
    }
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getWidth();
    int j = this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getWidth();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (this.jdField_d_of_type_Int - i / 2 + (j - this.e) * paramInt / 100);
    this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "%");
  }
  
  protected void a(Context paramContext, QAVPtvTemplateAdapter.IEffectCallback paramIEffectCallback)
  {
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback = paramIEffectCallback;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299472));
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = ((BidirectionSeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299474));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839005);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839007);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839008);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839006);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setMax(100);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getViewTreeObserver().addOnGlobalLayoutListener(new gqg(this));
  }
  
  public void b(int paramInt)
  {
    try
    {
      GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(a(paramInt), 0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BeautyToolbar", 2, "BeautyToolbar UnsatisfiedLinkError! libqav_graphics.so no impl");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
    AVNotifyCenter.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int > 0)
    {
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if (localSessionInfo != null) {
        localSessionInfo.r = true;
      }
    }
  }
  
  public void d()
  {
    AVNotifyCenter.f(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    int i = AVNotifyCenter.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    this.jdField_c_of_type_Int = i;
    this.jdField_b_of_type_Int = i;
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = 10;
      this.jdField_c_of_type_Int = 0;
    }
    b(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setProgress(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363736));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\BeautyToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */