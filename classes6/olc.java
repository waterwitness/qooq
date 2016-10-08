import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;

public class olc
  implements Runnable
{
  public olc(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
        int i = ((NewFriendManager)localObject1).b();
        Object localObject3;
        if (i > 0)
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(5);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set(i + "");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("{'cn':'#FF0000'}");
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d(QZoneLogTags.b + "updateTabContactNotify", 2, "unread=" + i);
            localObject1 = localObject3;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.obtainMessage(3);
          ((Message)localObject3).obj = localObject1;
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.sendMessage((Message)localObject3);
          return;
        }
        if (((NewFriendManager)localObject1).a())
        {
          localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d(QZoneLogTags.b + "updateTabContactNotify", 2, "redpoint");
            localObject1 = localObject3;
          }
        }
        else
        {
          Object localObject2 = null;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\olc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */