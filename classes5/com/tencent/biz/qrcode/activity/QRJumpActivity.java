package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.net.URLDecoder;
import jcb;
import jcc;
import mqq.app.NewIntent;

public class QRJumpActivity
  extends BaseActivity
{
  protected QQProgressDialog a;
  
  public QRJumpActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent().getStringExtra("url");
    if (TextUtils.isEmpty(paramBundle)) {
      finish();
    }
    while (isFinishing()) {
      return false;
    }
    this.a = new QQProgressDialog(this, super.getTitleBarHeight());
    this.a.b(2131364470);
    this.a.setOnCancelListener(new jcb(this));
    this.a.show();
    String str = URLDecoder.decode(paramBundle);
    paramBundle = Uri.parse(str);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getQueryParameter("auth"))
    {
      paramBundle = new jcc(this, paramBundle, this, str);
      NewIntent localNewIntent = new NewIntent(this, QRCodeServlet.class);
      localNewIntent.putExtra("d", str);
      localNewIntent.putExtra("cmd", "QRCodeSvc.decode");
      localNewIntent.putExtra("bqq", "1");
      localNewIntent.setObserver(paramBundle);
      this.app.startServlet(localNewIntent);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.doOnDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\QRJumpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */