import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;

public class nuf
  implements GestureSelectGridView.OnSelectListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  
  public nuf(AIOImageListScene paramAIOImageListScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = Integer.MIN_VALUE;
    this.jdField_b_of_type_Int = Integer.MAX_VALUE;
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.a(paramInt);
    if (AIORichMediaInfo.class.isInstance(localObject)) {
      return (AIORichMediaInfo)localObject;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jdField_b_of_type_Int > paramInt2)
      {
        this.jdField_b_of_type_Int = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    AIORichMediaInfo localAIORichMediaInfo;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label182;
        }
        localAIORichMediaInfo = a(paramInt1);
        if (localAIORichMediaInfo != null) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.jdField_a_of_type_Int < paramInt2) {
        this.jdField_a_of_type_Int = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    AIOImageListScene localAIOImageListScene = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localAIOImageListScene.a(localAIORichMediaInfo, bool, true);
      break;
    }
    label182:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localAIORichMediaInfo = a(paramInt1);
      if (localAIORichMediaInfo == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(localAIORichMediaInfo, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localAIORichMediaInfo = a(paramInt1);
      if (localAIORichMediaInfo == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(localAIORichMediaInfo, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.t();
    AIOImageListScene.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).q();
  }
  
  public void b(int paramInt)
  {
    boolean bool2 = false;
    if (!AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {}
    AIORichMediaInfo localAIORichMediaInfo;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a() == 2);
      localAIORichMediaInfo = a(paramInt);
    } while (localAIORichMediaInfo == null);
    if (localAIORichMediaInfo.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      AIOImageListScene localAIOImageListScene = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localAIOImageListScene.a(localAIORichMediaInfo, bool1, true))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.t();
        AIOImageListScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).q();
      }
      this.jdField_b_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageListScene", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void g()
  {
    if (!AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectEnd");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = Integer.MIN_VALUE;
    this.jdField_b_of_type_Int = Integer.MAX_VALUE;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */