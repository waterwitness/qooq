import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class oou
  extends BaseAdapter
{
  private oou(ContactListView paramContactListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    if (this.a.b == null) {
      return 0;
    }
    return this.a.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.a();
      paramViewGroup.setOnClickListener(this.a);
    }
    paramView = (PhoneContact)this.a.b.get(paramInt);
    ContactListView.a(this.a, paramViewGroup, paramView);
    if ((this.a.a == 3) && (paramInt < 5))
    {
      paramViewGroup.setTag(2131296652, Integer.valueOf(paramInt));
      paramView = (oox)paramViewGroup.getTag();
      if (paramView != null) {
        paramView.c.setTag(2131296652, Integer.valueOf(paramInt));
      }
    }
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */