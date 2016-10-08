package cooperation.qlink;

import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import yfe;
import yff;
import yfg;
import yfh;
import yfi;
import yfj;
import yfk;
import yfl;
import yfm;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  public static final int a = 4;
  static final String jdField_a_of_type_JavaLangString = "QlinkStandardDialogActivity";
  public static final int b = 7;
  public static final int c = 8;
  public static final int d = 9;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public QlinkStandardDialogActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new yff(this);
  }
  
  private void a()
  {
    Object localObject = new yfg(this);
    localObject = DialogUtil.a(this, 230, getString(2131366274), getString(2131366237), 2131366235, 2131366235, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = DialogUtil.a(this, 230, getString(2131366361), "是否添加[" + paramString2 + "]为好友？", 2131366236, 2131366362, new yfl(this, paramString1, paramString2), new yfm(this));
    paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    paramString1.show();
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    yfj localyfj = new yfj(this);
    yfk localyfk = new yfk(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2)) {
        str = ContactUtils.k(this.app, paramString1);
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131366246) + str + getString(2131366247) + paramInt + getString(2131366248) + paramString3 + getString(2131366249) + paramString4 + "。";; paramString1 = getString(2131366250) + str + getString(2131366251) + paramInt + getString(2131366252) + paramString3 + getString(2131366253) + paramString4 + "。")
    {
      paramString1 = DialogUtil.a(this, 230, getString(2131366274), paramString1, 2131366254, 2131366255, localyfk, localyfj);
      paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString1.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    yfh localyfh = new yfh(this);
    yfi localyfi = new yfi(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 2131366245;; i = 2131366244)
    {
      paramString = DialogUtil.a(this, 230, getString(2131366274), paramString, 2131366236, i, localyfi, localyfh);
      paramString.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString.show();
      return;
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.app != null) && (this.app.a() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {
      this.app.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = SplashActivity.sTopActivity;
    super.onCreate(paramBundle);
    if (this.app == null)
    {
      QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app=null");
      return;
    }
    setTitle(null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.qlink.finishdlg");
    if (this.app.a() != null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yfe(this);
      this.app.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    for (;;)
    {
      switch (getIntent().getIntExtra("str_type", 0))
      {
      default: 
        finish();
        return;
        QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app.getapp()=null");
      }
    }
    a(getIntent().getBooleanExtra("param_send", false), getIntent().getBooleanExtra("_INIT_SEND_IOS_", false), getIntent().getStringExtra("_DLG_CONTENT_"));
    this.app.a().h();
    return;
    a(getIntent().getBooleanExtra("param_send", false), getIntent().getStringExtra("param_uin"), getIntent().getStringExtra("param_nick"), getIntent().getIntExtra("param_transcount", 0), getIntent().getStringExtra("param_jsliuliang"), getIntent().getStringExtra("param_pjspeed"));
    this.app.a().h();
    return;
    a();
    return;
    paramBundle = getIntent().getStringExtra("_ADD_UIN_NICK_");
    a(getIntent().getStringExtra("_ADD_UIN_"), paramBundle);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlinkStandardDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */