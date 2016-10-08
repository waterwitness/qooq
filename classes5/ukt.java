import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import mqq.os.MqqHandler;

public class ukt
  implements Runnable
{
  public ukt(BaseSearchFragment paramBaseSearchFragment, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.a.a();
    BaseSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment, true);
    ThreadManager.c().post(new uku(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ukt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */