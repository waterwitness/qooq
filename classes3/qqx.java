import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDesc;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask.Result;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

class qqx
  implements Runnable
{
  qqx(qqw paramqqw, ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, qrr paramqrr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_Int;
    ??? = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_a_of_type_JavaLangString;
    if (i == 0) {
      if (ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.c, this.jdField_a_of_type_Qrr.c) >= 0) {
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateAppByName success, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Qrr.c, this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.c }));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Qrr.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Qrr.jdField_a_of_type_JavaLangString = ((String)???);
      if (i == 0) {
        this.jdField_a_of_type_Qrr.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo;
      }
      synchronized (ArkLocalAppMgr.a(this.jdField_a_of_type_Qqw.a))
      {
        ArkLocalAppMgr.a(this.jdField_a_of_type_Qqw.a).put(this.jdField_a_of_type_Qrr.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Qrr.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo);
        ArkLocalAppMgr.a(this.jdField_a_of_type_Qqw.a, this.jdField_a_of_type_Qrr);
        return;
        i = 6;
        ??? = null;
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateAppByName fail, invalid app version, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Qrr.c, this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.c }));
        continue;
        String str = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_JavaLangString;
        if (??? != null)
        {
          localObject2 = ???;
          ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateAppByName fail, retCode=%d, app-name=%s, msg=%s", new Object[] { Integer.valueOf(i), str, localObject2 }));
          continue;
        }
        Object localObject2 = "unknown";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */