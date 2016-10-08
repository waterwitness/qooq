import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class pvp
  implements Runnable
{
  pvp(pvo parampvo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ConditionSearchManager.a(this.a.a, false);
    if (this.a.a.b)
    {
      if (this.a.a.a != null)
      {
        Iterator localIterator = this.a.a.a.iterator();
        if (localIterator.hasNext())
        {
          ConditionSearchManager.IConfigListener localIConfigListener = (ConditionSearchManager.IConfigListener)localIterator.next();
          if (ConditionSearchManager.a(this.a.a) != null) {}
          for (boolean bool = true;; bool = false)
          {
            localIConfigListener.a(2, bool);
            break;
          }
        }
      }
      if (this.a.a.c) {
        this.a.a.c();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
    }
    ConditionSearchManager.a(this.a.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */