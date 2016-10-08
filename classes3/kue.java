import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.av.utils.GVideoUpdateUtil.OnGVideoUpdateListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.groupvideo.GroupVideoHelper;
import java.util.Map;
import mqq.os.MqqHandler;

public final class kue
  implements GVideoUpdateUtil.OnGVideoUpdateListener
{
  public kue(int paramInt1, int paramInt2, QCallFacade paramQCallFacade, long paramLong1, Intent paramIntent, QQAppInterface paramQQAppInterface, long paramLong2, Map paramMap, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Context paramContext, String paramString)
  {
    String str = null;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 3000)) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(1, this.jdField_a_of_type_Long, "", "");
    }
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("MultiAVType", 0);
    if (i != 2) {
      str = this.jdField_a_of_type_AndroidContentIntent.getComponent().getClassName();
    }
    for (paramString = paramContext.getClass().getName();; paramString = null)
    {
      if (i == 2) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, this.jdField_b_of_type_Long))
        {
          paramContext = new Intent("tencent.video.q2v.back2VideoRoom");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramContext);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Int == 0) {
          ThreadManager.a().post(new kuf(this));
        }
        return;
        this.jdField_a_of_type_AndroidContentIntent.putExtra("enterType", (String)this.jdField_a_of_type_JavaUtilMap.get("enterType"));
        GroupVideoHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_AndroidContentIntent, 1);
        continue;
        if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.av.ui.AVActivity")) && (((!TextUtils.isEmpty(str)) && (paramString.equals("com.tencent.mobileqq.qcall.QCallDetailActivity"))) || (paramString.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity")) || (paramString.equals("com.tencent.mobileqq.activity.SplashActivity")) || (paramString.equals("com.tencent.mobileqq.activity.recent.RecentT9SearchActivity"))))
        {
          paramString = new Intent(paramContext, AVLoadingDialogActivity.class);
          paramString.putExtra("avactivity_intent", this.jdField_a_of_type_AndroidContentIntent);
          paramString.addFlags(268435456);
          paramContext.startActivity(paramString);
        }
        else
        {
          paramContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */