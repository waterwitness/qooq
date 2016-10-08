import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.NotifyReceiver;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.ReadInJoyPublicAccountObserver;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.storage.ReadInJoyFeedsMsgRecord;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class qnx
  implements Runnable
{
  public qnx(ReadInJoyManager.NotifyReceiver paramNotifyReceiver, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyManager.a, 2, String.format("receive %s", new Object[] { this.jdField_a_of_type_AndroidContentIntent.getAction() }));
    }
    long l1;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidContentIntent.getAction().equalsIgnoreCase("notify_main_feeds_msg_newfeeds_read"))
    {
      if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
        return;
      }
      l1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newfeeds_leba_max_id", 0L);
      localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_read_id", l1);
      ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
      ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
    }
    for (;;)
    {
      localObject1 = new Intent("notify_main_feeds_msg_response");
      BaseApplication.getContext().sendBroadcast((Intent)localObject1);
      return;
      if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_newcomment_read"))
      {
        l1 = this.jdField_a_of_type_AndroidContentIntent.getExtras().getLong("read_id");
        if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
          break;
        }
        long l2 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newcomment_leba_max_id", 0L);
        long l3 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newcomment_leba_read_id", 0L);
        if (l1 >= l3) {
          label231:
          if (l2 <= l1) {
            break label291;
          }
        }
        for (;;)
        {
          localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
          ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_read_id", l1);
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
          ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
          break;
          l1 = l3;
          break label231;
          label291:
          l1 = l2;
        }
      }
      Object localObject2;
      if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_publish_fail"))
      {
        localObject1 = new ReadInJoyFeedsMsgRecord();
        ((ReadInJoyFeedsMsgRecord)localObject1).i = 999999;
        ((ReadInJoyFeedsMsgRecord)localObject1).a = this.jdField_a_of_type_AndroidContentIntent.getExtras().getLong("feed_owner");
        ((ReadInJoyFeedsMsgRecord)localObject1).j = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("fail_reason");
        localObject2 = new ArrayList();
        ((List)localObject2).add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a.a((List)localObject2);
      }
      else
      {
        if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_republish"))
        {
          if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
            break;
          }
          l1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_publishfail_leba_max_id", 0L);
          localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
          ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_read_id", l1);
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
          ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
          continue;
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_new_channel_clear"))
        {
          if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
            break;
          }
          localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
          ((SharedPreferences.Editor)localObject1).putInt("config_new_channel_notify_flag", -1);
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
          ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
          continue;
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_guide_clear"))
        {
          if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
            break;
          }
          localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
          ((SharedPreferences.Editor)localObject1).putInt("config_notify_guide_flag", -1);
          ((SharedPreferences.Editor)localObject1).putLong("config_notify_guide_updated_time", NetConnInfoCenter.getServerTime());
          ((SharedPreferences.Editor)localObject1).putInt("readinjoy_push_channel_article_flag", -1);
          ((SharedPreferences.Editor)localObject1).putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
          ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
          continue;
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_local_channel_flag"))
        {
          ConfigServlet.g(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).a());
        }
        else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_follow_uin"))
        {
          int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_position", -1);
          int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_smooth_dx", 0);
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("follow_uin");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            PublicAccountUtil.a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getApplication().getApplicationContext(), (String)localObject1, new ReadInJoyManager.ReadInJoyPublicAccountObserver(i, j, (String)localObject1));
          }
        }
        else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_update_app_setting"))
        {
          localObject1 = ReadInJoyHelper.a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a));
          if ((localObject1 != null) && (((LebaViewItem)localObject1).jdField_a_of_type_Byte != 0))
          {
            ((LebaViewItem)localObject1).jdField_a_of_type_Byte = 0;
            LebaShowListManager.a().a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, true, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
            localObject2 = (RedTouchHandler)ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).a(31);
            if (localObject2 != null)
            {
              ((RedTouchHandler)localObject2).a(String.valueOf(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), true, NetConnInfoCenter.getServerTimeMillis());
              ((RedTouchHandler)localObject2).a(1, true, null);
            }
          }
        }
        else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("readInJoy_video_play_real_time_report"))
        {
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
          if (localObject1 != null) {
            PublicAccountUtil.b(((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_AID"), ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_VID"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RTYPE"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RCODE"));
          }
        }
        else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_share_friend_video"))
        {
          ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), null, ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).a(), this.jdField_a_of_type_AndroidContentIntent, null);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */