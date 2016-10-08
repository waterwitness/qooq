import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class uqn
{
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public uqn(Observable paramObservable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ArrayList a(Object paramObject)
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject);
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ArrayList localArrayList = (ArrayList)localEntry.getValue();
      int i = 0;
      while (i < localArrayList.size())
      {
        Object localObject = localArrayList.get(i);
        if ((localObject == paramObject) || ((localObject != null) && (localObject.equals(paramObject)))) {
          ((ArrayList)localEntry.getValue()).remove(paramObject);
        } else {
          i += 1;
        }
      }
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject1);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, localArrayList1);
    }
    if (!localArrayList1.contains(paramObject2)) {
      localArrayList1.add(paramObject2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */