import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class wmf
  implements View.OnClickListener
{
  public wmf(GridListView paramGridListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131302453)).intValue();
    this.a.a.a(this.a, paramView, i, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */