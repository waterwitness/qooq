import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyPluginInstallActivity;
import java.lang.ref.WeakReference;

public class ysq
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ysq(ReadInJoyPluginInstallActivity paramReadInJoyPluginInstallActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInJoyPluginInstallActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    ReadInJoyPluginInstallActivity localReadInJoyPluginInstallActivity = (ReadInJoyPluginInstallActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localReadInJoyPluginInstallActivity != null)
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("sleepWait")) {
        break label32;
      }
      ReadInJoyPluginInstallActivity.a(localReadInJoyPluginInstallActivity);
    }
    label32:
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.equals("initPluginManager"))
      {
        ReadInJoyPluginInstallActivity.b(localReadInJoyPluginInstallActivity);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.equals("installPlugin"))
      {
        localReadInJoyPluginInstallActivity.a();
        return;
      }
    } while (!this.jdField_a_of_type_JavaLangString.equals("launchPlugin"));
    ReadInJoyPluginInstallActivity.a(localReadInJoyPluginInstallActivity, localReadInJoyPluginInstallActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */