import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.utils.BitmapUtils.OutOfMemHandleCommand;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Subscriber;
import java.lang.ref.WeakReference;
import java.util.List;

public class iqk
  implements Subscriber
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public iqk(QQStoryBaseActivity paramQQStoryBaseActivity1, QQStoryBaseActivity paramQQStoryBaseActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQStoryBaseActivity2);
  }
  
  public void accept(List paramList)
  {
    paramList.add(BitmapUtils.OutOfMemHandleCommand.class);
  }
  
  public void handleDispatch(Dispatcher.Dispatchable paramDispatchable)
  {
    paramDispatchable = (QQStoryBaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramDispatchable != null) {
      paramDispatchable.f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */