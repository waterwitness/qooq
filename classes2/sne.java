import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

public class sne
  extends NearbyObserver
{
  public sne(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MineFragment", 2, "onGetNearbyMyTabCard isSuccess=" + paramBoolean + " mIsPullRefresh=" + this.a.d);
    }
    if ((paramBoolean) && (paramNearbyMyTabCard != null))
    {
      this.a.b = System.currentTimeMillis();
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.arg1 = 0;
      localMessage.obj = paramNearbyMyTabCard;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    if (this.a.d)
    {
      paramNearbyMyTabCard = this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (!paramBoolean) {
        break label150;
      }
    }
    label150:
    for (int i = 0;; i = 1)
    {
      paramNearbyMyTabCard.a(i);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 1000L);
      this.a.d = false;
      return;
    }
  }
  
  public void b(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MineFragment", 2, "onNearbyMyTabDataChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.arg1 = 0;
      localMessage.obj = paramNearbyMyTabCard;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */