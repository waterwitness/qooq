import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oih
  extends SosoInterface.OnLocationListener
{
  public oih(SearchContactsFragment paramSearchContactsFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      SearchContactsFragment.a(this.a, paramSosoLbsInfo.a.a);
      SearchContactsFragment.b(this.a, paramSosoLbsInfo.a.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */