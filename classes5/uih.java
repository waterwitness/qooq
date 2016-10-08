import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.widget.TabBarView;

public class uih
  implements ViewPager.OnPageChangeListener
{
  public uih(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ((SignatureManager)this.a.app.getManager(57)).g = paramInt;
    this.a.a.setSelectedTab(paramInt, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */