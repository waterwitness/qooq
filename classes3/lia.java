import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class lia
  extends EmoticonObserver
{
  public lia(EmosmActivity paramEmosmActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      if (paramBoolean)
      {
        paramObject = (EmoticonResp)paramObject;
        EmosmActivity.a(this.a, ((EmoticonResp)paramObject).delEpId);
        EmosmActivity.b(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f();
      }
    }
    label108:
    do
    {
      do
      {
        return;
        EmosmActivity.a(this.a);
        break;
        if (paramInt != 2) {
          break label108;
        }
        if (QLog.isColorLevel()) {
          QLog.i("EmosmActivity", 2, "emoticon fetch:" + paramBoolean);
        }
      } while (!paramBoolean);
      this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
      return;
    } while (paramInt != 17);
    if (paramBoolean)
    {
      paramObject = ((EmoticonResp)paramObject).ids.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)paramObject).next();
        EmosmActivity.a(this.a, localInteger.intValue());
      }
    }
    EmosmActivity.a(this.a);
    EmosmActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */