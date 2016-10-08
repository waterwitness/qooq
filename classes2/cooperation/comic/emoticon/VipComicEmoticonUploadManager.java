package cooperation.comic.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionCommPicTryUp;
import yal;

public class VipComicEmoticonUploadManager
  implements Manager
{
  public static final String a = "VipComicEmoticonUploader";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private UpCallBack jdField_a_of_type_ComTencentMobileqqPicUpCallBack;
  private RemoteCommand.OnInvokeFinishLinstener jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private String b;
  
  public VipComicEmoticonUploadManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new yal(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.a();
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.f();
  }
  
  public void a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = paramOnInvokeFinishLinstener;
      paramOnInvokeFinishLinstener = new TransferRequest();
      paramOnInvokeFinishLinstener.jdField_b_of_type_Int = 24;
      paramOnInvokeFinishLinstener.jdField_c_of_type_Int = 20;
      paramOnInvokeFinishLinstener.jdField_a_of_type_JavaLangString = "actQqComicPicUpload";
      paramOnInvokeFinishLinstener.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.jdField_a_of_type_Boolean = true;
      paramOnInvokeFinishLinstener.i = paramBundle.getString("localPath");
      paramOnInvokeFinishLinstener.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack;
      Object localObject = paramBundle.getString("comicId");
      String str1 = paramBundle.getString("picMd5");
      String str2 = paramBundle.getString("actionData");
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("comicId", localObject);
        paramBundle.put("picMd5", str1);
        paramBundle.put("actionData", str2);
        localObject = new cmd0x388.ExtensionCommPicTryUp();
        ((cmd0x388.ExtensionCommPicTryUp)localObject).rpt_bytes_extinfo.add(ByteStringMicro.copyFrom(paramBundle.toString().getBytes()));
        paramOnInvokeFinishLinstener.jdField_a_of_type_ArrayOfByte = ((cmd0x388.ExtensionCommPicTryUp)localObject).toByteArray();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramOnInvokeFinishLinstener);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\emoticon\VipComicEmoticonUploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */