import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class old
  implements Runnable
{
  public old(MainAssistObserver paramMainAssistObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {}
    Object localObject3;
    int i;
    do
    {
      return;
      localObject3 = (TroopRedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(69);
      Object localObject1 = ((TroopRedTouchManager)localObject3).a();
      i = -1;
      if (localObject1 != null) {
        i = ((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get();
      }
      try
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().a) || (i != 11)) {
          break;
        }
        localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(4);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set(((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.get().toStringUtf8());
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("{'cn':'#FF0000', 'av':1}");
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.redPointMainAssistObserver", 2, "story文字、图片红点,storyAppid:" + i);
          localObject1 = localObject3;
        }
        localObject3 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject3).obj = localObject1;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("MainAssistObserver", 2, "Exception was thrown when update red point.", localException);
    return;
    int m = ((TroopRedTouchManager)localObject3).a();
    int n = ((TroopRedTouchManager)localObject3).b();
    int i1 = ((NumRedPointManager)this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(63)).a(0);
    if (QLog.isColorLevel()) {
      QLog.i("MainAssistObserver", 2, "troop red point-->redPointNums=" + m + ", redNumPointNums=" + n + ", numRedNums=" + i1);
    }
    Object localObject2 = ((LocalRedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(159)).a(100510);
    label348:
    boolean bool1;
    label362:
    int j;
    label452:
    int i2;
    int k;
    if ((localObject2 != null) && (((RedTouchItem)localObject2).unReadFlag) && (((RedTouchItem)localObject2).redtouchType == 2))
    {
      i = ((RedTouchItem)localObject2).count;
      if ((localObject2 != null) && (((RedTouchItem)localObject2).unReadFlag))
      {
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.i("MainAssistObserver", 2, "nearby red point-->nearbyNum=" + i + ", nearbyHasRedPoint=" + bool1);
        }
        localObject3 = ((RedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(35)).a();
        if ((localObject3 != null) && (((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.get() == 5))
        {
          j = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.get());
          if (QLog.isColorLevel()) {
            QLog.i("MainAssistObserver", 2, "business red point-->numRedTouch=" + j);
          }
          i2 = this.a.a();
          if (QLog.isColorLevel()) {
            QLog.i("MainAssistObserver", 2, "QZone red point-->qzonMsgCount=" + i2);
          }
          localObject2 = MainAssistObserver.a(this.a);
          if (localObject2 == null) {
            break label952;
          }
          k = ((ReadInJoyNotifyRedTouchInfo)localObject2).a();
          label543:
          if ((localObject2 == null) || (!((ReadInJoyNotifyRedTouchInfo)localObject2).a())) {
            break label958;
          }
        }
      }
    }
    label952:
    label958:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool4 = false;
      boolean bool3 = bool4;
      if (!TextUtils.isEmpty(PublicAccountHandler.c))
      {
        bool3 = bool4;
        if (PublicAccountConfigUtil.f)
        {
          bool3 = bool4;
          if (PublicAccountConfigUtil.g) {
            bool3 = true;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("readInJoy red point-->readInJoyNotifyCount=").append(k).append(", isReadinjoyNotifyNeedsDisplay=").append(bool2).append(", isShowPublicPortal=").append(bool3);
        QLog.i("MainAssistObserver", 2, ((StringBuilder)localObject2).toString());
      }
      i = k + (j + i2 + n + i1) + i;
      if (i > 0)
      {
        localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(5);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set(i + "");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("{'cn':'#FF0000'}");
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MainAssistObserver", 2, "updateTabLebaNotify totalCount = " + i);
        localObject2 = localObject3;
        break;
      }
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MainAssistObserver", 2, "updateTabLebaNotify redTypeInfo != null.");
        localObject2 = localObject3;
        break;
      }
      if ((m > 0) || (MainAssistObserver.a(this.a)) || (bool2) || (bool1) || (bool3))
      {
        localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MainAssistObserver", 2, "updateTabLebaNotify hasReddot; redpointMums = " + m + ",isReadinjoyNotifyNeedsDisplay" + bool2 + ",nearbyHasRedPoint = " + bool1 + ",isShowPublicPortal = " + bool3);
        localObject2 = localObject3;
        break;
      }
      localObject2 = null;
      break;
      j = 0;
      break label452;
      bool1 = false;
      break label362;
      i = 0;
      break label348;
      k = 0;
      break label543;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\old.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */