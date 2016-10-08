import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class nvn
  implements Runnable
{
  nvn(nvl paramnvl, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator1 = this.jdField_a_of_type_Nvl.a.a.iterator();
    label103:
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localIterator2.next();
          if (str.equals(localLocalMediaInfo.jdField_a_of_type_JavaLangString)) {
            localLocalMediaInfo.jdField_a_of_type_Boolean = true;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label103;
        }
        localIterator1.remove();
        break;
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */