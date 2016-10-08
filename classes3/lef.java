import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.PortalShower;
import com.tencent.mobileqq.portal.PortalManager.ResultData;

public class lef
  extends PortalManager.PortalShower
{
  private lef(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt, PortalManager.ResultData paramResultData)
  {
    PortalManager.a(this.a.a(), paramResultData);
  }
  
  public void a(long paramLong1, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong1, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, PortalManager.ResultData paramResultData) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    return true;
  }
  
  public void b()
  {
    if ((Conversation.a(this.a) != null) && (Conversation.a(this.a) != null)) {
      Conversation.a(this.a).removeView(Conversation.a(this.a));
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */