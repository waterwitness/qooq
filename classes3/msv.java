import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity.Info;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class msv
  extends TroopObserver
{
  public msv(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List arg4)
  {
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      Object localObject = this.a;
      ((TroopMemberCardActivity)localObject).Q -= 1;
      if (this.a.Q == 0) {
        this.a.stopTitleProgress();
      }
      this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (paramList1 != null)
      {
        paramList1 = paramList1.iterator();
        if (paramList1.hasNext())
        {
          ??? = (ShowExternalTroop)paramList1.next();
          localObject = new TroopMemberCardActivity.Info(this.a);
          ((TroopMemberCardActivity.Info)localObject).jdField_b_of_type_JavaLangString = ???.troopName;
          ((TroopMemberCardActivity.Info)localObject).a = ???.strFaceUrl;
          ((TroopMemberCardActivity.Info)localObject).jdField_b_of_type_Int = 2;
          this.a.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
    }
    this.a.h();
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      paramArrayList = this.a;
      paramArrayList.Q -= 1;
      if (this.a.Q == 0) {
        this.a.d.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCardInfoResult: isSuccess " + paramBoolean1);
      }
      if (paramBoolean1) {
        ThreadManager.a(new msw(this), 8, null, true);
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard:" + paramArrayList.toString());
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    long l;
    int i;
    label290:
    do
    {
      do
      {
        try
        {
          if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
        }
        catch (Exception paramObject)
        {
          TroopMemberCardActivity localTroopMemberCardActivity;
          while (!QLog.isColorLevel()) {}
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard:" + ((Exception)paramObject).toString());
          return;
        }
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          localTroopMemberCardActivity = this.a;
          localTroopMemberCardActivity.Q -= 1;
          if (this.a.Q == 0) {
            this.a.stopTitleProgress();
          }
          ((TroopGagMgr)this.a.app.getManager(47)).a(this.a.t, this.a.v);
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
          }
          if (paramBoolean)
          {
            paramObject = (Object[])paramObject;
            l = ((Long)paramObject[0]).longValue();
            i = ((Integer)paramObject[1]).intValue();
            paramObject = (TroopMemberCard)paramObject[2];
            if (l == Long.parseLong(this.a.t)) {
              break label290;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.a.t);
            }
          }
          return;
        }
        if (paramObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: cardInfo==null");
      return;
      l = ((TroopMemberCard)paramObject).memberUin;
      if (l == Long.parseLong(this.a.v)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + this.a.v);
    return;
    this.a.a(i, (TroopMemberCard)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */