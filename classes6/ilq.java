import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ilq
  implements View.OnTouchListener
{
  public ilq(BaseContentPagerView paramBaseContentPagerView, UserInfo paramUserInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.b.setBackgroundDrawable(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.themeColor & Color.argb(230, 255, 255, 255)));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a();
      return false;
      if ((i == 3) || (i == 1)) {
        this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.b.setBackgroundDrawable(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.themeColor));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */