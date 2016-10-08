package cooperation.huangye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import yby;

public class C2BAuthorisationActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 0;
  public static final String a = "C2BAuthorisationActivity";
  public static final int b = 1;
  public static final String b = "app_id";
  public static final int c = 2;
  public static final String c = "scope";
  public static final int d = 3;
  public static final String d = "bind_state";
  public static final int e = 1024;
  public static final String e = "error_info";
  public static final int f = 10086;
  public static final String f = "token_info";
  public static final String g = "package_name";
  public static final String h = "sign_md5";
  private static final int i = 0;
  public static final String i = "param_callback";
  private static final int jdField_j_of_type_Int = 1;
  private static final int jdField_k_of_type_Int = 2;
  private static final int jdField_l_of_type_Int = 3;
  private static final int jdField_m_of_type_Int = 4;
  private static final int jdField_n_of_type_Int = 5;
  private static final int jdField_o_of_type_Int = 6;
  private static final int jdField_p_of_type_Int = 7;
  private static final String r = "首次使用人工客服，需要绑定你的手机号码";
  int g;
  int h;
  String jdField_j_of_type_JavaLangString;
  String jdField_k_of_type_JavaLangString;
  String jdField_l_of_type_JavaLangString;
  String jdField_m_of_type_JavaLangString;
  String jdField_n_of_type_JavaLangString;
  String jdField_o_of_type_JavaLangString;
  String jdField_p_of_type_JavaLangString;
  String q;
  
  public C2BAuthorisationActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = null;
    this.g = 2;
    this.k = "";
    this.l = "";
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.h = 0;
  }
  
  protected void a()
  {
    if (this.h == 7) {
      return;
    }
    Intent localIntent = new Intent("tencent.c2b.action.tel.authorisation");
    localIntent.putExtra("error_info", this.g);
    if (this.g == 0)
    {
      String str = "{" + "\"errCode\":\"" + this.l + "\"" + ",";
      str = str + "\"tokenInfo\":" + this.k;
      str = (str + "}").replace("\"", "\\\"");
      localIntent.putExtra("token_info", "\"" + str + "\"");
    }
    for (;;)
    {
      localIntent.putExtra("param_callback", this.p);
      localIntent.setPackage(getPackageName());
      sendBroadcast(localIntent);
      return;
      localIntent.putExtra("token_info", "\"\"");
    }
  }
  
  void b()
  {
    this.g = 3;
    this.h = 1;
    Intent localIntent = new Intent(this, C2BBindNumberActivity.class);
    SharedPreferences localSharedPreferences = this.app.a().getSharedPreferences("contact_bind_info" + this.app.getAccount(), 0);
    this.j = localSharedPreferences.getString("K_b_msg", "");
    localSharedPreferences.edit().putString("K_b_msg", "首次使用人工客服，需要绑定你的手机号码").commit();
    startActivityForResult(localIntent, 10086);
  }
  
  void c()
  {
    this.g = 2;
    this.h = 2;
    Intent localIntent = new Intent(this, C2BAuthorityActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("scope", this.q);
    localBundle.putString("client_id", this.m);
    localBundle.putString("package_name", this.n);
    localBundle.putString("sign", this.o);
    localIntent.putExtra("internal_authority", true);
    localIntent.putExtra("key_params", localBundle);
    startActivityForResult(localIntent, 1024);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2130843567);
    int i1 = Resources.getSystem().getIdentifier("title_container", "id", "android");
    paramBundle = (ViewGroup)getWindow().findViewById(i1);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = getLayoutInflater().inflate(2130903202, null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramBundle.setContentDescription("common_footerview_blank");
    addContentView(paramBundle, localLayoutParams);
    paramBundle.setClickable(true);
    paramBundle.setOnClickListener(new yby(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    a();
    this.h = 7;
    if (this.j != null) {
      this.app.a().getSharedPreferences("contact_bind_info" + this.app.getAccount(), 0).edit().putString("K_b_msg", this.j).commit();
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Intent localIntent = super.getIntent();
    this.m = localIntent.getStringExtra("app_id");
    this.q = localIntent.getStringExtra("scope");
    boolean bool = localIntent.getBooleanExtra("bind_state", true);
    this.n = localIntent.getStringExtra("package_name");
    this.o = localIntent.getStringExtra("sign_md5");
    this.p = localIntent.getStringExtra("param_callback");
    if ((this.m == null) || (this.m.equals("")))
    {
      QLog.d("C2BAuthorisationActivity", 1, "param appid is empty.");
      this.g = 1;
      finish();
    }
    do
    {
      while (this.h == 0) {
        if (bool)
        {
          c();
          return;
          if ((!bool) && ((this.n == null) || (this.n.equals("")) || (this.o == null) || (this.o.equals("")) || (this.p == null) || (this.p.equals(""))))
          {
            QLog.d("C2BAuthorisationActivity", 1, "param mPackageName is empty.");
            this.g = 1;
            finish();
          }
        }
        else
        {
          b();
          return;
        }
      }
    } while (this.h != 1);
    c();
  }
  
  public void finish()
  {
    QLog.d("C2BAuthorisationActivity", 2, "finish().");
    a();
    this.h = 7;
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (10086 == paramInt1) {
      if (paramInt2 == -1) {
        if ((this.h == 0) || (this.h == 1)) {
          c();
        }
      }
    }
    while (paramInt1 != 1024)
    {
      return;
      if (paramInt2 == 0)
      {
        this.g = 3;
        this.h = 3;
        finish();
        return;
      }
      QLog.d("onActivityResult", 4, "Bind_Phone_Result_Event unexcepted ret");
      this.g = 3;
      this.h = 4;
      finish();
      return;
    }
    if (paramInt2 == -1)
    {
      StringBuilder localStringBuilder = new StringBuilder("result:\n");
      localStringBuilder.append("key_error_code").append("=").append(paramIntent.getIntExtra("key_error_code", -1)).append("\n");
      localStringBuilder.append("key_error_msg").append("=").append(paramIntent.getStringExtra("key_error_msg")).append("\n");
      localStringBuilder.append("key_error_detail").append("=").append(paramIntent.getStringExtra("key_error_detail")).append("\n");
      localStringBuilder.append("key_response").append("=").append(paramIntent.getStringExtra("key_response"));
      QLog.d("see.test", 4, "" + localStringBuilder.toString());
      this.k = paramIntent.getStringExtra("key_response");
      this.l = Long.toString(paramIntent.getIntExtra("key_error_code", -1));
      this.g = 0;
      finish();
      return;
    }
    if (paramInt2 == 0)
    {
      this.g = 2;
      this.h = 5;
      finish();
      return;
    }
    QLog.d("onActivityResult", 4, "Auth_Result_Event unexcepted ret");
    this.g = 2;
    this.h = 6;
    finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\C2BAuthorisationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */