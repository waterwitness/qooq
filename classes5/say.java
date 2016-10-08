import android.content.ContentValues;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class say
  implements Runnable
{
  public say(FileManagerProxy paramFileManagerProxy, ContentValues paramContentValues, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.a(FileManagerEntity.tableName(), this.jdField_a_of_type_AndroidContentContentValues, "nSessionId=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) }, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\say.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */