package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class AbstractOrientationEventListener
  extends OrientationEventListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  protected Context a;
  Configuration jdField_a_of_type_AndroidContentResConfiguration;
  Display jdField_a_of_type_AndroidViewDisplay;
  boolean jdField_a_of_type_Boolean;
  int b;
  public boolean b;
  
  public AbstractOrientationEventListener(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -25;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResConfiguration = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_a_of_type_Boolean = PhoneStatusTools.g(paramContext);
  }
  
  int a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 1000L)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      this.jdField_a_of_type_Long = l;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1)
    {
      if (this.jdField_a_of_type_Int != paramInt) {}
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    if (this.jdField_a_of_type_Int < 0) {
      this.jdField_a_of_type_Int = 0;
    }
    label88:
    int i;
    if ((this.jdField_a_of_type_AndroidContentResConfiguration.orientation == 2) || ((this.jdField_a_of_type_AndroidContentResConfiguration.orientation == 1) && (paramInt > 134) && (paramInt < 225) && (a() == 2)))
    {
      this.jdField_b_of_type_Boolean = true;
      a(this.jdField_b_of_type_Boolean);
      if ((paramInt - this.jdField_a_of_type_Int < 20) && (paramInt - this.jdField_a_of_type_Int > -20) && (!this.jdField_b_of_type_Boolean)) {
        break label241;
      }
      i = paramInt;
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt -= 90;
        i = paramInt;
        if (paramInt < 0) {
          i = paramInt + 360;
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label243;
      }
    }
    label241:
    label243:
    for (paramInt = ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90;; paramInt = ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90)
    {
      int j = paramInt;
      if (paramInt > 360) {
        j = paramInt % 360;
      }
      i -= j;
      paramInt = i;
      if (i < 0) {
        paramInt = i + 360;
      }
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt <= 314) && (paramInt >= 45)) {
        break label264;
      }
      a(0, this.jdField_b_of_type_Boolean);
      return;
      this.jdField_b_of_type_Boolean = false;
      a(this.jdField_b_of_type_Boolean);
      break label88;
      break;
    }
    label264:
    if ((paramInt > 44) && (paramInt < 135))
    {
      a(90, this.jdField_b_of_type_Boolean);
      return;
    }
    if ((paramInt > 134) && (paramInt < 225))
    {
      a(180, this.jdField_b_of_type_Boolean);
      return;
    }
    a(270, this.jdField_b_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\AbstractOrientationEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */