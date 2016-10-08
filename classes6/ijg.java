import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ijg
  extends ijl
{
  public ijg(DoodleEmojiManager paramDoodleEmojiManager, DoodleEmojiItem paramDoodleEmojiItem)
  {
    super(paramDoodleEmojiItem);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(DoodleEmojiItem arg1)
  {
    super.onResult(???);
    SLog.b("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem = null;
      DoodleEmojiManager.a(this.a);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */