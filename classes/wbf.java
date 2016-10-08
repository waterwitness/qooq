import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class wbf
  extends BaseAdapter
{
  public wbf(QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    if (this.a.items != null) {
      return this.a.items.length;
    }
    return 0;
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
    if (this.a.inflater == null) {
      this.a.inflater = ((LayoutInflater)this.a.getContext().getSystemService("layout_inflater"));
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.inflater.inflate(this.a.getDialogListItemLayout(), null);
      paramView = new wbo(this.a, null);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131297853));
      paramViewGroup.setTag(paramView);
    }
    paramView = (wbo)paramViewGroup.getTag();
    int i;
    int j;
    int k;
    int m;
    if (paramView.a != null)
    {
      paramView.a.setText(this.a.items[paramInt]);
      paramView.a.setOnClickListener(new wbn(this.a, paramInt));
      i = paramView.a.getPaddingTop();
      j = paramView.a.getPaddingLeft();
      k = paramView.a.getPaddingRight();
      m = paramView.a.getPaddingBottom();
      if (this.a.items.length != 1) {
        break label212;
      }
      paramView.a.setBackgroundResource(2130838415);
    }
    for (;;)
    {
      paramView.a.setPadding(j, i, k, m);
      return paramViewGroup;
      label212:
      if (paramInt == 0) {
        paramView.a.setBackgroundResource(2130838416);
      } else if (paramInt == this.a.items.length - 1) {
        paramView.a.setBackgroundResource(2130838414);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */