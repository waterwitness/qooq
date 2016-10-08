package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PhoneUnityVerifyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1001;
  private String jdField_a_of_type_JavaLangString;
  
  public PhoneUnityVerifyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      super.setResult(-1, paramIntent);
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904277);
    super.setTitle(getString(2131371001));
    this.leftView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131370486);
    this.rightViewText.setOnClickListener(this);
    paramBundle = (Button)super.findViewById(2131302149);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(this);
    }
    paramBundle = super.getIntent();
    if (paramBundle != null) {
      this.a = paramBundle.getStringExtra("url");
    }
    return true;
  }
  
  public boolean onBackEvent()
  {
    super.setResult(-1, new Intent());
    super.finish();
    super.overridePendingTransition(0, 2130968593);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302149: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("url", this.a);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("portraitOnly", true);
      paramView.putExtra("isShowAd", false);
      paramView.putExtra("needResult", true);
      paramView.putExtra("business", 16384L);
      super.startActivityForResult(paramView, 1001);
      return;
    }
    super.setResult(-1, new Intent());
    super.finish();
    super.overridePendingTransition(0, 2130968593);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PhoneUnityVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */