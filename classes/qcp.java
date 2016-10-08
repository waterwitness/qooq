import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class qcp
  implements Comparator
{
  public qcp(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  int a(PhoneContact paramPhoneContact)
  {
    int j = ContactUtils.a(paramPhoneContact.detalStatusFlag, paramPhoneContact.iTermType);
    if ((j != 6) && (j != 0)) {}
    for (int i = 65536;; i = 131072) {
      switch (j)
      {
      case 5: 
      case 6: 
      default: 
        return i | (int)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(paramPhoneContact.unifiedCode);
      }
    }
    return i | 0x1;
    return i | 0x2;
    return i | 0x3;
  }
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int j = 0;
    int k = 1;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      if ((paramPhoneContact1.isNewRecommend) || (paramPhoneContact1.highLightTimeStamp != 0L))
      {
        i = 1;
        if ((paramPhoneContact2.isNewRecommend) || (paramPhoneContact2.highLightTimeStamp != 0L)) {
          j = 1;
        }
        if (((i == 0) && (j == 0)) || ((i != 0) && (j != 0))) {
          break label85;
        }
        if (j == 0) {
          break label83;
        }
        i = k;
      }
    }
    label83:
    label85:
    do
    {
      return i;
      i = 0;
      break;
      return -1;
      if (!this.b) {
        break label108;
      }
      j = c(paramPhoneContact1, paramPhoneContact2);
      i = j;
    } while (j != 0);
    label108:
    return b(paramPhoneContact1, paramPhoneContact2);
  }
  
  int b(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
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
    if (j == 0) {
      i = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
    }
    return i;
  }
  
  int c(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return a(paramPhoneContact1) - a(paramPhoneContact2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */