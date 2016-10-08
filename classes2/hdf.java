import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.BitAppBaseViewCache.BitAppGetViewListener;
import com.tencent.bitapp.BitAppMsg.CreateViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hdf
  extends BitAppMsg.CreateViewListener
{
  public hdf(String paramString, BitAppBaseViewCache.BitAppGetViewListener paramBitAppGetViewListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache$BitAppGetViewListener.a();
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    UiThreadUtil.runOnUiThread(new hdg(this, paramString), 0L);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    UiThreadUtil.runOnUiThread(new hdh(this, paramString, paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */