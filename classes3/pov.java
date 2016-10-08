import com.tencent.mobileqq.adapter.MayKnowAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class pov
  extends FriendListObserver
{
  public pov(MayKnowAdapter paramMayKnowAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b();
      MayKnowAdapter.a(this.a, this.a.a.a());
      this.a.notifyDataSetChanged();
      if ((MayKnowAdapter.a(this.a) == null) || (MayKnowAdapter.a(this.a).size() == 0)) {
        MayKnowAdapter.a(this.a).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    MayKnowAdapter.a(this.a).setVisibility(0);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.b();
      MayKnowAdapter.a(this.a, this.a.a.a());
      this.a.notifyDataSetChanged();
      if ((MayKnowAdapter.a(this.a) == null) || (MayKnowAdapter.a(this.a).size() == 0)) {
        MayKnowAdapter.a(this.a).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    MayKnowAdapter.a(this.a).setVisibility(0);
  }
  
  protected void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onStatesChanged ");
    }
    MayKnowAdapter.a(this.a, this.a.a.a());
    this.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */