import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class qvl
  extends FriendListObserver
{
  public qvl(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null))
    {
      String str = ContactUtils.c(this.a.app, paramString, false);
      int i = 0;
      while (i < this.a.d.getChildCount())
      {
        Object localObject = this.a.d.getChildAt(i);
        if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof qvv)) && (paramString.equals(((qvv)((View)localObject).getTag()).a)))
        {
          localObject = (TextView)((View)localObject).findViewById(2131300662);
          if (localObject != null) {
            ((TextView)localObject).setText(str);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */