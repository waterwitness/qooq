import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoderImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class vxz
  extends DiscussionObserver
{
  private vxz(FaceDecoderImpl paramFaceDecoderImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoderImpl.a(this.a) == null) {
      return;
    }
    String str;
    if (this.a.jdField_a_of_type_Vxx != null)
    {
      if (!DiscussionIconHelper.a(paramString)) {
        break label304;
      }
      str = DiscussionIconHelper.b(paramString);
    }
    for (int i = 1001;; i = 101)
    {
      paramString = this.a.a(i, paramString, 0, (byte)1);
      int j = -1;
      if ((paramBoolean1) && (paramString != null))
      {
        if (i != 1001) {
          break label266;
        }
        if ((this.a.jdField_a_of_type_Vxx instanceof RecentAdapter))
        {
          int k = ((RecentAdapter)this.a.jdField_a_of_type_Vxx).a();
          j = k;
          if (k == 4)
          {
            this.a.jdField_a_of_type_Vxx.a(this.a.c + this.a.jdField_a_of_type_JavaUtilLinkedList.size(), i, str, paramString);
            j = k;
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + str + ",type: " + i + ",style: " + j);
        }
        if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.a.c >= this.a.b)) {
          break;
        }
        this.a.e();
        return;
        label266:
        this.a.jdField_a_of_type_Vxx.a(this.a.c + this.a.jdField_a_of_type_JavaUtilLinkedList.size(), i, str, paramString);
      }
      label304:
      str = paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */