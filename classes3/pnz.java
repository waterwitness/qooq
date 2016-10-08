import com.tencent.mobileqq.adapter.AllBuddyListAdapter;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class pnz
  implements Comparator
{
  public pnz(AllBuddyListAdapter paramAllBuddyListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a(Entity paramEntity)
  {
    paramEntity = (Friends)paramEntity;
    return ContactUtils.a(paramEntity) + paramEntity.uin;
  }
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    return ContactSorter.a(a(paramEntity1), a(paramEntity2));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */