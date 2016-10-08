import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;

public class oha
  implements Runnable
{
  public oha(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    List localList = localEntityManager.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.a.a.obtainMessage(1);
    localMessage.obj = localList;
    this.a.a.sendMessage(localMessage);
    localEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */