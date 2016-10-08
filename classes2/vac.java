import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.NetworkUtil;

public class vac
  implements Runnable
{
  public vac(BuddyTransfileProcessor paramBuddyTransfileProcessor, String paramString, short paramShort, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileMsg localFileMsg;
    if ((StreamDataManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e) != 0) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.f))
    {
      localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      BuddyTransfileProcessor localBuddyTransfileProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor;
      long l = System.nanoTime();
      localBuddyTransfileProcessor.d = l;
      localFileMsg.i = l;
      this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.f = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e, this.jdField_a_of_type_Short, BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor), this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.aM, this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.aN);
    this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 2, 0, StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      localFileMsg.f += StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBuddyTransfileProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */