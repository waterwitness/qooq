import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;

public class vab
  extends MessageObserver
{
  public vab(BuddyTransfileProcessor paramBuddyTransfileProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    if ((paramUploadStreamStruct != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramUploadStreamStruct.jdField_a_of_type_JavaLangString + " seq:" + paramUploadStreamStruct.jdField_a_of_type_Short + " Layer:" + paramUploadStreamStruct.jdField_a_of_type_Int + " RespCode:" + paramUploadStreamStruct.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.e + " isStreamPttSuccess:" + this.a.e);
    }
    this.a.c(2);
    if ((paramUploadStreamStruct == null) || (paramUploadStreamStruct.jdField_a_of_type_JavaLangString == null) || (!paramUploadStreamStruct.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.e))) {
      return;
    }
    if (!paramBoolean)
    {
      BuddyTransfileProcessor.a(this.a, false, paramUploadStreamStruct);
      return;
    }
    BuddyTransfileProcessor.a(this.a, true, paramUploadStreamStruct);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */