import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.TaskHttpDownload;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class quw
  implements Runnable
{
  public quw(WordMatchManager paramWordMatchManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a, 1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.e)
        {
          ThreadManager.a(new WordMatchManager.TaskHttpDownload(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager, 3), 8, null, true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.e)
        {
          ThreadManager.a(new WordMatchManager.TaskHttpDownload(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager, 4), 8, null, true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(true);
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\quw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */