import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class msx
  extends TroopObserver
{
  public msx(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerFailed, reqtype:" + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 9)) {
      this.a.a(1, this.a.getString(2131369498));
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerSuccess, reqtype:_eResignGroupReq result:" + paramByte + " troopUin:" + paramString);
      }
      if (paramByte == 0) {
        this.a.a(5, 2131369497, 1000);
      }
    }
    while (paramInt != 9)
    {
      return;
      this.a.a(1, this.a.getString(2131369498));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerSuccess, reqtype:_eDeleteGroupReq result:" + paramByte + " troopUin:" + paramString);
    }
    if (paramByte == 0)
    {
      this.a.a(5, 2131369497, 1000);
      return;
    }
    this.a.a(1, this.a.getString(2131369498));
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      this.a.a(2, this.a.getString(2131367361));
      this.a.a(1);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.a.a(1, this.a.getString(2131367362));
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong)
  {
    if (paramBoolean)
    {
      this.a.a(2, this.a.getString(2131369593));
      this.a.a(2);
    }
    for (;;)
    {
      paramString = this.a.jdField_a_of_type_ArrayOfAndroidViewView[2];
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = this.a.a(this.a.t, this.a.v);
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield = this.a.b(this.a.t, this.a.v);
      this.a.g();
      return;
      if (paramInt == 4) {
        this.a.a(1, this.a.getString(2131369592));
      } else {
        this.a.a(1, this.a.getString(2131369594));
      }
    }
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
        ThreadManager.a(new msy(this), 8, null, true);
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
    label316:
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
          if (this.a.Q == 0)
          {
            if (this.a.K == 5) {
              this.a.d.setVisibility(8);
            }
          }
          else
          {
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
                break label316;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.a.t);
              }
            }
            return;
          }
          this.a.stopTitleProgress();
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */