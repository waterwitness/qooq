import android.os.Handler;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.ArrayList;

public class lhm
  extends TroopObserver
{
  public lhm(EditInfoActivity paramEditInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    EditInfoActivity.a(this.a, false);
    if (paramBoolean) {
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.a.x)) {
          return;
        }
        if ((paramObject != null) && (((TroopMemberCard)paramObject).memberUin == Long.parseLong(this.a.y)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, 2131367912, 500);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new lho(this, (TroopMemberCard)paramObject), 700L);
          return;
        }
      }
      catch (Exception paramObject) {}
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      EditInfoActivity.a(this.a, false);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131367913, 1000);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new lhn(this), 1500L);
      return;
    }
    paramArrayList = (TroopHandler)this.a.app.a(20);
    try
    {
      paramArrayList.a(Long.parseLong(this.a.x), Long.parseLong(this.a.y));
      return;
    }
    catch (Exception paramArrayList)
    {
      EditInfoActivity.a(this.a, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */