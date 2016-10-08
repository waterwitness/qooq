import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class jca
  implements Comparator
{
  public jca(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(String paramString1, String paramString2)
  {
    int i = 1;
    if ((paramString1 != null) && (paramString2 != null)) {
      i = ChnToSpell.a(paramString1, 1).compareTo(ChnToSpell.a(paramString2, 1));
    }
    while (paramString1 != null) {
      return i;
    }
    if (paramString2 != null) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */