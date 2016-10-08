import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashSet;

public class xsk
  implements View.OnClickListener
{
  public xsk(ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((ActionSheet.a(this.a)) && ((ActionSheet.a(this.a) == null) || (!ActionSheet.a(this.a).contains(Integer.valueOf(i)))) && (ActionSheet.b(this.a) != -1) && (i != ActionSheet.b(this.a)))
    {
      Object localObject = (View)ActionSheet.a(this.a).get(ActionSheet.b(this.a));
      ((View)localObject).findViewById(2131296887).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131296886);
      ActionSheet.a(this.a, (TextView)localObject, false);
      localObject = (View)ActionSheet.a(this.a).get(i);
      ((View)localObject).findViewById(2131296887).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131296886);
      ActionSheet.a(this.a, (TextView)localObject, true);
      ActionSheet.a(this.a, i);
    }
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).OnClick(paramView, i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */