import android.util.Pair;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Set;
import mqq.os.MqqHandler;

public class rgk
  implements Runnable
{
  public rgk(StrangerHdHeadUrlFetcher paramStrangerHdHeadUrlFetcher, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (localObject1 != null) {}
    for (boolean bool = ((Boolean)((Pair)localObject1).first).booleanValue();; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_Boolean))
      {
        localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.b = System.currentTimeMillis();
          synchronized (StrangerHdHeadUrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher))
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(StrangerHdHeadUrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher), true);
            }
          }
        }
      }
      else
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_JavaUtilSet)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_JavaUtilSet.add(this.b);
          ((FriendListHandler)localObject1).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (byte)1, (byte)2);
          if (!this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
            this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 60000L);
          }
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
      DatingUtil.a("StrangerHdHeadUrlFetcher", new Object[] { "flh is null" });
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */