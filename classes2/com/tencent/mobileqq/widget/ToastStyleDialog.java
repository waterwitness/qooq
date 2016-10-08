package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ToastStyleDialog
  extends Dialog
{
  private static final int jdField_a_of_type_Int = 10;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ToastStyleDialog(Context paramContext)
  {
    super(paramContext, 2131558944);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    getWindow().setFlags(16, 16);
    getWindow().setFlags(8, 8);
    getWindow().setGravity(17);
    setContentView(2130904373);
    this.a = ((TextView)findViewById(2131297873));
    setCancelable(false);
  }
  
  public void a(int paramInt)
  {
    this.a.setMaxWidth(paramInt);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ToastStyleDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */