package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import jjm;
import jjn;
import jjo;

public class ShareAioResultDialog
  extends Dialog
{
  public static final int a = 0;
  public static final int b = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public ShareAioResultDialog(Context paramContext)
  {
    super(paramContext, 2131558973);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.setContentView(2130903794);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297843));
    this.b = ((TextView)super.findViewById(2131297844));
    this.c = ((TextView)super.findViewById(2131298214));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300095));
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if (ChatActivityConstants.I)
    {
      Resources localResources = getContext().getResources();
      this.b.setContentDescription(localResources.getString(2131367040, new Object[] { localResources.getString(2131364593) }));
    }
    this.b.setOnClickListener(new jjn(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (ChatActivityConstants.I)
    {
      Resources localResources = getContext().getResources();
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setContentDescription(localResources.getString(2131367040, new Object[] { str }));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new jjm(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.b.setText(paramString);
    if (ChatActivityConstants.I)
    {
      Resources localResources = getContext().getResources();
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setContentDescription(localResources.getString(2131367040, new Object[] { str }));
    }
    this.b.setOnClickListener(new jjo(this, paramOnClickListener));
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
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\widgets\ShareAioResultDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */