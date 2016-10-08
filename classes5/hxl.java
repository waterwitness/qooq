import com.tencent.biz.pubaccount.readinjoy.common.ThirdDataSourceAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager.UUIDToUrlCallback;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hxl
  implements ThirdVidoeManager.UUIDToUrlCallback
{
  public hxl(ThirdDataSourceAdapter paramThirdDataSourceAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThirdDataSourceAdapter.a(this.a, 2);
    ThirdDataSourceAdapter.a(this.a, paramString1);
    if (ThirdDataSourceAdapter.a(this.a) != null) {
      ThirdDataSourceAdapter.a(this.a).onPrepared(paramString1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */