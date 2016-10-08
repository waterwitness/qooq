import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.qphone.base.util.QLog;

public class pvj
  implements Runnable
{
  public pvj(ClubContentUpdateHandler paramClubContentUpdateHandler, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler.a.getManager(152);
      int i = ClubContentJsonTask.a();
      if (i != this.jdField_a_of_type_Int) {
        localApolloManager.a();
      }
      QLog.i("ClubContentUpdateHandler", 1, "handleApolloPanelRelTimeUpdate name: " + this.jdField_a_of_type_JavaLangString + ", ver: " + this.jdField_a_of_type_Int + ", locver: " + i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 1, "handleApolloPanelRealTimeUpdate failed" + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */