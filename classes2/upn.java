import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.NewIntent;

public class upn
  implements Runnable
{
  public upn(QZoneManagerImp paramQZoneManagerImp, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.nowtime: " + l + ",QZoneNotifyServlet.lastGetFeedTime: " + QZoneNotifyServlet.c + ",config interval:" + QZoneHelper.a() + "difference: " + (l - QZoneNotifyServlet.c));
    }
    if (l - QZoneNotifyServlet.c > QZoneHelper.a())
    {
      NewIntent localNewIntent = new NewIntent(QZoneManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp).getApplication(), QZoneNotifyServlet.class);
      localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
      localNewIntent.putExtra("qzone_send_by_time", this.jdField_a_of_type_Int);
      localNewIntent.putExtra("scene", 103);
      QZoneManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp).startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\upn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */