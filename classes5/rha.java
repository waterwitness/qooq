import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;

class rha
  implements Runnable
{
  rha(rgz paramrgz, FileMsg paramFileMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Rgz.a.mApp == null)
    {
      QLog.e("FavroamingManager", 1, "app is null");
      return;
    }
    ((FavroamingDBManager)this.jdField_a_of_type_Rgz.a.mApp.getManager(148)).a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */