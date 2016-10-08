import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class qul
  implements Runnable
{
  qul(quk paramquk, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      return;
    }
    finally
    {
      this.jdField_a_of_type_Quk.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */