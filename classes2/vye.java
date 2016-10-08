import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawableImpl.DisFaceObserver;
import com.tencent.mobileqq.util.FaceDrawableImpl.FaceObserver;
import com.tencent.mobileqq.util.FaceManager;

public class vye
  implements Runnable
{
  public vye(FaceManager paramFaceManager, Object paramObject, int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.FaceObserver)) {
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    while (!(this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.DisFaceObserver))
    {
      return;
      ((FaceDrawableImpl.FaceObserver)this.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Boolean, (String)this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
      ((FaceDrawableImpl.FaceObserver)this.jdField_a_of_type_JavaLangObject).b(this.jdField_a_of_type_Boolean, (String)this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
      ((FaceDrawableImpl.FaceObserver)this.jdField_a_of_type_JavaLangObject).c(this.jdField_a_of_type_Boolean, (String)this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
      ((FaceDrawableImpl.FaceObserver)this.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Boolean, (String)this.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue(), ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[2]).booleanValue());
      return;
      ((FaceDrawableImpl.FaceObserver)this.jdField_a_of_type_JavaLangObject).b(this.jdField_a_of_type_Boolean, (String)this.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue(), ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[2]).booleanValue());
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    ((FaceDrawableImpl.DisFaceObserver)this.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Boolean, ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[0]).booleanValue(), (String)this.jdField_a_of_type_ArrayOfJavaLangObject[1]);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */