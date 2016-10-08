package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class CarrierADView
  extends ADView
  implements Handler.Callback
{
  public static final String a = "CarrierADView";
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private IFlingSwitch jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public CarrierADView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CarrierADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a();
    }
    return i;
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.b.getChildCount() == 0)
    {
      this.b.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.e);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      this.b.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
        return;
      }
      catch (Exception paramView) {}
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)this.b.getChildAt(0)).getChildAt(0));
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 3000L);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getWidth() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a() + 1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 'ൈ');
      return false;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    return false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch != null)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label56;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch.a(false);
      i();
      if (this.jdField_a_of_type_AndroidViewMotionEvent != null) {
        this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    label56:
    do
    {
      return false;
      if (i == 2)
      {
        if (this.jdField_a_of_type_AndroidViewMotionEvent != null)
        {
          float f1 = this.jdField_a_of_type_AndroidViewMotionEvent.getX();
          float f2 = paramMotionEvent.getX();
          if (Math.abs((this.jdField_a_of_type_AndroidViewMotionEvent.getY() - paramMotionEvent.getY()) / (f1 - f2)) < 0.5F) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
    } while ((i != 1) && (i != 3));
    this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch.a(true);
    h();
    getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void setCarrierData(List paramList, int paramInt, CarrierHelper paramCarrierHelper)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
    }
    g();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CarrierADView", 2, "carrier List is null or empty");
      }
      setVisibility(8);
      return;
    }
    while (paramInt > 0)
    {
      paramList.add(paramList.get(0));
      paramList.remove(0);
      paramInt -= 1;
    }
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt < paramList.size()) {
        try
        {
          View localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2130904223, null);
          paramCarrierHelper.a(localView, (AdData)paramList.get(paramInt));
          b(localView, paramInt);
          paramInt += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CarrierADView", 2, localException.toString());
            }
          }
        }
      }
    }
    h();
  }
  
  public void setFlingSwitch(IFlingSwitch paramIFlingSwitch)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch = paramIFlingSwitch;
  }
  
  public void setVisibility(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 4)) {
      i();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setVisibility(paramInt);
      }
      super.setVisibility(paramInt);
      return;
      h();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\CarrierADView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */