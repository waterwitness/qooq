import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;

public class vez
  implements ExpandableListView.OnGroupClickListener
{
  public vez(NearbyTroopsView paramNearbyTroopsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(this.a.a.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_poi", 0, 0, "", "", "", "");
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */