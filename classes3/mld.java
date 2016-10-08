import android.os.Bundle;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.adapter.SigCommentSessionListAdapter;
import com.tencent.mobileqq.app.SignatureManager.SigComments;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Collection;
import java.util.List;

public class mld
  extends SignatureObserver
{
  public mld(SigCommentListActivity paramSigCommentListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    List localList;
    if (this.a.isResume())
    {
      this.a.stopTitleProgress();
      if (!paramBoolean) {
        break label175;
      }
      if ((paramObject instanceof Bundle))
      {
        paramObject = (SignatureManager.SigComments)((Bundle)paramObject).getSerializable("data");
        paramBoolean = ((SignatureManager.SigComments)paramObject).isOver;
        paramObject = ((SignatureManager.SigComments)paramObject).mlist;
        localList = this.a.a.a();
        if (((List)paramObject).size() <= 0) {
          break label128;
        }
        if (localList == null) {
          break label113;
        }
        localList.addAll(localList.size(), (Collection)paramObject);
        this.a.a.a(localList, paramBoolean);
        this.a.a.notifyDataSetChanged();
      }
    }
    label113:
    label128:
    label175:
    do
    {
      return;
      this.a.a.a((List)paramObject, paramBoolean);
      break;
      if ((localList != null) && (localList.size() > 0)) {
        this.a.a.a(localList, paramBoolean);
      }
      for (;;)
      {
        this.a.a.notifyDataSetChanged();
        return;
        SigCommentListActivity.a(this.a, 3);
      }
      paramObject = this.a.a.a();
    } while ((paramObject != null) && (((List)paramObject).size() > 0));
    SigCommentListActivity.a(this.a, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */