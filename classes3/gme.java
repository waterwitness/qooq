import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;

public class gme
  implements AdapterView.OnItemClickListener
{
  public gme(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "send flower from select");
    }
    VideoController.GAudioFriends localGAudioFriends1 = (VideoController.GAudioFriends)this.a.jdField_a_of_type_Gmr.getItem(paramInt);
    if (localGAudioFriends1 != null)
    {
      paramView = Utils.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte);
      if (paramView != null) {
        break label585;
      }
      paramView = "";
    }
    label103:
    label184:
    label582:
    label585:
    for (;;)
    {
      String str1;
      Object localObject1;
      Object localObject2;
      if (this.a.jdField_a_of_type_ComTencentAvRandomRandomController.a)
      {
        str1 = "1";
        paramAdapterView = NearbyURLSafeUtil.a(this.a.c);
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.b().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label184;
        }
        localObject2 = String.valueOf(((VideoController.GAudioFriends)((Iterator)localObject1).next()).a);
        if (((String)localObject2).equals(this.a.c)) {
          break label582;
        }
        paramAdapterView = paramAdapterView + "," + NearbyURLSafeUtil.a((String)localObject2);
      }
      for (;;)
      {
        break label103;
        str1 = "0";
        break;
        localObject1 = "";
        if (this.a.jdField_a_of_type_ComTencentAvRandomRandomController.a)
        {
          localObject2 = "";
          String str2 = "";
          paramInt = "voice_hall_avatar_".length();
          VideoController.GAudioFriends localGAudioFriends2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c);
          localObject1 = localObject2;
          int i;
          if (localGAudioFriends2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localGAudioFriends2.c))
            {
              localObject1 = localObject2;
              if (!TextUtils.equals(localGAudioFriends2.c, "null"))
              {
                i = localGAudioFriends2.c.lastIndexOf("voice_hall_avatar_");
                localObject1 = localGAudioFriends2.c.substring(i + paramInt);
              }
            }
          }
          localObject2 = str2;
          if (!TextUtils.isEmpty(localGAudioFriends1.c))
          {
            localObject2 = str2;
            if (!TextUtils.equals(localGAudioFriends1.c, "null"))
            {
              i = localGAudioFriends1.c.lastIndexOf("voice_hall_avatar_");
              localObject2 = localGAudioFriends1.c.substring(i + paramInt);
            }
          }
          str2 = SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.g;
          localObject1 = (String)localObject1 + "|" + str2 + "|" + (String)localObject2 + "|" + localGAudioFriends1.b + "|0";
        }
        paramAdapterView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050&uidList=%s&anonyInfo=%s", new Object[] { NearbyURLSafeUtil.a(String.valueOf(localGAudioFriends1.a)), paramView.toLowerCase(), Integer.valueOf(4), "ran.select.s", str1, paramAdapterView, localObject1 });
        if (QLog.isColorLevel()) {
          QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "url = " + paramAdapterView);
        }
        paramView = new Intent(this.a, QQBrowserActivity.class);
        paramView.putExtra("url", paramAdapterView);
        this.a.startActivity(paramView);
        if (this.a.b != null) {
          this.a.b.setVisibility(8);
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */