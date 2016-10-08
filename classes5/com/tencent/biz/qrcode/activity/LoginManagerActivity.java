package com.tencent.biz.qrcode.activity;

import QQService.SvcReqKikOut;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import jaq;
import jar;
import mqq.app.NewIntent;

public class LoginManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected TextView b;
  
  public LoginManagerActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.app.isLogin())
    {
      Object localObject2 = this.app.a();
      localObject1 = new UniPacket(true);
      ((UniPacket)localObject1).setEncodeName("utf-8");
      int i = MobileQQService.c;
      MobileQQService.c = i + 1;
      ((UniPacket)localObject1).setRequestId(i);
      SvcReqKikOut localSvcReqKikOut = new SvcReqKikOut(Long.parseLong((String)localObject2), 1L, (byte)0, new byte[0]);
      ((UniPacket)localObject1).setServantName("StatSvc");
      ((UniPacket)localObject1).setFuncName("SvcReqKikOut");
      ((UniPacket)localObject1).put("req", localSvcReqKikOut);
      localObject2 = new ToServiceMsg("mobileqq.service", (String)localObject2, "StatSvc.SvcReqKikOut");
      ((ToServiceMsg)localObject2).putWupBuffer(((UniPacket)localObject1).encode());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      localObject1 = new NewIntent(this.app.getApplication(), TempServlet.class);
      ((NewIntent)localObject1).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)localObject2);
      this.app.startServlet((NewIntent)localObject1);
    }
    QQToast.a(this, -1, 2131364440, 0).a();
    super.finish();
    Object localObject1 = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    ((Intent)localObject1).putExtra("status", "logout");
    super.sendBroadcast((Intent)localObject1);
  }
  
  public void onClick(View paramView)
  {
    paramView = DialogUtil.a(this, 230);
    paramView.setMessage(2131364439);
    paramView.setPositiveButton(2131364469, new jaq(this));
    paramView.setNegativeButton(2131367262, new jar(this));
    paramView.show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903782);
    super.setTitle(2131364437);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300053));
    this.b = ((TextView)findViewById(2131300050));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300056));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300049));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = this.app.a();
    this.b.setText(ContactUtils.i(this.app, paramBundle));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364434, new Object[] { getIntent().getStringExtra("loginInfo") }));
    paramBundle = FaceDrawable.a(this.app, paramBundle, (byte)3);
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\LoginManagerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */