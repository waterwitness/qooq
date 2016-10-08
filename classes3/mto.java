import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.Map;

public class mto
  extends FriendListObserver
{
  public mto(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.v.equals(paramString)))
    {
      Drawable localDrawable = ImageUtil.a();
      paramString = FaceDrawable.a(this.a.app, 1, paramString, 3, localDrawable, localDrawable);
      this.a.a(paramString);
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Map paramMap)
  {
    if ((TextUtils.isEmpty(this.a.v)) || (paramMap == null)) {}
    do
    {
      do
      {
        return;
      } while (!paramMap.containsKey(this.a.v));
      paramArrayOfString = (RichStatus)paramMap.get(this.a.v);
    } while (paramArrayOfString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRichSignStatus = paramArrayOfString;
    this.a.a(this.a.jdField_a_of_type_ArrayOfAndroidViewView[9], paramArrayOfString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */