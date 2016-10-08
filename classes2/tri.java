import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.TorchInfo;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;

public class tri
  implements Runnable
{
  public tri(OlympicManager paramOlympicManager, TorchInfo paramTorchInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (OlympicManager.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo);
        localObjectOutputStream.close();
        localByteArrayOutputStream.close();
        FileUtils.a(new File(BaseApplicationImpl.a.getFilesDir(), "olympic_torchinfo_" + this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */