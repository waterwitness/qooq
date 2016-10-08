import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class qco
  implements Comparator
{
  public qco(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return b(paramPhoneContact1, paramPhoneContact2);
  }
  
  int b(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int j = 0;
    int k = 1;
    int i;
    if ((paramPhoneContact1.isNewRecommend) || (paramPhoneContact1.highLightTimeStamp != 0L))
    {
      i = 1;
      if ((paramPhoneContact2.isNewRecommend) || (paramPhoneContact2.highLightTimeStamp != 0L)) {
        j = 1;
      }
      if (((i == 0) && (j == 0)) || ((i != 0) && (j != 0))) {
        break label88;
      }
      if (j == 0) {
        break label82;
      }
      i = k;
    }
    label82:
    label88:
    do
    {
      for (;;)
      {
        return i;
        i = 0;
        break;
        i = -1;
      }
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
      j = ((String)localObject1).compareTo((String)localObject2);
      i = j;
    } while (j != 0);
    return paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */