import android.app.Activity;
import android.app.Dialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.troop.TroopPluginManager;

public class ytl
  extends TroopObserver
{
  public ytl(TroopPluginManager paramTroopPluginManager, String paramString1, QQAppInterface paramQQAppInterface, String paramString2, int paramInt1, String paramString3, String paramString4, Dialog paramDialog, Activity paramActivity, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        String str = (Long)paramObject[0] + "";
        if (this.jdField_a_of_type_JavaLangString.equals(str)) {
          break label59;
        }
      }
    }
    return;
    label59:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
    this.jdField_a_of_type_CooperationTroopTroopPluginManager.a("com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", new ytm(this, (Object[])paramObject));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */