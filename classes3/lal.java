import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.RspBody;

public class lal
  implements BusinessObserver
{
  public lal(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject1 = paramBundle.getByteArray("data");
    for (;;)
    {
      try
      {
        paramBundle = new troop_member_distribute.RspBody();
        paramBundle.mergeFrom((byte[])localObject1);
        if (paramBundle.uint32_result.get() != 0) {
          break;
        }
        localObject1 = paramBundle.rpt_msg_statistic.get();
        int j = paramBundle.uint32_group_member.get();
        if (j == 0)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.chatopttroop", 2, "mGetTroopMemberDistributeObserver.onReceive: memberCount should not be 0!");
          return;
        }
        View localView = this.a.a[19];
        StringBuffer localStringBuffer = new StringBuffer(this.a.getResources().getString(2131367348));
        if ((localView == null) || (((List)localObject1).size() < 4)) {
          break;
        }
        localStringBuffer.append(",本群共" + j + "人");
        paramBundle = localView.findViewById(2131299660);
        int i = 0;
        if (i < ((List)localObject1).size()) {
          paramInt = Color.parseColor("#ffffff00");
        }
        switch (i)
        {
        case 0: 
          Object localObject2 = (troop_member_distribute.OStatisticInfo)((List)localObject1).get(i);
          Object localObject3 = (RoundProgressBar)paramBundle.findViewById(2131300646);
          ((RoundProgressBar)localObject3).setCircleColor(Color.parseColor("#b2ffffff"));
          ((RoundProgressBar)localObject3).setRoundWidth(2.0F);
          ((RoundProgressBar)localObject3).setTextSize(34.0F);
          ((RoundProgressBar)localObject3).setCircleProgressColor(paramInt);
          paramInt = ((troop_member_distribute.OStatisticInfo)localObject2).uint32_count.get() * 100 / j;
          ((RoundProgressBar)localObject3).setProgress(paramInt);
          localObject3 = (TextView)paramBundle.findViewById(2131297123);
          localObject2 = ((troop_member_distribute.OStatisticInfo)localObject2).bytes_desc.get().toStringUtf8();
          ((TextView)localObject3).setText((CharSequence)localObject2);
          localObject2 = ((String)localObject2).split("-");
          localStringBuffer.append(", 百分之" + paramInt + "为" + localObject2[0]);
          i += 1;
          continue;
          paramBundle = localView.findViewById(2131299660);
          paramInt = Color.parseColor("#ff771bf4");
          break;
        case 1: 
          paramBundle = localView.findViewById(2131299661);
          paramInt = Color.parseColor("#ff0eddb8");
          break;
        case 2: 
          paramBundle = localView.findViewById(2131299662);
          paramInt = Color.parseColor("#ff0d8aff");
          break;
        case 3: 
          paramBundle = localView.findViewById(2131299663);
          paramInt = Color.parseColor("#ffff8400");
          continue;
          localView.setContentDescription(localStringBuffer);
          this.a.a[20].setContentDescription(localStringBuffer);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */