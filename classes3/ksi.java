import android.os.AsyncTask;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public final class ksi
  extends AsyncTask
{
  public ksi(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    paramVarArgs = localList;
    if (localList == null) {
      paramVarArgs = new ArrayList();
    }
    if (ChatActivityFacade.a(paramVarArgs, 3, 0, this.jdField_a_of_type_JavaLangString) < 0) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEntityManager, 3, 0, this.jdField_a_of_type_JavaLangString, paramVarArgs);
    }
    localEntityManager.a();
    return null;
  }
  
  protected void a(Void paramVoid) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ksi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */