import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnChildClickListener;

public class mpb
  implements ExpandableListView.OnChildClickListener
{
  public mpb(TroopAssisSettingActivity paramTroopAssisSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if (((TroopMessageSettingAdapter)paramExpandableListView.a()).getChildType(paramInt1, paramInt2) == 1) {
      return true;
    }
    StatisticTroopAssist.c(this.a.getActivity(), this.a.app.a());
    paramExpandableListView = (TroopInfo)paramExpandableListView.a().getChild(paramInt1, paramInt2);
    this.a.a(paramExpandableListView);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */