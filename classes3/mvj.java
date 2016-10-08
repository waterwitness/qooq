import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mvj
  implements Runnable
{
  public mvj(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = this.a.app.a().createEntityManager();
        if (localObject3 == null) {
          break label168;
        }
        Object localObject1 = ((EntityManager)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.a.k }, null, null, null, null);
        ((EntityManager)localObject3).a();
        if (localObject1 == null) {
          break label165;
        }
        localObject3 = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ((ArrayList)localObject3).add(((TroopMemberInfo)((Iterator)localObject1).next()).memberuin);
          continue;
        }
        localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      }
      finally {}
      localMessage.what = 8;
      localMessage.obj = new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), localObject3 };
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      label165:
      return;
      label168:
      Message localMessage = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */