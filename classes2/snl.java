import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class snl
  extends BaseAdapter
{
  public snl(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.a;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.a.c;
    paramView.setMinimumHeight(paramViewGroup.getMeasuredHeight());
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */