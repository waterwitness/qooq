import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceManager;

public class vyg
  extends FriendListObserver
{
  private vyg(FaceManager paramFaceManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    this.a.a(4, paramBoolean, new Object[] { paramString });
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(5, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    this.a.a(30, paramBoolean, new Object[] { paramString });
  }
  
  protected void b(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(6, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
  }
  
  public void c(boolean paramBoolean, String paramString)
  {
    this.a.a(39, paramBoolean, new Object[] { paramString });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */