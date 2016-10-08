import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.FilterData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class iva
{
  public final View a;
  
  private iva(Context paramContext, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = a(paramContext, paramViewGroup);
    if (this.a == null) {
      throw new NullPointerException("onCreateView can not return null");
    }
  }
  
  abstract int a();
  
  protected abstract View a(Context paramContext, ViewGroup paramViewGroup);
  
  abstract void a();
  
  abstract void a(NewStoryFilterViewPagerController.FilterData paramFilterData, int paramInt);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */