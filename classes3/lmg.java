import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.WeakReferenceHandler;

class lmg
  implements Runnable
{
  lmg(lmf paramlmf, Card paramCard)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Lmf.a.a((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet);
    Message localMessage = this.jdField_a_of_type_Lmf.a.b.obtainMessage(13, Boolean.valueOf(bool));
    this.jdField_a_of_type_Lmf.a.b.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */