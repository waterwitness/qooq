import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lip
  extends SyncListener
{
  public lip(FavEmosmManageActivity paramFavEmosmManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.a.a();
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 28) || (paramInt2 % 28 == 0)) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */