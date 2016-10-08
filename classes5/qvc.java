import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class qvc
  implements Runnable
{
  qvc(qvb paramqvb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.k = this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
    BusinessCardEditActivity.a(this.a.a, this.a.a.jdField_a_of_type_Boolean, true, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */