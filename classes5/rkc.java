import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rkc
  extends EmoticonPackageDownloadListener
{
  public rkc(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
      return;
    }
    this.a.post(new rkd(this, paramEmoticonPackage, paramInt));
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onCoverComplete");
    }
    if ((paramEmoticonPackage == null) || (this.a.a == null)) {}
    while ((paramInt2 != 0) || (paramInt1 != 4)) {
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */