import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.lang.ref.WeakReference;

class jii
  implements Runnable
{
  jii(jih paramjih, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (WebUiBaseInterface)Share.a(this.jdField_a_of_type_Jih.jdField_a_of_type_ComTencentBizWebviewpluginShare).get();
    String str1;
    String str2;
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebUiMethodInterface)) && (((WebUiUtils.WebUiMethodInterface)localObject).isActivityResume()) && (!this.jdField_a_of_type_Jih.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_Jih.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_Jih.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_Jih.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      str1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_Jih.b });
      str2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { this.jdField_a_of_type_Jih.b });
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label265;
      }
    }
    label265:
    for (localObject = this.jdField_a_of_type_Jih.jdField_a_of_type_JavaLangString;; localObject = this.jdField_a_of_type_JavaLangString)
    {
      String str3 = String.format(this.jdField_a_of_type_Jih.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364569), new Object[] { this.jdField_a_of_type_Jih.c });
      ShareMsgHelper.a(this.jdField_a_of_type_Jih.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity, 1001, 1, "struct_msg_from_h5", this.jdField_a_of_type_Jih.b, (String)localObject, this.jdField_a_of_type_Jih.c, this.jdField_a_of_type_Jih.d, str3, this.jdField_a_of_type_Jih.e, "web", null, null, null, "plugin", null, str1, str2, "http://url.cn/JS8oE7", this.jdField_a_of_type_Jih.f, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */