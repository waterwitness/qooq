import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class vgo
  implements AdapterView.OnItemLongClickListener
{
  vgo(vgl paramvgl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.a.a.a.e) || (this.a.a.a.d)) {
      TroopAvatarWallPreviewActivity.a(this.a.a.a);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */