import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qgu
  implements Runnable
{
  public qgu(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Job localJob = ThreadExcutor.a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Int >= 8)
    {
      localJob.b = 1;
      ThreadExcutor.a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).a(localJob);
      return;
    }
    localJob.b = 2;
    ThreadExcutor.b(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).a(localJob);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */