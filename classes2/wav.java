import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qidian.controller.QidianBusinessObserver;
import java.util.HashMap;

public class wav
  extends QidianBusinessObserver
{
  public wav(JumpAction paramJumpAction)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void d(boolean paramBoolean, HashMap paramHashMap)
  {
    JumpAction.a(this.a).b(this.a.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    Intent localIntent;
    String str;
    if ((paramBoolean) && (paramHashMap != null))
    {
      localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      str = (String)paramHashMap.get("key_ext_uin");
      paramHashMap = (String)paramHashMap.get("key_sigt");
      if ((paramHashMap != null) && (str != null)) {
        localIntent.putExtra("sigt", HexUtil.a(paramHashMap));
      }
      localIntent.addFlags(67108864);
      if (!((FriendsManager)JumpAction.a(this.a).getManager(50)).b(str)) {
        break label161;
      }
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", ContactUtils.j(JumpAction.a(this.a), str));
    }
    for (;;)
    {
      localIntent.putExtra("uin", str);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      label161:
      localIntent.putExtra("uintype", 1025);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */