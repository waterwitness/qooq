import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter.ViewHolder;
import com.tencent.mobileqq.troop.widget.ScaleGallery;

public class veb
  extends FriendListObserver
{
  public veb(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      int j = this.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.a.a.getChildAt(i);
        if ((((View)localObject).getTag() instanceof NearbyMemberAdapter.ViewHolder))
        {
          localObject = (NearbyMemberAdapter.ViewHolder)((View)localObject).getTag();
          if (((NearbyMemberAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString))
          {
            paramString = this.a.app.a(((NearbyMemberAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString, (byte)3, true);
            ((NearbyMemberAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
            return;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\veb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */