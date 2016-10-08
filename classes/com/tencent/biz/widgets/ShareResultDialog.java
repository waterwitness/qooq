package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import jjp;
import jjq;

public class ShareResultDialog
  extends Dialog
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ShareResultDialog.IShareResultCallback jdField_a_of_type_ComTencentBizWidgetsShareResultDialog$IShareResultCallback;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public ShareResultDialog(Context paramContext)
  {
    super(paramContext, 2131558973);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setContentView(2130903350);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297843));
    this.b = ((TextView)super.findViewById(2131297844));
    this.c = ((TextView)super.findViewById(2131298214));
    this.d = ((TextView)super.findViewById(2131298215));
    this.e = ((TextView)super.findViewById(2131298216));
  }
  
  private void b(boolean paramBoolean)
  {
    int j = 8;
    QLog.i("ShareToQZone", 2, "width:" + this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width);
    TextView localTextView;
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      localTextView = this.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label122;
      }
      i = 8;
      label65:
      localTextView.setVisibility(i);
      localTextView = this.c;
      if (!this.jdField_a_of_type_Boolean) {
        break label127;
      }
      i = 0;
      label84:
      localTextView.setVisibility(i);
      localTextView = this.e;
      if (!this.jdField_a_of_type_Boolean) {
        break label133;
      }
    }
    label122:
    label127:
    label133:
    for (int i = j;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
      this.b.setVisibility(8);
      break;
      i = 0;
      break label65;
      i = 8;
      break label84;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.d != null) {
      this.d.setText(paramInt);
    }
  }
  
  public void a(ShareResultDialog.IShareResultCallback paramIShareResultCallback)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog$IShareResultCallback = paramIShareResultCallback;
  }
  
  public void a(String paramString)
  {
    if ((this.d != null) && (!TextUtils.isEmpty(paramString))) {
      this.d.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new jjp(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    if (this.e != null)
    {
      if (paramInt != 0) {
        this.e.setText(paramInt);
      }
    }
    else {
      return;
    }
    this.e.setText("");
  }
  
  public void b(String paramString)
  {
    if ((this.e != null) && (!TextUtils.isEmpty(paramString))) {
      this.e.setText(paramString);
    }
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      b(false);
      return;
    }
    b(true);
    this.b.setText(paramString);
    this.b.setOnClickListener(new jjq(this, paramOnClickListener));
  }
  
  public void c(int paramInt)
  {
    if (this.c != null) {
      this.c.setText(paramInt);
    }
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onBackPressed()
  {
    QLog.i("ShareResultDialog", 2, "onBackPressed");
    super.onBackPressed();
    ShareResultDialog.IShareResultCallback localIShareResultCallback;
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog$IShareResultCallback != null)
    {
      localIShareResultCallback = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog$IShareResultCallback;
      if (this.b.getVisibility() == 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      localIShareResultCallback.a(bool);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\biz\widgets\ShareResultDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */