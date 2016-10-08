import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.dating.SayHelloMsgListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class rgi
  extends NearbyRelevantObserver
{
  public rgi(SayHelloMsgListActivity paramSayHelloMsgListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FansEntity localFansEntity = (FansEntity)localIterator.next();
        RecentBaseData localRecentBaseData = (RecentBaseData)this.a.jdField_a_of_type_JavaUtilMap.get(String.valueOf(localFansEntity.uin));
        if ((localRecentBaseData != null) && ((localRecentBaseData instanceof RecentSayHelloListItem))) {
          ((RecentSayHelloListItem)localRecentBaseData).a(localFansEntity);
        }
      }
    }
    if (this.a.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
    if (QLog.isDevelopLevel()) {
      if (paramList != null) {
        break label156;
      }
    }
    label156:
    for (int i = 0;; i = paramList.size())
    {
      QLog.d("Q.msg_box", 4, "get tags, size is " + i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */