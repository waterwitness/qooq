import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDesc;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDownloadInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask.Result;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class qra
  implements qru
{
  public qra(ArkLocalAppMgr paramArkLocalAppMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, Object arg2)
  {
    synchronized (ArkLocalAppMgr.a(this.a))
    {
      ArkLocalAppMgr.a(this.a).remove(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString);
      if ((paramUpdateAppByNameTask.jdField_a_of_type_Int == 1) || (paramUpdateAppByNameTask.jdField_a_of_type_Int == 2))
      {
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("runUpdateLocalAppTask, updateAppByName success, result=%s, app-name=%s, app-version=%s, update-period=%s", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(paramUpdateAppByNameTask.jdField_a_of_type_Int), paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.c, Integer.toString(paramUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_Int) }));
        return;
      }
    }
    ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("runUpdateLocalAppTask, updateAppByName fail, result=%s, app-name=%s", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(paramUpdateAppByNameTask.jdField_a_of_type_Int), paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString }));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */