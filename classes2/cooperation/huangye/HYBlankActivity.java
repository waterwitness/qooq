package cooperation.huangye;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;
import ych;
import yci;
import ycj;

public class HYBlankActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 1;
  public Dialog a;
  AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  Map jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean;
  
  public HYBlankActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(Bundle paramBundle)
  {
    C2BUtils.a(this.app, this, paramBundle);
    return true;
  }
  
  private boolean b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("businessName");
    String str2 = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("directartificial");
    Intent localIntent = new Intent(this, ChatActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", str2);
    localBundle.putInt("uintype", 1008);
    localBundle.putString("uinname", str1);
    localBundle.putString("strDirectartificial", paramBundle);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("isforceRequestDetail", false);
    super.startActivity(localIntent);
    return true;
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      Object localObject = new yci(this);
      ycj localycj = new ycj(this);
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903236);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297840);
      if (localObject != null) {
        ((TextView)localObject).setText("呼叫错误");
      }
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852)).setText(paramString);
      paramString = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297843);
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297844);
      if (paramString != null)
      {
        paramString.setText(2131367263);
        paramString.setOnClickListener(localycj);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return super.isDestroyed();
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(String paramString)
  {
    a(paramString);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    this.jdField_a_of_type_Boolean = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2130843567);
    int i = Resources.getSystem().getIdentifier("title_container", "id", "android");
    paramBundle = (ViewGroup)getWindow().findViewById(i);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = getLayoutInflater().inflate(2130903202, null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramBundle.setContentDescription("common_footerview_blank");
    addContentView(paramBundle, localLayoutParams);
    paramBundle.setClickable(true);
    paramBundle.setOnClickListener(new ych(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    boolean bool = false;
    super.doOnResume();
    Bundle localBundle = super.getIntent().getBundleExtra("Bundle");
    if (super.getIntent().getBooleanExtra("bHadInit", false)) {
      super.finish();
    }
    for (;;)
    {
      return;
      super.getIntent().putExtra("bHadInit", true);
      String str = localBundle.getString("invoke_cmd");
      if (str.equals("BusinessHandler_voiceCall")) {
        bool = a(localBundle);
      }
      while (!bool)
      {
        super.finish();
        return;
        if (str.equals("BusinessHandler_enterChat")) {
          bool = b(localBundle);
        }
      }
    }
  }
  
  public void setImmersiveStatus() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYBlankActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */