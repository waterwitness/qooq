import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class vhl
  extends Handler
{
  public vhl(TroopBarPublishActivity paramTroopBarPublishActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x);
    localBundle.putString("from", "qqbuluo");
    localBundle.putString("uin", this.a.app.a());
    localBundle.putString("title", TroopBarUtils.a(this.a.jdField_a_of_type_AndroidWidgetEditText).trim());
    localBundle.putString("content", TroopBarUtils.a(this.a.b).trim());
    int i;
    switch (paramMessage.what)
    {
    default: 
      i = 3;
    case 4: 
    case 3: 
      for (;;)
      {
        TroopBarPublishUtils.a(this.a, 1, i, localBundle);
        return;
        localBundle.putString("clicktype", "music");
        TroopBarUtils.b("pub_page_new", "Clk_music", this.a.v, "", "", "");
        i = 4;
        continue;
        localBundle.putString("clicktype", "video");
        TroopBarUtils.b("pub_page_new", "Clk_video", this.a.v, "", "", "");
        i = 3;
      }
    }
    TroopBarUtils.b("pub_page_new", "Clk_record", this.a.v, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */