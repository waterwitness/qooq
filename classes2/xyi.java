import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import common.qzone.component.cache.common.SoftHashMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class xyi
  extends AbstractSet
{
  public xyi(SoftHashMap paramSoftHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public Iterator iterator()
  {
    return new xyh(this.a);
  }
  
  public boolean remove(Object paramObject)
  {
    if (this.a.containsKey(paramObject))
    {
      this.a.remove(paramObject);
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Object[] toArray()
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    return localArrayList.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(localIterator.next());
    }
    return localArrayList.toArray(paramArrayOfObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */