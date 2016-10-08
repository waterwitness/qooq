import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qmb
{
  public MessageRecord a;
  public boolean a;
  
  public qmb(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */