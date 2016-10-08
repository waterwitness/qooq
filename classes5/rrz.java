import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rrz
  implements Runnable
{
  rrz(rry paramrry, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QfileFileAssistantActivity.d(this.jdField_a_of_type_Rry.a);
      return;
    }
    QfileFileAssistantActivity.e(this.jdField_a_of_type_Rry.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */