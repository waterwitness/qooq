import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class pur
  implements Runnable
{
  public pur(CardHandler paramCardHandler, int paramInt, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b.a();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b.getManager(50);
    Card localCard = localFriendsManager.a(str);
    if (localCard != null)
    {
      localCard.iVoteIncrement = this.jdField_a_of_type_Int;
      localFriendsManager.a(localCard);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      CardHandler.a(str, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */