import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.patch.QZonePatchService;

public class ynm
  implements Runnable
{
  public ynm(QZonePatchService paramQZonePatchService, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QZonePatchService.b("收到补丁包回报");
    QZonePatchService.b("不管成功还是失败，验证补丁包");
    QZonePatchService.a();
    QZonePatchService.b(this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */