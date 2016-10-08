import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class pib
  implements Comparator
{
  public static final int a = -1;
  
  private pib()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(phz paramphz)
  {
    if (paramphz.jdField_a_of_type_Int != -1) {
      return paramphz.jdField_a_of_type_Int;
    }
    Friends localFriends = paramphz.jdField_a_of_type_ComTencentMobileqqDataFriends;
    int k = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
    int j;
    int i;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label129;
      }
      i = 4096;
      switch (k)
      {
      case 5: 
      case 6: 
      default: 
        label61:
        i = j | i | (int)localFriends.getLastLoginType();
      }
    }
    for (;;)
    {
      paramphz.jdField_a_of_type_Int = i;
      return i;
      j = 131072;
      break;
      label129:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        i = 8192;
        break label61;
      }
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ))
      {
        i = 12288;
        break label61;
      }
      i = 16384;
      break label61;
      i = j | i | 0x1;
      continue;
      i = j | i | 0x2;
      continue;
      i = j | i | 0x3;
    }
  }
  
  public int a(phz paramphz1, phz paramphz2)
  {
    return a(paramphz1) - a(paramphz2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */