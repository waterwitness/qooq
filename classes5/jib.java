import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.lang.ref.WeakReference;

class jib
  implements Runnable
{
  jib(jia paramjia, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    WebUiBaseInterface localWebUiBaseInterface = (WebUiBaseInterface)Share.a(this.jdField_a_of_type_Jia.jdField_a_of_type_ComTencentBizWebviewpluginShare).get();
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)) && (((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).isActivityResume()) && (!this.jdField_a_of_type_Jia.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_Jia.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_Jia.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_Jia.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_Jia.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_Jia.jdField_a_of_type_Int, this.jdField_a_of_type_Jia.jdField_a_of_type_ComTencentBizWebviewpluginShare.b, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */