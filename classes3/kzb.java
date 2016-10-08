import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kzb
  implements HotchatSCHelper.OnShowNoteListener
{
  public kzb(ChatSettingForHotChat paramChatSettingForHotChat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(HotchatSCMng.HotchatNote paramHotchatNote)
  {
    HotchatSCMng.HotchatNote localHotchatNote = paramHotchatNote;
    if (paramHotchatNote == null) {
      localHotchatNote = this.a.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a(this.a.a.jdField_a_of_type_JavaLangString, 1, HotchatSCHelper.a());
    }
    if (localHotchatNote != null) {
      this.a.a(localHotchatNote.jdField_a_of_type_JavaLangString, localHotchatNote.b);
    }
    for (;;)
    {
      return false;
      this.a.a(null, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */