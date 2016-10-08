package com.tencent.mobileqq.startup.step;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class Update
  extends Step
  implements Handler.Callback
{
  private static final int M = 4;
  private static final int jdField_a_of_type_Int = 1;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 3, 25, 21, 22, 23, 32, 33 };
  private static final int b = 2;
  private static final int c = 3;
  private int N;
  private int O;
  private int P = 27500;
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  private int a()
  {
    double d2 = (System.currentTimeMillis() - this.jdField_a_of_type_Long) * 1.0D / this.P * (this.O - this.N) + this.N;
    double d1;
    if (d2 < this.N) {
      d1 = this.N;
    }
    do
    {
      return (int)d1;
      d1 = d2;
    } while (d2 <= this.O - 10);
    if (this.jdField_a_of_type_Double < this.O - 10) {}
    for (this.jdField_a_of_type_Double = (this.O - 10);; this.jdField_a_of_type_Double += (this.O - this.jdField_a_of_type_Double) / 10.0D)
    {
      d1 = this.jdField_a_of_type_Double;
      break;
    }
  }
  
  protected boolean a()
  {
    if (!BaseApplicationImpl.c) {
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    if (Build.VERSION.SDK_INT < 21)
    {
      String str = System.getProperty("java.vm.version");
      if ((str != null) && (!str.startsWith("1"))) {
        this.P += 30000;
      }
    }
    try
    {
      Thread.sleep(300L);
      boolean bool = Step.AmStepFactory.b(0, this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, jdField_a_of_type_ArrayOfInt).c();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      int i;
      do
      {
        return true;
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a;
        QLog.e("AutoMonitor", 1, "init");
        if (!(localObject2 instanceof InstallActivity))
        {
          if (localObject2 != null) {}
          for (paramMessage = localObject2.toString();; paramMessage = "no activity")
          {
            QLog.e("AutoMonitor", 1, paramMessage);
            return true;
          }
        }
        Object localObject1 = ((Activity)localObject2).findViewById(2131298408);
        localObject2 = (ViewGroup)((Activity)localObject2).findViewById(2131298407);
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (paramMessage.arg1 < 5)
          {
            localObject1 = this.jdField_a_of_type_AndroidOsHandler;
            localObject2 = this.jdField_a_of_type_AndroidOsHandler;
            i = paramMessage.arg1 + 1;
            paramMessage.arg1 = i;
            ((Handler)localObject1).sendMessageDelayed(((Handler)localObject2).obtainMessage(1, i, 0), 50L);
            return true;
          }
          QLog.e("AutoMonitor", 1, "no splash");
          return true;
        }
        ((View)localObject1).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a.getApplicationContext(), 2130904995, null));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304904));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304905));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("升级中，请耐心等待...");
        ((ViewGroup)localObject2).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.N = 0;
        this.O = 90;
        return true;
        i = a();
        if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidWidgetProgressBar.getProgress() > i);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a.getString(2131370827), new Object[] { Integer.valueOf(i) }));
      }
      if (i < 99)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 100L);
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
      return true;
    case 3: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.N = 90;
      this.O = 100;
      this.P = 8000;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, this.P);
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\Update.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */