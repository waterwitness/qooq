import EncounterSvc.RespEncounterInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class rfs
  extends LBSObserver
{
  public rfs(MsgBoxListActivity paramMsgBoxListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void d(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null) && ((paramArrayOfObject instanceof Object[])) && (MsgBoxListActivity.a(this.a) != null))
    {
      MsgBoxListActivity.a(this.a).a((List)paramArrayOfObject[0], 0, (ArrayList)paramArrayOfObject[1]);
      this.a.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig = MsgBoxListActivity.a(this.a).a();
      this.a.app.getPreferences().edit().putLong("sp_key_dating_config_time", System.currentTimeMillis()).commit();
      this.a.runOnUiThread(new rfv(this));
    }
  }
  
  protected void e(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i;
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if (paramArrayOfObject == null) {
        break label101;
      }
      i = 1;
      if (((i & paramArrayOfObject instanceof Object[]) != 0) && (this.a.d != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper != null) && (((Integer)paramArrayOfObject[1]).intValue() == 1))
      {
        paramArrayOfObject = (List)paramArrayOfObject[0];
        localLinearLayout = (LinearLayout)this.a.d.findViewById(2131302077);
        if (localLinearLayout.getChildCount() != 0) {
          break label107;
        }
        this.a.runOnUiThread(new rft(this, paramArrayOfObject));
      }
    }
    for (;;)
    {
      return;
      label101:
      i = 0;
      break;
      label107:
      if (localLinearLayout.getChildCount() == paramArrayOfObject.size())
      {
        i = 0;
        while (i < localLinearLayout.getChildCount())
        {
          View localView = localLinearLayout.getChildAt(i);
          RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramArrayOfObject.get(i);
          this.a.runOnUiThread(new rfu(this, localView, localRespEncounterInfo));
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */