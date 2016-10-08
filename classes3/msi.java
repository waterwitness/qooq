import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity.ViewHolder;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class msi
  implements View.OnClickListener
{
  public msi(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a == null) || (this.a.a.customEntryList == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "mOnCustomItemClickListener: mTroopMemberCard == null || mTroopMemberCard.customEntryList == null");
      }
    }
    int i;
    int j;
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = paramView.getTag();
      } while ((localObject == null) || (!(localObject instanceof TroopMemberCardActivity.ViewHolder)));
      i = ((TroopMemberCardActivity.ViewHolder)paramView.getTag()).a;
      j = this.a.a.customEntryList.size();
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "mOnCustomItemClickListener, index:" + i + " size:" + j);
      }
    } while ((i < 0) || (i >= j));
    paramView = (TroopMemberCard.CustomEntry)this.a.a.customEntryList.get(i);
    this.a.d(paramView.linkUrl);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "mOnCustomItemClickListener, linkUrl:" + paramView.linkUrl + " reportId:" + paramView.reportId);
    }
    this.a.d("Clk_dynamic", paramView.reportId + "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */