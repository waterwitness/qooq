import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

class hje
  implements Runnable
{
  hje(hjd paramhjd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.a.a.app.a().createEntityManager();
    List localList = localEntityManager.a(SearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localEntityManager.b((SearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.a.a.a.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.a.a.a.sendMessage((Message)localObject);
    localEntityManager.a();
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8004D70", "0X8004D70", 0, 0, null, null, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hje.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */