import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qut
  implements Runnable
{
  public qut(WordMatchManager paramWordMatchManager, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a.runOnUiThread(new quu(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */