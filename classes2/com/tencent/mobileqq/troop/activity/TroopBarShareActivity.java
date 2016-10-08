package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import viu;
import viv;

public class TroopBarShareActivity
  extends QQBrowserActivity
{
  protected long a;
  protected Context a;
  protected Handler a;
  protected String a;
  public String b;
  
  public TroopBarShareActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = this;
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("share_app_name");
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("share_app_id", 0L);
    this.b = paramBundle.getStringExtra("bid");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new viu(this), 300L);
    return i;
  }
  
  public void a()
  {
    if (isFinishing()) {
      return;
    }
    ShareAioResultDialog localShareAioResultDialog = new ShareAioResultDialog(this);
    localShareAioResultDialog.a(getString(2131364968));
    Object localObject2 = getString(2131364595);
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangString != null) {
      localObject1 = (String)localObject2 + this.jdField_a_of_type_JavaLangString;
    }
    localObject2 = new viv(this);
    String str = getString(2131364967);
    localShareAioResultDialog.a((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    localShareAioResultDialog.b(str, (DialogInterface.OnClickListener)localObject2);
    localShareAioResultDialog.show();
  }
  
  public void finish()
  {
    super.finish();
    TroopBarShareUtils.b(this, this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */