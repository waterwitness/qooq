import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hna
  extends FriendListObserver
{
  public hna(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidViewViewGroup == null) {}
    label134:
    for (;;)
    {
      return;
      int j = this.a.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label134;
        }
        View localView = this.a.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
        if (((localView.getTag() instanceof String)) && ((localView instanceof ImageView)) && (((String)localView.getTag()).equals(paramString)))
        {
          ((ImageView)localView).setImageDrawable(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountDetailActivity.bindTroop", 2, "onUpdateTroopHead:" + paramString);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */