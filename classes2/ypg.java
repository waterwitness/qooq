import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QzoneShareServlet;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

public class ypg
  implements Runnable
{
  public ypg(QZoneShareActivity paramQZoneShareActivity, ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.app.getAccount();
    String str = ((TicketManager)this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.app.getManager(2)).getSkey((String)localObject);
    if (new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).equals(QZoneShareManager.a(this.jdField_a_of_type_JavaUtilArrayList, (String)localObject, str, "1"))) {
      QLog.e("QZoneShare", 1, "imageChangeError!");
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).f);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    localObject = new NewIntent(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, QzoneShareServlet.class);
    ((NewIntent)localObject).putExtra("reason", this.jdField_a_of_type_JavaLangString);
    ((NewIntent)localObject).putExtra("uin", l1);
    ((NewIntent)localObject).putExtra("sharedata", QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity));
    BaseApplicationImpl.a().a().startServlet((NewIntent)localObject);
    QLog.e("QZoneShare", 1, "startShare()");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */