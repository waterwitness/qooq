import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ptt
  extends pyi
{
  public ptt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    super.a();
    if (this.b == GuardManager.s * 50 - 1)
    {
      l = MemoryManager.a(Process.myPid());
      localHashMap = new HashMap();
      localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
      this.a.a("GM_reborn", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "suicide to free memory! suicide_factor=" + GuardManager.s);
      }
    }
    while (((this.b != GuardManager.s * 50) && (this.b != GuardManager.s * 50 + 1)) || (this.a.d != null))
    {
      long l;
      HashMap localHashMap;
      return;
    }
    System.exit(-1);
  }
  
  protected void a(String paramString)
  {
    this.a.a(3, paramString);
  }
  
  protected void b()
  {
    this.a.a(4, "fake_p_msg");
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    this.a.b(false);
    if (!"trick_p_msg".equals(paramString)) {
      this.a.a(false, new String[] { paramString });
    }
    long l = MemoryManager.a(Process.myPid());
    if (pyg.a().a(l) != 2) {
      this.a.f();
    }
    BaseApplicationImpl.a.a().onGuardEvent(2, pyg.a().a, 0L);
    CoreService.b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ptt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */