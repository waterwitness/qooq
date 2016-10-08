import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class mdk
  implements NewFriendManager.INewFriendListener
{
  public mdk(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.c() == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a().size() > 0))
    {
      Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a().iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData instanceof RecentItemNewFriendMsgData))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "Need to delete RecentItemNewFriendMsgData");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a().remove(localRecentBaseData);
          this.a.c();
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */