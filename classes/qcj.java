import android.text.TextUtils;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class qcj
  implements Comparator
{
  public qcj(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int n = 0;
    Object localObject2 = paramPhoneContact1.pinyinFirst;
    String str = paramPhoneContact2.pinyinFirst;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("#")) {
      localObject1 = "Za";
    }
    localObject2 = str;
    if (str.endsWith("#")) {
      localObject2 = "Za";
    }
    int j = ((String)localObject1).compareTo((String)localObject2);
    int i = j;
    int k;
    label99:
    label112:
    int m;
    if (j == 0)
    {
      if (TextUtils.isEmpty(paramPhoneContact1.uin)) {
        break label181;
      }
      i = 1;
      if ((i == 0) || (paramPhoneContact1.uin.equals("0"))) {
        break label187;
      }
      k = 1;
      if (TextUtils.isEmpty(paramPhoneContact2.uin)) {
        break label193;
      }
      j = 1;
      if ((j == 0) || (paramPhoneContact2.uin.equals("0"))) {
        break label199;
      }
      m = 1;
      label132:
      if (k == 0) {
        break label205;
      }
      i = 0;
    }
    for (;;)
    {
      label140:
      if (m != 0) {
        j = n;
      }
      for (;;)
      {
        i -= j;
        j = i;
        if (i == 0) {
          j = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
        }
        return j;
        label181:
        i = 0;
        break;
        label187:
        k = 0;
        break label99;
        label193:
        j = 0;
        break label112;
        label199:
        m = 0;
        break label132;
        label205:
        if (i == 0) {
          break label233;
        }
        i = 1;
        break label140;
        if (j != 0) {
          j = 1;
        } else {
          j = 2;
        }
      }
      label233:
      i = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */