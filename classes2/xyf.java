import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import common.qzone.component.cache.common.SoftHashMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class xyf
  extends AbstractSet
{
  public xyf(SoftHashMap paramSoftHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    xyd localxyd;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      localxyd = SoftHashMap.a(this.a, ((Map.Entry)paramObject).getKey());
    } while ((localxyd == null) || (!localxyd.equals(paramObject)));
    return true;
  }
  
  public Iterator iterator()
  {
    return new xye(this.a);
  }
  
  public boolean remove(Object paramObject)
  {
    return SoftHashMap.b(this.a, paramObject) != null;
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
      localArrayList.add(new xyj((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new xyj((Map.Entry)localIterator.next()));
    }
    return localArrayList.toArray(paramArrayOfObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */