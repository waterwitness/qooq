import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoderImpl;

public class vya
  extends FriendListObserver
{
  private vya(FaceDecoderImpl paramFaceDecoderImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, 1, paramString, 0);
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(paramBoolean1, 32, paramString, paramInt);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, 4, paramString, 0);
  }
  
  protected void b(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(paramBoolean1, 16, paramString, paramInt);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, 11, paramString, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */