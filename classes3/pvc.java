import android.os.AsyncTask;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class pvc
  extends AsyncTask
{
  public pvc(CircleManager paramCircleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    EntityTransaction localEntityTransaction = CircleManager.a(this.a).a();
    Object localObject;
    CircleGroup localCircleGroup;
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        localObject = CircleManager.a(this.a).a(CircleGroup.class);
        paramVarArgs = (Void[])localObject;
        if (localObject == null) {
          paramVarArgs = new ArrayList();
        }
        Iterator localIterator = paramVarArgs.iterator();
        if (!localIterator.hasNext()) {
          break label337;
        }
        localCircleGroup = (CircleGroup)localIterator.next();
        localObject = CircleManager.a(this.a).a(CircleBuddy.class, false, "groupId=" + localCircleGroup.groupId, null, null, null, null, null);
        paramVarArgs = (Void[])localObject;
        if (localObject == null) {
          paramVarArgs = new ArrayList();
        }
        localObject = new ArrayList(paramVarArgs.size());
        paramVarArgs = paramVarArgs.iterator();
      }
      catch (Exception paramVarArgs)
      {
        CircleBuddy localCircleBuddy;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CircleManager", 2, "$doInBackground | Exception: " + paramVarArgs.getMessage());
        return Integer.valueOf(0);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CircleManager", 2, "$updateCircle_local | buddy is friend or black");
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      if (!paramVarArgs.hasNext()) {
        break label301;
      }
      localCircleBuddy = (CircleBuddy)paramVarArgs.next();
      if (this.a.a(localCircleBuddy.uin)) {
        continue;
      }
      ((List)localObject).add(localCircleBuddy);
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localCircleBuddy.uin, localCircleBuddy);
    }
    for (;;)
    {
      label301:
      localCircleGroup.buddyCount = ((List)localObject).size();
      localCircleGroup.buddyList = ((List)localObject);
      localHashMap.put(Integer.valueOf(localCircleGroup.groupId), localCircleGroup);
      break;
      label337:
      localEntityTransaction.c();
      this.a.jdField_a_of_type_JavaUtilHashMap = localHashMap;
      localEntityTransaction.b();
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "mUpdateLocalTask on post execute");
    }
    CircleManager.a(this.a, null);
    if (this.a.b != null)
    {
      paramInteger = this.a.b.iterator();
      while (paramInteger.hasNext()) {
        ((IGroupObserver)paramInteger.next()).a(true, 1);
      }
    }
    if (CircleManager.a(this.a) == 0)
    {
      if (this.a.b != null)
      {
        paramInteger = this.a.b.iterator();
        while (paramInteger.hasNext()) {
          ((IGroupObserver)paramInteger.next()).a(true, 2);
        }
      }
    }
    else {
      ThreadManager.a(new pvd(this), 5, null, false);
    }
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "mUpdateLocalTask on cancelled");
    }
    CircleManager.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */