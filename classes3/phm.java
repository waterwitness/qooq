import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class phm
  implements AdapterView.OnItemClickListener
{
  public phm(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((ResultRecord)paramView.getTag()).a;
    if (this.a.a(paramAdapterView))
    {
      this.a.a(paramAdapterView);
      this.a.i();
      paramInt = this.a.a.a();
      if ((paramInt == 8) || (paramInt == 9) || (paramInt == 6) || (paramInt == 5) || (paramInt == 7) || (paramInt == 2) || (paramInt == 0) || (paramInt == 10)) {
        ((SelectMemberInnerFrame)this.a.a.getCurrentView()).f();
      }
      this.a.a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\phm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */