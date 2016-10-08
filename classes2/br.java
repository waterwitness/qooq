import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class br
  extends DataLineObserver
{
  public br(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong)
  {
    this.a.runOnUiThread(new bx(this));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new bw(this));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new bs(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new bv(this));
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new bt(this));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new bu(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */