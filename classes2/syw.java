import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class syw
  extends BaseAdapter
{
  private View a;
  
  public syw(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramView;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */