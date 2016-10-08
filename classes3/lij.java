import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lij
  extends EmoticonPackageDownloadListener
{
  public lij(EmosmActivity paramEmosmActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    this.a.runOnUiThread(new lil(this, paramEmoticonPackage, paramInt));
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage == null) || (paramInt1 != 2) || (paramInt2 != 0)) {}
    while (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.a.runOnUiThread(new lik(this, paramEmoticonPackage));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */