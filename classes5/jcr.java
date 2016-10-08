import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class jcr
  implements BusinessObserver
{
  public jcr(AppActivity paramAppActivity, String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean1, ScannerView paramScannerView, View paramView, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    if (!this.jdField_a_of_type_MqqAppAppActivity.isResume()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2;
    Object localObject3;
    label224:
    int i;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("result");
      localObject2 = localObject1;
      paramInt = j;
      for (;;)
      {
        try
        {
          paramBundle = new JSONObject(paramBundle);
          localObject2 = localObject1;
          paramInt = j;
          localObject3 = localObject1;
          if (paramBundle.getInt("r") != 0) {
            break label879;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("d")) {
            break label546;
          }
          localObject2 = localObject1;
          paramInt = j;
          localObject3 = new QRActionEntity(paramBundle.getString("d"));
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("wpa")) {
            break label535;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!"1".equals(paramBundle.getString("wpa"))) {
            break label535;
          }
          paramBoolean = true;
          localObject2 = localObject1;
          paramInt = j;
          bool = paramBundle.has("extvalue");
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("exttype")) {
            break label540;
          }
          localObject2 = localObject1;
          paramInt = j;
          if ("2".equals(paramBundle.getString("exttype"))) {
            break label895;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!"1".equals(paramBundle.getString("exttype"))) {
            break label540;
          }
        }
        catch (Exception paramBundle)
        {
          boolean bool;
          Bundle localBundle;
          String str;
          paramBundle = (Bundle)localObject2;
        }
        localObject2 = localObject1;
        paramInt = j;
        localBundle = new Bundle();
        if (paramBoolean)
        {
          localObject2 = localObject1;
          paramInt = j;
          localBundle.putBoolean("issupportwpa", paramBoolean);
        }
        if ((i != 0) && (bool))
        {
          localObject2 = localObject1;
          paramInt = j;
          str = paramBundle.getString("exttype");
          localObject2 = localObject1;
          paramInt = j;
          paramBundle = paramBundle.getString("extvalue");
          localObject2 = localObject1;
          paramInt = j;
          localBundle.putString("exttype", str);
          localObject2 = localObject1;
          paramInt = j;
          localBundle.putString("extvalue", paramBundle);
        }
        localObject2 = localObject1;
        paramInt = j;
        i = QRResultHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, (QRActionEntity)localObject3, this.jdField_a_of_type_JavaLangString, localBundle);
        localObject2 = localObject1;
        paramInt = i;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = localObject1;
          paramInt = i;
          this.jdField_a_of_type_MqqAppAppActivity.finish();
        }
        localObject2 = localObject1;
        paramInt = i;
        ScannerUtils.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject2 = localObject1;
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView.jdField_a_of_type_Boolean != true) {
          break;
        }
        localObject2 = localObject1;
        paramInt = i;
        this.jdField_a_of_type_MqqAppAppActivity.finish();
        return;
        label446:
        localObject1 = DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
        ((QQCustomDialog)localObject1).setTitle(2131364468);
        ((QQCustomDialog)localObject1).setMessage(paramBundle);
        localObject2 = new jcs(this);
        ((QQCustomDialog)localObject1).setPositiveButton(2131367263, new jct(this, paramBundle));
        ((QQCustomDialog)localObject1).setNegativeButton(2131367262, (DialogInterface.OnClickListener)localObject2);
        ((QQCustomDialog)localObject1).setOnCancelListener((DialogInterface.OnCancelListener)localObject2);
        ((QQCustomDialog)localObject1).show();
        ScannerUtils.a(paramInt, paramBundle, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        label535:
        paramBoolean = false;
        continue;
        label540:
        i = 0;
      }
      label546:
      localObject2 = localObject1;
      paramInt = j;
      if (paramBundle.has("a_a"))
      {
        localObject2 = localObject1;
        paramInt = j;
        paramBundle = paramBundle.getString("a_a");
        localObject2 = localObject1;
        paramInt = j;
        paramBundle = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, paramBundle);
        localObject3 = localObject1;
        if (paramBundle != null)
        {
          localObject2 = localObject1;
          paramInt = j;
          paramBundle.b();
        }
      }
      else
      {
        localObject2 = localObject1;
        paramInt = j;
        localObject3 = localObject1;
        if (paramBundle.has("url"))
        {
          localObject2 = localObject1;
          paramInt = j;
          i = paramBundle.getInt("url_level");
          localObject2 = localObject1;
          paramInt = j;
          paramBundle = paramBundle.getString("url");
          localObject2 = localObject1;
          paramInt = j;
          if (TextUtils.isEmpty(paramBundle)) {
            break label923;
          }
          if (i != 2) {
            break label917;
          }
          localObject2 = localObject1;
          paramInt = j;
          paramBundle = Uri.parse(paramBundle).toString();
          paramInt = i;
          break label901;
        }
      }
    }
    label879:
    label895:
    label901:
    label917:
    label923:
    label929:
    for (;;)
    {
      localObject2 = paramBundle;
      paramInt = j;
      localObject1 = new Intent(this.jdField_a_of_type_MqqAppAppActivity, PublicAccountBrowser.class);
      localObject2 = paramBundle;
      paramInt = j;
      ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      localObject2 = paramBundle;
      paramInt = j;
      ((Intent)localObject1).putExtra("fromQrcode", true);
      localObject2 = paramBundle;
      paramInt = j;
      ((Intent)localObject1).putExtra("url", paramBundle);
      localObject2 = paramBundle;
      paramInt = j;
      if (this.jdField_a_of_type_MqqAppAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true)
      {
        localObject2 = paramBundle;
        paramInt = j;
        this.jdField_a_of_type_MqqAppAppActivity.startActivityForResult((Intent)localObject1, 2);
      }
      for (;;)
      {
        localObject2 = paramBundle;
        paramInt = j;
        ScannerUtils.a(0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject2 = paramBundle;
        paramInt = j;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localObject2 = paramBundle;
        paramInt = j;
        this.jdField_a_of_type_MqqAppAppActivity.finish();
        return;
        localObject2 = paramBundle;
        paramInt = j;
        this.jdField_a_of_type_MqqAppAppActivity.startActivity((Intent)localObject1);
      }
      paramBundle = (Bundle)localObject3;
      paramInt = 0;
      break label446;
      paramBundle = (Bundle)localObject1;
      paramInt = 0;
      break label446;
      i = 1;
      break label224;
      for (;;)
      {
        if (paramInt == 1) {
          break label929;
        }
        localObject3 = paramBundle;
        if (paramInt != 2) {
          break label879;
        }
        break;
        paramInt = i;
        continue;
        paramInt = 0;
        paramBundle = (Bundle)localObject1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */