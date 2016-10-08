package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SequenceAction
  extends Action
{
  private Action jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Action[] jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionActionAction;
  private int p;
  
  public SequenceAction(Action... paramVarArgs)
  {
    super(0, 0, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionActionAction = paramVarArgs;
    this.jdField_a_of_type_ArrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    int j = 0;
    if (i < paramVarArgs.length)
    {
      if (i == 0) {
        this.jdField_a_of_type_ArrayOfInt[i] = 0;
      }
      for (;;)
      {
        j += paramVarArgs[i].m;
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfInt[i] = j;
      }
    }
    this.m = j;
    if (paramVarArgs.length > 0) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction = paramVarArgs[this.p];
    }
  }
  
  public void a()
  {
    super.a();
    this.p = 0;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionActionAction.length > 0) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionActionAction[this.p];
    }
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    if ((this.p + 1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionActionAction.length) && (paramInt > this.jdField_a_of_type_ArrayOfInt[(this.p + 1)]))
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.b();
      Action[] arrayOfAction = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionActionAction;
      i = this.p + 1;
      this.p = i;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction = arrayOfAction[i];
    }
    this.n = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.n;
    int i = paramInt - this.jdField_a_of_type_ArrayOfInt[this.p];
    float f = i / this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.m;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.o == 1) {
      f = i * i / (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.m * this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.m);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.a(i, f);
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.n & 0x1) != 0)
      {
        this.i = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.i;
        this.j = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.j;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.n & 0x2) != 0) {
        this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.jdField_a_of_type_Float;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.n & 0x4) != 0) {
        this.k = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.k;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.n & 0x8) != 0) {
        this.l = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.l;
      }
      super.a(paramInt, paramFloat);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.o == 2)
      {
        f = i / this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction.m;
        f *= (2.0F - f);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\SequenceAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */