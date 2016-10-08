import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rkp
  extends EmoticonPackageDownloadListener
{
  public rkp(EmotionNeedDownloadAdapter paramEmotionNeedDownloadAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    this.a.b(paramEmoticonPackage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    this.a.a(paramEmoticonPackage, paramInt);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.a.a(paramEmoticonPackage);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.a.a(paramEmoticonPackage, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */