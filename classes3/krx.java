import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import com.tencent.qphone.base.util.QLog;

public final class krx
  implements Runnable
{
  /* Error */
  public krx(MessageForPtt paramMessageForPtt, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 16	krx:jdField_a_of_type_ComTencentMobileqqDataMessageForPtt	Lcom/tencent/mobileqq/data/MessageForPtt;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 18	krx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 20	krx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: aload_0
    //   16: iload 4
    //   18: putfield 22	krx:jdField_a_of_type_Int	I
    //   21: aload_0
    //   22: iload 5
    //   24: putfield 24	krx:jdField_b_of_type_Int	I
    //   27: aload_0
    //   28: invokespecial 27	java/lang/Object:<init>	()V
    //   31: getstatic 33	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   34: istore 6
    //   36: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	krx
    //   0	37	1	paramMessageForPtt	MessageForPtt
    //   0	37	2	paramQQAppInterface	QQAppInterface
    //   0	37	3	paramString	String
    //   0	37	4	paramInt1	int
    //   0	37	5	paramInt2	int
    //   34	1	6	bool	boolean
  }
  
  public void run()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop + " itemType " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.itemType + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop;
    localTransferRequest.jdField_b_of_type_Int = 2;
    localTransferRequest.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq;
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.e = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer;
    localTransferRequest.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getLocalFilePath();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSendFromOtherTerminal()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSend())) {
      bool = true;
    }
    localTransferRequest.jdField_b_of_type_Boolean = bool;
    localTransferRequest.f = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.md5;
    localTransferRequest.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileID;
    localTransferRequest.g = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileKeyStr;
    localTransferRequest.d = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.subVersion;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    localTransferRequest.jdField_a_of_type_JavaLangObject = new TransferRequest.PttDownExtraInfo(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */