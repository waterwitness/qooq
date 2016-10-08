import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class uke
  implements Callable
{
  public uke(SearchTask paramSearchTask, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List a()
  {
    Object localObject = SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    ISearchable localISearchable;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localISearchable = (ISearchable)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.isCancelled()) {
          break label127;
        }
      }
      if (!SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask).equals(SearchTask.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localISearchable = (ISearchable)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label127:
        localISearchable.a(SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask));
        if (localISearchable.d() == Long.MIN_VALUE) {
          break;
        }
        int i = localArrayList.indexOf(localISearchable);
        if (-1 == i)
        {
          localArrayList.add(localISearchable);
          break;
        }
        if (((ISearchable)localArrayList.get(i)).d() >= localISearchable.d()) {
          break;
        }
        localArrayList.set(i, localISearchable);
        break;
      }
      long l = localISearchable.d();
      localISearchable.a(SearchTask.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask));
      if (localISearchable.d() == Long.MIN_VALUE) {
        localISearchable.a(l);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */