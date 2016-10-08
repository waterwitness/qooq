package cooperation.qwallet.plugin.proxy;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardHelper;
import yjv;
import yjw;
import yjx;

public class BaseNFCProxyActivity
  extends PluginProxyActivity
{
  private PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  private NfcAdapter jdField_a_of_type_AndroidNfcNfcAdapter;
  private boolean jdField_a_of_type_Boolean;
  private IntentFilter[] jdField_a_of_type_ArrayOfAndroidContentIntentFilter;
  private String[][] jdField_a_of_type_Array2dOfJavaLangString;
  
  public BaseNFCProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(String paramString1, String paramString2)
  {
    DialogUtil.a(this, 0, paramString1, paramString2, "下次再说", "设置", new yjw(this), new yjx(this)).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidNfcNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    if (this.jdField_a_of_type_AndroidNfcNfcAdapter == null) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_AndroidNfcNfcAdapter.isEnabled())
      {
        a("NFC未开启", "请在设置界面开启NFC功能");
        return;
      }
      this.jdField_a_of_type_Boolean = BuscardHelper.a(this);
    } while (this.jdField_a_of_type_Boolean);
    a("无NFC权限", "请重新打开手Q的NFC权限");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    paramIntent.putExtra("cleartop", true);
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("BaseNFCProxyActivity", 2, "onNewIntent");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    BuscardHelper.a(this, false, getIntent().getStringExtra("buscard_pluginNewNfcAPIFlag"), getIntent().getStringExtra("buscard_pluginNewNfcAPIBlackModel"));
  }
  
  protected void onResume()
  {
    super.onResume();
    String str1 = getIntent().getStringExtra("buscard_pluginNewNfcAPIFlag");
    String str2 = getIntent().getStringExtra("buscard_pluginNewNfcAPIBlackModel");
    if (Build.VERSION.SDK_INT < 19)
    {
      BuscardHelper.a(this, false, str1, str2, null);
      return;
    }
    BuscardHelper.a(this, false, str1, str2, new yjv(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\proxy\BaseNFCProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */