import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;

public class hjm
  implements Runnable
{
  public hjm(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    List localList = localEntityManager.a(SearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.a.a.obtainMessage(1);
    localMessage.obj = localList;
    this.a.a.sendMessage(localMessage);
    localEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */