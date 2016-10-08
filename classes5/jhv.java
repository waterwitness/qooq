import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.WebView;

public class jhv
  implements Runnable
{
  public jhv(QzonePlugin paramQzonePlugin, byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin) != null) {
      QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin).postUrl(QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin), this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */