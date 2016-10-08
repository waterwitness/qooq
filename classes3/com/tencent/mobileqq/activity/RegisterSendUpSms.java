package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mjf;
import mjg;
import mjh;
import mji;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class RegisterSendUpSms
  extends RegisterBaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "RegisterSendUpSms";
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "tips";
  private static final int jdField_c_of_type_Int = 1;
  private static final String jdField_c_of_type_JavaLangString = "upmsg";
  private static final int jdField_d_of_type_Int = 2;
  private static final String g = "upnum";
  private static final String h = "prompt";
  private static final String i = "button1";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public RegisterSendUpSms()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_MqqOsMqqHandler = new mjf(this);
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_MqqObserverAccountObserver = new mji(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.b)
      {
        b();
        return;
      }
      b(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.j);
      return;
    }
    c(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.j);
  }
  
  private void a(String paramString)
  {
    int n = 0;
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject1 = paramString.getString("tips");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (TextView)super.findViewById(2131304729);
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      this.j = paramString.getString("upmsg");
      if (!TextUtils.isEmpty(this.j))
      {
        localObject1 = (TextView)super.findViewById(2131304732);
        if (localObject1 != null) {
          ((TextView)localObject1).setText(this.j);
        }
      }
      this.k = paramString.getString("upnum");
      if (!TextUtils.isEmpty(this.k))
      {
        localObject1 = (TextView)super.findViewById(2131304733);
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          int i2 = this.k.length() / 4;
          int i1 = 0;
          while (n < i2)
          {
            ((StringBuilder)localObject2).append(this.k.substring(i1, i1 + 4));
            ((StringBuilder)localObject2).append(" ");
            i1 += 4;
            n += 1;
          }
          ((StringBuilder)localObject2).append(this.k.substring(i1));
          ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        }
      }
      localObject1 = paramString.getString("prompt");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (TextView)super.findViewById(2131304735);
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      paramString = paramString.getString("button1");
      if (!TextUtils.isEmpty(paramString)) {
        this.l = paramString;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getResources().getString(2131368561, new Object[] { this.m }));
    localActionSheet.c(2131368562);
    localActionSheet.c(getResources().getString(2131368563, new Object[] { this.m }));
    localActionSheet.d(2131367262);
    localActionSheet.a(new mjh(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramQQAppInterface = new Intent(this, RegisterByNicknameAndPwdActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_now_account", paramString3);
    paramQQAppInterface.putExtra("key_register_smscode", paramString4);
    startActivity(paramQQAppInterface);
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramQQAppInterface = new Intent(paramContext, RegisterPersonalInfoActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_now_account", paramString3);
    paramQQAppInterface.putExtra("key_register_smscode", paramString4);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_f_of_type_Int == 0)
    {
      paramView = new Intent("android.intent.action.VIEW");
      paramView.setData(Uri.parse("smsto:"));
      paramView.setType("vnd.android-dir/mms-sms");
      paramView.putExtra("address", this.k);
      paramView.putExtra("sms_body", this.j);
      super.startActivity(paramView);
      if ((!TextUtils.isEmpty(this.l)) && (this.jdField_a_of_type_AndroidWidgetButton != null)) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.l);
      }
      this.jdField_f_of_type_Int = 1;
    }
    while (this.jdField_f_of_type_Int != 1) {
      return;
    }
    if (this.jdField_e_of_type_Int == 0)
    {
      a();
      return;
    }
    paramView = (AccountManager)this.app.getManager(0);
    if (paramView != null) {
      paramView.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentViewB(2130904918);
    setTitle(2131368520);
    this.app.a(RegisterSendUpSms.class, this.jdField_a_of_type_MqqOsMqqHandler);
    Intent localIntent = super.getIntent();
    if (localIntent != null)
    {
      this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("phonenum");
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("key");
      this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("key_register_now_account");
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
      this.b = getIntent().getBooleanExtra("key_register_has_pwd", true);
      this.m = getIntent().getStringExtra("key_register_binded_qq");
    }
    this.j = super.getString(2131368523);
    this.k = super.getString(2131368525);
    this.l = super.getString(2131368528);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131304736));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    paramBundle = (TextView)super.findViewById(2131304734);
    if (paramBundle != null)
    {
      String str = super.getString(2131368531);
      SpannableString localSpannableString = SpannableString.valueOf(str);
      localSpannableString.setSpan(new mjg(this, str), 0, str.length(), 33);
      paramBundle.setText(localSpannableString);
      paramBundle.setContentDescription(localSpannableString);
      paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131304737));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131304738));
    paramBundle = "";
    if (localIntent != null) {
      paramBundle = localIntent.getStringExtra("key_register_prompt_info");
    }
    if (!TextUtils.isEmpty(paramBundle)) {
      a(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.a(RegisterSendUpSms.class);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\RegisterSendUpSms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */