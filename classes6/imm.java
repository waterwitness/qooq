import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.biz.qqstory.view.widget.QQStoryWebView;
import com.tencent.biz.qqstory.view.widget.ResponsiveScrollView.OnEndScrollListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class imm
  implements ResponsiveScrollView.OnEndScrollListener
{
  public imm(PostContentView paramPostContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.a.a != null) && (this.a.getContext() != null))
    {
      paramInt1 = DisplayUtil.b(this.a.getContext(), paramInt1);
      paramInt2 = DisplayUtil.b(this.a.getContext(), paramInt2);
      int i = DisplayUtil.b(this.a.getContext(), (float)DeviceInfoUtil.h());
      int j = DisplayUtil.b(this.a.getContext(), (float)DeviceInfoUtil.i());
      this.a.a.loadUrl("javascript:try{webviewScrollEnd(" + paramInt1 + "," + paramInt2 + "," + i + "," + j + ");}catch(e){}");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */