import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class izq
  extends DataSetObserver
{
  public izq(EmptySupportViewPager paramEmptySupportViewPager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    PagerAdapter localPagerAdapter = this.a.getAdapter();
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      EmptySupportViewPager.a(this.a, 8);
      this.a.setVisibility(0);
      return;
    }
    EmptySupportViewPager.a(this.a, 0);
    this.a.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */