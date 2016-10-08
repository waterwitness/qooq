import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import java.io.File;
import mqq.app.MobileQQ;

public class tey
  implements Runnable
{
  public tey(EmoticonManager paramEmoticonManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileUtils.a(new File(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "recommemd_emotion_file_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()).getAbsolutePath(), this.a.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.toByteArray(), false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */